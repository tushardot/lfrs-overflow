create table panasonic_support (
	spportId LONG not null primary key,
	claim VARCHAR(75) null,
	query VARCHAR(75) null,
	suggestioncomplaint VARCHAR(75) null,
	BU VARCHAR(75) null,
	channel VARCHAR(75) null,
	invoiceNumber LONG,
	invoiceDate DATE null,
	itemValueInvoice LONG,
	itemValueYou LONG,
	claimValue LONG,
	detailClaim VARCHAR(75) null,
	querybox VARCHAR(75) null,
	scBox VARCHAR(75) null
);