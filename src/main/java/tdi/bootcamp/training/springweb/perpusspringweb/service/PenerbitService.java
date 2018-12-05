package tdi.bootcamp.training.springweb.perpusspringweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Penerbit;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.PenerbitRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PenerbitService {

    @Autowired
    private PenerbitRepository repository;

    @Transactional
    public Penerbit save(Penerbit penerbit){
        return repository.save(penerbit);
    }

    @Transactional
    public void delete(String id){
        repository.deleteById(id);
    }

    public Iterable<Penerbit> list(){
        return repository.findAll();
    }

    public Optional<Penerbit> findById(String id){
        return repository.findById(id);
    }

    public Page<Penerbit> paginate(Pageable page){
        return repository.findAll(page);
    }


}
