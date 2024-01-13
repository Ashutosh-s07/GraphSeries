import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyListsDirectedgraphs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Adjacency list for directed graph
        // Time complexity: O(E)
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            // u —> v
            adj[u].add(v);
        }

        // Your code logic here

        scanner.close();
    }
}
