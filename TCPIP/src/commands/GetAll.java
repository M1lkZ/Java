package commands;

import java.util.ArrayList;

public class GetAll implements Command {
    private final ArrayList<Integer> commandList;

    public GetAll(ArrayList<Integer> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String act(String[] args) {
        if (commandList.size() == 0){
            return "Array is empty";
        }
        return commandList.toString();
    }

    @Override
    public String getName() {
        return "GetAll";
    }
}
