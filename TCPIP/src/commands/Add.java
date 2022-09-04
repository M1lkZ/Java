package commands;

import java.util.ArrayList;

public class Add implements commands.Command {
    private final ArrayList<Integer> commandList;

    public Add(ArrayList<Integer> commandList) {
        this.commandList = commandList;
    }

    @Override
    public String act(String[] args){
        if (args.length == 0){
            return "Где цифра, хуесос?????77??";
        }
        commandList.add(Integer.parseInt(args[0]));
        return "Element was added, suck me off";
    }

    @Override
    public String getName() {
        return "Add";
    }
}
