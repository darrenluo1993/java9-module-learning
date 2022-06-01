package pers.darren.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.darren.common.core.controller.BaseController;
import pers.darren.common.core.model.AjaxResult;
import pers.darren.dao.user.model.User;
import pers.darren.service.user.IUserService;

import java.util.Date;

import static java.util.UUID.randomUUID;
import static pers.darren.common.core.model.AjaxResult.success;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getUserById")
    public AjaxResult getUserById(String id) {
        return success(this.userService.getUserById(id));
    }

    @GetMapping("/listAllUser")
    public AjaxResult listAllUser() {
        return success(this.userService.listAllUser());
    }

    @PostMapping("/addUser")
    public AjaxResult addUser(@RequestBody User user) {
        user.setId(randomUUID().toString());
        user.setCreatedTime(new Date());
        this.userService.addUser(user);
        return success("新增成功");
    }
}
