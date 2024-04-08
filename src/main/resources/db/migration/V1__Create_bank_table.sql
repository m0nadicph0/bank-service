CREATE TABLE banks
(
    id             varchar(75) PRIMARY KEY NOT NULL,
    org_id         varchar(75),
    legal_name     varchar(50),
    tin            varchar(75),
    lei            varchar(75),
    routing_number varchar(75),
    phone_number   varchar(75),
    email          varchar(320)
);