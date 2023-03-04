package fr.ensim.dp.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCryptoUtil {

    /**
     * Permet de chiffrer ou déchiffrer un fichier
     * 
     * @param mode     chiffrer (1) ou déchiffrer (2)
     * @param password Le mot de passe
     * @param input    Le fichier à chiffrer ou à déchiffrer
     * @param output   Le fichier chiffrer ou déchiffrer
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     * @throws IOException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws Exception
     * 
     * @see Cipher.ENCRYPT_MODE
     * @see Cipher.DECRYPT_MODE
     * 
     */
    public static byte[] cryptOrDecryptFile(int mode, String password, byte[] input) throws NoSuchAlgorithmException,
    NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secret = generateSecretKeyWithPassword(password);
        /* Utilisation de l'algorithme AES */
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(mode, secret);
        /* Chiffre ou déchiffre le contenu du fichier */
        byte[] resultContent = aesCipher.doFinal(input);
        return resultContent;
    }

    /**
     * Génère une clé secrète avec le mot de passe
     * 
     * @param password Le mot de passe à transformer en clé de chiffrement
     * @return La clé générée à partir du mot de passe
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static SecretKey generateSecretKeyWithPassword(String password)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {

        /* une clé de 256 bits pour l'algorithme AES-256 */
        MessageDigest sha = MessageDigest.getInstance("MD5");
        /*
         * On prend les bytes du fichier. Le charset UTF-8 est important en cas
         * d'accentuation des caractères dans le mot de passe
         */
        byte[] key = sha.digest(password.getBytes("UTF-8"));
        SecretKey secret = new SecretKeySpec(key, "AES");
        return secret;
    }
}


// package fr.ensim.dp.util;

// import java.io.UnsupportedEncodingException;
// import java.security.MessageDigest;
// import java.security.NoSuchAlgorithmException;

// import javax.crypto.Cipher;
// import javax.crypto.spec.SecretKeySpec;

// public class AESCryptoUtil {

//     public static final String KEY = "test";

//     /**
//      * Fournit une chaine de caractère en utilisant le hashage MD5
//      *
//      * @param toEncrypt : texte à chiffrer
//      */
//     private static SecretKeySpec getKey(String secretKey) {
//         MessageDigest digest = null;
//         try {
//             digest = MessageDigest.getInstance("MD5");

//         } catch (NoSuchAlgorithmException e) {
//             throw new RuntimeException(e);
//         }

//         try {
//             return new SecretKeySpec(digest.digest(new String(secretKey.getBytes(), "UTF8").getBytes()), "AES");
//         } catch (UnsupportedEncodingException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

//     /**
//      * Chiffre une chaine de caractère en utilisant l'algo AES128
//      * 
//      * @param toEncrypt : texte à chiffrer
//      */
//     public static byte[] encryptAES(byte[] toEncrypt, String secretKey) {
//         byte[] encrypted = null;
//         try {
//             // Instantiate the cipher
//             Cipher cipher = Cipher.getInstance("AES");
//             cipher.init(Cipher.ENCRYPT_MODE, getKey(secretKey));
//             // Récupère la clé secrète
//             return cipher.doFinal(toEncrypt);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return encrypted;
//     }

//     /**
//      * Dechiffre une chaine de caractère en utilisant l'algo AES128
//      * 
//      * @param toDecrypt
//      */
//     public static byte[] decryptAES(byte[] toDecrypt, String secretKey) {
//         byte[] decrypted = null;
//         try {
//             // Instantiate the cipher
//             Cipher cipher = Cipher.getInstance("AES");
//             cipher.init(Cipher.DECRYPT_MODE, getKey(secretKey));
//             return cipher.doFinal(toDecrypt);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         return decrypted;
//     }

