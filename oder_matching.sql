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
  side VARCHAR(128) NOT NULL,
  quantity INT NOT NULL,
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
create table symbol_order(
  symbol_order_id INT NOT NULL AUTO_INCREMENT,
  symbol_id INT NOT NULL,
  order_id INT NOT NULL,
  PRIMARY KEY (symbol_order_id)
);

insert into user(user_name,password,type) values ("test_trader","123456","trader");
insert into user(user_name,password,type) values ("test_admin","123456","admin");

insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","BUY",100,12.25,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","BUY",100,15.25,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","BUY",100,11.25,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","BUY",100,12.75,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","BUY",100,12.55,"peding");

insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","SELL",100,14.25,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","SELL",100,13.25,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","SELL",100,15.75,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","SELL",100,12.95,"peding");
insert into orders (order_type,trader_name,side,quantity,price,status) values ("MKT","test_admin","SELL",100,12.55,"peding");

insert into symbol (symbol_name) values ("APPLE");