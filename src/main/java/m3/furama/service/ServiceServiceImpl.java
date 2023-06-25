package m3.furama.service;

import m3.furama.model.Service;
import m3.furama.repository.ServiceRepository;
import m3.furama.util.paging.Page;
import m3.furama.util.paging.Pageable;

import java.util.List;

public class ServiceServiceImpl implements ServiceService{
    private ServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public int save(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> find(String q) {
        return null;
    }

    @Override
    public int delete(int id) {
        return serviceRepository.delete(id, "service");
    }
}
