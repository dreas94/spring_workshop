package se.lexicon.dreas94.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.dreas94.config.ComponentScanConfig;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.exception.DataNotFoundException;
import se.lexicon.dreas94.models.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest
{
    @Autowired
    StudentDao testObject;
    Student student1;

    @BeforeEach
    public void setUp()
    {
        student1 = new Student(1,"Andreas Eriksson");
        Student student2 = new Student(2,"Tabea Teufel");

        testObject.save(student1);
        testObject.save(student2);
    }

    @Test
    @DisplayName("test find id 1 with the result and student1 being equal")
    public void test_findId1()
    {
        Student result;
        try
        {
            result = testObject.find(1);
        }
        catch (DataNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        assertEquals(result,student1);
    }

    @Test
    @DisplayName("test get all method from student dao with result 2")
    public void test_getAll()
    {
        int actualSize = testObject.findAll().size();
        int expectedSize = 2;

        assertEquals(expectedSize,actualSize);
    }

    @Test
    @DisplayName("test get delete method from student, then get all method from student dao with result 1")
    public void test_delete()
    {
        try
        {
            testObject.delete(1);
        }
        catch (DataNotFoundException e)
        {
            throw new RuntimeException(e);
        }

        int actualSize = testObject.findAll().size();
        int expectedSize = 1;

        assertEquals(expectedSize,actualSize);
    }

}
