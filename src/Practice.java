import java.io.*;

public class Practice {

    public static void practiceMenu(String langName) throws IOException {

        String choice1 = PracticePickList.practicePickList();

        if (!choice1.equals("4")) {

            if (Handler.isListEmpty(langName, Integer.parseInt(choice1))) {

                System.out.println("    ");
                System.out.println("                                           ░░ Diese liste ist leer.");
                System.out.println("    ");
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("                                           ░░ 1: Eine andere Liste üben         ░░");
                System.out.println("                                           ░░ 2: Zurück zum Hauptmenü           ░░");
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                String choice2 = Main.brUser.readLine();

                while (! Handler.inputIsCorrect(choice2, 2)) {
                    System.out.println(Handler.correctInput(choice2, 2));
                    System.out.println("    ");
                    System.out.print("                                           ░░ > ");
                    choice2 = Main.brUser.readLine();
                }

                switch (choice2) {
                    case "1":
                        Practice.continueAfterEmpty(langName);
                    break;

                    case "2":
                        Menu.menu(langName);
                    break;
                }

            } else {

                System.out.println("    ");
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("                                           ░░ 1: " + langName + " -> Deutsch");
                System.out.println("                                           ░░ 2: Deutsch -> " + langName);
                System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                String lang = Main.brUser.readLine();

                while (! Handler.inputIsCorrect(lang, 2)) {
                    System.out.println(Handler.correctInput(lang, 2));
                    System.out.println("    ");
                    System.out.print("                                           ░░ > ");
                    lang = Main.brUser.readLine();
                }

                switch (choice1) {

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
            }

        } else {
            Menu.menu(langName);
        }
    }

    public static void continueAfterEmpty(String langName) throws IOException {

        Practice.practiceMenu(langName);
    }

}
