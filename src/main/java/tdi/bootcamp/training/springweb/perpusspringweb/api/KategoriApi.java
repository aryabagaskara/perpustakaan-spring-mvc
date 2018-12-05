package tdi.bootcamp.training.springweb.perpusspringweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Kategori;
import tdi.bootcamp.training.springweb.perpusspringweb.service.KategoriService;

import java.util.Optional;


@RestController
@RequestMapping("/api/kategori")
public class KategoriApi {

    @Autowired
    private KategoriService service;

    @GetMapping("/list")
    public Page<Kategori> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Kategori> findById(@PathVariable("id") String id){
        Optional<Kategori> kategoriOption = service.findById(id);
        if(kategoriOption.isPresent())
            return ResponseEntity.ok(kategoriOption.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Kategori> save(
            @RequestParam String nama,
            @RequestParam(required = false)String id){
        Kategori kategori = service.save(new Kategori(nama,id));
        return ResponseEntity.ok(kategori);
    }

    @PutMapping("/save")
    public ResponseEntity<Kategori> update(@RequestBody Kategori value){
        Kategori kategori = service.save(value);
        return ResponseEntity.ok(kategori);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("kategoriId") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }



}
