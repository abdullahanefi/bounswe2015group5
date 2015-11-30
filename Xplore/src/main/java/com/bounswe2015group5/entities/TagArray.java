package com.bounswe2015group5.entities;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author burak
 */
public class TagArray extends JSONArray{

    public TagArray() {
        super();
    }
    
    public TagArray(JSONArray arr) {
        super(arr.toString());
    }
    
    public TagArray(Map m){
        super(m);
    }
    
    @Override
    public Tag get(int index){
        return new Tag((JSONObject)super.get(index));
    }
       
}
