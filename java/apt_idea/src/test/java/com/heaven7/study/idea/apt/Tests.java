package com.heaven7.study.idea.apt;

import com.heaven7.java.data.mediator.DataMediator;
import com.heaven7.java.data.mediator.DataMediatorCallback;
import com.heaven7.java.data.mediator.DataMediatorFactory;
import com.heaven7.java.data.mediator.Property;
import com.heaven7.study.apt.FlowItemModule;
import junit.framework.TestCase;

/**
 * Created by heaven7 on 2017/10/14.
 */
public class Tests extends TestCase {

    DataMediator<FlowItemModule> mediator;
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
        mediator.getDataProxy()
                .setId(1)
                .setName("heaven7")
                .setDesc("xxx");
    }

    public static void log(String method, Object obj){
        System.out.println("Tests >>> called [ "+ method+"() ]: " + obj);
    }
}
