/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 *
 * @author lukab
 */
public class TransactionResultAbonnementAll {
    
    String naam, postcode, straat, woonplaats;
    int huisnummer;
    
     public TransactionResultAbonnementAll (String naam, String postcode, String straat, int huisnummer, String woonplaats) {
        this.naam = naam;
        this.postcode = postcode;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.woonplaats = woonplaats;
    }
    
    /**
     * Returns an account name
     * @return <code>naamAbonnement</code>  The name of the account 
     */
    public String getNaam() {
        return naam;
    }
    
    public String getStraat() {
        return straat;
    }
    
    public String getWoonplaats(){
        return woonplaats;
    }
    
    public int getHuisnummer() {
        return huisnummer;
    }
    
    public String getPostcode() {
        return postcode;
    }
    
}
