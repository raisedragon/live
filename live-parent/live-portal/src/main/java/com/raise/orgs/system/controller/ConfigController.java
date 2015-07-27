package com.raise.orgs.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.gdcc.core.controller.BaseController;
import com.journaldev.spring.controller.EmpRestURIConstants;
import com.raise.core.HttpResponse;

@Controller
@RequestMapping("orgs/config")
public class ConfigController extends BaseController{
	
	
	
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = getDefaultModelAndView(request);
		return mv;
	}
	
	@RequestMapping(value = "listData")
	public  @ResponseBody HttpResponse listData(HttpServletRequest request,HttpServletResponse response){
		HttpResponse resp = new HttpResponse();
		resp.setStatus(0);
		Map<String,Object> data = new HashMap<String, Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0 ;i<20;i++){
			Map<String,Object> item = new HashMap<String, Object>();
			item.put("id", "id "+i);
			item.put("name", "name "+i);
			item.put("value", "value "+i);
			item.put("description", "description "+i);
			item.put("created", "created "+i);
			item.put("createdBy", "createdBy "+i);
			item.put("updated", "updated "+i);
			item.put("updatedBy", "updatedBy "+i);
			list.add(item);
		}
		data.put("list", list);
		resp.setData(data);
		return resp;
	}
	
	@RequestMapping("edit")
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,@RequestParam(required=false) String id){
		ModelAndView mv = getDefaultModelAndView(request);
		System.out.println(id);
		return mv;
	}
	
	
}
