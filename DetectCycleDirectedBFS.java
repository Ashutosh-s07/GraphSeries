import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int indegree[] = new int[V];
        for( int i=0;i<V;i++ ){
            for( int it:adj.get(i)){ indegree[it]++; }
        }

        Queue<Integer> q = new LinkedList<>();
        for( int i=0;i<V;i++ ){
            if( indegree[i] == 0 ) q.add(i);
        }
        int[] topo = new int[V];
        int ind = 0;
        while ( !q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo[ind++] = node;
            for( int it:adj.get(node) ){
                indegree[it]--;
                if( indegree[it] == 0 ) q.add(it); 
            }
        }

        if( ind == V ) return false;
        return true;

    }
}
