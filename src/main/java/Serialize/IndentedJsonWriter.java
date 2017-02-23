package Serialize;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Girenok
 */
public class IndentedJsonWriter extends JsonWriter {
    public IndentedJsonWriter(Writer writer) {
        super(writer);
    }
    public int level;
    public int indentSize=3;

    public void writeIndent() {
        for(int i =0;i<level;i++){
            for(int j=0;j<indentSize;j++){
                try {
                    out.write(" ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void writeObjectBegin()  {
        try {
            out.write("{\n");
            level++;
            writeIndent();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void writeObjectEnd () {

        try {
            level--;
            out.write("\n");
            writeIndent();
            out.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void WriteArrayBegin()  {
        try {
            out.write("[\n");
            level++;
            writeIndent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeArrayEnd()  {
        try {
            level--;
            out.write("\n");
            writeIndent();
            out.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeString(String string)  {
        try {
            out.write("\""+string+"\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void writeNumber(Number number)  {
        try {
            out.write(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeSeparator()  {
        try {
            out.write(",\n" );

            writeIndent();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writePropertySeparator() {
        try {
            out.write(" : ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeBoolean(Boolean bool)  {
        try {
            out.write(bool.toString().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void writeNull()  {
        try {
            out.write("null");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
