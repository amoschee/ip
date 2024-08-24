import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDate from;
    protected LocalDate to;

    public Event(String description, LocalDate from, LocalDate to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormat() {
        return "E|" + super.toFileFormat() + "|" + from.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "|"
                + to.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from.format(DateTimeFormatter.ofPattern("d MMM yyyy"))
                + " to " + to.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}
