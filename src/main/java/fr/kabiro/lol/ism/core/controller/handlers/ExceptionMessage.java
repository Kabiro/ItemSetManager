package fr.kabiro.lol.ism.core.controller.handlers;


public class ExceptionMessage {
    private String error;

    public ExceptionMessage(Exception e){
        error = e.getMessage();
    }

    public String getError() {
        return error;
    }
}
