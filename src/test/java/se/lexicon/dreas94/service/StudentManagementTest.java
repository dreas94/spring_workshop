package se.lexicon.dreas94.service;


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
public class StudentManagementTest
{
    @Autowired
    StudentManagement testObject;

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
        Student expectedData = new Student(1, "Andreas Eriksson");
        Student actualData = testObject.find(1);
        assertEquals(expectedData, actualData);
    }

    @Test
    @DisplayName("test findAll method from StudentManagement with result 2")
    public void test_findAll()
    {
        int actualSize = testObject.findAll().size();
        int expectedSize = 2;

        assertEquals(expectedSize,actualSize);
    }

    @Test
    @DisplayName("test remove method from student, then get all method from StudentManagement with result 1")
    public void test_remove()
    {
        testObject.remove(1);

        int actualSize = testObject.findAll().size();
        int expectedSize = 1;

        assertEquals(expectedSize,actualSize);
    }
}
