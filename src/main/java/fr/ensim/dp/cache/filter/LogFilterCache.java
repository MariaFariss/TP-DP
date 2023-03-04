package fr.ensim.dp.cache.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogFilterCache implements IFilterCache{
    public IFilterCache next = null;

    private final static Logger LOGGER = LogManager.getLogger();
    int count;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        LOGGER.info("on ajoute ");
        if(next !=null){
            buf = next.doAdd(key, buf);
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next!=null){
            buf = next.doRetreive(key, buf);
        }
        LOGGER.info("on retreive  ");
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
}
