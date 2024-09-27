package telran.interview;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

public class ConnectionPoolTest {
    String[] connectionIds = { "123", "sdv", "435" };
    ConnectionPool connectionPool;

    @BeforeEach
    private void setUpConnectionPool() {
        connectionPool = new ConnectionPool(3);
        Arrays.stream(connectionIds).forEach(s -> connectionPool.addConnection(new Connection(s)));
    }

    @Test
    void setUpConnectionPoolTest() {
        runAssertion(connectionIds, connectionPool);
    }

    private void runAssertion(String[] array, ConnectionPool connectionPool) {
        assertArrayEquals(array, connectionPool.getMap().keySet().toArray());
    }

    @Test
    void addConnectionTest() {
        String[] expected = { "sdv", "435", "hgf" };
        connectionPool.addConnection(new Connection("hgf"));
        assertThrowsExactly(IllegalStateException.class,
        () -> connectionPool.addConnection(new Connection("435")));
        runAssertion(expected, connectionPool);
    }

    @Test
    void getConnectionTest() {
        String[] expected = { "sdv", "435", "123" };
        connectionPool.getConnection("123");
        runAssertion(expected, connectionPool);
        assertThrowsExactly(NoSuchElementException.class,
                () -> connectionPool.getConnection("111"));
    }
}
