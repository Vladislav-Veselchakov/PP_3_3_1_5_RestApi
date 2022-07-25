package VL.PP_3_3_1_5_RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pp3315RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pp3315RestApiApplication.class, args);
// it works:       ApplicationContext AppContext = SpringApplication.run(Main_3315_RestApi_App.class, args);
        System.out.println("============================ VL ==========================");
        StringBuilder sbAnswer = new StringBuilder();
        String res = null;
        ProcessTask pTask = new ProcessTask();

/** does'nt work 'get context'
 // https://stackoverflow.com/questions/21827548/spring-get-current-applicationcontext
 WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
 ProcessTask pTask = context.getBean(ProcessTask.class);
 String res = pTask.getAllUsers();
 */
//  work:      https://www.netsurfingzone.com/spring-boot/how-to-get-applicationcontext-in-spring-boot/


        /////////////////////////  get Session ID  //////////////////////////////////
        System.out.println("Session ID 001:");
        pTask.getSessionID();
        System.out.println(pTask.sessionID);

        //////////////////// 1st answer - Save user /////////////////////////////////////////////
        User uJames = new User(3L, "James", "Brown", (byte)22);
        res = pTask.saveUser(uJames);
        sbAnswer.append(res);
        System.out.println("res 001: \n" + res);

        ///////////////// 2nd answer - Update user  ////////////////////////////////////////////
        uJames.setName("Thomas");
        uJames.setLastName("Shelby");
        res = pTask.updateUser(uJames);
        System.out.println("res 2: \n" + res);
        sbAnswer.append(res);

        ///////////////////////// 3rd answer - delete user //////////////////////////////////
        res = pTask.deleteUser();
        sbAnswer.append(res);
        System.out.println("res 3: \n" + res);

        /////////////////////// required Answer ///////////////////////////////
        System.out.println("required Answer:");
        System.out.println(sbAnswer.toString());




    } // public static void main(String[] args) {
} // public class Pp3315RestApiApplication {
