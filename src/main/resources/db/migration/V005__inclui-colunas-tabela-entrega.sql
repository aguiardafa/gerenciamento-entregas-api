alter table entrega add destinatario_cidade varchar(255) not null;
alter table entrega add destinatario_uf varchar(2) not null;
alter table entrega add destinatario_cep varchar(8) not null;