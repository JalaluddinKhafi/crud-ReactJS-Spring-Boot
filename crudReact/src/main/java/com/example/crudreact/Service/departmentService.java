package com.example.crudreact.Service;

import com.example.crudreact.Model.Department;
import com.example.crudreact.Repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class departmentService {
    @Autowired
    departmentRepository repository;

    public Department saveDepartment(Department department){
        return repository.save(department);
    }
    public List<Department> allDepartment(){
        return repository.findAll();
    }
    public Department findDepartment(Long id){
        return repository.findById(id).get();
    }
    public void deleteDepartment(long id){
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
