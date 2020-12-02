package com.cybertek.implementation;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplementation extends AbstractMapService<String, ProjectDTO> implements ProjectService {

    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(ProjectDTO obj) {
        super.delete(obj);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO project) {
        if (project.getProjectStatus()==null) {
            Status status = findById(project.getProjectCode()).getProjectStatus();
            project.setProjectStatus(status);
        }
        super.update(project.getProjectCode(), project);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(),project);
    }
}
