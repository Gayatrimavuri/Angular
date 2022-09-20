package com.restexample.restdemo.repositories;

import com.restexample.restdemo.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
