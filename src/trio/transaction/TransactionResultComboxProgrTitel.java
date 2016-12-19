/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the name of a profile of a query result
 * @author twanv
 */
public class TransactionResultComboxProgrTitel {
    private String titelProgramma;
    
    /**
     * 
     * @param titelProgramma Title of a programme that the selected profile in the addpanel hasn`t viewed yet.
     */
    public TransactionResultComboxProgrTitel(String titelProgramma) {
        this.titelProgramma = titelProgramma;
    }
    
    /**
     * 
     * @return The title of a programme
     */
    public String getProgramme() {
        return titelProgramma;
    }
    
}
