package m3.furama.service;

import m3.furama.repository.GenericRepository;
import m3.furama.util.paging.Page;
import m3.furama.util.paging.Pageable;

import java.util.List;

public class GenericService {
    private String entityName;

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Object> findAll() {
        return new GenericRepository(entityName).findAll();
    }

    public Page<Object> findAll(Pageable pageable) {
        return new GenericRepository(entityName).findAll(pageable);
    }

    public int save(Object obj) {
        return new GenericRepository(entityName).save(obj);
    }

    public List<Object> find(String q) {
        return null;
    }

    public int delete(int id) {
        return new GenericRepository(entityName).delete(id);
    }
}
