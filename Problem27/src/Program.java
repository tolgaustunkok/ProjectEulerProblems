/**
 * Created by tolgaustunkok on 27.05.2017.
 */
public class Program {

    public Program() {
        formula(1000000);
    }

    private int formula(int upperLimit) {
        int max = 0;
        for (int a  = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {

                int count = 0;
                for (int n = 0; n < upperLimit; n++) {
                    int result = n * n + a * n + b;

                    if (isPrime(result)) {
                        count++;
                    } else {
                        break;
                    }
                }

                if (count > max) {
                    max = count;
                    System.out.println("a = " + a + ", b = " + b);
                    System.out.println("Max = " + max);
                }
            }
        }

        return max;
    }

    private boolean isPrime(int num) {
        int half = Math.abs(num) / 2;

        for (int i = 2; i <= half; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Program();
    }
}
