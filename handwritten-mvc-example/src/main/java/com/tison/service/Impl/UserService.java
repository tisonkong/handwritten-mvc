package com.tison.service.Impl;

import com.tison.domain.User;
import com.tison.framework.annotation.Service;
import com.tison.framework.annotation.Transactional;
import com.tison.framework.helper.DatabaseHelper;
import com.tison.service.IUserService;

import java.util.List;
import java.util.Map;

/**
 * @author litianxiang
 */
@Service
public class UserService implements IUserService {
    /**
     * 获取所有用户
     */
    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM user";
        return DatabaseHelper.queryEntityList(User.class, sql);
    }

    /**
     * 根据id获取用户信息
     */
    @Override
    public User GetUserInfoById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return DatabaseHelper.queryEntity(User.class, sql, id);
    }

    /**
     * 修改用户信息
     */
    @Override
    @Transactional
    public boolean updateUser(int id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(User.class, id, fieldMap);
    }
}
