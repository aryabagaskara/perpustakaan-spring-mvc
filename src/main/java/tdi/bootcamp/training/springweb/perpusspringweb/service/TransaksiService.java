package tdi.bootcamp.training.springweb.perpusspringweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Transaksi;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.TransaksiDetail;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.BukuRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.TransaksiDetailsRepositoy;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.TransaksiRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TransaksiService{

    @Autowired
    private TransaksiRepository repository;
    @Autowired
    private BukuRepository bukuRepository;
    @Autowired
    private TransaksiDetailsRepositoy transaksiDetailsRepositoy;


    @Transactional
    public Transaksi peminjaman(Transaksi transaksi) {
        List<TransaksiDetail> details = transaksi.getDetails();
        transaksi = repository.save(transaksi);
        for (TransaksiDetail detail : details) {
            detail.setTransaksi(transaksi);
            transaksiDetailsRepositoy.save(detail);
            bukuRepository.updateStockPeminjaman(detail.getBuku().getId(), 1);
        }
        return transaksi;
    }

    public Optional<Transaksi> findById(String id){
        return repository.findById(id);
    }


    @Transactional
    public Transaksi pengembalian(Transaksi transaksi){
        repository.pengembalianBuku(transaksi.getId(), Timestamp.valueOf(LocalDateTime.now()));
        for (TransaksiDetail detail : transaksi.getDetails()){
            bukuRepository.updateStockPengembalian(detail.getBuku().getId(),1);
        }
        return transaksi;
    }

    public Page<Transaksi> paginate(Pageable page){
        return repository.findAll(page);
    }

}
