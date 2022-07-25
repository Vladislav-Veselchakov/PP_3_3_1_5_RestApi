package VL.PP_3_3_1_5_RestApi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ProcessTask {
    public String sessionID;
    public HttpHeaders headers;
    public String URL;
    public RestTemplate restTemplate;

    public ProcessTask() {
        this.URL = "http://94.198.50.185:7081/api/users";
        this.restTemplate = new RestTemplate();
        headers = new HttpHeaders();
    }

    public String getSessionID(){
        HttpHeaders response = restTemplate.headForHeaders(URL);
        sessionID = response.get("set-cookie").get(0);
//        sessionID = sessionID.replace("JSESSIONID=", "");
//        sessionID = sessionID.replace("; Path=/; HttpOnly", "");
//        headers.add("set-cookie", sessionID);
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("cookie", String.join(";", sessID));
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("cookie", sessionID);


//        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
//        this.sessionID = response.getHeaders().get("Set-Cookie").get(0);

/** так нельзя, сбивается sessionID
 User[] arrUsers = null;
 ResponseEntity<User[]> respArr = restTemplate.getForEntity(URL, User[].class);
 //        String sUsers = response.getBody().toString().replace(", ", "/r/n");
 List<User> users = Arrays.asList(respArr.getBody());
 System.out.println("getSessionID() --> users:");
 users.forEach(x-> System.out.println(x));

 System.out.println(response.getBody().toString());
 */
        return sessionID;
    }

    public String saveUser(User pUser) {
        HttpEntity<User> request = new HttpEntity<>(pUser, headers);
        ResponseEntity<String> response = restTemplate
                .exchange(URL, HttpMethod.POST, request, String.class);

        String res = response.getBody();
        return res;
    }

    public String updateUser(User pUser) {

        HttpEntity<User> requestUpdate = new HttpEntity<>(pUser, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://94.198.50.185:7081/api/users", HttpMethod.PUT, requestUpdate, String.class);

        return response.getBody();
    }

    public String deleteUser() {


        HttpEntity<User> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                "http://94.198.50.185:7081/api/users/3", HttpMethod.DELETE, request, String.class);

        return response.getBody();

/** no work
 Map<String, Long> uriVariables = new HashMap<>() {{
 put("id", 3L);
 }};
 HttpEntity<String> entity = new HttpEntity<>(null, headers);
 ResponseEntity<String> respEnt =  restTemplate.exchange(
 "http://94.198.50.185:7081/api/users/3", HttpMethod.DELETE, entity, String.class, uriVariables);
 return respEnt.getBody();
 */

//        User user2add = new User(3L, "James", "Brown",  (byte) 2);
//        user2add.setName("Thomas");
//        user2add.setLastName("Shelby");
//
//        HttpEntity<User> request = new HttpEntity<>(user2add, headers);
//        ResponseEntity response = restTemplate.exchange("http://94.198.50.185:7081/api/users" + "/3",
//                HttpMethod.DELETE, request, String.class);
//
//        String sBody = (String) response.getBody();
//        return sBody;

    }

} // public class ProcessTask {

