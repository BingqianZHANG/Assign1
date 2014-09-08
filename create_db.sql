create table account (
    username varchar(255) not null primary key,
    password varchar(255),
    agencyno varchar(255) not null
);

create table ad (
    id int not null  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    address varchar(255) not null,
    propertytype varchar(255) not null,
    buildingsize int not null,
    yearofbuilt int,
    construction varchar(255)
);

create view jdbcrealm_user (username, password) as
select username, password
from account;

create view jdbcrealm_group (username, groupname) as
select username, 'Users'
from account;

select * from ad; 
select * from account;



-- insert into ad(address,propertytype,buildingsize,yearofbuilt,construction) values
-- ('9870 St Vincent Place','Villa',1000,2006,'Brick,glass'),
-- ('26 Victoria St ','Apartment',200,2010,'Brick'),
-- ('76 Kent Avenue','Townhouse',460,2008,'brick');


-- insert into account (username, password, agencyno) values
--     ('cbrady', 'password', '123456'),
--     ('mbrady', 'qwerty', '234567'),
--     ('anelson', '123456', '345678'),
--     ('sfranklin', 'iloveyou', '456789');
-- 
-- insert into account (username, password,agencyno) values
--     ('cbrady2', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', '123456'),
--     ('mbrady2', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5', '234567'),
--     ('anelson2', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '345678'),
--     ('sfranklin2', 'e4ad93ca07acb8d908a3aa41e920ea4f4ef4f26e7f86cf8291c5db289780a5ae', '456789'),
--     ('nancy', 'e4ad93ca07acb8d908a3aa41e920ea4f4ef4f26e7f86cf8291c5db289780a5ae', '456789');




