package util;

import java.util.ArrayList;
import java.util.List;
import view.TaskListView;
import view.components.TaskCompleter;
import view.components.TaskCreator;
import view.components.TaskRemover;

public class TaskManager implements Mediator {
    private final TaskList taskList;
    private final List<TaskListView> views = new ArrayList<>();
    private List<TaskCreator> creators = new ArrayList<>();
    private List<TaskRemover> removers = new ArrayList<>();
    private List<TaskCompleter> completers = new ArrayList<>();
    private int selectedTaskIndex = -1;
    
    public TaskManager(TaskList taskList) {
        this.taskList = taskList;
    }
    
    @Override
    public void registerTaskCreator(TaskCreator creator) {
        creators.add(creator);
    }
    
    @Override
    public void registerTaskRemover(TaskRemover remover) {
        removers.add(remover);
    }
    
    @Override
    public void registerTaskCompleter(TaskCompleter completer) {
        completers.add(completer);
    }
    
    @Override
    public void registerTaskListView(TaskListView view) {
        views.add(view);
        view.updateList(taskList.getTasks());
    }
    
    @Override
    public void taskSelected(int index) {
        this.selectedTaskIndex = index;
    }
    
    @Override
    public void addTask(String description) {
        taskList.add(description);
        for (TaskListView view : views) {
            view.addItem(taskList.getLastTask());
        }
    }
    
    @Override
    public void removeTask() {
        if (selectedTaskIndex != -1) {
            taskList.remove(selectedTaskIndex);
            for (TaskListView view : views) {
                view.removeItem(selectedTaskIndex);
            }
            selectedTaskIndex = -1;
        }
    }
    
    @Override
    public void completeTask() {
        if (selectedTaskIndex != -1) {
            taskList.complete(selectedTaskIndex);
            for (TaskListView view : views) {
                view.updateItem(selectedTaskIndex, taskList.getTask(selectedTaskIndex));
            }
        }
    }
}