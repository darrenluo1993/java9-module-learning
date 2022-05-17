package pers.darren.service.user;

import pers.darren.dao.user.model.User;

public interface IUserService {
    User getUserById(String id);
}
