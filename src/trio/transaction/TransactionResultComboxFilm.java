/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the name of a film of a query result
 * @author twanv
 */
public class TransactionResultComboxFilm {
    private String naamFilm;
    
    /**
     * 
     * @param naamFilm The name of a film that got caught by a query
     */
    public TransactionResultComboxFilm (String naamFilm) {
        this.naamFilm = naamFilm;
    }
    
    /**
     * 
     * @return <code>naamAbonnement</code>  The name of the subscriber 
     */
    public String getFilm() {
        return naamFilm;
    }
    
}
