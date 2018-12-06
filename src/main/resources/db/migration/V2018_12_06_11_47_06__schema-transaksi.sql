create table transaksi
(
  id       character varying(64)  not null primary key,
tanggal_transaksi     date not null default now(),
tanggal_buat timestamp not null default now(),
nama_petugas character varying(100),
is_available boolean not null default true
);
