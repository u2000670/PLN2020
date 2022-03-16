package QN;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class G {

    public static void main(String[] args) {
        //97 = a = 0
        //65 = A 
//        int x = 'A' + 'J' + 'R' + 'B' - (4 * 65);
//        char ch_a = Character.toUpperCase((char) 97);//a
//        char ch_z = Character.toUpperCase((char) 122);//a
//        System.out.println(x);
//        System.out.println(ch_a);
//        System.out.println(ch_z);
        
        Scanner s = new Scanner(System.in);
        int checkLower;
        String code = "";
        char[] codeFullChar;

        do {
            checkLower = 0;
            code = s.nextLine();
            codeFullChar = code.toCharArray();
            for (char c : codeFullChar) {
                if (Character.isLowerCase(c)) {
                    checkLower++;
                }
            }

        } while (code.length() % 2 != 0 || code.length() > 15000 || checkLower > 0);

        //DIVIDE
        char[] half1 = new char[codeFullChar.length / 2];
        char[] half2 = new char[codeFullChar.length / 2];

        for (int i = 0; i < codeFullChar.length; i++) {

            if (i < codeFullChar.length / 2) {
                half1[i] = codeFullChar[i];
            } else {
                half2[i - (codeFullChar.length / 2)] = codeFullChar[i];
            }
        }

        // calc rotation value
        int rotValueh1 = 0, rotValueh2 = 0;

        for (int i = 0; i < half1.length; i++) {
            rotValueh1 += (half1[i] - 65);
            rotValueh2 += (half2[i] - 65);
        }

        System.out.println("half1 rotValue: " + rotValueh1);
        System.out.println("half2 rotValue: " + rotValueh2);

        //ROTATE
        half1 = rotateChar(half1, rotValueh1);
        half2 = rotateChar(half2, rotValueh2);

        //MERGE
        char[] decoded = new char[half1.length];
        
        decoded = mergeChar(half1, half2);
        
        for (char c : decoded) {
            System.out.print(c+" ");
        }
        System.out.println("");
        
    }

    static char[] rotateChar(char[] ch, int rotVal) {
        for (int i = 0; i < ch.length; i++) {
            
            int actualCharVal = ch[i] - 65;
            int newVal = rotVal + actualCharVal;

            while (newVal >= 26) {
                newVal -= 26;
            }

            ch[i] = Character.toUpperCase((char) (newVal + 65));
        }
        return ch;
    }

    static char[] mergeChar(char[] ch1, char[] ch2) {
        
        int mergeVal;
        char[] decode = new char[ch1.length];
        
        for (int i = 0; i < decode.length; i++) {
            mergeVal = ch1[i] + ch2[i] - (2*65);
            
            while(mergeVal >= 26){
                mergeVal -=26;
            }
            decode[i] = Character.toUpperCase((char) (mergeVal + 65));
        }
        
        return decode;
    }

}
