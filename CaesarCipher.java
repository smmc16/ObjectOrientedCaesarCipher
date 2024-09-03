
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < input.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar)) {
                int idx = alphabet.indexOf(currChar);
                if(idx != -1) {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                int idx = alphabet.toLowerCase().indexOf(currChar);
                if(idx != -1) {
                    char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String decrypted = cc.encrypt(input);
        return decrypted;
    }
}
