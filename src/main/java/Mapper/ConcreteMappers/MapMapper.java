package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Mapper.MapperFactory;
import Serialize.JsonWriter;

import java.util.Map;

/**
 * @author Girenok
 */
public class MapMapper extends JsonMapper {


    @Override
    public void write(Object object, JsonWriter writer) {
        Map<Object,Object> map= (Map<Object, Object>) object;
        for (Map.Entry<Object,Object> entry : map.entrySet()) {
            Object key =entry.getKey();
            Object value=entry.getValue();
            MapperFactory mapperFactory = new MapperFactory();
            JsonMapper mapperkey = mapperFactory.getMapper(key);
            JsonMapper mappervalue=mapperFactory.getMapper(value);

            mapperkey.write(key, writer);
            writer.writePropertySeparator();
            mappervalue.write(value,writer);
            writer.writeSeparator();

        }

    }
}
