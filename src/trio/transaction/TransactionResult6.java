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
public class TransactionResult6 {
     String name;
     int quantity;
    
    
    public TransactionResult6 (String name, int quantity){
        this.name = name;
        this.quantity = quantity;
      
       
    }
    
    
    public String toString(){
          
        
      String status =  String.format(" %2d kijker(s) hebben/heeft %20s afgekeken", quantity, name);
        
        return status;
        
    }
}
