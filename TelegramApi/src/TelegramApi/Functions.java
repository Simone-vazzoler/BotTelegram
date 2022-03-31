/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.json.*;
import org.xml.sax.SAXException;
/**
 *
 * @author pepe_michele
 */

public class Functions {
    public User getMe()
    {
        User user = new User();
        try {
        URL url = new URL("https://api.telegram.org/bot5166377045:AAFU5fK4x0_sHZTV6h0vukRvO0kdk4CyEAo/getMe");
        String inline = LeggiContenuto(url); //leggo il contenuto dell'url
        JSONObject obj = new JSONObject(inline); //lo trasformo in JSONObject
        JSONObject res = (JSONObject) obj.get("result"); //prendo l'oggetto result
        
        Integer id = res.getInt("id");
        Boolean is_bot = res.getBoolean("is_bot");
        
        Boolean can_join_groups = null;
        if(res.has("can_join_groups")) //attributo opzionale 
            can_join_groups = res.getBoolean("can_join_groups");
        
        Boolean can_read_all_group_messages = null;
        if(res.has("can_read_all_group_messages")) //attributo opzionale 
            can_read_all_group_messages = res.getBoolean("can_read_all_group_messages");
        
        Boolean supports_inline_queries = null;
        if(res.has("can_read_all_group_messages")) //attributo opzionale 
            supports_inline_queries = res.getBoolean("supports_inline_queries");
       
        String first_name = res.getString("first_name");
        
        String last_name = "NULL";
        if(res.has("last_name")) //attributo opzionale 
            last_name = res.getString("last_name");
        
        String username = "NULL";
        if(res.has("username")) //attributo opzionale 
            username = res.getString("username");
            
        String language_code = "NULL";
        if(res.has("language_code")) //attributo opzionale 
            language_code = res.getString("language_code");
        
        user = new User(id, is_bot, can_join_groups, can_read_all_group_messages, supports_inline_queries, first_name, last_name, username, language_code);
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public Vector<Update> getUpdates()
    {
        Vector<Update> ArrayUpdates = new Vector<Update>();
        
        try {
        URL url = new URL("https://api.telegram.org/bot5166377045:AAFU5fK4x0_sHZTV6h0vukRvO0kdk4CyEAo/getUpdates");
        
        String inline = LeggiContenuto(url);
        JSONObject obj = new JSONObject(inline);
        JSONArray res = (JSONArray) obj.get("result"); //prendo il vettore result
       
        for(int i = 0; i < res.length(); i++)
        {
            JSONObject obj2 = res.getJSONObject(i); //prendo l'oggetto del vettore result
            
            Integer update_id = obj2.getInt("update_id");
            
            //Oggetto Messagge
            JSONObject objMess = (JSONObject) obj2.get("message"); //JSONObject Messagge
            Integer message_id = objMess.getInt("message_id");
            Integer date = objMess.getInt("date");
            String text = objMess.getString("text");

            //Oggetto from che andrà dentro a Messaggio
            JSONObject Objfrom = (JSONObject) objMess.get("from"); //prendo l'oggetto from da Message
            String first_name = Objfrom.getString("first_name");
            Integer id = Objfrom.getInt("id");
            Boolean is_bot = Objfrom.getBoolean("is_bot");
            
            Boolean can_join_groups = null;
            if(Objfrom.has("can_join_groups")) //attributo opzionale 
                can_join_groups = Objfrom.getBoolean("can_join_groups");

            Boolean can_read_all_group_messages = null;
            if(Objfrom.has("can_read_all_group_messages")) //attributo opzionale 
                can_read_all_group_messages = Objfrom.getBoolean("can_read_all_group_messages");

            Boolean supports_inline_queries = null;
            if(Objfrom.has("can_read_all_group_messages")) //attributo opzionale 
                supports_inline_queries = Objfrom.getBoolean("supports_inline_queries");

            String last_name = "NULL";
            if(Objfrom.has("last_name")) //attributo opzionale 
                last_name = Objfrom.getString("last_name");

            String username = "NULL";
            if(Objfrom.has("username")) //attributo opzionale 
                username = Objfrom.getString("username");

            String language_code = "NULL";
            if(Objfrom.has("language_code")) //attributo opzionale 
                language_code = Objfrom.getString("language_code");
            
            //costruttore from che andrà dentro Messagge
            User user = new User(id, is_bot, can_join_groups, can_read_all_group_messages, supports_inline_queries, first_name, last_name, username, language_code);

            //Oggetto Chat che andrà dentro Message
            JSONObject objChat = (JSONObject) objMess.get("chat"); //prendo l'oggetto chat da Message
            Integer idchat = objChat.getInt("id");
            
            String first_nameChat = "NULL";
            if(objChat.has("first_name")) //attributo opzionale 
                first_nameChat = objChat.getString("first_name");
            
            String type = objChat.getString("type");
            
            //costruttore chat che andrà dentro Message
            Chat chat = new Chat(idchat, type, first_nameChat);
            
            Message mess = new Message(message_id, user, date, chat, text);
            
            ArrayUpdates.add(new Update(update_id, mess));
        }
        //metto thread che controlla se il messaggio dell utente inizia con /città (funzione start with)
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ArrayUpdates;
    }
    
    public void getCoordinate(String indirizzo) throws IOException, SAXException, ParserConfigurationException{
        String URLindirizzo = URLEncoder.encode(indirizzo, StandardCharsets.UTF_8); //url encodo il messaggio
        
        URL openAPI = new URL("https://nominatim.openstreetmap.org/search?q=" + URLindirizzo + "&format=xml&addressdetails=1");
        FileWriter fw = new FileWriter("coordinate.xml");
         //salvo il file xml preso dall'url
        //codice per parsing xml
        
        Scanner sc = new Scanner(openAPI.openStream());
        sc.useDelimiter("\u001a");
        fw.write(sc.next());
        
        fw.flush();
        fw.close();
        Gestore g = new Gestore("coordinate.xml");
        g.creaLista();
        
        //creo una lista con i tag dell'XML di open, prendo da li long e lat.
        //devo poi restituire questi campi
       
        
        
    }
    
    public Message sendMessage(String chat_id, String testo)
    {
        Message mess = new Message();
        try {
        URL url = new URL("https://api.telegram.org/bot5166377045:AAFU5fK4x0_sHZTV6h0vukRvO0kdk4CyEAo/sendMessage?chat_id=" + chat_id + "&text=" + testo);
        
        String inline = LeggiContenuto(url);
        
        //Using the JSON simple library parse the string into a json object
        JSONObject obj = new JSONObject(inline);
        JSONObject res = (JSONObject) obj.get("result"); //prendo l'object JSON result
        
        Integer message_id = res.getInt("message_id");
        
        JSONObject Objfrom = (JSONObject) res.get("from"); //prendo l'object JSON from da result
        String first_name = Objfrom.getString("first_name");
        Integer id = Objfrom.getInt("id");
        Boolean is_bot = Objfrom.getBoolean("is_bot");

        Boolean can_join_groups = null;
        if(Objfrom.has("can_join_groups")) //attributo opzionale 
            can_join_groups = Objfrom.getBoolean("can_join_groups");

        Boolean can_read_all_group_messages = null;
        if(Objfrom.has("can_read_all_group_messages")) //attributo opzionale 
            can_read_all_group_messages = Objfrom.getBoolean("can_read_all_group_messages");

        Boolean supports_inline_queries = null;
        if(Objfrom.has("can_read_all_group_messages")) //attributo opzionale 
            supports_inline_queries = Objfrom.getBoolean("supports_inline_queries");

        String last_name = "NULL";
        if(Objfrom.has("last_name")) //attributo opzionale 
            last_name = Objfrom.getString("last_name");

        String username = "NULL";
        if(Objfrom.has("username")) //attributo opzionale 
            username = Objfrom.getString("username");

        String language_code = "NULL";
        if(Objfrom.has("language_code")) //attributo opzionale 
            language_code = Objfrom.getString("language_code");
        
        User from = new User(id, is_bot, can_join_groups, can_read_all_group_messages, supports_inline_queries, first_name, last_name, username, language_code);
        
        JSONObject objChat = (JSONObject) res.get("chat"); //prendo l'object JSON chat da result
        String idChat = objChat.get("id").toString();
        
        String first_nameChat = "NULL";
        if(objChat.has("first_name"))
            first_nameChat = objChat.get("first_name").toString();
        
        String type = objChat.get("type").toString();
        
        Integer date = res.getInt("date");
        String text = res.get("text").toString();
        
        Chat chat = new Chat(id, type, first_name);
        
        mess = new Message(message_id, from, date, chat, text);
        
        } catch (MalformedURLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mess;
    }
    

    private String LeggiContenuto(URL url) throws IOException
    {
        String inline = "";
        Scanner scanner = new Scanner(url.openStream());
  
        //Write all the JSON data into a string using a scanner
        while (scanner.hasNext()) {
           inline += scanner.nextLine();
        }
        //Close the scanner
        scanner.close();
        return inline;
    }
}
