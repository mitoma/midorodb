CREATE TABLE tables (
	id serial primary key,

	code text,
	label text,
	description text,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);

CREATE TABLE rows (
	id serial primary key,
	table_id integer,

	value jsonb,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);

CREATE TABLE table_metas (
	id serial primary key,
	code text not null,
	label text not null,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);

CREATE TABLE common_column_metas (
	id serial primary key,
	table_meta_id integer not null references table_metas(id) on delete cascade,

	code text not null,
	label text not null,
	sort_order integer not null,

	
	-- required boolean not null,
	-- uniqueness boolean not null,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);

CREATE TABLE integer_column_metas (
	id serial primary key,
	common_column_meta_id integer references common_column_metas(id) on delete cascade,

	min integer not null,
	max integer not null,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);

CREATE TABLE text_column_metas (
	id serial primary key,
	common_column_meta_id integer not null references common_column_metas(id) on delete cascade,
	
	min_length integer not null,
	max_length integer not null,
	text_pattern text not null,

	-- template
	created_at timestamp not null,
	updated_at timestamp not null,
	lock_version integer not null
);
