import java.util.ArrayList;

public class Question {
    String proposition;
    ArrayList<String> choiceList = new ArrayList<String>();
    int amountOfChoice;
    int correctChoice;

    public Question(String text) {
        proposition = text;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public String getProposition() {
        return proposition;
    }
    
    public void addChoice(String text) {
        choiceList.add(text);
    }

    public void setChoice(int i, String text) {
        choiceList.set(i, text);
    }

    public String getChoice(int number) {
        return choiceList.get(number);
    }

    public void setCorrectChoice(int number) {
        correctChoice = number;
    }

    public int getCorrectChoice(int number) {
        return correctChoice;
    }

    public String toString() {
        String text = proposition;
        for (int i = 0 ; i < choiceList.size() ; i++) {
            text += "\n" + (char)(i + 65) + ". " + choiceList.get(i);
        }
        return text;
    }

    
}