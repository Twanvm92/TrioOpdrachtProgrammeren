/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.main;

import trio.presentation.NetflixFrame;
import trio.presentation.NetfilxView;
import trio.transaction.TransactionScript;
import trio.transaction.TransactionScript3;

/**
 *
 * @author twanv
 */
public class TrioOpdrachtProgrammeren {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        NetflixFrame frame = new NetflixFrame();
  
        TransactionScript t = new TransactionScript3();
        t.query("F. de Kat");
   
        
    }
    
}
