package fr.ensim.dp.cache.filter;
public class CountFilterCache implements IFilterCache{
    int count =0;
    public IFilterCache next = null;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        count++;
        if(next!=null){
            buf = next.doAdd(key, buf);
        }
        return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next!=null){
            buf = next.doRetreive(key, buf);
        }
        count++;
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
}
