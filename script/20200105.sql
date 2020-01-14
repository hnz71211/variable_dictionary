CREATE TABLE IF NOT EXISTS var_group (
    id varchar(36) primary key comment 'id',
    name VARCHAR(30) NOT NULL comment '分组名称',
    focus VARCHAR(4000) comment '关注分组',
    create_person varchar(36) comment '是否人',
    create_date DATETIME comment '创建时间',
    visible TINYINT default 1 comment '是否可见'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS var_dict (
     id varchar(36) primary key comment 'id',
     origin VARCHAR(15) NOT NULL comment '原词',
     translation VARCHAR(150) comment '译文',
     group_id varchar(36) comment '所在分组'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;