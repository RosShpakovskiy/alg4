package alg4;

import java.util.*;

public class Dijkstra<V> extends Search<V> {
    private final Set<V> unsettledNodes;
    private final Map<V, Double> distances;
    private final WeightedGraph<V> graph;

    public Dijkstra(WeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;

        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0D);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            V currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add(currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex<V> neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor.getData());

                if (getShortestDistance(neighbor.getData()) > newDistance) {
                    distances.put(neighbor.getData(), newDistance);
                    edgeTo.put(neighbor.getData(), currentNode);
                    unsettledNodes.add(neighbor.getData());
                }

            }

        }
    }

    private double getDistance(V node, V target) {
        for (Map.Entry<Vertex<V>, Double> kvPair : graph.getEdges(node)) {
            if (kvPair.getKey().getData().equals(target)) {
                return kvPair.getValue();
            }
        }
        throw new RuntimeException("Not found!");
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null) {
                minimum = vertex;

                continue;
            }

            if (getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }

        return minimum;
    }

    private double getShortestDistance(V dest) {
        Double dist = distances.get(dest);

        return (dist == null ? Double.MAX_VALUE : dist);
    }
}
