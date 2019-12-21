/*
Navicat MySQL Data Transfer

Source Server         :  mylocal
Source Server Version : 50641
Source Host           : localhost:3306
Source Database       : 08e-cms

Target Server Type    : MYSQL
Target Server Version : 50641
File Encoding         : 65001

Date: 2019-12-21 10:58:55
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `cms_complain`
-- ----------------------------
DROP TABLE IF EXISTS `cms_complain`;
CREATE TABLE `cms_complain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `complain_type` int(11) DEFAULT NULL,
  `compain_option` varchar(32) DEFAULT NULL COMMENT '被投诉的内容',
  `src_url` varchar(128) DEFAULT NULL,
  `picture` varchar(128) DEFAULT NULL,
  `content` varchar(256) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cms_complain
-- ----------------------------
INSERT INTO cms_complain VALUES ('1', '136', '0', '2', '1,3', 'https://v4.bootcss.com/docs/4.3/components/forms/', null, '测试', 'zhuzg@sohu.com', '136834512231', '2019-12-21');
INSERT INTO cms_complain VALUES ('2', '136', '0', '1', '1,2', 'https://www.toutiao.com/ch/news_tech/', '20191221/18d5c2ec-380b-43da-bdf7-2c263b315c4e.png', 'sdjdsjsdjhkdsjhkdsjhkdsjhk', 'zha@nice.cn', 'r3445676', '2019-12-21');
INSERT INTO cms_complain VALUES ('3', '136', '0', '1', '1,2', 'https://www.toutiao.com/ch/news_tech/', '20191221/46b2a61e-466e-4999-ab05-a9b72a3dcf06.png', 'sdjdsjsdjhkdsjhkdsjhkdsjhk', 'zha@nice.cn', 'r3445676', '2019-12-21');
INSERT INTO cms_complain VALUES ('4', '142', '68', '1', '1,2', 'https://v4.bootcss.com/docs/4.3/components/forms/', '20191221/a8b7df55-f154-4b08-9d4a-bc02c3db1981.png', 'sddsdsds', 'ddffd@sadfn.cn', '455y66767', '2019-12-21');
