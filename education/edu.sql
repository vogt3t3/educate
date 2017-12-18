-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.34-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 educate 的数据库结构
CREATE DATABASE IF NOT EXISTS `educate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `educate`;


-- 导出  表 educate.exam_paper_judge 结构
CREATE TABLE IF NOT EXISTS `exam_paper_judge` (
  `exam_paper_id` int(11) NOT NULL COMMENT '试卷编号',
  `judge_id` int(11) NOT NULL COMMENT '题目编号',
  PRIMARY KEY (`exam_paper_id`,`judge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷表与判断题表的关联关系表';

-- 正在导出表  educate.exam_paper_judge 的数据：~1 rows (大约)
DELETE FROM `exam_paper_judge`;
/*!40000 ALTER TABLE `exam_paper_judge` DISABLE KEYS */;
INSERT INTO `exam_paper_judge` (`exam_paper_id`, `judge_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `exam_paper_judge` ENABLE KEYS */;


-- 导出  表 educate.exam_paper_select 结构
CREATE TABLE IF NOT EXISTS `exam_paper_select` (
  `exam_paper_id` int(11) NOT NULL COMMENT '试卷编号',
  `select_id` int(11) NOT NULL COMMENT '题目编号',
  PRIMARY KEY (`exam_paper_id`,`select_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='试卷表和选择题表关系表';

-- 正在导出表  educate.exam_paper_select 的数据：~1 rows (大约)
DELETE FROM `exam_paper_select`;
/*!40000 ALTER TABLE `exam_paper_select` DISABLE KEYS */;
INSERT INTO `exam_paper_select` (`exam_paper_id`, `select_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `exam_paper_select` ENABLE KEYS */;


-- 导出  表 educate.section_test_judge 结构
CREATE TABLE IF NOT EXISTS `section_test_judge` (
  `section_test_id` int(11) NOT NULL COMMENT '章节测试编号',
  `judge_id` int(11) NOT NULL COMMENT '题目编号',
  PRIMARY KEY (`section_test_id`,`judge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='章节测试表和判断题表的关系表';

-- 正在导出表  educate.section_test_judge 的数据：~0 rows (大约)
DELETE FROM `section_test_judge`;
/*!40000 ALTER TABLE `section_test_judge` DISABLE KEYS */;
/*!40000 ALTER TABLE `section_test_judge` ENABLE KEYS */;


-- 导出  表 educate.section_test_select 结构
CREATE TABLE IF NOT EXISTS `section_test_select` (
  `section_test_id` int(11) NOT NULL COMMENT '章节测试编号',
  `select_id` int(11) NOT NULL COMMENT '题目编号',
  PRIMARY KEY (`section_test_id`,`select_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='章节测试表和选择题表的关系表';

-- 正在导出表  educate.section_test_select 的数据：~0 rows (大约)
DELETE FROM `section_test_select`;
/*!40000 ALTER TABLE `section_test_select` DISABLE KEYS */;
/*!40000 ALTER TABLE `section_test_select` ENABLE KEYS */;


-- 导出  表 educate.student_course 结构
CREATE TABLE IF NOT EXISTS `student_course` (
  `student_id` int(11) NOT NULL COMMENT '学生编号',
  `course_id` int(11) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`student_id`,`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生表和课程表的关系表';

-- 正在导出表  educate.student_course 的数据：~6 rows (大约)
DELETE FROM `student_course`;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` (`student_id`, `course_id`) VALUES
	(1, 1),
	(1, 2),
	(2, 1),
	(2, 2),
	(3, 1),
	(3, 2);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;


-- 导出  表 educate.t_apply_know 结构
CREATE TABLE IF NOT EXISTS `t_apply_know` (
  `apply_know_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名须知编号',
  `enroll_id` int(11) DEFAULT NULL COMMENT '招生编号',
  `apply_know_title` varchar(50) NOT NULL COMMENT '报名须知标题',
  `apply_know_content` varchar(200) NOT NULL COMMENT '报名须知内容',
  `apply_know_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`apply_know_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='报名须知表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_apply_know 的数据：~2 rows (大约)
DELETE FROM `t_apply_know`;
/*!40000 ALTER TABLE `t_apply_know` DISABLE KEYS */;
INSERT INTO `t_apply_know` (`apply_know_id`, `enroll_id`, `apply_know_title`, `apply_know_content`, `apply_know_delete`) VALUES
	(1, 1001, '云教育', '云教育', 1),
	(2, 1002, '报名须知及注意事项', '1、本系统主要针对在职人员、高中毕业及大专生的学习系统\r\n2、请务必正确填写好您的基本信息（务必保证信息真实有效），以免耽误您的信息接收\r\n3、注册完成后7日内，查询您的录取状态', 1);
/*!40000 ALTER TABLE `t_apply_know` ENABLE KEYS */;


-- 导出  表 educate.t_class_evaluate 结构
CREATE TABLE IF NOT EXISTS `t_class_evaluate` (
  `class_evaluate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程评价编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `class_evaluate_content` text NOT NULL COMMENT '评价内容',
  `class_evaluate_date` date NOT NULL COMMENT '提交日期',
  `class_evaluate_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`class_evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='课程评价表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_class_evaluate 的数据：~7 rows (大约)
DELETE FROM `t_class_evaluate`;
/*!40000 ALTER TABLE `t_class_evaluate` DISABLE KEYS */;
INSERT INTO `t_class_evaluate` (`class_evaluate_id`, `student_id`, `course_id`, `class_evaluate_content`, `class_evaluate_date`, `class_evaluate_delete`) VALUES
	(1, NULL, NULL, '该课程内容不错', '2017-07-07', 1),
	(2, NULL, NULL, '该课程内容不错', '2017-07-07', 1),
	(3, NULL, NULL, '该课程内容不错', '2017-07-07', 1),
	(4, NULL, NULL, '该课程内容不错', '2017-07-07', 1),
	(5, NULL, NULL, '该课程内容不错', '2017-07-08', 1),
	(6, NULL, NULL, '该课程内容不错', '2017-07-08', 1),
	(7, NULL, 1, 'aa', '2017-07-08', 1);
/*!40000 ALTER TABLE `t_class_evaluate` ENABLE KEYS */;


-- 导出  表 educate.t_course 结构
CREATE TABLE IF NOT EXISTS `t_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `exam_id` int(11) DEFAULT NULL COMMENT '考试信息编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号(注意名称单词有误)',
  `score_id` int(11) DEFAULT NULL COMMENT '成绩表编号',
  `dissent_id` int(11) DEFAULT NULL COMMENT '异议表编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `exam_paper_id` int(11) DEFAULT NULL COMMENT '试卷编号',
  `course_name` varchar(20) DEFAULT NULL COMMENT '课程名称',
  `course_score` int(11) DEFAULT NULL COMMENT '课程学分',
  `course_edition` varchar(20) DEFAULT NULL COMMENT '课程版本',
  `course_class` varchar(20) DEFAULT NULL COMMENT '课程类别',
  `course_online_test_scorce` int(11) DEFAULT NULL COMMENT '在线测试分数',
  `course_info` text COMMENT '课程简介',
  `course_final_test_scorce` int(11) DEFAULT NULL COMMENT '课程结业考试分数',
  `course_online_scorce` int(11) DEFAULT NULL COMMENT '在线时长分数',
  `course_plan` decimal(10,2) DEFAULT NULL COMMENT '课程进度',
  `course_create_date` date DEFAULT NULL COMMENT '创建时间',
  `course_modify_person` varchar(20) DEFAULT NULL COMMENT '修改人',
  `course_modify_date` date DEFAULT NULL COMMENT '修改时间',
  `course_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COMMENT='课程表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_course 的数据：~51 rows (大约)
DELETE FROM `t_course`;
/*!40000 ALTER TABLE `t_course` DISABLE KEYS */;
INSERT INTO `t_course` (`course_id`, `exam_id`, `teacher_id`, `score_id`, `dissent_id`, `major_id`, `exam_paper_id`, `course_name`, `course_score`, `course_edition`, `course_class`, `course_online_test_scorce`, `course_info`, `course_final_test_scorce`, `course_online_scorce`, `course_plan`, `course_create_date`, `course_modify_person`, `course_modify_date`, `course_delete`) VALUES
	(1, 3, 1, 3, 1, 1, 3, '化学2', 3, '3', '1', 3, '该课程不错，非常好', 3, 3, 3.00, '2017-07-12', '赵睿慷', '2017-07-19', 1),
	(2, 1, 0, 3, 3, 0, 3, 'c语言1', 0, NULL, NULL, 0, '该课程不错，非常好', 0, 0, 0.00, '2017-07-13', '赵睿慷', '2017-07-19', 1),
	(30, 1, 0, 1, 1, 0, 1, 'c语言2', 0, NULL, NULL, 0, '该课程不错，非常好', 0, 0, 0.00, '2017-07-12', '赵睿慷', '2017-07-19', 1),
	(31, 2, 0, 2, 2, 0, 2, 'cc', 0, NULL, NULL, 0, NULL, 0, 0, 0.00, '2017-07-12', '赵睿慷', '2017-07-19', 1),
	(32, 3, 3, 3, 3, 3, 3, 'java', 3, '3', '5', 3, '该课程不错，非常好', 3, 3, 3.00, '2017-07-12', '赵睿慷', '2017-07-19', 1),
	(35, 3, 3, 3, 3, 3, 3, '英语1', 3, '3', '6', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(36, 3, 3, 3, 3, 3, 3, '物理', 3, '3', '7', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(37, 3, 3, 3, 3, 3, 3, '化学1', 3, '3', '8', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(38, 3, 3, 3, 3, 3, 3, '生物', 3, '3', '9', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(39, 3, 3, 3, 3, 3, 3, '广告1', 3, '3', '10', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(40, 3, 3, 3, 3, 3, 3, '环艺', 3, '3', '11', 3, NULL, 3, 3, 3.00, '2017-07-12', 'cc', '2017-07-12', 1),
	(41, NULL, NULL, NULL, NULL, NULL, NULL, 'UI1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(42, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(43, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(44, NULL, NULL, NULL, NULL, NULL, NULL, '555', NULL, NULL, '666', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(45, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(46, NULL, NULL, NULL, NULL, NULL, NULL, '2014', NULL, NULL, '2014', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(47, NULL, NULL, NULL, NULL, NULL, NULL, '英语专业111111\r\n', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(48, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(49, NULL, NULL, NULL, NULL, NULL, NULL, '英语专业11111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(50, NULL, NULL, NULL, NULL, NULL, NULL, '汉语专业', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(51, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(52, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(53, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(54, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(55, NULL, NULL, NULL, NULL, NULL, NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(56, NULL, NULL, NULL, NULL, NULL, NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(57, NULL, NULL, NULL, NULL, NULL, NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(58, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(59, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(60, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(61, NULL, NULL, NULL, NULL, NULL, NULL, '什么', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(62, NULL, NULL, NULL, NULL, NULL, NULL, '第三代1', NULL, NULL, '多的', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(63, NULL, NULL, NULL, NULL, NULL, NULL, '第三代2', NULL, NULL, '多的', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(64, NULL, NULL, NULL, NULL, NULL, NULL, '2014', NULL, NULL, '2014', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(65, NULL, NULL, NULL, NULL, NULL, NULL, '1', NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(66, NULL, NULL, NULL, NULL, NULL, NULL, '6', NULL, NULL, '6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(67, NULL, NULL, NULL, NULL, NULL, NULL, '汉语', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(68, NULL, 0, NULL, NULL, NULL, NULL, 'c#语言', 0, NULL, NULL, 0, NULL, 0, 0, 0.00, '2017-07-19', NULL, NULL, 1),
	(69, NULL, 0, NULL, NULL, NULL, NULL, 'c#', 3, NULL, '专升本', 0, '有点不好', 0, 0, 0.00, '2017-07-19', NULL, NULL, 1),
	(70, NULL, NULL, NULL, NULL, NULL, NULL, 'UI23', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(71, NULL, NULL, NULL, NULL, NULL, NULL, '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(72, NULL, NULL, NULL, NULL, NULL, NULL, '2222', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(73, NULL, NULL, NULL, NULL, NULL, NULL, 'aaaaaaaaa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(74, NULL, 0, NULL, NULL, NULL, NULL, 'c--', 3, NULL, '必修', 0, '非常好', 0, 0, 0.00, '2017-07-19', NULL, NULL, 1),
	(75, NULL, 0, NULL, NULL, NULL, NULL, 'c--', 3, NULL, '必修', 0, '非常好', 0, 0, 0.00, '2017-07-19', NULL, NULL, 1),
	(76, NULL, 0, NULL, NULL, NULL, NULL, 'c--', 3, NULL, '必修', 0, '非常好', 0, 0, 0.00, '2017-07-19', NULL, NULL, 1),
	(77, NULL, NULL, NULL, NULL, NULL, NULL, '广告2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(78, NULL, NULL, NULL, NULL, NULL, NULL, '1111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(79, NULL, NULL, NULL, NULL, NULL, NULL, 'UI2', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(80, NULL, NULL, NULL, NULL, NULL, NULL, 'UI4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_course` ENABLE KEYS */;


-- 导出  表 educate.t_courseware 结构
CREATE TABLE IF NOT EXISTS `t_courseware` (
  `courseware_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课件编号',
  `resource_id` int(11) DEFAULT NULL COMMENT '资料编号',
  `courseware_name` varchar(50) DEFAULT NULL COMMENT '课件名称',
  `courseware_size` int(11) DEFAULT NULL COMMENT '课件大小',
  `courseware_path` varchar(50) DEFAULT NULL COMMENT '课件路径',
  `courseware_addtime` date DEFAULT NULL COMMENT '发布时间',
  `courseware_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`courseware_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='导学课件表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_courseware 的数据：~37 rows (大约)
DELETE FROM `t_courseware`;
/*!40000 ALTER TABLE `t_courseware` DISABLE KEYS */;
INSERT INTO `t_courseware` (`courseware_id`, `resource_id`, `courseware_name`, `courseware_size`, `courseware_path`, `courseware_addtime`, `courseware_delete`) VALUES
	(1, 4, 'java第一章第一节', 1000, '/resource/1.txt', '2017-05-22', 1),
	(2, 4, 'java第一章第二节', 200, '/resource/2.txt', '2017-06-30', 0),
	(3, 5, 'java第二章第一节', 5000, '/resource/3.txt', '2015-06-30', 1),
	(4, 6, 'java第二章第一节', 300, '/resource/4.txt', '2017-06-30', 1),
	(5, 7, '777', 100, '/resource/5.txt', '2017-05-22', 1),
	(6, 7, '777', 100, '/resource/5.txt', '2017-09-22', 1),
	(7, 7, '777', 100, '/resource/5.txt', '2017-09-30', 1),
	(8, 7, '999', 999, '/test', '2017-07-11', 1),
	(9, 7, '0011', 999, '/test', '2017-07-11', 0),
	(10, 7, '444', 999, '/test', '2017-07-11', 1),
	(11, 7, '00000000000000000000000000', 999, '/test', '2017-07-11', 1),
	(12, 7, '11', 999, '/test', '2017-07-11', 1),
	(13, 7, '111111111111', 999, '/test', '2017-07-11', 1),
	(14, 7, '55', 999, '/test', '2017-07-12', 1),
	(15, 7, '77777777777777777', 999, '/test', '2017-07-12', 1),
	(16, 7, '666', 999, '/test', '2017-07-12', 1),
	(17, 7, '6666666666666', 999, '/test', '2017-07-12', 1),
	(18, 7, 'gdsfhhdhe', 999, '/test', '2017-07-12', 1),
	(19, 7, '222', 999, '/test', '2017-07-12', 1),
	(20, 7, 'yy', 999, '/test', '2017-07-12', 1),
	(21, 7, '7700', 999, '/test', '2017-07-12', 1),
	(22, 1, 'qq23', 999, '/test', '2017-07-12', 1),
	(23, 0, '9', 999, '/test', '2017-07-12', 1),
	(24, 0, '00', 999, '/test', '2017-07-12', 1),
	(25, 0, '66', 999, '/test', '2017-07-12', 1),
	(26, 0, '88', 999, '/test', '2017-07-12', 1),
	(27, 4, '00', 999, '/test', '2017-07-12', 0),
	(28, 22, 'yyyyyyyyyyyy', 999, '/test', '2017-07-12', 1),
	(29, 22, 'yy', 999, '/test', '2017-07-12', 0),
	(30, 19, 'i', 999, '/test', '2017-07-12', 1),
	(31, 23, 'ddd', 999, '/test', '2017-07-17', 0),
	(32, 23, 'ddd', 999, '/test', '2017-07-17', 1),
	(33, 1, '909090909090', 100, '/myFiles/精忠报国.mp4', '2017-07-18', 1),
	(34, 1, '888888888888888', 100, '/myFiles/毕业学生确认表.doc', '2017-07-18', 1),
	(35, 1, 'IIIi', 100, '/myFiles/精忠报国.mp4', '2017-07-18', 1),
	(36, 1, 'uu', 100, '/myFiles/毕业学生确认表.doc', '2017-07-18', 1),
	(37, 1, '黑盒', 100, '/myFiles/02-Oracle-习题集(V4).doc', '2017-07-18', 1);
/*!40000 ALTER TABLE `t_courseware` ENABLE KEYS */;


-- 导出  表 educate.t_course_inform 结构
CREATE TABLE IF NOT EXISTS `t_course_inform` (
  `inform_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知表编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `inform_date` date NOT NULL COMMENT '课程时间',
  `inform_informTitle` varchar(50) NOT NULL COMMENT '通知标题',
  `inform_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`inform_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='课程通知(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_course_inform 的数据：~42 rows (大约)
DELETE FROM `t_course_inform`;
/*!40000 ALTER TABLE `t_course_inform` DISABLE KEYS */;
INSERT INTO `t_course_inform` (`inform_id`, `teacher_id`, `course_id`, `inform_date`, `inform_informTitle`, `inform_delete`) VALUES
	(2, 1, 40, '2017-07-20', '777', 0),
	(3, 2, 34, '2017-07-20', '很好', 1),
	(4, 2, 1, '2017-07-10', 'java明天不上课，在家休息', 1),
	(5, 1, 1, '2017-07-10', 'Java明天不上课', 1),
	(6, 1, 30, '2017-07-10', '下午上课', 1),
	(7, 1, 40, '2017-07-10', '上午上课', 1),
	(8, 1, 30, '2017-07-10', '电脑课暂时不上', 1),
	(9, 9, 2, '2017-07-10', 'Java下午一点上课', 1),
	(10, 2, 40, '2017-07-10', '化学上午9点上课', 1),
	(11, 11, 30, '2017-07-10', 'Java后天上课', 1),
	(12, 4, 4, '2017-07-13', '好好学习，天天向上', 1),
	(13, 2, 30, '2017-07-11', '好好学习，天天向上', 1),
	(14, 3, 30, '2017-07-11', '好好学习', 1),
	(24, 2, 1, '2017-07-12', '好好学习', 1),
	(27, 2, 2, '2017-07-13', '努力背书', 1),
	(28, 2, 2, '2017-07-13', '努力背书', 1),
	(29, 2, 2, '2017-07-13', '努力背书', 1),
	(30, 2, 2, '2017-07-13', '努力背书', 1),
	(31, 2, 2, '2017-07-13', '努力背书', 1),
	(32, 1, 39, '2017-07-13', '努力背书', 1),
	(33, 2, 2, '2017-07-13', '努力背书', 1),
	(34, 1, 40, '2017-07-15', '好好学习', 1),
	(35, 2, 40, '2017-07-15', '好好学习', 1),
	(36, 2, 41, '2017-07-15', 'UI下午由公司前来招聘', 1),
	(37, 11, 1, '2017-07-15', 'java有公司前来招聘', 1),
	(38, 2, 100, '2017-07-15', 'PHP下午由公司前来招聘', 0),
	(39, 2, 49, '2017-07-15', '好好学习', 1),
	(40, 2, 50, '2017-07-15', '好好学习', 1),
	(41, 1, 54, '2017-07-14', '111111', 0),
	(42, 10, 58, '2017-07-13', '2234234', 1),
	(43, 2, 59, '2017-07-21', '2222222', 0),
	(44, 11, 60, '2017-07-21', '434333', 1),
	(45, 1, 61, '2017-07-13', '你在说些什么东西', 0),
	(46, 1, 67, '2017-07-17', '好好学习', 1),
	(47, 1, 70, '2017-07-18', '好好学习天天向上', 1),
	(48, 1, 71, '2017-07-18', '111', 1),
	(49, 1, 72, '2017-07-18', '2222222222222', 0),
	(50, 2, 39, '1996-02-21', '1111111111111111', 0),
	(51, 1, 77, '2017-07-18', '设计设计', 1),
	(52, 111, 78, '2017-07-18', '11111', 1),
	(53, 1, 79, '2017-07-18', '132131', 0),
	(54, 1, 80, '2017-07-26', '伤害找工作', 0);
/*!40000 ALTER TABLE `t_course_inform` ENABLE KEYS */;


-- 导出  表 educate.t_dissent 结构
CREATE TABLE IF NOT EXISTS `t_dissent` (
  `dissent_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '异议表编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `dissent_content` text NOT NULL COMMENT '异议说明',
  `dissent_date` date NOT NULL COMMENT '提出时间',
  `dissent_check` int(11) NOT NULL COMMENT '审核状态',
  `dissent_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`dissent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='学生对该课程成绩的疑问的申请记录(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_dissent 的数据：~8 rows (大约)
DELETE FROM `t_dissent`;
/*!40000 ALTER TABLE `t_dissent` DISABLE KEYS */;
INSERT INTO `t_dissent` (`dissent_id`, `course_id`, `student_id`, `dissent_content`, `dissent_date`, `dissent_check`, `dissent_delete`) VALUES
	(1, 1, 1, 'nsgonsd', '2017-07-01', 0, 1),
	(2, 1, 1, '原因ftjf', '2017-07-04', 0, 1),
	(3, 1, 1, '原因dfhjdfj', '2017-07-04', 0, 1),
	(4, 1, 1, '原因', '2017-07-04', 0, 1),
	(5, 1, 2, '原因erhjh', '2017-07-04', 0, 1),
	(6, 1, 1, '原因mdlfhm', '2017-07-04', 0, 1),
	(7, 1, 1, '原因dshdh', '2017-07-05', 0, 1),
	(8, 1, 1, '原因dfh', '2017-07-06', 0, 1);
/*!40000 ALTER TABLE `t_dissent` ENABLE KEYS */;


-- 导出  表 educate.t_education 结构
CREATE TABLE IF NOT EXISTS `t_education` (
  `education_plan_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教学计划编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `education_grade` varchar(10) DEFAULT NULL COMMENT '年级',
  `course_name` varchar(10) DEFAULT NULL COMMENT '课程名称',
  `course_type` varchar(10) DEFAULT NULL COMMENT '课程类别',
  `study_score` int(11) DEFAULT NULL COMMENT '学分',
  `study_term` int(11) DEFAULT NULL COMMENT '学期',
  `education_create_date` date DEFAULT NULL COMMENT '创建时间',
  `education_plan_modify_person` varchar(20) DEFAULT NULL COMMENT '修改人',
  `education_plan_modify_date` date DEFAULT NULL COMMENT '修改时间',
  `education_plan_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`education_plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='教学计划表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_education 的数据：~28 rows (大约)
DELETE FROM `t_education`;
/*!40000 ALTER TABLE `t_education` DISABLE KEYS */;
INSERT INTO `t_education` (`education_plan_id`, `major_id`, `education_grade`, `course_name`, `course_type`, `study_score`, `study_term`, `education_create_date`, `education_plan_modify_person`, `education_plan_modify_date`, `education_plan_delete`) VALUES
	(1, 1, '2014级', 'java', '选修', 66666, 0, '2017-07-01', '大仁', '2017-05-01', 1),
	(2, 2, '2014级', 'ui', '必修', 2017, 10, '2017-07-01', '大仁', '2017-07-01', 1),
	(3, 3, '2014级', 'h5', '必修', NULL, 0, '2017-07-01', '大仁', '2017-07-01', 1),
	(4, 4, '2014级', 'php', '必修', 2014, 10, '2017-07-01', '大仁', '2017-07-01', 1),
	(5, 5, '2014级', 'java', '选修', 2017, 10, '2017-07-01', '大仁', '2017-07-01', 1),
	(6, 6, '2014级', 'php', '必修', NULL, 20, '2017-07-01', '大仁', '2017-07-01', 1),
	(7, 7, '2014级', NULL, '必修', NULL, NULL, '2017-07-01', '大仁', '2017-07-01', 1),
	(8, 8, '2014级', NULL, NULL, NULL, NULL, '2017-07-01', '大仁', '2017-07-01', 0),
	(10, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-01', '徐大仁', '2017-05-01', 0),
	(12, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-04', '徐大仁', '2017-05-01', 0),
	(13, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-04', '徐大仁', '2017-07-04', 0),
	(14, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-04', '徐大仁', '2017-07-04', 0),
	(15, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-04', '徐大仁', '2017-07-04', 0),
	(16, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-12', '徐大仁', '2017-07-12', 0),
	(17, 1, '2015级', NULL, NULL, NULL, NULL, '2017-07-12', '徐大仁', '2017-07-12', 0),
	(18, NULL, '2014', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
	(19, NULL, '2014', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
	(20, 3, '多的', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
	(21, 3, '多的', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0),
	(22, 3, '2014', NULL, '选修', 1995, 10, NULL, NULL, NULL, 1),
	(23, 1, '2017', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
	(24, 6, '6', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1),
	(25, 0, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL, 1),
	(26, 3, '201508', '德玛西亚', '必修', 2014, 0, NULL, NULL, NULL, 1),
	(27, 1, '1', '1', '1', 1, 1, NULL, NULL, NULL, 1),
	(28, 2, '2', '3', '2', 2, 4, NULL, NULL, NULL, 1),
	(29, 0, '201508', '', '5', 1888, 10, NULL, NULL, NULL, 1),
	(30, 0, '111', '111', '必修', 111, 111, NULL, NULL, NULL, 1);
/*!40000 ALTER TABLE `t_education` ENABLE KEYS */;


-- 导出  表 educate.t_enroll_students 结构
CREATE TABLE IF NOT EXISTS `t_enroll_students` (
  `enroll_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '招生编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `enroll_student_num` int(11) NOT NULL COMMENT '招生人数',
  `enroll_tuition` double NOT NULL COMMENT '学费',
  `enroll_edu_system` varchar(20) NOT NULL COMMENT '学制',
  `enroll_area` varchar(20) NOT NULL COMMENT '招生区域',
  `enroll_create_date` date NOT NULL COMMENT '创建时间',
  `enroll_model` varchar(20) NOT NULL COMMENT '招生形式',
  `enroll_modify_person` varchar(50) NOT NULL COMMENT '修改人',
  `enroll_modify_date` date NOT NULL COMMENT '修改时间',
  `enroll_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`enroll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='招生计划表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_enroll_students 的数据：~15 rows (大约)
DELETE FROM `t_enroll_students`;
/*!40000 ALTER TABLE `t_enroll_students` DISABLE KEYS */;
INSERT INTO `t_enroll_students` (`enroll_id`, `major_id`, `enroll_student_num`, `enroll_tuition`, `enroll_edu_system`, `enroll_area`, `enroll_create_date`, `enroll_model`, `enroll_modify_person`, `enroll_modify_date`, `enroll_delete`) VALUES
	(1, 3, 12, 4500, '3', '北京', '2017-07-09', '专升本', '李志鹏', '2017-07-19', 1),
	(2, 1, 200, 4500, '3', '上海', '2017-07-08', '专升本', '李志鹏', '2017-07-19', 1),
	(3, 2, 200, 4500, '4', '北京', '2017-07-08', '专升本', '李志鹏', '2014-07-08', 1),
	(4, 3, 200, 4500, '4', '郑州', '2017-07-08', '专升本', '李志鹏', '2013-07-08', 1),
	(5, 1, 200, 4500, '4', '西安', '2017-07-08', '专升本', '李志鹏', '2017-07-19', 1),
	(6, 2, 200, 4500, '4', '焦作', '2017-07-08', '专升本', '李志鹏', '2017-07-19', 1),
	(7, 1, 200, 4500, '4', '云和', '2017-07-08', '专升本', '李志鹏', '2017-07-19', 1),
	(8, 1, 200, 3000, '3', '北京', '2017-07-11', '专升本', '李志鹏', '2017-07-12', 1),
	(9, 1, 20, 2, '2', '9', '2017-07-11', '9', '李志鹏', '2017-07-12', 1),
	(10, 9, 3, 3, '3', '3', '2017-07-11', '3', '李志鹏', '2017-07-11', 0),
	(11, 6, 50, 5, '5', '5', '2017-07-12', '5', '李志鹏', '2017-07-24', 1),
	(12, 3, 10, 2500, '4', '焦作', '2017-07-13', '专升本', '李志鹏', '2017-08-02', 1),
	(13, 2, 41, 1, '1', '1', '2017-07-13', '1', '李志鹏', '2017-07-13', 0),
	(14, 7, 200, 188, '4', '上海', '2017-07-19', '专升本', '李志鹏', '2017-07-24', 1),
	(15, 2, 2, 3, '2', '1', '2017-07-19', '1', '李志鹏', '2017-07-19', 0);
/*!40000 ALTER TABLE `t_enroll_students` ENABLE KEYS */;


-- 导出  表 educate.t_enter 结构
CREATE TABLE IF NOT EXISTS `t_enter` (
  `enter_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '报名编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `enter_name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `enter_sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `enter_birth` date DEFAULT NULL COMMENT '出生日期',
  `enter_nation` varchar(20) DEFAULT NULL COMMENT '民族',
  `enter_idcard` varchar(100) DEFAULT NULL COMMENT '身份证号',
  `enter_phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `enter_graduate` varchar(100) DEFAULT NULL COMMENT '毕业院校',
  `enter_address` varchar(100) DEFAULT NULL COMMENT '家庭住址',
  `enter_education` varchar(100) DEFAULT NULL COMMENT '学历',
  `enter_certificate` varchar(100) DEFAULT NULL COMMENT '毕业证照片',
  `enter_photo` varchar(110) DEFAULT NULL COMMENT '二寸照',
  `enter_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `enter_check_state` int(11) DEFAULT NULL COMMENT '审核状态',
  `enter_check_date` date DEFAULT NULL COMMENT '审核时间',
  `enter_first_score` int(11) DEFAULT NULL COMMENT '初考成绩',
  `enter_date` date DEFAULT NULL COMMENT '报名日期',
  `enter_type` int(11) DEFAULT NULL COMMENT '所选类型',
  `enter_pay_state` int(11) DEFAULT NULL COMMENT '缴费状态',
  `enter_pay_way` int(11) DEFAULT NULL COMMENT '缴费方式',
  `enter_pay_money` double(10,2) DEFAULT NULL COMMENT '缴费金额',
  `enter_pay_date` date DEFAULT NULL COMMENT '缴费时间',
  `enter_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`enter_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='报名表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_enter 的数据：~16 rows (大约)
DELETE FROM `t_enter`;
/*!40000 ALTER TABLE `t_enter` DISABLE KEYS */;
INSERT INTO `t_enter` (`enter_id`, `teacher_id`, `major_id`, `enter_name`, `enter_sex`, `enter_birth`, `enter_nation`, `enter_idcard`, `enter_phone`, `enter_graduate`, `enter_address`, `enter_education`, `enter_certificate`, `enter_photo`, `enter_email`, `enter_check_state`, `enter_check_date`, `enter_first_score`, `enter_date`, `enter_type`, `enter_pay_state`, `enter_pay_way`, `enter_pay_money`, `enter_pay_date`, `enter_delete`) VALUES
	(10, 1, 1, '张三', '男', '2017-07-05', '汉', '411082199601170664', '15915915915', '河南职业技术学院', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '12342', 0, '2017-07-04', 50, '2017-07-03', 1, 1, 1, 3000.00, '2017-07-05', 1),
	(11, 1, 1, '王小雨', '女', '2017-07-05', '汉', '411082199601170664', '15915915915', '河南职业技术学院', '河南郑州', '高中', 'p02.jpg', 'p01.jpg', '123', 0, '2017-07-05', 65, '2017-07-05', 1, 1, 1, 3000.00, '2017-07-05', 1),
	(12, 1, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '214', 1, '2017-07-05', 65, '2017-07-05', 1, 1, 1, 3000.00, '2017-07-05', 1),
	(13, 2, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '高中', 'p02.jpg', 'p01.jpg', '2134', 0, '2017-07-05', 7, '2017-07-05', 1, 1, 1, 3000.00, '2017-07-05', 1),
	(14, 2, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '43125', 0, '2017-07-05', 100, '2017-07-05', 0, 1, 2, NULL, '2017-07-05', 1),
	(15, 2, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '高中', 'p02.jpg', 'p01.jpg', '423', 0, '2017-07-05', 71, '2017-07-05', 1, 1, 1, 3000.00, '2017-07-05', 1),
	(16, 2, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '123', 0, '2017-07-05', 20, '2017-07-05', 1, 1, 2, 3000.00, '2017-07-05', 1),
	(17, 2, 1, '王小雨', '女', '2017-07-05', '汉', '4123456789123456009', '15915915915', '河南职业技术学院', '河南郑州', '高中', 'p02.jpg', 'p01.jpg', '412', 0, '2017-07-05', 50, '2017-07-05', 1, 1, 2, 3000.00, '2017-07-05', 1),
	(21, 1, 3, '李四', '男', '2017-07-06', '汉', '1', '15915915912', '郑州大学', '河南郑州', '大专', 'c3.jpg', 'p3.jpg', '132', 0, '2017-07-06', 100, '2017-07-06', 1, 1, 3, 3000.00, NULL, 1),
	(25, 1, 3, '11111', '男', '2017-07-06', '汉', '412315935715915917', '15915915912', '郑州大学', '河南郑州', '大专', 'c3.jpg', 'p3.jpg', '124', 0, '2017-07-06', 60, '2017-07-06', 0, 1, 3, NULL, NULL, 1),
	(33, 2, 1, '张露林', '男', '2017-07-05', '汉', '9123456789123456009', '15915915915', '开封大学', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '124', 0, '2017-07-05', 33, '2017-07-05', 0, 1, 1, 4500.00, '2017-07-21', 1),
	(35, 1, 1, '王雨', '男', '2017-07-12', '汉', '1', '123456', '河南职业技术学院', '河南郑州', '高中', 'p01.jpg', 'p3.jpg', '124', NULL, NULL, 59, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(39, 1, 1, '王雨', '男', '2017-07-12', '回', '1', '321654', '河南职业技术学院', '河南郑州', '高中', 'p01.jpg', 'p2.jpg', '341', NULL, NULL, 50, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(58, NULL, 0, '张露林', '男', '2017-07-05', '汉', '9123456789123456009', '15915915915', '开封大学', '河南郑州', '大专', 'p01.jpg', 'p3.jpg', '31', NULL, NULL, NULL, '2017-07-05', 0, 1, 1, 4500.00, '2017-07-21', 1),
	(59, NULL, 0, '张露林', '男', '2017-07-05', '汉', '9123456789123456009', '15915915915', '开封大学', '河南郑州', '大专', 'p01.jpg', 'p2.jpg', '123', NULL, NULL, NULL, '2017-07-05', 0, 1, 1, 4500.00, '2017-07-21', 1),
	(60, NULL, 0, '张露林', '男', '2017-07-05', '汉', '9123456789123456009', '15915915915', '开封大学', '河南郑州', '高中', 'p01.jpg', 'p3.jpg', '12', NULL, NULL, NULL, '2017-07-05', 0, 1, 1, 4500.00, '2017-07-21', 1);
/*!40000 ALTER TABLE `t_enter` ENABLE KEYS */;


-- 导出  表 educate.t_exam 结构
CREATE TABLE IF NOT EXISTS `t_exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试信息编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `exam_place` varchar(200) NOT NULL COMMENT '考试地点',
  `exam_time` date NOT NULL COMMENT '考试时间',
  `exam_appoint_time` date NOT NULL COMMENT '预约时间',
  `exam_form` varchar(20) NOT NULL COMMENT '考试形式',
  `exam_addtime` date NOT NULL COMMENT '发布时间',
  `exam_motify_person` varchar(50) NOT NULL COMMENT '修改人',
  `exam_motify_date` date NOT NULL COMMENT '修改时间',
  `exam_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8 COMMENT='考试信息表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_exam 的数据：~62 rows (大约)
DELETE FROM `t_exam`;
/*!40000 ALTER TABLE `t_exam` DISABLE KEYS */;
INSERT INTO `t_exam` (`exam_id`, `course_id`, `teacher_id`, `exam_place`, `exam_time`, `exam_appoint_time`, `exam_form`, `exam_addtime`, `exam_motify_person`, `exam_motify_date`, `exam_delete`) VALUES
	(1, 1, 1, '亚武山', '2017-07-03', '2017-07-03', '网上考试', '2017-07-03', '0', '2017-07-03', 0),
	(2, 1, 1, '华山', '2017-07-03', '2017-07-03', '网上考试', '2017-07-03', '0', '2017-07-03', 0),
	(8, 1, 6, '黄山', '2015-05-05', '2017-07-07', '网上考试', '2016-06-06', '0', '2017-08-09', 1),
	(9, 1, 2, '黄山', '2015-05-05', '2017-07-07', '网上考试', '2016-06-06', '0', '2017-08-09', 0),
	(10, 1, 2, '德玛西亚', '2015-05-05', '2017-07-07', '网上考试', '2016-06-06', '0', '2017-08-09', 0),
	(11, 1, 2, '德玛西亚', '2015-05-05', '2017-07-07', '网上考试', '2016-06-06', '0', '2017-08-09', 0),
	(12, 6, 1, '河南', '2017-09-09', '2017-05-05', '网上考试', '2017-09-09', '0', '2017-07-07', 1),
	(13, 6, 1, '河南', '2017-09-09', '2017-05-05', '网上考试', '2017-09-09', '0', '2017-07-07', 1),
	(14, 6, 1, '河南', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2017-07-07', 1),
	(15, 6, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 1),
	(16, 6, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 1),
	(17, 6, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 1),
	(18, 2, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(19, 1, 1, 'dasdas', '2017-07-26', '2017-07-18', '网上考试', '2017-07-19', '0', '2017-07-29', 0),
	(20, 1, 1, 'dsadsa', '2017-07-29', '2017-07-14', '网上考试', '2017-07-20', '0', '2017-07-26', 0),
	(21, 1, 1, 'dasdasdas', '2017-07-21', '2017-07-07', '网上考试', '2017-07-21', '0', '2017-07-24', 0),
	(22, 1, 1, '云和', '2017-07-26', '2017-07-01', '网上考试', '2017-07-26', '0', '2017-07-26', 0),
	(23, 1, 2, '正大', '2017-07-25', '2017-07-01', '网上考试', '2017-07-18', '0', '2017-07-27', 0),
	(24, 1, 1, '河南郑州大学', '2017-07-25', '2017-07-01', '网上考试', '2017-07-18', '0', '2017-07-27', 1),
	(25, 1, 1, '清华', '2017-07-30', '2017-07-06', '网上考试', '2017-07-01', '0', '2017-07-31', 1),
	(26, 1, 1, '清华', '2017-07-29', '2017-07-01', '网上考试', '2017-07-20', '0', '2017-07-28', 1),
	(27, 1, 4, '羌胡', '2017-07-28', '2017-07-01', '现场考试', '2017-07-14', '0', '2017-07-27', 1),
	(28, 1, 1, '清华', '2017-07-29', '2017-07-08', '网上考试', '2017-07-10', '0', '2017-07-21', 0),
	(29, 1, 1, '北大', '2017-07-30', '2017-07-08', '网上考试', '2017-07-20', '0', '2017-07-29', 1),
	(30, 1, 1, '合工大', '2017-07-29', '2017-07-03', '网上考试', '2017-07-21', '0', '2017-07-22', 1),
	(31, 1, 1, '河南科技学院', '2017-07-31', '2017-07-01', '网上考试', '2017-07-08', '0', '2017-07-15', 1),
	(32, 1, 1, '河师大', '2017-07-28', '2017-07-08', '网上考试', '2017-07-20', '0', '2017-07-28', 1),
	(33, 1, 1, '河师大', '2017-07-28', '2017-07-08', '网上考试', '2017-07-20', '0', '2017-07-28', 1),
	(34, 1, 1, '石河子大学', '2017-07-29', '2017-07-07', '网上考试', '2017-07-10', '0', '2017-07-16', 1),
	(35, 1, 1, '开封大学', '2017-07-28', '2017-07-07', '网上考试', '2017-07-28', '0', '2017-07-09', 1),
	(36, 1, 2, '郑州大学', '2017-07-30', '2017-07-05', '网上考试', '2017-07-28', '0', '2017-07-28', 1),
	(37, 1, 2, '天津大学', '2017-07-31', '2017-07-07', '现场考试', '2017-07-14', '0', '2017-07-27', 0),
	(38, 1, 1, '哈尔滨大学', '2017-07-29', '2017-07-01', '网上考试', '2017-07-04', '0', '2017-07-13', 1),
	(39, 1, 2, '黑龙江', '2017-07-23', '2017-07-07', '网上考试', '2017-07-10', '0', '2017-07-25', 1),
	(40, 6, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(41, 6, 1, '黄土高坡', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(42, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(43, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(44, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(45, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(46, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(47, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(48, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(49, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(50, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(51, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(52, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(53, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(54, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(55, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(56, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(57, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(58, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(59, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(60, 6, 1, '黄土高坡1111', '2015-05-05', '2015-06-05', '网上考试', '2015-06-06', '0', '2015-06-06', 0),
	(61, 1, 3, '河南科技学院', '2017-07-30', '2017-07-02', '网上考试', '2017-07-27', '0', '2017-07-29', 1),
	(62, 1, 1, '郑州大学', '2017-07-29', '2017-07-07', '网上考试', '2017-07-21', '0', '2017-07-23', 1),
	(63, 1, 1, '北京师范大学', '2017-07-18', '2017-07-12', '现场考试', '2017-07-13', '0', '2017-07-18', 1),
	(64, 1, 3, '清华大学', '2017-07-28', '2017-07-07', '网上考试', '2017-07-21', '0', '2017-07-27', 0),
	(65, 1, 1, '石河子大学', '2017-07-23', '2017-07-07', '网上考试', '2017-07-20', '0', '2017-07-21', 0),
	(66, 1, 1, '外星人', '2017-07-22', '2017-07-06', '现场考试', '2017-07-20', '0', '2017-07-20', 1),
	(67, 1, 1, 'YUHE', '2017-07-29', '2017-07-03', '现场考试', '2017-07-11', '0', '2017-07-24', 1);
/*!40000 ALTER TABLE `t_exam` ENABLE KEYS */;


-- 导出  表 educate.t_exam_order 结构
CREATE TABLE IF NOT EXISTS `t_exam_order` (
  `order_id` int(10) DEFAULT NULL COMMENT '预约表编号',
  `stu_id` int(10) NOT NULL COMMENT '学生编号',
  `exam_id` int(10) NOT NULL COMMENT '考试信息编号',
  `order_state` int(10) DEFAULT NULL COMMENT '预约状态（1代表已经预约,0代表未预约）',
  PRIMARY KEY (`stu_id`,`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生考试预约表';

-- 正在导出表  educate.t_exam_order 的数据：~3 rows (大约)
DELETE FROM `t_exam_order`;
/*!40000 ALTER TABLE `t_exam_order` DISABLE KEYS */;
INSERT INTO `t_exam_order` (`order_id`, `stu_id`, `exam_id`, `order_state`) VALUES
	(NULL, 2, 18, 1),
	(NULL, 2, 20, 1),
	(NULL, 2, 31, 1);
/*!40000 ALTER TABLE `t_exam_order` ENABLE KEYS */;


-- 导出  表 educate.t_exam_paper 结构
CREATE TABLE IF NOT EXISTS `t_exam_paper` (
  `exam_paper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  PRIMARY KEY (`exam_paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='试卷表';

-- 正在导出表  educate.t_exam_paper 的数据：~1 rows (大约)
DELETE FROM `t_exam_paper`;
/*!40000 ALTER TABLE `t_exam_paper` DISABLE KEYS */;
INSERT INTO `t_exam_paper` (`exam_paper_id`, `course_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `t_exam_paper` ENABLE KEYS */;


-- 导出  表 educate.t_judge 结构
CREATE TABLE IF NOT EXISTS `t_judge` (
  `judge_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目编号',
  `store_id` int(11) DEFAULT NULL COMMENT '题库编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `judge_name` varchar(50) NOT NULL COMMENT '题目名称',
  `judge_one` varchar(200) NOT NULL COMMENT '选项1',
  `judge_two` varchar(200) NOT NULL COMMENT '选项2',
  `judge_answer` varchar(200) NOT NULL COMMENT '答案',
  `judge_point` int(11) NOT NULL COMMENT '分值',
  `judge_addtime` date DEFAULT NULL COMMENT '录题时间',
  `judge_adduser` varchar(50) DEFAULT NULL COMMENT '录题人',
  `judge_modify_date` date DEFAULT NULL COMMENT '修改时间',
  `judge_modify_person` varchar(50) DEFAULT NULL COMMENT '修改人',
  `judge_delete` int(11) NOT NULL COMMENT '删除状态',
  `score_type` int(10) DEFAULT NULL COMMENT '题库类型(1为期末考试，2为章节测试，3为入学测试)',
  `course_id` int(10) DEFAULT NULL COMMENT '课程编号',
  `section_test_id` int(10) DEFAULT NULL COMMENT '章节测试编号',
  `enter_test_type` int(10) DEFAULT NULL COMMENT '入学测试类型（1为专升本，2为高升专）',
  PRIMARY KEY (`judge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COMMENT='判断题表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_judge 的数据：~74 rows (大约)
DELETE FROM `t_judge`;
/*!40000 ALTER TABLE `t_judge` DISABLE KEYS */;
INSERT INTO `t_judge` (`judge_id`, `store_id`, `teacher_id`, `judge_name`, `judge_one`, `judge_two`, `judge_answer`, `judge_point`, `judge_addtime`, `judge_adduser`, `judge_modify_date`, `judge_modify_person`, `judge_delete`, `score_type`, `course_id`, `section_test_id`, `enter_test_type`) VALUES
	(1, 1, 1, '帅帅是个GUY', '是的', '不是', 'A', 2, '2017-07-06', 'zr', '2017-07-17', '李志鹏', 0, 1, 1, NULL, NULL),
	(2, 1, 1, '8', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-17', '李志鹏', 0, 1, 1, NULL, NULL),
	(3, 1, 1, '2222222222', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-17', '李志鹏', 0, 1, 1, NULL, NULL),
	(4, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-17', '李志鹏', 1, 1, 1, NULL, NULL),
	(5, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-17', '李志鹏', 1, 1, 1, NULL, NULL),
	(6, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(7, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(8, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(9, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(10, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(11, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(12, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(13, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(14, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(15, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(16, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(17, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(18, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(19, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(20, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(21, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, 2, NULL, NULL),
	(22, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, 2, NULL, NULL),
	(23, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 3, 2, NULL, NULL),
	(24, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(25, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(26, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(27, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 3, NULL, NULL, NULL),
	(28, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(29, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 3, NULL, NULL, NULL),
	(30, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(31, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(32, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(33, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(34, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(35, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(36, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(37, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(38, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(39, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 1, NULL, NULL, NULL),
	(40, 1, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-06', 'zr', '2017-07-06', 'zr', 1, 2, NULL, NULL, NULL),
	(41, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(42, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 2, NULL, NULL, NULL),
	(43, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(44, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 2, NULL, NULL, NULL),
	(45, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(46, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 2, NULL, NULL, NULL),
	(47, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(48, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 2, NULL, NULL, NULL),
	(49, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(50, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 2, NULL, NULL, NULL),
	(51, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(52, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(53, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(54, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(55, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(56, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(57, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(58, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(59, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(60, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(61, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(62, 2, 1, 'int有几个字节', '2个', '4个', 'B', 2, '2017-07-07', 'zr', '2017-07-07', 'zr', 1, 1, NULL, NULL, NULL),
	(63, NULL, NULL, '1', '1', '0', 'B', 2, '2017-07-01', 'li', NULL, NULL, 0, 2, 1, 1, NULL),
	(64, NULL, NULL, '刘帅是guy吗？', '对', '错', 'B', 2, '2017-07-15', '李志鹏', NULL, NULL, 0, 2, 1, 1, NULL),
	(65, NULL, NULL, '呵呵呵呵呵呵呵呵', '1', '2', 'B', 2, '2017-07-15', '李志鹏', NULL, NULL, 1, 2, 1, 27, NULL),
	(66, NULL, NULL, '1', '1', '1', 'B', 1, '2017-07-15', '李志鹏', NULL, NULL, 1, 2, 1, 2, NULL),
	(67, NULL, NULL, '2', '1', '1', 'B', 1, '2017-07-15', '李志鹏', NULL, NULL, 1, 2, 31, 0, NULL),
	(68, NULL, NULL, '8', '8', '8', 'B', 8, '2017-07-16', '李志鹏', NULL, NULL, 1, 2, 0, 0, NULL),
	(69, NULL, NULL, '8', '8', '8', 'B', 8, '2017-07-16', '李志鹏', NULL, NULL, 1, 2, 0, 0, NULL),
	(70, NULL, NULL, '9', '9', '9', 'B', 9, '2017-07-16', '李志鹏', NULL, NULL, 1, 2, 0, 0, NULL),
	(71, NULL, NULL, '9', '9', '9', 'B', 9, '2017-07-16', '李志鹏', NULL, NULL, 1, 3, NULL, NULL, 1),
	(72, NULL, NULL, 'asa', 'dasds', 'asdas', 'A', 2, '2017-07-17', '李志鹏', NULL, NULL, 0, 2, 1, 3, NULL),
	(73, NULL, NULL, '333', '555', '555', '555', 2, '2017-07-19', '李志鹏', '2017-07-19', '李志鹏', 1, 2, 1, 1, NULL),
	(74, NULL, NULL, '000', '00', '00', 'A', 2, '2017-07-19', '李志鹏', NULL, NULL, 0, 1, 30, NULL, NULL);
/*!40000 ALTER TABLE `t_judge` ENABLE KEYS */;


-- 导出  表 educate.t_major 结构
CREATE TABLE IF NOT EXISTS `t_major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业编号',
  `education_plan_id` int(11) DEFAULT NULL COMMENT '教学计划编号',
  `enroll_id` int(11) DEFAULT NULL COMMENT '招生编号',
  `thesis_layout_id` int(11) DEFAULT NULL COMMENT '论文格式编号',
  `enter_id` int(11) DEFAULT NULL COMMENT '报名表编号',
  `major_name` varchar(20) DEFAULT NULL COMMENT '专业名称',
  `major_academic` varchar(20) DEFAULT NULL COMMENT '学期',
  `major_create_date` date DEFAULT NULL COMMENT '专业创建时间',
  `major_profile` text COMMENT '专业简介',
  `major_total_credit` int(11) DEFAULT NULL COMMENT '总学分',
  `modify_person` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modify_date` date DEFAULT NULL COMMENT '修改时间',
  `major_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='专业表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_major 的数据：~48 rows (大约)
DELETE FROM `t_major`;
/*!40000 ALTER TABLE `t_major` DISABLE KEYS */;
INSERT INTO `t_major` (`major_id`, `education_plan_id`, `enroll_id`, `thesis_layout_id`, `enter_id`, `major_name`, `major_academic`, `major_create_date`, `major_profile`, `major_total_credit`, `modify_person`, `modify_date`, `major_delete`) VALUES
	(1, 1, 1, 1, 10, '计算机', '5', '2017-06-28', '好好学习', 500, '赵睿慷', '2017-07-20', 0),
	(2, 2, 1, 3, 12, '语文', '1', '2017-06-20', '好好学习', 3, '赵睿慷', '2017-06-28', 1),
	(3, 3, 1, 3, 11, '数学', '1', '2017-06-28', '学习知识', 3, '赵睿慷', '2017-07-14', 1),
	(4, 4, 2, NULL, 10, '英语', '2', '2017-06-28', '背诵英语', 3, '赵睿慷', '2017-07-25', 1),
	(5, 5, 2, NULL, 2, '语文', '5', '2017-06-28', '背诵文言文', 3, '赵睿慷', '2017-07-25', 1),
	(6, 6, 1, NULL, 2, '数学', '1', '2017-06-28', '学习高数', 3, '赵睿慷', '2017-06-29', 1),
	(7, 7, 3, NULL, 2, '物理', '1', '2017-06-28', '电流实验', 3, '赵睿慷', '2017-06-29', 1),
	(8, 8, 2, NULL, 2, '化学', '1', '2017-06-28', '实验', 3, '赵睿慷', '2017-06-29', 1),
	(9, 9, 2, NULL, NULL, '语文', '1', '2017-06-28', '看书', 3, '赵睿慷', '2017-06-29', 1),
	(10, NULL, NULL, NULL, NULL, '体育', '1', '2017-06-28', '锻炼', 3, '赵睿慷', '2017-06-29', 1),
	(11, NULL, NULL, NULL, NULL, 'java', '1', '2017-06-28', '学习', 3, '赵睿慷', '2017-06-29', 1),
	(12, NULL, NULL, NULL, NULL, '广告', '1', '2017-06-28', '手工装帧', 3, '赵睿慷', '2017-06-29', 1),
	(13, NULL, NULL, NULL, NULL, '广告', '1', '2017-06-28', '设计', 3, '赵睿慷', '2017-06-29', 1),
	(14, NULL, NULL, NULL, NULL, '广告', '1', '2017-06-28', '设计海报', 3, '赵睿慷', '2017-06-29', 0),
	(15, NULL, NULL, NULL, NULL, 'vue', '1', '2017-06-28', '设计网页框架', 1, '赵睿慷', '2017-06-29', 1),
	(51, NULL, NULL, NULL, NULL, 'java', '4', '2017-07-08', '练习', 300, '赵睿慷', '2017-06-29', 1),
	(52, NULL, NULL, NULL, NULL, 'UI', '4', '2017-07-14', '好好学习', 300, '赵睿慷', '2017-07-13', 1),
	(53, NULL, NULL, NULL, NULL, '语文', '4', '2017-07-14', '好好学习', 300, NULL, NULL, 0),
	(54, NULL, NULL, NULL, NULL, '语文', '4', '2017-07-14', '好好学习', 300, NULL, NULL, 0),
	(55, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 0),
	(56, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 0),
	(57, NULL, NULL, NULL, NULL, NULL, '4', NULL, '好好学习', 300, '还', '2017-07-20', 0),
	(58, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, 0),
	(59, NULL, NULL, NULL, NULL, NULL, '2', NULL, '1111111111', 111, NULL, NULL, 0),
	(60, NULL, NULL, NULL, NULL, '环艺', '2', NULL, '好好学习天天向上', 300, NULL, NULL, 0),
	(61, NULL, NULL, 17, NULL, '环艺', '3', NULL, '好好学习天天种树', 300, NULL, NULL, 0),
	(62, NULL, NULL, NULL, NULL, NULL, '1', NULL, '1111111', 111, NULL, NULL, 0),
	(63, NULL, NULL, NULL, NULL, NULL, '321312', '2017-07-14', '31321312', 321, NULL, NULL, 0),
	(64, NULL, NULL, NULL, NULL, NULL, '11', '2017-07-13', '321312', 111, NULL, NULL, 0),
	(65, NULL, NULL, NULL, NULL, '广告设计', '3', '2017-07-14', '色彩一定要分明，创意', 300, '赵睿慷', '2017-07-15', 0),
	(66, NULL, NULL, NULL, NULL, '英语', '4', '2017-07-14', '背背背背背背', 300, '赵睿慷', '2017-07-14', 0),
	(67, NULL, NULL, NULL, NULL, NULL, '666', NULL, NULL, 666, NULL, NULL, NULL),
	(68, NULL, NULL, NULL, NULL, NULL, '2014', NULL, NULL, 2014, NULL, NULL, NULL),
	(69, NULL, NULL, NULL, NULL, NULL, '5', NULL, NULL, 44, NULL, NULL, NULL),
	(70, NULL, NULL, NULL, NULL, NULL, '5', NULL, NULL, 44, NULL, NULL, NULL),
	(71, NULL, NULL, NULL, NULL, NULL, '2014', NULL, NULL, 2014, NULL, NULL, NULL),
	(72, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, 0, NULL, NULL, NULL),
	(73, NULL, NULL, NULL, NULL, NULL, '6', NULL, NULL, 6, NULL, NULL, NULL),
	(74, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(75, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(76, NULL, NULL, NULL, NULL, '语文', '6', '2017-07-18', '国语是中国精粹', 500, '赵睿慷', '2017-07-17', 1),
	(77, NULL, NULL, NULL, NULL, '英语', '3', '2017-07-17', '学好英语', 300, '赵睿慷', '2017-07-17', 1),
	(78, NULL, NULL, NULL, NULL, '111', '11', '2017-07-17', '1111', 111, '赵睿慷', '2017-07-19', 1),
	(79, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(80, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(81, NULL, NULL, NULL, NULL, '计算机', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(82, NULL, NULL, NULL, NULL, '计算机', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(83, NULL, NULL, NULL, NULL, '计算机', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `t_major` ENABLE KEYS */;


-- 导出  表 educate.t_notice 结构
CREATE TABLE IF NOT EXISTS `t_notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `notice_name` varchar(50) NOT NULL COMMENT '公告标题',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `notice_inf` text NOT NULL COMMENT '公告详情',
  `notice_date` date NOT NULL COMMENT '公告时间',
  `notice_target` int(11) NOT NULL COMMENT '针对人群',
  `notice_create_date` date NOT NULL COMMENT '创建时间',
  `notice_modify_date` date NOT NULL COMMENT '修改时间',
  `notice_modify_person` varchar(20) NOT NULL COMMENT '修改人',
  `notice_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`notice_id`,`notice_name`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='公告表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_notice 的数据：~41 rows (大约)
DELETE FROM `t_notice`;
/*!40000 ALTER TABLE `t_notice` DISABLE KEYS */;
INSERT INTO `t_notice` (`notice_id`, `notice_name`, `teacher_id`, `notice_inf`, `notice_date`, `notice_target`, `notice_create_date`, `notice_modify_date`, `notice_modify_person`, `notice_delete`) VALUES
	(2, '公告标题', 1, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张老师', 1),
	(3, '公告提示', 2, '关于做好节假日安全通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张老师', 1),
	(4, '公告标题', 3, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张老师', 1),
	(5, '公告标题', 4, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(6, '公告标题', 5, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(7, '公告标题', 6, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(8, '公告标题', 7, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(9, '公告标题', 8, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(10, '公告标题', 9, '关于做好节假日放假通知', '2017-07-10', 2, '2017-07-10', '2017-07-10', '张三', 1),
	(11, 'noticeName', 10, 'noticeInfo', '2017-07-10', 2, '2017-07-10', '2017-07-10', 'noticeModifyName', 1),
	(12, '节假日放假通知', 10, '关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知', '2017-07-10', 1, '2017-07-10', '2017-07-10', '张三', 1),
	(13, '节假日放假通知', 9, '关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知关于做好节假日放假通知', '2017-07-10', 1, '2017-07-10', '2017-07-10', '张三', 1),
	(14, 'noticeName', 8, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(15, 'noticeName', 7, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(16, 'noticeName', 6, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(17, 'noticeName', 5, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(18, 'noticeName', 4, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(19, 'noticeName', 3, 'noticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfo', '2017-07-14', 0, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(20, 'noticeName', 2, 'noticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfonoticeInfo', '2017-07-14', 0, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(21, 'noticeName', 1, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(22, 'noticeName', 1, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(23, 'noticeName', 2, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(24, 'noticeName', 3, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(25, 'noticeName', 4, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(26, 'noticeName', 5, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(27, 'noticeName', 6, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(28, 'noticeName', 7, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(29, 'noticeName', 8, 'noticeInfo', '2017-07-14', 2, '2017-07-14', '2017-07-14', 'noticeModifyName', 1),
	(30, 'noticeName', NULL, 'noticeInfo', '2017-07-18', 2, '2017-07-18', '2017-07-18', 'noticeModifyName', 1),
	(31, 'noticeName', NULL, 'noticeInfo', '2017-07-18', 2, '2017-07-18', '2017-07-18', 'noticeModifyName', 1),
	(32, 'noticeName', NULL, 'noticeInfo', '2017-07-18', 2, '2017-07-18', '2017-07-18', 'noticeModifyName', 1),
	(33, 'noticeName', NULL, 'noticeInfo', '2017-07-18', 2, '2017-07-18', '2017-07-18', 'noticeModifyName', 1),
	(34, 'noticeName', NULL, 'noticeInfo', '2017-07-18', 2, '2017-07-18', '2017-07-18', 'noticeModifyName', 1),
	(35, 'qw', NULL, 'qw', '2017-08-09', 12, '2017-08-09', '2017-07-18', '张三', 1),
	(36, 'a', NULL, 'a', '2017-08-08', 2, '2017-08-08', '2017-07-18', '张三', 1),
	(37, 'qw', NULL, 'qw', '2017-08-09', 12, '2017-08-09', '2017-07-18', '张三', 1),
	(38, '公告1', NULL, '关于做好毕业准备', '2017-07-18', 1, '2017-07-18', '2017-07-18', '张三', 1),
	(39, '公告2', NULL, '关于毕业生挂科安排', '2017-07-18', 2, '2017-07-18', '2017-07-18', '张三', 1),
	(40, '啊啊啊', NULL, '啊啊啊啊啊啊', '2017-07-18', 2, '2017-07-18', '2017-07-18', '张三', 1),
	(41, '号外号外', NULL, '亚武山今天毕业', '2017-07-19', 2, '2017-07-19', '2017-07-19', '张三', 1),
	(42, '华育教育公告', NULL, '华育远程教育平台今天上线', '2017-07-19', 2, '2017-07-19', '2017-07-19', '张老师', 1);
/*!40000 ALTER TABLE `t_notice` ENABLE KEYS */;


-- 导出  表 educate.t_part_section 结构
CREATE TABLE IF NOT EXISTS `t_part_section` (
  `part_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '小节编号',
  `video_id` int(11) DEFAULT '0' COMMENT '视频编号',
  `section_id` int(11) DEFAULT NULL COMMENT '章节编号',
  `part_id_name` varchar(200) NOT NULL COMMENT '小节编号名(例如：第一讲)',
  `part_name` varchar(50) NOT NULL COMMENT '小节名称',
  `part_frequence` int(11) NOT NULL COMMENT '访问次数',
  `part_addtime` date NOT NULL COMMENT '发布时间',
  `part_modify_person` varchar(200) NOT NULL COMMENT '修改人',
  `part_modify_date` date NOT NULL COMMENT '修改时间',
  `part_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='小节表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_part_section 的数据：~12 rows (大约)
DELETE FROM `t_part_section`;
/*!40000 ALTER TABLE `t_part_section` DISABLE KEYS */;
INSERT INTO `t_part_section` (`part_id`, `video_id`, `section_id`, `part_id_name`, `part_name`, `part_frequence`, `part_addtime`, `part_modify_person`, `part_modify_date`, `part_delete`) VALUES
	(1, 5, 1, '第一讲', '1.1 jdk的环境搭建', 1000, '2017-07-03', 'zhangsan', '2017-07-13', 1),
	(2, 0, 1, '第二讲', '1.2 JVM是什么', 1000, '2017-07-03', '杨振欣', '2017-07-03', 1),
	(3, 6, 2, '第一讲', '2.1 Java常用数据类型', 1000, '2017-07-03', 'zhangsan', '2017-07-14', 1),
	(5, 7, 3, 'aaaaa', 'cccccccccccccccccccccccccccccc', 1003, '2012-09-09', 'zhangsan', '2017-07-15', 1),
	(7, 0, 1, '不必填写', '1.3 跑谁人解', 1, '2017-07-11', 'zhangsan', '2017-07-11', 1),
	(8, 8, 27, '不必填写', '阿萨德发生的发生的发斯蒂芬', 0, '2017-07-11', 'zhangsan', '2017-07-15', 1),
	(9, 0, 29, '不必填写', '阿萨德发生的发生', 0, '2017-07-11', 'zhangsan', '2017-07-12', 1),
	(10, 0, 29, '不必填写', '阿萨德发生的方法的太阳镜越靠近', 0, '2017-07-11', 'zhangsan', '2017-07-12', 1),
	(11, 0, 1, '不必填写', '阿萨德法师打发', 0, '2017-07-11', 'zhangsan', '2017-07-11', 1),
	(12, 0, 1, '不必填写', 'asdfasdfasdfasdfasdfasdfasd', 0, '2017-07-13', 'zhangsan', '2017-07-13', 1),
	(13, 0, 1, '不必填写', '阿萨德发色', 0, '2017-07-13', 'zhangsan', '2017-07-13', 1),
	(14, 0, 1, '不必填写', '12234545', 1, '2017-07-13', 'zhangsan', '2017-07-19', 0);
/*!40000 ALTER TABLE `t_part_section` ENABLE KEYS */;


-- 导出  表 educate.t_permission 结构
CREATE TABLE IF NOT EXISTS `t_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(50) NOT NULL,
  `permission_type` varchar(20) DEFAULT NULL,
  `permission_url` varchar(30) DEFAULT NULL,
  `permission_code` varchar(255) DEFAULT NULL,
  `permission_delete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  educate.t_permission 的数据：~18 rows (大约)
DELETE FROM `t_permission`;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` (`permission_id`, `permission_name`, `permission_type`, `permission_url`, `permission_code`, `permission_delete`) VALUES
	(1, '登陆主页', 'menu', '/home', 'all:home', '1'),
	(2, '所有主页', 'menu', '/jiaowu', 'all:home', '1'),
	(3, '教务主页', 'menu', '/jiao_11', 'manager:home', '1'),
	(4, '学生管理', 'menu', '/jiao_12', 'manager:student', '1'),
	(5, '学费管理', 'menu', '/jiao_13', 'manager:xuefei', '1'),
	(6, '教学管理', 'menu', '/jiao_14', 'manager:jiaoxue', '1'),
	(7, '教师管理', 'menu', '/jiao_15', 'manager:teacher', '1'),
	(8, '专业管理', 'menu', '/jiao_16', 'manager:major', '1'),
	(9, '课程管理', 'menu', '/jiao_17', 'manager:kecheng', '1'),
	(10, '教学计划', 'menu', '/jiao_18', 'manager:jiao', '0'),
	(11, '异动审核', 'menu', '/jiao_19', 'manager:yidong', '1'),
	(12, '教师主页', 'menu', '/shi_21', 'teacher:index', '1'),
	(13, '成绩管理', 'menu', '/shi_22', 'teacher:chengji', '1'),
	(14, '考试管理', 'menu', '/shi_23', 'teacher:exam', '1'),
	(15, '视频答疑', 'menu', '/my_1', 'teacher:videodayi', '1'),
	(16, '论坛答疑', 'menu', '/my_2', 'teacher:luntan', '1'),
	(17, '课程通知', 'menu', '/shi_24', 'teacher:course', '1'),
	(18, '权限管理', 'menu', '/quanxian', 'super:quanxian', '1');
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;


-- 导出  表 educate.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限表编号',
  `role_name` varchar(255) NOT NULL,
  `role_desc` varchar(20) DEFAULT NULL COMMENT '等级说明',
  `role_delete` int(11) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='教师等级表，包含教师以及管理员';

-- 正在导出表  educate.t_role 的数据：~8 rows (大约)
DELETE FROM `t_role`;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`role_id`, `role_name`, `role_desc`, `role_delete`) VALUES
	(0, 'super', '超级管理员', 1),
	(1, 'manager', '管理人员', 1),
	(2, 'teacher', '普通教师', 1),
	(3, 'recruit', '审核人员', 1),
	(4, 'test', '测试人员1', 0),
	(5, 'test', '测试人员2', 1),
	(6, 'test', '测试人员3', 1),
	(46, '张三', '超级管理员', 0);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;


-- 导出  表 educate.t_role_permission 结构
CREATE TABLE IF NOT EXISTS `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限表编号',
  `role_id` int(11) DEFAULT NULL COMMENT '角色编号',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限编号',
  `delete_status` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色权限表，多对多衍生出的表';

-- 正在导出表  educate.t_role_permission 的数据：~5 rows (大约)
DELETE FROM `t_role_permission`;
/*!40000 ALTER TABLE `t_role_permission` DISABLE KEYS */;
INSERT INTO `t_role_permission` (`id`, `role_id`, `permission_id`, `delete_status`) VALUES
	(1, 0, 18, 1),
	(2, 0, 1, 1),
	(3, 0, 2, 0),
	(4, 0, 3, 0),
	(5, 46, 1, 1);
/*!40000 ALTER TABLE `t_role_permission` ENABLE KEYS */;


-- 导出  表 educate.t_score 结构
CREATE TABLE IF NOT EXISTS `t_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩表编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `score_play` int(11) DEFAULT NULL COMMENT '课件点播分数',
  `score_ontime` int(11) DEFAULT NULL COMMENT '在线时间分数',
  `score_test` int(11) DEFAULT NULL COMMENT '小节测试分数',
  `score_exam` int(11) DEFAULT NULL COMMENT '课程结业考试分数',
  `score_credit` int(11) DEFAULT NULL COMMENT '学生每门课学分',
  `score_create_date` date DEFAULT NULL COMMENT '创建时间',
  `modify_person` varchar(20) DEFAULT NULL COMMENT '修改人',
  `modify_date` date DEFAULT NULL COMMENT '修改时间',
  `score_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='学生成绩表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_score 的数据：~19 rows (大约)
DELETE FROM `t_score`;
/*!40000 ALTER TABLE `t_score` DISABLE KEYS */;
INSERT INTO `t_score` (`score_id`, `course_id`, `student_id`, `score_play`, `score_ontime`, `score_test`, `score_exam`, `score_credit`, `score_create_date`, `modify_person`, `modify_date`, `score_delete`) VALUES
	(1, 1, 1, 20, 10, 22, 0, 100, '2017-06-29', '冯云威', '2017-07-24', 1),
	(2, 1, 2, 10, 10, 10, 10, 100, '2017-07-02', '冯云威', '2017-07-13', 1),
	(3, 2, 1, 10, 10, 10, 20, 100, '2017-07-13', '冯云威', '2017-07-18', 1),
	(4, 1, 4, 20, 20, 20, 20, 100, '2017-07-13', 'fenyunwei', '2017-07-13', 1),
	(5, 1, 3, 20, 20, 20, 20, 100, '2017-07-13', 'fenyunwei', '2017-07-13', 1),
	(6, 2, 8, 10, 10, 10, 10, 100, '2017-07-13', 'fengyunwei', '2017-07-13', 1),
	(7, 2, 8, 10, 10, 10, 10, 100, '2017-07-13', 'fengyunwei', '2017-07-13', 1),
	(8, 35, 16, 10, 10, 10, 10, 100, '2017-07-14', 'fengyunwei', '2017-07-14', 1),
	(9, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(10, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(11, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(12, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(13, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(14, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(15, 2, 16, 10, 10, 10, 12, 10, '2017-07-14', '冯云威', '2017-07-20', 1),
	(16, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(17, 2, 16, 10, 10, 10, 10, 10, '2017-07-14', 'fengyunweo ', '2017-07-14', 1),
	(18, 1, 1, 10, 10, 60, 0, NULL, NULL, '冯云威', '2017-07-20', NULL),
	(19, 38, 2, 10, 10, 10, 10, 100, '2017-07-20', 'fengyunwei', '2017-07-20', 1);
/*!40000 ALTER TABLE `t_score` ENABLE KEYS */;


-- 导出  表 educate.t_section 结构
CREATE TABLE IF NOT EXISTS `t_section` (
  `section_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '章节编号',
  `score_id` int(10) DEFAULT NULL COMMENT '成绩表编号',
  `section_test_id` int(11) DEFAULT NULL COMMENT '章节测试编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `section_name` varchar(50) NOT NULL COMMENT '章节名称',
  `section_addtime` date NOT NULL COMMENT '发布时间',
  `section_modify_person` varchar(200) NOT NULL COMMENT '修改人',
  `section_modify_date` date NOT NULL COMMENT '修改时间',
  `section_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='章节表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_section 的数据：~11 rows (大约)
DELETE FROM `t_section`;
/*!40000 ALTER TABLE `t_section` DISABLE KEYS */;
INSERT INTO `t_section` (`section_id`, `score_id`, `section_test_id`, `course_id`, `teacher_id`, `section_name`, `section_addtime`, `section_modify_person`, `section_modify_date`, `section_delete`) VALUES
	(1, 1, 1, 1, 1, '第1章 搭建java的开发环境', '2017-06-29', 'zhangsan', '2017-07-11', 1),
	(2, 1, 2, 1, 1, '第二章 Java语言基础', '2017-06-29', 'zhangsan', '2017-07-12', 1),
	(3, NULL, NULL, 1, 1, 'java面对对象', '2017-06-09', 'zhangsan', '2017-06-09', 1),
	(27, NULL, NULL, 1, 1, '过户接口', '2017-07-10', 'zhangsan', '2017-07-11', 1),
	(28, NULL, NULL, 1, 1, '阿萨德发色的父', '2017-07-10', 'zhangsan', '2017-07-19', 0),
	(29, NULL, NULL, 2, 1, '123456', '2017-07-10', 'zhangsan', '2017-07-12', 1),
	(30, NULL, NULL, 2, 1, '5.2asopdifghpsfgasp[0eifgp-0asrhp0sae9', '2017-07-13', 'zhangsan', '2017-07-13', 1),
	(31, NULL, NULL, 2, 1, '抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱抱吧', '2017-07-13', 'zhangsan', '2017-07-14', 1),
	(32, NULL, NULL, 2, 1, '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', '2017-07-13', 'zhangsan', '2017-07-14', 1),
	(33, NULL, NULL, 1, 1, 'eeeeeeeeeeeeee', '2017-07-19', 'zhangsan', '2017-07-19', 0),
	(34, NULL, NULL, 1, 1, '听听听听听听听听听听听听听听他天天', '2017-07-20', 'zhangsan', '2017-07-20', 0);
/*!40000 ALTER TABLE `t_section` ENABLE KEYS */;


-- 导出  表 educate.t_section_score 结构
CREATE TABLE IF NOT EXISTS `t_section_score` (
  `section_score_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '章节测试成绩表编号',
  `section_id` int(10) DEFAULT NULL COMMENT '章节编号',
  `score_test` int(10) DEFAULT NULL COMMENT '章节测试分数',
  `student_id` int(10) DEFAULT NULL COMMENT '学生编号',
  PRIMARY KEY (`section_score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='学生章节测试成绩表';

-- 正在导出表  educate.t_section_score 的数据：~1 rows (大约)
DELETE FROM `t_section_score`;
/*!40000 ALTER TABLE `t_section_score` DISABLE KEYS */;
INSERT INTO `t_section_score` (`section_score_id`, `section_id`, `score_test`, `student_id`) VALUES
	(1, 1, 30, 1);
/*!40000 ALTER TABLE `t_section_score` ENABLE KEYS */;


-- 导出  表 educate.t_section_test 结构
CREATE TABLE IF NOT EXISTS `t_section_test` (
  `section_test_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '章节测试编号',
  `section_id` int(11) DEFAULT NULL COMMENT '章节编号',
  `section_test_time` date DEFAULT NULL COMMENT '考试时间',
  `section_test_state` int(11) DEFAULT NULL COMMENT '可测验状态',
  `section_test_score` int(11) DEFAULT NULL COMMENT '章节分数',
  `section_test_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`section_test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='章节测试表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_section_test 的数据：~2 rows (大约)
DELETE FROM `t_section_test`;
/*!40000 ALTER TABLE `t_section_test` DISABLE KEYS */;
INSERT INTO `t_section_test` (`section_test_id`, `section_id`, `section_test_time`, `section_test_state`, `section_test_score`, `section_test_delete`) VALUES
	(1, 1, '2017-07-03', 1, 60, 1),
	(2, 2, '2017-07-03', 1, 60, 1);
/*!40000 ALTER TABLE `t_section_test` ENABLE KEYS */;


-- 导出  表 educate.t_select 结构
CREATE TABLE IF NOT EXISTS `t_select` (
  `select_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `store_id` int(11) DEFAULT NULL COMMENT '题库编号',
  `select_name` varchar(50) NOT NULL COMMENT '题目名称',
  `select_a` varchar(200) NOT NULL COMMENT '选项a',
  `select_b` varchar(200) NOT NULL COMMENT '选项b',
  `select_c` varchar(200) NOT NULL COMMENT '选项c',
  `select_d` varchar(200) NOT NULL COMMENT '选项d',
  `select_answer` varchar(200) NOT NULL COMMENT '答案',
  `select_point` int(11) NOT NULL COMMENT '分值',
  `select_addtime` date DEFAULT NULL COMMENT '录题时间',
  `select_modify_date` date DEFAULT NULL COMMENT '修改时间',
  `select_modify_person` varchar(50) DEFAULT NULL COMMENT '修改人',
  `select_delete` int(11) NOT NULL COMMENT '删除状态',
  `score_type` int(10) DEFAULT NULL COMMENT '题库类型(1为期末考试，2为章节测试，3为入学测试)',
  `course_id` int(10) DEFAULT NULL COMMENT '课程编号',
  `section_test_id` int(10) DEFAULT NULL COMMENT '章节测试编号',
  `enter_test_type` int(10) DEFAULT NULL COMMENT '入学测试类型（1为专升本，2为高升专）',
  PRIMARY KEY (`select_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='选择题表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_select 的数据：~54 rows (大约)
DELETE FROM `t_select`;
/*!40000 ALTER TABLE `t_select` DISABLE KEYS */;
INSERT INTO `t_select` (`select_id`, `teacher_id`, `store_id`, `select_name`, `select_a`, `select_b`, `select_c`, `select_d`, `select_answer`, `select_point`, `select_addtime`, `select_modify_date`, `select_modify_person`, `select_delete`, `score_type`, `course_id`, `section_test_id`, `enter_test_type`) VALUES
	(1, 1, 1, '帅是guy', '是', '否', '好', '不好', 'D', 2, '2017-07-06', '2017-07-18', '李志鹏', 0, 1, 1, NULL, NULL),
	(2, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 0, 1, 1, NULL, NULL),
	(3, 1, 1, 'asd', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-18', '李志鹏', 0, 1, 1, NULL, NULL),
	(4, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(5, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(6, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, NULL, NULL),
	(7, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, 1, NULL),
	(8, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, 1, NULL),
	(9, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, 1, NULL),
	(10, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, 1, NULL),
	(11, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 1, 1, NULL),
	(12, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 1, NULL),
	(13, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(14, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(15, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(16, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(17, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(18, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(19, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(20, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(21, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 1, 2, 2, NULL),
	(22, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(23, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(24, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(25, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(26, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(27, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, 2, NULL, 2, NULL),
	(28, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(29, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(30, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(31, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(32, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(33, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(34, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 1, NULL),
	(35, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 2, NULL),
	(36, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 2, NULL),
	(37, 1, 1, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-06', '2017-07-06', 'zr', 1, NULL, NULL, 2, NULL),
	(38, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, NULL, NULL, 2, NULL),
	(39, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, NULL, NULL, 2, NULL),
	(40, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, NULL, NULL, 2, NULL),
	(41, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 1),
	(42, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 1),
	(43, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 1),
	(44, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 1),
	(45, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 2),
	(46, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 2),
	(47, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 0, 0, 2),
	(48, 1, 2, 'int有几个字节', '1', '2', '3', '4', 'D', 2, '2017-07-07', '2017-07-07', 'ZR', 1, 3, 3, 0, 2),
	(49, NULL, NULL, '0', '0', '0', '0', '0', 'D', 2, '2017-07-18', NULL, NULL, 1, 2, 1, 2, NULL),
	(50, NULL, NULL, '9', '9', '9', '9', '9', 'A', 2, '2017-07-18', NULL, NULL, 1, 1, 39, NULL, NULL),
	(51, NULL, NULL, '8', '8', '8', '8', '8', 'D', 2, '2017-07-18', NULL, NULL, 1, 3, NULL, NULL, 2),
	(52, NULL, NULL, '帅帅是个GUY', '是', '不是', '中兴', '12', 'A', 2, '2017-07-18', NULL, NULL, 1, 2, 2, 30, NULL),
	(53, NULL, NULL, '帅帅是个GUY', '直的', '弯的', '是的', '错误', 'A', 2, '2017-07-19', NULL, NULL, 1, 2, 1, 2, NULL),
	(54, NULL, NULL, '帅帅和', '2', '2', '22', '22', 'C', 3, '2017-07-19', NULL, NULL, 1, 2, 2, 31, NULL);
/*!40000 ALTER TABLE `t_select` ENABLE KEYS */;


-- 导出  表 educate.t_store 结构
CREATE TABLE IF NOT EXISTS `t_store` (
  `store_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题库编号',
  `store_name` varchar(50) NOT NULL COMMENT '题库名称',
  `store_explain` varchar(200) NOT NULL COMMENT '题库说明',
  `store_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='题库表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_store 的数据：~2 rows (大约)
DELETE FROM `t_store`;
/*!40000 ALTER TABLE `t_store` DISABLE KEYS */;
INSERT INTO `t_store` (`store_id`, `store_name`, `store_explain`, `store_delete`) VALUES
	(1, 'java课程', '针对java', 1),
	(2, 'php', '针对php', 1);
/*!40000 ALTER TABLE `t_store` ENABLE KEYS */;


-- 导出  表 educate.t_student 结构
CREATE TABLE IF NOT EXISTS `t_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `thesis_id` int(11) DEFAULT NULL COMMENT '论文表编号',
  `student_password` varchar(20) NOT NULL COMMENT '密码',
  `student_name` varchar(20) NOT NULL COMMENT '学生姓名',
  `student_sex` varchar(5) NOT NULL COMMENT '性别',
  `student_nation` varchar(50) NOT NULL COMMENT '民族',
  `student_idcard` varchar(40) NOT NULL COMMENT '身份证号',
  `student_phone` varchar(30) NOT NULL COMMENT '手机号',
  `student_graduate` varchar(50) NOT NULL COMMENT '毕业院校',
  `student_birth` date NOT NULL COMMENT '出生日期',
  `student_address` varchar(100) NOT NULL COMMENT '家庭住址',
  `student_education` varchar(40) NOT NULL COMMENT '学历',
  `student_certificate` varchar(100) NOT NULL COMMENT '毕业证照片',
  `student_photo` varchar(100) NOT NULL COMMENT '二寸照片',
  `student_email` varchar(20) NOT NULL COMMENT '邮箱',
  `student_date` date NOT NULL COMMENT '入学日期',
  `student_type` varchar(50) NOT NULL COMMENT '所选类型（升学类型）',
  `student_first_money` decimal(10,2) NOT NULL COMMENT '第一次缴费',
  `student_first_money_time` date NOT NULL COMMENT '第一次缴费时间',
  `student_second_money` decimal(10,2) DEFAULT NULL COMMENT '第二次缴费',
  `student_second_money_time` date DEFAULT NULL COMMENT '第二次缴费时间',
  `student_modify_person` varchar(30) NOT NULL COMMENT '修改人',
  `student_modify_date` date NOT NULL COMMENT '修改时间',
  `student_last_time` date NOT NULL COMMENT '最后在线时间',
  `student_total_time` varchar(30) NOT NULL COMMENT '总计在线时长',
  `student_graduation` varchar(20) NOT NULL COMMENT '是否毕业',
  `student_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2005 DEFAULT CHARSET=utf8 COMMENT='学生表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_student 的数据：~26 rows (大约)
DELETE FROM `t_student`;
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` (`student_id`, `major_id`, `thesis_id`, `student_password`, `student_name`, `student_sex`, `student_nation`, `student_idcard`, `student_phone`, `student_graduate`, `student_birth`, `student_address`, `student_education`, `student_certificate`, `student_photo`, `student_email`, `student_date`, `student_type`, `student_first_money`, `student_first_money_time`, `student_second_money`, `student_second_money_time`, `student_modify_person`, `student_modify_date`, `student_last_time`, `student_total_time`, `student_graduation`, `student_delete`) VALUES
	(1, 1, 1, '123', 'zhangasd', '男', '汉', '401504105840322358', '254', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '', '2017-06-29', '专升本', 132.00, '2017-06-29', 4500.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(2, 2, 2, '123', '李四', '男', '汉', '411082199601170668', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-06-29', 1300.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(3, 1, 2, '123', '啊大', '女', '汉', '411082199601170667', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-07-18', 13.00, '2017-07-18', '张三', '2017-07-18', '2017-06-29', '132', '13', 1),
	(4, 3, 2, '123', '张三三', '男', '汉', '41108500', '159000000000', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(5, 4, NULL, '123', '5', '5', '汉', '5', '5', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(6, 5, NULL, '123', '李喵喵', '男', '汉', '411082199601170665', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(7, 2, NULL, '123', '李课', '男', '汉', '411082199301170664', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(8, 1, NULL, '123', '李平', '女', '汉', '45345524', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(9, 2, NULL, '123', '赵来', '男', '汉', '411082199701170668', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(10, 3, NULL, '123', '李梦', '女', '汉', '45343546342', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(11, 2, NULL, '123', '李g', '男', '汉', '4524', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(12, 4, NULL, '123', '张翻', '女', '汉', '5245452470664', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(13, 2, NULL, '123', '刘第', '男', '汉', '45252354363456', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(14, 3, NULL, '123', '张喔', '男', '汉', '411082199901170668', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(15, 2, NULL, '123', '刘歌', '女', '汉', '45345634787634234', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(16, 1, NULL, '123', '李包', '男', '汉', '5434563453434', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 1),
	(17, 5, NULL, '123', '杨赋', '女', '汉', '543434', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '专升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(18, 3, NULL, '123', '李时', '男', '汉', '45346345', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(19, 5, NULL, '123', '李王', '男', '汉', '54254664', '15937499187', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(20, 6, NULL, '123', '20', '20', '汉', '20', '20', '郑州旅游职业学院', '2017-06-29', '郑州市金水区26号', '大专', '13', '13', '1581223692@qq.com', '2017-06-29', '高升本', 132.00, '2017-06-29', 13.00, '2017-06-29', '赵润', '2017-06-29', '2017-06-29', '132', '13', 0),
	(25, 5, 3, '123', 'limeb', '女', '汉', '411082419952311', 'c://w', '许昌学院', '2015-05-09', '郑州市金水区', '大专', 'jac://', 'f://', '1581223232@qq.com', '2016-09-05', '专升本', 2505.00, '2016-09-08', 2501.00, '2015-08-09', '李梦', '2017-07-09', '2017-07-09', '2017-07-09', '否', 0),
	(26, 5, 3, '123456', 'zz', 'nv', 'han', '1235', 'ddd', 'ddd', '2017-12-04', 'ddd', 'ddd', 'dd', 'dd', 'dd', '2017-12-04', 'ddd', 0.00, '2017-12-04', NULL, NULL, 'dd', '2017-12-04', '2017-12-04', '232', '1', 1),
	(2000, 2, 3, '000000', '李阿斯顿', '男', '汉', '254052640560', '15898426416', '郑大', '2017-05-08', '18548@qq', '大专', 'khjmjblkmol', 'zhopain', '金水区', '2016-08-05', '专升本', 2500.00, '2015-08-06', 2510.00, '2016-05-08', 'zhangsan', '2018-08-05', '2016-08-07', '2016-7-08', '否', 1),
	(2002, NULL, NULL, '123', '张露林', '男', '汉', '9123456789123456009', '15915915915', '开封大学', '2017-07-05', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '124', '2017-07-05', '0', 4500.00, '2017-07-21', NULL, NULL, '张三', '2017-07-21', '2017-07-21', '0', '未毕业', 1),
	(2003, NULL, NULL, '123', '张露林', '男', '汉', '9123456789123456009', '15915915915', '开封大学', '2017-07-05', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '124', '2017-07-05', '0', 4500.00, '2017-07-21', NULL, NULL, '张三', '2017-07-21', '2017-07-21', '0', '未毕业', 1),
	(2004, NULL, NULL, '123', '张露林', '男', '汉', '9123456789123456009', '15915915915', '开封大学', '2017-07-05', '河南郑州', '大专', 'p02.jpg', 'p01.jpg', '124', '2017-07-05', '0', 4500.00, '2017-07-21', NULL, NULL, '张三', '2017-07-21', '2017-07-21', '0', '未毕业', 1);
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;


-- 导出  表 educate.t_studentquiz 结构
CREATE TABLE IF NOT EXISTS `t_studentquiz` (
  `quiz_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '提问表编号',
  `video_id` int(11) DEFAULT NULL COMMENT '视频编号',
  `reply_id` int(11) DEFAULT NULL COMMENT '回复表编号',
  `quiz_date` date NOT NULL COMMENT '提问日期',
  `quiz_content` text NOT NULL COMMENT '提问内容',
  `quiz_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='视频提问(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_studentquiz 的数据：~13 rows (大约)
DELETE FROM `t_studentquiz`;
/*!40000 ALTER TABLE `t_studentquiz` DISABLE KEYS */;
INSERT INTO `t_studentquiz` (`quiz_id`, `video_id`, `reply_id`, `quiz_date`, `quiz_content`, `quiz_delete`) VALUES
	(1, 1, 1, '2017-07-04', '如果世界漆黑，其实你很美.', 1),
	(2, 2, 2, '2017-07-08', '三分归元气.', 1),
	(3, 3, 3, '2017-07-11', '龟派气功', 1),
	(4, 4, 4, '2017-07-11', '魔风波', 1),
	(5, 5, 5, '2017-07-14', '比克大魔王', 0),
	(6, 6, 6, '2017-06-11', '丽', 0),
	(7, 7, 7, '2017-07-14', '车速', 0),
	(8, 8, 8, '2017-07-15', 'Superstart', 0),
	(9, 9, 9, '2017-07-18', '亚武山必胜', 1),
	(10, 10, 10, '2017-07-16', '演员', 0),
	(11, 11, 11, '2017-06-26', '未来', 0),
	(12, 12, 12, '2017-06-26', '左半角天空', 1),
	(13, 13, 13, '2017-07-14', '一起来看流星雨', 0);
/*!40000 ALTER TABLE `t_studentquiz` ENABLE KEYS */;


-- 导出  表 educate.t_study_resource 结构
CREATE TABLE IF NOT EXISTS `t_study_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资料编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `resource_name` varchar(100) NOT NULL COMMENT '资料名称',
  `resource_title` varchar(100) NOT NULL COMMENT '资料标题',
  `resource_describe` varchar(200) NOT NULL COMMENT '资料描述',
  `resource_frequence` int(11) NOT NULL COMMENT '访问次数',
  `resource_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='导学资源表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_study_resource 的数据：~24 rows (大约)
DELETE FROM `t_study_resource`;
/*!40000 ALTER TABLE `t_study_resource` DISABLE KEYS */;
INSERT INTO `t_study_resource` (`resource_id`, `teacher_id`, `course_id`, `resource_name`, `resource_title`, `resource_describe`, `resource_frequence`, `resource_delete`) VALUES
	(1, 1, 1, 'ava第一章test', 'javaTes333333333333333333333', 'Test3', 1, 0),
	(2, 1, 2, 'ava第一章test2', 'javaTest2', 'Test3', 5, 1),
	(3, 1, 1, 'ava第一章test3', 'javaTest', 'Test3', 3, 1),
	(4, 1, 2, 'ava第一章test4', 'javaTest', 'Test33', 0, 1),
	(5, 1, 1, 'ava第一章test3', '呀呀呀呀呀呀呀有2', '呀呀呀呀呀呀呀呀呀呀有', 0, 1),
	(6, 1, 2, 'test6', 'test6', 'test6', 0, 1),
	(7, 1, 30, 'name', 'title', 'xiangiqng', 0, 1),
	(8, 1, 40, 'name', 'title', 'xiangiqng', 0, 1),
	(9, 1, 31, 'name', 'title', 'xiangiqng', 0, 1),
	(10, 1, 39, 'name', 'title', 'xiangiqng', 0, 1),
	(11, 1, 32, 'name', 'title', 'xiangiqng', 0, 1),
	(12, 1, 38, 'name2', '2222', '22222', 0, 1),
	(13, 1, 33, 'tt', 'tt', 'tt', 0, 1),
	(14, 1, 37, '333333', '33', '33333', 0, 1),
	(15, 1, 34, 'a', 'a', 'a', 0, 1),
	(16, 1, 36, 'aa', 'aa', 'aa', 0, 1),
	(17, 1, 35, '万网2', '万网2', '万网2', 0, 1),
	(18, 1, 40, '99', '99', '99', 0, 1),
	(19, 1, 1, '0', '0', '0', 0, 1),
	(20, 1, 30, 'ii', 'ii', 'ii', 0, 1),
	(21, 1, 35, 'y', 'y', 'y', 0, 1),
	(22, 1, 38, 'tt', 'tt', 'tt', 0, 1),
	(23, 1, 36, 'ddd', 'ddd', 'ddd', 0, 1),
	(24, 0, 0, 'erer', 'erer', 'erer', 0, 1);
/*!40000 ALTER TABLE `t_study_resource` ENABLE KEYS */;


-- 导出  表 educate.t_teacher 结构
CREATE TABLE IF NOT EXISTS `t_teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `course_id` int(11) DEFAULT NULL COMMENT '课程编号',
  `role_id` int(11) DEFAULT NULL COMMENT '权限等级编号',
  `teacher_password` varchar(40) DEFAULT NULL COMMENT '登录密码',
  `teacher_realname` varchar(20) DEFAULT NULL COMMENT '教师姓名',
  `teacher_birth` date DEFAULT NULL COMMENT '出生日期',
  `teacher_sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `teacher_political` varchar(20) DEFAULT NULL COMMENT '政治面貌',
  `teacher_national` varchar(40) DEFAULT NULL COMMENT '民族',
  `teacher_record` varchar(20) DEFAULT NULL COMMENT '最高学历',
  `teacher_native` varchar(100) DEFAULT NULL COMMENT '籍贯',
  `teacher_school` varchar(40) DEFAULT NULL COMMENT '毕业院校',
  `teacher_degree` varchar(20) DEFAULT NULL COMMENT '最高学位',
  `teacher_email` varchar(40) DEFAULT NULL COMMENT '邮箱',
  `teacher_phone` varchar(30) DEFAULT NULL COMMENT '联系方式',
  `teacher_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `teacher_category` varchar(30) DEFAULT NULL COMMENT '教师类别',
  `teacher_training` text COMMENT '进修情况',
  `teacher_reward` text COMMENT '曾获奖励',
  `teacher_punish` text COMMENT '曾获处分',
  `teacher_detail` text COMMENT '个人简介',
  `teacher_photo` varchar(200) DEFAULT NULL COMMENT '照片',
  `teacher_create_date` date DEFAULT NULL COMMENT '创建时间',
  `teacher_last_logindate` date DEFAULT NULL COMMENT '上次登录时间',
  `teacher_login_sumtime` int(11) DEFAULT NULL COMMENT '登录时长',
  `teacher_modify_person` varchar(50) DEFAULT NULL COMMENT '修改人',
  `teacher_modify_date` date DEFAULT NULL COMMENT '修改时间',
  `teacher_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='教师表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_teacher 的数据：~23 rows (大约)
DELETE FROM `t_teacher`;
/*!40000 ALTER TABLE `t_teacher` DISABLE KEYS */;
INSERT INTO `t_teacher` (`teacher_id`, `course_id`, `role_id`, `teacher_password`, `teacher_realname`, `teacher_birth`, `teacher_sex`, `teacher_political`, `teacher_national`, `teacher_record`, `teacher_native`, `teacher_school`, `teacher_degree`, `teacher_email`, `teacher_phone`, `teacher_address`, `teacher_category`, `teacher_training`, `teacher_reward`, `teacher_punish`, `teacher_detail`, `teacher_photo`, `teacher_create_date`, `teacher_last_logindate`, `teacher_login_sumtime`, `teacher_modify_person`, `teacher_modify_date`, `teacher_delete`) VALUES
	(0, 1, 0, '123456', '张三', '2017-07-19', '男', 'dangyuan', '汉', '博士', '河南', '郑州大学', '学士', '120@qq.com', '1231321231321', '郑州', '教授', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-07-19', '2017-07-19', 2131654, '0', '2017-07-19', 1),
	(1, 1, 1, '123456', '张三', '2017-06-29', '女', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '1111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(2, 2, 2, '123456', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(3, 3, 3, '123456', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(4, 4, 3, '123456', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(5, 5, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(6, 6, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(7, 7, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(8, 8, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(9, 9, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '张恒', '2017-06-29', 1),
	(10, 10, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '', '2017-06-29', 1),
	(11, 11, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(27, 27, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(28, 28, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(29, 29, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(30, 30, 2, '111', '张三', '2017-06-29', '男', '共青团员', '汉', '本科', '河南', '河大', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(31, 1, 2, '123', '张三', '2017-07-18', '女', '共青团员', '汉', '汉', '河南', '郑州大学', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(32, 1, 1, '123456', '张三', '2017-07-17', '男', '党员', '汉', '博士', '河南', '云和', '博士', '11111@qq.com', '1111111', '河南郑州', '高级教师', '好好学习,天天向上', '诺贝尔文学奖', '无', '各种奖项', '暂无', '2017-06-29', '2017-06-29', 213654615, '0', '2017-06-29', 1),
	(41, 1, 2, '123', '张三', '2017-07-19', '女', '共青团员', '汉', '汉', '河南', '郑州大学', '学士', '122@qq.com', '111', '河南', '高级讲师', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-07-19', '2017-07-19', 121313131, '0', '2017-07-19', 1),
	(42, 1, 2, '123', '张三', '2017-07-19', '男', 'dangyuan', '汉', '博士', '河南', '洛阳', '学士', '120@qq.com', '123456789', '美国', '副院士', '暂无', '暂无', '暂无', '暂无', '暂无', '2017-07-19', '2017-07-19', 12313213, '0', '2017-07-19', 0),
	(44, 1, 3, '132', '张三111', '2017-07-19', '男', 'dangyuan', '汉', '大专', '河南', '洛阳', '博士', '123456@qq.com', '12345646', '郑州', '教授', '暂无', '暂无', '暂无', '责任心强', '暂无', '2017-07-19', '2017-07-19', 2131654, '0', '2017-07-19', 1),
	(45, 1, 0, '123456', '张三', '2017-07-19', '男', 'dangyuan', '汉', 'ceo', '河南', '洛阳', '教师', '123@qq.com', '13525091111', '郑州', '副院士', '留学', '阿斯兰的法师', '武', '责任心强', '暂无', '2017-07-19', '2017-07-19', 2131654, '0', '2017-07-19', 1),
	(46, 38, 2, '123456', '张三', '2017-07-20', '男', 'dangyuan', '汉', '博士', '河南', '洛阳', '教师', '120@qq.com', '1352545544', '洛阳', '副院士', '留学', '无', '无', '爱学习', '暂无', '2017-07-20', '2017-07-20', 2131654, '0', '2017-07-20', 0);
/*!40000 ALTER TABLE `t_teacher` ENABLE KEYS */;


-- 导出  表 educate.t_teacherreply 结构
CREATE TABLE IF NOT EXISTS `t_teacherreply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复表编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `quiz_id` int(11) DEFAULT NULL COMMENT '提问表编号',
  `reply_Time` date NOT NULL COMMENT '回复时间',
  `reply_content` text NOT NULL COMMENT '回复内容',
  `reply_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COMMENT='教师回复表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_teacherreply 的数据：~16 rows (大约)
DELETE FROM `t_teacherreply`;
/*!40000 ALTER TABLE `t_teacherreply` DISABLE KEYS */;
INSERT INTO `t_teacherreply` (`reply_id`, `teacher_id`, `quiz_id`, `reply_Time`, `reply_content`, `reply_delete`) VALUES
	(1, 1, 1, '2017-07-05', '还行', 1),
	(2, 2, 2, '2017-05-05', 'dsadsadsadsada', 1),
	(3, 3, 3, '2017-07-13', 'myaaWQQQ', 1),
	(4, 4, 4, '2017-07-14', '一般般', 1),
	(5, 5, 5, '2017-07-14', '还可以', 1),
	(6, 6, 6, '2017-07-14', '的', 1),
	(7, 7, 7, '2017-07-14', '车速', 1),
	(8, 8, 8, '2017-07-14', '这样不行', 1),
	(9, 9, 9, '2017-07-18', '不要流年，不要留念', 1),
	(10, 10, 10, '2017-07-18', '是的', 1),
	(11, 11, 11, '2017-07-18', '刘帅不会随', 1),
	(12, 12, 12, '2017-07-18', '谢谢你', 1),
	(13, 13, 13, '2017-07-18', 'xxxiiii', 1),
	(109, 109, 109, '2017-07-14', '这样还好', 1),
	(110, 110, 110, '2017-07-14', 'zheyang', 1),
	(111, 111, 111, '2017-07-14', '不行', 1);
/*!40000 ALTER TABLE `t_teacherreply` ENABLE KEYS */;


-- 导出  表 educate.t_teacher_evaluate 结构
CREATE TABLE IF NOT EXISTS `t_teacher_evaluate` (
  `teacher_evaluate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师评价编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `teacher_evaluate_content` text NOT NULL COMMENT '教师评价内容',
  `teacher_evaluate_date` date NOT NULL COMMENT '提交日期',
  `teacher_evaluate_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`teacher_evaluate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='教师评价(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_teacher_evaluate 的数据：~44 rows (大约)
DELETE FROM `t_teacher_evaluate`;
/*!40000 ALTER TABLE `t_teacher_evaluate` DISABLE KEYS */;
INSERT INTO `t_teacher_evaluate` (`teacher_evaluate_id`, `student_id`, `teacher_id`, `teacher_evaluate_content`, `teacher_evaluate_date`, `teacher_evaluate_delete`) VALUES
	(1, 1, 30, '教课认真，责任心强', '2017-06-29', 1),
	(2, 2, 1, '热心解决问题', '2017-06-29', 1),
	(3, 1, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(4, 2, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(5, 3, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(6, 4, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(7, 5, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(8, 6, 2, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(9, 3, 2, '教课认真', '2017-07-01', 1),
	(10, NULL, 3, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(11, NULL, 3, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(12, NULL, 3, '教课认真，知识点讲解清除', '2017-06-29', 1),
	(13, NULL, 3, '教课认真，责任心强', '2017-06-29', 1),
	(14, NULL, 3, '教课认真，责任心强', '2017-06-29', 1),
	(15, NULL, 3, '教课认真，责任心强', '2017-06-29', 1),
	(16, NULL, 3, '教课认真，责任心强', '2017-06-29', 1),
	(17, NULL, 3, '教课认真，责任心强', '2017-06-29', 1),
	(18, NULL, 4, '教课认真，责任心强', '2017-06-29', 1),
	(19, NULL, 4, '教课认真，责任心强', '2017-06-29', 1),
	(20, NULL, 4, '教课认真，责任心强', '2017-06-29', 1),
	(21, NULL, 4, '教课认真，责任心强', '2017-06-29', 1),
	(22, NULL, 4, '教课认真，责任心强', '2017-06-29', 1),
	(23, 4, 2, '热心解决问题', '2017-06-29', 1),
	(24, 4, 2, '热心解决问题', '2017-06-29', 1),
	(25, 4, 2, '热心解决问题', '2017-06-29', 1),
	(26, 4, 2, '热心解决问题', '2017-06-29', 1),
	(27, 4, 2, '热心解决问题', '2017-06-29', 1),
	(28, 4, 2, '热心解决问题', '2017-06-29', 1),
	(29, 4, 2, '热心解决问题', '2017-06-29', 1),
	(30, 4, 2, '热心解决问题', '2017-06-29', 1),
	(31, 4, 2, '热心解决问题', '2017-06-29', 1),
	(32, 4, 2, '热心解决问题', '2017-06-29', 1),
	(33, 4, 2, '热心解决问题', '2017-06-29', 1),
	(34, 4, 2, '讲解问题容易理解', '2017-07-02', 1),
	(36, 4, 2, '讲的好', '2017-07-02', 1),
	(41, 1, 1, 'lllll\n', '2017-07-08', 1),
	(42, 1, 1, 'KSDJFASDKJFHAS DHAPSDPSDOHFASL;KDHFLAKSDHFALKSDJFHALKSJDFHALKSDJFHAKSLDJFHALKSDHFASD', '2017-07-08', 1),
	(43, 1, 1, 'tgjdghjgj', '2017-07-09', 1),
	(44, 1, 1, 'asdga ', '2017-07-09', 1),
	(45, 1, 1, 'asdfasdfasdfasdfasdf', '2017-07-12', 1),
	(46, 1, 30, 'niahiahgasidhfas ', '2017-07-14', 1),
	(47, 1, 30, 'niahiahgasidhfas ', '2017-07-14', 1),
	(48, 1, 30, 'niahiahgasidhfas ', '2017-07-14', 1),
	(49, 1, 30, '还可以', '2017-07-17', 1);
/*!40000 ALTER TABLE `t_teacher_evaluate` ENABLE KEYS */;


-- 导出  表 educate.t_thesis 结构
CREATE TABLE IF NOT EXISTS `t_thesis` (
  `thesis_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '论文表编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `thesis_title` varchar(100) DEFAULT NULL COMMENT '论文题目',
  `thesis_address` varchar(100) DEFAULT NULL COMMENT '论文地址',
  `thesis_score` int(11) DEFAULT NULL COMMENT '论文成绩',
  `thesis_date` date DEFAULT NULL COMMENT '提交日期',
  `thesis_state` int(11) DEFAULT NULL COMMENT '审核状态(0代表未审核.1代表已审核)',
  `thesis_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`thesis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='论文表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_thesis 的数据：~4 rows (大约)
DELETE FROM `t_thesis`;
/*!40000 ALTER TABLE `t_thesis` DISABLE KEYS */;
INSERT INTO `t_thesis` (`thesis_id`, `student_id`, `thesis_title`, `thesis_address`, `thesis_score`, `thesis_date`, `thesis_state`, `thesis_delete`) VALUES
	(1, 1, 'java毕业设计', NULL, 60, '2017-07-12', 1, 1),
	(2, 2, 'c毕业设计', NULL, 10, '2017-07-12', 0, 1),
	(3, 2, 'JAVA的设计与实现', '', NULL, '2017-07-21', 0, 1),
	(4, 1, '5.12亚武山.docx', 'doc\\5.12亚武山.docx', NULL, '2017-07-21', 0, 1);
/*!40000 ALTER TABLE `t_thesis` ENABLE KEYS */;


-- 导出  表 educate.t_thesis_layout 结构
CREATE TABLE IF NOT EXISTS `t_thesis_layout` (
  `thesis_layout_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '论文格式表编号',
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `thesis_layout_name` varchar(100) NOT NULL COMMENT '论文规范名称',
  `thesis_layout_content` varchar(100) NOT NULL COMMENT '论文格式要求文件的地址',
  `thesis_layout_update` date NOT NULL COMMENT '上传日期',
  `thesis_layout_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`thesis_layout_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='论文格式表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_thesis_layout 的数据：~17 rows (大约)
DELETE FROM `t_thesis_layout`;
/*!40000 ALTER TABLE `t_thesis_layout` DISABLE KEYS */;
INSERT INTO `t_thesis_layout` (`thesis_layout_id`, `major_id`, `teacher_id`, `thesis_layout_name`, `thesis_layout_content`, `thesis_layout_update`, `thesis_layout_delete`) VALUES
	(1, 1, 1, 'java论文规范', '/static/maven环境变量的配置.docx', '2017-07-15', 1),
	(2, 1, 1, 'c论文规范', '/static/maven环境变量的配置.docx', '2017-07-15', 1),
	(3, 2, 1, 'c++论文规范', '/static/maven环境变量的配置.docx', '2017-07-15', 1),
	(4, 1, 1, 'python论文规范', '/static/maven环境变量的配置.docx', '2017-07-17', 1),
	(5, 1, 1, 'python论文规范', '/static/maven环境变量的配置.docx', '2017-07-17', 1),
	(6, 1, 1, 'python论文规范', '/static/maven环境变量的配置.docx', '2017-07-17', 1),
	(7, 1, 1, 'python论文规范', '/static/maven环境变量的配置.docx', '2017-07-17', 1),
	(8, 1, 1, '新建文本文档.txt', '/static/新建文本文档.txt', '2017-07-17', 1),
	(9, 1, 1, '亚武山第四阶段考试答案.docx', '/static/亚武山第四阶段考试答案.docx', '2017-07-17', 1),
	(10, 1, 1, '面试题.bmp', '/static/面试题.bmp', '2017-07-17', 1),
	(11, 1, 1, '新建文本文档.txt', '/static/新建文本文档.txt', '2017-07-17', 1),
	(12, 1, 1, '面试题.bmp', '/static/面试题.bmp', '2017-07-17', 1),
	(13, 1, 1, 'pom.xml', '/static/pom.xml', '2017-07-17', 1),
	(14, 61, 1, '亚武山第四阶段考试答案.docx', '/static/亚武山第四阶段考试答案.docx', '2017-07-17', 1),
	(15, 61, 1, 'iview版本.txt', '/static/iview版本.txt', '2017-07-17', 1),
	(16, 61, 1, '2.jsp基础.docx', '/static/2.jsp基础.docx', '2017-07-17', 1),
	(17, 61, 1, 'Java面试宝典.doc', '/static/Java面试宝典.doc', '2017-07-17', 1);
/*!40000 ALTER TABLE `t_thesis_layout` ENABLE KEYS */;


-- 导出  表 educate.t_transaction 结构
CREATE TABLE IF NOT EXISTS `t_transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '异动编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `transaction_reason_request` varchar(50) DEFAULT NULL COMMENT '申请主题',
  `transaction_reason_text` text COMMENT '申请详细',
  `transaction_apply_date` date DEFAULT NULL COMMENT '申请时间',
  `transaction_start_date` date DEFAULT NULL COMMENT '开始时间',
  `transaction_how_long` varchar(10) DEFAULT NULL COMMENT '申请时长',
  `transaction_current_state` varchar(20) DEFAULT NULL COMMENT '现状',
  `transaction_response_state` varchar(20) DEFAULT NULL COMMENT '审核结果',
  `transaction_delete` int(11) DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8 COMMENT='异动（休学）表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_transaction 的数据：~86 rows (大约)
DELETE FROM `t_transaction`;
/*!40000 ALTER TABLE `t_transaction` DISABLE KEYS */;
INSERT INTO `t_transaction` (`transaction_id`, `student_id`, `teacher_id`, `transaction_reason_request`, `transaction_reason_text`, `transaction_apply_date`, `transaction_start_date`, `transaction_how_long`, `transaction_current_state`, `transaction_response_state`, `transaction_delete`) VALUES
	(17, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 0),
	(21, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学2', '审核通过', 0),
	(22, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '未通过', '未审核', 0),
	(23, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 0),
	(24, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 0),
	(25, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '已审核', 0),
	(26, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(27, 3, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(28, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(29, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 0),
	(30, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(31, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(32, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(33, 2, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(34, 1, 1, '休学', '休学', '2017-06-29', '2017-06-29', '2天', '已休学', '审核通过', 1),
	(35, 1, 1, '休学', '休学', '2017-07-11', '2017-07-11', '2天', '休学', '已通过', 1),
	(36, 2, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(37, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(38, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(39, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(40, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(41, 2, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(42, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(43, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(44, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(45, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(46, 2, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(47, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(48, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(49, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(50, 3, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(51, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(52, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(53, 3, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(54, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(55, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(56, 3, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(57, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(58, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(59, 1, 1, '休学', '休学', '2017-01-01', '2017-01-01', '2天', '休学', '已通过', 1),
	(107, 1, 1, '休学', '休学', '2014-02-03', '2014-02-03', '2天', '未休学', '未通过', 0),
	(108, 1, 1, '休学', '休学', '2014-02-03', '2014-02-03', '2天', '休学', '休学', 1),
	(109, 3, 1, '休学', '休学', '2014-02-03', '2014-02-03', '2天', '休学', '休学', 1),
	(110, 1, 1, '休学', '休学', '2014-02-03', '2014-02-03', '2天', '休学', '休学', 1),
	(111, 1, 1, '休学', '休学', '2014-02-03', '2014-02-03', '2天', '休学', '休学', 1),
	(112, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(113, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(114, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(115, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(116, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(117, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(118, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(119, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(120, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(121, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(122, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(123, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(124, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(125, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(126, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(127, NULL, NULL, '休学', '休学', '2017-07-12', '2017-07-12', '2天', '休学', '休学', 1),
	(128, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(129, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(130, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(131, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(132, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(133, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(134, NULL, NULL, '休学', '休学', '2017-07-13', '2017-07-13', '休学', '休学', '休学', 1),
	(135, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(136, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(137, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(138, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(139, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(140, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(141, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(142, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(143, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(144, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(145, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(146, NULL, NULL, '休学', '休学', '2017-02-02', '2017-02-02', '2', '休学', '休学', 1),
	(147, 1, NULL, 'hgijh', 'pojlk;lk', NULL, NULL, NULL, '待审核', NULL, 1),
	(148, 1, NULL, 'fdghdfg', 'sdfsdf', NULL, NULL, 'sdfsafs', '待审核', NULL, 1),
	(149, 1, NULL, '3453', '234', NULL, NULL, '32423', '待审核', NULL, 1),
	(150, 1, NULL, 'xdfgsdf', 'sdfasf', NULL, NULL, 'safsdf', '待审核', NULL, 1),
	(151, 1, NULL, 'dfsdf', 'sdf', NULL, NULL, 'dsf', '待审核', NULL, 1),
	(152, 1, NULL, '休学', '回家吃饭', NULL, NULL, '1个月', '待审核', NULL, 1);
/*!40000 ALTER TABLE `t_transaction` ENABLE KEYS */;


-- 导出  表 educate.t_video 结构
CREATE TABLE IF NOT EXISTS `t_video` (
  `video_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频编号',
  `part_id` int(11) DEFAULT NULL COMMENT '小节编号',
  `video_name` varchar(200) NOT NULL COMMENT '视频名称',
  `video_path` varchar(200) NOT NULL COMMENT '视频路径',
  `video_adduser` varchar(50) NOT NULL COMMENT '作者',
  `video_addtime` date NOT NULL COMMENT '发布时间',
  `video_delete` int(11) NOT NULL COMMENT '删除状态',
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='视频表(删除状态   1为未删除状态，0为已删除状态)';

-- 正在导出表  educate.t_video 的数据：~8 rows (大约)
DELETE FROM `t_video`;
/*!40000 ALTER TABLE `t_video` DISABLE KEYS */;
INSERT INTO `t_video` (`video_id`, `part_id`, `video_name`, `video_path`, `video_adduser`, `video_addtime`, `video_delete`) VALUES
	(1, 1, 'java基础', 'http://127.0.0.1:8091/video/11.mp4', '刘帅', '2017-07-11', 1),
	(2, 2, 'c00115tsjb6.mp4', 'http://127.0.0.1:8091/video/11.mp4', 'zhangsan', '2017-07-13', 1),
	(3, 1, 'c00115tsjb6.mp4', 'http://127.0.0.1:8091/video/11.mp4', 'zhangsan', '2017-07-13', 1),
	(4, 1, 'c00115tsjb6.mp4', 'http://127.0.0.1:8091/video/11.mp4', 'zhangsan', '2017-07-13', 1),
	(5, 1, 'c00115tsjb6.mp4', 'http://127.0.0.1:8091/video/11.mp4', 'zhangsan', '2017-07-13', 1),
	(6, 3, '精忠报国.mp4', '/vedio/精忠报国.mp4', 'zhangsan', '2017-07-14', 1),
	(7, 5, '精忠报国.mp4', '/vedio/精忠报国.mp4', 'zhangsan', '2017-07-15', 1),
	(8, 8, '精忠报国.mp4', '/vedio/精忠报国.mp4', 'zhangsan', '2017-07-15', 1);
/*!40000 ALTER TABLE `t_video` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
