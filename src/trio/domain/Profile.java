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
public class Profile {
    
    String profileName;
    ArrayList<Watch> watchList;
    
public Profile(String profileName){
    this.profileName = profileName;
    
    watchList = new ArrayList<Watch>();
}

public void addWatch(Watch watch) {
    
    watchList.add(watch);
}


}
