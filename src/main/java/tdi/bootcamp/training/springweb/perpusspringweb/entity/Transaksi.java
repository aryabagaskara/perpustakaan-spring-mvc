package tdi.bootcamp.training.springweb.perpusspringweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaksi")
public class Transaksi {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "tanggal_transaksi", nullable = false)
    private Date tanggal;

    @ManyToOne
    @JoinColumn(name = "anggota_id", nullable = false)
    private Anggota anggota;

    @Column(name = "tanggal_buat", nullable = false)
    private Timestamp createdDate;

    @Column(name = "nama_petugas", nullable = false)
    private String petugas;

    @Column(name = "is_available", nullable = false)
    private boolean kembali;

    @Column(name = "tanggal_kembali")
    private Timestamp tanggalKembali;

    @OneToMany(mappedBy = "transaksi")
    private List<TransaksiDetail> details = new ArrayList<>();
}