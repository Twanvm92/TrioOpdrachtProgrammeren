/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 *
 * @author lukab
 */
public class TransactionResult5 {
     String name;
    
    
    public TransactionResult5 (String name){
        this.name = name;
      
       
    }
    
    
    public String toString(){
          
        
      String status =  String.format("Account naam: %-20s", name);
        
        return status;
        
    }
}
