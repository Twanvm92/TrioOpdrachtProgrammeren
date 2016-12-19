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
public class TransactionResultComboxProfiel {
    private String naamProfiel;
    
    /**
     * 
     * @param naamProfiel The name of a profile that got caught by a query
     */
    public TransactionResultComboxProfiel(String naamProfiel) {
        this.naamProfiel = naamProfiel;
    }
    
    /**
     * 
     * @return The titel of a serie
     */
    public String getNaam() {
        return naamProfiel;
    }
    
}
