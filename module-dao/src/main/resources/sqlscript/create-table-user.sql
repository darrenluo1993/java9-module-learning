create table user
(
    id            varchar(36)      not null comment '主键'
        primary key,
    username      varchar(150)     not null comment '用户名',
    realname      varchar(150)     not null comment '真实姓名',
    gender        varchar(15)      not null comment '性别',
    age           tinyint unsigned not null comment '年龄',
    created_by    varchar(36)      null comment '创建人',
    created_time  datetime         null comment '创建时间',
    modified_by   varchar(36)      null comment '修改人',
    modified_time datetime         null comment '修改时间'
);


