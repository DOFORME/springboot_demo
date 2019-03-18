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
DROP DATABASE IF EXISTS `school`;
CREATE DATABASE IF NOT EXISTS `school` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `school`;

-- 导出  表 school.class 结构
DROP TABLE IF EXISTS `class`;
CREATE TABLE IF NOT EXISTS `class` (
  `id` int(11) NOT NULL COMMENT 'id',
  `grade` int(11) NOT NULL COMMENT '年级',
  `no` int(11) NOT NULL COMMENT '班级号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

-- 正在导出表  school.class 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` (`id`, `grade`, `no`) VALUES
	(1111, 11, 11);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;

-- 导出  表 school.class_teacher 结构
DROP TABLE IF EXISTS `class_teacher`;
CREATE TABLE IF NOT EXISTS `class_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='班级-教师信息表';

-- 正在导出表  school.class_teacher 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `class_teacher` DISABLE KEYS */;
INSERT INTO `class_teacher` (`id`, `class_id`, `teacher_id`) VALUES
	(1, 1111, 1),
	(2, 1111, 2);
/*!40000 ALTER TABLE `class_teacher` ENABLE KEYS */;

-- 导出  表 school.course 结构
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `name` varchar(8) DEFAULT NULL COMMENT '课程名',
  `credit` tinyint(4) DEFAULT NULL COMMENT '学分',
  `hours` tinyint(4) DEFAULT NULL COMMENT '学时',
  `desc` varchar(10) DEFAULT NULL COMMENT '描述',
  `create_at` datetime DEFAULT NULL COMMENT '创建时间',
  `update_at` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(10) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(10) DEFAULT NULL COMMENT '更新人',
  `is_delete` bit(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  school.course 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- 导出  表 school.menu 结构
DROP TABLE IF EXISTS `menu`;
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_code` char(10) DEFAULT NULL,
  `menu_name` varchar(20) DEFAULT NULL,
  `parent_menu_id` int(11) DEFAULT NULL,
  `create_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能目录';

-- 正在导出表  school.menu 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 导出  表 school.sc 结构
DROP TABLE IF EXISTS `sc`;
CREATE TABLE IF NOT EXISTS `sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课编号',
  `student_id` int(11) NOT NULL DEFAULT '0' COMMENT '学生编号',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程编号',
  `teacher_id` int(11) NOT NULL DEFAULT '0' COMMENT '教师编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生选课表';

-- 正在导出表  school.sc 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sc` DISABLE KEYS */;
/*!40000 ALTER TABLE `sc` ENABLE KEYS */;

-- 导出  表 school.student 结构
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- 正在导出表  school.student 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`id`, `name`, `age`, `gender`, `class_id`, `address`, `create_at`, `update_at`, `create_by`, `update_by`, `is_delete`) VALUES
	(1, 'zhan', 20, 'man', 1111, NULL, '2018-12-20 16:09:33', NULL, NULL, NULL, b'0'),
	(2, 'liu', 22, 'man', 1111, NULL, '2018-12-20 16:09:33', NULL, NULL, NULL, b'0');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- 导出  表 school.sys_role 结构
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` int(11) DEFAULT NULL COMMENT '权限号',
  `role_desc` varchar(10) DEFAULT NULL COMMENT '权限描述',
  `create_by` varchar(10) DEFAULT NULL,
  `update_by` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-激活1-逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限';

-- 正在导出表  school.sys_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;

-- 导出  表 school.sys_user 结构
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL,
  `encode_password` varchar(10) DEFAULT NULL COMMENT '加密后的密码',
  `create_by` varchar(10) DEFAULT NULL,
  `update_by` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-激活的用户1-逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- 正在导出表  school.sys_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;

-- 导出  表 school.teacher 结构
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  school.teacher 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`id`, `name`, `course`) VALUES
	(1, 'test', NULL),
	(2, 'abc', NULL),
	(3, 'abc', NULL),
	(4, 'bob', NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
