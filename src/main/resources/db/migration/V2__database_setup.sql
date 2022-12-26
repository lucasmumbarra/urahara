----------------------------------------------
-- v2 (26/12/2022)
----------------------------------------------

create table access_group (
  id bigint not null auto_increment,
  uuid varchar(100) not null,
  name varchar(100) not null,
  status varchar(100) not null,
  description varchar(100) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  deleted_at timestamp null,
  version int default null,
  primary key (id)
);

create table permission (
  id bigint not null auto_increment,
  uuid varchar(100) not null,
  status varchar(100) not null,
  access_level varchar(100) not null,
  access_group_id bigint not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  deleted_at timestamp null,
  version int default null,
  primary key (id),
  constraint FK_access_group_permission foreign key (access_group_id) references access_group (id)
);

create table user (
  id bigint not null auto_increment,
  uuid varchar(100) not null,
  name varchar(100) not null,
  document varchar(100) not null,
  email varchar(100) not null,
  password varchar(100) not null,
  status varchar(100) not null,
  customer_id bigint not null,
  access_group_id bigint not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  deleted_at timestamp null,
  version int default null,
  primary key (id),
  constraint FK_customer_user foreign key (customer_id) references customer (id),
  constraint FK_access_group_user foreign key (access_group_id) references access_group (id)
);

