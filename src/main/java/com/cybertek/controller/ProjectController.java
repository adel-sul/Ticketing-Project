package com.cybertek.controller;

import com.cybertek.dto.ProjectDTO;
import com.cybertek.service.ProjectService;
import com.cybertek.service.UserService;
import com.cybertek.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String projectCreate(Model model) {
        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());
        return "project/create";
    }

    @PostMapping("/create")
    public String projectSave(ProjectDTO project, Model model) {
        project.setProjectStatus(Status.OPEN);
        projectService.save(project);
        return "redirect:/project/create";
    }

    @GetMapping("/update/{projectcode}")
    public String userEdit(@PathVariable("projectcode") String code, Model model) {
        model.addAttribute("project", projectService.findById(code));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("managers", userService.findManagers());

        return "project/update";
    }

    @PostMapping("/update/{projectcode}")
    public String userUpdate(@PathVariable("projectcode") String code, ProjectDTO project, Model model) {
        projectService.update(project);
        return "redirect:/project/create";
    }

    @GetMapping("delete/{projectcode}")
    public String deleteUser(@PathVariable("projectcode") String code) {
        projectService.deleteById(code);
        return "redirect:/project/create";
    }

    @GetMapping("complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String code) {
        projectService.complete(projectService.findById(code));
        return "redirect:/project/create";
    }
}
