public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();

        graph.addEdge("A", "B", 5.0);
        graph.addEdge("A", "C", 3.0);
        graph.addEdge("B", "D", 2.0);
        graph.addEdge("C", "D", 1.0);
        graph.addEdge("D", "E", 4.0);

        String source = "A";
        String destination = "E";

        DijkstraSearch<String> dijkstraSearch = new DijkstraSearch<>(graph, source);

        if (dijkstraSearch.hasPathTo(destination)) {
            System.out.println("Shortest path from " + source + " to " + destination + ":");
            for (String vertex : dijkstraSearch.pathTo(destination)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
            double distance = dijkstraSearch.getShortestDistance(destination);
            System.out.println("Total distance from " + source + " to " + destination + ": " + distance);
        } else {
            System.out.println("There is no path from " + source + " to " + destination);
        }
    }
}