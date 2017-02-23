package Mapper;

import Serialize.JsonWriter;

/**
 * @author Girenok
 */
public abstract class JsonMapper {
    /*protected int currentLevel =0;
    public int getCurrentLevel(){
      return currentLevel;
    }
    public void setLevel(int level){
        currentLevel=level;
    }
*/


    public abstract void write(Object object, JsonWriter writer);


}
