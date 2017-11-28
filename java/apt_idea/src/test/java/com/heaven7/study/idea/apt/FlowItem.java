package com.heaven7.study.idea.apt;

import com.heaven7.java.data.mediator.Field;
import com.heaven7.java.data.mediator.Fields;
import com.heaven7.java.data.mediator.Property;
import com.heaven7.java.data.mediator.internal.SharedProperties;

import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_MAIN_SCOPES_2;
import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_NO_EXPOSE;

/**
 * the item of flow
 * Created by heaven7 on 2017/10/8.
 */

@Fields({
        @Field(propName = "id", type = int.class,  since = 1.2, until = 2.0),
        @Field(propName = "name" ,seriaName = "stu_name"),
        @Field(propName = "desc" , flags = FLAGS_MAIN_SCOPES_2 | FLAGS_NO_EXPOSE),
        @Field(propName = "test" , flags = FLAGS_MAIN_SCOPES_2 | FLAGS_NO_EXPOSE),
})
public interface FlowItem extends com.heaven7.java.data.mediator.DataPools.Poolable {

    Property PROP_id = SharedProperties.get("int", "id", 0);
    Property PROP_name = SharedProperties.get("java.lang.String", "name", 0);
    Property PROP_desc = SharedProperties.get("java.lang.String", "desc", 0);
    Property PROP_test = SharedProperties.get("java.lang.String", "test", 0);

    int getId();

    FlowItem setId(int id1);

    String getName();

    FlowItem setName(String name1);

    String getDesc();

    FlowItem setDesc(String desc1);

    String getTest();

    FlowItem setTest(String test1);
}
