package tdi.bootcamp.training.springweb.perpusspringweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anggota")
public class Anggota {

    @Id
    @GenericGenerator(name = "gen_ui",strategy = "uuid2")
    @GeneratedValue(generator = "gen_ui")
    @Column(name = "id")
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "noKtp", nullable = false)
    private String noKtp;

    @Column(name = "alamat", nullable = false)
    private String alamat;

    @Column(name = "tanggal_lahir", nullable = false)
    private Date tanggalLahir;
}