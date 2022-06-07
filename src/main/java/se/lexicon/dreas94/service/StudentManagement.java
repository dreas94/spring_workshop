package se.lexicon.dreas94.service;

import se.lexicon.dreas94.models.Student;

import java.util.List;

public interface StudentManagement
{
    Student create();
    Student save(Student student);
    Student find(int id);
    Student remove(int id);
    List<Student> findAll();
    Student edit(Student student);
}
