import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Subject implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String topicName;
    private String teacherName;
    private String teacherPicture;
    private String subjectString;
    private String subjectID;
    private ArrayList<User> allUser;
    private ArrayList<String> score;

    private String subjectPicture;
    private String detailSubjectString;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectPicture() {
        return subjectPicture;
    }

    public void setSubjectPicture(String subjectPicture) {
        this.subjectPicture = subjectPicture;
    }

    public String getTeacherPicture() {
        return teacherPicture;
    }

    public void setTeacherPicture(String teacherPicture) {
        this.teacherPicture = teacherPicture;
    }

    public String getSubjectString() {
        return subjectString;
    }

    public void setSubjectString(String subjectString) {
        this.subjectString = subjectString;
    }

    public String getDetailSubjectString() {
        return detailSubjectString;
    }

    public void setDetailSubjectString(String detailSubjectString) {
        this.detailSubjectString = detailSubjectString;
    }

    public Subject(String topicName, String teacherName, String teacherPicture, String subjectString, String subjectID,
            String subjectPicture, String detailSubjectString) {
        this.topicName = topicName;
        this.teacherName = teacherName;
        this.teacherPicture = teacherPicture;
        this.subjectString = subjectString;
        this.subjectID = subjectID;
        this.subjectPicture = subjectPicture;
        this.detailSubjectString = detailSubjectString;
        this.allUser = new ArrayList<>();
        this.score = new ArrayList<>();
    }

    public Subject(String subjectPicture, String subjectString) {
        this.subjectPicture = subjectPicture;
        this.subjectString = subjectString;
    }

    public ArrayList<User> getAllUser() {
        return allUser;
    }

    public void setAllUser(User user) {
        this.allUser.add(user);
    }

    public void addScore() throws FileNotFoundException, ClassNotFoundException, IOException {
        score.clear();
        for(int i = 0;i < allUser.size(); i++){
            score.add(Course.updateinsideSubject(getAllUser().get(i)).getUserScore(this.subjectString));
        }
    }

    public ArrayList<String> getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Subject [allUser=" + allUser + ", score=" + score + ", subjectString=" + subjectString + "]";
    }

}
