package view.components;

import javax.swing.*;
import util.Mediator;

public class TaskCompleter extends Component {
    private final JButton completeButton;
    
    @SuppressWarnings("unused")
	public TaskCompleter(Mediator mediator) {
        super(mediator);
        
        completeButton = new JButton("Concluir");
        
        completeButton.addActionListener(e -> {
            mediator.completeTask();
        });
        
        mediator.registerTaskCompleter(this);
    }
    
    public JButton getCompleteButton() {
        return completeButton;
    }
}