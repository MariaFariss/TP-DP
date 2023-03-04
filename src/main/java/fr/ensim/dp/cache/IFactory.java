package fr.ensim.dp.cache;

public interface IFactory {
    ICache getDiskCache(String typemap);
    ICache getMemoryCache();
}
