package com.xtkj.service;

import com.github.pagehelper.PageInfo;
import com.xtkj.pojo.UserInfo;
import com.xtkj.tools.JsonResult;

public interface IUserInfoService {
    JsonResult<PageInfo<UserInfo>> getUsers(Integer offset,Integer limit);

    void addUser(UserInfo user);

    void updUser(UserInfo user);

    void delUser(Integer id);

}
