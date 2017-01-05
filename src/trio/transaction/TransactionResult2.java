/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a string method that returns the results of the second question
 * @author mikakrooswijk
 */
public class TransactionResult2{
    String account;
    Double avg;
 
    
    public TransactionResult2(String account, Double avg){
        this.account = account;
        this.avg = avg;
    }
    
      /**
     * Returns a string
     * @return <code>s</code>  The answer that is displayed on the panel
     */
    
    public String toString(){
          
        String s = " ";
        s = "account: " + account +  " gemiddelde: " + avg + "%";
        
        return s;
        
        
    }
}
