package tdi.bootcamp.training.springweb.perpusspringweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Penerbit;
import tdi.bootcamp.training.springweb.perpusspringweb.service.PenerbitService;

import java.util.Optional;

@RestController
@RequestMapping("/api/penerbit")
public class PenerbitApi {

    @Autowired
    private PenerbitService service;

    @GetMapping("/list")
    public Page<Penerbit> pagination(Pageable page){
        return service.paginate(page);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Penerbit> findById(@PathVariable("id") String id){
        Optional<Penerbit> penerbitOption = service.findById(id);
        if(penerbitOption.isPresent())
            return ResponseEntity.ok(penerbitOption.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Penerbit> save(
            @RequestParam String nama,
            @RequestParam String alamat,
            @RequestParam(required = false)String id){
        Penerbit penerbit = service.save(new Penerbit(id,nama,alamat));
        return ResponseEntity.ok(penerbit);
    }


    @PutMapping("/save")
    public ResponseEntity<Penerbit> update(@RequestBody Penerbit value){
        Penerbit penerbit = service.save(value);
        return ResponseEntity.ok(penerbit);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("penerbitId") String id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }


}
