package com.example.springbootapi.controller;

import com.example.springbootapi.model.Employee;
import com.example.springbootapi.repository.EmployeeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        return ResponseEntity.ok(employeeRepository.findAll());
    }

//    @GetMapping("/employees/{id}")
//    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable(value = "id") Integer employeeId) {
//        Optional<Employee> employees = employeeRepository.findById(employeeId);
//        return ResponseEntity.ok().body(employee);
//
//    }

//    @GetMapping("/employees/{id}")
//    public Employee getEmployeeById(@PathVariable(value = "id") Integer employeeId)
//    {
//        Optional<Employee> employee = employeeRepository.findById(employeeId);
//                //.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        //return ResponseEntity.ok().body(employee);
//        return employee.isPresent() ? employee.get() : null;
//    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
//                                                   @RequestBody Employee employeeDetails) {
//        Employee employee = employeeRepository.findById(employeeId);
//               .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
////        employee.setName(employeeDetails.getName());
////        employee.setEmail(employeeDetails.getEmail());
////        employee.setPhone(employeeDetails.getPhone());
////        employee.setDepartment(employeeDetails.getDepartment());
//
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }
//
//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId)
//            {
//        Employee employee = employeeRepository.findById(employeeId);
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
}

