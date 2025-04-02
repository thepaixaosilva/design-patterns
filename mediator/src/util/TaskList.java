package util;

import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskList {
    private final List<Task> tasks = new ArrayList<>();

    public void add(String description) {
        tasks.add(new Task(description));
    }

    public void remove(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public void complete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).complete();
        }
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }
}
