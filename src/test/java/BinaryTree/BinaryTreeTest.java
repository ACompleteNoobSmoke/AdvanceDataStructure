package BinaryTree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    private BinaryTree btTree;

    @BeforeEach
    public void setUp(){
        btTree = new BinaryTree();
    }

    @Test
    void itShouldAddAndFind() {
        //Given
        Person newPerson = new Person(50, "Victoria", "Freelancer");
        //When
        btTree.add(newPerson);
        //Then
        assertEquals(newPerson, btTree.searchNode(50).data);
    }
}