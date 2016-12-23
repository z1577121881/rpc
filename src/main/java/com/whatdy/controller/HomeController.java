package com.whatdy.controller;

import com.whatdy.autowire.User;
import com.whatdy.service.UserService;
import com.whatdy.utils.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;

/**
 * todo http://www.cnblogs.com/xiepeixing/p/4243288.html
 * Controller 控制器层
 */
@Controller
public class HomeController {

    private static  final String SUCCESS = "success";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private User user;
    @Autowired
    private UserService userService;

    /**
     * index page
     * @return index .jsp
     */
    @RequestMapping(value = "/")
    public String index(){
        return  "index";
    }

    /**
     * login page
     * @return login.jsp
     */
    @RequestMapping(value = "/login")
    public String login(){

        return "login";
    }

    /**
     * test page
     * @return test.jsp
     */
    @RequestMapping(value = "test")
    public String test(){
        return "test";
    }

    /**
     * api test
     * @param id test id
     * @return redirect page
     */
    @RequestMapping(value = "/api/{id}")
    public ModelAndView test(@RequestParam(required = false,value = "name")String name
            , @PathVariable("id")Integer id)
    {
        if (user!=null) {
            System.out.println("the request is not null");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("id",id);
        modelAndView.addObject("user",user);
        modelAndView.addObject("name",name);
        return modelAndView;
    }
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert(){
        com.whatdy.model.User user = new com.whatdy.model.User();
        user.setUsername("1577121881@qq.com");
        user.setPassword(Digest.encodeAes("123456"));
        System.out.println(userService.insertUser(user));
        return  SUCCESS;
    }


}
