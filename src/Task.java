import java.time.LocalDate;

public class Task<T extends Priority> {
    private String name;
    private LocalDate deadline;
    private T priority;

    public Task(String name, LocalDate date, T priority){
        this.name = name;
        this.deadline = date;
        this.priority = priority;
    }

    public Task() {

    }

    @Override
    public String toString() {
        return "Task: '" + name +
                "'\n Deadline: " + deadline +
                "\n Priority: " + priority;
    }
}
