package uz.bakhromjon.springbootrediscache.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 18/10/22, Tue, 15:43
 **/
@Service
public class StudentService {


    @Autowired
    private StudentRepository repository;

    @PostConstruct
    public void init() {
        Student s1 = new Student("1", "name1", Student.Gender.MALE, 1);
        Student s2 = new Student("2", "name2", Student.Gender.MALE, 1);
        Student s3 = new Student("3", "name3", Student.Gender.MALE, 1);
        repository.saveAll(List.of(s1, s2, s3));
    }

    public Student create(Student student) {
        Student saved = repository.save(student);
        return saved;
    }

    public Student update(Student student) {
        Student updated = repository.save(student);
        return updated;
    }

    public Student get(String id) {
        Optional<Student> optional =
                repository.findById(id);
        return optional.orElseThrow(() -> {
            throw new RuntimeException("Student not found");
        });
    }

    public List<Student> list() {
        Iterable<Student> all = repository.findAll();
        List<Student> students = toList(all);
        return students;
    }


    public boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }

    public <T> List<T> toList(Iterable<T> iterable) {
        List<T> res = new ArrayList<>();
        for (T t : iterable) {
            res.add(t);
        }
        return res;
    }
}
