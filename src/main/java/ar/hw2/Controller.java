package ar.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private StudentRepository repository;

    @Autowired
    public Controller(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("student")
    public List<Student> getAll(){
        return repository.getAll();
    }

    @GetMapping("student/{id}")
    public Student getById(@PathVariable long id){
        return repository.getById(id);
    }

    @GetMapping("student/search")
    public List getByName(@RequestParam String name){
        return repository.getByName(name);
    }

    @GetMapping("group/{groupName}/student")
    public List getByGroupName(@PathVariable String groupName){
        return repository.getByGroupName(groupName);
    }
}
