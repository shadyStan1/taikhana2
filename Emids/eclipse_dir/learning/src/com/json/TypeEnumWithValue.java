package com.json;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {

    TYPE1(1), TYPE2(2);
	 
    private Integer id;
    private String name;

    TypeEnumWithValue(int key)
    {
      this.name = name;
    }
    
    @JsonValue
    public Integer getId() {
        return id;
    }
    
    @JsonValue
    public String getName() {
        return name;
    }
}
