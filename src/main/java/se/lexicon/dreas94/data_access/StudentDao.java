package se.lexicon.dreas94.data_access;

import se.lexicon.dreas94.data_access.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;
import java.util.List;

public interface StudentDao
{
    Student save(Student student);
    Student find(long id) throws DataNotFoundException;
    List<Student> findAll();
    void delete(long id) throws DataNotFoundException;
}
