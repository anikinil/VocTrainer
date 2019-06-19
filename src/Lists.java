
import java.io.IOException;

public class Lists {

    static void lists(String langName) throws IOException {


        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Liste 1 (jeden Tag)            ░░");
        System.out.println("                                           ░░ 2: Liste 2 (alle drei Tage)       ░░");
        System.out.println("                                           ░░ 3: Liste 3 (jede Woche)           ░░");
        System.out.println("                                           ░░ 4: Zurück                         ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String listNr = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(listNr, 4)) {
            System.out.println(Handler.correctInput(String.valueOf(listNr), 4));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            listNr = Main.brUser.readLine();
        }

        switch (listNr) {
            case "1":
                List1.list1(langName);
            break;

            case "2":
                List2.list2(langName);
            break;

            case "3":
                List3.list3(langName);
            break;
            
            case "4":
                Menu.menu(langName);
        }

    }
}
