package alg4;

public class DFS<V> extends Search<V> {
    public DFS(MyGraph<V> graph, V source) {
        super(source);

        dfs(graph, source);
    }

    //starts from an initial vertex and goes down one path
    //until it reaches the end and if it doesn't reach a destination,
    //then it comes back and goes down a different path.
    private void dfs(MyGraph<V> graph, V current) {
        marked.add(current);

        for (Vertex<V> vertex : graph.adjacencyList(current)) {
            if (!marked.contains(vertex.getData())) {
                edgeTo.put(vertex.getData(), current);
                dfs(graph, vertex.getData());
            }
        }

    }
}
