create table queries_answer (
	uuid_ VARCHAR(75) null,
	ansId LONG not null primary key,
	ansTitle VARCHAR(75) null,
	ansDesc VARCHAR(75) null,
	userName VARCHAR(75) null,
	quesId LONG,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table queries_question (
	uuid_ VARCHAR(75) null,
	quesId LONG not null primary key,
	quesTitle VARCHAR(75) null,
	quesDesc VARCHAR(75) null,
	userName VARCHAR(75) null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);