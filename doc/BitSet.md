 - Check if the integer is even or odd
    ```
    if ((x & 1) == 0) {
        x is even
    } else {
        x is odd
    }
    ```
 - Test if the n-th bit is set
    ```
    if (x & (1 << n)) {
        n-th bit is set
    } else {
        n-th bit is not set
    }
    ```
 - Set the n-th bit
    ```
    y = x | (1 << n)
    ```
 - Unset the n-th bit
    ```
    y = x & ~(1 << n)
    ```
 - Toggle the n-th bit
    ```
    y = x ^ (1 << n)
    ```
 -  Turn off the rightmost 1-bit，将最右边的1清零
    ```
    y = x & (x - 1)
    ```
 -  Isolate the rightmost 1-bit，留下最右边的1，其余位都置为0
    ```
    y = x & (-x)
    ```
 - Right propagate the rightmost 1-bit，将最右边的1的右边全部置为1
    ```
    y = x | (x - 1)
    ```
 - Isolate the rightmost 0-bit，将最右边的0置为1，其余位都置为0
    ```
    y = ~x & (x + 1)
    ```
 - Turn on the rightmost 0-bit，将最右边的0置为1
    ```
    y = x | (x + 1)
    ```