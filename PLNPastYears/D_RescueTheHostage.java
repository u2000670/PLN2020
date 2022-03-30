package com.company.PLNPastYears;
import java.util.*;

//idea from baeldung: https://www.baeldung.com/java-solve-maze
public class D_RescueTheHostage {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int N = sc.nextInt();
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();

            char[][] map = new char[H][W];
            for (int j = 0; j < H; j++) {
                map[j] = sc.nextLine().toCharArray();
            }
            System.out.println(solution(map, N));
        }
    }

    public static int solution(char[][] map, int N) {
        Set<String> visited = new HashSet<>();
        Pointer p = new Pointer(0, 0, N);
        visited.add(p.x + "" + p.y);
        if (move(p, map, visited))
            return 1;
        else
            return 0;
    }

    public static boolean move(Pointer p, char[][] map, Set<String> visited) {

        if (map[p.y][p.x] == '%') return true;
        if (map[p.y][p.x] == '*' && p.N == 0)
            return false;
        else if (map[p.y][p.x] == '*' && p.N != 0)
            p.N--;

        if (!(p.x + 1 > map[0].length - 1) && map[p.y][p.x + 1] != '#' && !visited.contains((p.x + 1) + "" + p.y)) {
            p.x = p.x + 1;
            visited.add(p.x + "" + p.y);
            if (!move(p, map, visited)) {
                if (map[p.y][p.x] == '*')
                    p.N++;
                p.x = p.x - 1;
            }
            if (map[p.y][p.x] == '%') return true;
            //down
        }
        if (!(p.y + 1 > map.length - 1) && map[p.y + 1][p.x] != '#' && !visited.contains(p.x + "" + (p.y + 1))) {
            p.y = p.y + 1;
            visited.add(p.x + "" + p.y);
            if (!move(p, map, visited)) {
                if (map[p.y][p.x] == '*')
                    p.N++;
                p.y = p.y - 1;
            }
            if (map[p.y][p.x] == '%') return true;
            //left
        }
        if (!(p.x - 1 < 0) && map[p.y][p.x - 1] != '#' && !visited.contains((p.x - 1) + "" + p.y)) {
            p.x = p.x - 1;
            visited.add(p.x + "" + p.y);
            if (!move(p, map, visited)) {
                if (map[p.y][p.x] == '*')
                    p.N++;
                p.x = p.x + 1;
            }
            if (map[p.y][p.x] == '%') return true;
            //up
        }
        if (!(p.y - 1 < 0) && map[p.y - 1][p.x] != '#' && !visited.contains(p.x + "" + (p.y - 1))) {
            p.y = p.y - 1;
            visited.add(p.x + "" + p.y);
            if (!move(p, map, visited)) {
                if (map[p.y][p.x] == '*')
                    p.N++;
                p.y = p.y + 1;
            }
            if (map[p.y][p.x] == '%') return true;
        }

        return false;
    }

    static class Pointer {
        int x;
        int y;
        int N;

        public Pointer(int x, int y, int N) {
            this.x = x;
            this.y = y;
            this.N = N;
        }

    }
}
