CREATE DATABASE IF NOT EXISTS tarefa;


use tarefa;

create table usuarios (

id BIGINT NOT NULL AUTO_INCREMENT,login varchar(30) not null,
senha varchar(30) not null,primary key (id)
);

create table tarefas (
id BIGINT NOT NULL AUTO_INCREMENT,
  descricao VARCHAR(255),
  finalizado BOOLEAN,
  dataFinalizacao DATE,
  primary key (id)
);