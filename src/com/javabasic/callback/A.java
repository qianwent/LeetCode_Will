package com.javabasic.callback;

/**
 * Created by Wentao Qian on 1/24/2018.
 */
public class A implements CallBack {

    /**
     * 提问者A是知道回答者B的联系方式的
     * 这里以一个B类引用代表，并在构造方法中传入B实例对象
     */
    private B b;
    public A(B b){
        this.b = b;
    }
    /**
     * 提问者A向回答者B打电话提问题
     * 这里以一个call方法表示，并把问题参数传入
     */
    public void call(final String question){
        /**
         * 建立提问者A线程，与回答者B线程结合，构成一个异步的环境
         */
        new Thread(() -> {
            /**
             * B接电话，听问题
             * 这里以调用回答者B的answer方法表示，传入回调方法类参数、问题参数，以表示谁打的电话，问啥了
             * 因为A类实现了CallBack接口，所以A类就是回调方法类，回调方法类实现了回调方法
             */
            b.answer(A.this, question);
        }).start();
        /**
         * 提问者提完问，去干别事情
         */
        doOtherThing();
    }

    public void doOtherThing(){
        System.out.println("我是提问者A，我问完问题就去干别的事情了！");
    }

    @Override
    public void callBack(String result) {

    }
}
