package fr.ensim.dp.cache;

public class CacheFactory implements IFactory {

    private static CacheFactory singleton;

    private CacheFactory(){
        
    }

    public static CacheFactory getInstance(){
        if(singleton==null){
            singleton = new CacheFactory();
        }
        return singleton;
    }
    @Override
    public ICache getDiskCache(String typemap) {

        return DiskCache.getInstance(typemap);
    }

    @Override
    public ICache getMemoryCache() {

        return Memorycache.getInstance();
    }

    
}
