package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class A implements CallBack {

    /**
     * ������A��֪���ش���B����ϵ��ʽ��
     * ������һ��B�����ô������ڹ��췽���д���Bʵ������
     */
    private B b;
    public A(B b){
        this.b = b;
    }
    /**
     * ������A��ش���B��绰������
     * ������һ��call������ʾ�����������������
     */
    public void call(final String question){
        /**
         * ����������A�̣߳���ش���B�߳̽�ϣ�����һ���첽�Ļ���
         */
        new Thread(() -> {
            /**
             * B�ӵ绰��������
             * �����Ե��ûش���B��answer������ʾ������ص����������������������Ա�ʾ˭��ĵ绰����ɶ��
             * ��ΪA��ʵ����CallBack�ӿڣ�����A����ǻص������࣬�ص�������ʵ���˻ص�����
             */
            b.answer(A.this, question);
        }).start();
        /**
         * �����������ʣ�ȥ�ɱ�����
         */
        doOtherThing();
    }

    public void doOtherThing(){
        System.out.println("����������A�������������ȥ�ɱ�������ˣ�");
    }

    @Override
    public void callBack(String result) {

    }
}
