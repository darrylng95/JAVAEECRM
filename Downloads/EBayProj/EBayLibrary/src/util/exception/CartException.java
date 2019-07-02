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
public class CartException extends Exception {
    public CartException(){
        
    }
    public CartException(String msg){
        super(msg);
    }
}
