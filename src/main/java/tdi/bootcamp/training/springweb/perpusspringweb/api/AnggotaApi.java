package tdi.bootcamp.training.springweb.perpusspringweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Anggota;
import tdi.bootcamp.training.springweb.perpusspringweb.service.AnggotaService;

import java.sql.Date;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaService service;

    @GetMapping("/list")
    public Page<Anggota> pagination(Pageable page){
        return service.paginate(page);
    }

    @PostMapping("/save")
    public ResponseEntity<Anggota> save(
            @RequestParam(required = false) String id,
            @RequestParam String nama,
            @RequestParam String noKtp,
            @RequestParam String alamat,
            @RequestParam Date tanggalLahir
            ){
        Anggota anggota = service.save(new Anggota(id,nama,noKtp,alamat,tanggalLahir));
        return ResponseEntity.ok(Anggota);
    }

    @PutMapping("/save")
    public ResponseEntity<Anggota> save(
            @RequestBody Anggota value){
        Anggota anggota = service.save(value);
        return ResponseEntity.ok(anggota);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete (@RequestParam("anggotaId") String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
