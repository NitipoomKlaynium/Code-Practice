
public class Predict {
    Day day = Day.Tuesday;

    public Predict() {

    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void action() {
        if (day == Day.Monday) {
            System.out.println("--Monday--");
        }
        if (day == Day.Tuesday) {
            System.out.println("--Tuesday--");
        }
    }
}