module module.service {
    requires module.common;
    requires transitive module.dao;

    requires spring.beans;
    requires spring.context;

    exports pers.darren.service.user to module.web;
    exports pers.darren.service.role to module.web;
    opens pers.darren.service.user.impl to spring.beans, spring.core;
    opens pers.darren.service.role.impl to spring.beans, spring.core;
}