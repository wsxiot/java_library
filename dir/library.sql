/*
Navicat MySQL Data Transfer

Source Server         : wsx
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-11-10 15:39:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookname` varchar(30) DEFAULT NULL,
  `bannercode` varchar(30) NOT NULL,
  `kindnumber` varchar(20) DEFAULT NULL,
  `kindname` varchar(20) DEFAULT NULL,
  `positionnumber` varchar(20) DEFAULT NULL,
  `publishingcompany` varchar(30) DEFAULT NULL,
  `publishtime` datetime DEFAULT NULL,
  `putintime` datetime DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` varchar(4) DEFAULT NULL,
  `introduction` varchar(50) DEFAULT NULL,
  `author` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`bannercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('法律基础', '000', ' ccc', '政治、法律', '0', '人民教育', '2006-01-03 00:00:00', '2007-01-01 00:00:00', '0', '离架', '学法选读', '无');
INSERT INTO `book` VALUES ('1', '1', '1', '马克思列宁主义、毛泽东思想', '1', '1', '2007-12-01 00:00:00', '2016-10-16 00:00:00', '1', '在架', '1', '1');
INSERT INTO `book` VALUES ('数字电路', '1010', 'hhh', '工业技术', '10', '科学出版社', '2005-05-06 00:00:00', '2007-12-03 00:00:00', '24', '在架', 'sad', 'as');
INSERT INTO `book` VALUES ('药学概论', '111', 'aaa', '医药、卫生', '1', '电子工业', '2006-04-04 00:00:00', '2007-01-15 00:00:00', '10.2', '在架', 'asdf', 'aaa');
INSERT INTO `book` VALUES ('1', '12', '1', '马克思列宁主义、毛泽东思想', '21', '1', '2007-12-01 00:00:00', '2016-10-16 00:00:00', '1', '在架', '1', '1');
INSERT INTO `book` VALUES ('JAVA高级编程', '12-235', '比尔', '综合性图书', 'aaa', '电子出版社', '2007-12-01 00:00:00', '2007-12-25 00:00:00', '36', '在架', 'JAVA高级编程适合高级编程人员使用', '比尔');
INSERT INTO `book` VALUES ('JSP', '123', '小三', '工业技术', '333', '清华大学出版社', '2007-03-03 00:00:00', '2007-12-25 00:00:00', '25', '在架', 'JSP', '小三');
INSERT INTO `book` VALUES ('线性代数', '1233', '陈建华', '数理化', '1100', '高等教育出版社', '2006-06-06 00:00:00', '2008-01-01 00:00:00', '20', '在架', '线性代数学习', '陈建华');
INSERT INTO `book` VALUES ('SQL2000', '1234', '王明', '综合性图书', '111', '电子工业出版社', '2007-01-03 00:00:00', '2007-12-25 00:00:00', '50', '在架', 'SQL2000', '王明');
INSERT INTO `book` VALUES ('黑洞', '1235', '霍金', '天文学、地球科学', '1223', '世界出版社', '2006-01-02 00:00:00', '2008-01-01 00:00:00', '60', '在架', '关于黑洞的猜测', '霍金');
INSERT INTO `book` VALUES ('基础医学概论', '222', 'aaa', '医药、卫生', '2', '电子工业', '2006-04-04 00:00:00', '2007-01-14 00:00:00', '10.2', '离架', 'asdf', 'asf');
INSERT INTO `book` VALUES ('牛津英语词典', '231', '牛津', '语言文字', '1212', '牛津大学出版社', '2007-07-07 00:00:00', '2008-01-01 00:00:00', '80', '在架', '英语工具书', '牛津');
INSERT INTO `book` VALUES ('java开发', '234', '张义丰', '工业技术', '234', '电子工业出版社', '2006-06-06 00:00:00', '2008-01-02 00:00:00', '30', '在架', 'JAVA', '张义丰');
INSERT INTO `book` VALUES ('数据库系统', '333', 'bbb', '文化、科学、教育', '3', '清华大学', '2006-03-03 00:00:00', '2007-01-09 00:00:00', '12.2', '在架', 'adf', 'asa');
INSERT INTO `book` VALUES ('离散数学', '3456', '王立', '数理化', '456', '高等教育', '2007-04-05 00:00:00', '2008-01-01 00:00:00', '60', '在架', '离散数学教育', '王立');
INSERT INTO `book` VALUES ('4', '4', '4', '马克思列宁主义、毛泽东思想', '4', '4', '2016-10-16 00:00:00', '2016-10-16 00:00:00', '4', '在架', '', '4');
INSERT INTO `book` VALUES ('计算机网络', '444', 'bbb', '文化、科学、教育', '4', '清华大学', '2006-04-03 00:00:00', '2007-10-09 00:00:00', '15.3', '在架', 'adf', 'sa');
INSERT INTO `book` VALUES ('大学英语', '555', 'ddd', '语言文字', '6', '清华大学', '2005-03-04 00:00:00', '2007-06-09 00:00:00', '15.5', '离架', 'aas', 'sa');
INSERT INTO `book` VALUES ('c语言', '666', 'aaa', '文化、科学、教育', '7', '清华大学', '2005-04-04 00:00:00', '2007-10-14 00:00:00', '10', '在价', 'adsf', 'aaa');
INSERT INTO `book` VALUES ('数据挖掘', '7-301-12345-6', '按时', '综合性图书', '031', '我们的', '2007-12-01 00:00:00', '2007-12-25 00:00:00', '20', '在架', '我们的', '按时');
INSERT INTO `book` VALUES ('高等数学', '777', 'fff', '数理化', '5', '电子工业', '2007-01-05 00:00:00', '2007-06-14 00:00:00', '12.3', '在架', 'adsf', 'gsd');
INSERT INTO `book` VALUES ('java', '888', 'aaa', '文化、科学、教育', '8', '电子工业', '2007-04-04 00:00:00', '2007-10-20 00:00:00', '15.6', '在架', 'cvfdssd', 'asd');
INSERT INTO `book` VALUES ('编译原理', '999', 'bbb', '文化、科学、教育', '9', '人民教育', '2007-02-04 00:00:00', '2007-12-01 00:00:00', '15', '在架', 'sdfg', 'fgs');
INSERT INTO `book` VALUES ('q', 'q', 'q', '马克思列宁主义、毛泽东思想', 'q', 'q', '2016-10-16 00:00:00', '2016-10-16 00:00:00', '1', '在架', 'q', 'q');

-- ----------------------------
-- Table structure for booking
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `user_cardnumber` varchar(20) NOT NULL,
  `bannercode` varchar(30) NOT NULL,
  `bookingdate` datetime DEFAULT NULL,
  PRIMARY KEY (`user_cardnumber`,`bannercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booking
-- ----------------------------
INSERT INTO `booking` VALUES ('0507508214', '05075082', '2007-02-09 00:00:00');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `user_cardnumber` varchar(20) NOT NULL,
  `bannercode` varchar(30) NOT NULL,
  `borrowdate` datetime DEFAULT NULL,
  `receivedate` datetime DEFAULT NULL,
  `renew` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`user_cardnumber`,`bannercode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('000', '000', '2008-01-01 00:00:00', '2008-02-01 00:00:00', '否');
INSERT INTO `borrow` VALUES ('000', '222', '2008-01-01 00:00:00', '2008-02-01 00:00:00', '否');
INSERT INTO `borrow` VALUES ('000', '555', '2007-06-05 00:00:00', '2007-08-05 00:00:00', null);
INSERT INTO `borrow` VALUES ('001', '000', '2008-01-01 00:00:00', '2008-02-01 00:00:00', '否');
INSERT INTO `borrow` VALUES ('001', '555', '2007-12-25 00:00:00', '2008-01-25 00:00:00', '否');
INSERT INTO `borrow` VALUES ('002', '777', '2007-12-25 00:00:00', '2008-01-25 00:00:00', '否');
INSERT INTO `borrow` VALUES ('003', '444', '2007-03-04 00:00:00', '2007-09-04 00:00:00', null);

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `user_name` varchar(10) NOT NULL,
  `psw` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', '123');
INSERT INTO `login` VALUES ('guest', '0507');

-- ----------------------------
-- Table structure for punishment
-- ----------------------------
DROP TABLE IF EXISTS `punishment`;
CREATE TABLE `punishment` (
  `user_cardnumber` varchar(20) NOT NULL,
  `sum_account` float DEFAULT NULL,
  PRIMARY KEY (`user_cardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of punishment
-- ----------------------------
INSERT INTO `punishment` VALUES ('003', '30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(20) DEFAULT NULL,
  `user_sex` varchar(2) DEFAULT NULL,
  `user_status` varchar(20) DEFAULT NULL,
  `user_office` varchar(30) DEFAULT NULL,
  `user_cardnumber` varchar(20) NOT NULL,
  `user_registerdate` datetime DEFAULT NULL,
  `user_canceldate` datetime DEFAULT NULL,
  `user_state` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`user_cardnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('彭世炜', '男', '学生', '医药信息工程学院', '000', '2008-01-01 00:00:00', '2012-01-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('沈佳研', '男', '学生', '医药信息工程学院', '001', '2005-10-01 00:00:00', '2009-10-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('程燕', '女', '学生', '医药信息工程学院', '002', '2006-01-01 00:00:00', '2010-01-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('钟桥生', '男', '学生', '医药信息工程学院', '003', '2005-10-01 00:00:00', '2009-10-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('刘贤崔', '男', '学生', '医药信息工程学院', '004', '2005-10-01 00:00:00', '2009-10-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('萧蔷', '女', '学生', '医药商学院', '123', '2008-01-01 00:00:00', '2012-01-01 00:00:00', '正常');
INSERT INTO `user` VALUES ('外网', '男', '学生', '医药信息工程学院', '1516516516', '2016-11-10 00:00:00', '2020-11-10 00:00:00', '正常');
INSERT INTO `user` VALUES ('小强', '男', '学生', '中药学院', '321', '2008-01-01 00:00:00', '2012-01-01 00:00:00', '正常');
