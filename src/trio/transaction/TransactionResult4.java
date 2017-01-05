/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a string method that returns the results of the fourth question
 * @author lukab
 */
public class TransactionResult4 {
       String title;
       String duration;
       int viewerGuide;
    
    public TransactionResult4(String title, int viewerGuide, String duration){
        this.title = title;
        this.duration = duration;
        this.viewerGuide = viewerGuide;
       
    }
    
      /**
     * Returns a string
     * @return <code>status</code>  The answer that is displayed on the panel
     */
    public String toString(){
          
        
      String status =  String.format("Titel film: %-30s  Leeftijdsindicatie: %2d jaar Tijdsduur: %3s minuten", title, viewerGuide, duration);
        
        return status;
        
    }
}
