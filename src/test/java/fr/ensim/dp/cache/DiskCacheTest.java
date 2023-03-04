package fr.ensim.dp.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DiskCacheTest {
    byte[] b = {4,5,6,7};
    ICache cache = DiskCache.getInstance("C:\\Users\\Maria_Pamda\\Documents\\4A\\s8\\Mapnik");
    
    @Test
    void testAdd() {
        cache.add("tuile1", b);
        assertEquals(4, cache.size());
    }
    
    @Test
    void testRetreive() {
        cache.add("tuile1", b);
        assertArrayEquals(b, cache.retreive("tuile1"));
    }   


}
