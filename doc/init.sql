# Dump of table WS_TASk
# ------------------------------------------------------------

DROP TABLE IF EXISTS `SHIRO_ACCOUNT`;

CREATE TABLE `SHIRO_ACCOUNT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginName` varchar(64) DEFAULT NULL,
  `userId` varchar(64) DEFAULT NULL,
  `nickName` varchar(64) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `allowInternet` BIT DEFAULT FALSE,
  `createdTime` timestamp NULL DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `SHIRO_ROLE`;

CREATE TABLE `SHIRO_ROLE` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(64) DEFAULT NULL,
   `description` varchar(255) DEFAULT NULL,
   `permission` varchar(255) DEFAULT NULL,
   `createdTime` timestamp NULL DEFAULT NULL,
   `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `SHIRO_PERMISSION`;

CREATE TABLE `SHIRO_PERMISSION` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(64) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    `permission` varchar(255) DEFAULT NULL,
    `createdTime` timestamp NULL DEFAULT NULL,
    `updateTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
