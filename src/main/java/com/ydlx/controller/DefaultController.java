package com.ydlx.controller;

import com.ydlx.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ydlx on 2017/8/12.
 */
@Controller
public class DefaultController {
    private static final String userId="1";
    private static final String fullName="admin";
    private static final String loginAccount="admin";
    private static final String sysId ="1";

    @Autowired
    private SysService sysService;

    @GetMapping(value="/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/index");
        //0. 当前登录用户具备权限管理系统的登录权限
        //1. 查询当前用户所具备管理权限的系统列表，用下拉框展示
        //2. 用户选择指定系统之后，查询用户在当前系统中所具备的管理权限，跳转管理页面
        //3. 根据用户在当前系统的权限生成菜单系统
        //4. 控制当前用户所在页面元素的权限，该显示的显示，该隐藏的隐藏

        mav.addObject("sysId","1");
        return mav;
    }


    @GetMapping(value="/user/index")
    public ModelAndView userIndex(){
        ModelAndView mav = new ModelAndView("/user/index");
        mav.addObject("sysId","1");
        mav.addObject("sysName","权限管理系统(PMS)");
        return mav;
    }

    @GetMapping(value="/sys/index")
    public ModelAndView sysIndex(){
        ModelAndView mav = new ModelAndView("/sys/index");
        mav.addObject("sysId","1");
        mav.addObject("sysName","权限管理系统(PMS)");
        return mav;
    }

    @GetMapping(value="/pri/index")
    public ModelAndView priIndex(){
        ModelAndView mav = new ModelAndView("/pri/index");
        mav.addObject("sysId","1");
        mav.addObject("sysName","权限管理系统(PMS)");
        return mav;
    }

}
