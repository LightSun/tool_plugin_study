package com.heaven7.study.apt;

import com.heaven7.java.data.mediator.Field;
import com.heaven7.java.data.mediator.Fields;
import com.heaven7.java.data.mediator.GlobalConfig;
import com.heaven7.java.data.mediator.GsonConfig;

import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_MAIN_SCOPES_2;
import static com.heaven7.java.data.mediator.FieldFlags.FLAGS_NO_EXPOSE;

/**
 * the item of flow
 * Created by heaven7 on 2017/10/8.
 */

@GlobalConfig(
        gsonConfig = @GsonConfig(
                version = 1.2,
                generateJsonAdapter = true
        )
)
@Fields({
        @Field(propName = "id", type = int.class,  since = 1.2, until = 2.0),
        @Field(propName = "name" ,seriaName = "stu_name"),
        @Field(propName = "desc" , flags = FLAGS_MAIN_SCOPES_2 | FLAGS_NO_EXPOSE),
})
public interface FlowItem {
}
