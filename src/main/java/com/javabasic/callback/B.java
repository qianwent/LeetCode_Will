package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class B {

    /**
     * �ش���B�ӵ绰�������� �����Ե��ûش���B��answer������ʾ������ص������ࡢ����������Ա�ʾ˭��ĵ绰����ɶ��
     */
    public void answer(CallBack callBack, String question) {
        System.out.println("A����B�Ľӵ绰���������ǻش���B��������A�ʵ������ǣ�" + question);
        /**
         * ģ��ش���B��æ�Լ�����
         */
        System.out.println("���ǻش���B���ҽ���绰��ȥæ���Լ����£�");
        for (int i = 0; i < 100000; i++) {

        }
        String result = "2";
        System.out.println("���ǻش���B����֪���˴��ǣ�" + result);
        /**
         * ���ûص���������绰��֪A����ʲô
         */
        callBack.callBack(result);
    }

}
