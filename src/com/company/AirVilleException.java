package com.company;

public class AirVilleException {

    //FIELDS
    private ErrorCode errorCode;

    //ENUMS
    public enum ErrorCode{
        UNSUPPORTED_OPERATION, INVALID_INPUT_DATA
    }

    //CONSTRUCTOR
    public AirVilleException(AirVilleException.ErrorCode errorCode){
        this.errorCode = errorCode;
    }

    //METHODS

    /**
     * @return the error code associated with the exception
     */
    public AirVilleException.ErrorCode getErrorCode(){
        return this.errorCode;
    }
}
