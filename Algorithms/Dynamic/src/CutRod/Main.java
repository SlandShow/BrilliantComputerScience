/**
 * Задача о разрезании стержня:
 * <p>
 * Имеются стержнь длиной n и таблица p(i) для i = 1, 2 ... n.
 * Необходимо найти максимальную прибль r(n), получаемую при разрезании стержня и продаже полученных кусков.
 */
public class Main {

    public static void main(String... args) {
        long start = System.currentTimeMillis();
        new Test().solve();
        long end = System.currentTimeMillis();
        System.out.println("\nCalculated in " + (end - start) + " ms");
    }

    private void solve() {
        int[] productsPrice = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Profit is " + cutRod(productsPrice, 4));
    }

    /**
     * Наивная реализация вычисления рекурентной формы:
     * r(n) = max(p(i) + r(n - i)
     * где r(0) = 0, p(i) - прибыль, r(n) - вычисление наилучшей цены
     * Сложность: O(n^2)
     */
    public int cutRod(int[] price, int n) {
        if (n == 0) {
            return 0;
        }

        int expectedProfit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            expectedProfit = Math.max(
                    expectedProfit,
                    price[i] + cutRod(price, n - i - 1)
            );
        }

        return expectedProfit;
    }
}
