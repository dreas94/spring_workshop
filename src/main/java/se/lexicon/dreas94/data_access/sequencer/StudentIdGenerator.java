package se.lexicon.dreas94.data_access.sequencer;

public class StudentIdGenerator
{
    private static final int MAX = 999999;
    private static final int MIN = 100000;
    private static int sequencer = 0;

    public static long generateAccountNumber()
    {
        return Long.parseLong(++sequencer + "" + getRandomNumber());
    }

    private static int getRandomNumber()
    {
        return (int) ((Math.random() * (MAX - MIN)) + MIN);
    }

}
