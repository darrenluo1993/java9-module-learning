create table role
(
    id            varchar(36)  not null comment '主键'
        primary key,
    role_name     varchar(30)  not null comment '角色名',
    role_desc     varchar(150) not null comment '角色描述',
    created_by    varchar(36)  null comment '创建人',
    created_time  datetime     null comment '创建时间',
    modified_by   varchar(36)  null comment '修改人',
    modified_time datetime     null comment '修改时间'
);


