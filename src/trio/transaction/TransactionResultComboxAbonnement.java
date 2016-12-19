/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the account name of a query result
 * @author twanv
 */
public class TransactionResultComboxAbonnement {
    private String naamAbonnement;
    
    /**
     * 
     * @param naamAbonnement The name of an account that got caught by a query.
     */
    public TransactionResultComboxAbonnement (String naamAbonnement) {
        this.naamAbonnement = naamAbonnement;
    }
    
    /**
     * Returns an account name
     * @return <code>naamAbonnement</code>  The name of the account 
     */
    public String getNaam() {
        return naamAbonnement;
    }
    
}
