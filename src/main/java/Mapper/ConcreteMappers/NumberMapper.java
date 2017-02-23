package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Serialize.JsonWriter;

/**
 * @author Girenok
 */
public class NumberMapper extends JsonMapper {

    @Override
    public void write(Object object, JsonWriter writer) {

        writer.writeNumber((Number)object);

    }
}
