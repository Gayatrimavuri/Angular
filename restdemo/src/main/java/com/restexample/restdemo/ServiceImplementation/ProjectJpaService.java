package com.restexample.restdemo.ServiceImplementation;

import com.restexample.restdemo.Services.IProject;
import com.restexample.restdemo.entities.Project;
import com.restexample.restdemo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectJpaService implements IProject
{
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public List<Project> findAll() {
      Iterable<Project> I = projectRepository.findAll();
      List<Project> list =new ArrayList<Project>();
      I.forEach(list::add);
      return list;
    }

    @Override
    public Project findByProjectId(int id) {
      Optional<Project> o= projectRepository.findById(id);
      if(o.isPresent())
            return o.get();
      else
          return null;
    }

    @Override
    public String addProject(Project P) {
     try{
         projectRepository.save(P);
         return "1 row inserted";
     }
     catch(Exception e)
     {
         return e.getMessage();
     }

    }

    @Override
    public String updateProject(Project P, int id) {
       Optional<Project> O=projectRepository.findById(id);
    if(O.isPresent())
    {
        O.get().setProjectDesc(P.getProjectDesc());
        O.get().setProjectHead(P.getProjectHead());
        O.get().setStartDate(P.getStartDate());
        projectRepository.save(O.get());
        return " 1 row updated";
    }
    else
    {
        return "No row exists";
    }

    }

    @Override
    public String deleteProject(int id) {
        Optional<Project> O=projectRepository.findById(id);
        if(O.isPresent())
        {
            projectRepository.delete(O.get());
            return " 1 row deleted";
        }
        else
        {
            return "No row exists";
        }

    }
}
