package com.nrmj.controllers;

import com.nrmj.models.Task;
import com.nrmj.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping({"/tasks"})
public class TasksController {
    private TaskRepository repo;

    @Autowired
    public void setRepo(TaskRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Task> index(){
        PageRequest pr = new PageRequest(0, 3);
        return repo.findAll(pr);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Task show(@PathVariable int id){
        Task t = repo.findOne(id);
        return t;
    }

    @RequestMapping(path = {"","/"}, method = RequestMethod.POST)
    public Task create(@RequestBody Task task){
        return repo.save(task);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id){
        repo.delete(id);
    }

    @RequestMapping(path = "/{id}/complete", method = RequestMethod.PATCH)
    public Task complete(@PathVariable int id){
        Task t = repo.findOne(id);
        t.setComplete(!t.getComplete());
        return repo.save(t);
    }
}
