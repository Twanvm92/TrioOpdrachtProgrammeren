/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns the accountnumber of a query result
 * @author twanv
 */
public class TransactionResultComboxAbonnementNr {
    private String abonnementNr;
    
    /**
     * 
     * @param abonnementNr The accountnumber that got caught by a query.
     */
    public TransactionResultComboxAbonnementNr (String abonnementNr) {
        this.abonnementNr = abonnementNr;
    }
    
    /**
     * Returns an accountnumber
     * @return <code>naamAbonnementNr</code>  The name of the account 
     */
    public String getNaam() {
        return abonnementNr;
    }
    
}
