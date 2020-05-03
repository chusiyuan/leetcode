package WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (n == m) {
            System.out.println(0);
        } else if (n > m) {
            System.out.println((n - m) * Math.min(a, b));
        } else {
            int result = 0;
            while (m % n != 0) {
                n--;
                result += a;
            }
            System.out.println(Math.min((n - m % n) * b, result));
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String s = scanner.nextLine();
            int[] st = new int[26];
            for (int i = 0; i < s.length(); i++) {
                st[s.charAt(i) - 'a']++;
            }
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (st[i] % 2 == 1) {
                    count++;
                }
            }
            if (count == 0 || count % 2 == 1) {
                System.out.println("Cassidy");
            } else {
                System.out.println("Eleanore");
            }
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] card = new int[n][2];
        for (int i = 0; i < n; i++) {
            card[i][0] = scanner.nextInt();
            card[i][1] = scanner.nextInt();
        }
        Arrays.sort(card, (int[] o1, int[] o2) -> {
            return o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1];
        });
        int ans = 0;
        int chance = 1;
        int i = 0;
        while (chance-- > 0) {
            ans += card[i][0];
            chance += card[i][1];
            i++;
            if (i == n) break;
        }
        System.out.println(ans);
    }
}
