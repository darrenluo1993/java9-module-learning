package pers.darren.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pers.darren.common.core.controller.BaseController;
import pers.darren.dao.user.model.User;
import pers.darren.service.user.IUserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUserById")
    @ResponseBody
    public User getUserById(String id) {
        return this.userService.getUserById(id);
    }
}
