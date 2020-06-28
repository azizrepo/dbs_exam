DROP TABLE IF EXISTS PRODUCT_DETAILS;  
CREATE TABLE PRODUCT_DETAILS (  
product_code INT AUTO_INCREMENT  PRIMARY KEY,  
product_name VARCHAR(20) NOT NULL,  
product_quantity INT(6) NOT NULL
);  

DROP TABLE IF EXISTS ORDER_DETAILS;  
CREATE TABLE ORDER_DETAILS (  
order_id INT AUTO_INCREMENT  PRIMARY KEY,  
order_customer_name VARCHAR(50) NOT NULL,  
order_date  DATE NOT NULL,
order_shipping_address VARCHAR(50) NOT NULL,  
prder_total_amount DOUBLE NOT NULL
);  

DROP TABLE IF EXISTS ORDER_PRODUCT_DETAILS;  

CREATE TABLE ORDER_PRODUCT_DETAILS (  
fk_product_code int(6) references PRODUCT_DETAILS(product_code) ,
fk_order_id int(6)references ORDER_DETAILS(order_id)
);




