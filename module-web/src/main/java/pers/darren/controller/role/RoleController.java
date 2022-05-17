package pers.darren.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.darren.common.core.model.AjaxResult;
import pers.darren.dao.role.model.Role;
import pers.darren.service.role.IRoleService;

import java.util.Date;

import static java.util.UUID.randomUUID;
import static pers.darren.common.core.model.AjaxResult.success;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/getRoleById")
    public AjaxResult getRoleById(String id) {
        return success(this.roleService.getRoleById(id));
    }

    @PostMapping("/addRole")
    public AjaxResult addRole(@RequestBody Role role) {
        role.setId(randomUUID().toString());
        role.setCreatedTime(new Date());
        this.roleService.addRole(role);
        return success("新增成功");
    }

    @PostMapping("/modifyRoleById")
    public AjaxResult modifyRoleById(@RequestBody Role role) {
        role.setModifiedTime(new Date());
        this.roleService.modifyRoleById(role);
        return success("修改成功");
    }

    @PostMapping("/modifyRoleSelectiveById")
    public AjaxResult modifyRoleSelectiveById(@RequestBody Role role) {
        role.setModifiedTime(new Date());
        this.roleService.modifyRoleSelectiveById(role);
        return success("修改成功");
    }
}
