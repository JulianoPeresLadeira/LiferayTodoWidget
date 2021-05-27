create table Todo_Todo (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	done BOOLEAN,
	dueDate DATE null,
	user LONG
);