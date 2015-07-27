package com.winit.label.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winit.label.model.DeliveryWay;
import com.winit.label.service.DeliveryWayService;
import com.winit.label.service.LabelService;

@Controller
@RequestMapping(value = "/deliveryWay")
public class DeliveryWaryController extends BaseController {

    @Autowired
    private LabelService          labelService;
    @Autowired
    private DeliveryWayService    deliveryWayService;

	/**
	 * 日志
	 */
	protected static final Logger logger = Logger.getLogger(DeliveryWaryController.class);


    @RequestMapping("getAllDeliveryWay")
	@ResponseBody
	public Object consignment(HttpServletRequest request) {
        List<DeliveryWay> list = deliveryWayService.getAllDeliveryWay();
        return list;
	}

}