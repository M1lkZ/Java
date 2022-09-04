package commands;

public interface Command {
    String act(String[] args);
    String getName();
}
