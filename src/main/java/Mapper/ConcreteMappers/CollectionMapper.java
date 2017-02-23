package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Mapper.MapperFactory;
import Serialize.JsonWriter;

import java.util.Collection;
import java.util.Map;

/**
 * @author Girenok
 */
public class CollectionMapper extends JsonMapper {


    @Override
    public void write(Object object, JsonWriter writer) {

        writer.WriteArrayBegin();
        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            for (Object i : collection) {
                MapperFactory mapperFactory = new MapperFactory();
                JsonMapper mapper = mapperFactory.getMapper(i);
                mapper.write(i, writer);
                writer.writeSeparator();
            }
        } else {
            Object[]objects=(Object[])object;
            for (Object i : objects) {
                MapperFactory mapperFactory = new MapperFactory();
                JsonMapper mapper = mapperFactory.getMapper(i);
                mapper.write(i, writer);
                writer.writeSeparator();
            }
        }
        writer.writeArrayEnd();

    }
}
