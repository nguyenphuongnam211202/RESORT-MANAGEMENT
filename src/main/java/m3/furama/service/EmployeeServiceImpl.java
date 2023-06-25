//package m3.furama.service;
//
//import m3.furama.model.Employee;
//import m3.furama.repository.EmployeeRepository;
//import m3.furama.util.paging.Page;
//import m3.furama.util.paging.Pageable;
//
//import java.util.List;
//
//public class EmployeeServiceImpl implements EmployeeService{
//    private EmployeeRepository employeeRepository = new EmployeeRepository();
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Page<Employee> findAll(Pageable pageable) {
//        return employeeRepository.findAll(pageable);
//    }
//
//    @Override
//    public int save(Employee employee) {
//        return 0;
//    }
//
//    @Override
//    public List<Employee> find(String q) {
//        return null;
//    }
//
//    @Override
//    public int delete(int id) {
//        return 0;
//    }
//}
