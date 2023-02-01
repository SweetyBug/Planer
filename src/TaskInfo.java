import java.util.Date;

public class TaskInfo extends Task{
    final Date dateAdd;
    final String username;
    final int id;
    Task task;

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    public TaskInfo(String username, int id, Task task) {
        super();
        this.dateAdd = new Date();
        this.id = id;
        this.username = username;
        this.task = task;
        this.status = "Expectation";
    }


    TaskInfo(String username, int id){
        this.dateAdd = new Date();
        this.username = username;
        this.id = id;
        this.status = "Expectation";
    }

    @Override
    public String toString() {
        return  "id: " + id +
                    task +
                "\n Date of creation: " + dateAdd +
                "\n User: " + username +
                "\n Status: " + status;
    }
}
