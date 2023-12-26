package com.example.crudreact.Repository;

import com.example.crudreact.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<Department,Long> {
}
