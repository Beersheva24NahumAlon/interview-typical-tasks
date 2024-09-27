package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    private int size;
    private LinkedHashMap<String, Connection> map;

    public int getSize() {
        return size;
    }

    public LinkedHashMap<String, Connection> getMap() {
        return map;
    }

    public ConnectionPool(int size) {
        this.size = size;
        map = new LinkedHashMap<>(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry) {
                return size() > size;
            }
        };
    }

    public void addConnection(Connection connection) {
        if (map.containsValue(connection)) {
            throw new IllegalStateException();
        }
        String connectionId = connection.connectionId();
        map.putIfAbsent(connectionId, connection);   
    }

    public Connection getConnection(String connectionId) {
        if (!map.containsKey(connectionId)) {
            throw new NoSuchElementException();
        }
        return map.get(connectionId);
    }
}
