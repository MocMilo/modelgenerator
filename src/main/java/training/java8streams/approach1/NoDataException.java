package training.java8streams.approach1;

public class NoDataException extends RuntimeException {

    private static final String MESSAGE = "No Data in collection.";

    public NoDataException() {
        super(MESSAGE);
    }

    public NoDataException(String message) {
        super(message);
    }
}
