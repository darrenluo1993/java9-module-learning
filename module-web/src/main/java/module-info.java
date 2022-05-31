module module.web {
    requires module.common;
    requires module.service;

    requires spring.web;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;
    requires spring.boot.autoconfigure;

    opens pers.darren to spring.beans, spring.core, spring.context;
    opens pers.darren.controller.role to spring.beans, spring.core, spring.web;
    opens pers.darren.controller.user to spring.beans, spring.core, spring.web;
}