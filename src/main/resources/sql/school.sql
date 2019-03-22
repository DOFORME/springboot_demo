-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.20 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 school 的数据库结构
CREATE DATABASE IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;

-- 导出  表 school.aust_class 结构
CREATE TABLE IF NOT EXISTS `aust_class` (
  `id` int(11) NOT NULL COMMENT 'id',
  `period` int(11) NOT NULL COMMENT '届',
  `grade` int(11) NOT NULL COMMENT '年级',
  `no` int(11) NOT NULL COMMENT '班级号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

-- 正在导出表  school.aust_class 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `aust_class` DISABLE KEYS */;
INSERT INTO `aust_class` (`id`, `period`, `grade`, `no`) VALUES
	(1111, 0, 11, 11);
/*!40000 ALTER TABLE `aust_class` ENABLE KEYS */;

-- 导出  表 school.aust_class_teacher 结构
CREATE TABLE IF NOT EXISTS `aust_class_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='班级-教师';

-- 正在导出表  school.aust_class_teacher 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `aust_class_teacher` DISABLE KEYS */;
INSERT INTO `aust_class_teacher` (`id`, `class_id`, `teacher_id`) VALUES
	(1, 1111, 1),
	(2, 1111, 2);
/*!40000 ALTER TABLE `aust_class_teacher` ENABLE KEYS */;

-- 导出  表 school.aust_course 结构
CREATE TABLE IF NOT EXISTS `aust_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `name` varchar(8) DEFAULT NULL COMMENT '课程名',
  `credit` tinyint(4) DEFAULT NULL COMMENT '学分',
  `hours` tinyint(4) DEFAULT NULL COMMENT '学时',
  `description` varchar(10) DEFAULT NULL COMMENT '描述',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(10) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(10) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(10) DEFAULT NULL,
  `flag` bit(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程';

-- 正在导出表  school.aust_course 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `aust_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `aust_course` ENABLE KEYS */;

-- 导出  表 school.aust_sc 结构
CREATE TABLE IF NOT EXISTS `aust_sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课编号',
  `student_id` int(11) NOT NULL DEFAULT '0' COMMENT '学生编号',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程编号',
  `teacher_id` int(11) NOT NULL DEFAULT '0' COMMENT '教师编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='选课';

-- 正在导出表  school.aust_sc 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `aust_sc` DISABLE KEYS */;
/*!40000 ALTER TABLE `aust_sc` ENABLE KEYS */;

-- 导出  表 school.aust_student 结构
CREATE TABLE IF NOT EXISTS `aust_student` (
  `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `gender` char(50) DEFAULT NULL COMMENT '性别',
  `class_id` int(11) DEFAULT NULL COMMENT '班级ID',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL COMMENT '逻辑删除1-删除0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学生';

-- 正在导出表  school.aust_student 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `aust_student` DISABLE KEYS */;
INSERT INTO `aust_student` (`id`, `name`, `age`, `gender`, `class_id`, `address`, `create_at`, `update_at`, `create_by`, `update_by`, `is_delete`) VALUES
	(1, 'zhan', 20, 'man', 1111, NULL, '2018-12-20 16:09:33', NULL, NULL, NULL, b'0'),
	(2, 'liu', 22, 'man', 1111, NULL, '2018-12-20 16:09:33', NULL, NULL, NULL, b'0');
/*!40000 ALTER TABLE `aust_student` ENABLE KEYS */;

-- 导出  表 school.aust_teacher 结构
CREATE TABLE IF NOT EXISTS `aust_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  `age` int(11) DEFAULT '0',
  `gender` tinyint(4) DEFAULT NULL COMMENT '0-女，1-男',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(50) DEFAULT NULL,
  `flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='教师';

-- 正在导出表  school.aust_teacher 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `aust_teacher` DISABLE KEYS */;
INSERT INTO `aust_teacher` (`id`, `name`, `age`, `gender`, `create_by`, `update_by`, `create_at`, `update_at`, `remark`, `flag`) VALUES
	(1, 'test', 0, NULL, NULL, NULL, '2019-03-21 10:37:26', '2019-03-21 10:37:26', NULL, 0),
	(2, 'abc', 0, NULL, NULL, NULL, '2019-03-21 10:37:26', '2019-03-21 10:37:26', NULL, 0),
	(3, 'abc', 0, NULL, NULL, NULL, '2019-03-21 10:37:26', '2019-03-21 10:37:26', NULL, 0),
	(4, 'bob', 0, NULL, NULL, NULL, '2019-03-21 10:37:26', '2019-03-21 10:37:26', NULL, 0);
/*!40000 ALTER TABLE `aust_teacher` ENABLE KEYS */;

-- 导出  表 school.sys_menu 结构
CREATE TABLE IF NOT EXISTS `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` char(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(20) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(50) DEFAULT NULL,
  `flag` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- 正在导出表  school.sys_menu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;

-- 导出  表 school.sys_permission 结构
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(50) DEFAULT NULL,
  `flag` varchar(50) DEFAULT '1' COMMENT '0-禁用，1-启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 正在导出表  school.sys_permission 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` (`id`, `name`, `description`, `create_by`, `update_by`, `create_at`, `update_at`, `remark`, `flag`) VALUES
	(1, 'create', NULL, NULL, NULL, '2019-03-21 10:44:26', '2019-03-21 10:46:10', NULL, '1'),
	(2, 'delete', NULL, NULL, NULL, '2019-03-21 10:44:36', '2019-03-21 10:46:11', NULL, '1'),
	(3, 'update', NULL, NULL, NULL, '2019-03-21 10:44:56', '2019-03-21 10:46:12', NULL, '1'),
	(4, 'search', NULL, NULL, NULL, '2019-03-21 10:45:11', '2019-03-21 10:46:13', NULL, '1'),
	(5, 'test', NULL, NULL, NULL, '2019-03-21 16:04:14', '2019-03-21 16:04:14', NULL, '1');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;

-- 导出  表 school.sys_role 结构
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(50) DEFAULT NULL COMMENT '权限描述',
  `flag` int(11) DEFAULT '1' COMMENT '0-禁用，1-启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  school.sys_role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` (`id`, `name`, `create_by`, `update_by`, `create_at`, `update_at`, `remark`, `flag`) VALUES
	(1, 'admin', NULL, NULL, '2019-03-21 10:45:42', '2019-03-21 10:45:42', NULL, 1),
	(2, 'student', NULL, NULL, '2019-03-21 10:46:49', '2019-03-21 10:46:49', NULL, 1),
	(3, 'teacher', NULL, NULL, '2019-03-21 10:47:20', '2019-03-21 10:47:20', NULL, 1),
	(4, 'manager', NULL, NULL, '2019-03-21 10:47:32', '2019-03-21 10:47:32', NULL, 1);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 school.sys_role_permission 结构
CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL DEFAULT '0',
  `permission_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色-权限';

-- 正在导出表  school.sys_role_permission 的数据：~7 rows (大约)
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` (`id`, `role_id`, `permission_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 2, 4),
	(6, 3, 1),
	(7, 3, 4),
	(8, 1, 5);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;

-- 导出  表 school.sys_user 结构
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL COMMENT '登录名',
  `nick_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `flag` int(11) DEFAULT '1' COMMENT '0-禁用，1-启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_name` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  school.sys_user 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` (`id`, `login_name`, `nick_name`, `password`, `create_by`, `update_by`, `create_at`, `update_at`, `remark`, `flag`) VALUES
	(1, 'ASDFG123', 'zhangsan', '123456', NULL, NULL, '2019-03-19 15:23:03', '2019-03-21 10:50:23', NULL, 1),
	(2, 'ASDFG234', 'teacherwu', '234567', NULL, NULL, '2019-03-21 10:50:56', '2019-03-21 10:50:56', NULL, 1),
	(3, 'lc', 'lc', '123456', NULL, NULL, '2019-03-21 10:52:31', '2019-03-21 10:52:31', NULL, 1);
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 school.sys_user_role 结构
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户-角色表';

-- 正在导出表  school.sys_user_role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` (`id`, `user_id`, `role_id`) VALUES
	(1, 1, 5),
	(2, 2, 3),
	(3, 3, 1);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
