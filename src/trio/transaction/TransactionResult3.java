/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionResult3{
    String titel;
    String duration;
 
    
    public TransactionResult3(String title, String duration){
        this.titel = titel;
        this.duration = duration;
       
    }
    
    
    public String toString(){
          
        
        return titel;
        
        
    }
}
