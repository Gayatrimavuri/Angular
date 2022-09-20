package com.restexample.restdemo.Services;

import com.restexample.restdemo.entities.Project;

import java.util.List;

public interface IProject {
    public List<Project> findAll();
    public Project findByProjectId(int id);
    public String addProject(Project P);
    public String updateProject(Project P,int id);
    public String deleteProject(int id);

}
