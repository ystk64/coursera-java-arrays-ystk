import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class WordPlay {
    private char ch = 'A';

    private boolean isVowel(char ch) {
        this.ch = ch;
        boolean charIsVowel = false;
        String vowels = "AEOUIaeoui";


        for (int i = 0; i < vowels.length(); i++) {
            if (vowels.charAt(i) == ch) {
                charIsVowel = true;
                break;
            } else charIsVowel = false;
        }
        return charIsVowel;
    }

    private void replaceVowels(String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder();

        for (int i=0;i<phrase.length();i++) {
            char c = phrase.charAt(i);
            if(isVowel(c)){
                c = ch;
                newPhrase.append(c);
            }
            else newPhrase.append(c);
        }
        System.out.println(newPhrase);
    }

    private void emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ch) {
                if ((i % 2) == 0) {
                    newPhrase.append('*');
                } else newPhrase.append('+');
            } else newPhrase.append(phrase.charAt(i));
        }
        System.out.println(newPhrase);
    }

    @Test
    public void testIsVowel(){
        String c = "b";
        char ch = c.charAt(0);
        isVowel(ch);
    }

    @Test
    public void testReplaceVowels(){
        String phrase = "Hello world";
        String supposedToBe = "H*ll* w*rld";
        replaceVowels(phrase, '*');
    }

    @Test
    public void testEmphasize(){
        String phrase = "dna ctgaaactga";
        emphasize(phrase, 'a');
    }
}


