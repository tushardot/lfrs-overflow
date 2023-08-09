create index IX_65B8BE7E on queries_answer (quesId);
create index IX_56B742E7 on queries_answer (userName[$COLUMN_LENGTH:75$]);
create index IX_4AAFB257 on queries_answer (uuid_[$COLUMN_LENGTH:75$]);

create index IX_E695C8CF on queries_question (userName[$COLUMN_LENGTH:75$]);
create index IX_B3C9356F on queries_question (uuid_[$COLUMN_LENGTH:75$]);