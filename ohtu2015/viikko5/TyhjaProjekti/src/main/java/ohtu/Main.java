package ohtu;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014454998";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        System.out.println("opiskelijanumero " + subs[0].getStudent_number());
        int yhteensa = 0;
        int yaika = 0;
        for (Submission submission : subs) {
            System.out.print("viikko " + submission.getWeek());
            System.out.println(submission.toString());
            yhteensa += submission.yhteensa;
            yaika += Integer.parseInt(submission.getHours());
        }
        System.out.println("Yhteensa " + yhteensa + " tehtävää  " + yaika + " tuntia ");

    }
}
