import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Set<V> unsettledNodes;
    private Map<V, Double> distances;
    private Map<V, Vertex<V>> vertexMap; // Store vertices and their corresponding Vertex objects
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        vertexMap = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            V node = getVertexWithMinimumWeight(unsettledNodes);
            marked.add(node);
            unsettledNodes.remove(node);

            for (V target : graph.adjacencyList(node)) {
                double currentDistance = getShortestDistance(node) + getDistance(node, target);

                if (currentDistance < getShortestDistance(target)) {
                    distances.put(target, currentDistance);
                    edgeTo.put(target, node);
                    unsettledNodes.add(target);
                }
            }
        }
    }

    private double getDistance(V node, V target) {
        Vertex<V> vertex = vertexMap.get(node);
        if (vertex != null) {
            Double weight = vertex.getAdjacentVertices().get(vertexMap.get(target));
            if (weight != null) {
                return weight;
            }
        }
        // Edge not found, return a default value
        return Double.POSITIVE_INFINITY;
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    public double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.POSITIVE_INFINITY : d);
    }
}