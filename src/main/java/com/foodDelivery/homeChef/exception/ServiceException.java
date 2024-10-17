package com.foodDelivery.homeChef.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ServiceException extends Exception {

    private final String errorDetails;
    private final HomeChefServiceErrorCodes errorCode;

    @Getter
    public enum HomeChefServiceErrorCodes {
        // Validations related 1xxx
        MISSING_REQUIRED_PARAMETER(1000, HttpStatus.BAD_REQUEST, "Missing required parameter"),
        INVALID_VALUES_FOR_REQUIRED_PARAMETER(1001, HttpStatus.BAD_REQUEST,
                "Invalid values sent for the requested parameter"),

        // Service related error codes 2xxx
        INTERNAL_SERVER_ERROR(2000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error"),

        // Database related errors 30xx
        DATA_PERSISTENCE_ERROR(3000, HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save data in DB"),
        REQUESTED_DETAILS_NOT_FOUND(3001, HttpStatus.NOT_FOUND,
                "Requested details were not found in the DB"),
        SOCIETY_DETAILS_NOT_FOUND(3002, HttpStatus.NOT_FOUND,
                "Society details were not found in the DB"),

        // Database constraints violations errors 31xx
        DUPLICATE_DATA(3101, HttpStatus.BAD_REQUEST, "The data already exists for the passed keys"),
        FOREIGN_KEY_CONSTRAINT_VIOLATION(3102, HttpStatus.BAD_REQUEST,
                "Foreign key constraint violation occurred.");
        private final int errorCode;
        private final HttpStatus httpStatusCode;
        private final String errorTitle;

        HomeChefServiceErrorCodes(int errCode, HttpStatus httpCode, String errMsg) {
            httpStatusCode = httpCode;
            errorCode = errCode;
            errorTitle = errMsg;
        }
    }
}
