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
public class User {
    Integer id;
    Boolean is_bot, can_join_groups, can_read_all_group_messages, supports_inline_queries;
    String first_name, last_name, username, language_code;
    
    public User(){}
    
    public User(Integer id, Boolean is_bot, Boolean can_join_groups, Boolean can_read_all_group_messages, Boolean supports_inline_queries, String first_name, String last_name, String username, String language_code) {
        this.id = id;
        this.is_bot = is_bot;
        this.can_join_groups = can_join_groups;
        this.can_read_all_group_messages = can_read_all_group_messages;
        this.supports_inline_queries = supports_inline_queries;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.language_code = language_code;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot;
    }

    public boolean isCan_join_groups() {
        return can_join_groups;
    }

    public void setCan_join_groups(boolean can_join_groups) {
        this.can_join_groups = can_join_groups;
    }

    public boolean isCan_read_all_group_messages() {
        return can_read_all_group_messages;
    }

    public void setCan_read_all_group_messages(boolean can_read_all_group_messages) {
        this.can_read_all_group_messages = can_read_all_group_messages;
    }

    public boolean isSupports_inline_queries() {
        return supports_inline_queries;
    }

    public void setSupports_inline_queries(boolean supports_inline_queries) {
        this.supports_inline_queries = supports_inline_queries;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
    
    public String ToString()
    {
        String s = "";
        s = "\nUSER: \nid: " + id + "\nis_bot: " + is_bot + "\ncan_join_groups: " + can_join_groups +
            "\ncan_read_all_group_messages:" + can_read_all_group_messages + "\nsupports_inline_queries: " + supports_inline_queries +
            "\nfirst_name: " + first_name + "\nlast_name: " + last_name + "\nusername: " + username + "\nlanguage_code:" + language_code;
        return s;         
    }
    
}
