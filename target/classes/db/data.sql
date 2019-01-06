

insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('user1','test','test','test','88888888','admin','YES');
insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('cust1','cust','cust','pune','88888888','cust','YES');
insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('fr','fr','fr','test','88888888','FR','YES');
insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('sadmin','sadmin','sadmin','test','88888888','FR','YES');
insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('user5','test','test','test','88888888','FR','YES');
insert into T_USER(USERNAME,FIRSTNAME,LASTNAME,ADDRESS,MOBILENO,TYPE,ACTIVE) values  ('user6','test','test','test','88888888','FR','YES');

insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('user1','3276de173c04c9eb0f07bfc0383c94fde404060c','admin',342432,'Y');
insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('admin','3276de173c04c9eb0f07bfc0383c94fde404060c','admin',342432,'Y');
insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('cust1','3276de173c04c9eb0f07bfc0383c94fde404060c','cust',342432,'Y');
insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('cust2','3276de173c04c9eb0f07bfc0383c94fde404060c','cust',12345,'Y');
insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('sadmin','3276de173c04c9eb0f07bfc0383c94fde404060c','sadmin',342432,'Y');
insert into T_LOGIN(USERNAME,PASSWORD,ROLE,COMPANYID,ACTIVE) values  ('fr','3276de173c04c9eb0f07bfc0383c94fde404060c','fr',342432,'Y');

 


INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (1,'viewchecklist','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (2,'createchecklist','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (3,'viewcompany','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (5,'viewcustomer','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (6,'dashboard','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (7,'viewnotification','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (8,'updatenotification','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (9,'viewproductchecklist','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (10,'createproductchecklist','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (11,'viewproducts','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (12,'createproduct','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (13,'viewproduct','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (14,'createproduct','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (15,'removeproduct','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (16,'editproduct','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (17,'associatechecklist','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (18,'createproducttype','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (19,'createticket','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (20,'createusers','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (21,'viewusers','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (22,'viewtickets','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (23,'changepassword','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (24,'createcustomerclient','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (25,'viewcustomerclient','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (26,'removecustomerclient','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (27,'editcustomerclient','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (28,'createtasks','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (29,'assignticket','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (30,'ticketaudit','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (31,'dashboard','cust');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (32,'viewnotification','cust');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (33,'updatenotification','cust');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (34,'createticket','cust');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (35,'viewtickets','cust');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (36,'createpart','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (37,'viewschedule','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (38,'schedulefr','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (39,'createcompany','sadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (40,'viewcompany','sadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (41,'editticket','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (42,'createticket','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (43,'createusers','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (44,'viewusers','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (45,'dashboard','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (46,'viewtickets','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (47,'changepassword','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (48,'editticket','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (49,'viewproductchecklist','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (50,'createproductchecklist','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (51,'createpart','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (52,'createpart','admin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (53,'estimate','cadmin');
INSERT INTO `t_role_function` (`id`,`appfunction`,`role`) VALUES (54,'estimate','admin');

