package util;

import view.TaskListView;
import view.components.TaskCompleter;
import view.components.TaskCreator;
import view.components.TaskRemover;

public interface Mediator {
    void addTask(String description);
    void removeTask();
    void completeTask();
    void taskSelected(int index);
    
    void registerTaskCreator(TaskCreator creator);
    void registerTaskRemover(TaskRemover remover);
    void registerTaskCompleter(TaskCompleter completer);
    void registerTaskListView(TaskListView view);
}