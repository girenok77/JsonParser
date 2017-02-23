package Serialize;

import Mapper.JsonMapper;
import Mapper.MapperFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * @author Girenok
 */
public class JsonSerializer {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private MapperFactory mapperFactory = new MapperFactory();

    public boolean isIndent() {
        return true;
    }

    public void setIndent(boolean indent) {
    }

    public void serialize(Object object, OutputStream stream) {
        serialize(object, stream, DEFAULT_CHARSET);
    }

    public void serialize(Object object, OutputStream stream, Charset charset) {
        serialize(object, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object obj, Writer writer) {
        JsonWriter jsonWriter;
        if (isIndent()) {
            jsonWriter = new IndentedJsonWriter(writer);
        } else {
            jsonWriter = new JsonWriter(writer);
        }
        JsonMapper mapper = mapperFactory.getMapper(obj);
        mapper.write(obj, jsonWriter);
        jsonWriter.flush();
        try {
            jsonWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
