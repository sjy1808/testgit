package com.jt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysLog;
import com.jt.sys.service.SysLogService;

@Controller
@RequestMapping("/log/")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping("doLogListUI")
	public String doLogListUI(){
		return "sys/log_list";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
		/*Thread thread = new Thread();
		try {
			thread.sleep(1000);;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		PageObject<SysLog> pageObject = sysLogService.findPageObjects(username, pageCurrent);
		JsonResult js = new JsonResult(pageObject);
		return js;
	}
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer[] ids){
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
}
