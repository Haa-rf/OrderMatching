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

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","APPLE","BUY",100,100,199.20,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","IBM","BUY",100,100,133.45,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","CITI","BUY",100,100,63.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","BAIDU","BUY",100,100,94.33,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","BABA","BUY",100,100,156.55,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","APPLE","SELL",100,100,202.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","IBM","SELL",100,100,134.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","CITI","SELL",100,100,64.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","BAIDU","SELL",100,100,95.66,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader","BABA","SELL",100,100,159.55,"pending");

insert into symbol (symbol_name) values ("APPLE");


insert into user(user_name,password,type) values ("test_trader1","123456","trader");
insert into user(user_name,password,type) values ("test_trader2","123456","trader");
insert into user(user_name,password,type) values ("test_trader3","123456","trader");
insert into user(user_name,password,type) values ("test_trader4","123456","trader");
insert into user(user_name,password,type) values ("test_trader5","123456","trader");


insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","APPLE","BUY",100,100,198.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","IBM","BUY",100,100,133.65,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","CITI","BUY",100,100,63.11,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","BAIDU","BUY",100,100,93.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","BABA","BUY",100,100,155.55,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","APPLE","SELL",100,100,201.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","IBM","SELL",100,100,135.66,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","CITI","SELL",100,100,64.55,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","BAIDU","SELL",100,100,94.95,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader1","BABA","SELL",100,100,159.05,"pending");


insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","APPLE","BUY",100,100,197.33,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","IBM","BUY",100,100,133.15,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","CITI","BUY",100,100,63.15,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","BAIDU","BUY",100,100,93.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","BABA","BUY",100,100,156.25,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","APPLE","SELL",100,100,203.11,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","IBM","SELL",100,100,134.02,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","CITI","SELL",100,100,65.22,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","BAIDU","SELL",100,100,95.95,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader2","BABA","SELL",100,100,158.35,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","APPLE","BUY",100,100,199.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","IBM","BUY",100,100,133.98,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","CITI","BUY",100,100,64.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","BAIDU","BUY",100,100,92.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","BABA","BUY",100,100,157.25,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","APPLE","SELL",100,100,200.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","IBM","SELL",100,100,136.01,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","CITI","SELL",100,100,66.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","BAIDU","SELL",100,100,96.95,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader3","BABA","SELL",100,100,159.85,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","APPLE","BUY",100,100,199.98,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","IBM","BUY",100,100,132.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","CITI","BUY",100,100,62.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","BAIDU","BUY",100,100,93.75,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","BABA","BUY",100,100,156.33,"pending");

insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","APPLE","SELL",100,100,202.35,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","IBM","SELL",100,100,136.25,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","CITI","SELL",100,100,64.77,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","BAIDU","SELL",100,100,97.15,"pending");
insert into orders (order_type,trader_name,symbol,side,quantity,quantity_left,price,status) values ("MKT","test_trader4","BABA","SELL",100,100,158.75,"pending");


insert into symbol (symbol_name) values ("IBM");
insert into symbol (symbol_name) values ("CITI");
insert into symbol (symbol_name) values ("BAIDU");
insert into symbol (symbol_name) values ("BABA");
