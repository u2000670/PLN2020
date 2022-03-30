package com.company.PLNPastYears;
import java.util.*;

//my code starts here
public class B_KillProcess {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Node> map = new HashMap<>();
    static Map<Integer, Long> dp = new HashMap<>();

    public static void solution() {
        int r = sc.nextInt();
        int s = sc.nextInt();
        List<Integer> visited1 = new ArrayList<>();
        List<Integer> visited2 = new ArrayList<>();
        visited1.add(r);
        visited2.add(s);
        while (true) {
            if (visited1.contains(s)) {
                System.out.println(map.get(s).getMemory());
                break;
            }
            if (visited2.contains(r)) {
                System.out.println(map.get(r).getMemory());
                break;
            }
            r = map.get(r).ppid;
            visited1.add(r);
            s = map.get(s).ppid;
            visited2.add(s);

        }
    }
    //my code ends here

    //below this line is from Sam's code : https://github.com/samweihong/PLN2020-Closed/blob/master/src/C.java
    public static void main(String[] args) {
        int n = sc.nextInt();
        int q = sc.nextInt();

        map.put(0, new Node(0, 0, -1));
        for (int i = 0; i < n; i++) {
            int pid = sc.nextInt();
            int ppid = sc.nextInt();
            int memory = sc.nextInt();
            map.put(pid, new Node(pid, memory, ppid));
            map.get(ppid).children.add(pid);
        }

        for (int i = 0; i < q; i++) {
            solution();
        }
    }

    static class Node {
        int pid;
        int ppid; //added
        int memory;
        List<Integer> children;

        public Node(int pid, int memory, int ppid) {
            this.pid = pid;
            this.ppid = ppid; // added
            this.memory = memory;
            children = new ArrayList<>();
        }

        public long getMemory() {
            if (dp.containsKey(pid))
                return dp.get(pid);

            long sum = memory;
            for (int id : children)
                sum += map.get(id).getMemory();
            dp.put(pid, sum);
            return sum;
        }
    }
}
