package com.algorithm.topdatastructurealgorithmquestions.sorting.applysorting;

import java.util.Comparator;

/**
 * Created by Wentao Qian on 12/9/2017.
 */
//ע�⵽����д��������Զ����comparator����ȫд�����ˣ��е�ʱ��Ϊ����ʵ����д�������࣬���CollectionSorting��main����
public class RatingComparator implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone o1, SmartPhone o2) {
        //same as if--else if--else
        return o1.getRating()<o2.getRating() ? -1 : o1.getRating()>o2.getRating() ? 1 :0;
    }
}
