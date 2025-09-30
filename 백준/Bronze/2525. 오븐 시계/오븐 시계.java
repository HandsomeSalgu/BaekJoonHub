import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String hourMin = br.readLine();
        int hour = Integer.parseInt((hourMin.split(" "))[0]);
        int min = Integer.parseInt((hourMin.split(" "))[1]);

        int pass = Integer.parseInt(br.readLine());

        int time = hour * 60 + min + pass;
        hour = (time / 60) % 24;
        min = time % 60;

        bw.write(hour + " " + min);

        bw.flush();
    }
}