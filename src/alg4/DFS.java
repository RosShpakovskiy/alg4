package alg4;

public class DFS<V> extends Search<V> {
    public DFS(MyGraph<V> graph, V source) {
        super(source);

        dfs(graph, source);
    }

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
