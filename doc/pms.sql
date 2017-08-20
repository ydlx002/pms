/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-08-15 23:05:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_s_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_s_menu`;
CREATE TABLE `t_s_menu` (
  `id` varchar(64) NOT NULL COMMENT '菜单id',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级菜单ID',
  `sys_id` varchar(64) DEFAULT NULL COMMENT '系统ID',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名',
  `leaf` int(11) DEFAULT NULL COMMENT '0 非叶子节点  1叶子节点',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标样式',
  `path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `level` int(11) DEFAULT NULL COMMENT '菜单级数',
  `url` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `target` varchar(255) DEFAULT NULL COMMENT '跳转方式',
  `order_by` int(11) DEFAULT 0 COMMENT '排序',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `operator_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_s_menu` VALUES ('1', '-1', '1','菜单根目录', '0', null, '--', '0', '#', 0,null, '2012-12-15 18:08:07', '2012-12-23 19:46:45', '1');
INSERT INTO `t_s_menu` VALUES ('2', '1', '1','系统管理', '0', null, '1#2', '1', '#', 0,null, '2012-12-13 13:46:00', '2013-04-29 10:36:34', '1');
INSERT INTO `t_s_menu` VALUES ('3', '1', '1','业务管理', '0', null, '1#3', '1', '#', 0,null, '2012-12-13 13:53:10', '2013-04-26 20:15:27', '1');
INSERT INTO `t_s_menu` VALUES ('4', '2', '1','菜单管理', '0', null, '1#2#4', '2', '/system/menu/index', 0,null, '2012-12-13 16:00:02', '2013-04-26 20:15:36', '1');
INSERT INTO `t_s_menu` VALUES ('5', '2', '1','用户管理', '0', null, '1#2#5', '2', '/system/user/index', 0,null, '2012-12-13 16:00:02', '2013-04-26 20:15:47', '1');
INSERT INTO `t_s_menu` VALUES ('6', '2', '1','角色管理', '0', null, '1#2#6', '2', '/system/role/index', 0,null, '2012-12-13 16:00:02', '2013-04-26 20:15:50', '1');
INSERT INTO `t_s_menu` VALUES ('7', '4', '1','菜单添加', '1', null, '1#2#4#7', '3', '/system/menuAdd.jsp', 0,'centerFrame', '2012-12-15 18:33:28', '2013-04-26 20:16:31', '1');
INSERT INTO `t_s_menu` VALUES ('8', '2', '1','权限管理', '0', null, '1#2#8', '2', '/system/permission/index',0, null, '2012-12-16 13:59:33', '2013-04-29 11:26:42', '1');
INSERT INTO `t_s_menu` VALUES ('9', '4', '1','菜单查询', '1', null, '1#2#4#9', '3', '/system/menuList.jsp', 0,'centerFrame', '2012-12-16 14:15:20', '2013-04-26 20:12:33', '1');
INSERT INTO `t_s_menu` VALUES ('10', '8', '1','权限添加', '1', null, '1#2#8#10', '3', '/system/permissionAdd.jsp', 0,'centerFrame', '2012-12-20 14:58:29', '2013-04-26 20:12:38', '1');
INSERT INTO `t_s_menu` VALUES ('13', '8', '1','权限查询', '1', null, '1#2#8#13', '3', '/system/permissionList.jsp', 0,'centerFrame', '2012-12-20 16:28:03', '2013-04-26 20:12:43', '1');
INSERT INTO `t_s_menu` VALUES ('14', '6', '1','角色添加', '1', null, '1#2#6#14', '3', '/system/roleAdd.jsp', 0,'centerFrame', '2012-12-22 12:36:14', '2013-04-26 20:12:48', '1');
INSERT INTO `t_s_menu` VALUES ('15', '6', '1','角色查询', '1', null, '1#2#6#15', '3', '/system/roleList.jsp', 0,'centerFrame', '2012-12-22 14:29:28', '2013-04-26 20:12:53', '1');
INSERT INTO `t_s_menu` VALUES ('16', '5', '1','用户添加', '1', null, '1#2#5#16', '3', '/system/userAdd.jsp', 0,'centerFrame', '2012-12-22 18:34:26', '2013-04-26 20:12:57', '1');
INSERT INTO `t_s_menu` VALUES ('17', '5', '1','用户查询', '1', null, '1#2#5#17', '3', '/system/userList.jsp', 0,'centerFrame', '2012-12-22 19:56:13', '2013-04-26 20:13:01', '1');

-- ----------------------------
-- Table structure for t_s_privilege
-- ----------------------------
DROP TABLE IF EXISTS `t_s_privilege`;
CREATE TABLE `t_s_privilege` (
  `pri_id` varchar(64) NOT NULL COMMENT '权限ID',
  `sys_id` varchar(64) DEFAULT NULL,
  `pri_code` varchar(64) DEFAULT NULL COMMENT '权限编码',
  `pri_name` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `pri_desc` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员ID',
  PRIMARY KEY (`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_pri_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_pri_user`;
CREATE TABLE `t_s_pri_user` (
  `user_id` varchar(64) NOT NULL,
  `pri_id` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`,`pri_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role`;
CREATE TABLE `t_s_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolecode` varchar(32) DEFAULT NULL,
  `rolename` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_s_role_menu`;
CREATE TABLE `t_s_role_menu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) DEFAULT NULL,
  `menuid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_sys
-- ----------------------------
DROP TABLE IF EXISTS `t_s_sys`;
CREATE TABLE `t_s_sys` (
  `sys_id` varchar(32) DEFAULT NULL COMMENT '系统ID--唯一标识',
  `sys_code` varchar(32) DEFAULT NULL COMMENT '系统编码',
  `sys_name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `sys_desc` varchar(255) DEFAULT NULL,
  `enable` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `operator_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统信息表';

-- ----------------------------
-- Table structure for t_s_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_sys_user`;
CREATE TABLE `t_s_sys_user` (
  `sys_id` varchar(32) NOT NULL DEFAULT '' COMMENT '系统ID',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `password` varchar(128) DEFAULT NULL,
  `user_type_id` varchar(64) DEFAULT NULL COMMENT '类型ID',
  `state` tinyint(1) DEFAULT '1' COMMENT '0 禁用  1 正常',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`sys_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_user
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user`;
CREATE TABLE `t_s_user` (
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `login_account` varchar(64) DEFAULT NULL COMMENT '登录帐号',
  `full_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `mobile` varchar(16) DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(512) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `operator_id` varchar(64) DEFAULT NULL COMMENT '操作员id',
  PRIMARY KEY (`user_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for t_s_user_pri
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_pri`;
CREATE TABLE `t_s_user_pri` (
  `user_id` varchar(64) DEFAULT NULL,
  `pri_id` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_s_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_s_user_role`;
CREATE TABLE `t_s_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `modifytime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Function structure for getChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildList`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN
   DECLARE sTemp VARCHAR(1000);
   DECLARE sTempChd VARCHAR(1000);

	 SET sTemp='$';
   SET sTempChd =cast(rootId as CHAR);
	 
   WHILE sTempChd is not null DO
		SET sTemp = concat(sTemp,',',sTempChd);
     SELECT group_concat(id) INTO sTempChd FROM t_s_menu where FIND_IN_SET(parentid,sTempChd)>0;
   END WHILE;
   RETURN sTemp;
 END
;;
DELIMITER ;
