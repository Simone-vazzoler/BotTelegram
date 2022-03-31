/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zenmetsu
 */
public class ThreadCoordinate extends Thread {

    Functions f;

    public ThreadCoordinate(Functions f) {
        this.f = f;
    }
    
    
    public String checkCoordinate(){
        Vector<Update> ArrayUpdates= f.getUpdates();
        String città = "";
        for(Update element:ArrayUpdates){
            String messaggio = element.toString();
            if(messaggio.startsWith("/città:")){
                città = messaggio.substring(messaggio.lastIndexOf(":") + 1);
            }
        }
        return città;
    }
    
    @Override
    public void run(){
        try {
            checkCoordinate();
            ThreadCoordinate.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadCoordinate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
