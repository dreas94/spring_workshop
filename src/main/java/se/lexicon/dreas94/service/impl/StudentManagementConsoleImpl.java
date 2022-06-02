package se.lexicon.dreas94.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;
import se.lexicon.dreas94.service.interfaces.StudentManagment;
import se.lexicon.dreas94.service.interfaces.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagment
{
    UserInputService scannerService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDao studentDao)
    {
        this.scannerService = scannerService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create()
    {
        return new Student(scannerService.getInt(), scannerService.getString());
    }

    @Override
    public Student save(Student student)
    {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id)
    {
        Student student;
        try
        {
            student = studentDao.find(id);
        }
        catch (DataNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public Student remove(int id)
    {
        Student student;
        try
        {
            student = studentDao.delete(id);
        }
        catch (DataNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        return student;
    }

    @Override
    public List<Student> findAll()
    {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student)
    {
        student.setId(scannerService.getInt());
        student.setName(scannerService.getString());

        return student;
    }
}
