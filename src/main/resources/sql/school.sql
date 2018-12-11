-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.3-rc-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5295
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

-- 数据导出被取消选择。
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='功能目录';

-- 数据导出被取消选择。
-- 导出  表 school.sc 结构
DROP TABLE IF EXISTS `sc`;
CREATE TABLE IF NOT EXISTS `sc` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课编号',
  `student_id` int(11) NOT NULL DEFAULT '0' COMMENT '学生编号',
  `course_id` int(11) NOT NULL DEFAULT '0' COMMENT '课程编号',
  `teacher_id` int(11) NOT NULL DEFAULT '0' COMMENT '教师编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生选课表';

-- 数据导出被取消选择。
-- 导出  表 school.student 结构
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `gender` char(50) DEFAULT NULL COMMENT '性别',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL COMMENT '逻辑删除1-删除0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- 数据导出被取消选择。
-- 导出  表 school.student_temp 结构
DROP TABLE IF EXISTS `student_temp`;
CREATE TABLE IF NOT EXISTS `student_temp` (
  `id` int(12) unsigned NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `age` tinyint(3) unsigned DEFAULT NULL COMMENT '年龄',
  `course_name` varchar(10) DEFAULT NULL,
  `gender` char(50) DEFAULT NULL COMMENT '性别',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `create_at` timestamp NULL DEFAULT NULL COMMENT '创建日期',
  `update_at` timestamp NULL DEFAULT NULL COMMENT '更新日期',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '逻辑删除0-删除1-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COMMENT='学生表';

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
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

-- 数据导出被取消选择。
-- 导出  表 school.teacher 结构
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(8) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
