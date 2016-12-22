/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a string method that returns the results of the first question
 * @author mikakrooswijk
 */
public class TransactionResult1{
    String serie;
    Double avg;
 
    
    public TransactionResult1(String serie, Double avg){
        this.serie = serie;
        this.avg = avg;
    }
    
      /**
     * Returns a string
     * @return <code>status</code>  The answer that is displayed on the panel
     */
    public String toString(){
          
        
        String status = String.format("Titel: %-20s gemiddelde: %3.2f", serie, avg);
        
        return status;
        
        
    }
}
