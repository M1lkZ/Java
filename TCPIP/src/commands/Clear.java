package commands;

import java.util.ArrayList;

public class Clear implements Command{
    private final ArrayList<Integer> listOfIntegers;

    public Clear(ArrayList<Integer> listOfIntegers) {
        this.listOfIntegers = listOfIntegers;
    }

    @Override
    public String act(String[] args) {
        listOfIntegers.clear();
        return "Array has been cleared";
    }

    @Override
    public String getName() {
        return "Clear";
    }
}
