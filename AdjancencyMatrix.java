import java.util.*;

public class AdjancencyMatrix {
    int v;
    int[][] matrix;
    Edge edges[];

    public static class Edge implements Comparable<Edge>{
        int u,v,w;
        public Edge(int u, int v,int w){
            this.u=u;
            this.v =v;
            this.w =w;
        }

        @Override
        public int compareTo(Edge o){
            return this.w-o.w;
        }
    }

    // initialize matrix
    AdjancencyMatrix(int v) {
        this.v = v;
        matrix = new int[v][v];
        edges = new Edge[v*(v-1)/2];
    }

    //edge counter:
    int edgeCount = -1;

    // add edgegs
    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

    void populateEdgesList(){
        for(int i =0;i<v;i++){
            for(int j=0;j<v;j++){
                if(matrix[i][j]!=0){
                    edges[++edgeCount] = new Edge(i, j, matrix[i][j]);
                }
            }
        }
    }
    //::KRUSHKALL'S ALGORITHM::
    void kruskal(){
        int mst[][] = new int[v][v];
        int parent[] = new int[v];
        int size[] = new int[v];
        for(int i= 0;i<v;i++){
            parent[i] = -1;
        }
        int edgeCounter = 0;
        int edgeTaken = 1;
        Arrays.sort(edges);
        while(edgeTaken<v){ //if edgeTaken was equal to 0 then in condition it should be (edgeTaken<v-1)
            Edge edge = edges[edgeCounter];
            edgeCounter++;
            if(isCycleDetected(edge.u,edge.v,parent)){
                continue;
            }
            union(find(edge.u,parent), find(edge.v, parent), size, parent);
            mst[edge.u][edge.v] = edge.w;
            mst[edge.v][edge.u] = edge.w;
            edgeTaken++;
        }
    }

    //TO DETECT IF THE CYCLE EXISTS IN A GRAPH OR NOT::
    boolean isCycleDetected(int u,int v,int[] parent){
        return find(u,parent) == find(v,parent);
    }

    int find(int x, int parent[]){
        if(parent[x]==-1){
            return x;
        }
        return parent[x] = find(parent[x],parent);
    }
    void union(int uabsroot, int vabsroot, int[] size,int[] parent){
        if(size[uabsroot]>size[vabsroot]){
            parent[vabsroot] = uabsroot;
            
        }
        else if(size[vabsroot]>size[uabsroot]){
            parent[uabsroot] = vabsroot;

        }else{
            parent[vabsroot] = uabsroot;
            size[uabsroot]++;
        }

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

    int topologicalSorting(){
        int indegree[] = new int[v];
        for(int i = 0; i<v;i++){
            for(int j = 0; j<v;j++){
                if(matrix[i][j]!=0){
                    indegree[j]++;
                }
            }

        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            int u = q.poll();
            System.out.println(q);
            for(int j = 0; j<v;j++){
                if(matrix[u][j]!=0){
                    indegree[j]--;
                    if(indegree[j]==0){
                        q.add(j);
                    }
                }
            }
        }
        if(cnt!=v){
            return 1;
        }
        return -1;
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