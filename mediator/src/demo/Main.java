package demo;

import javax.swing.SwingUtilities;
import util.TaskManager;
import util.TaskList;
import util.Mediator;
import view.TaskListView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TaskList taskList = new TaskList();
            Mediator mediator = new TaskManager(taskList);
            new TaskListView("Todo List", mediator);
        });
    }
}