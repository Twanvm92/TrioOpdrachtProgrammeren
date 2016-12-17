/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class will 
 * @author twanv
 */
public class TransactionResultComboxFilm {
    private String naamFilm;
    
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
