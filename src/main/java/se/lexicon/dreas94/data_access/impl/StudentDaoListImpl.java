package se.lexicon.dreas94.data_access.impl;

import org.springframework.stereotype.Component;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.data_access.sequencer.StudentIdSequencer;
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
        student.setId(StudentIdSequencer.nextId());
        storage.add(student);
        return student;
    }

    @Override
    public Student find(int id) throws DataNotFoundException
    {
        return storage.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DataNotFoundException("Not Found", "Student"));
    }

    @Override
    public List<Student> findAll()
    {
        return new ArrayList<>(storage);
    }

    @Override
    public Student delete(int id) throws DataNotFoundException
    {
        Student student = find(id);
        Optional.ofNullable(student).ifPresent(storage::remove);

        return student;
    }

    public void clear(){
        storage.clear();
    }

}
