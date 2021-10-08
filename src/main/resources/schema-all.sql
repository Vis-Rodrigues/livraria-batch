drop table if exists TB_LIVRO;

create table TB_LIVRO(
	id int auto_increment not null primary key,
	titulo varchar(200) not null,
	isbn varchar(50) not null
);