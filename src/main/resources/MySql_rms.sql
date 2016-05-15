create database rms;

use rms;

create table users(
uid varchar(20)not null,
pwd varchar(16)not null,
constraint pk_usrs_uid primary key (uid)
);

create table roles(
rname varchar(15)not null,
rdesc varchar(150)not null,
constraint pk_roles_rname primary key(rname)
);

create table user_roles(
uid varchar(20) not null,
rname varchar(15)not null,
constraint pk_usrroles primary key(uid,rname),
constraint fk_uid foreign key(uid) references users(uid),
constraint fk_rname foreign key(rname) references roles(rname)
);

create table trans_entry(
trans_id bigint not null auto_increment,
trans_date date not  null,
amount float DEFAULT 0 not null,
item varchar(100) not null,
created_by varchar(20) not null,
modified_by varchar(20),
modified_date TIMESTAMP,
created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
constraint pk_trans_id primary key(trans_id),
constraint fk_created_by foreign key(created_by) references users(uid),
constraint fk_modified_by foreign key(modified_by) references users(uid)
);