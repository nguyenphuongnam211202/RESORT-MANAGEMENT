package m3.furama.service;

import m3.furama.util.paging.Page;
import m3.furama.util.paging.Pageable;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    Page<T> findAll(Pageable pageable);
    int save(T t);
    List<T> find(String q);
    int delete(int id);
}
