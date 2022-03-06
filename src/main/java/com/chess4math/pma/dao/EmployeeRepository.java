package com.chess4math.pma.dao;

import com.chess4math.pma.entities.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//<Employee is the entity type && Long is the primary key unique identifier type...see the Employee class
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    List<Employee> findAll();
}
