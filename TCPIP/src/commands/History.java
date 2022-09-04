package commands;

import java.util.ArrayList;

public class History implements Command{
    private final ArrayList<String> history;

    public History(ArrayList<String> history) {
        this.history = history;
    }

    @Override
    public String act(String[] args) {
        return history.toString();
    }

    @Override
    public String getName() {
        return "History";
    }
}
