package com.example.crudreact.Controller;

import com.example.crudreact.Model.Department;
import com.example.crudreact.Service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class departmentController {

    @Autowired
    private departmentService departmentService;

    @GetMapping
    public List<Department> getAllEmployees() {
        return departmentService.allDepartment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = Optional.ofNullable(departmentService.findDepartment(id));
        return department.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department savedDepartment = departmentService.saveDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department updatedDepartment) {
        Optional<Department> existingDepartment = Optional.ofNullable(departmentService.findDepartment(id));

        if (existingDepartment.isPresent()) {
            updatedDepartment.setId(id);
            Department savedDepartment = departmentService.saveDepartment(updatedDepartment);
            return ResponseEntity.ok(savedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (departmentService.existsById(id)) {
            departmentService.deleteDepartment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
