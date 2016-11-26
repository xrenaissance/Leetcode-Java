这个类型的题目一共有5道，

[303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)
[307. Range Sum Query - Mutable](https://leetcode.com/problems/range-sum-query-mutable/)
[304. Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)
[308. Range Sum Query 2D - Mutable](https://leetcode.com/problems/range-sum-query-2d-mutable/)
[327. Count of Range Sum](https://leetcode.com/problems/count-of-range-sum/)

303很容易，307数组元素可变的就麻烦一些了，需要用到高级点的数据结构，Segment Tree或Index Tree。

关于Segment Tree可参考 https://discuss.leetcode.com/topic/29918/17-ms-java-solution-with-segment-tree
关于Index Tree可参考 http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/

假设数组为A[0, 8]，则Index Tree为
T[0] = 0
T[1] = A[0]
T[2] = A[0] + A[1]
T[3] = A[2];
T[4] = A[0] + A[1] + A[2] + A[3]
T[5] = A[4]
T[6] = A[5] + A[4]
T[7] = A[6]
T[8] = A[0] + A[1] + A[2] + A[3] + A[4] + A[5] + A[6] + A[7]
T[9] = A[8]

首先根据数组A生成T，然后再由T得到Sum。
生成T的过程，先看A[0]，从1开始，索引依次加n&-n，即A[0]会被依次叠加到T[1],T[2],T[4],T[8]
对于A[1]，从2开始，A[1]会被依次叠加到T[2],T[4],T[8]
对于A[2]，从3开始，A[2]会被依次叠加到T[3],T[4],T[8]
对于A[3]，从4开始，A[3]会被依次叠加到T[4],T[8]
对于A[4]，从5开始，A[4]会被依次叠加到T[5],T[6],T[8]
对于A[5]，从6开始，A[5]会被依次叠加到T[6],T[8]
对于A[6]，从7开始，A[6]会被依次叠加到T[7],T[8]
对于A[7]，从8开始，A[7]会被依次叠加到T[8]
对于A[8]，从9开始，A[8]会被依次叠加到T[9]
所以就这样生成了T。

说一下n&-n,这个生成的结果是只保留最低位的1，高位的1都清零。

Sum的过程刚好相反，对于Sum[k]，则起始T的索引为k+1，然后依次减n&-n
Sum[8] = T[9] + T[8]
Sum[7] = T[8]
Sum[6] = T[7] + T[6] + T[4]
Sum[5] = T[6] + T[4]
Sum[4] = T[5] + T[4]
Sum[3] = T[4]
Sum[2] = T[3] + T[2]
Sum[1] = T[2]
Sum[0] = T[1]
