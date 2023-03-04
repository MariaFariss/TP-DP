package fr.ensim.dp.cache;

import fr.ensim.dp.cache.filter.IFilterCache;

import java.util.HashMap;
import java.util.Map;

public class Memorycache implements ICache {
    private Map<String, byte[]> map;
    IFilterCache filtercache = null;
    private static Memorycache singleton;

    private Memorycache(){
        map = new HashMap<>();
    }

    public static Memorycache getInstance(){
        if(singleton == null){
            singleton = new Memorycache();
        }
        return singleton;
    }
    @Override
    public long size() {
        long s = 0;
        for(Map.Entry<String, byte[]> m : map.entrySet()){
            s += m.getValue().length;
        }
        return s;
    }

    @Override
    public boolean add(String key, byte[] buf) {
        if(!map.containsKey(key) ){
            if(filtercache != null) {
                map.put(key, filtercache.doAdd(key, buf));
            }
            else {
                map.put(key,buf);
            }
            return true;
        }
       return false;
    }

    @Override
    public byte[] retreive(String key) {
        if(filtercache != null){
            return filtercache.doRetreive(key, map.get(key));
        }
        else {
            return map.get(key);
        }

    }

    @Override
    public void clear() {
        map.clear();       
    }

    @Override
    public IFilterCache setFilterCache(IFilterCache filterCache) {
        filtercache = filterCache;
        return filterCache;
    }

}
