package Mapper.ConcreteMappers;

import Mapper.JsonMapper;
import Serialize.JsonWriter;

import java.util.Collection;

/**
 * @author Girenok
 */
public class PrimitiveArrayMapper extends JsonMapper {

    @Override
    public void write(Object object, JsonWriter writer) {
        writer.WriteArrayBegin();

        if (object instanceof double[] || object instanceof float[]) {
            double[] arr = (double[]) object;
            for (int i=0;i<arr.length;i++) {

                writer.writeNumber(arr[i]);
                if(i!=arr.length-1)writer.writeSeparator();
            }
        } else if (object instanceof byte[] || object instanceof short[] || object instanceof int[] ||
                object instanceof long[]) {
            long[] arr = (long[]) object;
            for (int i=0;i<arr.length;i++) {

                writer.writeNumber(arr[i]);
                if(i!=arr.length-1)writer.writeSeparator();
            }
        } else {
            String[]arr=(String[])object;
            for (int i=0;i<arr.length;i++) {

                writer.writeString(arr[i]);
                if(i!=arr.length-1)writer.writeSeparator();
            }
        }

        writer.writeArrayEnd();

    }
}
