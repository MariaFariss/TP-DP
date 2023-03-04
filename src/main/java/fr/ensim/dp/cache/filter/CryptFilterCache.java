package fr.ensim.dp.cache.filter;

import javax.crypto.Cipher;

import fr.ensim.dp.util.AESCryptoUtil;

public class CryptFilterCache implements IFilterCache{
    IFilterCache next = null;
    //AES block = new AES();

    @Override
    public byte[] doAdd(String key, byte[] buf) {
        //encrypte
        try {
             buf = AESCryptoUtil.cryptOrDecryptFile(Cipher.ENCRYPT_MODE, key, buf);
            //buf = AESCryptoUtil.encryptAES(buf, AESCryptoUtil.KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(next !=null){
            buf = next.doAdd(key, buf);
        }
        return buf;
    }
    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        if(next !=null){
            buf = next.doAdd(key, buf);
        }
        //decrypte
        try {
             buf = AESCryptoUtil.cryptOrDecryptFile(Cipher.DECRYPT_MODE, key, buf);
            //buf = AESCryptoUtil.decryptAES(buf, AESCryptoUtil.KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
}
