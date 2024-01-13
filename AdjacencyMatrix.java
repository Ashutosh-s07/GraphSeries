import java.util.Scanner;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        // adjacency matrix for undirected graph
        // time complexity: O(n)
        int[][] adj = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u, v;
            u = scanner.nextInt();
            v = scanner.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;  // this statement will be removed in case of a directed graph
        }

        // Your further logic can go here

        scanner.close();
    }
}
