package se.lexicon.dreas94.exception;

public class DataNotFoundException extends Exception
{
    private final String objectName;

    public DataNotFoundException(String message, String objectName) {
        super(message);
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }

}
