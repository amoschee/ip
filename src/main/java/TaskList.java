import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private final List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public String addTask(Task task) {
        tasks.add(task);
        StringBuilder sb = new StringBuilder();
        sb.append("Got it. I've added this task:\n").append(task).append("\n");
        sb.append("Now you have ").append(tasks.size()).append(" tasks in the list!");
        return sb.toString();
    }

    public int getSize() {
        return tasks.size();
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public String markDone(int taskNumber) {
        StringBuilder sb = new StringBuilder();
        Task task = getTask(taskNumber - 1);
        task.markDone();
        sb.append("Nice! I've marked this task as done:\n");
        sb.append(task);
        return sb.toString();
    }

    public String markUndone(int taskNumber) {
        StringBuilder sb = new StringBuilder();
        Task task = getTask(taskNumber - 1);
        task.markUndone();
        sb.append("Ok, I've marked this task as not done yet:\n");
        sb.append(task);
        return sb.toString();
    }

    public String deleteTask(int taskNumber) {
        StringBuilder sb = new StringBuilder();
        Task task = getTask(taskNumber - 1);
        this.tasks.remove(task);
        sb.append("Noted. I've removed this task:\n");
        sb.append(task).append("\n");
        sb.append("Now you have ").append(tasks.size()).append(" tasks in the list!");
        return sb.toString();
    }

    public String toFileFormat() {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task.toFileFormat()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (Task task : tasks) {
            sb.append(count).append(". ").append(task.toString()).append("\n");
            count++;
        }

        return sb.toString();
    }
}
