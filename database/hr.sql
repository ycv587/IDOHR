/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : hr

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-04-13 10:25:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for approve
-- ----------------------------
DROP TABLE IF EXISTS `approve`;
CREATE TABLE `approve` (
  `appno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '审批记录号',
  `subemp` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '发起人',
  `atypeno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审批类型',
  `apptime` datetime DEFAULT NULL COMMENT '发起时间',
  `dealemp` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '处理人',
  `dealtime` datetime DEFAULT NULL COMMENT '处理时间',
  `appresult` int(11) DEFAULT NULL COMMENT '审批结果',
  `remark` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审批备注',
  PRIMARY KEY (`appno`),
  KEY `subemp` (`subemp`),
  KEY `atypeno` (`atypeno`),
  CONSTRAINT `approve_ibfk_1` FOREIGN KEY (`subemp`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE,
  CONSTRAINT `approve_ibfk_2` FOREIGN KEY (`atypeno`) REFERENCES `apptype` (`atypeno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='审批信息表';

-- ----------------------------
-- Records of approve
-- ----------------------------

-- ----------------------------
-- Table structure for apptype
-- ----------------------------
DROP TABLE IF EXISTS `apptype`;
CREATE TABLE `apptype` (
  `atypeno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '审批类型编号',
  `atype` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '审批类型',
  PRIMARY KEY (`atypeno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='审批类型表';

-- ----------------------------
-- Records of apptype
-- ----------------------------

-- ----------------------------
-- Table structure for attend
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `attno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '出勤记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `batch` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '考勤批次',
  `pdate` date DEFAULT NULL COMMENT '打卡日期',
  `ptime` time DEFAULT NULL COMMENT '打卡时间',
  PRIMARY KEY (`attno`),
  KEY `batch` (`batch`),
  KEY `empno` (`empno`),
  CONSTRAINT `attend_ibfk_1` FOREIGN KEY (`batch`) REFERENCES `attset` (`setno`),
  CONSTRAINT `attend_ibfk_2` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='考勤结果表';

-- ----------------------------
-- Records of attend
-- ----------------------------
INSERT INTO `attend` VALUES ('00573ce73acf11e89db27429af0b9432', '10001', '上班打卡', '2018-04-09', '09:48:57');
INSERT INTO `attend` VALUES ('05a018ee3acf11e89db27429af0b9432', '10003', '上班打卡', '2018-04-09', '09:49:06');
INSERT INTO `attend` VALUES ('0e3e0c243acf11e89db27429af0b9432', '10001', '下班打卡', '2018-04-09', '17:49:20');
INSERT INTO `attend` VALUES ('12c4e2cc3acf11e89db27429af0b9432', '10002', '下班打卡', '2018-04-09', '17:49:28');
INSERT INTO `attend` VALUES ('1a361b6c3acf11e89db27429af0b9432', '10003', '下班打卡', '2018-04-09', '17:49:40');
INSERT INTO `attend` VALUES ('7c635b103ace11e89db27429af0b9432', '10001', '上班打卡', '2018-04-08', '08:45:16');
INSERT INTO `attend` VALUES ('873801f83ace11e89db27429af0b9432', '10002', '上班打卡', '2018-04-08', '08:45:34');
INSERT INTO `attend` VALUES ('8eabeb1a3ace11e89db27429af0b9432', '10003', '上班打卡', '2018-04-08', '08:45:46');
INSERT INTO `attend` VALUES ('95d7c3973ace11e89db27429af0b9432', '10004', '上班打卡', '2018-04-08', '08:45:58');
INSERT INTO `attend` VALUES ('9f1e34cb3ace11e89db27429af0b9432', '10005', '上班打卡', '2018-04-08', '08:46:14');
INSERT INTO `attend` VALUES ('ae587df63ace11e89db27429af0b9432', '10005', '下班打卡', '2018-04-08', '17:46:39');
INSERT INTO `attend` VALUES ('b342b0853ace11e89db27429af0b9432', '10004', '下班打卡', '2018-04-08', '17:46:48');
INSERT INTO `attend` VALUES ('b6d92db53ace11e89db27429af0b9432', '10003', '下班打卡', '2018-04-08', '17:46:54');
INSERT INTO `attend` VALUES ('baa33a283ace11e89db27429af0b9432', '10002', '下班打卡', '2018-04-08', '17:47:00');
INSERT INTO `attend` VALUES ('be042d283ace11e89db27429af0b9432', '10001', '下班打卡', '2018-04-08', '17:47:06');
INSERT INTO `attend` VALUES ('fb80edd53ace11e89db27429af0b9432', '10001', '上班打卡', '2018-04-09', '09:48:49');

-- ----------------------------
-- Table structure for attset
-- ----------------------------
DROP TABLE IF EXISTS `attset`;
CREATE TABLE `attset` (
  `setno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '考勤配置编号',
  `attstart` time DEFAULT NULL COMMENT '开始时间',
  `attend` time DEFAULT NULL COMMENT '结束时间',
  `attflag` int(11) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`setno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='考勤配置表';

-- ----------------------------
-- Records of attset
-- ----------------------------
INSERT INTO `attset` VALUES ('上班打卡', '08:00:00', '09:00:00', '1');
INSERT INTO `attset` VALUES ('下班打卡', '17:00:00', '18:00:00', '1');
INSERT INTO `attset` VALUES ('临时打卡', '09:00:00', '10:00:00', '0');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `carno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '卡号记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `salaryac` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工资卡账户',
  `saladdr` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '工资卡账户开户行',
  `provideac` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公积金账户',
  `proaddr` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公积金账户开户行',
  `socac` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '社保账户',
  `socaddr` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '社保账户开户行',
  PRIMARY KEY (`carno`),
  KEY `empno` (`empno`),
  CONSTRAINT `card_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='卡号登记表';

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1ac779853a7911e8b6257429af0b9432', '10003', '6222022717290675678', '上海市', '6222022717290675678', '上海市', '6222022717290675678', '上海市');
INSERT INTO `card` VALUES ('668464563abf11e89db27429af0b9432', '10005', '6222022717290675678', '河南省焦作市', '6222022717290675678', '河南省焦作市', '6222022717290675678', '河南省焦作市');
INSERT INTO `card` VALUES ('79273b993a7c11e8b6257429af0b9432', '10004', '6222022717290675678', '太原市', '6222022717290675678', '太原市', '6222022717290675678', '太原市');
INSERT INTO `card` VALUES ('7e70cfe43a6e11e8b6257429af0b9432', '10001', '6222022717290675678', '山西省太原市小店区', '6222022717290675678', '山西省太原市小店区', '6222022717290675678', '山西省太原市小店区');
INSERT INTO `card` VALUES ('af552f503a7411e8b6257429af0b9432', '10002', '6222022717290675678', '山西省太原市杏花岭区', '6222022717290675678', '山西省太原市杏花岭区', '6222022717290675678', '山西省太原市杏花岭区');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `conno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '合同编号',
  `conname` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '合同名称',
  `conpath` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '合同路径',
  `conflag` int(11) DEFAULT NULL COMMENT '是否有效标记',
  PRIMARY KEY (`conno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='合同信息表';

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('0655bfda3ac511e89db27429af0b9432', '人事任免通知.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('3802a03d3a6911e8b6257429af0b9432', '竞业限制协议.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('538b858a3a6911e8b6257429af0b9432', '劳动合同.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('577329aa3a6911e8b6257429af0b9432', '离职员工工作交接表.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('5d3f07223a6911e8b6257429af0b9432', '工作证明.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('630f0cd33a6911e8b6257429af0b9432', '劳动合同解除协议.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('6c14fb683a6911e8b6257429af0b9432', '续签劳动合同通知书.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('6f6a70103a6911e8b6257429af0b9432', '应聘登记表.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('73ec66763a6911e8b6257429af0b9432', '外训申请表.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('8888caa9375411e8821f7429af0b9432', '保密协议.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');
INSERT INTO `contract` VALUES ('906f487d375611e8821f7429af0b9432', '劳动合同期满终止通知书.docx', 'D:\\eclipse-workspace\\HR\\src\\main\\webapp\\upload', '1');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `deptno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '部门编号',
  `dname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门名称',
  `location` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门地址',
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='部门信息表';

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('10', '人事部', '天津市');
INSERT INTO `department` VALUES ('40', '后勤部', '太原市');
INSERT INTO `department` VALUES ('401', '人事部', 'IDO大厦二层');
INSERT INTO `department` VALUES ('402', '行政部', 'IDO大厦三层');
INSERT INTO `department` VALUES ('403', '研发部', 'IDO大厦四层');
INSERT INTO `department` VALUES ('404', '财务部', 'IDO大厦五层');
INSERT INTO `department` VALUES ('405', '信息技术部', 'IDO大厦五层504');
INSERT INTO `department` VALUES ('406', '采购部', 'IDO大厦六层');

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education` (
  `eduno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '教育信息记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `diploma` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '学历',
  `gyear` date DEFAULT NULL COMMENT '毕业年份',
  `gschool` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '毕业院校',
  `majors` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所学专业',
  PRIMARY KEY (`eduno`),
  KEY `edu_empno_fk` (`empno`),
  CONSTRAINT `edu_empno_fk` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工教育信息表';

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES ('1ac849703a7911e8b6257429af0b9432', '10003', '本科', '2006-07-01', '山西大学', '工商管理');
INSERT INTO `education` VALUES ('6688ac083abf11e89db27429af0b9432', '10005', '硕士', '2008-07-01', '清华大学', '计算机科学技术');
INSERT INTO `education` VALUES ('79279cb73a7c11e8b6257429af0b9432', '10004', '本科', '2018-07-01', '山西大学', '软件工程');
INSERT INTO `education` VALUES ('7e739e1e3a6e11e8b6257429af0b9432', '10001', '本科', '2018-07-01', '山西大学', '软件工程');
INSERT INTO `education` VALUES ('af5644d03a7411e8b6257429af0b9432', '10002', '本科', '2018-07-01', '山西大学', '软件工程');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '员工编号',
  `password` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '密码',
  `ename` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '姓名',
  `gender` varchar(5) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '性别',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `address` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '现住址',
  `hiredate` date DEFAULT NULL COMMENT '入职日期',
  `jobid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职位号',
  `deptno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '部门号',
  `mgr` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '直接上级',
  `marriage` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '婚姻状态',
  `nativeaddr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '籍贯',
  `peoples` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '民族',
  `idcard` varchar(18) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '身份证号',
  `estatus` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工状态',
  `blood` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '血型',
  `political` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '政治面貌',
  `close` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '紧急联系人',
  `cphone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '紧急联系方式',
  `salary` decimal(11,3) DEFAULT NULL COMMENT '基本工资',
  PRIMARY KEY (`empno`),
  KEY `emp_deptno_fk` (`deptno`),
  KEY `emp_jobid_fk` (`jobid`),
  CONSTRAINT `emp_deptno_fk` FOREIGN KEY (`deptno`) REFERENCES `department` (`deptno`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `emp_jobid_fk` FOREIGN KEY (`jobid`) REFERENCES `job` (`jobid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工信息表';

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('10001', '7c4a8d09ca3762af61e59520943dc26494f8941b', '张三', '男', '1988-02-18', '30', '17656734563', '山西省太原市杏花岭区', '2018-04-07', '503', '403', '', '已婚', '山西省太原市杏花岭区', '汉族', '140768199502018976', '在职', 'A', '群众', '张富贵', '18679762974', '8000.000');
INSERT INTO `employee` VALUES ('10002', '7c4a8d09ca3762af61e59520943dc26494f8941b', '李四', '男', '1991-06-19', '26', '17628637833', '山西省太原市', '2018-04-07', '503', '403', '10001', '已婚', '山西省太原市', '汉族', '140482729374839393', '在职', 'A', '群众', '李明明', '17373838833', '13000.000');
INSERT INTO `employee` VALUES ('10003', '7c4a8d09ca3762af61e59520943dc26494f8941b', '王五', '男', '1996-01-09', '22', '17628373939', '上海市', '2018-04-07', '501', '405', '10001', '已婚', '上海市', '汉族', '140481192283737333', '在职', 'A', '群众', '王老五', '17623876393', '24000.000');
INSERT INTO `employee` VALUES ('10004', '7c4a8d09ca3762af61e59520943dc26494f8941b', '赵六', '女', '1996-02-14', '22', '19836383883', '山西省太原市', '2018-04-07', '504', '404', '10002', '已婚', '山西省太原市', '汉族', '136739394477584494', '在职', 'A', '群众', '赵四', '17826389003', '12000.000');
INSERT INTO `employee` VALUES ('10005', '7c4a8d09ca3762af61e59520943dc26494f8941b', '孙七', '男', '1981-02-10', '37', '17652639539', '河南省焦作市', '2015-07-16', '502', '403', '10001', '未婚', '河南省焦作市', '满族', '140481198102107837', '在职', 'O', '共产党员', '孙尚香', '18334982633', '18000.000');

-- ----------------------------
-- Table structure for emprole
-- ----------------------------
DROP TABLE IF EXISTS `emprole`;
CREATE TABLE `emprole` (
  `epno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限角色编号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编号',
  `roleno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`epno`),
  KEY `empno` (`empno`),
  KEY `roleno` (`roleno`),
  CONSTRAINT `emprole_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `emprole_ibfk_2` FOREIGN KEY (`roleno`) REFERENCES `roles` (`roleno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of emprole
-- ----------------------------

-- ----------------------------
-- Table structure for incometax
-- ----------------------------
DROP TABLE IF EXISTS `incometax`;
CREATE TABLE `incometax` (
  `taxno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '个税配置号',
  `taxstart` float DEFAULT NULL COMMENT '薪资等级',
  `rate` float DEFAULT NULL COMMENT '税率',
  `taxsub` float DEFAULT NULL COMMENT '速算扣除数',
  `taxflag` int(11) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`taxno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='个人所得税配置表';

-- ----------------------------
-- Records of incometax
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `jobid` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '职位编号',
  `jname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '职位名',
  PRIMARY KEY (`jobid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='职位表';

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('13', '架构师');
INSERT INTO `job` VALUES ('14', '广告经理');
INSERT INTO `job` VALUES ('501', '总经理');
INSERT INTO `job` VALUES ('502', '项目经理');
INSERT INTO `job` VALUES ('503', '程序员');
INSERT INTO `job` VALUES ('504', '财务经理');

-- ----------------------------
-- Table structure for jobadjust
-- ----------------------------
DROP TABLE IF EXISTS `jobadjust`;
CREATE TABLE `jobadjust` (
  `adjno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '调动记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `prejobid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调动前工作',
  `latjobid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调动后工作',
  `adjdate` date DEFAULT NULL COMMENT '调动时间',
  `remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调动备注',
  PRIMARY KEY (`adjno`),
  KEY `adjust_empno` (`empno`),
  KEY `adjust_prejobid_fk` (`prejobid`),
  KEY `adjust_latjobid_fk` (`latjobid`),
  CONSTRAINT `adjust_empno` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `adjust_latjobid_fk` FOREIGN KEY (`latjobid`) REFERENCES `job` (`jobid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `adjust_prejobid_fk` FOREIGN KEY (`prejobid`) REFERENCES `job` (`jobid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工工作调动表';

-- ----------------------------
-- Records of jobadjust
-- ----------------------------

-- ----------------------------
-- Table structure for jobhistory
-- ----------------------------
DROP TABLE IF EXISTS `jobhistory`;
CREATE TABLE `jobhistory` (
  `hisno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '工作经历记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `company` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司名称',
  `hhire` date DEFAULT NULL COMMENT '入职日期',
  `hquit` date DEFAULT NULL COMMENT '离职日期',
  `job` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '担任职位',
  PRIMARY KEY (`hisno`),
  KEY `history_empno_fk` (`empno`),
  CONSTRAINT `history_empno_fk` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='员工工作经历表';

-- ----------------------------
-- Records of jobhistory
-- ----------------------------
INSERT INTO `jobhistory` VALUES ('1ac994f43a7911e8b6257429af0b9432', '10003', '无', '2018-04-07', '2018-04-07', '无');
INSERT INTO `jobhistory` VALUES ('6689e8fc3abf11e89db27429af0b9432', '10005', '无', '2018-04-08', '2018-04-08', '无');
INSERT INTO `jobhistory` VALUES ('792861ae3a7c11e8b6257429af0b9432', '10004', '西软', '2017-07-13', '2018-01-30', '财务');
INSERT INTO `jobhistory` VALUES ('7e7746653a6e11e8b6257429af0b9432', '10001', '无', '2018-04-07', '2018-04-07', '无');
INSERT INTO `jobhistory` VALUES ('af5852953a7411e8b6257429af0b9432', '10002', '东软睿道', '2015-07-08', '2018-04-06', '程序员');

-- ----------------------------
-- Table structure for joblevel
-- ----------------------------
DROP TABLE IF EXISTS `joblevel`;
CREATE TABLE `joblevel` (
  `levno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '请假记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `levstart` datetime DEFAULT NULL COMMENT '请假日期',
  `levend` datetime DEFAULT NULL COMMENT '结束日期',
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '请假备注',
  PRIMARY KEY (`levno`),
  KEY `empno` (`empno`),
  CONSTRAINT `joblevel_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='请假记录表';

-- ----------------------------
-- Records of joblevel
-- ----------------------------
INSERT INTO `joblevel` VALUES ('0cbcddbe3ac111e89db27429af0b9432', '10005', '2018-04-06 08:00:00', '2018-04-07 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('102b1e683ac111e89db27429af0b9432', '10004', '2018-04-06 08:00:00', '2018-04-07 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('12007bee3ac111e89db27429af0b9432', '10003', '2018-04-06 08:00:00', '2018-04-07 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('1618d6793ac111e89db27429af0b9432', '10002', '2018-04-06 08:00:00', '2018-04-06 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('1c5760b43ac111e89db27429af0b9432', '10001', '2018-04-06 08:00:00', '2018-04-06 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('37e949e33ac011e89db27429af0b9432', '10001', '2018-04-09 08:00:00', '2018-04-09 17:00:00', '看病');
INSERT INTO `joblevel` VALUES ('5e6635353ac011e89db27429af0b9432', '10002', '2018-04-09 08:00:00', '2018-04-09 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('6b5bc7353ac011e89db27429af0b9432', '10002', '2018-04-03 08:00:00', '2018-04-04 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('6fb46d2c3ac011e89db27429af0b9432', '10003', '2018-04-03 08:00:00', '2018-04-04 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('72ad7b6f3ac011e89db27429af0b9432', '10004', '2018-04-03 08:00:00', '2018-04-04 17:00:00', '无');
INSERT INTO `joblevel` VALUES ('74b04af43ac011e89db27429af0b9432', '10005', '2018-04-03 08:00:00', '2018-04-04 17:00:00', '无');

-- ----------------------------
-- Table structure for jobout
-- ----------------------------
DROP TABLE IF EXISTS `jobout`;
CREATE TABLE `jobout` (
  `outno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '离职记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `outdate` date DEFAULT NULL COMMENT '离职日期',
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '离职日期',
  PRIMARY KEY (`outno`),
  KEY `empno` (`empno`),
  CONSTRAINT `jobout_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='离职记录表';

-- ----------------------------
-- Records of jobout
-- ----------------------------

-- ----------------------------
-- Table structure for jobover
-- ----------------------------
DROP TABLE IF EXISTS `jobover`;
CREATE TABLE `jobover` (
  `overno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '加班记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `overstart` datetime DEFAULT NULL COMMENT '开始时间',
  `overend` datetime DEFAULT NULL COMMENT '结束时间',
  `overtype` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加班类型',
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '加班备注',
  PRIMARY KEY (`overno`),
  KEY `empno` (`empno`),
  CONSTRAINT `jobover_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='加班记录表';

-- ----------------------------
-- Records of jobover
-- ----------------------------
INSERT INTO `jobover` VALUES ('5c3d47de3ac111e89db27429af0b9432', '10001', '2018-04-08 08:00:00', '2018-04-08 10:00:00', '周末', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('6573e3333ac111e89db27429af0b9432', '10002', '2018-04-08 08:00:00', '2018-04-08 10:00:00', '周末', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('678b1b7f3ac111e89db27429af0b9432', '10003', '2018-04-08 08:00:00', '2018-04-08 10:00:00', '周末', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('69bcec573ac111e89db27429af0b9432', '10004', '2018-04-08 08:00:00', '2018-04-08 10:00:00', '周末', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('6b90823b3ac111e89db27429af0b9432', '10005', '2018-04-08 08:00:00', '2018-04-08 10:00:00', '周末', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('7b74819c3ac111e89db27429af0b9432', '10001', '2018-04-09 08:00:00', '2018-04-09 10:00:00', '普通', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('89e487133ac111e89db27429af0b9432', '10002', '2018-04-09 10:00:00', '2018-04-09 17:00:00', '普通', 'HR项目未完成');
INSERT INTO `jobover` VALUES ('afff4cc13ac111e89db27429af0b9432', '10003', '2018-04-04 13:00:00', '2018-04-04 17:00:00', '普通', 'HR项目未完成');

-- ----------------------------
-- Table structure for labor
-- ----------------------------
DROP TABLE IF EXISTS `labor`;
CREATE TABLE `labor` (
  `labno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '劳务记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `conno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '合同号',
  `startdate` date DEFAULT NULL COMMENT '合同开始时间',
  `enddate` date DEFAULT NULL COMMENT '合同终止时间',
  PRIMARY KEY (`labno`),
  KEY `empno` (`empno`),
  KEY `conno` (`conno`),
  CONSTRAINT `labor_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `labor_ibfk_2` FOREIGN KEY (`conno`) REFERENCES `contract` (`conno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='劳务关系表';

-- ----------------------------
-- Records of labor
-- ----------------------------
INSERT INTO `labor` VALUES ('1ac8e8bb3a7911e8b6257429af0b9432', '10003', '538b858a3a6911e8b6257429af0b9432', '2005-07-21', '2008-07-21');
INSERT INTO `labor` VALUES ('66893e733abf11e89db27429af0b9432', '10005', '538b858a3a6911e8b6257429af0b9432', '2015-07-16', '2018-07-16');
INSERT INTO `labor` VALUES ('7927fe493a7c11e8b6257429af0b9432', '10004', '538b858a3a6911e8b6257429af0b9432', '2018-04-07', '2021-04-07');
INSERT INTO `labor` VALUES ('7e75e97b3a6e11e8b6257429af0b9432', '10001', '538b858a3a6911e8b6257429af0b9432', '2018-04-07', '2021-04-07');
INSERT INTO `labor` VALUES ('7e76a4d73a6e11e8b6257429af0b9432', '10001', '3802a03d3a6911e8b6257429af0b9432', '2018-04-07', '2021-04-07');
INSERT INTO `labor` VALUES ('af5723fb3a7411e8b6257429af0b9432', '10002', '538b858a3a6911e8b6257429af0b9432', '2018-04-07', '2021-04-07');

-- ----------------------------
-- Table structure for merit
-- ----------------------------
DROP TABLE IF EXISTS `merit`;
CREATE TABLE `merit` (
  `merno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '考核编号',
  `assname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '考核名称',
  `initemp` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '考核发起人',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`merno`),
  KEY `merit_ibfk_1` (`initemp`),
  CONSTRAINT `merit_ibfk_1` FOREIGN KEY (`initemp`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='绩效考核表';

-- ----------------------------
-- Records of merit
-- ----------------------------
INSERT INTO `merit` VALUES ('9b136f263ac311e89db27429af0b9432', '五一劳动节', null, '2018-04-08 10:00:00', '2018-04-08 17:00:00');
INSERT INTO `merit` VALUES ('af0caa823ac311e89db27429af0b9432', '312植树节', null, '2018-03-12 09:00:00', '2018-03-12 17:00:00');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `perid` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限编号',
  `percode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限代码字符串',
  `resurl` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '资源地址',
  `resource` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '具体资源',
  `available` int(11) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`perid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for perrole
-- ----------------------------
DROP TABLE IF EXISTS `perrole`;
CREATE TABLE `perrole` (
  `prno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '权限角色编号',
  `perid` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限编号',
  `roleno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`prno`),
  KEY `perid` (`perid`),
  KEY `roleno` (`roleno`),
  CONSTRAINT `perrole_ibfk_1` FOREIGN KEY (`perid`) REFERENCES `permission` (`perid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `perrole_ibfk_2` FOREIGN KEY (`roleno`) REFERENCES `roles` (`roleno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='权限角色表';

-- ----------------------------
-- Records of perrole
-- ----------------------------

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `resno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '考核结果流水号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `merno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '考核编号',
  `score` float DEFAULT NULL COMMENT '考核分数',
  PRIMARY KEY (`resno`),
  KEY `empno` (`empno`),
  KEY `merno` (`merno`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE,
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`merno`) REFERENCES `merit` (`merno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='绩效考核结果表';

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('9b1e9a5c3ac311e89db27429af0b9432', '10001', '9b136f263ac311e89db27429af0b9432', null);
INSERT INTO `result` VALUES ('9b21738d3ac311e89db27429af0b9432', '10002', '9b136f263ac311e89db27429af0b9432', null);
INSERT INTO `result` VALUES ('9b21cedd3ac311e89db27429af0b9432', '10003', '9b136f263ac311e89db27429af0b9432', null);
INSERT INTO `result` VALUES ('9b2296b33ac311e89db27429af0b9432', '10004', '9b136f263ac311e89db27429af0b9432', null);
INSERT INTO `result` VALUES ('9b231f933ac311e89db27429af0b9432', '10005', '9b136f263ac311e89db27429af0b9432', null);
INSERT INTO `result` VALUES ('af0d7a993ac311e89db27429af0b9432', '10001', 'af0caa823ac311e89db27429af0b9432', '78');
INSERT INTO `result` VALUES ('af0dc7c53ac311e89db27429af0b9432', '10002', 'af0caa823ac311e89db27429af0b9432', '89');
INSERT INTO `result` VALUES ('af0e53e23ac311e89db27429af0b9432', '10003', 'af0caa823ac311e89db27429af0b9432', '67');
INSERT INTO `result` VALUES ('af0eadd13ac311e89db27429af0b9432', '10004', 'af0caa823ac311e89db27429af0b9432', '72');
INSERT INTO `result` VALUES ('af101c8b3ac311e89db27429af0b9432', '10005', 'af0caa823ac311e89db27429af0b9432', '94');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `roleno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色编号',
  `rolename` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名',
  `available` int(11) DEFAULT NULL COMMENT '是否可用',
  PRIMARY KEY (`roleno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色表';

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `salno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '流水号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `basesal` decimal(11,3) DEFAULT NULL COMMENT '基本工资',
  `overtime` float DEFAULT NULL COMMENT '加班工时',
  `osal` decimal(11,3) DEFAULT NULL COMMENT '加班薪酬',
  `absence` float DEFAULT NULL COMMENT '缺勤天数',
  `asal` decimal(11,3) DEFAULT NULL COMMENT '缺勤扣薪',
  `lve` float DEFAULT NULL COMMENT '事假天数',
  `lsal` decimal(11,3) DEFAULT NULL COMMENT '事假扣薪',
  `sick` float DEFAULT NULL COMMENT '病假天数',
  `ssal` decimal(11,3) DEFAULT NULL COMMENT '病假扣薪',
  `tax` decimal(11,3) DEFAULT NULL COMMENT '个人所得税',
  `ownfund` decimal(11,3) DEFAULT NULL COMMENT '个人五险一金',
  `realsal` decimal(11,3) DEFAULT NULL COMMENT '实发工资',
  `setdate` date DEFAULT NULL COMMENT '结算日期',
  PRIMARY KEY (`salno`),
  KEY `empno` (`empno`),
  CONSTRAINT `salary_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='salary';

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES ('037f7b803acb11e89db27429af0b9432', '10001', '8000.000', '0', '0.000', '0', '0.000', '1', '266.670', '0', '0.000', '233.000', '1120.000', '6380.330', '2018-04-08');
INSERT INTO `salary` VALUES ('039a78383acb11e89db27429af0b9432', '10002', '13000.000', '0', '0.000', '0', '0.000', '1.5', '650.000', '0', '0.000', '981.000', '1820.000', '9549.000', '2018-04-08');
INSERT INTO `salary` VALUES ('03a323a03acb11e89db27429af0b9432', '10003', '24000.000', '0', '0.000', '0', '0.000', '1', '800.000', '0', '0.000', '3280.000', '3360.000', '16560.000', '2018-04-08');
INSERT INTO `salary` VALUES ('03afaf153acb11e89db27429af0b9432', '10004', '12000.000', '0', '0.000', '0', '0.000', '1', '400.000', '0', '0.000', '809.000', '1680.000', '9111.000', '2018-04-08');
INSERT INTO `salary` VALUES ('03b90d6e3acb11e89db27429af0b9432', '10005', '18000.000', '0', '0.000', '0', '0.000', '1', '600.000', '0', '0.000', '1990.000', '2520.000', '12890.000', '2018-04-08');

-- ----------------------------
-- Table structure for salchange
-- ----------------------------
DROP TABLE IF EXISTS `salchange`;
CREATE TABLE `salchange` (
  `chano` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '调薪记录号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `beforesal` decimal(11,3) DEFAULT NULL COMMENT '调薪前工资',
  `aftersal` decimal(11,3) DEFAULT NULL COMMENT '调薪后工资',
  `chadate` date DEFAULT NULL COMMENT '调薪日期',
  `remark` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '调薪备注',
  PRIMARY KEY (`chano`),
  KEY `empno` (`empno`),
  CONSTRAINT `salchange_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='调薪记录表';

-- ----------------------------
-- Records of salchange
-- ----------------------------

-- ----------------------------
-- Table structure for salset
-- ----------------------------
DROP TABLE IF EXISTS `salset`;
CREATE TABLE `salset` (
  `ssetno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '配置记录号',
  `setname` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '配置名',
  `cleardate` int(11) DEFAULT NULL COMMENT '薪资结算日',
  `abspropo` float DEFAULT NULL COMMENT '缺勤扣款基数',
  `levpropo` float DEFAULT NULL COMMENT '事假扣款基数',
  `sickpropo` float DEFAULT NULL COMMENT '病假扣款基数',
  `nopropo` float DEFAULT NULL COMMENT '普通加班基数',
  `wopropo` float DEFAULT NULL COMMENT '周末加班基数',
  `qopropo` float DEFAULT NULL COMMENT '法定加班基数',
  `merpropo` float DEFAULT NULL COMMENT '绩效结果基数',
  `coldage` float DEFAULT NULL COMMENT '公司养老保险基数',
  `cmedical` float DEFAULT NULL COMMENT '公司医疗保险基数',
  `cunemp` float DEFAULT NULL COMMENT '公司失业保险基数',
  `cinjury` float DEFAULT NULL COMMENT '公司工伤保险基数',
  `cbirth` float DEFAULT NULL COMMENT '公司生育保险基数',
  `caccum` float DEFAULT NULL COMMENT '公司公积金基数',
  `eoldage` float DEFAULT NULL COMMENT '个人养老保险基数',
  `emedical` float DEFAULT NULL COMMENT '个人医疗保险基数',
  `eunemp` float DEFAULT NULL COMMENT '个人失业保险基数',
  `einjury` float DEFAULT NULL COMMENT '个人工伤保险基数',
  `ebirth` float DEFAULT NULL COMMENT '个人生育保险基数',
  `eaccum` float DEFAULT NULL COMMENT '个人公积金基数',
  `setflag` int(11) DEFAULT NULL COMMENT '是否有效',
  `startdate` date DEFAULT NULL COMMENT '开始执行时间',
  PRIMARY KEY (`ssetno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='薪资结算配置表';

-- ----------------------------
-- Records of salset
-- ----------------------------
INSERT INTO `salset` VALUES ('20180401', '默认配置', '8', '100', '0', '0', '1', '2', '3', '1000', '8', '8', '8', '8', '8', '1', '8', '2', '1', '0', '0', '3', '1', '2018-04-01');

-- ----------------------------
-- Table structure for subsidy
-- ----------------------------
DROP TABLE IF EXISTS `subsidy`;
CREATE TABLE `subsidy` (
  `subno` varchar(32) COLLATE utf8_unicode_ci NOT NULL COMMENT '福利登记流水号',
  `empno` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '员工编号',
  `traffic` decimal(11,3) DEFAULT NULL COMMENT '车补',
  `meal` decimal(11,3) DEFAULT NULL COMMENT '餐补',
  `housing` decimal(11,3) DEFAULT NULL COMMENT '住房津贴',
  `seniority` decimal(11,3) DEFAULT NULL COMMENT '工龄福利',
  `fivefund` decimal(11,3) DEFAULT NULL COMMENT '公司五险一金',
  `business` decimal(11,3) DEFAULT NULL COMMENT '出差补贴',
  PRIMARY KEY (`subno`),
  KEY `empno` (`empno`),
  CONSTRAINT `subsidy_ibfk_1` FOREIGN KEY (`empno`) REFERENCES `employee` (`empno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='福利表';

-- ----------------------------
-- Records of subsidy
-- ----------------------------
