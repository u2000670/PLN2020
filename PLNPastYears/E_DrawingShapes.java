package com.company.PLNPastYears;
import java.util.Scanner;

public class E_DrawingShapes {

    public static double dist(Coordinates c1, Coordinates c2) {
        return Math.sqrt((c1.x - c2.x) * (c1.x - c2.x) + (c1.y - c2.y) * (c1.y - c2.y));
    }
    public static double slope(Coordinates c1, Coordinates c2) {
        return (c1.y - c2.y) / ((c1.x - c2.x) * 1.0);
    }

    public static String solution(Coordinates[] coords ) {
        //because points are sorted, the last point in the coords array is automatically
        // the point that is opposite to the 1st point
        //thus making dist(point1, point4) = diagonal (strictly for squares, rec, rhombuses, parallelograms)
        double d12 = dist(coords[0],coords[1]);
        double d13 = dist(coords[0],coords[2]);
        double d14 = dist(coords[0],coords[3]);
        double d23 = dist(coords[1],coords[2]);
        double d24 = dist(coords[1],coords[3]);
        double d34 = dist(coords[2],coords[3]);

        double s12 = slope(coords[0],coords[1]);
        double s13 = slope(coords[0],coords[2]);
        double s14 = slope(coords[0],coords[3]);
        double s23 = slope(coords[1],coords[2]);
        double s24 = slope(coords[1],coords[3]);
        double s34 = slope(coords[2],coords[3]);

        if(d12 == d13){
            if(d14 == d23)
                return "Square";
            return "Rhombus";
        }else if (d12 == d34 && d13 == d24 && s12 == s34 && s13 == s24){
            if(d14 == d23)
                return "Rectangle";
            return "parallelogram";
        } else if (s12 == s34 || s13 == s24 || s14 == s23 )
            return "Trapez";
        else
        return "nope";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Coordinates c = new Coordinates(x, y, j);
            }
            Coordinates.sortPoints();
//            Coordinates.printAll();
            System.out.println(solution(Coordinates.points));
        }
    }
}

class Coordinates {
    int x, y;
    static Coordinates[] points = new Coordinates[4];

    public Coordinates(int x, int y, int index) {
        this.x = x;
        this.y = y;
        points[index] = this;
    }

    public static void sortPoints() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 - i; j++) {
                if (points[j + 1].x < points[j].x) {
                    Coordinates temp = points[j + 1];
                    points[j + 1] = points[j];
                    points[j] = temp;
                } else if (points[j + 1].x == points[j].x) {
                    if (points[j + 1].y < points[j].y) {
                        Coordinates temp = points[j + 1];
                        points[j + 1] = points[j];
                        points[j] = temp;
                    }
                }
            }
        }
    }
    //just to check if it sorted correctly
    public static void printAll() {
        int i = 0;
        for (Coordinates c : points
        ) {
            System.out.println("point " + (i + 1) + ": (" + c.x + "," + c.y + ")");
            i++;
        }
    }
}

