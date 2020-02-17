package com.algorithm.topdatastructurealgorithmquestions.sorting.applysorting;

import java.util.Comparator;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
//注意到这种写法把这个自定义的comparator类完全写出来了，有的时候为了其实可以写成匿名类，详见CollectionSorting的main方法
public class RatingComparator implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        //same as if--else if--else
        return o1.getRating()<o2.getRating() ? -1 : o1.getRating()>o2.getRating() ? 1 :0;
    }
}
