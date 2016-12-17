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
public class TransactionResultComboxAbonnement {
    private String naamAbonnement;
    
    public TransactionResultComboxAbonnement (String naamAbonnement) {
        this.naamAbonnement = naamAbonnement;
    }
    
    /**
     * 
     * @return <code>naamAbonnement</code>  The name of the subscriber 
     */
    public String getNaam() {
        return naamAbonnement;
    }
    
}
