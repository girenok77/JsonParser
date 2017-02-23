package Serialize;

import Mapper.JsonMapper;

import java.io.*;

/**
 * @author Girenok
 */
public class JsonWriter extends FilterWriter {
    private Object objecttoJson;
    private StringBuilder JsonString;
    public int level;
    public int indentSize=3;


    public JsonWriter (Writer writer){
        super(writer);

    }



    public void writeObjectBegin()  {
        try {
            out.write("{");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeObjectEnd () {

        try {
            out.write("}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void WriteArrayBegin()  {
        try {
            out.write("[");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeArrayEnd()  {
        try {
            out.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeString(String string)  {
        try {
            out.write("\""+string+"\"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void writeNumber(Number number)  {
        try {
            out.write(String.valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeSeparator()  {
        try {
            out.write("," );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePropertySeparator() {
        try {
            out.write(":");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeBoolean(Boolean bool)  {
        try {
            out.write(bool.toString().toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeNull()  {
        try {
            out.write("null");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush() {
        try {
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
