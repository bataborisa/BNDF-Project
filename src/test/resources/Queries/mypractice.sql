select * from EMPLOYEES;

select * from EMPLOYEES
where SALARY>6000 and DEPARTMENT_ID=60;

select * from EMPLOYEES
where JOB_ID='IT_PROG' or JOB_ID='MK_MAN' or JOB_ID='SA_REP';

select * from EMPLOYEES
where EMPLOYEE_ID IN (121,143,156,134);

select COUNTRY_NAME from COUNTRIES
where COUNTRY_ID NOT IN('US','IT');

select * from departments;
select count(*) from departments;

select count(distinct FIRST_NAME) from EMPLOYEES;

select Distinct  FIRST_NAME from EMPLOYEES;

select count(*) from EMPLOYEES
where JOB_ID in ('IT_PROG','SA_REP');

select JOB_ID,avg(salary),min(salary),max(SALARY),sum(salary),count(*) from EMPLOYEES
group by JOB_ID;

select DEPARTMENT_ID,sum(salary),count(*),max(salary),min(salary),round(avg(salary)) from EMPLOYEES
where DEPARTMENT_ID is not null   -- to remove null department id from result
group by DEPARTMENT_ID
order by max(salary) , min(salary) desc;

select first_name,count(*) from EMPLOYEES
group by first_name
having count(*)>1
order by 2 desc;

select FIRST_NAME as given_name from EMPLOYEES;

select FIRST_NAME as "given name" from EMPLOYEES;

select EMAIL||'@gmail.com' as full_email from EMPLOYEES;

select UPPER(EMAIL||'@gmail.com') as full_email from EMPLOYEES;

select email,length(email||'@gmail.com') as email_length  from EMPLOYEES
order by email_length;

select substr(FIRST_NAME,0,1)||'.'||substr(LAST_NAME,0,1)||'.' as initials from employees;

select substr(LAST_NAME,0,1)||'.'||substr(FIRST_NAME,0,1)||'.' as back_initials from
EMPLOYEES;

select * from EMPLOYEES
where  salary=(select max(salary) from EMPLOYEES);

select distinct SALARY
from EMPLOYEES
order by SALARY desc;

select * from EMPLOYEES
where SALARY < (select max(salary) from EMPLOYEES);

select * from EMPLOYEES
where SALARY = (select max(SALARY) from EMPLOYEES where SALARY < (select max(SALARY) from EMPLOYEES));

select min(SALARY) from EMPLOYEES;

select min(SALARY) from EMPLOYEES
where SALARY > (select min(SALARY) from EMPLOYEES);

select * from EMPLOYEES
where SALARY = (select min(SALARY) from EMPLOYEES
where SALARY > (select min(SALARY) from EMPLOYEES));

select * from EMPLOYEES
where rownum<11;

select * from (select * from EMPLOYEES order by salary desc )
where rownum<6;

-- display all information who is getting 5th highest salary
--display all different salaries in desc order

select distinct SALARY from EMPLOYEES order by salary desc;

select * from (select distinct SALARY from EMPLOYEES order by salary desc)
where ROWNUM < 6;

select min(SALARY) from (select * from (select distinct SALARY from EMPLOYEES order by salary desc)
                     where ROWNUM < 6);

select *
from EMPLOYEES
where SALARY = (select min(SALARY) from (select distinct SALARY from EMPLOYEES order by salary desc)
                                         where ROWNUM < 6);

create table boris(
    first varchar(20) unique ,
    last varchar(20) unique not null ,
    email varchar(30) unique not null ,
    id integer primary key
);

select *from boris;

insert into boris (first, last, email, id) VALUES ('Boris','Despot','boris@gmail.com',1);
insert into boris (first, last, email, id) VALUES ('Mix','Des','mix@gmail.com',2);
insert into boris (first, last, email, id) VALUES ('Sox','Despo','sox@gmail.com',3);
insert into boris (first, last, email, id) VALUES ('Tax','Desp','tax@gmail.com',4);

update boris set first = 'Box' where first =  'Boris';

create view boris as select * from EMPLOYEES
    where SALARY > 5000;

drop view boris;

delete from boris where first = 'Box';

alter table boris add (address varchar(20) );

truncate table boris;
drop table boris;

CREATE TABLE address(
                        address_id Integer PRIMARY KEY,
                        address VARCHAR(50) NOT NULL,
                        phone Integer NOT NULL
);

INSERT INTO address (address_id, address, phone) VALUES (5,
                                                         '1913 Hanoi Way',  28303384);
INSERT INTO address (address_id, address, phone) VALUES (7,
                                                         '692 Joliet Street',  44847719);
INSERT INTO address (address_id, address, phone) VALUES (8,
                                                         '1566 Inegl Manor',  70581400);
INSERT INTO address (address_id, address, phone) VALUES (10,
                                                         '1795 Santiago',  86045262);
INSERT INTO address (address_id, address, phone) VALUES (11,
                                                         '900 Santiago',  16571220);

CREATE TABLE customer(
                         customer_id Integer PRIMARY KEY,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50)NOT NULL,
                         address_id Integer REFERENCES address(address_id)
);

INSERT INTO customer (customer_id, first_name, last_name,
                      address_id) VALUES (1, 'Mary' ,  'Smith',  5);
INSERT INTO customer (customer_id, first_name, last_name,
                      address_id) VALUES (2,  'Patricia' ,  'Johnson' ,  NULl);
INSERT INTO customer (customer_id, first_name, last_name,
                      address_id) VALUES (3,  'Linda' ,  'Williams' ,  7);
INSERT INTO customer (customer_id, first_name, last_name,
                      address_id) VALUES (4, 'Barbara' ,  'Jones' , 8);
INSERT INTO customer (customer_id, first_name, last_name,
                      address_id) VALUES (5,  'Elizabeth' ,  'Brown' ,  NULL);

commit work;

select * from customer;
select * from address;

select * from customer c join address a on c.address_id = a.address_id;

create table Developers(
                           Id_Number Integer primary key,
                           Names varchar(30),
                           Salary Integer
);
create table Testers(
                        Id_Number Integer primary key,
                        Names varchar(30),
                        Salary Integer
);

insert into developers values (1, 'Mike', 155000);
insert into developers values (2, 'John', 142000);
insert into developers values (3, 'Steven', 850000);
insert into developers values (4, 'Maria', 120000);
insert into testers values (1, 'Steven', 110000);
insert into testers values(2, 'Adam', 105000);
insert into testers values (3, 'Lex', 100000);

commit work;

select * from customer c left join address a on c.address_id = a.address_id;

select * from customer c right join address a on c.address_id = a.address_id;

select * from customer c full join address a on c.address_id = a.address_id;

SELECT customer_id, first_name, last_name, address, phone FROM customer
LEFT OUTER JOIN address
ON customer.address_id = address.address_id
WHERE address.address_id IS NULL;

select *
from Developers
union
select * from Testers;

select * from Developers
minus
select * from Testers;

