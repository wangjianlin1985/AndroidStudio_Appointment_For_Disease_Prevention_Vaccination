/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.6
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost:3306
 Source Schema         : db_yufangjiezhong

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 13/10/2021 01:19:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `ctime` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (3, 2, '2021-10-20', '麻疹疫苗');
INSERT INTO `appointment` VALUES (4, 2, '2021-10-25', '乙肝疫苗');

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL,
  `gid` int(11) NULL DEFAULT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `simg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sessionid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (29, 2, 3, '张苗苗', '李双江', 'http://192.168.1.5:82/514015810405.jpg', 'http://192.168.1.5:82/510851041.jpg', '2021-10-13 00:51:52', '你好吗，医生，我已经预约了疫苗接种', 3);
INSERT INTO `chat` VALUES (30, 2, 3, '张苗苗', '李双江', 'http://192.168.1.5:82/514015810405.jpg', 'http://192.168.1.5:82/510851041.jpg', '2021-10-13 00:52:05', '请问接种时间是几点开始几点结束？', 3);
INSERT INTO `chat` VALUES (31, 3, 2, '李双江', '张苗苗', 'http://192.168.1.5:82/510851041.jpg', 'http://192.168.1.5:82/514015810405.jpg', '2021-10-13 01:03:00', '早上8点开始，晚上6点结束', 3);
INSERT INTO `chat` VALUES (32, 3, 2, '李双江', '张苗苗', 'http://192.168.1.5:82/510851041.jpg', 'http://192.168.1.5:82/514015810405.jpg', '2021-10-13 01:03:11', '请合理安排时间哦', 3);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (3, '李双江', '疫苗科', '主任', '负责各种疫苗的接种预约工作。', 'http://192.168.1.5:82/510851041.jpg', '111', '123');
INSERT INTO `doctor` VALUES (4, '王天竹', '传染科', '一级专家', '多年疾病控制经验，精通各种传染病治疗', 'http://192.168.1.5:82/1614416387932513.jpg', '222', '123');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ctime` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '今天进人医院需要测量体温', '最新公告', '2021-02-27 10:52:43');
INSERT INTO `news` VALUES (2, '测试', '测试', '2021-02-27 10:52:43');
INSERT INTO `news` VALUES (3, '按时打算将打破佳世达收盘价及配件插件啊啥水平评价结案时间哦is大家怕就是平静怕时间破旧的破案', '测试1', '2021-02-27 10:52:50');
INSERT INTO `news` VALUES (4, 'sadsad', 'sasdasad', '2021-02-27 10:54:28');
INSERT INTO `news` VALUES (5, 'sadsadsadsadsasd', 'sasdasad', '2021-02-27 10:54:39');
INSERT INTO `news` VALUES (6, '最近新冠病毒肆虐全球，请大家少出门和戴好口罩，勤洗手！', '最新疫情公告', '2021-03-01 11:11:37');
INSERT INTO `news` VALUES (7, 'sadsadsadsadsasd', '嘎发', '2021-10-13 01:09:05');

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `did` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES (3, 2, 3);
INSERT INTO `session` VALUES (4, 5, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'saddas', 'sadsa', 'http://192.168.1.5:82/5108510851.jpg', '王晓婷', 11, '女');
INSERT INTO `user` VALUES (2, '123', '123', 'http://192.168.1.5:82/1634058815224558.jpg', '张苗苗', 21, '女');
INSERT INTO `user` VALUES (4, '123456', '123', 'http://192.168.1.5:82/1614411452279210.jpg', '张霞', 22, '男');
INSERT INTO `user` VALUES (5, '346818', '123456', 'http://192.168.1.5:82/0810147184158141.jpg', '李曦', 12, '男');

SET FOREIGN_KEY_CHECKS = 1;
