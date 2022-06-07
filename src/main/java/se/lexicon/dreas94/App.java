package se.lexicon.dreas94;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.dreas94.config.ComponentScanConfig;
import se.lexicon.dreas94.service.StudentManagement;

public class App
{
    public static void main(String[] args)
    {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class))
        {
            StudentManagement studentDao = context.getBean(StudentManagement.class);
        }
    }
}
