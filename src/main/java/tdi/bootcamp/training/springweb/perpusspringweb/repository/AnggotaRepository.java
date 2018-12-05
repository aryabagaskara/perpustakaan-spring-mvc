package tdi.bootcamp.training.springweb.perpusspringweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Anggota;

public interface AnggotaRepository extends PagingAndSortingRepository<Anggota,String> {
}
