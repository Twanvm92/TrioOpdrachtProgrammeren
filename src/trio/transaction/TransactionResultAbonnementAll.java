/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 * This class has a getrequest that returns everything of a query result
 * @author twanv
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
    
    
     /**
     * Returns a street name
     * @return <code>straat</code>  The name of the street
     */
    public String getStraat() {
        return straat;
    }
    
     /**
     * Returns a city 
     * @return <code>woonplaats</code>  The name of the city
     */
    public String getWoonplaats(){
        return woonplaats;
    }
    
    /**
     * Returns a housenumber
     * @return <code>huisnummer</code>  The housenumber of an account
     */
    public int getHuisnummer() {
        return huisnummer;
    }
    
      /**
     * Returns a postalcode
     * @return <code>postcode</code>  The postalcode of an account
     */
    
    public String getPostcode() {
        return postcode;
    }
    
}
