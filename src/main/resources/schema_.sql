CREATE USER midorodb CREATEDB;

DROP DATABASE midorodb;

CREATE DATABASE midorodb OWNER midorodb;

CREATE TABLE tables (
	id serial primary key,

	code text,
	name text,
	description text,

	-- template
	created_at timestamp,
	updated_at timestamp,
	lock_version integer
);

CREATE TABLE rows (
	id serial primary key,
	table_id integer,

	value jsonb,

	-- template
	created_at timestamp,
	updated_at timestamp
);

CREATE TABLE table_metas (
	id serial primary key,
	table_id integer,

	-- template
	created_at timestamp,
	updated_at timestamp
);

CREATE TABLE column_metas (
	id serial primary key,
	table_meta_id integer,

	code text,
	name text,
	required boolean,
	uniqueness boolean,

	sort_order integer,	

	-- template
	created_at timestamp,
	updated_at timestamp
);

CREATE TABLE integer_column_metas (
	id serial primary key,
	column_meta_id integer,

	min integer,
	max integer
);

CREATE TABLE decimal_column_metas (
	id serial primary key,
	column_meta_id integer,
	
	min decimal,
	max decimal
);

CREATE TABLE text_column_metas (
	id serial primary key,
	column_meta_id integer,
	
	min_length integer,
	max_length integer,
	text_pattern text
);

CREATE TABLE select_column_metas (
	id serial primary key,
	column_meta_id integer,
	
	options text[],
	min integer,
	max integer
);
