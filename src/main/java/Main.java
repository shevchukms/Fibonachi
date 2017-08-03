import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Main {

    static int n = 0;
    static int count = 0;
    static int odd = 0;
    static int even = 0;
    static BigDecimal number567;

    public static void main(String[] args) throws IOException {

        BigDecimal preLastNumber = BigDecimal.valueOf(1);
        BigDecimal lastNumber = BigDecimal.valueOf(1);

        readLine();
        try {
            fibo(preLastNumber, lastNumber, n);
        } catch (StackOverflowError e) {
            System.out.println("Введіть значення менше за " + count + ", пораховано " + count + " чисел Фібоначі");
        }

        System.out.println(String.format("Непарних чисел %d  що становить %.2f відсотків", odd, (odd * 100f / n)));
        System.out.println(String.format("Парних чисел %d  що становить %.2f відсотків", even, (even * 100f / n)));

        System.out.println("567-е число= " + number567);

    }

    public static void readLine() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введіть ціле число");
            n = Integer.parseInt(br.readLine());
        } catch (NumberFormatException e) {
            System.out.println("введено не ціле число, спробуйте знову");
            readLine();
        }

    }

    public static void fibo(BigDecimal preLastNumber, BigDecimal lastNumber, int number) {

        BigDecimal output = BigDecimal.valueOf(0);
        if (number > count) {
            output = preLastNumber.add(lastNumber);
            count++;
            if (preLastNumber.remainder(BigDecimal.valueOf(2)).equals(BigDecimal.valueOf(0))) {
                even++;
            } else {
                odd++;

            }
            if (count == 567) {
                number567 = output;
            }

            System.out.println(count + " : " + preLastNumber);
            fibo(lastNumber, output, number);
        }
    }
}






















