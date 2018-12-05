package tdi.bootcamp.training.springweb.perpusspringweb.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Rak;
import tdi.bootcamp.training.springweb.perpusspringweb.service.RakService;

@RestController
@RequestMapping("/api/rak")
public class RakApi {

    @Autowired
    private RakService service;

    @GetMapping("/list")
    public Page<Rak> pagination(Pageable page){
        return service.paginate(page);
    }

    @PostMapping("/save")
    public ResponseEntity<Rak> save(
            @RequestParam String nama,
            @RequestParam String alamat,
            @RequestParam(required = false)String id,
            @RequestParam String lokasi){
        Rak rak = service.save(new Rak(id,nama,lokasi));
        return ResponseEntity.ok(rak);
    }

    @PutMapping("/save")
    public ResponseEntity<Rak> update(@RequestBody Rak value){
        Rak rak = service.save(value);
        return ResponseEntity.ok(value);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("rakId")String id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
