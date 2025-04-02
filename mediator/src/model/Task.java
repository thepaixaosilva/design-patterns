package model;

public class Task {
    private final String description;
    private boolean completed;

    public Task(String descricao) {
        this.description = descricao;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    public void reopen() {
        this.completed = false;
    }

    @Override
    public String toString() {
        return (completed ? "[✔] " : "[ ] ") + description;
    }
}
