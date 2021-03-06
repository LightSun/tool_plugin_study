package com.heaven7.study.apt;

import com.heaven7.java.data.mediator.*;
import com.heaven7.java.data.mediator.internal.SharedProperties;

import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_MAIN_SCOPES_2;
import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_NO_EXPOSE;

/**
 * the item of flow
 * Created by heaven7 on 2017/10/8.
 */

@GlobalConfig(
        gsonConfig = @GsonConfig(
                version = 1.5,
                generateJsonAdapter = true
        )
)
@Fields({
        @Field(propName = "id", type = int.class,  since = 1.2, until = 2.0),
        @Field(propName = "name" ,seriaName = "stu_name"),
        @Field(propName = "desc" , flags = FLAGS_MAIN_SCOPES_2 | FLAGS_NO_EXPOSE),
})
public interface FlowItem extends DataPools.Poolable {
        Property PROP_id = SharedProperties.get("int", "id", 0);
        Property PROP_name = SharedProperties.get("java.lang.String", "name", 0);
        Property PROP_desc = SharedProperties.get("java.lang.String", "desc", 0);

        int getId();

        FlowItem setId(int id1);

        String getName();

        FlowItem setName(String name1);

        String getDesc();

        FlowItem setDesc(String desc1);
}
