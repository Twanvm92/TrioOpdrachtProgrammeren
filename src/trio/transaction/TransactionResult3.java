/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a string method that returns the results of the third question
 * @author mikakrooswijk
 */
public class TransactionResult3{
    String titel;
    String duration;
 
    
    public TransactionResult3(String titel, String duration){
        this.titel = titel;
        this.duration = duration;
       
    }
    
      /**
     * Returns a string
     * @return <code>s</code>  The answer that is displayed on the panel
     */
    public String toString(){
          
        String s = "";
        s = String.format("Titel: %-30s, duur: %3s", titel, duration);
        
        return s;
        
        
    }
}
