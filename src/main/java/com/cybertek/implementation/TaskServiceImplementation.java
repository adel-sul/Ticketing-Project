package com.cybertek.implementation;

import com.cybertek.dto.TaskDTO;
import com.cybertek.service.TaskService;
import com.cybertek.utils.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImplementation extends AbstractMapService<Long, TaskDTO> implements TaskService {

    @Override
    public TaskDTO save(TaskDTO task) {
        return super.save(task.getId(), task);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(TaskDTO task) {
        super.delete(task);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void update(TaskDTO task) {
        if (task.getAssignedDate()==null) {
            LocalDate date = findById(task.getId()).getAssignedDate();
            task.setAssignedDate(date);
        }
        if (task.getTaskStatus()==null) {
            Status status = findById(task.getId()).getTaskStatus();
            task.setTaskStatus(status);
        }
        super.update(task.getId(), task);
    }
}
