package com.jt.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.common.vo.SysResult;
import com.jt.sso.pojo.User;
import com.jt.sso.service.UserService;

@RestController("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	 /**
     * 检测数据是否可用
     * 
     * @param param 用户输入的参数
     * @param type type为类型，可选参数1、2、3分别代表username、phone、email
     * @return
     */
    @RequestMapping(value = "/check/{param}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public SysResult check(@PathVariable("param") String param, @PathVariable("type") Integer type) {
        return userService.check(param, type);
    }

    /**
     * 用户注册
     * 
     * @param user
     * @param result
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public SysResult register(User user) {
        boolean boo = userService.register(user);
        if (boo) {
            return SysResult.ok();
        }
        return SysResult.build(201, "注册失败!");
    }

    /**
     * 登录
     * 
     * @param userName
     * @param passwd
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public SysResult login(@RequestParam("u") String userName, @RequestParam("p") String passwd) {
        // 返回
        String ticket = userService.login(userName, passwd);
        if (ticket == null) {
            return SysResult.build(201, "用户名、密码错误, 登录失败！");
        }
        return SysResult.ok(ticket);
    }

    /**
     * ticket查询
     * 
     * @param ticket
     * @return
     */
    @RequestMapping(value = "/query/{ticket}", method = RequestMethod.GET)
    @ResponseBody
    public SysResult ticket(@PathVariable("ticket") String ticket) {
        // 返回
        String userJson = null;
        try {
            userJson = userService.queryUserByTicket(ticket);
            if (userJson == null) {
                return SysResult.build(201, "查询失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return SysResult.build(201, "查询失败！");
        }
        return SysResult.ok(userJson);
    }

}
