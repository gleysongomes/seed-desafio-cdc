create table autor
(
    id bigint not null,
    nome character varying(100) not null,
    email character varying(256) not null,
    descricao character varying(400) not null,
    data_cricao timestamp with time zone not null,
    codigo character varying(36) not null
);

alter table autor add constraint pk_autor_id primary key (id);
alter table autor add constraint uk_autor_email unique (email);
