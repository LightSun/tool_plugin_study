package com.heaven7.study.idea.apt;

import junit.framework.TestCase;

/**
 * Created by heaven7 on 2017/10/14.
 */
public class Tests extends TestCase {

 /*   DataMediator<FlowItemModule> mediator;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mediator = DataMediatorFactory.createDataMediator(FlowItemModule.class);
        mediator.addDataMediatorCallback(new DataMediatorCallback<FlowItemModule>() {
            @Override
            public void onPropertyValueChanged(FlowItemModule data, Property prop,
                                               Object oldValue, Object newValue) {
                log("onPropertyValueChanged", "old = " + oldValue + ", newValue = " + newValue);
            }
        });
    }

    public void test1(){
        log("test1", GlobalSetting.getDefault().getGsonVersion());
        mediator.getDataProxy()
                .setId(1)
                .setName("heaven7")
                .setDesc("xxx")
                .setTest("test");
        log("test1", GlobalSetting.getDefault().getGsonVersion());
    }*/

    public static void log(String method, Object obj){
        System.out.println("Tests >>> called [ "+ method+"() ]: " + obj);
    }

    public static void main(String[] args){
        final Tests tests = new Tests();
        try {
            tests.setUp();
        } catch (Exception e) {
        }
       // tests.test1();
    }

}
