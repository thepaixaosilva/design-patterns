package view.components;

import util.Mediator;

public abstract class Component {
    protected Mediator mediator;
    
    public Component(Mediator mediator) {
        this.mediator = mediator;
    }
    
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}