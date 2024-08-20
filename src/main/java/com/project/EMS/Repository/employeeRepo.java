package com.project.EMS.Repository;

import org.springframework.data.repository.CrudRepository;

import com.project.EMS.Model.employee;


public interface employeeRepo extends CrudRepository<employee,Integer> {

    
} 
