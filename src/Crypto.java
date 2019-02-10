import java.lang.*;

public class Crypto {

    public static void main(String[] args){
        String str = "Fuck Off?\"\'!().,:;";
        str = encryptString(str, 1, 2);
        System.out.println(str);
        str = decryptString(str, 1);
        System.out.println(str);
    }

    public static String normalizeText(String str){
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String c = Character.toString(ch);
            if(c.equals(" ") || c.equals(".") || c.equals(",") || c.equals(":") || c.equals(";") || c.equals("\'") ||
                    c.equals("\"") || c.equals("!") || c.equals("?") || c.equals("(") || c.equals(")")){
                str = str.replace(c, "");
                i--;
            }
        }
        return str.toUpperCase();
    }

    public static String obify(String str) {
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String c = Character.toString(ch);
            if(c.equals("A") || c.equals("E") || c.equals("I") || c.equals("O") || c.equals("U")){
                str = str.substring(0, i+1) + "OB" + str.substring(i+1);
                i+=2;
            }
        }
        return str;
    }

    public static String unobify(String str) {
        for(int i = 0; i < str.length(); i++){
            char ch1 = str.charAt(i);
            String c1 = Character.toString(ch1);
            if(c1.equals("O")){
                char ch2 = str.charAt(i+1);
                String c2 = Character.toString(ch2);
                if(c2.equals("B")){
                    str = str.replace("OB", "");
                    i-=2;
                }
            }
        }
        return str;
    }

    public static String caesarify(String str, int key){
        String originalAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlphabet = shiftAlphabet(key);

        int index = 0;
        char oldChar;
        char newChar;

        for(int i = 0; i < str.length(); i++){
            oldChar = str.charAt(i);
            index = originalAlphabet.indexOf(oldChar);
            newChar = newAlphabet.charAt(index);
            str = str.substring(0, i) + newChar + str.substring(i+1);
        }
        return str;
    }

    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }

    public static String groupify(String str, int x){
        int padding = x-(str.length()%x);
        for(int i = x - 1; i < str.length(); i = i + x){
            str = str.substring(0, i+1) + " " + str.substring(i+1);
            i++;
        }

        for(int i = 0; i < padding; i++){
            str = str + "x";
        }
        return str;
    }

    public static String ungroupify(String str){
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String c = Character.toString(ch);
            if(c.equals(" ") ){
                str = str.replace(" ", "");
                i--;
            }
            if(c.equals("x") ){
                str = str.replace("x", "");
                i--;
            }
        }
        return str;
    }

    public static String encryptString(String str, int key, int x){
        str = normalizeText(str);
        str = obify(str);
        str = caesarify(str, key);
        str = groupify(str, x);
        return str;
    }

    public static String decryptString(String str, int key) {
        str = ungroupify(str);
        str = caesarify(str, (-1 * key));
        str = unobify(str);
        return str;
    }

}
