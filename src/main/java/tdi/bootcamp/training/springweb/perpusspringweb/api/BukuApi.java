package tdi.bootcamp.training.springweb.perpusspringweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Buku;
import tdi.bootcamp.training.springweb.perpusspringweb.service.BukuService;

import java.util.Optional;

@RestController
@RequestMapping("/api/buku")
public class BukuApi {

    @Autowired
    private BukuService service;

    @PostMapping("/save")
    public ResponseEntity<Buku> save(@RequestBody Buku buku) {
        buku = service.save(buku);
        return ResponseEntity.ok(buku);
    }

    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Buku> findById(@PathVariable("id") String id) {
        Optional<Buku> buku = service.findById(id);
        if (buku.isPresent()) {
            return ResponseEntity.ok(buku.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public Page<Buku> pagination(Pageable page) {
        return service.paginate(page);
    }

    @PutMapping("/save")
    public ResponseEntity<Buku> update(@RequestBody Buku buku) {
        buku = service.save(buku);
        return ResponseEntity.ok(buku);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.ok(String.format("id : %s berhasil dihapus", id));
    }

}
