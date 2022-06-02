package se.lexicon.dreas94.data_access.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.data_access.sequencer.StudentIdGenerator;
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
        if (student == null) throw new IllegalArgumentException("account is null");
        student.setId(StudentIdGenerator.generateAccountNumber());
        storage.add(student);
        return student;
    }

    @Override
    public Optional<Student> find(Long id)
    {
        if (id == null) throw new IllegalArgumentException("id is null");

        return storage.stream().filter(account -> account.getId() == id).findFirst();
    }

    @Override
    public List<Student> findAll()
    {
        return null;
    }

    @Override
    public void delete(long id) throws DataNotFoundException
    {
        Optional<Student> result = find(id);
        if (!result.isPresent()) throw new DataNotFoundException("Student not found");
        else storage.remove(result.get());
    }
}
