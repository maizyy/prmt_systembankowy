import java.io.IOException;
import java.util.Scanner;

public class Login {
    public final String DATABASE_PATH = "data.csv";
    public final int BASE_BALANCE = 0;
    public final int BASE_INVEST = 0;
    public final char CSV_POINT = ';';
    private void starter() throws InterruptedException {
        Scanner console = new Scanner(System.in);
        Authorization a = new Authorization();
        System.out.print("Operacje:\n 1 - logowanie \n 2 - zakładanie konta \nWybieram: ");
        try{
            int sw = console.nextInt();
            switch (sw ){
                case 1: {
                    System.out.println("LOGOWANIE");

                    break;
                }
                case 2: {
                    System.out.println("ZAKŁADANIE KONTA");
                    System.out.print("Podaj nową nazwe uzytkownika: ");
                    String name = console.next();
                    System.out.print("Podaj nowe haslo: ");
                    String pass1 = console.next();
                    System.out.print("Potwierdz nowe haslo: ");
                    String pass2 = console.next();
                    boolean auth = a.getid();
                    if (pass1.equals(pass2)&& auth){
                        new CreateAccount().create(name,pass1);
                        System.out.println("Własnie załozyles konto !!!!");
                    }
                    else{
                        System.out.println("zle podane haslo spobuj zarejestrowac sie jeszcze raz");
                    }
                    starter();
                    break;
                }
                case 0:{
                    System.out.println("Wyszedłęś z programu");
                    break;
                }
            }


        }catch (Exception e){
            e.getStackTrace();
            System.err.println("oj -1 byczku -1");
        }




    }




    public static void main(String[] args) throws InterruptedException, IOException {
       Login login = new Login();
       login.starter();





    }


}