/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.domain;

import java.util.ArrayList;

/**
 *
 * @author lukab
 */
public class Subscription {
    int subscriptionNr;
    String name,postalCode, street;
    int houseNumber;
    ArrayList <Profile> profileList;
    
public Subscription (int subscriptionNr){
    
    this.subscriptionNr = subscriptionNr;
    profileList = new ArrayList<Profile>();
    
}

public void addProfile (Profile profile){
    
    profileList.add(profile);
}
}
