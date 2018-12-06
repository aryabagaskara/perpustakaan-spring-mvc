package tdi.bootcamp.training.springweb.perpusspringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Buku;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.BukuRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BukuService {

    @Autowired
    private BukuRepository repository;

    @Transactional
    public Buku save (Buku buku){
        return repository.save(buku);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Buku> list(){
        return repository.findAll();
    }

    public Optional<Buku> findById(String id){
        return repository.findById(id);
    }

    public Page<Buku> paginate(Pageable page){
        return repository.findAll(page);
    }


}
