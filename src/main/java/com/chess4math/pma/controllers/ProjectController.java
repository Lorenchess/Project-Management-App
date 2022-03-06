package com.chess4math.pma.controllers;

import com.chess4math.pma.dao.ProjectRepository;
import com.chess4math.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository proRepo; //Using composition to have access to the method find all defined in the interface

    @GetMapping     //@GetMapping handles the requests of @RequestMapping
    public String displayProjects (Model model) {
       List<Project> projects = proRepo.findAll();
       model.addAttribute("projectsList",projects);
       return "projects/list-projects"; //returns the hmtl page
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        model.addAttribute("project", aProject);
       return "/projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        //saving to the database...
        proRepo.save(project);

        //we prevent duplicate submissions by redirecting...
        return "redirect:/projects/new";
    }
}
