package tdi.bootcamp.training.springweb.perpusspringweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaksi {
    private String id;
    private Date tanggal;
    private Timestamp createdDate;
    private String petugas;
    private boolean kembali;
}