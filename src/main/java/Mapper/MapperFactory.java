package Mapper;

import Mapper.ConcreteMappers.*;
import Mapper.JsonMapper;
import com.google.common.collect.Maps;

import java.util.Collections;

/**
 * @author Girenok
 */
public class MapperFactory {
    private Object obj;
    private JsonMapper jsonMapper=null;

    public JsonMapper getMapper(Object obj) {
        this.obj=obj;
        checkType();
        return jsonMapper;
    }

    private void checkType() {
        if(obj == null){
            jsonMapper=new NullMapper();
        }else if (obj instanceof Boolean){
            jsonMapper=new BooleanMapper();
        }else if (obj instanceof Number){
            jsonMapper=new NumberMapper();
        }else if(obj instanceof String||obj instanceof Character){
            jsonMapper=new StringMapper();
        }else if(isPrimitiveArray(obj)){
            jsonMapper=new PrimitiveArrayMapper();
        }else if(obj instanceof Object[]){
            jsonMapper=new CollectionMapper();
        }else if(obj instanceof Collections){
            jsonMapper=new CollectionMapper();
        }else if(obj instanceof Maps){
            jsonMapper=new MapMapper();
        } else {
            jsonMapper=new ObjectMapper();
        }
    }
    private boolean isPrimitiveArray(Object o) {

        return (o instanceof byte[]||o instanceof short[]||o instanceof int[]||
                o instanceof long[]||o instanceof float[]||o instanceof double[]||
                o instanceof boolean[]||o instanceof String);
    }
}
