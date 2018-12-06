package tdi.bootcamp.training.springweb.perpusspringweb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.TransaksiDetail;

public interface TransaksiDetailsRepositoy extends PagingAndSortingRepository<TransaksiDetail,String> {
}
