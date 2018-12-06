package tdi.bootcamp.training.springweb.perpusspringweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Transaksi;
import tdi.bootcamp.training.springweb.perpusspringweb.service.TransaksiService;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaksi")
public class TransaksiApi {

    @Autowired
    public TransaksiService service;

    @PostMapping("/peminjaman/buku")
    public ResponseEntity<?> transaksiPeminjamanBuku(@RequestBody Transaksi transaksi) {
        transaksi = service.peminjaman(transaksi);
        return ResponseEntity.ok(transaksi);
    }

    @GetMapping("/list")
    public Page<Transaksi> pagination(Pageable page){
        return service.paginate(page);
    }

    @PostMapping("/pengembalian/buku")
    public ResponseEntity<?> transaksiPengemblianBuku(@RequestParam("id")String id){
        Optional<Transaksi> transaksiOptional = service.findById(id);
        if(!transaksiOptional.isPresent()) return ResponseEntity.noContent().build();
        else {
            Transaksi transaksi = transaksiOptional.get();
            if (transaksi.isKembali()) return ResponseEntity.badRequest().body("returned");
            else {
                transaksi = service.pengembalian(transaksi);
                return ResponseEntity.ok(transaksi);
            }
        }
    }
}
