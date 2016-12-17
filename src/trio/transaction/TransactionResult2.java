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
public class TransactionResult2{
    String account;
    Double avg;
 
    
    public TransactionResult2(String account, Double avg){
        this.account = account;
        this.avg = avg;
    }
    
    
    public String toString(){
          
        String s = " ";
        s = "account: " + account +  " gemiddelde: " + avg + "%";
        
        return s;
        
        
    }
}
