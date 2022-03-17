/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

/**
 *
 * @author Miky
 */
public class Message {
    Integer message_id;
    User from;
    Integer date;
    Chat chat;
    String text;

    public Message(){}
    
    public Message(Integer message_id, User from, Integer date, Chat chat, String text) {
        this.message_id = message_id;
        this.from = from;
        this.date = date;
        this.chat = chat;
        this.text = text;
    }

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String ToString()
    {
        String s = "";
        s = "\nMESSAGE: \nmessage_id: " + message_id + from.ToString() + "\ndate: " + date + chat.ToString() + "\ntext: " + text;
        return s;
    }
    
}
