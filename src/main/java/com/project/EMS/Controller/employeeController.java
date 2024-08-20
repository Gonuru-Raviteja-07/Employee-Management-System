package com.project.EMS.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.EMS.Model.employee;
import com.project.EMS.Repository.employeeRepo;

@RestController
@RequestMapping("/api")
public class employeeController {
  @Autowired
  employeeRepo empRepo;

  // Add "NEW" employee details
  @PostMapping("/save")
  public ResponseEntity<employee> saveEmployeeDetails(@RequestBody employee Employee) {
    return new ResponseEntity<>(empRepo.save(Employee), HttpStatus.CREATED);
  }

  // Get employee details by "ID"
  @GetMapping("/employee/{id}")
  public ResponseEntity<employee> getEmployeeDetailsById(@PathVariable int id) {
    Optional<employee> Employee = empRepo.findById(id);
    if (Employee.isPresent()) {
      return new ResponseEntity<>(Employee.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  // Get "All" employees details
  @GetMapping("/employees")
  public Iterable<employee> getAllEmployeeDetails() {
    return empRepo.findAll();
  }

  // Delete employee details by ID
  @DeleteMapping("/delete/employee/{id}")
  public ResponseEntity<employee> deleteEmployeeDetailsById(@PathVariable int id) {
    empRepo.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
  @DeleteMapping("/delete/all/employees")
  public ResponseEntity<employee> deleteAllEmployeeDetailsById() {
    empRepo.deleteAll();
    return new ResponseEntity<>(HttpStatus.OK);
  }


  // "Modify" the existing employee details
  @PutMapping("/modify/employee/{id}")
  public ResponseEntity<employee> modifyEmployeeDetailsById(@PathVariable int id, @RequestBody employee emp) {
    Optional<employee> Employee = empRepo.findById(id);
    if (Employee.isPresent()) {
      Employee.get().setEmployeeName(emp.getEmployeeName());
      Employee.get().setEmployeeEmail(emp.getEmployeeEmail());
      Employee.get().setEmployeeDepartment(emp.getEmployeeDepartment());
      Employee.get().setEmployeeLocation(emp.getEmployeeLocation());
      return new ResponseEntity<>(empRepo.save(Employee.get()), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
