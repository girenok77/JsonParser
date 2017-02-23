package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Mapper.MapperFactory;
import Serialize.JsonWriter;

import java.lang.reflect.Field;

/**
 * @author Girenok
 */
public class ObjectMapper extends JsonMapper {

    @Override
    public void write(Object object, JsonWriter writer) {
        writer.writeObjectBegin();
        Field[]fields=object.getClass().getDeclaredFields();
        for (int i=0;i<fields.length;i++) {
            Field field=fields[i];
            field.setAccessible(true); //set modifier to public first.
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            writer.writeString(field.getName());
            writer.writePropertySeparator();
            MapperFactory mapperFactory = new MapperFactory();
            JsonMapper mapper = mapperFactory.getMapper(value);
            mapper.write(value, writer);
            if(writer.level>1||i!=fields.length-1)writer.writeSeparator();


        }
        writer.writeObjectEnd();

    }
}
