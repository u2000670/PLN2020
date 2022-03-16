package QN;

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class F {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x;
        int n0, n1, n2, n3, n4;

        do {
            x = s.nextInt();
        } while (x <= 0 || x >= 1000);

        for (int i = 0; i < x; i++) {
            do {
                System.out.print("enter num: ");
                n0 = s.nextInt();
            } while (n0 <= 0 || n0 >= 1000000);

            n1 = 3 * n0;

            if (n1 % 2 == 0) {
                System.out.print("even ");
                n2 = n1 / 2;
                n3 = 3 * n2;
                n4 = n3 / 9;
                System.out.println(n4);
            } else {
                System.out.print("odd ");
                n2 = (n1 + 1) / 2;
                n3 = 3 * n2;
                n4 = n3 / 9;
                System.out.println(n4);
            }

        }

    }
}
