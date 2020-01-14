CREATE TABLE IF NOT EXISTS var_group (
    id varchar(36) primary key comment 'id',
    name VARCHAR(30) NOT NULL comment '分组名称',
    create_user varchar(36) comment '创建主体',
    create_date DATETIME comment '创建时间',
    visible TINYINT default 1 comment '是否可见'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '分组表';

CREATE TABLE IF NOT EXISTS var_group_focus (
     follower varchar(36) comment '关注者',
     groupId VARCHAR(36) comment '被关注分组',
     state TINYINT comment '1本人创建，2取消关注',
     primary key (follower, groupId),
     index(groupId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '关注分组表';

CREATE TABLE IF NOT EXISTS var_dict (
     id varchar(36) primary key comment 'id',
     origin VARCHAR(15) NOT NULL comment '原词',
     translation VARCHAR(150) comment '译文',
     group_id varchar(36) comment '所在分组'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '字段表';