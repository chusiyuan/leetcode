import java.util.Scanner;

public class SequenceSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double n = scanner.nextDouble();
            double m = scanner.nextDouble();
            double result = 0;
            for (int i = 0; i < m; i++) {
                result += n;
                n = Math.sqrt(n);
            }
            System.out.println(String.format("%.2f", result));
        }
    }
}
