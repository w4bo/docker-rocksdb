import org.junit.jupiter.api.*;
import org.rocksdb.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RocksDBTest {
    private RocksDB db;
    private Options options;

    static {
        RocksDB.loadLibrary();
    }

    @BeforeAll
    void setUp() throws RocksDBException {
        options = new Options().setCreateIfMissing(true);
        db = RocksDB.open(options, "testdb");
    }

    @Test
    void testPutAndGet() throws RocksDBException {
        byte[] key = "key1".getBytes();
        byte[] value = "value1".getBytes();
        db.put(key, value);
        byte[] retrievedValue = db.get(key);
        assertNotNull(retrievedValue);
        assertEquals("value1", new String(retrievedValue));
    }

    @Test
    void testDelete() throws RocksDBException {
        byte[] key = "key1".getBytes();

        db.delete(key);
        byte[] retrievedValue = db.get(key);

        assertNull(retrievedValue);
    }

    @AfterAll
    void tearDown() throws RocksDBException {
        db.close();
        options.close();
    }
}
