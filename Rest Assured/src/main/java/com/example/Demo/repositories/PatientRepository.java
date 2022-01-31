package com.example.Demo.repositories;

import com.example.Demo.beans.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {     //bean class name and primary key is used has a parameter
}
