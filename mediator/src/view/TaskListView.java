package view;

import javax.swing.*;
import model.Task;
import util.Mediator;
import view.components.Component;
import view.components.TaskCompleter;
import view.components.TaskCreator;
import view.components.TaskRemover;

import java.util.List;
import java.awt.*;

public class TaskListView extends Component {
	 private final JFrame frame;
	    private final DefaultListModel<Task> listModel = new DefaultListModel<>();
	    private final JList<Task> list = new JList<>(listModel);
	    
	    public TaskListView(String title, Mediator mediator) {
	        super(mediator);
	        
	        frame = new JFrame(title);
	        frame.setSize(650, 500);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLayout(new BorderLayout());
	        
	        JScrollPane scrollPane = new JScrollPane(list);
	        frame.add(scrollPane, BorderLayout.CENTER);
	        
	        TaskCreator creator = new TaskCreator(mediator);
	        TaskRemover remover = new TaskRemover(mediator);
	        TaskCompleter completer = new TaskCompleter(mediator);
	        
	        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
	        
	        controlPanel.add(new JLabel("Nova tarefa:"));
	        controlPanel.add(creator.getTextField());
	        controlPanel.add(creator.getAddButton());
	        controlPanel.add(remover.getRemoveButton());
	        controlPanel.add(completer.getCompleteButton());
	        
	        frame.add(controlPanel, BorderLayout.SOUTH);
	        
	        list.addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                int selectedIndex = list.getSelectedIndex();
	                mediator.taskSelected(selectedIndex);
	            }
	        });
	        
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        
	        mediator.registerTaskListView(this);
	    }
	    
	    public void updateList(List<Task> tasks) {
	        listModel.clear();
	        for (Task task : tasks) {
	            listModel.addElement(task);
	        }
	    }
	    
	    public void addItem(Task task) {
	        listModel.addElement(task);
	    }
	    
	    public void removeItem(int index) {
	        listModel.remove(index);
	    }
	    
	    public void updateItem(int index, Task task) {
	        listModel.set(index, task);
	    }
	    
	    public int getSelectedIndex() {
	        return list.getSelectedIndex();
	    }
}