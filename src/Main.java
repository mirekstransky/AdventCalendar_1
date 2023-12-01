import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> listOfQuote = readAllLines("input.txt");

        boolean prvniCisliceNalezena = true;
        int prvniCislice=0;
        int posledniCislice=0;
        int soucet = 0;
        System.out.println(listOfQuote.size());
        System.out.println(listOfQuote.get(0));

        for (int i = 0; i < listOfQuote.size() ; i++) {

            for (int j = 0; j < listOfQuote.get(i).length(); j++) {

                char charakter  = listOfQuote.get(i).charAt(j);
                String charStr = String.valueOf(charakter);

                if (isNumeric(charStr)){
                    if (prvniCisliceNalezena){
                        prvniCislice = Integer.parseInt(charStr);
                    }
                    prvniCisliceNalezena = false;
                    posledniCislice = Integer.parseInt(charStr);
                }
            }
            System.out.printf("\nPrvní číslice je: %d , poslední číslice je: %d",prvniCislice,posledniCislice);
            int spojeniRetezce = Integer.parseInt(Integer.toString(prvniCislice) + Integer.toString(posledniCislice));
            soucet += spojeniRetezce;
            prvniCisliceNalezena = true;
        }
        System.out.printf("\nSoučet všech čísel je: %d",soucet);
    }
    public static boolean isNumeric(String num) {
        if (num == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(num);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static List<String> readAllLines(String resource)throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        try(InputStream inputStream=classLoader.getResourceAsStream(resource);
            BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))){

            return reader.lines().collect(Collectors.toList());
        }
    }
}