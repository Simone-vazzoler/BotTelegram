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
public class Update {
    Integer update_id;
    Message message;

    public Update() {}

    public Update(Integer update_id, Message message) {
        this.update_id = update_id;
        this.message = message;
    }
    
    public String ToString()
    {
        String s = "";
        s = "\nupdate_id: " + update_id + message.ToString();
        return s;
    }

    public Integer getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(Integer update_id) {
        this.update_id = update_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
