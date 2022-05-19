package Stack;

import BinaryTree.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private StackMethods stacks;
    private List<Person> testPeople;


    @BeforeEach
    void setUp() {
        testPeople = getTestPeople();
        int limit = testPeople.size();
        stacks = new Stack(limit);
    }

    public List<Person> getTestPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person(50, "Victoria", "Freelancer"));
        people.add(new Person(10, "Osaretin", "Sailor"));
        people.add(new Person(100, "Boye", "Programmer"));
        people.add(new Person(85, "Ade", "Programmer"));
        people.add(new Person(20, "Sammy", "Student"));
        people.add(new Person(35, "Armando", "Gamer Designer"));
        return people;
    }

    @Test
    public void addOnePerson(){
        int index = new Random().nextInt(testPeople.size());
        Person newPerson = testPeople.get(index);
        System.out.println("Index: " + index + "\n" + newPerson);
        assertTrue(stacks.push(newPerson));
    }

    @Test
    public void addMultiplePeople(){
        testPeople.forEach(p -> stacks.push(p));
        stacks.printAll();
        assertEquals(stacks.getLimit(), testPeople.size());
    }

    @Test
    public void cantAddIfFull(){
        testPeople.forEach(p -> stacks.push(p));
        Person newPerson =
                new Person(123, "Omoruyi", "Programmer");
        boolean added = stacks.push(newPerson);
        stacks.printAll();
        assertFalse(added);
    }


}