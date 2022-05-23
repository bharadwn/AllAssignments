/**
An E-commerce website manages its data in the form of various tables.

**/
create database IF NOT EXISTS ecommerce_site;
use ecommerce_site;
/**
1) You are required to create tables for supplier,customer,category,product,supplier_pricing,
order,rating to store the data for the E-commerce with the schema definition given below.
**/

create table supplier(
Supp_ID int primary key,
SUPP_NAME varchar(50) NOT NULL,
SUPP_CITY varchar(50) NOT NULL,
SUPP_PHONE varchar(50) NOT NULL
							);
                            
create table customer(
CUS_ID int primary key,
CUS_NAME VARCHAR(20) NOT NULL,
CUS_PHONE VARCHAR(10) NOT NULL,
CUS_CITY VARCHAR(30) NOT NULL,
CUS_GENDER CHAR
							);
                            
create table category(          
CAT_ID INT primary key,
CAT_NAME VARCHAR(20) NOT NULL
);

create table product(         
PRO_ID INT primary key,
PRO_NAME VARCHAR(20) NOT NULL DEFAULT "Dummy",
PRO_DESC VARCHAR(60),
CAT_ID INT ,
foreign key (cat_id) references category(CAT_ID)
);

create table supplier_pricing(    
PRICING_ID INT primary key,
PRO_ID INT ,
SUPP_ID INT ,
SUPP_PRICE INT DEFAULT 0      ,
foreign key (PRO_ID) references product(PRO_ID) ,
foreign key (SUPP_ID) references supplier (Supp_ID)
);

create table order1(
ORD_ID INT primary key,
ORD_AMOUNT INT NOT NULL,
ORD_DATE DATE NOT NULL,
CUS_ID INT ,
PRICING_ID INT , 
foreign key (CUS_ID) references customer(CUS_ID),
foreign key (PRICING_ID) references supplier_pricing(PRICING_ID)
);

create table rating(     
RAT_ID INT primary key     ,
ORD_ID INT ,
RAT_RATSTARS  INT NOT NULL,
foreign key (ORD_ID) references order1(ORD_ID)
);
/**
2) Insert the following data in the table created above
**/
insert into supplier values(1,"Rajesh Retails","Delhi",1234567890);
insert into supplier values(2,"Appario Ltd.","Mumbai",2589631470);
insert into supplier values(3,"Knome products","Banglore",9785462315);
insert into supplier values(4,"Bansal Retails","Kochi",8975463285);
insert into supplier values(5,"Mittal Ltd.","Lucknow",7898456532);

insert into customer values(1,"AAKASH",9999999999,"Delhi",'M');
insert into customer values(2,"AMAN",9785463215,"NOIDA",'M');
insert into customer values(3,"NEHA",9999999999,"MUMBAI",'F');
insert into customer values(4,"MEGHA",9994562399,"KOLKATA",'F');
insert into customer values(5,"PULKIT",7895999999,"LUCKNOW",'M');

insert into category values(1,"BOOKS");
insert into category values(2,"GAMES");
insert into category values(3,"GROCERIES");
insert into category values(4,"ELECTRONICS");
insert into category values(5,"CLOTHES");

insert into product values(1,"GTA V","Windows 7 and above with i5 processor and 8GB RAM",2);
insert into product values(2,"TSHIRT","SIZE-L with Black, Blue and White variations",5);
insert into product values(3,"ROG LAPTOP","Windows 10 with 15inch screen, i7 processor, 1TB SSD",4);
insert into product values(4,"OATS","Highly Nutritious from Nestle",3);
insert into product values(5,"HARRY POTTER","Best Collection of all time by J.K Rowling",1);
insert into product values(6,"MILK","1L Toned MIlk",3);
insert into product values(7,"Boat Earphones","1.5Meter long Dolby Atmos",4);
insert into product values(8,"Jeans","Stretchable Denim Jeans with various sizes and color",5);
insert into product values(9,"Project IGI","compatible with windows 7 and above",2);
insert into product values(10,"Hoodie","Black GUCCI for 13 yrs and above",5);
insert into product values(11,"Rich Dad Poor Dad","ritten by RObert Kiyosaki",1);
insert into product values(12,"Train Your Brain","By Shireen Stephen",1);

insert into supplier_pricing values(1,1, 2, 1500);
insert into supplier_pricing values(2,3, 5, 30000);
insert into supplier_pricing values(3,5, 1, 3000);
insert into supplier_pricing values(4,2, 3, 2500);
insert into supplier_pricing values(5,4, 1, 1000);

insert into order1 values(101, 1500, '2021-10-06', 2, 1);
insert into order1 values(102, 1000, '2021-10-12', 3, 5);
insert into order1 values(103, 30000, '2021-09-16', 5, 2);
insert into order1 values(104, 1500, '2021-10-05', 1, 1);
insert into order1 values(105, 3000, '2021-08-16', 4, 3);/**doesnt work because out of range for the PRICING_ID constraint of FK- for ref integrity
insert into order1 values(106, 1450, '2021-08-18', 1, 9);
insert into order1 values(107, 789, '2021-09-01', 3, 7);
insert into order1 values(108, 780, '2021-09-07', 5, 6);*/
insert into order1 values(109, 3000, '2021-00-10', 5, 3);
insert into order1 values(110, 2500, '2021-09-10', 2, 4);
insert into order1 values(111, 1000, '2021-09-15', 4,5);/**doesnt work because out of range for the PRICING_ID constraint of FK- for ref integrity
insert into order1 values(112, 789, '2021-09-16', 4, 7);
insert into order1 values(113, 31000, '2021-09-16', 1, 8);*/
insert into order1 values(114, 1000, '2021-09-16', 3, 5);
insert into order1 values(115, 3000, '2021-09-16', 5, 3);/**doesnt work because out of range for the PRICING_ID constraint of FK- for ref integrity
insert into order1 values(116, 99, '2021-09-17', 2, 14);*/

/**inserting some valid values with my own data- changed only the last value below**/
insert into order1 values(106, 1450, '2021-08-18', 1, 5);
insert into order1 values(107, 789, '2021-09-01', 3, 4);
insert into order1 values(108, 780, '2021-09-07', 5, 3);
insert into order1 values(112, 789, '2021-09-16', 4, 2);
insert into order1 values(113, 31000, '2021-09-16', 1, 1);
insert into order1 values(116, 99, '2021-09-17', 2, 5);
/**inserting some valid values with my own data- changed only the last value above**/


insert into rating values(1,101, 4);
insert into rating values(2,102, 3);
insert into rating values(3,103, 1);
insert into rating values(4,104, 2);
insert into rating values(5,105, 4);
insert into rating values(6,106, 3);
insert into rating values(7,107, 4);
insert into rating values(8,108, 4);
insert into rating values(9,109, 3);
insert into rating values(10,110, 5);
insert into rating values(11,111, 3);
insert into rating values(12,112, 4);
insert into rating values(13,113, 2);
insert into rating values(14,114, 1);
insert into rating values(15,115, 1);
insert into rating values(16,116, 0);

/**
Queries →
Write queries for the following:
3) Display the total number of customers based on gender who have placed orders of worth at least Rs.3000.
**/
select customer.cus_gender, count(customer.cus_ID) as customerCNT from customer WHERE customer.CuS_id IN
(select order1.cus_ID from  order1 where order1.ord_amount>=3000) GROUP BY customer.cus_gender;


/**
4) Display all the orders along with product name ordered by a customer having Customer_Id=2
**/
select ordProTbl.pro_ID,ordProTbl.ord_id,ordProTbl.ord_amount,ordProTbl.ord_date, ordProTbl.cus_id,PRD.pro_name as ProductName from
(select supplier_pricing.PRO_ID,order1.ord_id,order1.ord_amount,order1.ord_date, order1.cus_id from supplier_pricing  
INNER JOIN order1 
ON supplier_pricing.PRICING_ID=order1.PRICING_ID AND order1.cus_ID=2
) AS ordProTbl
INNER JOIN product AS PRD
ON ordProTbl.pro_ID =PRD.pro_id;


/**
5) Display the Supplier details who can supply more than one product.
**/
select tab1.supp_ID,tab1.SUPP_CNT,tab2.SUPP_NAME,tab2.SUPP_CITY,tab2.supp_PHONE from 
(select supplier_pricing.supp_ID ,count(supp_ID) as SUPP_cnt from supplier_pricing  group by SUPP_ID having SUPP_cnt>1) as tab1
INNER JOIN supplier as tab2
WHERE tab1.supp_ID=tab2.supp_ID ;


/**
6) Find the least expensive product from each category and print the table with category id, name, product name and price of the product
**/
select *,min(prodSuppTbl1.supp_price) as minPrice from 
(select prodSuppTbl.cat_id,prodSuppTbl.cat_name,prodSuppTbl.pro_name,prodSuppTbl.supp_price from
(
select prodCATtbl.pro_id,prodCATtbl.pro_name,prodCATtbl.cat_id,prodCATtbl.cat_name,suppPriceTbl.pricing_id,suppPriceTbl.supp_price from (
select product.pro_id,product.pro_name,product.pro_desc,category.cat_id,category.cat_name from product, category  WHERE category.cat_id=product.cat_ID order by product.cat_ID
) as prodCATtbl
RIGHT JOIN
Supplier_pricing as suppPriceTbl ON suppPriceTbl.pro_id=prodCATtbl.pro_id
) as prodSuppTbl
) as prodSuppTbl1 group by prodSuppTbl1.cat_id;

/**
7) Display the Id and Name of the Product ordered after “2021-10-05”.
-JOIN or INNER JOIN can be used
**/
select tbl4.pro_id, tbl4.ord_date, product.pro_name from
(select tbl3.pro_id, tbl3.ord_date from
(select  * from 
(select order1.pricing_id as priceID,order1.ord_date from order1 where ord_date>'2021-10-05') as tbl1
JOIN
supplier_pricing as tbl2 where tbl1.priceID = tbl2.pricing_id ) as tbl3
) as tbl4
JOIN
product where tbl4.pro_id=product.pro_id;



/**
8) Display customer name and gender whose names start or end with character 'A'.
**/
select c.cus_name, c.cus_gender from customer c where c.cus_name LIKE '%a' OR c.cus_name LIKE 'a%';


/**
9) Create a stored procedure to display supplier id, name, rating and Type_of_Service. For Type_of_Service, 
If rating =5, print “Excellent Service”,If rating >4 print “Good Service”, If rating >2 print “Average Service”  else print “Poor Service”;

a)The above rating system will not rate anything as 'Good Service' as anything above 4 i.e 5 will be rated Excellent Service

b)The below syntax provided in the videos was not working -it was showing errors. so used online sources to arrive with one with no syntax errors.
CREATE PROCEDURE  SelectAllStudentMarks
AS
Select Marks  from Student
GO;
EXEC SelectAllStudentMarks

Have not used DELimiters, Seems to work fine.
**/

CREATE PROCEDURE Rating_of_supplierOrders()
(	select tb2.supp_id,tb2.ord_id,tb2.supp_name,ra.RAT_RATSTARS ,
		CASE	    
			WHEN ra.RAT_RATSTARS=5 THEN 'Excellent Service'
			WHEN ra.RAT_RATSTARS>4 THEN 'Good Service'    
			WHEN ra.RAT_RATSTARS>2 THEN 'Average Service'
			ELSE 'Poor Service'
		END As Type_of_Service
	from
	(
	select tb1.supp_id,tb1.supp_name,tb1.pricing_id,ord.ord_id from 
	(
	select s.supp_id,s.supp_name,sp.pricing_id from supplier s
	INNER JOIN
	supplier_pricing sp ON s.supp_id=sp.supp_id
	) AS tb1
	JOIN order1 ord
	ON tb1.pricing_id=ord.pricing_id
	) AS tb2
	JOIN rating ra
	ON tb2.ord_id =ra.ord_id
);

CALL Rating_of_supplierOrders;




    

