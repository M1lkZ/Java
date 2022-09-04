package commands;

import java.util.ArrayList;

public class Get implements Command{
    private final ArrayList<Integer> commandList;

    public Get(ArrayList<Integer> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String act(String[] args) {
        if(args.length < 1){
           return "Not enough arguments";
        }
        int id = Integer.parseInt(args[0]);
        if(id < 0){
            return "Id must be positive";
        }
        if (id > commandList.size() - 1){
            return "Id is out of list range";
        }
        return commandList.get(id).toString();
    }

    @Override
    public String getName() {
        return "Get";
    }
}
