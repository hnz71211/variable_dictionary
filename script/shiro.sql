CREATE TABLE IF NOT EXISTS sys_user (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    account VARCHAR(20) NOT NULL COMMENT '账号',
    password VARCHAR(32) NOT NULL COMMENT '密码'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户表';

CREATE TABLE IF NOT EXISTS sys_role (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    role_name VARCHAR(20) NOT NULL COMMENT '角色名称',
    role_desc VARCHAR(20) COMMENT '角色描述'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色表';

CREATE TABLE IF NOT EXISTS sys_permission (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    permission VARCHAR(20) NOT NULL COMMENT '授权名称',
    url VARCHAR(100) COMMENT '授权url'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '权限表';

CREATE TABLE IF NOT EXISTS sys_user_role (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    uid INT NOT NULL COMMENT '用户id',
    rid INT NOT NULL COMMENT '角色id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户角色表';

CREATE TABLE IF NOT EXISTS sys_role_permission (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
    rid INT NOT NULL COMMENT '角色id',
    pid INT NOT NULL COMMENT '权限id'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '角色权限表';



INSERT INTO `sys_user` (`id`, `account`,`password`) VALUES (1, 'admin', 'C4CA4238A0B923820DCC509A6F75849B');
INSERT INTO `sys_role` (`id`,`role_name`,`role_desc`) VALUES (1,'manager','管理员');
INSERT INTO `sys_role` (`id`,`role_name`,`role_desc`) VALUES (2,'vip','VIP会员');
INSERT INTO `sys_permission` (`id`,`permission`, `url`) VALUES (1, 'user:all','menu','/user');
INSERT INTO `sys_permission` (`id`,`permission`, `url`) VALUES (2, 'group:select','button','userInfo/userAdd');
INSERT INTO `sys_user_role` (`id`, `uid`,`rid`) VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` (`id`, `rid`,`pid`) VALUES (1, 1, 1);
INSERT INTO `sys_role_permission` (`id`, `rid`,`pid`) VALUES (1, 1, 2);
INSERT INTO `sys_role_permission` (`id`, `rid`,`pid`) VALUES (3, 2, 2);
