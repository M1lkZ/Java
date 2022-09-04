import Guys.AntoHa;
import Guys.Leha;
import Guys.Makar;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic();
        logic.Act(new Makar());
        logic.Act(new AntoHa());
        logic.Act(new Leha());
    }
}