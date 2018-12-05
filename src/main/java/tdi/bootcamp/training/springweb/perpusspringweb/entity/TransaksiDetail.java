package tdi.bootcamp.training.springweb.perpusspringweb.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiDetail {
    private String id;
    private Transaksi transaksi;
    private Book book;

}