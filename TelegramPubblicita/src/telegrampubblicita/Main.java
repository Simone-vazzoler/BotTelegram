/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telegrampubblicita;

import TelegramApi.*;   
import TelegramApi.User;
import TelegramApi.Update;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Miky
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Functions fx = new Functions();
        String scelta = "0";
        do
        {
            System.out.println("\nScelta:");
            System.out.println("[1]GetMe\n[2]GetUpdates\n[3]SendMessage\n[4]GetCoordinate");

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            scelta = myObj.nextLine();

            switch(scelta)
            {
                case "1":
                    User user = fx.getMe();
                    System.out.println(user.ToString());
                    break;
                    
                case "2":
                    Vector<Update> ArrayUpdates = fx.getUpdates();
                    for(Update element:ArrayUpdates)
                    {
                        System.out.println(element.ToString());
                    }
                    break;
                case "3":
                    System.out.println("\nchat id:");
                    String chat_id = myObj.nextLine();
                    
                    System.out.println("\ntesto:");
                    String text = myObj.nextLine();
                    System.out.println("");
                    
                    Message mess = fx.sendMessage(chat_id, text);
                    System.out.println(mess.ToString()); 
                    break;
                case "4":
                    String indirizzo = "mariano comense, monnet";
                    fx.getCoordinate(indirizzo);
                    break;
            }
        }
        while(!scelta.equals("-1"));
    }
}
