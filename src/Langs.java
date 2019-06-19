import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Langs {

    public static void langMenu() throws IOException {

        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░          Vokabeln wählen          ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        BufferedReader brFile = null;
        try { brFile = new BufferedReader(new FileReader(Main.langListPath)); }
        catch (FileNotFoundException e) { e.printStackTrace(); }

        int i = 0;
        while ((Main.line = brFile.readLine()) != null) { i++; }

        if (i == 0) {

            System.out.println("                                           ░░                                   ░░");
            System.out.println("                                           ░░              [leer]               ░░");
            System.out.println("                                           ░░                                   ░░");

        } else {

            System.out.println("    ");

            for (int j = 0; j < i; j++) {
                String temp = Files.readAllLines(Paths.get(Main.langListPath)).get(j);
                System.out.println("                                              " + (j + 1) + ": " + temp);
            }

            System.out.println("    ");
        }

        brFile.close();

        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");


        if (i > 0) {

            System.out.println("                                           ░░ " + (i + 1) + ": [Neue Sprache hinzufügen]      ░░");
            System.out.println("                                           ░░ " + (i + 2) + ": [Sprache entfernen]            ░░");
        } else {

            System.out.println("                                           ░░ " + (i + 1) + ": [Neue Sprache hinzufügen]      ░░");
        }

        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice = Main.brUser.readLine();

        if (i > 0) {

            while (! Handler.inputIsCorrect(choice, i + 2)) {
                System.out.println(Handler.correctInput(choice, i + 2));
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                choice = Main.brUser.readLine();
            }
        } else {

            while (! Handler.inputIsCorrect(choice, i + 1)) {
                System.out.println("                                           ░░ Bitte 1 wählen.");
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                choice = Main.brUser.readLine();
            }
        }

        if (Integer.parseInt(choice) == (i + 1)) {

            System.out.println("    ");
            System.out.print("                                           ░░ Name der Sprache: > ");
            String newLang = Main.brUser.readLine();

            while (newLang.length() == 0) {
                System.out.println("                                           ░░ Bitte mehr als nichts eingeben.");
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                newLang = Main.brUser.readLine();
            }

            String path = Main.globPath + newLang;
            new File(path).mkdirs();

            FileWriter fileWriterLangList = new FileWriter(Main.langListPath, true);
            fileWriterLangList.append(newLang);
            fileWriterLangList.append("\r\n");
            fileWriterLangList.flush();
            fileWriterLangList.close();

            for (int l = 1; l <= 3; l++) {
                File f = null;
                boolean bool = false;
                try {
                    f = new File(Main.globPath + newLang + "/vocList" + l + ".csv");
                    bool = f.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            System.out.println("    ");
            System.out.println("                                           ░░ \"" + newLang + "\" erfolgreich hinzugefügt.");

            Langs.langMenu();
        }

        if (Integer.parseInt(choice) == (i + 2)) {

            System.out.println("  ");
            System.out.print("                                           ░░ Sprachennummer eingeben: > ");
            String langNr = Main.brUser.readLine();

            while (!Handler.inputIsCorrectLangs(String.valueOf(langNr), 1, i )) {
                System.out.println(Handler.correctInputLangs(String.valueOf(langNr), 1, i));
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                langNr = Main.brUser.readLine();
            }

            String deleteLine;
            deleteLine = Files.readAllLines(Paths.get(Main.langListPath)).get(Integer.parseInt(langNr) - 1);

            System.out.println("    ");
            System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("                        ░░");
            System.out.println("                        ░░ Entfernen:    \"" + deleteLine + "\"    ?");
            System.out.println("                        ░░");
            System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("                                           ░░                                   ░░                    ");
            System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("                                           ░░ 1: Entfernen                      ░░");
            System.out.println("                                           ░░ 2: Abbrechen                      ░░");
            System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            String deleteOrNot = Main.brUser.readLine();

            while (!Handler.inputIsCorrect(deleteOrNot, 2)) {
                System.out.println(Handler.correctInput(String.valueOf(deleteOrNot), 2));
                System.out.println("    ");
                System.out.print("                                           ░░ > ");
                deleteOrNot = Main.brUser.readLine();
            }

            switch (deleteOrNot) {

                case "1":

                    List<String> tempList = new ArrayList<>();
                    String tempString;

                    BufferedReader brFile2 = null;{ try { brFile2 = new BufferedReader(new FileReader(Main.langListPath)); } catch (FileNotFoundException e) { e.printStackTrace(); } }

                    int k = 0;
                    while ((Main.line = brFile2.readLine()) != null) {
                        k++;
                    }

                    for (int j = 0; j < k; j++) {
                        tempString = Files.readAllLines(Paths.get(Main.langListPath)).get(j);
                        tempList.add(tempString);
                    }

                    String langName = tempList.get(Integer.parseInt(langNr)-1);
                    tempList.remove(Integer.parseInt(langNr) - 1);

                    PrintWriter writer = new PrintWriter(Main.langListPath);
                    writer.print("");
                    writer.close();

                    for (int j = 0; j < tempList.size(); j++) {

                        FileWriter fileWriter = new FileWriter(Main.langListPath, true);
                        fileWriter.append(tempList.get(j));
                        fileWriter.append("\r\n");
                        fileWriter.flush();
                        fileWriter.close();
                    }

                    Files.walk(Paths.get(Main.globPath + langName)).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);

                System.out.println("    ");
                System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                System.out.println("                        ░░");

                try {System.out.println("                        ░░ \"" + langName + "\" erfolgreich entfernt.");}
                catch (Exception E) {System.out.println("                        ░░ \"" + "" + "\" erfolgreich entfernt.");}

                System.out.println("                        ░░");
                System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

                    Langs.langMenu();
                break;

                case "2":

                    Langs.langMenu();
                break;
            }
        } else {

            String langName = Files.readAllLines(Paths.get(Main.langListPath)).get(Integer.parseInt(choice)-1);
            Menu.menu(langName);
        }
    }
}