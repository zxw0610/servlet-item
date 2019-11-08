# DataBase 
# User表，用于存储用户信息
drop table if exists t_use
create table if not exists t_use{
	id int primary_key auto_increment,
	name varchar(100) not null,
	pwd varchar(100),
	age int(10),
	brith date
}; 

# 