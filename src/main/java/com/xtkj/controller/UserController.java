package com.xtkj.controller;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.UserInfo;
import com.xtkj.service.IUserInfoService;
import com.xtkj.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;


    @RequestMapping("/main")
    public @ResponseBody JsonResult<PageInfo<UserInfo>> main(@RequestParam(value = "pageNumber") Integer offset,@RequestParam(value = "pageSize") Integer limit){
        JsonResult<PageInfo<UserInfo>> users = userInfoService.getUsers(offset, limit);
        return users;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public void addUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        userInfoService.addUser(new UserInfo(id,userId,userPwd));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @RequestMapping("/updUser")
    @ResponseBody
    public void updUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
        userInfoService.updUser(new UserInfo(id,userId,userPwd));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public void delUser(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userInfoService.delUser(id);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

}
