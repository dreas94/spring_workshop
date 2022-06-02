package se.lexicon.dreas94.models;

public class Student
{
    private int id;
    private String name;

    public Student(int id, String name)
    {
        setId(id);
        setName(name);
    }

    public long getId()
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
