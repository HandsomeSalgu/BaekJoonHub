import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //문자열 S
        String s = br.readLine();

        //정답
        StringBuffer sb = new StringBuffer();

        //태그가 없다면
        if(!(s.contains(">") || s.contains("<"))){
            String[] strArr = s.split(" ");

            for(int i = 0; i<strArr.length; i++){
                StringBuffer strRev = new StringBuffer(strArr[i]);
                
                sb.append(strRev.reverse());
                if(i != strArr.length -1){
                    sb.append(" ");
                }
            }
            //태그가 있다면
        }else{
            //문자열 s를 담은 StringBuffer
            StringBuffer sb2 = new StringBuffer(s);

            while(sb2.length() != 0){

                if(sb2.charAt(0) == '<'){
                    String str = sb2.substring(sb2.indexOf("<"), sb2.indexOf(">")+1);
                    sb.append(str);
                    sb2.delete(sb2.indexOf("<"), sb2.indexOf(">")+1);

                }else{
                    //끝이 <일 경우와 아닐 경우
                    String str = "";
                    if(sb2.indexOf("<") == -1){
                        str = sb2.substring(0);
                        sb2.delete(0, sb2.length());
                    }else{
                        str = sb2.substring(0, sb2.indexOf("<"));
                        sb2.delete(0, sb2.indexOf("<"));
                    }
                    
                    String[] strArr = str.split(" ");

                    for(int i = 0; i<strArr.length; i++){
                        StringBuffer strRev = new StringBuffer(strArr[i]);
                        
                        sb.append(strRev.reverse());
                        if(i != strArr.length -1){
                            sb.append(" ");
                        }
                    }
                }
                
            }
            
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
