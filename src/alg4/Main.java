package alg4;

public class Main {

    public static void main(String[] args) {

        /*
        According to the terms of the assignment,
        the code must work with the unchanged Main class
        from github. So I took it completely from there.
         */

        //At this stage of work I don't need to have full Main class
        //from github. I'm checking the correctness of my code.

        WeightedGraph<String> weightedGraph = new WeightedGraph<>(false);
        fillWithWeights(weightedGraph);

        System.out.println(weightedGraph.hasEdge("Almaty", "Astana")); //true
        System.out.println(weightedGraph.hasEdge("Astana", "Almaty")); //true
        System.out.println(weightedGraph.hasEdge("Uralsk", "Astana")); //false
        System.out.println(weightedGraph.hasEdge("Kyzylorda", "Astana")); //false

        System.out.println(weightedGraph.adjacencyList("Kyzylorda"));
        System.out.println(weightedGraph.adjacencyList("Uralsk"));

        System.out.println(weightedGraph.getEdges("Astana"));

        System.out.println("BFS:");
        Search<String> bfs = new BFS<>(weightedGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");

        System.out.println("Dijkstra:");
        Search<String> djk = new Dijkstra<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        /*
        System.out.println("--------------------------------");

        WeightedGraph<String> graph = new WeightedGraph<>(true);


        fillWithoutWeights(graph);

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println("--------------------------------");
         */
    }

    /*
    public static void fillWithoutWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana"); // 16 - 19
        graph.addEdge("Shymkent", "Atyrau");
        graph.addEdge("Atyrau", "Astana");
        graph.addEdge("Almaty", "Shymkent");
        graph.addEdge("Shymkent", "Astana");
        graph.addEdge("Astana", "Kostanay");
        graph.addEdge("Shymkent", "Kyzylorda");
    }
    */

    public static void fillWithWeights(WeightedGraph<String> graph) {
        graph.addEdge("Almaty", "Astana", 2.1);
        graph.addEdge("Shymkent", "Atyrau", 7.8);
        graph.addEdge("Atyrau", "Astana", 7.1);
        graph.addEdge("Almaty", "Shymkent", 7.2);
        graph.addEdge("Shymkent", "Astana", 3.9);
        graph.addEdge("Astana", "Kostanay", 3.5);
        graph.addEdge("Shymkent", "Kyzylorda", 5.4);
    }


    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }

}