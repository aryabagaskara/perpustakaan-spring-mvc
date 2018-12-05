package tdi.bootcamp.training.springweb.perpusspringweb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Anggota;
import tdi.bootcamp.training.springweb.perpusspringweb.repository.AnggotaRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AnggotaService {

    @Autowired
    private AnggotaRepository repository;

    @Transactional
    public Anggota save(Anggota anggota){
        return repository.save(anggota);
    }

    @Transactional
    public void delete (String id){
        return repository.deleteById(id);
    }

    @public Iterable<Anggota> list(){
        return repository.findAll();
    }

    public Optional<Anggota> findById(String id){
        return repository.findById(id);
    }

    public Page<Anggota> paginate(Pageable page){
        return repository.findAll(page);
    }
}
