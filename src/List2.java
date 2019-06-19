
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class List2 {

    static void list2(String langName) throws IOException {

        System.out.println("    ");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ Liste 2 ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");


        if (Handler.isListEmpty(langName, 2)) {

            System.out.println("░░");
            System.out.println("░░      Diese Liste ist leer.");
            System.out.println("░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        } else {

            for (int j = 0; j < Handler.getLength(langName, 2); j++) {
                String[] temp = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list2csv)).get(j).split(";");

                System.out.println("░░");

                try { System.out.print("░░  " + (j + 1) + ".  " + temp[0]); }
                catch (Exception E) { System.out.print("░░  " + (j + 1) + ".  " + ""); }

                try { System.out.print("  --  " + temp[1]); }
                catch (Exception E) { System.out.print("  --  " + ""); }

                try { System.out.print("      // " + temp[2]); }
                catch (Exception E) { System.out.print(" "); }

                double percentage = (Double.parseDouble(temp[3]) / Double.parseDouble(temp[4])) * 100;

                if (temp[4] == "1") { System.out.print("      [" + temp[4] + " Test]"); }
                else { System.out.print("      [" + temp[4] + " Tests]"); }

                if (Double.parseDouble(temp[4]) == 0) { System.out.print("  [new]"); }
                else { System.out.print("  [" + String.format("%.2f", percentage) + "% ✔]"); }

                if (!temp[6].equals("-")) {
                    System.out.print("      (Eingabe: " + temp[5] + ")");
                    System.out.println("      (Letzte Übung: " + temp[6] + ")");
                } else {
                    System.out.println("      (Eingabe: " + temp[5] + ")");
                }
            }

            System.out.println("░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        }

        ListsMenu.listsMenu(langName,"2");
    }
}
