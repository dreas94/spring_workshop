package se.lexicon.dreas94.data_access.dao;

import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;

import java.util.List;

public interface StudentDao
{
    Student save(Student student);

    Student find(long id) throws DataNotFoundException;

    List<Student> findAll();

    void delete(long id) throws DataNotFoundException;
}