package com.restexample.restdemo.entities;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;
    @NotNull
    private String projectDesc;
    @NotNull
    private Date startDate;
    @NotNull
    private String projectHead;
    public Project() {
    }
    public Project(int projectId, String projectDesc, Date startDate, String projectHead) {
        this.projectId = projectId;
        this.projectDesc = projectDesc;
        this.startDate = startDate;
        this.projectHead = projectHead;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProjectHead() {
        return projectHead;
    }

    public void setProjectHead(String projectHead) {
        this.projectHead = projectHead;
    }



}
