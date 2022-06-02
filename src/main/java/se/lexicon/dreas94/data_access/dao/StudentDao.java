package se.lexicon.dreas94.data_access.dao;

import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao
{
    Student save(Student student);

    Optional<Student> find(Long id);

    List<Student> findAll();

    void delete(long id) throws DataNotFoundException;
}
