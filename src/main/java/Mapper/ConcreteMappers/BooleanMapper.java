package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Serialize.JsonWriter;

/**
 * @author Girenok
 */
public class BooleanMapper extends JsonMapper {



    @Override
    public void write(Object object, JsonWriter writer) {
        writer.writeBoolean((Boolean)object);

    }
}
