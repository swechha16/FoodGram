create database if not exists relationaltest;
use relationaltest;

drop table if exists USER;
create table USER(
	username VARCHAR(50),
    full_name VARCHAR(50),
    email VARCHAR(300) not null,
    account_type VARCHAR(50) not null,
    phone_num INTEGER,
    location_city VARCHAR(50),
    location_state VARCHAR(50),
    password VARCHAR(50) not null,
    profile_pic VARCHAR(200),
    primary key(username)
);

drop table if exists PHOTO;
create table PHOTO(
	pic_id BIGINT, 
    username VARCHAR(50),
    pic VARCHAR(200) NOT NULL,
    comment VARCHAR(250),
    food_tags VARCHAR(50) NOT NULL,
    cost_tags VARCHAR(50) NOT NULL,
    timestamp VARCHAR(50) NOT NULL,
    primary key(pic_id),
    foreign key(username) references USER(username) on delete cascade
);