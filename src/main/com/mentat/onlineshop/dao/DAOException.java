package main.com.mentat.onlineshop.dao;

/**
 * Created by Misha on 23.08.2015.
 */
public class DAOException extends RuntimeException {
    public DAOException(String message){
        super(message);
    }
    public DAOException (String message, Throwable cause){
        super(message, cause);
    }
}
