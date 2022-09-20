package com.restexample.restdemo.ServiceImplementation;

import com.restexample.restdemo.Services.IProject;
import com.restexample.restdemo.entities.Project;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectService  implements IProject {

   static  List<Project> LP = new ArrayList<Project>();
   static {
       try {
           SimpleDateFormat F = new SimpleDateFormat("MM/dd/yyyy");
           LP.add(new Project(1, "HMS", F.parse("01/02/2021"), "Pradeep"));
           LP.add(new Project(2, "BMS", F.parse("01/06/2021"), "Ankitha"));
           LP.add(new Project(3, "MMS", F.parse("01/07/2021"), "Yousof"));
           LP.add(new Project(4, "LMS", F.parse("01/09/2021"), "Pavan"));
        }
       catch (ParseException E) {
       }
   }
    @Override
        public List<Project> findAll() {
             return LP;
            }
    @Override
    public Project findByProjectId(int id) {
       Project P=null;
       for(int i=0;i<LP.size();i++)
        {
            if(LP.get(i).getProjectId()==id)
                P=LP.get(i);
        }
       return P;
    }
    public String addProject(Project P)
    {
        LP.add(P);
        return  " 1 object added";
    }
    public String updateProject(Project P,int id)
    {
    for(int i=0;i<LP.size();i++)
    {
        if(LP.get(i).getProjectId()==id)
        {
            LP.get(i).setProjectDesc(P.getProjectDesc());
            LP.get(i).setProjectHead(P.getProjectHead());
            LP.get(i).setStartDate(P.getStartDate());
        }

    }
    return "1 Row updated";
    }

    public String deleteProject(int id) {
        for (int i = 0; i < LP.size(); i++) {
            if (LP.get(i).getProjectId() == id)
                LP.remove(LP.get(i));
        }
        return "1 Row deleted";
    }

}