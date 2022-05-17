package pers.darren.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.darren.dao.role.RoleMapper;
import pers.darren.dao.role.model.Role;
import pers.darren.service.role.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleById(String id) {
        return this.roleMapper.getRoleById(id);
    }

    @Override
    public void addRole(Role role) {
        this.roleMapper.addRole(role);
    }

    @Override
    public void modifyRoleById(Role role) {
        this.roleMapper.modifyRoleById(role);
    }

    @Override
    public void modifyRoleSelectiveById(Role role) {
        this.roleMapper.modifyRoleSelectiveById(role);
    }
}
