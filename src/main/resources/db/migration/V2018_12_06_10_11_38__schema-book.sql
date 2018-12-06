create table buku
(
  id       character varying(64)  not null primary key,
nama     character varying(150) not null,
isbn character varying(150) not null,
qty integer not null default 0,
tanggal_lahir date not null default now(),
penerbit_id character varying(64) not null,
rak_id character varying(64)
);


alter table buku add constraint fk_penerbit_buku foreign key (penerbit_id)
references penerbit(id) ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE buku
ADD CONSTRAINT fk_rak_buku FOREIGN KEY (rak_id)
REFERENCES rak(id) on update CASCADE ON DELETE RESTRICT;

create TABLE kategori_buku(
  buku_id character varying(64) not null,
  kategori_id character VARYING(64) NOT NULL
);

alter TABLE kategori_buku
add constraint fk_kategori_buku_id FOREIGN KEY (buku_id)
REFERENCES buku(id) on UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE kategori_buku
add constraint fk_kategori_buku_kategori_id foreign key (kategori_id)
references kategori(id) on update cascade on delete cascade;

alter table kategori_buku
add constraint uq_kategori_buku unique (buku_id,kategori_id);