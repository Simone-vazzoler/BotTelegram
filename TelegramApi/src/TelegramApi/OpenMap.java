/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelegramApi;

//https://www.spadamar.com/archivio/2015/11/geolocalizzazione-di-indirizzi-geocoding-con-php-o-jquery-e-nominatim-di-openstreetmap/
/**
 *
 * @author Zenmetsu
 */
public class OpenMap {
    //url open map web api
    String URLopen ="https://nominatim.openstreetmap.org/search?q=";
    String indirizzo;
    String query;
    
    public String getCoordinate(String indirizzo){
        query = indirizzo + "&format=json&addressdetails=1";
        URLopen += query;
        return URLopen;
    }
}
