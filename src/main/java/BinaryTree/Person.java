package BinaryTree;

import java.util.ArrayList;

public class Person {
    public int id;
    public String name;
    public String occupation;

    public Person(int id, String name, String occupation){
        this.id = id;
        this.name = name;
        this.occupation = occupation;
    }

    public String toString(){
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Occupation: " + occupation + "\n";
    }
}
