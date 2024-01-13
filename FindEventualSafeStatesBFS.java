import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindEventualSafeStatesBFS {
    public List<Integer> eventualSafeNodesBFS(int[][] graph) {
        
        int V = graph.length;

        List<List<Integer>> adjREv = new ArrayList<>();
        for( int i=0;i<V;i++ ){
            adjREv.add( new ArrayList<>());
        }
        int indegree[] = new int[V];
        for( int i=0;i<V;i++ ){
            for( int it:graph[i]){ 
                adjREv.get(it).add(i);
                indegree[i]++; 
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for( int i=0;i<V;i++ ){
            if( indegree[i] == 0 ) q.add(i);
        }
        while ( !q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for( int it:adjREv.get(node) ){
                indegree[it]--;
                if( indegree[it] == 0 ) q.add(it); 
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
