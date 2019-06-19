import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ranking {

    public static void ranking(String langName) throws IOException {

        System.out.println("    ");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░ Ranking ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        if (Handler.isListEmpty(langName, 1) && Handler.isListEmpty(langName, 2) && Handler.isListEmpty(langName, 3)) {

            System.out.println("░░");
            System.out.println("░░      Alle Listen sind leer.");
            System.out.println("░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        } else {

            List<String[]> tempListAll = new ArrayList<>();
            List<String[]> tempListNews = new ArrayList<>();

            String[] tempString;

            for (int j = 0; j < Handler.getLength(langName, 1); j++) {
                tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(j).split(";");
                if (tempString[4].equals("0")) {
                    tempListNews.add(tempString);
                } else {
                    tempListAll.add(tempString);
                }
            }

            for (int j = 0; j < Handler.getLength(langName, 2); j++) {
                tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list2csv)).get(j).split(";");
                if (tempString[4].equals("0")) {
                    tempListNews.add(tempString);
                } else {
                    tempListAll.add(tempString);
                }
            }

            for (int j = 0; j < Handler.getLength(langName, 3); j++) {
                tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list3csv)).get(j).split(";");
                if (tempString[4].equals("0")) {
                    tempListNews.add(tempString);
                } else {
                    tempListAll.add(tempString);
                }
            }


            //////////////////////////////////////////////////////////////////////////////////////// sorting ///////////

            for (int i = 0; i < tempListAll.size() - 1; i++) {

                double value1 = Double.parseDouble(tempListAll.get(i)[3]) / Double.parseDouble(tempListAll.get(i)[4]);

                for (int j = i + 1; j < tempListAll.size(); j++) {

                    double value2 = Double.parseDouble(tempListAll.get(j)[3]) / Double.parseDouble(tempListAll.get(j)[4]);

                    if (value2 > value1) {

                        String[] tempStrings = tempListAll.get(i);
                        tempListAll.set(i, tempListAll.get(j));
                        tempListAll.set(j, tempStrings);

                        value1 = Double.parseDouble(tempListAll.get(i)[3]) / Double.parseDouble(tempListAll.get(i)[4]);
                    }
                }
            }


            ////////////////////////////////////////////////////////////////////////////////// printing ////

            int lastJ = 0;

            for (int j = 0; j < tempListAll.size(); j++) {

                System.out.println("░░");

                try { System.out.print("░░  " + (j + 1) + ".  " + tempListAll.get(j)[0]); }
                catch (Exception E) { System.out.print("░░  " + (j + 1) + ".  " + ""); }

                try { System.out.print("  --  " + tempListAll.get(j)[1]); }
                catch (Exception E) { System.out.print("  --  " + ""); }

                try { System.out.print("      // " + tempListAll.get(j)[2]); }
                catch (Exception E) { System.out.print(" "); }

                double percentage = (Double.parseDouble(tempListAll.get(j)[3]) / Double.parseDouble(tempListAll.get(j)[4])) * 100;

                System.out.print("      [" + tempListAll.get(j)[4] + " Tests]");

                System.out.print("  [" + String.format("%.2f", percentage) + "% ✔]");

                System.out.print("      (Hinzugefügt: " + tempListAll.get(j)[5] + ")");

                if (!tempListAll.get(j)[6].equals("_")) {
                    System.out.println("      (Letzte Übung: " + tempListAll.get(j)[6] + ")");
                }

                lastJ = j;
            }

            for (int j = 0; j < tempListNews.size(); j++) {

                if (j == 0) {
                    System.out.println("░░");
                    System.out.println("░░");
                }

                if (j != 0) {
                    System.out.println("░░");
                }

                if (lastJ == 0) {
                    try { System.out.print("░░  " + (lastJ + j + 1) + ".  " + tempListNews.get(j)[0]); }
                    catch (Exception E) { System.out.print("░░  " + (lastJ + j + 1) + ".  " + ""); }

                } else {
                    try { System.out.print("░░  " + (lastJ + j + 2) + ".  " + tempListNews.get(j)[0]); }
                    catch (Exception E) { System.out.print("░░  " + (lastJ + j + 2) + ".  " + ""); }
                }

                try { System.out.print("  --  " + tempListNews.get(j)[1]); }
                catch (Exception E) { System.out.print("  --  " + ""); }

                try { System.out.print("      // " + tempListNews.get(j)[2]); }
                catch (Exception E) { System.out.print(" "); }

                System.out.print("    [new]");

                System.out.println("      (Hinzugefügt: " + tempListNews.get(j)[5] + ")");
            }

            tempListAll.clear();
            tempListNews.clear();

            System.out.println("░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        }

        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Neues Wort hinzufügen          ░░");
        System.out.println("                                           ░░ 2: Eine Liste aufrufen            ░░");
        System.out.println("                                           ░░ 3: Vokabeln üben                  ░░");
        System.out.println("                                           ░░ 4: Sprachen verwalten             ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(choice, 4)) {
            System.out.println(Handler.correctInput(choice, 4));
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
                Practice.practiceMenu(langName);
            break;

            case "4":
                Langs.langMenu();
            break;
        }
    }
}
