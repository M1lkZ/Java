package commands;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandHandler {
    private final ArrayList<Integer> listOfIntegers = new ArrayList<>();
    private final ArrayList<Command> listOfCommands = new ArrayList<>();
    private final ArrayList<String> listHistory = new ArrayList<>();

    public CommandHandler() {
        listOfCommands.add(new Add(listOfIntegers));
        listOfCommands.add(new GetAll(listOfIntegers));
        listOfCommands.add(new Get(listOfIntegers));
        listOfCommands.add(new Clear(listOfIntegers));
        listOfCommands.add(new History(listHistory));
        listOfCommands.add(new Size(listOfIntegers));
    }

    public String handle(String str){
        String[] splitted = str.split(" ");
        Command command = null;
        for (Command c :listOfCommands) {
            String name = c.getName();
            if (name.equalsIgnoreCase(splitted[0])) {
                command = c;
                break;
            }
        }
        if (command == null){
            return "Incorrect command";
        }
        if (listHistory.size() >= 3){
            listHistory.remove(0);
        }
        listHistory.add(str);
        return command.act(Arrays.copyOfRange(splitted, 1, splitted.length));
    }
}

