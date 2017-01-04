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
	updated_at timestamp,
	lock_version integer
);

CREATE TABLE table_metas (
	id serial primary key,
	code text,
	name text,

	-- template
	created_at timestamp,
	updated_at timestamp,
	lock_version integer
);

CREATE TABLE common_column_metas (
	id serial primary key,
	table_meta_id integer references table_metas(id) on delete cascade,

	code text,
	name text,
	required boolean,
	uniqueness boolean,

	sort_order integer,	

	-- template
	created_at timestamp,
	updated_at timestamp,
	lock_version integer
);

CREATE TABLE integer_column_metas (
	id serial primary key,
	common_column_meta_id integer references common_column_metas(id) on delete cascade,

	min integer,
	max integer,

	-- template
	created_at timestamp,
	updated_at timestamp,
	lock_version integer
);

CREATE TABLE text_column_metas (
	id serial primary key,
	common_column_meta_id integer references common_column_metas(id) on delete cascade,
	
	min_length integer,
	max_length integer,
	text_pattern text,

	-- template
	created_at timestamp,
	updated_at timestamp,
	lock_version integer
);
