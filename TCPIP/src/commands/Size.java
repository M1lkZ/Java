package commands;

import java.util.ArrayList;

public class Size implements Command{
    private final ArrayList<Integer> commandList;

    public Size(ArrayList<Integer> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String act(String[] args) {
        return "Size: " + commandList.size();
    }

    @Override
    public String getName() {
        return "Size";
    }
}
