public class Main {
    public static void main(String[] args)
    {


        String[] document = {"1abc2",
                            "pqr3stu8vwx",
                            "a1b2c3d4e5f",
                            "treb7uchet"
        };

        boolean prvniCisliceNalezena = true;
        int prvniCislice=0;
        int posledniCislice=0;
        int soucet = 0;

        for (int i = 0; i < document.length ; i++) {

            for (int j = 0; j < document[i].length(); j++) {

                char charakter  = document[i].charAt(j);
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
}