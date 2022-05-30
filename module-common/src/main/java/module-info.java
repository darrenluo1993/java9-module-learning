module module.common {
    requires org.slf4j;
    requires com.fasterxml.jackson.annotation;

    exports pers.darren.common.constant;
    exports pers.darren.common.core.model;
    exports pers.darren.common.core.controller to module.web;
}