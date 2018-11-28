create table if not exists contract
(
	id bigserial not null
		constraint contract_pkey
			primary key,
	name varchar(255)
)
