package com.imooc.springmvc.controller;

import com.imooc.springmvc.entity.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("/um")
public class TestController {
    @GetMapping("/t")
    @ResponseBody//直接向相应输出字符串数据，不跳转页面
    public String test(){
        return "<h2>success</h2>";
    }

    @GetMapping("/hi")
    @ResponseBody
    public String test1(String name){
        System.out.println(name);
        return "Hi,"+name;
    }

    @PostMapping("/submit")
    @ResponseBody
    public String test1(String name, String mobile, @DateTimeFormat(pattern = "yyyy-MM-dd") Date createTime){
        System.out.println(name+mobile+createTime);
        return "名字:"+name;
    }
    @GetMapping("/view")
    public ModelAndView showView(Integer userId){
        //ModelAndView mav=new ModelAndView("/view.jsp");
        ModelAndView mav=new ModelAndView();
        //在/um找view.jsp
        mav.setViewName("view.jsp");
        User user= new User();
        if(userId == 1){
            user.setUsername("lily");
        }else if(userId==2){
            user.setUsername("smith");
        }else if(userId == 3){
            user.setUsername("lina");
        }
        mav.addObject("u",user);
        return mav;
    }
    @GetMapping("/view1")
    /**
     *     @ResponseBody
     *     加了这个注解，相应会直接返回view字符串
     *     不加该注解，返回的是数据渲染的视图
     */
    public String showView1(Integer userId, ModelMap modelMap){
        String view="/um/view.sjp";
        User user= new User();
        if(userId == 1){
            user.setUsername("lily");
        }else if(userId==2){
            user.setUsername("smith");
        }else if(userId == 3){
            user.setUsername("lina");
        }
        modelMap.addAttribute("u",user);
        return view;
    }
}
