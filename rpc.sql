/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : 192.168.0.110:3306
Source Database       : rpc

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-12-23 11:53:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_users
-- ----------------------------
DROP TABLE IF EXISTS `shop_users`;
CREATE TABLE `shop_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(18) NOT NULL COMMENT '账号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(20) DEFAULT NULL COMMENT '昵称',
  `img` varchar(30) DEFAULT NULL COMMENT '头像',
  `status` enum('0','1') DEFAULT '1' COMMENT '使用状态',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_users
-- ----------------------------
INSERT INTO `shop_users` VALUES ('5', '45454554@qq.com', 'l4OYjda5tf2bl1QMBNA3MQ==', null, null, '1');
INSERT INTO `shop_users` VALUES ('6', '1577121881@qq.com', 'DjjvHqB4UFUfMSykD2gQDg==', null, null, '1');
INSERT INTO `shop_users` VALUES ('7', '1577121881@qq.com', 'rF6VB4S4eIgUoO2+aNpf2w==', null, null, '1');
INSERT INTO `shop_users` VALUES ('8', '1577121881@qq.com', 'NIXs2V9AervoFCYSo84EUQ==', null, null, '1');
INSERT INTO `shop_users` VALUES ('9', '1577121881@qq.com', '9uLzUjLD/reRPrC8HwEpjg==', null, null, '1');
INSERT INTO `shop_users` VALUES ('10', '1577121881@qq.com', 's67Jw55kWqROJAdXHoaqkw==', null, null, '1');
INSERT INTO `shop_users` VALUES ('11', '1577121881@qq.com', 'Qt78B+cvNXW4T8NknpmK6g==', null, null, '1');
INSERT INTO `shop_users` VALUES ('12', '1577121881@qq.com', 'vB+4gxbuedL2DcMzTW/wEA==', null, null, '1');
