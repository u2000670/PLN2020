package QN;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class H {
    
    static void triangleChecker(int a, int b, int c){
        
        if (a+b>c && a+c>b && b+c>a){
        //valid
            if (a==b && b==c ){
                System.out.println("Equilateral");
            }else if(a==b || a == c || b==c){
                System.out.println("Isosceles");
            }else
                System.out.println("Scalene");
        }else
            System.out.println("Invalid");
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int testCase;
        int x,y,z;
        
        do {            
            testCase = s.nextInt();
        } while (testCase<1 || testCase >200);
        
        for (int i = 0; i < testCase; i++) {
            x = s.nextInt();
            y = s.nextInt();
            z = s.nextInt();
            
            triangleChecker(x, y, z);
        }
        
    }
    
}
