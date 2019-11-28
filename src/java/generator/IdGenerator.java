package generator;

public class IdGenerator {
    private static final long ID_MIN = 1;
    private static final long ID_MAX = 100_000;
    private static long counter;

    private IdGenerator() {
    }

    public static long generateId() {
        ++counter;
        if (ID_MIN + counter >= ID_MAX) {
            counter = 0;
        }
        long generatedId = counter;
        return generatedId;
    }

    public static void setId(long id) {
        counter = id;
    }
}
