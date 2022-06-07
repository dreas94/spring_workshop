package se.lexicon.dreas94.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;
import se.lexicon.dreas94.util.UserInputService;

import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement
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
        System.out.println("Creating Student");
        System.out.println("Student Name: ");
        return save(new Student(scannerService.getString()));
    }

    @Override
    public Student save(Student student)
    {
        if (student == null) throw new IllegalArgumentException("Student is null");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id)
    {
        if (id <= 0) throw new IllegalArgumentException("id is not valid");
        try
        {
            return studentDao.find(id);
        }
        catch (DataNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student remove(int id)
    {
        try
        {
            return studentDao.delete(id);
        }
        catch (DataNotFoundException e)
        {
            e.printStackTrace();
            return null;
        }
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
