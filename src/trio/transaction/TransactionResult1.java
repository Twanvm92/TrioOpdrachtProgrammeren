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
public class TransactionResult1{
    String serie;
    Double avg;
 
    
    public TransactionResult1(String serie, Double avg){
        this.serie = serie;
        this.avg = avg;
    }
    
    
    public String toString(){
          
        
        String status = String.format("Titel: %-20s gemiddelde: %3.2f", serie, avg);
        
        return status;
        
        
    }
}
