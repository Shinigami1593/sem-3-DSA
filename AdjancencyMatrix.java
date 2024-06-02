import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdjancencyMatrix {
    int v;
    int[][] matrix;

    // initialize matrix
    AdjancencyMatrix(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    // add edgegs
    public void addEdge(int source, int destination, int weight) {
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
    //BFS
    void BFS(int s){
        boolean visited[] = new boolean[v];
        Queues q = new Queues(v);
        q.enQueue(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int u = q.dequeue();
            System.out.println(u);
            for(int j = 0; j<v;j++ ){
                if(matrix[u][j] != 0 ){
                    if(!visited[j]){
                        q.enQueue(j);
                        visited[j] = true;

                    }
                }
            }
        }
    }
    void depthFirstSearch(int s){
        boolean visited[] = new boolean[v];
        dfs(s,visited);
    }
    void dfs(int s,boolean visited[]){
        visited[s] = true;
        System.out.println(s);
        for(int j = 0; j<v;j++){
            if(matrix[s][j] != 0){
                dfs(j, visited);
            }
        }
    }

    //SHORTEST PATH FINDING BFS
    int shortestPathBFS(int source, int destination){
        Queues q = new Queues(v);
        boolean visited[] = new boolean[v];
        int dist[] = new int[v];
        int prevpath[] = new int[v];
        for(int i= 0; i<v;i++){
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        dist[source] = 0;
        q.enQueue(source);
        visited[source] = true;
        while(!q.isEmpty()){
            int u = q.dequeue();
            for(int j = 0;j<v;j++){
                if(matrix[u][j] != 0){
                    if(!visited[j]){
                        if(dist[u] + 1<dist[j]){
                            dist[j] = dist[u]+1;
                            prevpath[j] = u;
                            q.enQueue(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        //PATH PRINTING ALGORITHM:
        // List<Integer> path = new ArrayList<>();
        // int currentNode = destination;
        // path.add(destination);
        // while (prevpath.get(currentNode) != -1) {
        //     path.add(prevpath.get(currentNode));
        //     currentNode = par.get(currentNode);
        // }
        Stack<Integer> stk = new Stack<Integer>();
        int temp = destination;
        stk.push(temp);
        while(prevpath[temp] != -1){
            temp = prevpath[temp];
            stk.push(prevpath[temp]);
        }
        while (stk.isEmpty()) {
            System.out.println("Printing path");
            int val = stk.pop();
            System.out.println(val);
        }



        return dist[destination];
    }
    int dijakstraAlgorithm(int source, int destination){
        boolean visited[] = new boolean[v];
        int dist[] = new int[v];
        int prevpath[] = new int[v];
        for(int i=0;i<v;i++){
            dist[i] = Integer.MAX_VALUE;
            prevpath[i] = -1;
        }
        dist[source] = 0;
        for(int i=0;i<v;i++){
            int u = findMinVertex(visited,dist);
            visited[u] = true;
            for(int j=0;j<v;j++){
                if(matrix[u][j]!=0){
                    if (!visited[j] && dist[u] + matrix[u][j]<dist[j]) {
                        dist[j] = dist[u] + matrix[u][j];
                        prevpath[j] = u;
                    }
                }
            }
        }
        Stack<Integer> stk = new Stack<Integer>();
        int temp = destination;
        stk.push(temp);
        while (prevpath[temp]!=-1) {
            temp = prevpath[temp];
            stk.push(temp);
            
        }
        while (!stk.isEmpty()) {
            System.out.println("printing path");
            int val = stk.pop();
            System.out.println(val);
            
        }

        return dist[destination];
    }
    int findMinVertex(boolean visited[],int [] dist){
        int minvertex = -1;
        for(int i = 0;i<v;i++){
            if(!visited[i] && dist[i] != Integer.MAX_VALUE && (minvertex ==-1 || dist[minvertex]>dist[i])){
                minvertex = i;
            }
        }
        return minvertex;
    }

    public static void main(String[] args) {
        AdjancencyMatrix adj = new AdjancencyMatrix(5);
        adj.addEdge(0, 1,5);
        // adj.addEdge(0, 2,5);
        // adj.addEdge(0, 5,5);
        // adj.addEdge();
        // adj.addEdge(2, 4);
        // adj.addEdge(3, 4);
        adj.printGraph();
        adj.getAdjNodes(1);
    }

}


//write itterative implementation of DFSalgorithm