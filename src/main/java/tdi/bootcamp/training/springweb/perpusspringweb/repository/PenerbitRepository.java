package tdi.bootcamp.training.springweb.perpusspringweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Penerbit;

public interface PenerbitRepository extends PagingAndSortingRepository<Penerbit, String> {
}
