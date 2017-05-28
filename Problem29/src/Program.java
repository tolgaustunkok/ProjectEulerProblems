import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tolgaustunkok on 28.05.2017.
 */
public class Program {

    public Program() {
        List<BigInteger> nums = new ArrayList<>();

        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger genNum = pow(BigInteger.valueOf(a), BigInteger.valueOf(b));
                if (!nums.contains(genNum)) {
                    nums.add(genNum);
                }
            }
        }

        System.out.println(nums.size());
    }

    private BigInteger pow(BigInteger base, BigInteger exponent) {
        BigInteger result = BigInteger.ONE;
        while (exponent.signum() > 0) {
            if (exponent.testBit(0)) result = result.multiply(base);
            base = base.multiply(base);
            exponent = exponent.shiftRight(1);
        }
        return result;
    }

    public static void main(String[] args) {
        new Program();
    }
}
