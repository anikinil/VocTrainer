import java.io.IOException;

public class PracticePickList {

    static String practicePickList() throws IOException {

        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Liste 1 üben                   ░░");
        System.out.println("                                           ░░ 2: Liste 2 üben                   ░░");
        System.out.println("                                           ░░ 3: Liste 3 üben                   ░░");
        System.out.println("                                           ░░ 4: Zurück                         ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice1 = Main.brUser.readLine();

            while (! Handler.inputIsCorrect(choice1, 4)) {
            System.out.println(Handler.correctInput(choice1, 4));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            choice1 = Main.brUser.readLine();
        }

        return choice1;
    }
}
