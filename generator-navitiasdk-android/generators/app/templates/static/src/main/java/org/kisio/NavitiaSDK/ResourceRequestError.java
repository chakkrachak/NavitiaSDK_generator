package org.kisio.NavitiaSDK;

public class ResourceRequestError {
    private int httpStatusCode;
    private String message;
    private Exception innerException;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public Exception getInnerException() {
        return innerException;
    }

    public ResourceRequestError(int httpStatusCode, String message, Exception innerException) {
        this.httpStatusCode = httpStatusCode;
        this.message = message;
        this.innerException = innerException;
    }
}
