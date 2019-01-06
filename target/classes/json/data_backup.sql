insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (8,'cust1','AC not working','REJECTED',TO_DATE('02/08/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD',342432,100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (9,'cust1','AC not working','SUBMITTED',TO_DATE('02/08/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD',342432,100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (1,'cust1','AC not working','INPROGRESS',TO_DATE('02/08/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD',342432,100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (2,'cust1','AC not working','SUBMITTED',TO_DATE('02/08/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD',342432,100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (3,'cust2','AC not working','SUBMITTED',TO_DATE('02/08/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD','12345',100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (4,'cust2','AC not working','SUBMITTED',TO_DATE('30/07/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD','12345',100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (5,'cust2','AC not working','SUBMITTED',TO_DATE('30/07/2018','DD/MM/YYYY'),TO_DATE('01/08/2018','DD/MM/YYYY'),'123','WAKAD','12345',100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (6,'cust2','AC not working','SUBMITTED',TO_DATE('30/07/2018','DD/MM/YYYY'),TO_DATE('01/08/2018','DD/MM/YYYY'),'123','WAKAD','12345',100);
insert into T_TICKET(ID,CREATEDBY, DESCRIPTION,STATUS,CREATED_ON,UPDATED_ON,DEVICEID,DEVICELOACTION,COMPANYID,ESTIMATE) values (7,'cust2','AC not working','SUBMITTED',TO_DATE('30/07/2018','DD/MM/YYYY'),TO_DATE('02/08/2018','DD/MM/YYYY'),'123','WAKAD','12345',100);



insert into T_RESOURCE(ID,NAME, CONTACT,LOCATION,TYPE) values (1,'AMEY3','8888606651','PUNE','ELECTRICAL');
insert into T_RESOURCE(ID,NAME, CONTACT,LOCATION,TYPE) values (2,'Aviraj','8888606652','PUNE','ELECTRICAL');
insert into T_RESOURCE(ID,NAME, CONTACT,LOCATION,TYPE) values (3,'Sagar','8888606654','PUNE','ELECTRICAL');
insert into T_RESOURCE(ID,NAME, CONTACT,LOCATION,TYPE) values (4,'Harsh','8888606656','MUMBAI','ELECTRICAL');
insert into T_RESOURCE(ID,NAME, CONTACT,LOCATION,TYPE) values (5,'Brajesh','8888606659','PUNE','ELECTRICAL');

insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (1,'CUSTOMER1','324324423432','customer1@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (2,'CUSTOMER2','324324423432','customer2@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (3,'CUSTOMER3','324324423432','customer3@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (4,'CUSTOMER4','324324423432','customer4@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (5,'CUSTOMER5','324324423432','customer5@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (6,'CUSTOMER6','324324423432','customer6@gmail.com');
insert into T_CUSTOMER(ID,CUSTOMER_NAME,CUSTOMER_CONTACT,CUSTOMER_EMAIL) values (7,'CUSTOMER17','324324423432','customer7@gmail.com');


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

insert into product_type( description ,  type , id,active) values ('electronics','Electronics',1,true);
insert into product_type( description ,  type , id,active) values ('Home Appliances','Home Appliances',2,true);
insert into product_type( description ,  type , id,active) values ('Mechanical','Mechanical',3,true);
insert into product_type( description ,  type , id,active) values ('FireFighting','FireFighting',4,true);
 
 

insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('1','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','AC','good product','123','LG','SMART','Electronics','SPLIT');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('2','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','CAR','good product','123','HONDA','JAZZ','Mechanical','SEDAN');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('3','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','TV','good product','123','SONY','OLED','Electronics','CURVE');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('4','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','CAR','good product','123','HONDA','CITY','Mechanical','HATCHBAK');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('5','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','AC','good product','123','HONDA','SMART','Electronics','SPLIT');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('6','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','AC','good product','123','LG','SMART2','Electronics','SPLIT');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('7','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','Bike','good product','123','YAMAHA','R15','Mechanical','Patrol');
insert into T_PRODUCT(ID  , CREATED_ON , UPDATED_ON  , ACTIVE  , CATEGORY  , COMMENTS  , COMPANYID  , PRODUCTBRAND  , PRODUCTNAME  , PRODUCTTYPE  , SUBCATEGORY  ) values  ('8','2012-05-05 00:00:00','2012-05-05 00:00:00','Y','CAR','good product','123','SUZUKI','BALENO','Mechanical','SEDAN');


 

 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 1,'admin','viewchecklist');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 2,'admin','createchecklist'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 3,'admin','viewcompany'); 
 --insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 4,'admin','createcompany'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 5,'admin','viewcustomer'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 6,'admin','dashboard'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 7,'admin','viewnotification'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 8,'admin','updatenotification'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 9,'admin','viewproductchecklist'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 10,'admin','createproductchecklist'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 11,'admin','viewproducts');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 12,'admin','createproduct');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 13,'admin','viewproduct'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 14,'admin','createproduct');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 15,'admin','removeproduct');  
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 16,'admin','editproduct');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 17,'admin','associatechecklist');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 18,'admin','createproducttype');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 19,'admin','createticket');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 20,'admin','createusers');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 21,'admin','viewusers');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 22,'admin','viewtickets');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 23,'admin','changepassword');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 24,'admin','createcustomerclient');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 25,'admin','viewcustomerclient');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 26,'admin','removecustomerclient');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 27,'admin','editcustomerclient');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 28,'admin','createtasks');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 29,'admin','assignticket');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 30,'admin','ticketaudit');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 31,'cust','dashboard'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 32,'cust','viewnotification'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 33,'cust','updatenotification'); 
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 34,'cust','createticket');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 35,'cust','viewtickets');
 insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 36,'admin','createpart');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 37,'admin','viewschedule');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 38,'admin','schedulefr');



insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 39,'admin','viewreports');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 40,'admin','downloadreport');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 41,'admin','estimate');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 42,'admin','editticket');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 43,'sadmin','createcompany');

insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 44,'admin','status');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 45,'admin','OpenTickets');
insert into T_ROLE_FUNCTION (ID,ROLE,FUNCTION) values( 46,'admin','onboard');


insert into T_PRODUCTCHECKLIST ( created_on , updated_on , active , checklistid , productid) values  ('2012-05-05 00:00:00','2012-05-05 00:00:00','Y',1,1);
insert into T_PRODUCTCHECKLIST ( created_on , updated_on , active , checklistid , productid) values  ('2012-05-05 00:00:00','2012-05-05 00:00:00','Y',1,2);
insert into T_PRODUCTCHECKLIST ( created_on , updated_on , active , checklistid , productid) values  ('2012-05-05 00:00:00','2012-05-05 00:00:00','Y',2,4);
insert into T_PRODUCTCHECKLIST (created_on , updated_on , active , checklistid , productid) values  ('2012-05-05 00:00:00','2012-05-05 00:00:00','Y',3,3);




insert into t_checklist (checklistid , active , checklistname , comments, companyid ) 
values(1,'Y','AC Checklist','Use for AC',342432);
insert into t_checklist (checklistid , active , checklistname , comments, companyid ) 
values(2,'Y','TV Checklist','Use for TV',342432);
insert into t_checklist (checklistid , active , checklistname , comments, companyid ) 
values(3,'Y','WASHING MACHIN Checklist','Use for TV',123);
insert into t_checklist (checklistid , active , checklistname , comments, companyid ) 
values(4,'Y','CAR Checklist','Use for AC',342432);
insert into t_checklist (checklistid , active , checklistname , comments, companyid ) 
values(5,'Y','BIKE Checklist','Use for AC',342432);


insert into t_tasks (taskid , checklistid , desc )
values(1,1,'Check Adapter');
insert into t_tasks (taskid , checklistid , desc )
values(2,1,'Check GAS');
insert into t_tasks (taskid , checklistid , desc )
values(3,1,'Check Condencer');


insert into t_tasks (taskid , checklistid , desc )
values(11,2,'Check Adapter');
insert into t_tasks (taskid , checklistid , desc )
values(12,2,'Check SCREEN');
insert into t_tasks (taskid , checklistid , desc )
values(13,2,'Check REMOTE');

insert into t_partproduct (partid , active , created_on , updated_on , productid , updateby ) values (123,  'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00', '1', 'user1');
insert into t_partproduct (partid , active , created_on , updated_on , productid , updateby ) values (345,  'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00', '1', 'user1');
insert into t_partproduct (partid , active , created_on , updated_on , productid , updateby ) values (678,  'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00', '1', 'user1');
insert into t_partproduct (partid , active , created_on , updated_on , productid , updateby ) values (90,  'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00', '1', 'user1');


insert into t_part (id , active , created_on , updated_on , category , comments , companyid , partbrand , partname , parttype , price , subcategory ) values (123,'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00','AC','Good Product',342432,'LG','Volve 300','Volve','50','SMARTAC');
insert into t_part (id , active , created_on , updated_on , category , comments , companyid , partbrand , partname , parttype , price , subcategory ) values (345,'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00','AC','Good Product',342432,'LG','Volve 500','Volve','50','SMARTAC');
insert into t_part (id , active , created_on , updated_on , category , comments , companyid , partbrand , partname , parttype , price , subcategory ) values (678,'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00','AC','Good Product',342432,'LG','Volve 700','Volve','50','SMARTAC');
insert into t_part (id , active , created_on , updated_on , category , comments , companyid , partbrand , partname , parttype , price , subcategory ) values (90,'Y', '2012-05-05 00:00:00', '2012-05-05 00:00:00','AC','Good Product',342432,'LG','Volve 100','Volve','50','SMARTAC');

  
insert into t_barcodechecklisttask (barcodeid , checklistid , comments,taskid, taskstatus,updateby) values (1,1,'GOod',1,'true','user1');
insert into t_barcodechecklisttask (barcodeid , checklistid , comments,taskid, taskstatus,updateby) values (1,1,'GOod',2,'true','user1');
insert into t_barcodechecklisttask (barcodeid , checklistid , comments,taskid, taskstatus,updateby) values (1,1,'GOod',3,'false','user1');
	  
insert into t_barcodepart (barcodeid , partid , updateby ) values (411,123,'user1');
insert into t_barcodepart (barcodeid , partid , updateby ) values (411,345,'user1');
  
  
  
 insert into t_ticketbarcode 
 (id , active  , created_on , updated_on , barcodeid , ticketid, updateby ) values
  (1 , 'Y'  , '2012-05-05 00:00:00', '2012-05-05 00:00:00' , 1 , 1, 'user1' );

  
  insert into  t_barcodeproduct (barcodeid , active , created_on , updated_on , companyid , productid , updateby )
  values
  (1 , 'Y'  , '2012-05-05 00:00:00', '2012-05-05 00:00:00' , 342432 , 1, 'user1' )



  insert into  t_barcodeproduct (barcodeid , active , created_on , updated_on , companyid , productid , updateby )
  values
  (2 , 'Y'  , '2012-05-05 00:00:00', '2012-05-05 00:00:00' , 342432 , 1, 'user1' );
  