create table anggota
(
  id       character varying(64)  not null primary key,
nama     character varying(150) not null,
no_ktp character varying(150) not null,
alamat character varying(150) not null,
tanggal_lahir date not null
);
