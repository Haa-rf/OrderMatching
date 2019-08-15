-- User table
create table user(
   user_id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(128) NOT NULL,
   password VARCHAR(128) NOT NULL,
   type VARCHAR(128) NOT NULL,
   PRIMARY KEY ( user_id )
);

-- Order table
create table orders(
  order_id INT NOT NULL AUTO_INCREMENT,
  order_type VARCHAR(128) NOT NULL,
  trader_name VARCHAR(128) NOT NULL,
  symbol VARCHAR(128) NOT NULL,
  side VARCHAR(128) NOT NULL,
  quantity INT NOT NULL,
  quantity_left INT NOT NULL,
  price FLOAT,
  status VARCHAR(128),
  create_date TIMESTAMP,
  limit_time int,
  finish_date TIMESTAMP,
  PRIMARY KEY (order_id)
 );

-- TraderOrder table
-- create table trader_order(
--   trader_order_id INT NOT NULL AUTO_INCREMENT,
--   user_id INT NOT NULL,
--   order_id INT NOT NULL,
--   PRIMARY KEY (trader_order_id)
-- );

-- symbol table
create table symbol(
  symbol_id INT NOT NULL AUTO_INCREMENT,
  symbol_name VARCHAR(128) NOT NULL,
  PRIMARY KEY (symbol_id)
);

-- symbol_order table
-- create table symbol_order(
--   symbol_order_id INT NOT NULL AUTO_INCREMENT,
--   symbol_id INT NOT NULL,
--   order_id INT NOT NULL,
--   PRIMARY KEY (symbol_order_id)
-- );

insert into user(user_name,password,type) values ("test_trader","123456","trader");
insert into user(user_name,password,type) values ("test_admin","123456","admin");
insert into user(user_name,password,type) values ("test_trader1","123456","trader");
insert into user(user_name,password,type) values ("test_trader2","123456","trader");
insert into user(user_name,password,type) values ("test_trader3","123456","trader");
insert into user(user_name,password,type) values ("test_trader4","123456","trader");
insert into user(user_name,password,type) values ("test_trader5","123456","trader");
insert into user(user_name,password,type) values ("test2","123456","trader");


insert into symbol (symbol_name) values ("APPLE");
insert into symbol (symbol_name) values ("IBM");
insert into symbol (symbol_name) values ("CITI");
insert into symbol (symbol_name) values ("BAIDU");
insert into symbol (symbol_name) values ("BABA");


insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","APPLE","BUY",100,100,199.20,"2019-08-14 10:02:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","IBM","BUY",100,100,133.45,"2019-08-14 10:08:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","CITI","BUY",100,100,63.25,"2019-08-14 10:11:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","BAIDU","BUY",100,100,94.33,"2019-08-14 10:15:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","BABA","BUY",100,100,156.55,"2019-08-14 10:25:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","APPLE","SELL",100,100,202.25,"2019-08-14 10:33:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","IBM","SELL",100,100,134.25,"2019-08-14 10:38:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","CITI","SELL",100,100,64.75,"2019-08-14 10:45:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","BAIDU","SELL",100,100,95.66,"2019-08-14 10:50:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader","BABA","SELL",100,100,159.55,"2019-08-14 10:56:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","APPLE","BUY",100,100,198.25,"2019-08-14 11:03:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","IBM","BUY",100,100,133.65,"2019-08-14 11:09:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","CITI","BUY",100,100,63.11,"2019-08-14 11:11:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","BAIDU","BUY",100,100,93.75,"2019-08-14 11:19:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","BABA","BUY",100,100,155.55,"2019-08-14 11:27:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","APPLE","SELL",100,100,201.25,"2019-08-14 11:32:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","IBM","SELL",100,100,135.66,"2019-08-14 11:35:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","CITI","SELL",100,100,64.55,"2019-08-14 11:46:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","BAIDU","SELL",100,100,94.95,"2019-08-14 11:49:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader1","BABA","SELL",100,100,159.05,"2019-08-14 11:53:33",0,"pending");


insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","APPLE","BUY",100,100,197.33,"2019-08-14 12:02:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","IBM","BUY",100,100,133.15,"2019-08-14 12:16:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","CITI","BUY",100,100,63.15,"2019-08-14 12:19:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","BAIDU","BUY",100,100,93.75,"2019-08-14 12:21:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","BABA","BUY",100,100,156.25,"2019-08-14 12:24:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","APPLE","SELL",100,100,203.11,"2019-08-14 12:29:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","IBM","SELL",100,100,134.02,"2019-08-14 12:35:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","CITI","SELL",100,100,65.22,"2019-08-14 12:37:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","BAIDU","SELL",100,100,95.95,"2019-08-14 12:39:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader2","BABA","SELL",100,100,158.35,"2019-08-14 12:44:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","APPLE","BUY",100,100,199.75,"2019-08-14 13:05:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","IBM","BUY",100,100,133.98,"2019-08-14 13:16:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","CITI","BUY",100,100,64.25,"2019-08-14 13:19:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","BAIDU","BUY",100,100,92.75,"2019-08-14 13:22:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","BABA","BUY",100,100,157.25,"2019-08-14 13:28:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","APPLE","SELL",100,100,200.25,"2019-08-14 13:32:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","IBM","SELL",100,100,136.01,"2019-08-14 13:33:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","CITI","SELL",100,100,66.75,"2019-08-14 13:38:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","BAIDU","SELL",100,100,96.95,"2019-08-14 13:39:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader3","BABA","SELL",100,100,159.85,"2019-08-14 13:45:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","APPLE","BUY",100,100,199.98,"2019-08-14 14:16:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","IBM","BUY",100,100,132.25,"2019-08-14 14:19:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","CITI","BUY",100,100,62.25,"2019-08-14 14:22:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","BAIDU","BUY",100,100,93.75,"2019-08-14 14:24:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","BABA","BUY",100,100,156.33,"2019-08-14 14:29:33",0,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","APPLE","SELL",100,100,202.35,"2019-08-14 14:31:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","IBM","SELL",100,100,136.25,"2019-08-15 14:35:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","CITI","SELL",100,100,64.77,"2019-08-14 14:38:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","BAIDU","SELL",100,100,97.15,"2019-08-14 14:46:33",0,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status,create_date,limit_time) values ("LMT","test_trader4","BABA","SELL",100,100,158.75,"2019-08-14 14:57:33",0,"pending");

