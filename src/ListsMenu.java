import java.io.IOException;

public class ListsMenu {

    static void listsMenu(String langName, String listNr) throws IOException {

        System.out.println("                                           ░░                                   ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Wort löschen                   ░░");
        System.out.println("                                           ░░ 2: Wort bearbeiten                ░░");
        System.out.println("                                           ░░ 3: Liste üben                     ░░");
        System.out.println("                                           ░░ 4: Eine andere Liste aufrufen     ░░");
        System.out.println("                                           ░░ 5: Zurück zum Hauptmenü           ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(choice, 5)) {

            System.out.println(Handler.correctInput(choice, 5));
            System.out.println("    ");
            System.out.print("                   ░░ > ");
            choice = Main.brUser.readLine();
        }

        switch (choice){

            case "1":
                Delete.delete(langName, Integer.parseInt(listNr));
                break;

            case "2":
                Edit.edit(langName, Integer.parseInt(listNr));
                break;

            case "3":

                System.out.println("    ");
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("                                           ░░ 1: " + langName + " -> Deutsch");
                System.out.println("                                           ░░ 2: Deutsch -> " + langName);
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                String lang = Main.brUser.readLine();

                while (! Handler.inputIsCorrect(lang, 2)) {
                    System.out.println(Handler.correctInput(langName, 2));
                    System.out.println("    ");
                    System.out.print("                                           ░░ > ");
                    lang = Main.brUser.readLine();
                }

                switch (listNr) {

                    case "1":
                        Practice1.practice1(langName, Integer.parseInt(lang));
                    break;

                    case "2":
                        Practice2.practice2(langName, Integer.parseInt(lang));
                    break;

                    case "3":
                        Practice3.practice3(langName, Integer.parseInt(lang));
                    break;
                }

            case "4":
                Lists.lists(langName);
            break;

            case "5":
                Menu.menu(langName);
            break;
        }
    }
}
