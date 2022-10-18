package uz.bakhromjon.springbootrediscache.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Bakhromjon Khasanboyev
 * @username: @xbakhromjon
 * @since : 18/10/22, Tue, 15:43
 **/
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
