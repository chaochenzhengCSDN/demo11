package com.util;

import com.sun.crypto.provider.SunJCE;
import sun.security.jca.ProviderList;
import sun.security.jca.Providers;
import sun.security.provider.Sun;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * @date 2020-08-17
 * @des aes加密解密
 * @author Administrator
 */
public class AES {
    public static String encrypt(String param1,String param2){
        byte[] arrBytes=null;
        try {
            KeyGenerator localKeyGenerator=KeyGenerator.getInstance("AES");
            SecureRandom localsSecureRandom=SecureRandom.getInstance("SHA1PRNG");
            localsSecureRandom.setSeed(param2.getBytes());
            localKeyGenerator.init(128,localsSecureRandom);
            SecretKey localSecretKey=localKeyGenerator.generateKey();
            byte[] arrayOfByte2 = localSecretKey.getEncoded();
            SecretKeySpec localSecretKeySpec=new SecretKeySpec(arrayOfByte2,"AES");
            Cipher localCipher =Cipher.getInstance("AES", "SunJCE");
            byte[] arrayOfByte3 = param1.getBytes();
            localCipher.init(1,localSecretKeySpec);
            arrBytes = localCipher.doFinal(arrayOfByte3);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            e.getLocalizedMessage();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return arrBytes == null ? "" : parseByte2HexStr(arrBytes);
    }

    public static String decrypt(String paramString1, String paramString2)
    {
        byte[] arrayOfByte1 = null;
        byte[] arrayOfByte2 = parseHexStr2Byte(paramString1);
        try {
            KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom localSecureRandom = SecureRandom.getInstance("SHA1PRNG");
            localSecureRandom.setSeed(paramString2.getBytes());
            localKeyGenerator.init(128, localSecureRandom);

            SecretKey localSecretKey = localKeyGenerator.generateKey();
            byte[] arrayOfByte3 = localSecretKey.getEncoded();
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(arrayOfByte3, "AES");
            Cipher localCipher = Cipher.getInstance("AES", "SunJCE");
            localCipher.init(2, localSecretKeySpec);
            arrayOfByte1 = localCipher.doFinal(arrayOfByte2);
        } catch (NoSuchProviderException localNoSuchProviderException) {
            localNoSuchProviderException.printStackTrace();
        } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
            localNoSuchAlgorithmException.printStackTrace();
        } catch (NoSuchPaddingException localNoSuchPaddingException) {
            localNoSuchPaddingException.printStackTrace();
        } catch (InvalidKeyException localInvalidKeyException) {
            localInvalidKeyException.printStackTrace();
        } catch (IllegalBlockSizeException localIllegalBlockSizeException) {
            localIllegalBlockSizeException.printStackTrace();
        } catch (BadPaddingException localBadPaddingException) {
            localBadPaddingException.printStackTrace();
        }
        return arrayOfByte1 == null ? "" : new String(arrayOfByte1);
    }

    private static String parseByte2HexStr(byte[] paramArrayOfByte)
    {
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; i < paramArrayOfByte.length; i++) {
            String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
            if (str.length() == 1) {
                str = '0' + str;
            }
            localStringBuffer.append(str.toUpperCase());
        }
        return localStringBuffer.toString();
    }

    private static byte[] parseHexStr2Byte(String paramString)
    {
        if (paramString.length() < 1) {
            return null;
        }
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        for (int i = 0; i < paramString.length() / 2; i++) {
            int j = Integer.parseInt(paramString.substring(i * 2, i * 2 + 1), 16);
            int k = Integer.parseInt(paramString.substring(i * 2 + 1, i * 2 + 2), 16);

            arrayOfByte[i] = ((byte)(j * 16 + k));
        }
        return arrayOfByte;
    }

    static
    {
        if (null == Security.getProvider("SunJCE")) {
            Security.addProvider(new SunJCE());
        }

        if (null == Security.getProvider("SUN")) {
            Security.addProvider(new Sun());
        }
    }


    public static void main(String[] args) {
        String res=encrypt("a","1");
        System.out.println("res = " + res);
        System.out.println("res.length() = " + res.length());
        String res1 = decrypt("FA108F0C8DE1AA54A9501DBB53B9EF42","1");
        System.out.println("res1 = " + res1);
        //将二进制转换成十六进制
        String str = Integer.toHexString(-1 & 0xFF);
        System.out.println("str = " + str);
    }
}
