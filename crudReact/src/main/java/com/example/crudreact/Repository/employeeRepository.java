package com.example.crudreact.Repository;

import com.example.crudreact.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeeRepository extends JpaRepository<Employee,Long> {
}
