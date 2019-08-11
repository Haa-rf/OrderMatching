--User table
create table user(
   user_id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(128) NOT NULL,
   password VARCHAR(128) NOT NULL,
   type VARCHAR(128) NOT NULL,
   PRIMARY KEY ( user_id )
);

--Order table
create table orders(
  order_id INT NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(128) NOT NULL,
  order_type VARCHAR(128) NOT NULL,
  side VARCHAR(128) NOT NULL,
  quantity INT NOT NULL,
  price FLOAT NOT NULL,         --The length of float data type？
  status VARCHAR(128),
  create_date DATE,
  finish_date DATE,
  PRIMARY KEY (order_id)
 );

--TraderOrder table
create table trader_order(
  user_id INT NOT NULL,
  order_id INT NOT NULL
);


