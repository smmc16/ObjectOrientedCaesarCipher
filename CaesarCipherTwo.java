
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(i % 2 == 0) {
                if(Character.isUpperCase(currChar)) {
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1) {
                        char newChar = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    int idx = alphabet.indexOf(Character.toUpperCase(currChar));
                    if(idx != -1) {
                        char newChar = shiftedAlphabet1.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            } else {
                if(Character.isUpperCase(currChar)) {
                    int idx = alphabet.indexOf(currChar);
                    if(idx != -1) {
                        char newChar = shiftedAlphabet2.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                } else {
                    int idx = alphabet.indexOf(Character.toUpperCase(currChar));
                    if(idx != -1) {
                        char newChar = shiftedAlphabet2.toLowerCase().charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}
