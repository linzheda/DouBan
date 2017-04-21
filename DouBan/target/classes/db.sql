
		
use douban;


--创建书籍类型表
create table category(
	c_id int primary key auto_increment,
	c_name varchar(500) not null
)
		
--创建书籍表
create table book(
	b_id int primary key auto_increment,
	b_name varchar(500) not null,
	b_price DECIMAL(10,2),
	b_author varchar(50),
	b_isbn varchar(30) not null,
	b_photo varchar(500),
	b_pdfs varchar(5000),
	b_description varchar(5000),
	b_c_id int,
	b_br_id int 
)
		
--创建书的等级表
create table bookrank(
	br_id int primary key auto_increment,
	br_rank varchar(50),
	br_ip varchar(500),
	br_scores int 
)
alter table book
   add constraint FK_book_b_c_id
      foreign key(b_c_id) references category(c_id);

alter table book
   add constraint FK_book_b_br_id
      foreign key(b_br_id) references bookrank(br_id);


