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
             * ���forѭ��һ��ʼ��û���뵽�ģ�˵������Ȼ��ǲ���
             * ��ʵӦ�ú���Ȼ�����ⷽ���룬��Ȼ�Ƕ�̬�滮����̬�Ĳ��־����¼����һ���鵽���Ƿ�ԭ����һ�㣬
             * �����¼�һ�㣬���ǰѵ�ǰһ������һ�������µ�һ���鶼�ŵ��µ�һ��
             * ��ȻҪ��������Щ�߼�����ȫ������Ҫ��һ������ġ�����
             */
            for (int j = i - 1; j >= 1; j--) {
                /**
                 * if�������ʼ�����뵽�ģ��ؼ���if������߼����Ƕ������ڷŲ��ԵĹؼ�
                 * �ڵ�ǰ��ǰһ����width֮��Ҳ����sumWidth������shelf_width��ʱ��
                 * ʵ�����Ƚ���һ�����صĵ������Զ��׼��Ĳ������������������ȷŵ�һ�飬�õ�һ��maxHeight
                 * ���ʱ��������µ�dp��ʽ�ͼ��ˣ����������
                 * 1.һ��ѭ�����dp��Ҳ����ֱ�Ӱ��µ�һ����ŵ��µ�һ��
                 * 2.����ѭ��if�����ǹ�����һ��height���������maxHeight+����ǰһ���鼰��֮ǰ�������鹹�ɵ�dp
                 * ���ʱ��dp��index��Ҫ�ټ�ȥ1
                 * 1��2ȡ��Сֵ���������Ž���
                 * TODO��������˼ά����ֵ�ö�λع�
                 */
                if (sumWidth + books[j-1][0] <= shelf_width) {
                    sumWidth += books[j-1][0];
                    maxHeight = Math.max(maxHeight, books[j-1][1]);
                    dp[i] = Math.min(dp[i], maxHeight + dp[j - 1]);
                } else {
                    /**
                     * ��ǰһ�����width+ǰһ�����width���>shelf_width����һ��ֻ�ܰѵ�ǰ�Ȿ��ŵ��²�
                     * Ҳ����ֱ�ӻص���һ��forѭ�����dp״̬ת�Ʒ���
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
