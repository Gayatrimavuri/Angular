package com.restexample.restdemo.controller;

import com.restexample.restdemo.Services.IProject;
import com.restexample.restdemo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProjectController
{
    @Autowired
    IProject projectJpaService;

    @GetMapping("/Project")
    public List<Project> getProjects()
    {
        List<Project> L=projectJpaService.findAll();
        return L;
    }
    @GetMapping("/Project/{projectId}")
    public Project getProject(@PathVariable String projectId)
    {
       Project P=projectJpaService.findByProjectId(Integer.parseInt(projectId));
       return P;
    }
    @PostMapping("/Project")
    public String addProject(@RequestBody Project P)
    {
        return projectJpaService.addProject(P);
    }
@PutMapping("/Project/{projectId}")
public String updateProject(@RequestBody Project newProject,@PathVariable String projectId)
{
    return projectJpaService.updateProject(newProject,Integer.parseInt(projectId));

}
@DeleteMapping("/Project/{projectId}")
public String deleteProject(@PathVariable String projectId)
{
    return  projectJpaService.deleteProject(Integer.parseInt(projectId));
}

}
