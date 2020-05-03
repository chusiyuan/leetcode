import java.util.Scanner;

public class NarcissisticNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            boolean flag = false;
            for (int i = m; i <= n; i++) {
                int j = i;
                int sum = 0;
                while (j > 0) {
                    sum += (j%10)*(j%10)*(j%10);
                    j = j/10;
                }
                if (sum == i) {
                    System.out.print(i);
                    System.out.print(" ");
                    flag = true;
                }
            }
            if (flag) {
                System.out.println();
            } else {
                System.out.println("no");
            }
        }
    }
}
