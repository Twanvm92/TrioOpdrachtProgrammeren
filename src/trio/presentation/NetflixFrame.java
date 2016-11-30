/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.presentation;
import javax.swing.*;

/**
 *
 * @author lukab
 */
public class NetflixFrame extends JFrame {
    
    public NetflixFrame() {
        setSize ( 600, 600);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle ( "Netflix Statistix");
        setContentPane (new NetflixPanel());
        setVisible( true );
                
                }
    
}
