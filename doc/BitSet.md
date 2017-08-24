 - Check if the integer is even or odd
    ```
    if ((x & 1) == 0) {
        x is even
    } else {
        x is odd
    }
    ```
 - 测试nth bit是否设置：`x & (1 << n)`
 - 设置nth bit：`x | (1 << n)`
 - 