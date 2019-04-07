    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
package tempo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
    
public class Requests {
public static void main(String[] args) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = login("test@test.test", "Test");
        System.out.println(jsonResponse.getBody() + " " + jsonResponse.getStatus());
}

    public static HttpResponse<JsonNode> login(String usr, String psw) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/login";
	
        return Unirest.post(url)
    //  .header("accept", "application/json")
    //  .header("Authorization", "QWMztwfKdcALhuLhBVDrunEyTtLWSAiHpGaHvmIUkByJFTVUWL")
    //  .queryString("apiKey", "123")
      .field("email", usr)
      .field("password", psw)
      .asJson();
        
    }
    
    public static HttpResponse<JsonNode> create(String usr, String psw, String email, String phone) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/create";
	
        return Unirest.post(url)
    //  .header("accept", "application/json")
    //  .header("Authorization", "QWMztwfKdcALhuLhBVDrunEyTtLWSAiHpGaHvmIUkByJFTVUWL")
    //  .queryString("apiKey", "123")
      .field("username", usr)
      .field("password", psw)
      .field("email", email)
      .field("phone", phone)
      .asJson();
        
    }
    
    public static HttpResponse<JsonNode> createEvent(String auth, String name, String description, int type, String due, int dif, int pid) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/event/create";
	
        return Unirest.post(url)
    //  .header("accept", "application/json")
      .header("Authorization", auth)
    //  .queryString("apiKey", "123")
      .field("name", name)
      .field("description", description)
      .field("type", type)
      .field("duedate", due)
      .field("difficulty", dif)
      .field("parent_id", pid)
      .asJson();
        
    }
    
    public static HttpResponse<JsonNode> getEvents(String auth) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/event/all";
	
        return Unirest.get(url)
    //  .header("accept", "application/json")
      .header("Authorization", auth)
      .asJson();
        
    }
    
    public static HttpResponse<JsonNode> getEventId(String auth, int id) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/login/event/" + id;
	
        return Unirest.get(url)
    //  .header("accept", "application/json")
      .header("Authorization", auth)
    //  .queryString("apiKey", "123")
      .asJson();
        
    }
    
    public static HttpResponse<JsonNode> delEventId(String auth, int id) throws UnirestException{
        String url = "https://api.tempoapp.pro/v1/login/event/" + id;
	
        return Unirest.delete(url)
    //  .header("accept", "application/json")
      .header("Authorization", auth)
    //  .queryString("apiKey", "123")
      .asJson();
        
    }

}