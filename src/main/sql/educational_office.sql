/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : educational_office

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 08/08/2017 18:16:10 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `college_id`   INT(11)      NOT NULL AUTO_INCREMENT,
  `college_name` VARCHAR(200) NOT NULL
  COMMENT '学院名',
  PRIMARY KEY (`college_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 15
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `college`
-- ----------------------------
BEGIN;
INSERT INTO `college`
VALUES ('1', '电气与信息学院'), ('2', '动物科学与技术学院'), ('3', '工程学院'), ('4', '经济管理学院'), ('5', '理学院'), ('6', '马克思主义学院'),
  ('7', '农学院'), ('8', '生命科学学院'), ('9', '食品学院'), ('10', '水利与土木工程学院'), ('11', '文法学院'), ('12', '艺术学院'), ('13', '园艺学院'),
  ('14', '资源与环境学院');
COMMIT;

-- ----------------------------
--  Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id`   INT(11)      NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(200) NOT NULL
  COMMENT '课程名称',
  `teacher_id`  INT(11)      NOT NULL,
  `course_time` VARCHAR(200)          DEFAULT NULL
  COMMENT '开课时间',
  `classroom`   VARCHAR(200)          DEFAULT NULL
  COMMENT '开课地点',
  `course_week` INT(200)              DEFAULT NULL
  COMMENT '学时',
  `course_type` VARCHAR(20)           DEFAULT NULL
  COMMENT '课程类型',
  `college_id`  INT(11)      NOT NULL
  COMMENT '所属院系',
  `score`       INT(11)      NOT NULL
  COMMENT '学分',
  PRIMARY KEY (`course_id`),
  KEY `college_id` (`college_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`),
  CONSTRAINT `course_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `course`
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('1', 'C语言程序设计', '1002', '周二', '研424', '18', '必修课', '1', '3'),
  ('2', 'Python爬虫技巧', '1006', '周四', '研424', '18', '选修课', '1', '3'),
  ('3', '数据结构', '1011', '周四', '成637', '18', '必修课', '1', '2'),
  ('4', 'Java程序设计', '1007', '周五', '主401', '18', '选修课', '1', '3'),
  ('5', '大学英语', '1005', '周四', '研424', '16', '必修课', '11', '2'),
  ('6', '马克思主义原理', '1010', '周五', '教301', '12', '选修课', '6', '2'),
  ('7', '中国近现代史纲要', '1009', '周一', '主305', '12', '必修课', '6', '4'),
  ('8', '应用化学', '1001', '周一', '教301', '18', '必修课', '5', '4'),
  ('9', '高等数学', '1008', '周三', '教206', '18', '必修课', '5', '5'),
  ('10', '线性代数', '1001', '周二', '研314', '18', '选修课', '5', '3'),
  ('11', '大学物理', '1008', '周一', '研424', '18', '必修课', '5', '3');
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id`     INT(11)     NOT NULL AUTO_INCREMENT,
  `role_name`   VARCHAR(20) NOT NULL,
  `permissions` VARCHAR(255)         DEFAULT NULL
  COMMENT '权限',
  PRIMARY KEY (`role_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'teacher', NULL), ('2', 'student', NULL), ('3', 'admin', NULL);
COMMIT;

-- ----------------------------
--  Table structure for `select_course`
-- ----------------------------
DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course` (
  `course_id`  INT(11) NOT NULL,
  `student_id` INT(11) NOT NULL,
  `mark`       INT(11) DEFAULT NULL
  COMMENT '成绩',
  KEY `courseId` (`course_id`),
  KEY `studentId` (`student_id`),
  CONSTRAINT `select_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `select_course_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `select_course`
-- ----------------------------
BEGIN;
INSERT INTO `select_course`
VALUES ('2', '10002', '75'), ('1', '10001', '95'), ('1', '10002', '66'), ('3', '10008', NULL), ('2', '10003', '99'),
  ('5', '10011', '80'), ('8', '10001', NULL), ('5', '10001', NULL), ('5', '10005', '78'), ('6', '10004', NULL),
  ('5', '10002', '69'), ('10', '10001', NULL);
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id`     INT(11)      NOT NULL AUTO_INCREMENT,
  `name`           VARCHAR(200) NOT NULL,
  `gender`         VARCHAR(20)           DEFAULT NULL,
  `bidrth_date`    DATE                  DEFAULT NULL
  COMMENT '出生日期',
  `enrolment_date` DATE                  DEFAULT NULL
  COMMENT '入学时间',
  `college_id`     INT(11)      NOT NULL
  COMMENT '院系id',
  PRIMARY KEY (`student_id`),
  KEY `college_id` (`college_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10013
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student`
VALUES ('10001', '小周', '男', '1996-09-23', '2017-08-25', '1'), ('10002', '小刘', '女', '1995-09-14', '2017-08-25', '1'),
  ('10003', '小陈', '女', '1996-03-11', '2017-08-25', '5'), ('10004', '小王', '女', '1996-09-02', '2017-08-25', '5'),
  ('10005', '小李', '女', '1996-05-27', '2017-08-25', '6'), ('10006', '小陈', '女', '1996-09-25', '2017-08-25', '1'),
  ('10007', '小华', '男', '1996-06-14', '2016-08-28', '6'), ('10008', '小宋', '女', '1996-07-16', '2015-08-27', '11'),
  ('10009', '小明', '女', '1996-08-02', '2015-08-27', '1'), ('10010', '小左', '男', '1996-08-25', '2015-08-27', '11'),
  ('10011', '小杨', '女', '1996-05-22', '2015-08-27', '5'), ('10012', '小赵', '女', '1996-09-09', '2015-08-27', '1');
COMMIT;

-- ----------------------------
--  Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id`    INT(11)      NOT NULL AUTO_INCREMENT,
  `name`          VARCHAR(200) NOT NULL,
  `gender`        VARCHAR(20)           DEFAULT NULL,
  `birth_date`    DATE         NOT NULL,
  `degree`        VARCHAR(20)           DEFAULT NULL
  COMMENT '学历',
  `title`         VARCHAR(255)          DEFAULT NULL
  COMMENT '职称',
  `enrolmentDate` DATE                  DEFAULT NULL
  COMMENT '入职时间',
  `college_id`    INT(11)      NOT NULL
  COMMENT '院系id',
  PRIMARY KEY (`teacher_id`),
  KEY `college_id` (`college_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1012
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `teacher`
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES ('1001', '刘老师', '女', '1985-03-08', '硕士', '副教授', '2010-07-30', '5'),
  ('1002', '王老师', '男', '1982-03-29', '本科', '副教授', '2008-09-02', '1'),
  ('1003', '张老师', '女', '1984-06-14', '硕士', '普通教师', '2008-08-16', '1'),
  ('1004', '方老师', '男', '1986-10-23', '博士', '普通教师', '2012-09-02', '1'),
  ('1005', '左老师', '男', '1983-09-13', '本科', '教授', '2012-09-02', '11'),
  ('1006', '张老师', '男', '1990-04-06', '本科', '副教授', '2015-07-30', '1'),
  ('1007', '孙老师', '女', '1986-05-13', '硕士', '普通教师', '2007-10-24', '1'),
  ('1008', '张老师', '男', '1986-08-09', '本科', '教授', '2015-09-12', '5'),
  ('1009', '乔老师', '女', '1985-09-02', '硕士', '普通教师', '2015-06-18', '6'),
  ('1010', '刘老师', '男', '1985-05-26', '博士', '教授', '2010-09-02', '6'),
  ('1011', '何老师', '女', '1989-07-04', '硕士', '助教', '2008-07-07', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id`  INT(11)      NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(200) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `role_id`  INT(11)      NOT NULL DEFAULT '2'
  COMMENT '角色权限',
  PRIMARY KEY (`user_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 11
  DEFAULT CHARSET = utf8;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info`
VALUES ('1', 'admin', '123', '3'), ('2', '1001', '1234', '1'), ('3', '1002', '1234', '1'), ('4', '1003', '1234', '1'),
  ('5', '1004', '1234', '1'), ('6', '101', '12345', '2'), ('7', '102', '12345', '2'), ('8', '103', '12345', '2'),
  ('9', '104', '12345', '2'), ('10', '105', '12345', '2');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
