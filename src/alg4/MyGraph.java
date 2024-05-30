package alg4;

import java.util.*;

public class MyGraph<V> {
   private boolean directed;
   private Map<V, Vertex<V>> map = new HashMap<>();

   public MyGraph() {
       this.directed = false;
   }

   public MyGraph(boolean directed) {
       this.directed = directed;
   }

   public void addVertex(V data) {
       if (hasVertex(data))
           return;
       map.put(data, new Vertex<>(data));
   }

    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

   public void addEdge(V source, V destination, double weight) {
       if (!hasVertex(source))
           addVertex(source);

       if (!hasVertex(destination))
           addVertex(destination);

       if (hasEdge(source, destination) || source.equals(destination))
           return;

       map.get(source).addAdjacentVertex(map.get(destination), weight);

       if (!directed)
           map.get(destination).addAdjacentVertex(map.get(source), weight);
   }

    public void addEdge(V source, V destination) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(destination))
            addVertex(destination);

        if (hasEdge(source, destination) || source.equals(destination))
            return;

        map.get(source).addAdjacentVertex(map.get(destination), 0);

        if (!directed)
            map.get(destination).addAdjacentVertex(map.get(source), 0);
    }

   private boolean hasVertex(V data) {
       return map.containsKey(data);
   }

   public boolean hasEdge(V source, V destination) {
       if (!hasVertex(source) || !hasVertex(destination))
           return false;

       return map.get(source).getAdjacentVertices().containsKey(map.get(destination));
   }

    public List<Vertex<V>> adjacencyList(V v) {
        if (!hasVertex(v))
            return null;

        Set<Vertex<V>> vert = map.get(v).getAdjacentVertices().keySet();
        return new LinkedList<>(vert);
    }

    public Iterable<Map.Entry<Vertex<V>, Double>> getEdges(V v) {
        if (!hasVertex(v))
            return null;

        return map.get(v).getAdjacentVertices().entrySet();
    }
}
