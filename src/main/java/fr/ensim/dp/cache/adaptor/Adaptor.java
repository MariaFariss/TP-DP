package fr.ensim.dp.cache.adaptor;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.imageio.ImageIO;

import org.jdesktop.swingx.mapviewer.TileCache;

import fr.ensim.dp.cache.ICache;

public class Adaptor extends TileCache {

    private ICache cache;

    public Adaptor(ICache cache) {
        this.cache = cache;
    }

    @Override
    public BufferedImage get(URI arg0) throws IOException {
        byte[] bytes = cache.retreive(arg0.toString());
        InputStream is = new ByteArrayInputStream(bytes);
        BufferedImage newBi = ImageIO.read(is);

        return newBi;
    }
    

    @Override
    public void needMoreMemory() {
        cache.clear();
    }

    @Override
    public void put(URI arg0, byte[] arg1, BufferedImage arg2) {
        cache.add(arg0.toString(), arg1);
    }
    
}
