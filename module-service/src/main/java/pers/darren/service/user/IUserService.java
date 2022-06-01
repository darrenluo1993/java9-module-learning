package pers.darren.service.user;

import pers.darren.dao.user.model.User;

import java.util.List;

public interface IUserService {

    User getUserById(String id);

    List<User> listAllUser();

    void addUser(User user);
}
