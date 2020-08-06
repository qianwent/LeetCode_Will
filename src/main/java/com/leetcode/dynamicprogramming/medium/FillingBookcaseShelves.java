package com.leetcode.dynamicprogramming.medium;

/**
 * We have a sequence of books: the i-th book has thickness books[i][0] and height books[i][1].
 * <p>
 * We want to place these books in order onto bookcase shelves that have total width shelf_width.
 * <p>
 * We choose some of the books to place on this shelf (such that the sum of their thickness is <= shelf_width), then build another level of shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down.  We repeat this process until there are no more books to place.
 * <p>
 * Note again that at each step of the above process, the order of the books we place is the same order as the given sequence of books.  For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
 * <p>
 * Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
 * <p>
 * Example 1:
 * Input: books = [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]], shelf_width = 4
 * Output: 6
 * Explanation:
 * The sum of the heights of the 3 shelves are 1 + 3 + 2 = 6.
 * Notice that book number 2 does not have to be on the first shelf.
 * <p>
 * Constraints:
 * <p>
 * 1 <= books.length <= 1000
 * 1 <= books[i][0] <= shelf_width <= 1000
 * 1 <= books[i][1] <= 1000
 */
public class FillingBookcaseShelves {

    public static int minHeightShelves(int[][] books, int shelf_width) {
        int dp[] = new int[books.length + 1];
        dp[0] = 0;

        for (int i = 1; i < books.length + 1; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int sumWidth = books[i - 1][0];
            int maxHeight = books[i - 1][1];

            /**
             * 这层for循环一开始是没有想到的，说明敏锐度还是不行
             * 其实应该很自然能往这方面想，既然是动态规划，动态的部分就是新加入的一本书到底是放原来的一层，
             * 还是新加一层，还是把当前一层的最后一本连带新的一本书都放到新的一层
             * 当然要把上面这些逻辑都想全，还是要花一番功夫的。。。
             */
            for (int j = i - 1; j >= 1; j--) {
                /**
                 * if条件是最开始就能想到的，关键是if里面的逻辑，是对整个摆放策略的关键
                 * 在当前和前一本书width之和也就是sumWidth不超过shelf_width的时候，
                 * 实际上先进行一步隐藏的但是又显而易见的操作，即把这两本书先放到一块，得到一个maxHeight
                 * 这个时候再理解新的dp公式就简单了，分两种情况
                 * 1.一层循环里的dp，也就是直接把新的一本书放到新的一层
                 * 2.二层循环if里先是构建了一种height，两本书的maxHeight+再往前一本书及其之前的所有书构成的dp
                 * 这个时候dp的index需要再减去1
                 * 1和2取最小值，就是最优解了
                 * TODO：整个的思维过程值得多次回顾
                 */
                if (sumWidth + books[j-1][0] <= shelf_width) {
                    sumWidth += books[j-1][0];
                    maxHeight = Math.max(maxHeight, books[j-1][1]);
                    dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                } else {
                    /**
                     * 当前一本书的width+前一本书的width如果>shelf_width，那一定只能把当前这本书放到下层
                     * 也就是直接回到第一层for循环里的dp状态转移方程
                     */
                    break;
                }
            }
        }

        return dp[books.length];
    }

    public static void main(String[] args) {
        System.out.println(minHeightShelves(new int[][]{{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));
    }
}
