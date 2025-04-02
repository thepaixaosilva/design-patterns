package view.components;

import javax.swing.*;
import util.Mediator;

public class TaskCreator extends Component {
    private final JTextField taskField;
    private final JButton addButton;
    
    @SuppressWarnings("unused")
	public TaskCreator(Mediator mediator) {
        super(mediator);
        
        taskField = new JTextField(20);
        addButton = new JButton("Adicionar");
        
        addButton.addActionListener(e -> {
            String description = taskField.getText().trim();
            if (!description.isEmpty()) {
                mediator.addTask(description);
                taskField.setText("");
            }
        });
        
        mediator.registerTaskCreator(this);
    }
    
    public JTextField getTextField() {
        return taskField;
    }
    
    public JButton getAddButton() {
        return addButton;
    }
    
    public void clearField() {
        taskField.setText("");
    }
}