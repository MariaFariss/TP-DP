package fr.ensim.dp.cache;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.Test;
import fr.ensim.dp.cache.filter.CompressFilterCache;
import fr.ensim.dp.cache.filter.CountFilterCache;
import fr.ensim.dp.cache.filter.LogFilterCache;
import fr.ensim.dp.cache.filter.CryptFilterCache;

public class FilterCacheTest {
    @Test
    public void testAll() {
        Memorycache.getInstance().setFilterCache(new CountFilterCache()).setNext(new LogFilterCache()).setNext(new CompressFilterCache()).setNext(new CryptFilterCache());
        byte[]  buf1 = {1,5,6};
        Memorycache.getInstance().add("1", buf1);
        assertArrayEquals(buf1,Memorycache.getInstance().retreive("1"));
        
    }
}
