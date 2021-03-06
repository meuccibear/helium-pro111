package io.renren.common.gitUtils.kdl.exceptions;


public class KdlException extends Exception {
    private static final long serialVersionUID = -1384494266981602237L;
    private int code;
    private String message;
    private String hintMessage;

    public KdlException(int code, String message) {
        this.code = code;
        this.message = message;
        this.hintMessage = String.format("[KdlException] code: %d message: %s", this.code, this.message);
    }


    public String getHintMessage() {
        return hintMessage;
    }

    public void setHintMessage(String hintMessage) {
        this.hintMessage = hintMessage;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return hintMessage;
    }

}
