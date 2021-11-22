import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Tabledash
 */
public class Tabledash {

    public static ObservableList<Subject> getSubject(User user) {
        ObservableList<Subject> allsubjects = FXCollections.observableArrayList();
        for (int i = 0; i < user.getUserSubject().size(); i++) {
            allsubjects.add(user.getUserSubject().get(i));
        }
        return allsubjects;
    }

    public static ObservableList<User> getUser(Subject subject) throws ClassNotFoundException, IOException {
        ObservableList<User> allUser = FXCollections.observableArrayList();
        for (int i = 0; i < subject.getAllUser().size(); i++) {
            allUser.add(Course.updateinsideSubject(subject.getAllUser().get(i)));
        }
        return allUser;
    }

    public static ObservableList<Score> getScore(Subject subject)
            throws FileNotFoundException, ClassNotFoundException, IOException {
        subject.addScore();
        ArrayList<Score> allUserScore = new ArrayList<>();
        for(int i = 0; i < subject.getScore().size(); i++){
            allUserScore.add(new Score(subject.getScore().get(i)));
        }
        ObservableList<Score> allscore = FXCollections.observableArrayList();
        for(int j = 0; j < allUserScore.size(); j++){
            allscore.add(allUserScore.get(j));
        }

        return allscore;
    }
    
}
