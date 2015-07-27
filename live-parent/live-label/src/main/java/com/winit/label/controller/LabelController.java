package com.winit.label.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.winit.commons.http.DataTableResult;
import com.winit.label.manager.impl.LabelHandlerInvoker;
import com.winit.label.model.DeliveryWay;
import com.winit.label.model.RequestMessage;
import com.winit.label.model.ResponseMessage;
import com.winit.label.service.DeliveryWayService;
import com.winit.label.service.LabelService;
import com.winit.label.shippment.entity.LabelEntity;

@Controller
@RequestMapping(value = "/label")
public class LabelController extends BaseController {
	private static final String GET_LABEL = "getLabel";

    @Autowired
    private LabelService          labelService;
    @Autowired
    private DeliveryWayService    deliveryWayService;

	/**
	 * 日志
	 */
	protected static final Logger logger = Logger.getLogger(LabelController.class);

	@Autowired
	private LabelHandlerInvoker labelHandlerInvoker;

	@RequestMapping(value = "/consignment")
	public ModelAndView consignment(HttpServletRequest request) {
        List<DeliveryWay> list = deliveryWayService.getAllDeliveryWay();
		ModelAndView mv = getDefaultModelAndView(request);
        mv.addObject("deliveryWays", list);
		return mv;
	}

	/**
	 * 
	 * <p>
	 * 获取面单
	 * </p>
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/getLabel", method = RequestMethod.POST)
	@ResponseBody
	public Object getLabel(HttpServletRequest request) {
		ResponseMessage responseMessage = new ResponseMessage();

		String requestStr;
		try {
			requestStr = IOUtils.toString(request.getInputStream(), "UTF-8");

			logger.info("Get Lable request: " + requestStr);

			if (StringUtils.isEmpty(requestStr)) {
				responseMessage.setMessage("paraments is null");
				responseMessage.setStatusCode(100);
			} else {
				RequestMessage requestMessage = com.alibaba.fastjson.JSONObject.parseObject(requestStr, RequestMessage.class);

				responseMessage = labelHandlerInvoker.invoke(requestMessage);
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatusCode(100);
		}

		String responseStr = JSONObject.fromObject(responseMessage).toString();
		logger.info("Get Label response: " + responseStr);
		return responseMessage;
	}

	@RequestMapping(value = "/getLabel2", method = RequestMethod.POST)
	@ResponseBody
	public Object getLabel2(HttpServletRequest request) {
		ResponseMessage responseMessage = new ResponseMessage();

		String requestStr = request.getParameter("data");
		try {

			logger.info("Get Lable request: " + requestStr);

			if (StringUtils.isEmpty(requestStr)) {
				responseMessage.setMessage("paraments is null");
				responseMessage.setStatusCode(100);
			} else {
				RequestMessage requestMessage = com.alibaba.fastjson.JSONObject.parseObject(requestStr, RequestMessage.class);

				responseMessage = labelHandlerInvoker.invoke(requestMessage);
			}
		} catch (Exception e) {
			logger.error(ExceptionUtils.getFullStackTrace(e));
			responseMessage.setMessage(e.getMessage());
			responseMessage.setStatusCode(100);
		}

		String responseStr = JSONObject.fromObject(responseMessage).toString();
		logger.info("Get Label response: " + responseStr);
		return responseMessage;
	}

    @RequestMapping(value = "list")
    public ModelAndView list(HttpServletRequest request) {
        ModelAndView mv = getDefaultModelAndView(request);
        return mv;
    }

    @RequestMapping(value = "getAllLabel")
    @ResponseBody
    public Object getAllLabel(HttpServletRequest request) {
        List<LabelEntity> labels = labelService.getAllLabel(false);
        DataTableResult result = new DataTableResult();
        result.setAoData(labels);
        return result;
    }

    @RequestMapping("viewLabel")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws IOException {
        String id = request.getParameter("id");

        LabelEntity label = labelService.getById(Long.valueOf(id));
        byte[] bytes = Base64.decodeBase64(label.getFileCode());

        DeliveryWay deliveryWay = deliveryWayService.getById(label.getDeliveryWayId());
        String extension = deliveryWay.getExtension();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", System.currentTimeMillis() + "." + extension);
        return new ResponseEntity<byte[]>(bytes,
            headers,
            HttpStatus.CREATED);
    }

}
