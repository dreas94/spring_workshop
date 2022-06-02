package se.lexicon.dreas94;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.dreas94.config.ComponentScanConfig;
import se.lexicon.dreas94.data_access.dao.StudentDao;
import se.lexicon.dreas94.service.interfaces.StudentManagment;
import se.lexicon.dreas94.service.interfaces.UserInputService;

public class App
{
    public static void main(String[] args)
    {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class))
        {
            StudentManagment studentDao = context.getBean(StudentManagment.class);
        }
    }
}
