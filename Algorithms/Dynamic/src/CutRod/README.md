## Задача о разрезании стержня:
 Имеются стержнь длиной `n` и таблица `p(i)` для `i = 1, 2 ... n`.
 Необходимо найти максимальную прибль `r(n)`, получаемую при разрезании стержня и продаже полученных кусков.
 
 ![image not found](https://i.ibb.co/JvG9C0d/2019-11-16-0-15-18.png)


### Рекурентная формула нахождения оптимального стержня:
 ![image not found](https://i.ibb.co/0J3qXdw/2019-11-16-0-19-03.png)


### Наивная реализация.
Псевдокод:

![image not found](https://i.ibb.co/09vnJXj/2019-11-16-0-33-06.png)

Дерево всех вызовов для вычисления `r(4)`:
 ![image not found](https://i.ibb.co/nPD84XW/2019-11-16-0-21-22.png)

Для каждой подзадачи рекурсивно вычисляется значение и берётся максимум.
```
r(4) = price(1) + r(3)
r(4) = price(2) + r(2)
r(4) = price(3) + r(1)
r(4) = price(4)

r(3) = price(1) + r(2)
r(3) = price(2) + r(1)
r(3) = price(3) 

r(2) = price(1) + r(1)
r(2) = price(2)

r(1) = price(1)
```

Можно заметить дубликаты при вычислении. Данное решение растёт экспоненциально относительно `n`.

Реализация:
```
int cutRod(int[] price, int n) {
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
```
