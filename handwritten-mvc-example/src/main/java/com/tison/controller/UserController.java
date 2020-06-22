package com.tison.controller;

import com.tison.domain.User;
import com.tison.framework.annotation.Autowired;
import com.tison.framework.annotation.Controller;
import com.tison.framework.annotation.RequestMapping;
import com.tison.framework.annotation.RequestMethod;
import com.tison.framework.bean.Data;
import com.tison.framework.bean.Param;
import com.tison.framework.bean.View;
import com.tison.service.IUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author litianxiang
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     *
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public View getUserList() {
        List<User> userList = userService.getAllUser();
        return new View("index.jsp").addModel("userList", userList);
    }

    /**
     * 用户详情
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Data getUserInfo(Param param) {
        String id = (String) param.getParamMap().get("id");
        User user = userService.GetUserInfoById(Integer.parseInt(id));

        return new Data(user);
    }

    @RequestMapping(value = "/userEdit", method = RequestMethod.GET)
    public Data editUser(Param param) {
        String id = (String) param.getParamMap().get("id");
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("age", 911);
        userService.updateUser(Integer.parseInt(id), fieldMap);

        return new Data("Success.");
    }

}
