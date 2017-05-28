/**
 * Created by tolgaustunkok on 28.05.2017.
 */
public class Program {

    public Program() {
        int increaser = 2;
        int sum = 0;

        for (int i = 3, j = 0; i <= 1002001; i += increaser, j++) {
            sum += i;

            if (j >= 3) {
                increaser += 2;
                j = -1;
            }
        }

        sum += 1;

        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        new Program();
    }
}
