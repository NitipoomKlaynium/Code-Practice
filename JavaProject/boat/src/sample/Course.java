package sample;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Course {
    public static void createTopic( String getTopicName)  throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin); 
            while(fin.available() != 0){
                System.out.println("Reading Old Course");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }
        boolean same = false;
        ObjectOutputStream writeTopic = new ObjectOutputStream(new FileOutputStream("coursedata.dat"));
        for (int i = 0; i < oldTopic.size(); i++) {
            System.out.println("Writing Old Course");
            writeTopic.writeObject(oldTopic.get(i));
            if(getTopicName.equals(oldTopic.get(i).getTopicName())){
                same = true;
            }
        }
        if(same == false){
            writeTopic.writeObject(new Topic(getTopicName));
        }
        writeTopic.close();
    }

    public static void addNewTopic( Subject addSubject, String getTopicName)  throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            while(fin.available() != 0){
                System.out.println("Reading Old Topic");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }

        ObjectOutputStream writeTopic = new ObjectOutputStream(new FileOutputStream("coursedata.dat"));
        for (int i = 0; i < oldTopic.size(); i++) {

            if(getTopicName.equals(oldTopic.get(i).getTopicName())){
                oldTopic.get(i).setSubjectArrayList(addSubject);
                System.out.println("Finished Add Subject");
                writeTopic.writeObject(oldTopic.get(i));
            }
            else{
                System.out.println("Writing Old Topic");
                writeTopic.writeObject(oldTopic.get(i));
            }
        }
        writeTopic.close();
    }

    public static ArrayList<Topic> readoldtopic() throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            while(fin.available() != 0){
                System.out.println("Reading Old Topic");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }
        System.out.println(oldTopic.size());
        return oldTopic;
    }

    public static boolean checkTopic(String topicname) throws IOException, ClassNotFoundException {
        boolean same = false;
        File file = new File("coursedata.dat");
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin); 
            while(fin.available() != 0){
                System.out.println("Reading Old Course");
                Topic a = (Topic)in.readObject();
                if(topicname.equals(a.getTopicName())){
                    same = true;
                }
            }
            in.close();
        }
        if(same == true){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkSubject(String subjectname) throws IOException, ClassNotFoundException {
        boolean same = false;
        File file = new File("coursedata.dat");
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin); 
            while(fin.available() != 0){
                System.out.println("Reading Old Course");
                Topic a = (Topic)in.readObject();
                for(int i = 0; i < a.getSubjectArrayList().size(); i++){
                    if(subjectname.equals(a.getSubjectArrayList().get(i).getSubjectString())){
                        same = true;
                        break;
                    }
                }
            }
            in.close();
        }
        if(same == true){
            return false;
        }
        else {
            return true;
        }
    }

    public static void updateTopic(Subject subject) throws FileNotFoundException, IOException, ClassNotFoundException {
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            while(fin.available() != 0){
                System.out.println("Reading Old Topic");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }

        ObjectOutputStream writeTopic = new ObjectOutputStream(new FileOutputStream("coursedata.dat"));
        for (int i = 0; i < oldTopic.size(); i++) {
            for(int j = 0; j < oldTopic.get(i).getSubjectArrayList().size(); j++){
                if(oldTopic.get(i).getSubjectArrayList().get(j).getSubjectString().equals(subject.getSubjectString())){
                    oldTopic.get(i).getSubjectArrayList().remove(j);
                    oldTopic.get(i).getSubjectArrayList().add(subject);
                }
            }
            writeTopic.writeObject(oldTopic.get(i));
        }
        writeTopic.close();
    }

    public static void deleteTopic(Topic topic)  throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            while(fin.available() != 0){
                System.out.println("Reading Old Topic");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }
        for (int i = 0; i < oldTopic.size(); i++) {
            if(oldTopic.get(i).getTopicName().equals(topic.getTopicName())){
                oldTopic.remove(i);
            }
        }
        ObjectOutputStream writeTopic = new ObjectOutputStream(new FileOutputStream("coursedata.dat"));
        for (int j = 0; j < oldTopic.size(); j++) {
            writeTopic.writeObject(oldTopic.get(j));
        }
        writeTopic.close();
    }
    
   
    public static void deleteSubject(Subject subject) throws FileNotFoundException, IOException, ClassNotFoundException{
        File file = new File("coursedata.dat");
        ArrayList<Topic> oldTopic = new ArrayList<>();
        if(file.exists()){
            FileInputStream fin = new FileInputStream("coursedata.dat");
            ObjectInputStream in = new ObjectInputStream(fin);
            while(fin.available() != 0){
                System.out.println("Reading Old Topic");
                Topic a = (Topic)in.readObject();
                oldTopic.add(a);
            }
            in.close();
        }
        for (int i = 0; i < oldTopic.size(); i++) {
            for(int k = 0;k < oldTopic.get(i).getSubjectArrayList().size(); k++){
                if(oldTopic.get(i).getSubjectArrayList().get(k).getSubjectString().equals(subject.getSubjectString())){
                    oldTopic.get(i).getSubjectArrayList().remove(k);
                }
            }
        ObjectOutputStream writeTopic = new ObjectOutputStream(new FileOutputStream("coursedata.dat"));
        for (int j = 0; i < oldTopic.size(); i++) {
            writeTopic.writeObject(oldTopic.get(j));
        }
        writeTopic.close();
        }
    }
}