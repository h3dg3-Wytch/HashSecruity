import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by rex on 4/18/16.
 */
public class md5 {

    public static void main(String[] args){

        String passWordToHash = "password";
        String generatedPassword = null;

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passWordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hex
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = stringBuilder.toString();

        }catch(NoSuchAlgorithmException e){

        }

        System.out.println(generatedPassword);

    }
}
