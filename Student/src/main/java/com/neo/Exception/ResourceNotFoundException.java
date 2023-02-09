package com.neo.Exception;

public class ResourceNotFoundException extends RuntimeException {

    String resoutceName;
    String fieldName;
    Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName,
                                     Object fieldValue) {
        super(String.format("%s not found %s : %s", resourceName, fieldName, fieldValue));
        this.resoutceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
