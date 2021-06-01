package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.test.model.Engineer;

//@RepositoryRestResource
@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {

}
