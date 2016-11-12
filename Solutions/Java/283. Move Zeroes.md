# [283.Move Zeroes](https://leetcode.com/problems/move-zeroes/)

`
这题关键是从前到后遍历，统计有几个0，然后依次给非0的数往前移，最后补零。
`

```
public void moveZeroes(int[] nums) {
    int cur = 0;

    for (int j = 0; j < nums.length; j++) {
        if (nums[j] != 0) {
            nums[cur++] = nums[j];
        }
    }

    while (cur < nums.length) {
        nums[cur++] = 0;
    }
}
```