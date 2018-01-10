import org.junit.Test;

import java.io.*;

public class CaesarCipher {

    private void encrypt(String phrase, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encr = alphabet.substring(key);
        encr += alphabet.substring(0,key);
        System.out.println(encr);

        StringBuilder encryptedString = new StringBuilder();
        encryptedString.append("");

        for(int i=0;i<phrase.length();i++){
            char c =phrase.charAt(i);
            boolean isLowerCase = Character.isLowerCase(c);
            if(isLowerCase){c = Character.toUpperCase(c);}
            if(alphabet.indexOf(c) >= 0) {
                int index = alphabet.indexOf(c);
                char encryptedChar = encr.charAt(index);
                if(isLowerCase) {
                    encryptedChar = Character.toLowerCase(encryptedChar);
                    encryptedString.append(encryptedChar);
                } else encryptedString.append(encryptedChar);
            } else encryptedString.append(c);
        }

        System.out.println(encryptedString);
    }

    private void encryptTwoKeys(String phrase, int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encr1 = alphabet.substring(key1);
        encr1 += alphabet.substring(0,key1);

        String encr2 = alphabet.substring(key2);
        encr2 += alphabet.substring(0,key2);

        StringBuilder encryptedString = new StringBuilder();
        encryptedString.append("");

        for(int i=0;i<phrase.length();i++) {
            char c = phrase.charAt(i);
            boolean isLowerCase = Character.isLowerCase(c);
            if(isLowerCase){c = Character.toUpperCase(c);}
            if (alphabet.indexOf(c) >= 0) {
                    char encryptedChar;
                    int index = alphabet.indexOf(c);
                    if (i == 0 || i % 2 == 0) {
                        encryptedChar = encr1.charAt(index);
                                          if(isLowerCase){encryptedChar= Character.toLowerCase(encryptedChar);
                            encryptedString.append(encryptedChar);}
                        else encryptedString.append(encryptedChar);
                    } else if (i % 2 == 1) {
                        encryptedChar = encr2.charAt(index);
                        if(isLowerCase){encryptedChar= Character.toLowerCase(encryptedChar);
                            encryptedString.append(encryptedChar);}
                        else encryptedString.append(encryptedChar);
                    }
            } else encryptedString.append(c);
        }
        System.out.println(encryptedString);
    }

    public void decrypt(String encryptedPhrase,int encryptKey){
        int decryptkey = 26 - encryptKey;
        int neg = -1;
        if(decryptkey <0){decryptkey *= neg;}
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encr = alphabet.substring(decryptkey);
        encr += alphabet.substring(0,decryptkey);

        StringBuilder decryptedString = new StringBuilder();
        decryptedString.append("");

        for(int i=0;i<encryptedPhrase.length();i++) {
            char c = encryptedPhrase.charAt(i);
            boolean isLowerCase = Character.isLowerCase(c);
            if (isLowerCase) {
                c = Character.toUpperCase(c);
            }
            if (alphabet.indexOf(c) >= 0) {
                int index = alphabet.indexOf(c);
                char decryptedChar = encr.charAt(index);
                if (isLowerCase) {
                    decryptedChar = Character.toLowerCase(decryptedChar);
                    decryptedString.append(decryptedChar);
                } else decryptedString.append(decryptedChar);
            } else decryptedString.append(c);
        }
        System.out.println(encryptKey + " " + decryptedString);
    }

    public void bruteForce(String encryptedPhrase) {
        int decryptkey = 0;
        for (int i = 0; i < 26; i++) {
            decrypt(encryptedPhrase, decryptkey);
            decryptkey++;
        }
    }

    @Test
    public void testEncrypt(){
        encrypt("Encryption and security are fundamental parts of today's Internet.",7);
    }

    @Test
    public void testEncryptTwoKeys(){
        encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD",8,21);
    }

    @Test
    public void testDecrypt(){
        decrypt("Ftue ue m ndgfqradoq fqef. Wqk ue dmzpay.", 12);
    }

    @Test
    public void testBruteForcre(){
        bruteForce("Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula.");
    }
}
