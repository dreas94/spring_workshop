package se.lexicon.dreas94.models;

public class Student
{
    private int id;
    private String name;

    public Student()
    {
    }

    public Student(String name)
    {
        setName(name);
    }

    public Student(int id, String name)
    {
        setId(id);
        setName(name);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
