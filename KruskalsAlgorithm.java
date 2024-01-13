import java.util.*;
class KruskalsAlgorithm{
    
    static class DisjointSet{    // TC is O(4)
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n){
            for(int i = 0; i <= n; i++){
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node){
            if(node == parent.get(node)) return node;
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }
        
        
        public void unionByRank(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u) < rank.get(ulp_v)) parent.set(ulp_u, ulp_v);
            else if(rank.get(ulp_v) < rank.get(ulp_u)) parent.set(ulp_v, ulp_u);
            else{
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
        

        public void unionBySize(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(size.get(ulp_u) < size.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
            }
            else{
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }
    
    
    static class Edge implements Comparable<Edge>{
        int src;
        int des;
        int weight;
        Edge(int src, int des, int weight){
            this.src = src;
            this.des = des;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge){
            return this.weight - compareEdge.weight;
        }
    }
    
    
	static int spanningTree(int V, int E, int edges[][]){
	   List<Edge> ed = new ArrayList<Edge>();
        for(int i = 0; i < E; i++){
           
                int adjNode = edges [i] [1];
                int edgeWeight = edges [i] [2];
                int node = edges [i] [0];
                Edge temp = new Edge(node, adjNode, edgeWeight);
                ed.add(temp);
        }
        
        
        DisjointSet ds = new DisjointSet(V);
        Collections.sort(ed);
        int sum = 0;
        for(int i = 0; i < ed.size(); i++){
            int u = ed.get(i).src;
            int v = ed.get(i).des;
            int wt = ed.get(i).weight;
            if(ds.findUPar(u) != ds.findUPar(v)){
                sum += wt;
                ds.unionBySize(u, v);
            }
        }
        return sum;
	}
}