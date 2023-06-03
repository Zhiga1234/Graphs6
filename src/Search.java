import java.util.*;
public class Search<V> {
    protected int count;
    protected Set<V> marked;
    protected Map<V, V> edgeTo;
    protected final V source;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V v) {
        return marked.contains(v);
    }

    public Iterable<V> pathTo(V v) {
        if (!hasPathTo(v))
            return null;

        LinkedList<V> path = new LinkedList<>();
        V current = v;
        while (!current.equals(source)) {
            path.addFirst(current);
            current = edgeTo.get(current);
        }
        path.addFirst(source);

        return path;
    }

    public int getCount() {
        return count;
    }
}