/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trio.transaction;

/**
 *
 * @author Mika Krooswijk
 */
public class TransactionResultProgramID{
    
    String programmaID;
    
    public TransactionResultProgramID(String id){
        this.programmaID = id;
    }
    
    public String getNaam(){
        return programmaID;
    }
    
}
