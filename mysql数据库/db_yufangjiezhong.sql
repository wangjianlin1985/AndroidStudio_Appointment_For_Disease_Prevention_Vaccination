/*
Navicat MySQL Data Transfer

Source Server         : ss
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : db_yufangjiezhong

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-03-01 11:33:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `ctime` varchar(111) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `gname` varchar(255) DEFAULT NULL,
  `simg` varchar(255) DEFAULT NULL,
  `gimg` varchar(255) DEFAULT NULL,
  `time` varchar(111) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `sessionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES ('15', '2', '3', '撒打算SaaS', '李双江', 'http://192.168.0.111:82/1614411452279210.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-02-28 16:59:39', '飒飒', '3');
INSERT INTO `chat` VALUES ('16', '3', '2', '李双江', '撒打算SaaS', 'http://192.168.0.111:82/1614416387932513.jpg', 'http://192.168.0.111:82/1614411452279210.jpg', '2021-02-28 17:00:31', 'sasa', '3');
INSERT INTO `chat` VALUES ('17', '2', '3', '撒打算SaaS', '李双江', 'http://192.168.0.111:82/1614411452279210.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-02-28 17:07:37', 'assasasa', '3');
INSERT INTO `chat` VALUES ('18', '2', '3', '撒打算SaaS', '李双江', 'http://192.168.0.111:82/1614411452279210.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-02-28 17:07:48', 'sasasas', '3');
INSERT INTO `chat` VALUES ('19', '3', '2', '李双江', '撒打算SaaS', 'http://192.168.0.111:82/1614416387932513.jpg', 'http://192.168.0.111:82/1614411452279210.jpg', '2021-02-28 17:12:58', 'sdssa', '3');
INSERT INTO `chat` VALUES ('20', '3', '2', '李双江', '撒打算SaaS', 'http://192.168.0.111:82/1614416387932513.jpg', 'http://192.168.0.111:82/1614411452279210.jpg', '2021-02-28 17:13:01', 'sasa', '3');
INSERT INTO `chat` VALUES ('21', '2', '3', '撒打算SaaS', '李双江', 'http://192.168.0.111:82/1614411452279210.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-02-28 17:13:28', 'sasdsa', '3');
INSERT INTO `chat` VALUES ('22', '2', '3', '撒打算SaaS', '李双江', 'http://192.168.0.111:82/1614411452279210.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-02-28 17:13:31', '阿松大', '3');
INSERT INTO `chat` VALUES ('24', '5', '3', '哈哈', '李双江', 'http://192.168.0.111:82/1614568402764350.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-03-01 11:13:48', '撒飒飒', '4');
INSERT INTO `chat` VALUES ('25', '5', '3', '哈哈', '李双江', 'http://192.168.0.111:82/1614568402764350.jpg', 'http://192.168.0.111:82/1614416387932513.jpg', '2021-03-01 11:13:55', '你好啊', '4');
INSERT INTO `chat` VALUES ('26', '3', '5', '李双江', '哈哈', 'http://192.168.0.111:82/1614416387932513.jpg', 'http://192.168.0.111:82/1614568402764350.jpg', '2021-03-01 11:14:33', '岁数大', '4');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `dec` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('3', '李双江', '口腔科', '主任', '大飒飒大数据集破解撒泼的骄傲破解怕是击破敌军炮击就怕是击破敌军撒泼就击破帕松加的破案经济就哦怕破解苏东坡阿萨萨达', 'http://192.168.0.111:82/1614416387932513.jpg', '111', '123');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `ctime` varchar(111) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '今天进人医院需要测量体温', '最新公告', '2021-02-27 10:52:43');
INSERT INTO `news` VALUES ('2', '测试', '测试', '2021-02-27 10:52:43');
INSERT INTO `news` VALUES ('3', '按时打算将打破佳世达收盘价及配件插件啊啥水平评价结案时间哦is大家怕就是平静怕时间破旧的破案', '测试1', '2021-02-27 10:52:50');
INSERT INTO `news` VALUES ('4', 'sadsad', 'sasdasad', '2021-02-27 10:54:28');
INSERT INTO `news` VALUES ('5', 'sadsadsadsadsasd', 'sasdasad', '2021-02-27 10:54:39');
INSERT INTO `news` VALUES ('6', '阿斯极大时间撒【偶读【哦啊【欧式哦啊是【哦大家【跑【 【】怕啥【科大', '最新疫情公告', '2021-03-01 11:11:37');

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `did` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES ('3', '2', '3');
INSERT INTO `session` VALUES ('4', '5', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'saddas', 'sadsa', 'saddsa', 'dsadsa', '11', 'sasa');
INSERT INTO `user` VALUES ('2', '123', '123', 'http://192.168.0.111:82/1614411452279210.jpg', '撒打算SaaS', '11', '男');
INSERT INTO `user` VALUES ('4', '123456', '123', null, null, null, null);
INSERT INTO `user` VALUES ('5', '346818', '123456', 'http://192.168.0.111:82/1614568402764350.jpg', '哈哈', '12', '男');
