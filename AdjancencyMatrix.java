import java.util.ArrayList;
import java.util.List;

public class AdjancencyMatrix {
    int v;
    int[][] matrix;

    // initialize matrix
    AdjancencyMatrix(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    // add edgegs
    public void addEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    // print graph

    void printGraph() {
        for (int i = 0; i < v; i++) {
            System.out.println(i + " is connected to");
            for (int j = 0; j < v; j++) {
                if(matrix[i][j] != 0){
                    System.out.println(j+", ");
                }
            }
            System.out.println();
        }
    }
    //get adj nodes
    List<Integer> getAdjNodes(int i){
        List<Integer> adjNodes = new ArrayList<Integer>();
        for(int j=0;j<v;j++){
            if(matrix[i][j]!=0){
                adjNodes.add(j);
            }
        }
        return adjNodes;
        
    }
    //print adjacency matrix

    public static void main(String[] args) {
        AdjancencyMatrix adj = new AdjancencyMatrix(5);
        adj.addEdge(0, 1);
        adj.addEdge(0, 2);
        adj.addEdge(1, 4);
        adj.addEdge(2, 3);
        adj.addEdge(2, 4);
        adj.addEdge(3, 4);
        adj.printGraph();
        adj.getAdjNodes(1);
    }

}
