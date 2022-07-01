/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : ssims

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 02/07/2022 02:13:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) NOT NULL COMMENT '客户姓名',
  `phone` varchar(30) NOT NULL COMMENT '客户电话',
  `address` varchar(30) DEFAULT NULL COMMENT '客户居住地址',
  `record` varchar(255) DEFAULT NULL COMMENT '业务联系记录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='客户表';

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) NOT NULL COMMENT '员工姓名',
  `sex` varchar(5) NOT NULL COMMENT '员工性别',
  `age` smallint DEFAULT NULL COMMENT '员工年龄',
  `native_place` varchar(30) DEFAULT NULL COMMENT '员工籍贯',
  `education` varchar(30) DEFAULT NULL COMMENT '员工学历',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='员工表';

-- ----------------------------
-- Table structure for saloon
-- ----------------------------
DROP TABLE IF EXISTS `saloon`;
CREATE TABLE `saloon` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `model` varchar(30) NOT NULL COMMENT '轿车型号',
  `color` varchar(30) NOT NULL COMMENT '轿车颜色',
  `manufacturer` varchar(30) NOT NULL COMMENT '轿车生产厂家',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '轿车生产日期',
  `price` int unsigned DEFAULT NULL COMMENT '轿车价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='轿车信息表';

-- ----------------------------
-- Table structure for saloon_sales
-- ----------------------------
DROP TABLE IF EXISTS `saloon_sales`;
CREATE TABLE `saloon_sales` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `saloon_id` bigint unsigned NOT NULL COMMENT '轿车id',
  `employee_id` bigint unsigned NOT NULL COMMENT '员工id',
  `customer_id` bigint unsigned NOT NULL COMMENT '客户id',
  `sales_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '销售日期',
  PRIMARY KEY (`id`),
  KEY `saloon_id` (`saloon_id`),
  KEY `employee_id` (`employee_id`),
  KEY `customers_id` (`customer_id`),
  CONSTRAINT `saloon_sales_ibfk_1` FOREIGN KEY (`saloon_id`) REFERENCES `saloon` (`id`),
  CONSTRAINT `saloon_sales_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`),
  CONSTRAINT `saloon_sales_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='轿车销售信息表';

SET FOREIGN_KEY_CHECKS = 1;
