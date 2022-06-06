package se.lexicon.dreas94.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dreas94.service.interfaces.UserInputService;

import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService
{
    Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner)
    {
        this.scanner = scanner;
    }

    @Override
    public String getString()
    {
        String nextLine = null;

        do
        {
            if(scanner.hasNextLine())
            {
                nextLine = scanner.nextLine();
            }
            else
            {
                System.out.println("That's not a String!");
                scanner.next();
                System.out.println("Try again!: ");
            }
        }while(nextLine == null);

        return nextLine;
    }

    @Override
    public int getInt()
    {
        int nextInt = -1;

        do
        {
            if(scanner.hasNextInt())
            {
                nextInt = scanner.nextInt();
            }
            else
            {
                System.out.println("That's not a Integer!");
                scanner.next();
                System.out.println("Try again!: ");
            }
        }while(nextInt == -1);

        return nextInt;
    }
}
