----------------------------------------------
-- v1 (04/12/2022)
----------------------------------------------

create table customer (
  id bigint not null auto_increment,
  uuid varchar(100) not null,
  name varchar(100) not null,
  email varchar(100) not null,
  telephone varchar(100) not null,
  status varchar(100) not null,
  hostname varchar(100) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  deleted_at timestamp null,
  version int default null,
  primary key (id)
);

