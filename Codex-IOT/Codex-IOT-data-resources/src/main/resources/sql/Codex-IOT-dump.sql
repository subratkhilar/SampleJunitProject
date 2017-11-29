-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: <DatabaseName>
-- ------------------------------------------------------
-- Server version	5.5.48



-- Database: "Codex_IoT_POV"
-- DROP DATABASE "Codex_IoT_POV";

CREATE DATABASE "Codex_IoT_POV"
  WITH OWNER = postgres;
  
-- Schema: eventdb
-- DROP SCHEMA "eventdb";
CREATE SCHEMA "eventdb"
 AUTHORIZATION postgres;
  
  
-- Schema: operationdb
-- DROP SCHEMA "operationdb";
CREATE SCHEMA "operationdb"
  AUTHORIZATION postgres;

-- Table: operationdb.customers

-- DROP TABLE operationdb.customers;

CREATE TABLE operationdb.customers
(
    customer_id bigint NOT NULL,
    created_date timestamp without time zone,
    customer_location character varying(255) COLLATE pg_catalog."default",
    customer_name character varying(255) COLLATE pg_catalog."default",
    customer_number integer,
    email_id character varying(255) COLLATE pg_catalog."default",
    is_active boolean,
    updated_date timestamp without time zone,
    CONSTRAINT customers_pkey PRIMARY KEY (customer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.customers
    OWNER to postgres;
	
INSERT INTO operationdb.customers(
	customer_id, created_date, customer_location, customer_name, customer_number, email_id, is_active, updated_date)
	VALUES (1,'04-04-2017','US','Siemens',02211,'siemens@siemens.com',true,'05-10-2017'),
		   (2,'05-08-2016','US','Atos',021144,'Atosindia@atos.com',true,'05-05-2017'),
	      (3,'11-04-2017','India','ACF',22111,'Acfatos@acf.com',true,'05-10-2017'),
		  (4,'04-09-2016','Japan','Compose',033114,'Compose.atos@compose.com',true,'05-06-2017'),
	      (5,'11-04-2017','Italy','Unify',01144,'atos_unify@unify.com',false,'05-10-2017');	


-- Table: operationdb.projects

-- DROP TABLE operationdb.projects;

CREATE TABLE operationdb.projects
(
    project_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_date timestamp without time zone,
    is_active boolean,
    latitude character varying(255) COLLATE pg_catalog."default",
    longitude character varying(255) COLLATE pg_catalog."default",
    project_description character varying(255) COLLATE pg_catalog."default",
    project_location character varying(255) COLLATE pg_catalog."default",
    project_name character varying(255) COLLATE pg_catalog."default",
    updated_date timestamp without time zone,
    customer_id bigint,
    CONSTRAINT projects_pkey PRIMARY KEY (project_id),
    CONSTRAINT fkbv679k27d8mxb1hc7p2h8ghcj FOREIGN KEY (customer_id)
        REFERENCES operationdb.customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.projects
    OWNER to postgres;

INSERT INTO operationdb.projects(
	project_id, created_date, is_active, latitude, longitude, project_description, project_location, project_name, updated_date, customer_id)
	VALUES ('11','05-05-2017',true,'18.5204','73.8567','Management','Pune','Mindspere' ,'05-08-2016',1), 
			('12','06-05-2017',false,'19.0760','72.8777','Resources Management','Mumbai','Industry' ,'05-08-2016',2),
			('13','08-05-2017',true,'28.7041','77.1025','Mindsphere Apps','Delhi','Mindspere' ,'05-08-2016',3),
			('14','09-05-2017',false,'12.9716','77.5946','All mobile Apps','Bengaluru','MobileApp' ,'05-08-2016',4),
			('15','11-05-2017',true,'22.5726','88.3639','Cloudification Apps','Kolkata','Cloudification' ,'05-08-2016',5);
	
			

CREATE TABLE operationdb.role
(
    role_id bigint NOT NULL,
    rolename character varying(255) COLLATE pg_catalog."default",
    roletype character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT role_pkey PRIMARY KEY (role_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.role
    OWNER to postgres;

INSERT INTO operationdb.role(
	role_id, rolename, roletype) 
	VALUES (1,'CustomerAdmin','admin'),
	       (2,'ProjectAdmin','admin'),
	       (3,'BusinessUser','user');
		  

		

-- Table: operationdb.users

-- DROP TABLE operationdb.users;

CREATE TABLE operationdb.users
(
    user_id bigint NOT NULL,
    devicetoken character varying(255) COLLATE pg_catalog."default",
    firstname character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    username character varying(255) COLLATE pg_catalog."default",
    customer_id bigint,
    role_id bigint,
    CONSTRAINT users_pkey PRIMARY KEY (user_id),
    CONSTRAINT fk4qu1gr772nnf6ve5af002rwya FOREIGN KEY (role_id)
        REFERENCES operationdb.role (role_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkchxdoybbydcaj5smgxe0qq5mk FOREIGN KEY (customer_id)
        REFERENCES operationdb.customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.users
    OWNER to postgres;

 INSERT INTO operationdb.users(
	user_id, devicetoken, firstname, lastname, password, username, customer_id, role_id)
	VALUES (210,'token1', 'Nikhil','Vyas','Nikhil@(123','nikhil12@atos.net',1,3),
			(220,'token2', 'Rishi','Shrivastava','Rishi=$123','Rishi.shrivastava@atos.net',2,2),
			(230,'token3','jeevan','kulkarni','jeevan!@123','Jeevan.kulkarni@atos.net',3,1),
			(240,'token4','Ashish','Gonnade','Ashish@$123','Ashish12@atos.net',4,1),
			(250,'token4','Debashish','Mohanty','Ashish@$123','Ashish12@atos.net',1,1),
			(260,'token4','Rohit','Gupta','Rohit%*123','rohitgupta11@atos.net',2,3);
	

	  

CREATE TABLE operationdb.asset
(
    asset_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    asset_desc character varying(255) COLLATE pg_catalog."default",
    asset_ip_address character varying(255) COLLATE pg_catalog."default",
    asset_name character varying(255) COLLATE pg_catalog."default",
    asset_protocol character varying(255) COLLATE pg_catalog."default",
    asset_serial_number character varying(255) COLLATE pg_catalog."default",
    created_date timestamp without time zone,
    is_active boolean,
    updated_date timestamp without time zone,
    project_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT asset_pkey PRIMARY KEY (asset_id),
    CONSTRAINT fkct27spqlskneicas42m7vvnmj FOREIGN KEY (project_id)
        REFERENCES operationdb.projects (project_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.asset
    OWNER to postgres;
	
	  INSERT INTO "operationdb"."asset"(
	    asset_id, asset_desc, asset_ip_address, asset_name, asset_protocol, asset_serial_number, created_date, is_active, updated_date, project_id)
	      VALUES('100','Machineryasset','190.168.12.1','Machinery','IP' ,'ww300','02-04-2017',true,'05-12-2017','11'),
		  		('101','Assetbuilding','191.168.12.1','Buildings','IP','cc120','05-03-2016',false,'10-05-2016','12'),
           		('102','Assetlicense','192.161.11.2','Licenses','TCP','cc122','02-12-2016',true,'05-04-2017','13'),
	       		('103','Brandasset','192.122.12.2','Brands','TCP','zz670','10-09-2016',true,'12-06-2017','14'),
	       		('104','Trademarketingasset','191.123.12.1','Trademarket','IP','ss220','11-05-2017',false,'05-05-2017','15');



-- Table: operationdb.sensors

-- DROP TABLE operationdb.sensors;

CREATE TABLE operationdb.sensors
(
    sensor_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_date timestamp without time zone,
    is_active boolean,
    sensor_datatype character varying(255) COLLATE pg_catalog."default",
    sensor_description character varying(255) COLLATE pg_catalog."default",
    sensor_serial_number character varying(255) COLLATE pg_catalog."default",
    sensor_tag character varying(255) COLLATE pg_catalog."default",
    sensors_name character varying(255) COLLATE pg_catalog."default",
    upated_date timestamp without time zone,
    asset_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT sensors_pkey PRIMARY KEY (sensor_id),
    CONSTRAINT fkl5bmg5qb8p6e2mcob0nbfv3bu FOREIGN KEY (asset_id)
        REFERENCES operationdb.asset (asset_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.sensors
    OWNER to postgres;

	INSERT INTO operationdb.sensors(
	sensor_id, created_date, is_active, sensor_datatype, sensor_description, sensor_serial_number, sensor_tag, sensors_name, upated_date, asset_id)
	VALUES ('1', '11-04-2017', true,'alarmtype','Sensor alarm','220a','alarmsensor','Alarm sensor','12-12-2017','100'),
	('2', '05-04-2017', true,'switchtype','Sensor motion','334r','switchsensor','Motion Detector','15-12-2017','101'),
	('3', '09-04-2017', false,'motiontype','Sensor occupancy','111q','occupancysensor','Alarm sensor','20-12-2017','102'),
	('4', '10-05-2017', true,'occupancytype','Sensor about infrared','400w','alarmsensor','Occupancy sensor','05-12-2017','103'),
	('5', '15-04-2017', false,'infraredsensor','Sensor about switch','234s','infraredsensor','Passive infrared sensor','22-12-2017','104');	   
		   
	
	

-- Table: operationdb.temperature

-- DROP TABLE operationdb.temperature;

CREATE TABLE operationdb.temperature
(
    temp_id bigint NOT NULL,
    date timestamp without time zone,
    temperature integer NOT NULL,
    sensor_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT temperature_pkey PRIMARY KEY (temp_id),
    CONSTRAINT fkabbpr52o315gjtqvpd9xfbepq FOREIGN KEY (sensor_id)
        REFERENCES operationdb.sensors (sensor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.temperature
    OWNER to postgres;
	
	
INSERT INTO operationdb.temperature(
	temp_id, date, temperature, sensor_id)
	VALUES (1,'12-12-2017',100, '1'),
	 (2,'13-12-2017',102, '2'),
	 (3, '14-12-2017',201, '3');
	
	

-- Table: operationdb.timeseries

-- DROP TABLE operationdb.timeseries;

CREATE TABLE operationdb.timeseries
(
    timeseries_id bigint NOT NULL,
    date character varying(255) COLLATE pg_catalog."default",
    waterlevel character varying(255) COLLATE pg_catalog."default",
    sensor_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT timeseries_pkey PRIMARY KEY (timeseries_id),
    CONSTRAINT fknw2lojhmox3av37lq9fy1tvtx FOREIGN KEY (sensor_id)
        REFERENCES operationdb.sensors (sensor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE operationdb.timeseries
    OWNER to postgres;
	
INSERT INTO operationdb.timeseries(
	timeseries_id, date, waterlevel, sensor_id)
	VALUES (1, '13-12-2017', 'high', '1'),
	(2, '15-10-2017', 'low', '2'),
	(3, '17-11-2017', 'medium', '3');
	
	
	
-- Table: eventdb.event

-- DROP TABLE eventdb.event;


CREATE TABLE eventdb.event
(
    event_id bigint NOT NULL,
    created_date timestamp without time zone,
    event_description character varying(255) COLLATE pg_catalog."default",
    event_Type character varying(255) COLLATE pg_catalog."default",
    asset_id character varying(255) COLLATE pg_catalog."default",
    customer_id bigint,
    project_id character varying(255) COLLATE pg_catalog."default",
    sensor_id character varying(255) COLLATE pg_catalog."default",
    severity character varying(255) COLLATE pg_catalog."default",
    status character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT event_pkey PRIMARY KEY (event_id),
    CONSTRAINT fk79g9tcyr3j0n7vp28a4dbvkih FOREIGN KEY (project_id)
        REFERENCES operationdb.projects (project_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkfiqnrynks1kc5p8a79itacul5 FOREIGN KEY (asset_id)
        REFERENCES operationdb.asset (asset_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkhhoadgs2599y5ko2t6vlotpqf FOREIGN KEY (sensor_id)
        REFERENCES operationdb.sensors (sensor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkos0v4rvybihkg9gknrocgdq4n FOREIGN KEY (customer_id)
        REFERENCES operationdb.customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE eventdb.event
    OWNER to postgres;

ALTER TABLE eventdb.event
    OWNER to postgres;	
    
    
  INSERT INTO eventdb.event(
	event_id, created_date, event_description, event_Type, asset_id, customer_id, project_id, sensor_id, severity, status)
	VALUES (1, '12-12-2017','sensorevent', 'sensor information', '100', 1,'11','1','High','open'),
	(2, '12-12-2017','sensorevent', 'sensor information', '100', 1,'11','1','High','open'),
	(3, '12-12-2017','sensorevent', 'sensor information', '100', 1,'11','1','High','open'),
	(4, '12-12-2017','sensorevent', 'sensor information', '100', 1,'11','1','High','open'),
	(5, '08-10-2017','temperature event', 'temperature event information', '101', 2,'12','2','low','open'),
	(6, '07-11-2016','pressure event', 'pressure event information', '102', 3,'13','3','medium','open'),
	(7, '06-09-2017','temperature event', 'temperature event information', '103', 4,'14','4','High','open');
    
-- Table: eventdb.mst_event_template

-- DROP TABLE eventdb.mst_event_template;

CREATE TABLE eventdb.mst_event_template
(
    template_id bigint NOT NULL,
    event_template character varying(255) COLLATE pg_catalog."default",
    is_active boolean,
    CONSTRAINT mst_event_template_pkey PRIMARY KEY (template_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE eventdb.mst_event_template
    OWNER to postgres;
    
    
 INSERT INTO eventdb.mst_event_template(
	template_id, event_template, is_active)
	VALUES (1,'email event template',true),
	(2,'sms event template',false),
	(3,'mail event template',true);   
    
 -- Table: eventdb.mst_notification_type

-- DROP TABLE eventdb.mst_notification_type;

CREATE TABLE eventdb.mst_notification_type
(
    type_id bigint NOT NULL,
    type_description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT mst_notification_type_pkey PRIMARY KEY (type_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE eventdb.mst_notification_type
    OWNER to postgres;
    
INSERT INTO eventdb.mst_notification_type(
	type_id, type_description)
	VALUES (21, 'Sensor working'),
	(22, 'Temprature Sensor not working'),
	(23, 'water pressure working'),
	(24, 'Pressure Sensor worked');
    
    
-- Table: eventdb.notification

-- DROP TABLE eventdb.notification;

CREATE TABLE eventdb.notification
(
    notification_id bigint NOT NULL,
    created_date timestamp without time zone,
    is_deleted boolean,
    is_read boolean,
    type_id bigint,
    event_id bigint,
    user_id bigint,
    CONSTRAINT notification_pkey PRIMARY KEY (notification_id),
    CONSTRAINT fk913jbqdnmdkw6mm9bx23a36hj FOREIGN KEY (event_id)
        REFERENCES eventdb.event (event_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk9xx9rcte4ukp8te2d4ojrs1lr FOREIGN KEY (user_id)
        REFERENCES operationdb.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE eventdb.notification
    OWNER to postgres;
    
INSERT INTO eventdb.notification(
	notification_id, created_date, is_deleted, is_read, type_id, event_id, user_id)
	VALUES(1,'05-03-2017',true,true,21,1,210),
	(2,'05-04-2016',true,false,22,2,220),
	(3,'06-06-2017',false,true,23,3,230),
	(4,'07-10-2016',true,false,24,4,240),
	(5,'09-12-2017',false,false,22,1,220);
    

	



