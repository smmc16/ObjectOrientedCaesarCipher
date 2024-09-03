
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipherTwo {
    private int[] countLetters(String input) {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for(int i = 0; i < input.length(); i++){
            char ch = Character.toUpperCase(input.charAt(i));
            int index = alph.indexOf(ch);
            if(index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    
    private int indexOfMax(int[] values) {
        int max = 0;
        for(int i = 0; i < values.length; i++) {
            if(values[i] > values[max]){
                max = i;
            }
        }
        return max;
    }
    
    private String halfOfString(String message, int start) {
        StringBuilder string = new StringBuilder();
        for(int i = start; i < message.length(); i += 2){
                string.append(message.charAt(i));    
        }
        return string.toString();
    }
    
    private int getKey(String s) {
        int[] counts = countLetters(s);
        int max = indexOfMax(counts);
        int dkey = max - 4;
        if(max < 4) {
            dkey = 26 - (4 - max);
        }
        return dkey;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(14, 24);
        String encrypted = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("Encrypted: " + encrypted);
        String decrypted = cc.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy.");
        System.out.println("Decrypted: " + decrypted);
        System.out.println(breakCaesarCipher(text));
    }
    
    private String breakCaesarCipher(String input) {
        String string0 = halfOfString(input, 0);
        String string1 = halfOfString(input, 1);
        int key0 = getKey(string0);
        int key1 = getKey(string1);
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - key0, 26 - key1);
        String decrypted = cc.encrypt(input);
        return "Key 1: " + key0 + "\nKey 2: " + key1 + "\n" + decrypted;
    }
}
