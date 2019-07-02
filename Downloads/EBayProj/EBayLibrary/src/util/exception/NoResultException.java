/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.exception;

/**
 *
 * @author darryl
 */
public class NoResultException extends Exception {
    public NoResultException(){
        
    }
    
    public NoResultException(String msg){
        super(msg);
    }
}
