package view.components;

import javax.swing.*;
import util.Mediator;

public class TaskRemover extends Component {
    private final JButton removeButton;
    
    @SuppressWarnings("unused")
	public TaskRemover(Mediator mediator) {
        super(mediator);
        
        removeButton = new JButton("Remover");
        
        removeButton.addActionListener(e -> {
            mediator.removeTask();
        });
        
        mediator.registerTaskRemover(this);
    }
    
    public JButton getRemoveButton() {
        return removeButton;
    }
}