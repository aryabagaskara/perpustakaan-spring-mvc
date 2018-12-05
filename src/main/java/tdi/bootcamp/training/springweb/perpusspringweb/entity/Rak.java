package tdi.bootcamp.training.springweb.perpusspringweb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rak")
public class Rak {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    private String id;


    @Column(name = "nama", nullable = false)
    private String nama;


    @Column(name = "lokasi", nullable = false)
    private Integer lokasi;
}