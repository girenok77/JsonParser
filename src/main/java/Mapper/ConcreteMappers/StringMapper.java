package Mapper.ConcreteMappers;
import Mapper.JsonMapper;
import Serialize.JsonWriter;

/**
 * @author Girenok
 */
public class StringMapper extends JsonMapper {


    @Override
    public void write(Object object, JsonWriter writer) {
        writer.writeString((String) object);

    }
}
