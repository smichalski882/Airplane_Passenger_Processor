package com.company;

public class AirVilleException {

    //FIELDS
    private ErrorCode errorCode;

    //ENUMS
    public enum ErrorCode{
        UNSUPPORTED_OPERATION, INVALID_INPUT_DATA
    }

    //CONSTRUCTOR

    /**
     * Create AirvilleException with an associated error code depending on the error
     * @param errorCode being assigned to this instance of exception
     */
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
