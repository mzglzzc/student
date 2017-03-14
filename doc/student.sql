/*
Navicat MySQL Data Transfer

Source Server         : localhost_root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-03-14 21:39:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `majorid` bigint(20) DEFAULT NULL COMMENT '专业ID',
  `name` varchar(255) DEFAULT NULL COMMENT '班级名称',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='班级';

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '1', '网络0901', '2017-03-04 23:40:43');

-- ----------------------------
-- Table structure for institute
-- ----------------------------
DROP TABLE IF EXISTS `institute`;
CREATE TABLE `institute` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='学院';

-- ----------------------------
-- Records of institute
-- ----------------------------
INSERT INTO `institute` VALUES ('1', '信息学院', '2017-02-26 21:09:22');
INSERT INTO `institute` VALUES ('2', '理学院', '2017-02-26 23:33:29');
INSERT INTO `institute` VALUES ('3', '文学院', '2017-02-28 23:14:44');
INSERT INTO `institute` VALUES ('4', '历史学院', '2017-02-28 23:15:50');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `instituteid` bigint(20) DEFAULT NULL COMMENT '学院id',
  `name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `seq` int(11) DEFAULT '0' COMMENT '序号',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='专业表';

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '1', '网络工程', '0', '2017-03-01 22:37:12');
INSERT INTO `major` VALUES ('2', '1', '计算机', '0', '2017-03-01 22:43:57');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` bigint(20) DEFAULT NULL COMMENT '学号',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别：0-女；1-男',
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `idcard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL,
  `entry_time` timestamp NULL DEFAULT NULL COMMENT '入学时间',
  `classesid` bigint(20) DEFAULT NULL COMMENT '班级ID',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='学生';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '0', null, null, '0', null, null, null, null, null, '0', '2017-03-05 18:44:19');
INSERT INTO `student` VALUES ('2', '0', '¦e', 'zzc', '0', null, null, null, null, null, '1', '2017-03-05 19:48:54');
INSERT INTO `student` VALUES ('3', '0', '¦ÐÜ', 'zwr', '0', null, null, null, null, null, '1', '2017-03-09 22:40:05');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `uid` bigint(20) DEFAULT NULL COMMENT '工号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别：0-女；1-男',
  `birthday` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '生日',
  `idcard` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL,
  `entry_time` timestamp NULL DEFAULT NULL COMMENT '入职时间',
  `majorid` bigint(20) DEFAULT NULL COMMENT '专业ID',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师表';

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for teacher_class_rel
-- ----------------------------
DROP TABLE IF EXISTS `teacher_class_rel`;
CREATE TABLE `teacher_class_rel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `teacherid` bigint(20) DEFAULT NULL COMMENT '教师ID',
  `classid` bigint(20) DEFAULT NULL COMMENT '班级ID',
  `ctime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='教师-班级关系表';

-- ----------------------------
-- Records of teacher_class_rel
-- ----------------------------
INSERT INTO `teacher_class_rel` VALUES ('2', null, null, '2017-02-26 16:03:40');
