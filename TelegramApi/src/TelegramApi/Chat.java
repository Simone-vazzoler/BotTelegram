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
public class Chat {
    Integer id;
    String type, first_name;

    public Chat(Integer id, String type, String first_name) {
        this.id = id;
        this.type = type;
        this.first_name = first_name;
    }
    
    public String ToString()
    {
        String s = "";
        s = "\nCHAT: \nid: " + id + "\ntype: " + type + "\nfirst_name: " + first_name;
        return s;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
