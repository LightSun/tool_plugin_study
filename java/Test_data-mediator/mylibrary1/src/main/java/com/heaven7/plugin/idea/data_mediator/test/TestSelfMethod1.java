package com.heaven7.plugin.idea.data_mediator.test;

import com.heaven7.java.data.mediator.*;
import com.heaven7.java.data.mediator.internal.SharedProperties;
import com.heaven7.plugin.idea.data_mediator.test.util.TestUtil;

/**
 * Created by heaven7 on 2017/10/26.
 */
@Fields({
        @Field(propName = "test_self1"),
        @Field(propName = "test_self2", type = int.class)
})
@ImplClass(TestUtil.class)
public interface TestSelfMethod1 extends DataPools.Poolable {

    Property PROP_test_self1 = SharedProperties.get("java.lang.String", "test_self1", 0);
    Property PROP_test_self2 = SharedProperties.get("int", "test_self2", 0);

    String getTest_self1();

    TestSelfMethod1 setTest_self1(String test_self11);

    int getTest_self2();
    TestSelfMethod1 setTest_self2(int test_self21);

    @ImplMethod("getStudentId")
    int getId(Student stu, int key);

    //not assigned method name of ImplClass. so use the same name.
    @ImplMethod
    void parseStudent(Student stu, int key);
}
