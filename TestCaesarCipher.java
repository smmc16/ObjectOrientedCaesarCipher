
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class TestCaesarCipher {
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
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String text = fr.asString();
        CaesarCipher cc = new CaesarCipher(15);
        String encrypted = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
        System.out.println("Encrypted: " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println(breakCaesarCipher(encrypted));
    }
    
    private String breakCaesarCipher(String input) {
        int[] freqs = countLetters(input);
        int maxIndex = indexOfMax(freqs);
        int dkey = maxIndex - 4;
        if(maxIndex < 4) {
            dkey = 26 - (4 - maxIndex);
        }
        System.out.println("Key: " + dkey);
        CaesarCipher cc = new CaesarCipher(dkey);
        return "Key: " + dkey + "\nBroken: " + cc.decrypt(input);
    }
}
