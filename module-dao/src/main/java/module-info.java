module module.dao {
    requires org.mybatis;
    requires java.sql;

    exports pers.darren.dao.user.model;
    exports pers.darren.dao.role.model;
    exports pers.darren.dao.user to module.service;
    exports pers.darren.dao.role to module.service;
}