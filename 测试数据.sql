stugradestudtypestudtypesidstugradeconditionsSELECT * FROM popedom
INSERT INTO popedom(pdmname,pdmfather) VALUES('信息管理',NULL);
INSERT INTO popedom(pdmname,pdmfather) VALUES('查看学生信息',1);
INSERT INTO popedom(pdmname,pdmfather) VALUES('查看教师信息',1);
INSERT INTO popedom(pdmname,pdmfather) VALUES('查看学生成绩',1);
INSERT INTO popedom(pdmname,pdmfather) VALUES('常规管理',NULL);
INSERT INTO popedom(pdmname,pdmfather) VALUES('课程管理',5);
INSERT INTO popedom(pdmname,pdmfather) VALUES('班级管理',5);
INSERT INTO popedom(pdmname,pdmfather) VALUES('题库管理',NULL);
INSERT INTO popedom(pdmname,pdmfather) VALUES('试卷管理',8);
INSERT INTO popedom(pdmname,pdmfather) VALUES('题目管理',8);
INSERT INTO popedom(pdmname,pdmfather) VALUES('发布考试',NULL);
INSERT INTO popedom(pdmname,pdmfather) VALUES('权限管理',NULL);
INSERT INTO popedom(pdmname,pdmfather) VALUES('查看用户',12);
INSERT INTO popedom(pdmname,pdmfather) VALUES('添加权限',12);
INSERT INTO popedom(pdmname,pdmfather) VALUES('删除权限',12);
popedomtestpapertopic



role_popedom
DROP TABLE popedom;
CREATE TABLE popedom(
pdmid INT PRIMARY KEY AUTO_INCREMENT,
pdmname VARCHAR(20) NOT NULL,
pdmfather INT 
)




DROP TABLE role_popedom;
CREATE TABLE role_popedom(
 rpid INT PRIMARY KEY AUTO_INCREMENT ,
 pdmid INT NOT NULL,
 roleid INT  NOT NULL
)




INSERT INTO role_popedom(pdmid,roleid) VALUES(1,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(2,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(3,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(4,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(5,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(6,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(7,10);
INSERT INTO role_popedom(pdmid,roleid) VALUES(1,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(2,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(3,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(4,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(5,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(6,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(7,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(8,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(9,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(10,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(11,20);
INSERT INTO role_popedom(pdmid,roleid) VALUES(1,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(2,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(3,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(4,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(5,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(6,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(7,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(8,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(9,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(10,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(11,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(12,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(13,30);studtypetestpapertestpapertopictopicbankrolestudtypestugrademakeuptable
INSERT INTO role_popedom(pdmid,roleid) VALUES(14,30);
INSERT INTO role_popedom(pdmid,roleid) VALUES(15,30);
teacherstudentstudentsquadsquad WHERE 1=1 AND roleid=10 AND pdmid=3;



stugradestugradesquad
DELETE FROM role_popedom WHERE 1=1 AND roleid=10 AND pdmid=3



INSERT INTO student VALUES('01','刘斌','男',18,1squadsquad,'123456','2018-5-9','430721199903463610','15389305478','刘清军','父子','13478559940','湖南长沙','在读');
INSERT INTO student VALUES('02','彭波','男',18,1,'123456','2015-7-19','430721199307669920','15899356778','彭进','父子','13798557740','湖南岳阳','在读');
INSERT INTO student VALUES('03','梁巩','男',18,1,'123456','2017-3-24','430721200009526370','13432415594','梁锦','父子','15974077909','湖南邵阳','休学');
INSERT INTO student VALUES('04','杨维','男',18,1,'123456','2018-11-29','430721200011297880','16788905446','杨阳','父子','18278806577','湖南甘肃','毕业');
INSERT INTO student VALUES('05','周湘粤','男',18,1,'123456','2016-4-6','430721199901265434','13432417894','周浑','父子','17670431524','湖南常德','在读');
INSERT INTO student VALUES('06','徐亚健','男',18,1,'123456','2017-8-19','430721200011263420','15643318893','徐龙','父子','18390434459','湖南邵阳','休学');
INSERT INTO student VALUES('07','李定金','男',18,1,'123456','2017-6-4','430721199906043378','18975669800','李鹤','父子','14578994497','湖南长沙','在读');
INSERT INTO student VALUES('08','李嘉伟','男',18,1,'123456','2016-7-23','4307211999011144555','17899305433','李永祥','父子','15974078806','湖南岳阳','开除');
INSERT INTO student VALUES('09','胡玲','女',18,1,'123456','2017-4-8','430721199905263720','18273683379','胡宏斌','父女','13762675821','湖南安乡','在读');
INSERT INTO student VALUES('10','赵丁吉','男',18,1,'123456','2017-4-2','430721199701267720','17604315243','赵刑','父子','15643789980','湖南邵阳','开除');
INSERT INTO student VALUES('15','刘希','男',18,1,'123456','2016-6-19','430721199910243450','13432417343','刘凯','父子','18390327889','湖南永州','开除');
INSERT INTO student VALUES('20','周志明','男',18,1,'123456','2018-3-15','430721199904264363','15573148860','周弩','父子','15630321772','湖南邵阳','休学');
INSERT INTO student VALUES('22','周志明','男',18,2,'123456','2018-3-15','430721199904264363','15573148860','周弩','父子','15630321772','湖南邵阳','休学');





CREATE TABLE exam(
  eid INT NOT NULL PRIMARY KEY,
  cid INT NOT NULL,
  headline VARCHAR(125) NOT NULL,
  cname VARCHAR(20) NOT NULL,
  sqid INT NOT NULL,
  examtime DATE NOT NULL,
  finishtime DATE NOT NULL,
  againexam VARCHAR(20) NOT NULL
);


INSERT INTO exam VALUES(1,3,'A4','数学',4,'2018-3-15','2016-6-19','待考');
INSERT INTO exam VALUES(2,3,'A4','数学',41,'2018-3-15','2016-6-19','待考');
INSERT INTO exam VALUES(3,3,'A4','数学',44,'2018-3-15','2016-6-19','待考');















SELECT * FROM testpaper
CREATE TABLE testpaper(
  cid INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  headline VARCHAR(125) NOT NULL,
  courseid VARCHAR(20) NOT NULL,
  state VARCHAR(20) NOT NULL
);


INSERT INTO testpaper VALUES(1,'哲学','A1','已发布');
INSERT INTO testpaper VALUES(2,'语文','A2','未发布');
INSERT INTO testpaper VALUES(3,'数学','A3','已发布');
INSERT INTO testpaper VALUES(4,'外语','B1','已发布');
INSERT INTO testpaper VALUES(5,'历史','B2','未发布');
INSERT INTO testpaper VALUES(6,'政治','B3','已发布');
INSERT INTO testpaper VALUES(7,'生物','B4','未发布');



CREATE TABLE stugrade(
  gid INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  sid INT NOT NULL,
  sname VARCHAR(20) NOT NULL,
  grade INT NOT NULL,
  sqid INT NOT NULL,
  eid INT NOT NULL,
  remark VARCHAR(20)
);




INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(1,'唐毅',80,1,7,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(2,'张漂亮',80,3,7,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(3,'廖雪冬',80,5,7,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(4,'孟俊',80,1,8,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(5,'汤洪',80,1,12,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(6,'石中意',80,1,14,'无');
INSERT INTO stugrade(sid,sname,grade,sqid,eid,remark) VALUES(7,'刘登升',80,1,13,'无');




CREATE TABLE course(
		cid INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
		cname VARCHAR(50) NOT NULL,
		stagename VARCHAR(40) NOT NULL
);

INSERT INTO course(cname,stagename) VALUES('计算机基础','第一阶段');
INSERT INTO course(cname,stagename) VALUES('计算机英语','第一阶段');
INSERT INTO course(cname,stagename) VALUES('Java基础','第一阶段');
INSERT INTO course(cname,stagename) VALUES('web基础','第一阶段');
INSERT INTO course(cname,stagename) VALUES('JAJX基础','第一阶段');
INSERT INTO course(cname,stagename) VALUES('Java数据库基础','第二阶段');
INSERT INTO course(cname,stagename) VALUES('Java程序设计基础','第二阶段');
INSERT INTO course(cname,stagename) VALUES('Java面向对象','第一阶段');
INSERT INTO course(cname,stagename) VALUES('Java Web基础','第二阶段');
INSERT INTO course(cname,stagename) VALUES('Qracle数据库','第三阶段');
INSERT INTO course(cname,stagename) VALUES('J2EE','第三阶段');
INSERT INTO course(cname,stagename) VALUES('前沿技术','第三阶段');
INSERT INTO course(cname,stagename) VALUES('Android编程','第三阶段');





SELECT * FROM conditions
CREATE TABLE conditions (
		tid INT NOT NULL PRIMARY KEY ,
		falsely DOUBLE NOT NULL
);


INSERT INTO conditions VALUES(1,0);
INSERT INTO conditions VALUES(2,0);
INSERT INTO conditions VALUES(3,0);
INSERT INTO conditions VALUES(4,0);
INSERT INTO conditions VALUES(5,0);
INSERT INTO conditions VALUES(6,0);
INSERT INTO conditions VALUES(7,0);
INSERT INTO conditions VALUES(8,0);
INSERT INTO conditions VALUES(9,0);
INSERT INTO conditions VALUES(10,0);
INSERT INTO conditions VALUES(11,0);
INSERT INTO conditions VALUES(12,0);
INSERT INTO conditions VALUES(13,0);
INSERT INTO conditions VALUES(14,0);
INSERT INTO conditions VALUES(15,0);
INSERT INTO conditions VALUES(16,0);
INSERT INTO conditions VALUES(17,0);
INSERT INTO conditions VALUES(18,0);
INSERT INTO conditions VALUES(19,0);
INSERT INTO conditions VALUES(20,0);
INSERT INTO conditions VALUES(21,0);
INSERT INTO conditions VALUES(22,0);
INSERT INTO conditions VALUES(23,0);
INSERT INTO conditions VALUES(24,0);
INSERT INTO conditions VALUES(25,0);
INSERT INTO conditions VALUES(26,0);
INSERT INTO conditions VALUES(27,0);
INSERT INTO conditions VALUES(28,0);
INSERT INTO conditions VALUES(29,0);
INSERT INTO conditions VALUES(30,0);
INSERT INTO conditions VALUES(31,0);
INSERT INTO conditions VALUES(32,0);
INSERT INTO conditions VALUES(33,0);
INSERT INTO conditions VALUES(34,0);
INSERT INTO conditions VALUES(35,0);
INSERT INTO conditions VALUES(36,0);
INSERT INTO conditions VALUES(37,0);
INSERT INTO conditions VALUES(38,0);
INSERT INTO conditions VALUES(39,0);
INSERT INTO conditions VALUES(40,0);
INSERT INTO conditions VALUES(41,0);
INSERT INTO conditions VALUES(42,0);
INSERT INTO conditions VALUES(43,0);
INSERT INTO conditions VALUES(44,0);
INSERT INTO conditions VALUES(45,0);
INSERT INTO conditions VALUES(46,0);
INSERT INTO conditions VALUES(47,0);
INSERT INTO conditions VALUES(48,0);
INSERT INTO conditions VALUES(49,0);
INSERT INTO conditions VALUES(50,0);
INSERT INTO conditions VALUES(51,0);
INSERT INTO conditions VALUES(52,0);
INSERT INTO conditions VALUES(53,0);
INSERT INTO conditions VALUES(54,0);
INSERT INTO conditions VALUES(55,0);
INSERT INTO conditions VALUES(56,0);
INSERT INTO conditions VALUES(57,0);
INSERT INTO conditions VALUES(58,0);
INSERT INTO conditions VALUES(59,0);
INSERT INTO conditions VALUES(60,0);
INSERT INTO conditions VALUES(61,0);
INSERT INTO conditions VALUES(62,0);
INSERT INTO conditions VALUES(63,0);
INSERT INTO conditions VALUES(64,0);
INSERT INTO conditions VALUES(65,0);
INSERT INTO conditions VALUES(66,0);
INSERT INTO conditions VALUES(67,0);
INSERT INTO conditions VALUES(68,0);
INSERT INTO conditions VALUES(69,0);
INSERT INTO conditions VALUES(70,0);
INSERT INTO conditions VALUES(71,0);
INSERT INTO conditions VALUES(72,0);
INSERT INTO conditions VALUES(73,0);
INSERT INTO conditions VALUES(74,0);
INSERT INTO conditions VALUES(75,0);
INSERT INTO conditions VALUES(76,0);
INSERT INTO conditions VALUES(77,0);
INSERT INTO conditions VALUES(78,0);
INSERT INTO conditions VALUES(79,0);
INSERT INTO conditions VALUES(80,0);
INSERT INTO conditions VALUES(81,0);
INSERT INTO conditions VALUES(82,0);
INSERT INTO conditions VALUES(83,0);
INSERT INTO conditions VALUES(84,0);
INSERT INTO conditions VALUES(85,0);
INSERT INTO conditions VALUES(86,0);
INSERT INTO conditions VALUES(87,0);
INSERT INTO conditions VALUES(88,0);
INSERT INTO conditions VALUES(89,0);



CREATE TABLE makeuptable (
		sid INT NOT NULL PRIMARY KEY ,
		sname VARCHAR(20) NOT NULL,
		grade INT NOT NULL,
		squadid INT NOT NULL,
		eid INT NOT NULL,
		conditions VARCHAR(10) NOT NULL
);
SELECT * FROM makeuptable;

INSERT INTO makeuptable VALUES(1,'增默涵',140,280,4,'补考');
INSERT INTO makeuptable VALUES(2,'浪子小刀',300,280,4,'通过');
INSERT INTO makeuptable VALUES(3,'达达',56,270,4,'补考');
INSERT INTO makeuptable VALUES(4,'小凯',13,270,4,'补考');
INSERT INTO makeuptable VALUES(5,'大黄蜂',320,289,4,'通过');
INSERT INTO makeuptable VALUES(6,'万成',223,289,4,'通过');
INSERT INTO makeuptable VALUES(7,'非凡',31,280,4,'补考');



DROP TABLE IF EXISTS topicbank
CREATE TABLE topicbank (
	testid INT  PRIMARY KEY AUTO_INCREMENT NOT NULL,
	testtype VARCHAR(10) NOT NULL,
	aresult  VARCHAR(10) NOT NULL,
	bresult  VARCHAR(10) NOT NULL,
	cresult VARCHAR(10) NOT NULL,
	dresult  VARCHAR(10) NOT NULL,
	eresult  VARCHAR(10)  NULL,
	fresult  VARCHAR(10)  NULL,
	rightsult  VARCHAR(10) NOT NULL,
	content  VARCHAR(400) NOT NULL,
	grade  VARCHAR(20) NOT NULL,
	falsely  DECIMAL(8,2) NOT NULL,
	cname  VARCHAR(40) NOT NULL,
	stagename VARCHAR(40) NOT NULL 
);

INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DROP ','B.ALTER','C.UPDATE','D.DELETE','','','D','删除表中数据的语句是（  ）。','简单',0.1,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.CHECK  ','B.PRIMARY KEY','C.PRIMARY KEY','D.UNIQUE','','','A','限制输入到列的值的范围，应使用（  ）约束。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.DOM  ','B.SAX  ','JDOM  ','DOM4J','','','ABCD','Java中有哪些XML解析技术（）（多选）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.Create database 表名','B.Create VIEW 表名','Create TABLE  表名','ALTER TABLE 表名','','','C','创建表的命令是（   ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A._  ','B.[]','^ ','LIKE','','','D','用于模糊查询的匹配符是(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.master   ','B.model','. tempdb  ','pubs','','','D','在sql SERVER中不是系统数据库的是(  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.关系图是在同一个表中不同字段之间建立关联','B.关系图是在不同表中的字段之间建立关联','关系图是表与表之间建立关联，与字段无关','关系图是在不同数据库之间建立关联','','','B','关于关系图下列哪一个是正确的（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DROP   ','B.ALTER','UPDATE','DELETE','','','A','删除表的语句是(  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SELECT * FROM 学习经历 WHERE 毕业学校 LIKE ’*清华*’ ','B.SELECT * FROM 学习经历 WHERE 毕业学校 = ’%清华%’','.SELECT * FROM 学习经历 WHERE 毕业学校 LIKE ’?清华?’',' SELECT * FROM 学习经历 WHERE 毕业学校 LIKE ’%清华%’','','','D','查询毕业学校名称与“清华”有关的记录应该用(   )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.CHECK ','B.PRIMARY KEY','FOREIGN KEY','UNIQU','','','A','规则对象在使用上与(  )约束类似。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.查询工资大于1250的纪录','B.查询1250号记录后的记录','检索所有的职工号','从[职工]关系中检索工资大于1250的职工号','','','A','Select 职工号 FROM 职工 WHERE 工资>1250 命令的功能是( )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据共享','数据完整性','B.数据冗余很高','数据独立性高','','','C','下列四项中，不属于数据库特点的是（    ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.企业管理器 ','B.查询分析器','服务管理器','媒体播放器','','','B','下列四项中，不属于SQL2000实用程序的是（  ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.CREATE SCHEMA','B.CREATE TABLE','CREATE VIEW ','CREATE INDEX','','','D','在SQL中，建立表用的命令是 (  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.包括15岁和35岁','B.不包括15岁和35岁','包括15岁但不包括35岁','包括35岁但不包括15岁','','','A','SQL语言中，条件年龄 BETWEEN 15 AND 35表示年龄在15至35之间，且(  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SQL语言是关系数据库的国际标准语言','B.SQL语言具有数据定义、查询、操纵和控制功能','SQL语言可以自动实现关系数据库的规范化','SQL语言称为结构查询语言','','','C','下列四项中，不正确的提法是(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DELETE     ','B.DROP','CLEAR ','REMOVE','','','A','SQL语言中，删除表中数据的命令是(  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.mdf','B.ldf','tif   ','ndf','','','C','下列哪个不是sql 数据库文件的后缀。( )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DDL ','B.DCL','DML ','DBL','','','A','数据库结构定义语言的缩写词为 (  )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.插入新数据','B.描述数据库结构','修改数据','删除数据','','','B','在数据操作语言(DML)的基本功能中，不包括的是 (   ) ','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DB ','B.DBS','DBA   ','DBMS','','','D','数据库管理系统的英文缩写是（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DBMS  ','B.DB','DBS ','DBA','','','D','数据库应用系统是由数据库、数据库管理系统（及其开发工具）、应用系统、（ ）和用户构成。（提示：管理员）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.48','B.32','90','65','','','D','运行命令SELECT ASCII（‘Alklk’）的结果是（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DATA','B.INFORMATION ','DB','DBS','','','C','（  ）是被长期存放在计算机内的、有组织的、统一管理的相关数据的集合。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.USE','B.SELECT','UPDATE','DROP','','','B','SQL Server 2000中表查询的命令是（   ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.USE','B.SELECT','UPDATE','DROP','','','C','删SQL Server 2000中表更新数据的命令是（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.@sum ','B.j','sum','4kk','','','A','在SQL Server 2000中，下列变量名正确的是（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.YEAR（）','B.GETDATE（）','COUNT（）','SUM（）','','','B','用于求系统日期的函数是（  ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.CTEATE','B.REVOKE','SELECT','GRANT','','','D','向用户授予操作权限的SQL语句是（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.master','B.model','tempdb','msdb','','','A','SQL Server系统中的所有服务器级系统信息存储于哪个数据库（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.外键并不一定要与相应的主键同名','B.外键一定要与相应的主键同名','外键一定要与相应的主键同名而且唯一','外键一定要与相应的主键同名，但并不一定唯一','','','A','以下关于外键和相应的主键之间的关系，正确的是(   )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.UPDATE ','B.INSERT','ALTER ','MODIFY','','','C','在T-SQL语言中，修改表结构时，应使用的命令是（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据库减少了数据冗余 ','B.数据库中的数据可以共享','数据库避免了一切数据的重复','数据库具有较高的数据独立性','','','C','下列四项中说法不正确的是(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.多对多','B.一对一','多对一 ','一对多','','','D','公司中有多个部门和多名职员，每个职员只能属于一个部门，一个部门可以有多名职员，从部门到职员的联系类型是(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据库系统表','B.数据库模板','临时数据库','示例数据库','','','B','在SQL Server 中，model是(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据模型','B.视图','表','用户','','','A','下列哪个不是数据库对象（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.aili  ','B.bai','bba ','cca','','','B','模式查找like"_a%" ,下面哪个结果是可能的(  )','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DELETE ','B.DROP','CLEAR','REMOVE','','','A',' SQL语言中，删除记录的命令是( )。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SQL Server ','B.SQL Server Agent','MS DTC','PWS','','','D','删下列哪个不是SQL Server服务（  ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据类型','B.规则','默认','用户','','','A','下列哪个不是数据库对象（ ）。','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.这个文件是形式良好的。','B.这个文件是结构完整的','必需每个标记都是XML标准定义过了的','扩展名必须是.xml的文件','','','A','一个XML文件能被浏览器解析的最小要求是（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.delete booklist where bookname in ("book1","book2")','B.delete booklist where (bookname="book1") or (bookname="book2") ','delete booklist where bookname="book1" or bookname="book2"','delete booklist where bookname="book1" and bookname="book2"','','','D','若要删除booklist表中列bookname值为"book1"和"book2"的所有数据,一下语句删除不成功的是（）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.多样','B.重复','唯一','若干','','','C','主键索引可确保字段中输入值的（）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.W3C的XML小组制定了被称为命名空间（NameSpace）的标准','B.命名空间标准提供了一个很聪明的命名方法--前缀标识法','命名空间的合法名称形式为：前缀部分:本地部分','命名空间仅能作用于XML的元素内容。','','','D','关于命名空间标准的描述不正确的有：（  ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.DOM的全称是Document Object Model，也即文档对象模型','B.在应用程序中，基于DOM的XML分析器将一个XML文档转换成一个对象模型的集合（通常称DOM树）','通过DOM接口，应用程序可以在任何时候访问XML文档中的任何一部分数据，因此，这种利用DOM接口的机制也被称作随机访问机制','DOM强制使用树模型来访问XML文档中的信息，不适合XML的模式','','','D','关于XML接口DOM的描述，错误的是：（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SAX的全称是Simple APIs for XML，也即XML简单应用程序接口','B.SAX提供的访问模式是一种顺序模式，是快速读写XML数据的方式','SAX分析器的应用程序通过事件处理函数实现对XML文档的访问，因而SAX接口也被称作事件驱动接口','SAX分析器只做一些简单的工作，大部分工作要由应用程序自己去做,这样就影响了应用程序的效率','','','D','关于XML接口SAX的描述，错误的是：（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.语言、平台','B.操作系统','环境','可移植环境','','','A','DOM是对象化的XML数据接口，一个与（ ）无关的标准接口规范','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据发布','B.数据集成','交易自动化','数据转换','','','D','不属于XML信息交换类型的是：（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.0','NULL','B.125','1.25','','','B','下列语句select（NULL+100）*1.25 from tempa返回的结果是（）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.XML声明','B.处理指示','XML元素','文件的内容','','','AC','一个XML文件最基本的构成是（多选）：（ ）','简单',0.0,'java数据库编程','第二阶段');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据库管理语言','B.数据定义语言','数据控制语言','数据操纵语言','','','D','对数据库的操作分成三大类,DDL,DML,DCL,其中DML的意思是：','简单',0.0,'Java数据库编程','S2');--
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.层次型','B.网络型','关系型','对象型','','','C','SQL Server是一种        数据库管理系统','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.用户 ','B.系统分析员 ','DBA','应用程序员','','','C','某个用户对某类数据有何种操作权力由(   )决定','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.1NF ','B.2NF ','3NF  ','都没有','','','D','非主键必须依赖于主键于主键列, 这属于下列范式的内容(  )。','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A. PK(主键)  ','B.FK(外键) ','UK(唯一键)  ','复合主键','','','B','如果一个字段的数据必须来源另一个表的主键,那么要在这个字段上建立:','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.为了提高数据的查询速度 ','B.为了提高数据的增加的速度 ','可以通过索引实现主键约束','可以通过索引实现唯一约束','','','A','数据库系统中，有关索引的说法正确的是：','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.AGE<=22 AND AGE >=20 ','B.AGE <22 AND AGE >20 ','AGE <22 AND AGE >20','AGE =20 OR AGE =22','','','D','SQL中，"AGE IN(20, 22)"的语义是:','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.直接建表 ','B.先建立实体, 再建立表 ','先建立实体, 再建立实体关系, 最后转化为表','先建立ER模型完成概念设计, 再转化为关系模型。','','','C','数据库设计的步骤是','简单',0.0,'Java数据库编程','S2');                              
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.约束就是限制数据录入的范围 ','B.在开发中必须要使用外键约束,否则无法进行表连接 ','C.主键约束的本质就是唯一索引加上非空约束','D.两个表如果没有相同的字段,就无法进行表连接','','','B','下面列出的关于“约束”的条目中，哪一条是不正确的','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.实体完整性约束 ','B.参照完整性约束 ','C.用户自定义完整性约束','D.关键字完整性约束','','','C','有一个关系：学生(学号，姓名，系别)，规定学号的值域是8个数字组成的字符串，这一规则属于"()','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据查询 ','B.数据操纵(DML) ','C.数据定义(DDL)','D.数据控制(DCL)','','','D','在下面列出的数据模型中，哪一个是概念数据模型______。','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.关系模型 ','B.层次模型 ','C.网状模型','D.实体-关系模型','','','C','某个用户对某类数据有何种操作权力由(   )决定','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SQL注入就是通过工具反复猜登录的用户名和密码，直到破解 ','B.SQL注入指的是在sql加入特殊字符，从而不需要正确的用户名和密码就能登录 ','C.SQL注入指的是在sql加入特殊命令，从而达到破坏数据库的效果','D.指的在JDBC对PreparedStatement中的?参数进行赋值的过程','','','B','有关SQL注入，说法正确的有：','简',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.主键 ','B.外键 ','C.默认值','D.唯一约束','','','AD','下列哪个约束的值不能重复：','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.sum ','B.avg ',' C.max','D.count','','','CD','下列哪些统计函数可以计算在字符串类型列进行统计 ( )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.包括20岁和30岁 ','B.不包括20岁和30岁 ','C.包括20岁不包括30岁','D.不包括20岁包括30岁','','','A','在SQL语言中，条件“BETWEEN 20 AND 30”表示年龄在20到30之间，且(    )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.delete * from emp ','B.drop table emp ','C.truncate table emp','D.没有正确答案','','','C','SQL语言中，删除EMP表中全部数据的命令是( ) ','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.索引需要在查询时指明才能够优化执行 ','B.索引建立以后,对该表的所有查询都会使用到该索引 ','C.索引建立越多,则查询越快','D.可以对任何字段建立索引','','','ABCD','有关下列索引说法错误的是(    )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.索引的目的是为增加数据操作的速度 ','B.索引是数据库内部使用的对象 ','C.索引建立得太多，会降低数据增加删除修改速度','D只能为一个字段建立索引','','','AD','有关索引的说法错误的是(     )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A. *  ','B.ALL   ','C.DESC  ','D.DISTINCT','','','A','下列哪个关键字在select语句中表示所有列？( )','简单',0.0,'Java数据库编程','S2')
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.select stu_id, avg(socre) from score group by stu_id ','B.select stu_id, avg(sorce) from score ','C.select stu_id, avg(score) from score','D.select stu_id, sum(score)/count(score) from score','','','A','t_score(stu_id, sub_id, score)，即成绩表(学号，科目编号，成绩)。学生如果某科没有考试，则该科成绩录入null。能够获取各位学生的平均成绩的选项是：','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.实体完整性 ','B.参照完整性 ','C.用户定义的完整性','D.实体完整性、参照完整性和用户定义的完整性','','','B','定义外键实现的是哪一(些)类完整性？','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.ORDER BY ','B.GROUP BY ','C.Having','D.没有限制','','','D','SQLServer在子查询中不允许包括( )关键字','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.数据库可以减少数据冗余 ','B.数据库中的数据可以共享 ','C.数据库避免了一切数据的重复','D.数据库具有较高的数据独立性','','','C','下列四项中说法不正确的是( )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.不同的记录可以具有重复的主键值或空值 ','B.不同的记录可以具有重复的主键值或空值 ',' C.在一个表中主键只可以是一个字段  ','D.表中的主键的数据类型必须定义为自动编号或文本','','','B','下面有关主键的叙述正确的是(  )','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.学生信息表S ','B.学生信息表S和课程信息表c ','C.学生信息表S、课程信息表c和学生选课信息表sc','D.学生信息表S和学生选课信息表sc','','','D','在查询选修课程号为4，且成绩在80分以上的所有学生的学号和姓名的SQL语句中，将使用的表是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.JDBC就是一套接口,由SUN公司提出,各厂商实现 ','B.使用JDBC连接不同数据库时调用的接口是相同的 ','C.使用JDBC连接不同数据库时连接的字符串是相同的','D.由于使用Statement不需要对参数进行赋值,所以执行更快。','','','AD','下面有关JDBC说法正确的是：','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.S和SC','B.SC和C','C.S和C','D.S、SC和C','','','A','若要求“查询某个学生的基本信息及其选课的平均成绩”，将使用关系','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.SELECT Sno FROM SC GROUP BY Sno HAVING COUNT(*)> 3 ','B.SELECT Sno FROM SC GROUP BY Sno HAVING (COUNT(*)>= 3) ','C.SELECT Sno FROM SC ORDER BY Sno WHERE COUNT(*)> 3','D.SELECT Sno FROM SC ORDER BY Sno HAVING COUNT(*)> 3','','','A','若要求“查询选修了3门以上课程的学生的学生号”，正确的SQL语句是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.一对一 ','B.一对多 ','C.多对一','D.多对多','','','D','36、	“商品”与“顾客”两个实体集之间的联系一般是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.实体完整性规则——必须标识每个实体(对象) ','B.参照完整性规则 ','C.用户定义完整性规则','D.域完整性规则','','','A','设属性“学号”是实体“学生”的主键，则“学号”不能取空值(NULL)和重复。这是_______。','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.RDBMS是关系数据库管理系统的简称 ','B.各行记录都不能重复，是第二范式要求的 ','C.在数据库设计中一定要满足第三范式','D.索引越多，查询越快，数据更新越慢','','','A','下列说法中，哪些是正确的？','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('多选','A.XML文件要求必须是形式良好的。 ','B.XML文件要求必须是有效的。 ','C.有效的的XML文件一定是形式良好的XML文件。','D.形式良好的XML文件一定是有效的的XML文件。','','','AC','下列说法正确的有','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.Connection con = new Connection(); ','B.调用JDBC驱动程序类中的getConnection方法 ','C.调用JDBC驱动管理器的getConnection方法','D.使用Class.forName()方法获得','','','C','使用JDBC连接数据库时，如何获得连接对象','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.如果select语句没有查询到任何一行记录，返回的ResultSet将会是个空指针 ','B.刚刚打开的ResultSet实例，游标指针指向结果集的第一行 ','C.以字符串的方式取得第一个字段值，可以在ResultSet实例上调用getString(0)','D.对查询结果集处理完毕后，应当关闭结果集','','','D','关于ResultSet，说法正确的是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.PreparedStatement要求RDBMS对SQL语句进行预编译，因此执行的效率更高； ','B.对于动态SQL语句的参数使用?符号进行绑定，可以有效避免SQL注入攻击； ','C.与数组不同，PreparedStatement的第一个参数下标为1；	','D.PreparedStatement执行查询的效率很高，但执行更新的速度较慢。','','','D','关于PreparedStatement，说法错误的是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.<?xml version=1.0 encoding=gbk ?> ','B.<?xml version=”1.0” encoding=”gbk” ?> ','C.<?xml version=”1.0” charset=”gbk” ?>','D.<?xml version=”1.0” type=”stylesheet” ?>','','','B','XML声明正确的是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.只能有一个根元素 ','B.元素可以不闭合 ','C.和SQL语言一样，大小写不敏感','D.CDATA段中的双引号符号需要用实体&quot;来替代','','','A','关于XML的语法正确的是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.XML语法严谨，因此解析器的编写很复杂 ','B.纯文本的XML文档只能适合使用HTTP协议在网络上传输 ','C.XML可以被任何计算机语言处理，人阅读也很方便','D.通过使用合适的编码字符集，XML文档可以包含任何语言的文字','','','B','关于XML说法错误的是','简单',0.0,'Java数据库编程','S2');
INSERT INTO topicbank (testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,grade,falsely,cname,stagename)VALUES('单选','A.既要读取又要改写XML文档 ','B.处理超大型的XML文档 ','C.可能需要对XML的不同部分反复读取时','D.将内存数据转换成XML文件','','','B','使用DOM解析器不适合处理以下哪种情况','简单',0.0,'Java数据库编程','S2');


SELECT * FROM topicbank 

DROP TABLE difficulty
CREATE TABLE difficulty  (
		tid INT NOT NULL PRIMARY KEY ,
		grade VARCHAR(20) NOT NULL
);
INSERT INTO difficulty VALUES(1,'简单');
INSERT INTO difficulty VALUES(1,'简单');
INSERT INTO difficulty VALUES(1,'简单');
INSERT INTO difficulty VALUES(1,'简单');

SELECT * FROM difficulty




SELECT * FROM announce 
DROP TABLE IF EXISTS annouce;
CREATE TABLE announce(
 aid INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 theme VARCHAR(30) NOT NULL,
 titlecontent VARCHAR(50) NOT NULL,
 announcecont VARCHAR(255) NOT NULL,
 issuepeople VARCHAR(20) NOT NULL,
 issuetime VARCHAR(20) NOT NULL
);



INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('处分','早恋','xxx因在校期间与xxx日常交往中，交往行为超出正常男女交往亲密程度，对二人提出处分决定','佘福君','2018-01-03');
INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('处分','旷课','xxx因在校期间多次旷课，给与处分决定','佘福君','2018-01-03');
INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('警告','旷课','xxx因在校期间多次旷课，给与处分决定','佘福君','2019-02-23');
INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('处分','早恋','xxx因在校期间与xxx日常交往中，交往行为超出正常男女交往亲密程度，对二人提出处分决定','佘福君','2019-01-03');
INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('留校察看','顶撞老师','xxx因在校期间多次顶撞老师，给与留校察看处分','佘福君','2019-01-03');
INSERT INTO announce(theme,titlecontent,announcecont,issuepeople,issuetime) VALUES('处分','早恋','xxx因在校期间与xxx日常交往中，交往行为超出正常男女交往亲密程度，对二人提出处分决定','佘福君','2019-01-03')


SELECT * FROM conditions
DROP TABLE conditions
INSERT INTO conditions VALUES(8,0.0);
INSERT INTO conditions VALUES(9,0.0);
INSERT INTO conditions VALUES(10,0.1);

SELECT * FROM difficulty
DESC difficulty
INSERT INTO difficulty VALUES(1,'简单');
INSERT INTO difficulty VALUES(2,'简单');
INSERT INTO difficulty VALUES(3,'简单');
INSERT INTO difficulty VALUES(4,'简单');
INSERT INTO difficulty VALUES(5,'简单');
INSERT INTO difficulty VALUES(6,'简单');
INSERT INTO difficulty VALUES(7,'简单');
INSERT INTO difficulty VALUES(8,'简单');
INSERT INTO difficulty VALUES(9,'简单');
INSERT INTO difficulty VALUES(10,'简单');
INSERT INTO difficulty VALUES(11,'简单');
INSERT INTO difficulty VALUES(12,'简单');
INSERT INTO difficulty VALUES(13,'简单');
INSERT INTO difficulty VALUES(14,'简单');
INSERT INTO difficulty VALUES(15,'简单');
INSERT INTO difficulty VALUES(16,'简单');
INSERT INTO difficulty VALUES(17,'简单');
INSERT INTO difficulty VALUES(18,'简单');
INSERT INTO difficulty VALUES(19,'简单');
INSERT INTO difficulty VALUES(20,'简单');
INSERT INTO difficulty VALUES(21,'简单');
INSERT INTO difficulty VALUES(22,'简单');
INSERT INTO difficulty VALUES(23,'简单');
INSERT INTO difficulty VALUES(24,'简单');
INSERT INTO difficulty VALUES(25,'简单');
INSERT INTO difficulty VALUES(26,'简单');
INSERT INTO difficulty VALUES(27,'简单');
INSERT INTO difficulty VALUES(28,'简单');
INSERT INTO difficulty VALUES(29,'简单');
INSERT INTO difficulty VALUES(30,'简单');
INSERT INTO difficulty VALUES(31,'简单');
INSERT INTO difficulty VALUES(32,'简单');
INSERT INTO difficulty VALUES(33,'简单');
INSERT INTO difficulty VALUES(34,'简单');
INSERT INTO difficulty VALUES(35,'简单');
INSERT INTO difficulty VALUES(36,'简单');
INSERT INTO difficulty VALUES(37,'简单');
INSERT INTO difficulty VALUES(38,'简单');
INSERT INTO difficulty VALUES(39,'简单');
INSERT INTO difficulty VALUES(40,'简单');
INSERT INTO difficulty VALUES(41,'简单');
INSERT INTO difficulty VALUES(42,'简单');
INSERT INTO difficulty VALUES(43,'简单');
INSERT INTO difficulty VALUES(44,'简单');
INSERT INTO difficulty VALUES(45,'简单');
INSERT INTO difficulty VALUES(46,'简单');
INSERT INTO difficulty VALUES(47,'简单');
INSERT INTO difficulty VALUES(48,'简单');
INSERT INTO difficulty VALUES(49,'简单');
INSERT INTO difficulty VALUES(50,'简单');
INSERT INTO difficulty VALUES(51,'简单');
INSERT INTO difficulty VALUES(52,'简单');
INSERT INTO difficulty VALUES(53,'简单');
INSERT INTO difficulty VALUES(54,'简单');
INSERT INTO difficulty VALUES(55,'简单');
INSERT INTO difficulty VALUES(56,'简单');
INSERT INTO difficulty VALUES(57,'简单');
INSERT INTO difficulty VALUES(58,'简单');
INSERT INTO difficulty VALUES(59,'简单');
INSERT INTO difficulty VALUES(60,'简单');
INSERT INTO difficulty VALUES(61,'简单');
INSERT INTO difficulty VALUES(62,'简单');
INSERT INTO difficulty VALUES(63,'简单');
INSERT INTO difficulty VALUES(64,'简单');
INSERT INTO difficulty VALUES(65,'简单');
INSERT INTO difficulty VALUES(66,'简单');
INSERT INTO difficulty VALUES(67,'简单');
INSERT INTO difficulty VALUES(68,'简单');
INSERT INTO difficulty VALUES(69,'简单');
INSERT INTO difficulty VALUES(70,'简单');
INSERT INTO difficulty VALUES(71,'简单');
INSERT INTO difficulty VALUES(72,'简单');
INSERT INTO difficulty VALUES(73,'简单');
INSERT INTO difficulty VALUES(74,'简单');
INSERT INTO difficulty VALUES(75,'简单');
INSERT INTO difficulty VALUES(76,'简单');
INSERT INTO difficulty VALUES(77,'简单');
INSERT INTO difficulty VALUES(78,'简单');
INSERT INTO difficulty VALUES(79,'简单');
INSERT INTO difficulty VALUES(80,'简单');
INSERT INTO difficulty VALUES(81,'简单');
INSERT INTO difficulty VALUES(82,'简单');
INSERT INTO difficulty VALUES(83,'简单');
INSERT INTO difficulty VALUES(84,'简单');
INSERT INTO difficulty VALUES(85,'简单');
INSERT INTO difficulty VALUES(86,'简单');
INSERT INTO difficulty VALUES(87,'简单');
INSERT INTO difficulty VALUES(88,'简单');
INSERT INTO difficulty VALUES(89,'困难');



CREATE TABLE squad(
 sqid INT  NOT NULL PRIMARY KEY,
 snumber VARCHAR(20) NOT NULL ,
 speople INT NOT NULL,
 squadtime VARCHAR(15) NOT NULL,
 teacher VARCHAR(20)  NOT NULL,
 sadministration VARCHAR(20) NOT NULL,
 state VARCHAR(20) NOT NULL,
 classify VARCHAR(20) NOT NULL
);



INSERT INTO squad VALUES(1,'T235',33,'2017-04-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(2,'T236',32,'2017-05-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(3,'T237',30,'2017-06-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(4,'T238',31,'2017-07-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(5,'T239',31,'2017-08-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(6,'T240',31,'2017-09-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(7,'T241',35,'2017-10-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(8,'T242',29,'2017-11-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(9,'T243',30,'2017-12-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(10,'T244',33,'2018-01-01','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(11,'T245',32,'2018-01-10','佘福君','陈娟','在校','高中');
INSERT INTO squad VALUES(12,'T246',28,'2018-01-20','佘福君','陈娟','在校','高中');



SELECT * FROM studtype;
CREATE TABLE studtype(
  sid INT PRIMARY KEY NOT NULL,
  examtype INT NOT NULL,
  squadid INT NOT NULL
);
INSERT INTO studtype VALUES('01',0);
INSERT INTO studtype VALUES('02',0);
INSERT INTO studtype VALUES('03',0);
INSERT INTO studtype VALUES('04',0);
INSERT INTO studtype VALUES('05',0);
INSERT INTO studtype VALUES('06',0);
INSERT INTO studtype VALUES('07',0);
INSERT INTO studtype VALUES('08',0);
INSERT INTO studtype VALUES('09',0);
INSERT INTO studtype VALUES('10',0);
INSERT INTO studtype VALUES('15',0);
INSERT INTO studtype VALUES('20',0);
INSERT INTO studtype VALUES('22',0);





CREATE TABLE testpapertopic(
  tid INT PRIMARY KEY AUTO_INCREMENT,
  testpaperid INT NOT NULL,
  topicbankid INT NOT NULL
);
















CREATE TABLE teacher(
 tid VARCHAR(20) NOT NULL PRIMARY KEY,
 tname VARCHAR(20) NOT NULL,
 sex VARCHAR(11) NOT NULL,
 age INT NOT NULL,
 phone VARCHAR(15) NOT NULL,
 penguin INT NOT NULL,
 address VARCHAR(50) NOT NULL,
 situation VARCHAR(20) NOT NULL
   );
  SELECT * FROM teacher;
INSERT INTO teacher VALUES('001','周湘粤','男',18,'18574859117','642764043','湖南常德','在职');
INSERT INTO teacher VALUES('002','胡玲','女',18,'18273683379','1602610507','湖南安乡','在职');
INSERT INTO teacher VALUES('003','周志明','男',18,'15573148660','2799615127','湖南郴州','在职');
INSERT INTO teacher VALUES('004','梁巩','男',19,'13873830407','1352010675','湖南涟源','在职');
INSERT INTO teacher VALUES('005','罗兰','女',18,'18569426056','1325920605','湖南常德','在职');
INSERT INTO teacher VALUES('006','陈娟','女',18,'18942527552','261759602','湖南长沙','在职');
INSERT INTO teacher VALUES('007','陈昭','男',17,'15873035457','1423660713','湖南益阳','在职');
INSERT INTO teacher VALUES('008','刘斌','男',18,'13777221100','416559380','湖南郴州','在职');
INSERT INTO teacher VALUES('011','徐亚健','男',17,'13511164992','2224361237','湖南永州','在职');
INSERT INTO teacher VALUES('012','钟诚','男',18,'13545321160','378875365','湖南沅江','在职');
SELECT * FROM user_role
SELECT * FROM testpapertopic

SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult,fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename FROM topicbank T  JOIN difficulty D ,conditions C WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid   AND cname='java数据库编程' ORDER BY C.falsely DESC;