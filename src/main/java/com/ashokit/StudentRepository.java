package com.ashokit;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Serializable> {

}
