package se.lexicon.dreas94.service.interfaces;

import se.lexicon.dreas94.models.Student;

import java.util.List;

public interface StudentManagment
{
    Student create();
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);
}
