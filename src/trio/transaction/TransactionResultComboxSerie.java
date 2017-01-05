/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the title of a serie of a query result
 * @author twanv
 */
public class TransactionResultComboxSerie {
    private String titelSerie;
    
    /**
     * 
     * @param titelSerie The title of a serie that got caught by a query
     */
    public TransactionResultComboxSerie(String titelSerie) {
        this.titelSerie = titelSerie;
    }
    
    /**
     * 
     * @return The titel of a serie
     */
    public String getTitel() {
        return titelSerie;
    }
    
}
