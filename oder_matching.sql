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
  side VARCHAR(128) NOT NULL,
  quantity INT NOT NULL,
  price FLOAT,
  status VARCHAR(128),
  create_date DATE,
  limit_time int,
  finish_date DATE,
  PRIMARY KEY (order_id)
 );

-- TraderOrder table
create table trader_order(
  trader_order_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  order_id INT NOT NULL,
  PRIMARY KEY (trader_order_id)
);

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