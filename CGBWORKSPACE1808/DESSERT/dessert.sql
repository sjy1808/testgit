/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : dessert

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2018-11-26 18:12:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `parentId` int(20) DEFAULT NULL,
  `sort` int(200) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL,
  `createdTime` date DEFAULT NULL,
  `modifiedTime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('2', '销售', null, null, null, null, null);
INSERT INTO `dept` VALUES ('3', '后勤', null, null, null, null, null);
INSERT INTO `dept` VALUES ('4', '采购', null, null, null, null, null);
INSERT INTO `dept` VALUES ('5', '后厨', null, null, null, null, null);
INSERT INTO `dept` VALUES ('6', '财务', null, null, null, null, null);
INSERT INTO `dept` VALUES ('16', '线上销售', '2', '2001', '负责线上销售', '2018-11-24', '2018-11-24');
INSERT INTO `dept` VALUES ('17', '实体店销售', '2', '2002', '实体店销售', '2018-11-24', '2018-11-24');
INSERT INTO `dept` VALUES ('18', '后勤一组', '3', '3001', '后勤的所有事宜', '2018-11-24', '2018-11-24');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  `deptId` int(20) DEFAULT NULL,
  `gender` char(20) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `adress` varchar(30) DEFAULT NULL,
  `deptName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('18', 'sjy', '0a71f72c2979ff1e66d9bd8d0ff31b85', '7d200dff-3101-4aa3-99eb-62ad461bfb9d', null, '2', '男', '申俊洋', '18', '经理', '12155563', '123548', '2018-11-24 14:02:27', '第三方', null);
INSERT INTO `employee` VALUES ('19', 'sss', '6f77421775d385931dbf6a9d38dc2daa', '9db93df6-509f-4dd0-80ff-886480339bbb', null, '3', '男', '都是疯狂老师', '15', '客服', '定时', '顺风顺水', '2018-11-24 14:37:12', '定时', null);
INSERT INTO `employee` VALUES ('20', 'sww', '342408dfb23ba1f1ed1c140d2084930c', 'eb2575ca-a603-469b-8769-942d236012a6', null, '4', 'sd', '时间考察', '15', 'dsvss', '156613', 'sdfas', '2018-11-24 14:58:35', 'dsfsf', null);
INSERT INTO `employee` VALUES ('21', 'she', '834004269eb467f13fca678eb3606833', '73cf0d77-6e0a-4685-9171-48256be1e423', null, '18', 'sdfs', '琪琪', '12', 'sdfs', 'sfs', 'sf', '2018-11-24 15:04:49', 'sf', null);
INSERT INTO `employee` VALUES ('22', 'asf', '40a4eaa4a5bce10dd3209ee094a13283', 'a08cc4ed-1813-4a60-b241-27e67b7b9057', null, '5', '女', '阿萨德', '21', '甜品师', '45646464', '5645455@qq.com', '2018-11-24 16:14:08', '河南郑州', null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '百利甜情人', '290', 'cake', './images/cake/1459337079137.jpg');
INSERT INTO `goods` VALUES ('2', '榴莲飘飘', '177', 'cake', './images/cake/58c4227141bbcf6efe30b5940267a1a9.jpg');
INSERT INTO `goods` VALUES ('3', '朗姆芝士', '277', 'cake', './images/cake/c28932d6886994d259828091a579f744.jpg');
INSERT INTO `goods` VALUES ('4', '小重组', '190', 'cake', './images/cake/02aad7bba254a49e5ee68c589b83cfef.jpg');
INSERT INTO `goods` VALUES ('5', '黑白巧克力慕斯', '166', 'cake', './images/cake/78ad114c07704d96ac2d8123d9ae480c.jpg');
INSERT INTO `goods` VALUES ('6', '黑白巧克力慕斯（千阳号）', '189', 'cake', './images/cake/e7d2b8fb0c791c005d06110adb477ffe.jpg');
INSERT INTO `goods` VALUES ('7', '松仁淡奶（木糖醇）', '333', 'cake', './images/cake/6b8dd4e2c5bd0f908b224ba0abe46ad8.jpg');
INSERT INTO `goods` VALUES ('8', '草浅', '254', 'cake', './images/cake/59954fac59f25d03564b474b1a10e385.jpg');
INSERT INTO `goods` VALUES ('9', '冻慕斯与焗芝士', '133', 'cake', './images/cake/8b1e56924f869afde7dae8243900af8a.jpg');
INSERT INTO `goods` VALUES ('10', '芒果奶油蛋糕', '222', 'cake', './images/cake/f5c184a98afac9e350304232c69b2bc5.jpg');
INSERT INTO `goods` VALUES ('11', '松仁淡奶', '212', 'cake', './images/cake/fe9f6d95e37eed09a253fc8a99525a11.jpg');
INSERT INTO `goods` VALUES ('12', '栗蓉暗香', '218', 'cake', './images/cake/d9271fefbf341ffef634aa7ebfed7ab9.jpg');
INSERT INTO `goods` VALUES ('13', '东方栗融', '168', 'cake', './images/cake/3723e4875bb28d90eb77cbeda8b58f55.jpg');
INSERT INTO `goods` VALUES ('14', '布莱克', '259', 'cake', './images/cake/876769ac33295fb48da37430f85067f5.jpg');
INSERT INTO `goods` VALUES ('15', '核桃斯诺', '208', 'cake', './images/cake/fbfe369538fa7968f7f2e277e9b39ceb.jpg');
INSERT INTO `goods` VALUES ('16', '布朗尼', '199', 'cake', './images/cake/f8d71aa2fbf7ba52c3baa863603747bd.jpg');
INSERT INTO `goods` VALUES ('17', '枣儿', '188', 'cake', './images/cake/a447e5ccf956dcb889fe44674ebf214f.jpg');
INSERT INTO `goods` VALUES ('18', '摩卡', '211', 'cake', './images/cake/505c71f60ac4b3d96744a6bb54d63cb1.jpg');
INSERT INTO `goods` VALUES ('20', '新卡', '256', 'cake', './images/cake/327595e905e1fb3385478b4b6d2253fc.jpg');
INSERT INTO `goods` VALUES ('21', '黑白巧克力慕斯', '256', 'dessert', './images/dessert/bd98be4be1de2edd23694874b3352fd0.jpg');
INSERT INTO `goods` VALUES ('24', '百香果酸乳酪慕斯蛋糕', '198', 'dessert', './images/dessert/d290a164f8824685201f20ebe30aaa69.jpg');
INSERT INTO `goods` VALUES ('25', '深艾尔', '199', 'dessert', './images/dessert/f0b8c71b2fba5ab2a5773595a1c13e32.jpg');
INSERT INTO `goods` VALUES ('26', '黑白巧克力慕斯', '168', 'dessert', './images/dessert/31ad1048931a2871f920a4a69c628fa1.jpg');
INSERT INTO `goods` VALUES ('27', '深爱百利甜情人蛋糕', '199', 'dessert', './images/dessert/887535ff37a336eb09fe99170c9b3f6b.jpg');
INSERT INTO `goods` VALUES ('28', '尽享小切块3+1组合', '200', 'dessert', './images/dessert/b268553ed6640950cead99e5cd5642e7.jpg');
INSERT INTO `goods` VALUES ('29', '6口味切块', '189', 'dessert', './images/dessert/b1a6e87bcf1cb033f7a77d6e44ade49d.jpg');
INSERT INTO `goods` VALUES ('31', '便携冰包-象牙白', '260', 'dessert', './images/dessert/f7643036ea61b99a34dfbbb921b93879.png');
INSERT INTO `goods` VALUES ('32', '爱尔兰咖啡', '208', 'dessert', './images/dessert/d6f73d4a02abd614e6c2b5cfc305021d.jpg');
INSERT INTO `goods` VALUES ('33', '桂圆冰淇淋蛋糕', '208', 'dessert', './images/dessert/6d3698893ae88a0a391f9b90dd02335d.jpg');
INSERT INTO `goods` VALUES ('34', '清境', '218', 'dessert', './images/dessert/1cc25b8c3296c4a8e7cc51b0a385e731.jpg');
INSERT INTO `goods` VALUES ('35', '黑方', '208', 'dessert', './images/dessert/96a6ce52ffe1339daf51d03caad48707.jpg');
INSERT INTO `goods` VALUES ('36', '新马斯卡彭-咖啡软芝士蛋糕', '268', 'dessert', './images/dessert/56222ace4ddc9d661467ce115f6b7a89.jpg');
INSERT INTO `goods` VALUES ('37', '重组', '239', 'dessert', './images/dessert/b97c755b92ab5a0791cd05b16e04ee18.jpg');
INSERT INTO `goods` VALUES ('38', '抹茶和栗', '239', 'dessert', './images/dessert/4012f756d6319a7a5f45aba2e23ea637.jpg');
INSERT INTO `goods` VALUES ('39', '心语心愿', '218', 'dessert', './images/dessert/c428279ffac4d47fd774751d29e0cda9.jpg');
INSERT INTO `goods` VALUES ('40', '杏仁克鲁兹', '228', 'dessert', './images/dessert/779ffd7cec8c44e24ea0ce509306fe20.jpg');
INSERT INTO `goods` VALUES ('41', '榛子巧克力软欧', '68', 'bread', './images/bread/b92c952a6577d37d9b6fa39403822ace.jpg');
INSERT INTO `goods` VALUES ('42', '红糖红枣桂圆软欧', '66', 'bread', './images/bread/2665680d079329234b1c999ab5267bdd.jpg');
INSERT INTO `goods` VALUES ('43', '北海道吐司', '58', 'bread', './images/bread/784496196c211a6237c4cdc3fbbd516a.jpg');
INSERT INTO `goods` VALUES ('44', '阳光葡萄卷', '59', 'bread', './images/bread/f05d5aeaf79a28f303cd00feeade8efc.jpg');
INSERT INTO `goods` VALUES ('45', '卜壳吐司', '35', 'bread', './images/bread/4abe09e65cf5095359ce9aebdaea4f54.jpg');
INSERT INTO `goods` VALUES ('46', '卜壳吐司', '6', 'bread', './images/bread/9e335de3e3cff00c0fb683f918b575a0.jpg');
INSERT INTO `goods` VALUES ('47', '玫瑰吐司', '5', 'bread', './images/bread/cfded09f3ed4c73b615feb887c29efd4.jpg');
INSERT INTO `goods` VALUES ('48', '蓝莓丹麦', '8', 'bread', './images/bread/3ab42e3ed23dc2d31b3513eb3341ded4.jpg');
INSERT INTO `goods` VALUES ('49', '巴西挂耳咖啡', '99', 'coffee', './images/milky%20tea/3eba02fc2f81e1413274316bc362100b.jpg');
INSERT INTO `goods` VALUES ('50', '耶加雪菲挂耳咖啡', '99', 'coffee', './images/milky%20tea/016870f84fb3bab38f0a09c8aed39b2a.jpg');
INSERT INTO `goods` VALUES ('51', '西达摩挂耳咖啡', '88', 'coffee', './images/milky%20tea/5f4b6ae847d1438e2aaad33c53555508.jpg');
INSERT INTO `goods` VALUES ('52', '巴布亚新几内亚挂耳咖啡', '99', 'coffee', './images/milky%20tea/ca0fab744768f2f67a33f60a2d7aa2ee.jpg');
INSERT INTO `goods` VALUES ('53', '巴西挂耳咖啡盒装', '99', 'coffee', './images/milky%20tea/0d607c3efdc5ef65e01d5f931b70cf5a.jpg');
INSERT INTO `goods` VALUES ('55', '耶加雪菲挂耳咖啡盒装', '78', 'coffee', './images/milky%20tea/16cb42e06298bef3e660a0e39972b791.jpg');
INSERT INTO `goods` VALUES ('56', '西达摩挂耳咖啡盒装', '88', 'coffee', './images/milky%20tea/9ab74778cf923c673a861c1026203898.jpg');
INSERT INTO `goods` VALUES ('57', '巴布亚新几内亚盒装', '89', 'coffee', './images/milky%20tea/ff7e0b38a1201951a24c400012a0ff84.jpg');
INSERT INTO `goods` VALUES ('58', '四口味挂耳咖啡混合装', '88', 'coffee', './images/milky%20tea/29d9524f931636ec68689ef5227f965f.jpg');
INSERT INTO `goods` VALUES ('59', '原味牛乳冰淇淋', '36', 'ice cream', './images/ice%20cream/4d839ee123f383d1fd13c47967412bf7.jpg');
INSERT INTO `goods` VALUES ('60', '夏日-Affogato组合', '29', 'ice cream', './images/ice%20cream/c14bd544432cd679126c51fd95da7288.jpg');
INSERT INTO `goods` VALUES ('61', '荔枝冰淇淋', '35', 'ice cream', './images/ice%20cream/4d839ee123f383d1fd13c47967412bf7.jpg');
INSERT INTO `goods` VALUES ('62', '拿铁冰淇淋', '33', 'ice cream', './images/ice%20cream/221a39cb2e019ce02d7229c901e18233.jpg');
INSERT INTO `goods` VALUES ('63', '榴莲冰淇淋', '38', 'ice cream', './images/ice%20cream/e5bef17b22763a8fdd632916cf268843.jpg');
INSERT INTO `goods` VALUES ('64', '蓝莓冰淇淋', '49', 'ice cream', './images/ice%20cream/e5bef17b22763a8fdd632916cf268843.jpg');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  `count` int(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `money` double DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `note` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'ad', '121', null, null, '121', '1231', null, null);

-- ----------------------------
-- Table structure for `order_goods`
-- ----------------------------
DROP TABLE IF EXISTS `order_goods`;
CREATE TABLE `order_goods` (
  `id` int(11) NOT NULL,
  `orders_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `shopcart`
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `imagesurl` varchar(200) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcart
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `mobile` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `createdTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', 'pszz', '9c8910fe0266f4e30ad8575481181ab0', null, '60a7d7eb-ac19-49bf-80ba-32d8fc75c0c7', 'da', '1564561', 'da', '2018-11-26 10:11:25');
INSERT INTO `user` VALUES ('5', 'pol', 'fd3d53435cc4745daa2743efba386969', null, '5ff8f15d-cede-4f0d-a958-4468aeffd5e7', 'dad', '424ada', 'dad', '2018-11-26 12:08:19');
INSERT INTO `user` VALUES ('6', 'poi', '8ed01651bb853c835755487c81f87708', null, 'd4faf110-30fe-4c56-aebc-40bb58bc99de', 'dad', 'fa', 'adw', '2018-11-26 12:11:18');
INSERT INTO `user` VALUES ('7', 'pok', '81d1704225de09be48962731fde7ab7b', null, '375ede50-69d5-464d-878c-83803a460210', 'sdf', 'fds', 'dsf', '2018-11-26 12:12:07');
INSERT INTO `user` VALUES ('8', 'uio', '2dfe87a536e7122fd16ccb057392c517', null, '86630f1b-739e-4132-a28f-38641472339c', 'dad', 'd', 'dad', '2018-11-26 12:19:05');
INSERT INTO `user` VALUES ('9', 'put', '07ba7136b4b2d95ae17d54e9d1425988', null, '4b2a5d1a-7d48-43f4-a058-6f7469e0e5a7', 'dad', 'dad', 'ada', '2018-11-26 14:08:40');
INSERT INTO `user` VALUES ('10', 'out', '8ac8b4d2507f44e339b1ef68b687ad62', null, '1d3fec30-a742-4f11-8f0a-9f5c50b97f22', 'da', 'dad', 'dad', '2018-11-26 14:09:20');
INSERT INTO `user` VALUES ('11', 'kkk', '791ebd8aa6b9ba30b88aecef7a86f555', null, '2afe551d-ee50-4eb4-a79b-fad5d4ec03c1', null, null, null, '2018-11-26 16:40:33');
INSERT INTO `user` VALUES ('12', 'ooo', '4cf60e2fbd58f9c62f858da5f3563462', null, 'afba20d5-e1af-458c-9925-5fdd0ba1497e', null, null, null, '2018-11-26 16:43:31');
INSERT INTO `user` VALUES ('13', 'uuu', 'badd9d82148c113d9c4de8bb39c516f0', null, '23a2adde-d062-421f-b12d-8c77e762ff95', null, null, null, '2018-11-26 16:46:49');

-- ----------------------------
-- Table structure for `user_orders`
-- ----------------------------
DROP TABLE IF EXISTS `user_orders`;
CREATE TABLE `user_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `orders_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_orders
-- ----------------------------
