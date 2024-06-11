public class DisjointSet {
    int [] size;
    int parent[];
    int v;
    DisjointSet(int v){
        this.v = v;
        size = new int[v];
        parent = new int[v];
        for(int i = 0;i<v;i++){
            parent[-1] = -1;
        }
    }

    void findCycle(int u,int v){
        int uabsroot = find(u);
        int vabsroot = find(v);
        if(uabsroot == vabsroot){
            System.out.println("cycle detected");
            return;
        }
        union(uabsroot,vabsroot);

    }

    void union(int uabsroot, int vabsroot){
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

    int find(int x){
        if(parent[x]==-1){
            return x;
        }
        return parent[x] = find(parent[x]);

    }

    public static void main(String[] args) {
        DisjointSet d =new DisjointSet(4);
        d.findCycle(0,1);
        d.findCycle(0, 2);
        d.findCycle(0, 3);
        d.findCycle(1, 3);
    }
}
