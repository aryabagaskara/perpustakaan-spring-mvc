package tdi.bootcamp.training.springweb.perpusspringweb.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdi.bootcamp.training.springweb.perpusspringweb.entity.Buku;

public interface BukuRepository extends PagingAndSortingRepository<Buku,String> {

    @Modifying
    @Query("update from Buku set qty = qty - ?2 where id = ?1")
    int updateStockPeminjaman(String id, Integer stok);

    @Query("update from Buku set qty = qty + ?2 where id = ?1")
    @Modifying
    int updateStockPengembalian(String id, Integer stok);
}
