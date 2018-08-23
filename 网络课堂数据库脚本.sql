-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.14-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 networkclass 的数据库结构
CREATE DATABASE IF NOT EXISTS `networkclass` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `networkclass`;

-- 导出  表 networkclass.nc_admin 结构
CREATE TABLE IF NOT EXISTS `nc_admin` (
  `admin_id` varchar(50) NOT NULL COMMENT '管理员ID',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员姓名',
  `admin_password` varchar(50) DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  networkclass.nc_admin 的数据：~0 rows (大约)
DELETE FROM `nc_admin`;
/*!40000 ALTER TABLE `nc_admin` DISABLE KEYS */;
INSERT INTO `nc_admin` (`admin_id`, `admin_name`, `admin_password`) VALUES
	('admin', '警察', '123');
/*!40000 ALTER TABLE `nc_admin` ENABLE KEYS */;

-- 导出  表 networkclass.nc_choose 结构
CREATE TABLE IF NOT EXISTS `nc_choose` (
  `choose_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课ID',
  `choose_course_id` varchar(50) DEFAULT NULL COMMENT '课程ID',
  `choose_student_id` varchar(50) DEFAULT NULL COMMENT '学生ID',
  PRIMARY KEY (`choose_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  networkclass.nc_choose 的数据：~4 rows (大约)
DELETE FROM `nc_choose`;
/*!40000 ALTER TABLE `nc_choose` DISABLE KEYS */;
INSERT INTO `nc_choose` (`choose_id`, `choose_course_id`, `choose_student_id`) VALUES
	(1, 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', 'stu'),
	(2, '2ab1b484-efff-4feb-be80-2b07760f8e82', 'stu'),
	(11, '69eb45a5-f745-4e7a-965b-cef7c6fd6ff0', 'stu'),
	(13, '089ecc84-71e0-48b6-80c4-964eadf6c442', 'stu');
/*!40000 ALTER TABLE `nc_choose` ENABLE KEYS */;

-- 导出  表 networkclass.nc_course 结构
CREATE TABLE IF NOT EXISTS `nc_course` (
  `course_id` varchar(50) NOT NULL COMMENT '课程ID',
  `course_name` varchar(50) DEFAULT NULL COMMENT '课程名',
  `course_teacher_id` varchar(50) DEFAULT NULL COMMENT '任课教师ID',
  `course_teacher_name` varchar(50) DEFAULT NULL COMMENT '任课教师姓名',
  `course_intro` text DEFAULT NULL COMMENT '课程简介',
  `course_notice` text DEFAULT NULL COMMENT '课程公告',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  networkclass.nc_course 的数据：~3 rows (大约)
DELETE FROM `nc_course`;
/*!40000 ALTER TABLE `nc_course` DISABLE KEYS */;
INSERT INTO `nc_course` (`course_id`, `course_name`, `course_teacher_id`, `course_teacher_name`, `course_intro`, `course_notice`) VALUES
	('089ecc84-71e0-48b6-80c4-964eadf6c442', '大学英语', 'tea', '叶鑫', '适合高中英语学习者、大学生准备考四六级的学生，也可作为考研的辅导材料。内容新颖，选材灵活多样，是大学生的良师益友。本刊主要为教学辅导类刊物，一般不登载学术性文章。\n另每半年出版一期《大学英语》（学术版），征稿范围包括：语言学研究和语言对比研究、翻译研究和英美文学研究、多媒体教学设计与实践、大学英语语言应用能力培养途径、大学英语课程体系改革、大学英语课堂教学方法。接受电子版投稿。', NULL),
	('563d9200-2a76-4b3b-aabb-40dece89c4c1', '大学物理', 'li123', '李老师', '大学物理，是大学理工科类的一门基础课程，通过课程的学习，使学生熟悉自然界物质的结构，性质，相互作用及其运动的基本规律，为后继专业基础与专业课程的学习及进一步获取有关知识奠定必要的物理基础。但工科专业以力学基础和电磁学为主要授课。', NULL),
	('ef13ed43-dd57-473b-9b28-fd76be91aaa8', '高等数学', 'tea', '叶鑫', '在中国理工科各类专业的学生（数学专业除外，数学专业学数学分析），学的数学较难，课本常称“高等数学”；文史科各类专业的学生，学的数学稍微浅一些，课本常称“微积分”。理工科的不同专业，文史科的不同专业，深浅程度又各不相同。研究变量的是高等数学，可高等数学并不只研究变量。至于与“高等数学”相伴的课程通常有：线性代数（数学专业学高等代数），概率论与数理统计（有些数学专业分开学）。', '老师有事，本周停课一周。');
/*!40000 ALTER TABLE `nc_course` ENABLE KEYS */;

-- 导出  表 networkclass.nc_courseware 结构
CREATE TABLE IF NOT EXISTS `nc_courseware` (
  `courseware_id` varchar(50) DEFAULT NULL COMMENT '课件ID',
  `courseware_name` text DEFAULT NULL COMMENT '课件名',
  `courseware_teacher` text DEFAULT NULL COMMENT '上传教师',
  `courseware_course` text DEFAULT NULL COMMENT '归属课程',
  `courseware_describe` text DEFAULT NULL COMMENT '课件描述',
  `courseware_time` datetime DEFAULT NULL COMMENT '上传时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课件';

-- 正在导出表  networkclass.nc_courseware 的数据：~3 rows (大约)
DELETE FROM `nc_courseware`;
/*!40000 ALTER TABLE `nc_courseware` DISABLE KEYS */;
INSERT INTO `nc_courseware` (`courseware_id`, `courseware_name`, `courseware_teacher`, `courseware_course`, `courseware_describe`, `courseware_time`) VALUES
	('d7e2f14f-7bb3-4b6e-b9cf-41a979ad0ca8', '高数课件1.txt', '叶鑫', '高等数学', '高数课件_第一部分', '2018-04-11 15:17:50'),
	('f24ec745-83a4-48a7-b381-3f98e10d542e', '1411050110叶鑫-开题报告.doc', '叶鑫', '高等数学', '高数课件_第二部分', '2018-04-11 15:22:47'),
	('290825bb-ea3f-4de5-934d-6b1b30c7589a', '1.sql', '叶鑫', '高等数学', '数据库脚本', '2018-04-13 13:32:36');
/*!40000 ALTER TABLE `nc_courseware` ENABLE KEYS */;

-- 导出  表 networkclass.nc_forum 结构
CREATE TABLE IF NOT EXISTS `nc_forum` (
  `forum_id` varchar(50) DEFAULT NULL COMMENT '帖子ID',
  `forum_course_id` varchar(50) DEFAULT NULL COMMENT '帖子归属课程ID',
  `forum_user_id` varchar(50) DEFAULT NULL COMMENT '发帖者ID',
  `forum_title` text DEFAULT NULL COMMENT '帖子标题',
  `forum_content` text DEFAULT NULL COMMENT '帖子内容',
  `forum_time` datetime DEFAULT NULL COMMENT '发帖时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='论坛帖子';

-- 正在导出表  networkclass.nc_forum 的数据：~2 rows (大约)
DELETE FROM `nc_forum`;
/*!40000 ALTER TABLE `nc_forum` DISABLE KEYS */;
INSERT INTO `nc_forum` (`forum_id`, `forum_course_id`, `forum_user_id`, `forum_title`, `forum_content`, `forum_time`) VALUES
	('ee1f9c32-48c9-4816-a183-076e24d3192f', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', 'stu', '新帖子', '我的第一个帖子！\n123456545445', '2018-03-21 13:34:05'),
	('046544cf-40b2-4b02-a3dc-246cd5118cfa', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', 'tea', '4324322', '213123', '2018-04-07 18:21:27'),
	('5865c2dc-5388-4cd4-964e-156d10fe4fd8', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', 'stu', '测试帖1', '新的测试内容', '2018-04-24 13:06:33');
/*!40000 ALTER TABLE `nc_forum` ENABLE KEYS */;

-- 导出  表 networkclass.nc_homework 结构
CREATE TABLE IF NOT EXISTS `nc_homework` (
  `homework_id` varchar(50) DEFAULT NULL COMMENT '作业ID',
  `homework_name` varchar(50) DEFAULT NULL COMMENT '作业名',
  `homework_student_id` varchar(50) DEFAULT NULL COMMENT '学生ID',
  `homework_course_id` varchar(50) DEFAULT NULL COMMENT '课程ID',
  `homework_time` datetime DEFAULT NULL COMMENT '上传时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='作业';

-- 正在导出表  networkclass.nc_homework 的数据：~3 rows (大约)
DELETE FROM `nc_homework`;
/*!40000 ALTER TABLE `nc_homework` DISABLE KEYS */;
INSERT INTO `nc_homework` (`homework_id`, `homework_name`, `homework_student_id`, `homework_course_id`, `homework_time`) VALUES
	('9d199e73-649b-4f19-a222-94a8482e6ab8', '1.sql', 'stu', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '2018-04-16 14:55:09'),
	('c2e49f4f-83db-435b-ab84-503485dd23bb', '1411050110叶鑫-开题报告.doc', 'stu', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '2018-04-16 14:57:36'),
	('8c8ffb49-e8ce-4eb0-ab20-e194d505b273', '20180317130647.png', 'stu', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '2018-04-16 15:41:31');
/*!40000 ALTER TABLE `nc_homework` ENABLE KEYS */;

-- 导出  表 networkclass.nc_notice 结构
CREATE TABLE IF NOT EXISTS `nc_notice` (
  `notice_id` varchar(50) DEFAULT NULL COMMENT '公告ID',
  `notice_course_id` varchar(50) DEFAULT NULL COMMENT '公告归属课程ID',
  `notice_content` text DEFAULT NULL COMMENT '公告内容',
  `notice_time` datetime DEFAULT NULL COMMENT '发布公告时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程公告';

-- 正在导出表  networkclass.nc_notice 的数据：~4 rows (大约)
DELETE FROM `nc_notice`;
/*!40000 ALTER TABLE `nc_notice` DISABLE KEYS */;
INSERT INTO `nc_notice` (`notice_id`, `notice_course_id`, `notice_content`, `notice_time`) VALUES
	('e368782a-28ae-48ed-9eea-5547d852b06f', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '2131sasASa13123131aaaaaaaaaaaaaaaaaaaaaaaaaa1111\n11111111112323131321434qwe23131231aadaddasdadass', '2018-04-07 22:00:46'),
	('f482d7e7-988d-494b-92b8-0fe8510c8c75', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '2131sasASa13123131aaaaaaaaaaaaaaaaaaaaaaaaaa1111\n11111111112323131321434qwe23131231aadaddasdadass1111111111', '2018-04-11 11:28:05'),
	('ec8f66ad-a7e2-4701-8719-189a6c22cc8b', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '老师有事，停课一周！', '2018-04-11 11:28:19'),
	('fa78858a-99f0-4a79-9410-0f2f04577499', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', '老师有事，本周停课一周。', '2018-04-24 13:03:27');
/*!40000 ALTER TABLE `nc_notice` ENABLE KEYS */;

-- 导出  表 networkclass.nc_record 结构
CREATE TABLE IF NOT EXISTS `nc_record` (
  `record_id` varchar(50) NOT NULL COMMENT '记录ID',
  `record_course_id` varchar(50) DEFAULT NULL COMMENT '课程ID',
  `record_deliver_id` varchar(50) DEFAULT NULL COMMENT '发送者ID',
  `record_deliver_name` varchar(50) DEFAULT NULL COMMENT '发送者名字',
  `record_receiver_id` varchar(50) DEFAULT NULL COMMENT '接受者ID',
  `record_receiver_name` varchar(50) DEFAULT NULL COMMENT '接收者名字',
  `record_message` text DEFAULT NULL COMMENT '消息内容',
  `record_time` datetime DEFAULT NULL COMMENT '发送时间',
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息记录';

-- 正在导出表  networkclass.nc_record 的数据：~1 rows (大约)
DELETE FROM `nc_record`;
/*!40000 ALTER TABLE `nc_record` DISABLE KEYS */;
INSERT INTO `nc_record` (`record_id`, `record_course_id`, `record_deliver_id`, `record_deliver_name`, `record_receiver_id`, `record_receiver_name`, `record_message`, `record_time`) VALUES
	('59480b8c-9165-4956-9fad-abda773b3785', 'ef13ed43-dd57-473b-9b28-fd76be91aaa8', 'stu', '小明', 'tea', '叶鑫', '老师好', '2018-04-16 15:43:02');
/*!40000 ALTER TABLE `nc_record` ENABLE KEYS */;

-- 导出  表 networkclass.nc_student 结构
CREATE TABLE IF NOT EXISTS `nc_student` (
  `student_id` varchar(50) NOT NULL COMMENT '学生ID',
  `student_name` varchar(50) DEFAULT NULL COMMENT '学生姓名',
  `student_password` varchar(50) DEFAULT NULL COMMENT '学生密码',
  `student_gender` varchar(50) DEFAULT NULL COMMENT '学生性别',
  `student_birthday` varchar(50) DEFAULT NULL COMMENT '学生生日',
  `student_signature_line` text DEFAULT '说点什么吧...' COMMENT '学生签名档',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  networkclass.nc_student 的数据：~0 rows (大约)
DELETE FROM `nc_student`;
/*!40000 ALTER TABLE `nc_student` DISABLE KEYS */;
INSERT INTO `nc_student` (`student_id`, `student_name`, `student_password`, `student_gender`, `student_birthday`, `student_signature_line`) VALUES
	('stu', '小明', '123', '男', '1996-01-09', '这是我的个人签名。');
/*!40000 ALTER TABLE `nc_student` ENABLE KEYS */;

-- 导出  表 networkclass.nc_teacher 结构
CREATE TABLE IF NOT EXISTS `nc_teacher` (
  `teacher_id` varchar(50) NOT NULL COMMENT '教师ID',
  `teacher_name` varchar(50) DEFAULT NULL COMMENT '教师姓名',
  `teacher_password` varchar(50) DEFAULT NULL COMMENT '教师密码',
  `teacher_gender` varchar(50) DEFAULT NULL COMMENT '教师性别',
  `teacher_birthday` varchar(50) DEFAULT NULL COMMENT '教师生日',
  `teacher_signature_line` text DEFAULT '说点什么吧...' COMMENT '学生签名档',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  networkclass.nc_teacher 的数据：~3 rows (大约)
DELETE FROM `nc_teacher`;
/*!40000 ALTER TABLE `nc_teacher` DISABLE KEYS */;
INSERT INTO `nc_teacher` (`teacher_id`, `teacher_name`, `teacher_password`, `teacher_gender`, `teacher_birthday`, `teacher_signature_line`) VALUES
	('li123', '李老师', '123', NULL, NULL, '说点什么吧...'),
	('tea', '叶鑫', '123', '男', '1996-01-10', '我是人民教师。'),
	('zhang', '章老师', '123', NULL, NULL, '说点什么吧...');
/*!40000 ALTER TABLE `nc_teacher` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
