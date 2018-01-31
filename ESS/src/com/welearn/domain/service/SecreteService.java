/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.welearn.domain.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Alexander
 */
public class SecreteService {
    
    public static SecreteService intance = new SecreteService();
    private static final String SECRETE_PATH = "com/welearn/resources/key.sec";
    private boolean launch;
    private String copyRight;
    private SecreteService()
    {
        Path temp;
        try {
            temp = Files.createTempFile(String.valueOf(System.currentTimeMillis()), ".ext");
            Files.copy(SecreteService.class.getClassLoader().getResourceAsStream(SECRETE_PATH), temp, StandardCopyOption.REPLACE_EXISTING);
            List<String> lines = Files.readAllLines(temp);
            if (lines.get(0).equals(encrypt(Configuration.AUTHOR)))
            {
                setLaunch(true);
                setCopyRight(decrypt(lines.get(1)));
            }
            else
            {
                setLaunch(false);
                setCopyRight("illegal usage");
            }
        } catch (IOException ex) {
            Logger.getLogger(SecreteService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SecreteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static Key generateKey() throws Exception {
        return new SecretKeySpec(Configuration.keyValue, Configuration.ALGO);
}
    
    public static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Configuration.ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encVal);
}
    
    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Configuration.ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
}

    /**
     * @return the launch
     */
    public boolean isLaunch() {
        return launch;
    }

    /**
     * @param launch the launch to set
     */
    public void setLaunch(boolean launch) {
        this.launch = launch;
    }

    /**
     * @return the copyRight
     */
    public  String getCopyRight() {
        return copyRight;
    }

    /**
     * @param copyRight the copyRight to set
     */
    public  void setCopyRight(String _copyRight) {
        this.copyRight = _copyRight;
    }
}
