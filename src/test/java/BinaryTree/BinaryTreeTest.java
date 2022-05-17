package BinaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    private BinaryTree btTree;
    private List<Person> testPeople;

    @BeforeEach
    public void setUp(){
        btTree = new BinaryTree();
        testPeople = getPeople();
        addPeople();
    }

    public List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person(50, "Victoria", "Freelancer"));
        people.add(new Person(50, "Victoria", "Freelancer"));
        people.add(new Person(10, "Osaretin", "Sailor"));
        people.add(new Person(100, "Boye", "Programmer"));
        people.add(new Person(85, "Ade", "Programmer"));
        people.add(new Person(20, "Sammy", "Student"));
        people.add(new Person(35, "Armando", "Gamer Designer"));
        return people;
    }

    public void addPeople(){
        testPeople.forEach(p -> btTree.addNode(p));
    }

    @Test
    void inOrderTraversal() {
        btTree.inOrderTraversal(btTree.root);
    }

    @Test
    void preOrderTraversal(){
        btTree.preOrderTraversal(btTree.root);
    }

    @Test
    void postOrderTraversal(){
        btTree.postOrderTraversal(btTree.root);
    }

    @Test
    void searchForExistingPerson(){
        int index = new Random().nextInt(7);
        Person randomPerson = testPeople.get(index);
        Person foundPerson = btTree.searchNode(randomPerson.id);
        assertTrue(randomPerson.equals(foundPerson), "Found: \n" + foundPerson);
    }

    @Test
    void searchForNotExistingPerson(){
        int index = new Random().nextInt(7);
        assertEquals(null, btTree.searchNode(index));
    }

    @Test
    void removeExistingPerson(){
        int index = new Random().nextInt(7);
        Person randomPerson = testPeople.get(index);
        System.out.println("Person Getting Deleted \n" + randomPerson);
        btTree.deleteNode(randomPerson.id);
        System.out.println("After Deleting Person: \n");
        inOrderTraversal();
    }




}