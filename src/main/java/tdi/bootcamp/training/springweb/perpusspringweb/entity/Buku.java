package tdi.bootcamp.training.springweb.perpusspringweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buku")
@ToString(exclude = "daftarKategori")
public class Buku {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false)
    private String id;


    @Column(name = "nama", nullable = false)
    private String nama;


    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "qty", nullable = false)
    private Integer qty;


    @Column(name = "tanggal_publish", nullable = false)
    private Date tanggalPublish;

    @ManyToOne
    @JoinColumn(name = "penerbit_id", nullable = false)
    private Penerbit penerbit;

    @ManyToOne
    @JoinColumn(name = "rak_id", nullable = false)
    private Rak rak;


    @OneToMany
    @JoinTable(
            name = "kategori_buku",
            joinColumns = @JoinColumn(name = "buku_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "kategori_id", nullable = false)
    )
    private List<Kategori> daftarKategori = new ArrayList<>();
}