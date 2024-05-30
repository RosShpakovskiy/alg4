package alg4;

import java.util.*;

public class MyGraph<V> {
   private boolean directed;
   private Map<V, Vertex<V>> map = new HashMap<>();

    //constructor with default direction
   public MyGraph() {
       this.directed = false;
   }

   //overwrite constructor with direction
   public MyGraph(boolean directed) {
       this.directed = directed;
   }

   //creates new vertex
   public void addVertex(V data) {
       if (hasVertex(data))
           return;
       map.put(data, new Vertex<>(data));
   }

   //get data from a vertex
    public Vertex<V> getVertex(V data) {
        return map.get(data);
    }

    //add edge between two vertices. Create, if vertices don't exist
    //Weighted variant
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

   //Non-weighted variant
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

    //return list of vertices that have connection
    //with chosen vertex
    public List<Vertex<V>> adjacencyList(V v) {
        if (!hasVertex(v))
            return null;

        Set<Vertex<V>> vert = map.get(v).getAdjacentVertices().keySet();
        return new LinkedList<>(vert);
    }

    ////return list of vertices that have connection
    //with chosen vertex. Additional weight information
    public Iterable<Map.Entry<Vertex<V>, Double>> getEdges(V v) {
        if (!hasVertex(v))
            return null;

        return map.get(v).getAdjacentVertices().entrySet();
    }
}
