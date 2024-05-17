package com.my.blog.api_myblog.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.blog.api_myblog.DTO.ProjectsDto;
import com.my.blog.api_myblog.Services.AddProjects.AddProjectServices;
import com.my.blog.api_myblog.Services.ListAllProjects.ListAllServices;
import com.my.blog.api_myblog.Services.delete.DeleteServices;

@CrossOrigin(origins= "*", allowedHeaders= "*")
@RestController
@RequestMapping("/api/projects")
public class ProjectsController {

    private final ListAllServices listAllServices;
    private final AddProjectServices addProjectServices;
    private final DeleteServices deleteServices;

    public ProjectsController(ListAllServices listAllServices, AddProjectServices addProjectServices, DeleteServices deleteServices) {
        this.listAllServices = listAllServices;
        this.addProjectServices = addProjectServices;
        this.deleteServices = deleteServices;
    }

    @GetMapping("/get/projects")
    public ResponseEntity<List<ProjectsDto>> getProjects() {
        List<ProjectsDto> projects = listAllServices.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/get/projects/lang/{languageName}")
    public ResponseEntity<List<ProjectsDto>> getProjectsLanguageName(@PathVariable String languageName) {
        List<ProjectsDto> projectsDtos = listAllServices.getProjectsByName(languageName);
        return ResponseEntity.ok(projectsDtos);
    }

    @GetMapping("/get/projects/framework/{frameworkName}")
    public ResponseEntity<List<ProjectsDto>> getProjectsFrameworkName(@PathVariable String frameworkName) {
        List<ProjectsDto> projectsDtos = listAllServices.getFrameworkByName(frameworkName);
        return ResponseEntity.ok(projectsDtos);
    }

    @GetMapping("/get/projects/type/{typeName}")
    public ResponseEntity<List<ProjectsDto>> getProjectsTypeProject(@PathVariable String typeName){
        List<ProjectsDto> projectsDtos = listAllServices.getProjectTypeProjects(typeName);
        return ResponseEntity.ok(projectsDtos);
    }

    @GetMapping("/get/projects/link-github/{linkName}")
    public ResponseEntity<List<ProjectsDto>> getProjectsLinkProject(@PathVariable String link){
        List<ProjectsDto> projectsDtos = listAllServices.getLinkProject(link);
        return ResponseEntity.ok(projectsDtos);
    }

    @PostMapping("/add/project")
    public ResponseEntity<String> addProject(@RequestBody ProjectsDto project) {
        String result = addProjectServices.addProject(project);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/project/{id}")
    public ResponseEntity<String> deleteFromProject(@PathVariable Long id){
        deleteServices.deleteProjectById(id);
        return ResponseEntity.ok().body("Project deleted successfully");
    }

}
