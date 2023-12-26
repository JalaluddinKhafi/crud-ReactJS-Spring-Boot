package com.example.crudreact.Service;

import com.example.crudreact.Model.Employee;
import com.example.crudreact.Repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    employeeRepository repository;

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }
    public List<Employee> allEmployees(){
        return repository.findAll();
    }
    public Employee findEmployee(Long id){
        return repository.findById(id).get();
    }
    public void deleteEmployee(long id){
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
