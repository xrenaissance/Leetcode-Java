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
 -  Turn off the rightmost 1-bit
    ```
    y = x & (x - 1)
    ```
 -  Isolate the rightmost 1-bit
    ```
    y = x & (-x)
    ```