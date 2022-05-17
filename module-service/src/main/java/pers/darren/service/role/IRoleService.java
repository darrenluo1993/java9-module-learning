package pers.darren.service.role;

import pers.darren.dao.role.model.Role;

public interface IRoleService {

    Role getRoleById(String id);

    void addRole(Role role);

    void modifyRoleById(Role role);

    void modifyRoleSelectiveById(Role role);
}
