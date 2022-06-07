package se.lexicon.dreas94.dao;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest
{
    @Autowired
    StudentDao testObject;

    @BeforeEach
    public void setUp()
    {
        Student student1 = new Student("Andreas Eriksson");
        Student student2 = new Student("Tabea Teufel");

        testObject.save(student1);
        testObject.save(student2);
    }

    @Test
    @DisplayName("given Student student successfully create and successfully equal")
    void test_save()
    {
        Student expectedData = new Student(3, "Mehrdad Javan");
        Student actualData = testObject.save(new Student("Mehrdad Javan"));
        assertEquals(expectedData, actualData);
    }

    @Test
    @DisplayName("test find id 1 with the result and student1 being equal")
    public void test_findId1()
    {
        try
        {
            Student expectedData = new Student(1, "Andreas Eriksson");
            Student actualData = testObject.find(1);
            assertEquals(expectedData, actualData);
        }
        catch (DataNotFoundException e)
        {
            System.out.println(e.getObjectName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("test get all method from student dao with result 2")
    public void test_getAll()
    {
        int actualSize = testObject.findAll().size();
        int expectedSize = 2;

        assertEquals(expectedSize, actualSize);
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

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void find_throws_DataNotFoundException()
    {
        assertThrows(DataNotFoundException.class, () -> testObject.find(10));
    }

    @Test
    void delete_throws_DataNotFoundException()
    {
        assertThrows(DataNotFoundException.class, () -> testObject.delete(10));
    }

}
