import java.util.*;

class AdjacencyArray {
    private int[][] arrGraph;

    public AdjacencyArray(int initSize) {
        this.arrGraph = new int[initSize+1][initSize+1];
    }

    public int[][] getGraph() {
        return this.arrGraph;
    }

    public void put(int x, int y) {
        arrGraph[x][y] = arrGraph[y][x] = 1;
    }

    public void printAll() {
        for (int i = 1; i < getGraph().length; i++) {
            for (int j = 1; j < arrGraph[i].length; j++) {
                System.out.printf("%d ", arrGraph[i][j]);
            }
            System.out.println();
        }
    }
}

public class GraphSearch {
    
    void dfsWithStack(int[][] arr) {
        boolean[] visited = new boolean[9];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int x = stack.pop();
            System.out.print(x + " ");

            for (int i = 0; i < arr[x].length; i++) {
                if (arr[x][i] == 1 && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    boolean[] visited = new boolean[9];
    void dfsWithRecursive(int[][] arr, int x) {
        visited[x] = true;
        System.out.print(x + " ");

        for (int i = 0; i < arr[x].length; i++) {
            if (arr[x][i] == 1 && !visited[i]) {
                dfsWithRecursive(arr, i);
            }
        }
    }

    void bfs(int[][] arr) {
        boolean[] visited = new boolean[9];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int x = queue.remove();
            System.out.print(x + " ");

            for (int i = 0; i < arr[x].length; i++) {
                if (arr[x][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyArray adjacencyArray = new AdjacencyArray(8);
        adjacencyArray.put(0, 1);
        adjacencyArray.put(1, 2);
        adjacencyArray.put(1, 3);
        adjacencyArray.put(2, 3);
        adjacencyArray.put(2, 4);
        adjacencyArray.put(3, 4);
        adjacencyArray.put(3, 5);
        adjacencyArray.put(5, 6);
        adjacencyArray.put(5, 7);
        adjacencyArray.put(6, 8);
        //adjacencyArray.printAll();

        GraphSearch graph = new GraphSearch();

        graph.dfsWithStack(adjacencyArray.getGraph());
        System.out.println();
        
        graph.dfsWithRecursive(adjacencyArray.getGraph(), 0);
        System.out.println();
        
        graph.bfs(adjacencyArray.getGraph());
    }

}