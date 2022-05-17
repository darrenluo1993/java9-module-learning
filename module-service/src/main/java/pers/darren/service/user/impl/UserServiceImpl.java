package pers.darren.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.darren.dao.user.UserMapper;
import pers.darren.dao.user.model.User;
import pers.darren.service.user.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String id) {
        return this.userMapper.getUserById(id);
    }
}
