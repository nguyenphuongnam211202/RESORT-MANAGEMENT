package m3.furama.service;

import m3.furama.model.CustomerType;
import m3.furama.repository.CustomerTypeRepository;
import m3.furama.util.paging.Page;
import m3.furama.util.paging.Pageable;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService{
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public int save(CustomerType customerType) {
        return 0;
    }

    @Override
    public List<CustomerType> find(String q) {
        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
