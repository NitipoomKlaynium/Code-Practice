
import java.io.Serializable;
import java.util.ArrayList;

import javafx.util.Pair;


public class User implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static int numberUser;
    private String username;
    private String password;
    private int ID;
    private boolean teacher;  //True = teacher , False = Student
    private String name,surname,address,email,tel;
    private ArrayList<Subject> userSubject;
    private ArrayList<Pair<String, String>> userScore;
    private String picture;

    public User(String user, String pass, boolean teacher) {
        this.username = user;
        this.password = pass;
        this.teacher = teacher;
        numberUser++;
        this.ID = numberUser;
        this.email = this.username + "@kmitl.ac.th";
        this.address = this.username;
        this.name = this.username;
        this.tel = this.username;
        this.surname = this.username;
        this.userSubject = new ArrayList<>();
        this.picture = "Image/error404.jpg";
        this.userScore = new ArrayList<>();
    }
    
    
    public static int getNumberUser() {
        return numberUser;
    }
    
    public static void setNumberUser(int numberUser) {
        User.numberUser = numberUser;
    }

    public String getUsername(){
        return this.username;
    }

    public boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(boolean teacher) {
        this.teacher = teacher;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [ID=" + ID + ", " + " teacher=" + teacher + ", username=" + username + "]";
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ArrayList<Subject> getUserSubject() {
        return userSubject;
    }

    public void addUserSubject(Subject subject) {
        this.userSubject.add(subject);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    String score;
    public String getUserScore(String subjectName) {
        score = "0";
        for(int i = 0; i< this.userScore.size(); i++){
            if(this.userScore.get(i).getKey().equals(subjectName)){
                score = this.userScore.get(i).getValue();
                break;
            }
        }
        return  score;
    }

    public void setUserScore(String subjectName, String score) {
        this.userScore.add(new Pair<String ,String>(subjectName, score));
    }
}