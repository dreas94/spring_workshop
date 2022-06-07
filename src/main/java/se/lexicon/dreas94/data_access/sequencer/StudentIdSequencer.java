package se.lexicon.dreas94.data_access.sequencer;

public class StudentIdSequencer
{

    private static int sequencer = 0;

    public static int nextId(){
        return ++sequencer;
    }

}
