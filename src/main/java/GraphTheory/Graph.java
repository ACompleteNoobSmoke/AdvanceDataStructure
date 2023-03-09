package GraphTheory;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    List<Vertex> vertices;
    int[][] matrix;

    public Graph(int size){
        matrix = new int[size][size];
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex node){
        vertices.add(node);
    }

    public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest){
        return matrix[src][dest] == 1;
    }

    public void print(){
        System.out.print("  ");
        vertices.forEach(n -> System.out.print(n.getData() + " "));
        System.out.println();
        for (int i = 0; i < matrix.length; i++){
            System.out.print(vertices.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
