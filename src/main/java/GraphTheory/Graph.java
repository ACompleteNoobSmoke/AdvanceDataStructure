package GraphTheory;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex<Character>> vertices;
    private int[][] matrix;

    public Graph(int size){
        vertices = new ArrayList<>(size);
        matrix = new int[size][size];
    }

    public void addVertex(Vertex newVertix){
        vertices.add(newVertix);
    }

    public void addEdge(int src, int dest){
        matrix[src][dest] = 1;
    }

    public boolean checkEdge(int src, int dest){
        return matrix[src][dest] == 1;
    }

    public void print(){
        System.out.print("  ");
        vertices.forEach(v -> System.out.print(v.getData() + " "));
        System.out.println();

        for(int i = 0; i < matrix.length; i++){
            System.out.print(vertices.get(i).getData() + " ");
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
