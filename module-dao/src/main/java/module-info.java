module module.dao {
    requires module.common;

    requires java.sql;
    requires org.mybatis;
    requires com.fasterxml.jackson.annotation;

    exports pers.darren.dao.user.model;
    exports pers.darren.dao.role.model;
    exports pers.darren.dao.user to module.service;
    exports pers.darren.dao.role to module.service;
}