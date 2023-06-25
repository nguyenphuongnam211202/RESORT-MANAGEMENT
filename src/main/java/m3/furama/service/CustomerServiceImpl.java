//package m3.furama.service;
//
//import m3.furama.model.Customer;
//import m3.furama.repository.CustomerRepository;
//import m3.furama.util.paging.Page;
//import m3.furama.util.paging.Pageable;
//
//import java.util.List;
//
//public class CustomerServiceImpl implements CustomerService {
//    private CustomerRepository customerRepository = new CustomerRepository();
//
//    @Override
//    public List<Customer> findAll() {
//       return customerRepository.findAll();
//    }
//
//    @Override
//    public int save(Customer customer) {
//        return customerRepository.save(customer);
//    }
//
//    @Override
//    public List<Customer> find(String q) {
//        return null;
//    }
//
//    @Override
//    public int delete(int id) {
//        return customerRepository.delete(id, "customer");
//    }
//
//    @Override
//    public Page<Customer> findAll(Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }
//}
