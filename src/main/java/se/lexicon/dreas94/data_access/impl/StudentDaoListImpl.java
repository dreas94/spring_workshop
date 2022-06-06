package se.lexicon.dreas94.data_access.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao
{
    List<Student> storage;

    public StudentDaoListImpl()
    {
        this.storage = new ArrayList<>();
    }

    @Override
    public Student save(Student student)
    {
        if (student == null) throw new IllegalArgumentException("student is null");
        if(findById(student.getId()).isPresent()) throw new IllegalArgumentException("student id already exists");
        storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) throws DataNotFoundException
    {
        Optional<Student> result = findById(id);
        if (!result.isPresent()) throw new DataNotFoundException("Student not found");
        return result.get();
    }

    @Override
    public List<Student> findAll()
    {
        return new ArrayList<>(storage);
    }

    @Override
    public Student delete(int id) throws DataNotFoundException
    {
        Optional<Student> result = findById(id);
        if (!result.isPresent()) throw new DataNotFoundException("Student not found");
        else storage.remove(result.get());

        return result.get();
    }

    public Optional<Student> findById(Integer id)
    {
        if (id == null) throw new IllegalArgumentException("id is null");

        return storage.stream().filter(account -> account.getId() == id).findFirst();
    }
}
