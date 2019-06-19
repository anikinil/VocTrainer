import java.io.IOException;

public class Menu {

    public static void menu(String langName) throws IOException {


        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Neues Wort hinzufügen          ░░");
        System.out.println("                                           ░░ 2: Eine Liste aufrufen            ░░");
        System.out.println("                                           ░░ 3: Ranking                        ░░");
        System.out.println("                                           ░░ 4: Vokabeln üben                  ░░");
        System.out.println("                                           ░░ 5: Sprachen verwalten             ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(choice, 5)) {
            System.out.println(Handler.correctInput(choice, 5));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            choice = Main.brUser.readLine();
        }

        switch(choice) {

            case "1":
                Add.add(langName);
            break;

            case "2":
                Lists.lists(langName);
            break;

            case "3":
                Ranking.ranking(langName);
            break;

            case "4":
                Practice.practiceMenu(langName);
            break;

            case "5":
                Langs.langMenu();
            break;
        }
    }
}
