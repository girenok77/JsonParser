package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Serialize.JsonWriter;

/**
 * @author Girenok
 */
public class  NullMapper extends JsonMapper {


    @Override
    public void write(Object object, JsonWriter writer) {
        writer.writeNull();

    }
}
