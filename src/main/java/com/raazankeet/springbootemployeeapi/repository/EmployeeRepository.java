package com.raazankeet.springbootemployeeapi.repository;

import com.raazankeet.springbootemployeeapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    List<Employee> findAllByOrderByLastNameAsc();

}
