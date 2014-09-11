create schema if not exists `computer-database-db`;
use `computer-database-db`;

drop table if exists computer;
drop table if exists company;

create table company (
  id                        bigint not null auto_increment,
  name                      varchar(255),
  constraint pk_company primary key (id))
;

create table computer (
  id                        bigint not null auto_increment,
  name                      varchar(255),
  introduced                timestamp,
  discontinued              timestamp,
  company_id                bigint,
  constraint pk_computer primary key (id))
;

alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_1 on computer (company_id);


#-----------------------------------
#USER RIGHTS MANAGEMENT
#-----------------------------------
CREATE USER 'jee-cdb'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON `computer-database-db`.* TO 'jee-cdb'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;
