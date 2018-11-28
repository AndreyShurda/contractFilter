-- drop table contract;

create table if not exists contract (
    id bigint NOT NULL auto_increment,
    name VARCHAR(255) NULL,
    primary key (id)
);
