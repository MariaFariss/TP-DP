package fr.ensim.dp.cache;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import fr.ensim.dp.cache.filter.IFilterCache;
import fr.ensim.dp.util.FileUtil;

public class DiskCache implements ICache {

    private File file;
    private IFilterCache filterCache ;
    private static Map<String, DiskCache> caches = new HashMap<>();

    private DiskCache(String mapType){ 
        file = new File(mapType);
        file.mkdir();
    }

    public static DiskCache getInstance(String typemap){
        if (!caches.containsKey(typemap)) {
            caches.put(typemap, new DiskCache(typemap));
        }
        return caches.get(typemap);
    }

    @Override
    public long size() {

        return FileUtil.dirLength(file);
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if (filterCache != null) {
            return FileUtil.copy(new ByteArrayInputStream(filterCache.doAdd(key, buf)), new File(file, key));
        }
        return FileUtil.copy(new ByteArrayInputStream(buf), new File(file, key));
    }

    @Override
    public byte[] retreive(String key) {
        byte[] b = null;
        try {
            if(filterCache != null) {
                b = filterCache.doRetreive(key,FileUtil.readFile(new File(file, key))) ;
            }
            else {
                b = FileUtil.readFile(new File(file, key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public void clear() {

        FileUtil.deleteDirectory(file);
    }

    @Override
    public IFilterCache setFilterCache(IFilterCache filterCache) {
        this.filterCache = filterCache;
        return filterCache;

    }

}
