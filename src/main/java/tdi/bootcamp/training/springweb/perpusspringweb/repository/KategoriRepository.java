package tdi.bootcamp.training.springweb.perpusspringweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Kategori;

public interface KategoriRepository extends PagingAndSortingRepository<Kategori,String> {
}
