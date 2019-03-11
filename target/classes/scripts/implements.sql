create table usuario(
	id_usuario_usr serial primary key,
	nm_nomeusu_usr text not null,
	nm_loginusr_usr text not null,
	nm_senhausr_usr text not null,
	nm_emailusr_usr text not null);
	
create table hora_lancamento(
	id_horalanc_hlc serial primary key,
	dt_datahlc_hlc timestamp NOT NULL default now(),
	nm_horainic_hlc text,
	nm_horaFinl_hlc text,
	id_usuario_usr bigint not null,
	constraint usurio_fk foreign key (id_usuario_usr) references usuario(id_usuario_usr));