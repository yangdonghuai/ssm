package com.xtkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xtkj.dao.UserInfoMapper;
import com.xtkj.pojo.UserInfo;
import com.xtkj.service.IUserInfoService;
import com.xtkj.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public JsonResult<PageInfo<UserInfo>> getUsers(Integer offset,Integer limit) {
        int ost = (offset - 1) * limit;
        PageHelper.offsetPage(ost,limit);
        List<UserInfo> users = userInfoMapper.getUsers();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(users);
        JsonResult<PageInfo<UserInfo>> jsonResult = new JsonResult<>();
        jsonResult.setMsg("OK");
        jsonResult.setObj(pageInfo);
        jsonResult.setStateCode(200);
        return jsonResult;
    }

    @Override
    public void addUser(UserInfo user) {
        userInfoMapper.insert(user);
    }

    @Override
    public void updUser(UserInfo user) {
        userInfoMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delUser(Integer id) {
        userInfoMapper.deleteByPrimaryKey(id);
    }
}
