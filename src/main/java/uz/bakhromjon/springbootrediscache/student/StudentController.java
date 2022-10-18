package uz.bakhromjon.springbootrediscache.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 18/10/22, Tue, 15:52
 **/
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;


    @PostMapping
    private Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping
    private Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @GetMapping("/{id}")
    private Student get(@PathVariable String id) {
        return service.get(id);
    }

    @GetMapping()
    private List<Student> list() {
        return service.list();
    }

    @DeleteMapping()
    private boolean delete(@RequestParam String id) {
        return service.delete(id);
    }

}
