create table Liferay_channel (
	uuid_ VARCHAR(75) null,
	userName VARCHAR(75) not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	password_ VARCHAR(75) null,
	otp VARCHAR(75) null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);