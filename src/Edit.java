
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Edit {

    static void edit(String langName, int listNr) throws IOException {

        System.out.println("    ");
        System.out.print("                                           ░░ Wortnummer eingeben: > ");
        String wordNr = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(String.valueOf(wordNr), Handler.getLength(langName, listNr))) {
            System.out.println(Handler.correctInput(String.valueOf(wordNr), Handler.getLength(langName, listNr)));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            wordNr = Main.brUser.readLine();
        }

        String[] editLine = new String[6];

        System.out.println("    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ ");

        if (listNr == 1) {

            editLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(Integer.parseInt(wordNr) - 1).split(";");

            try {System.out.println("                                           ░░ " + langName + ": " + editLine[0]);} catch (Exception E) {System.out.println("                   ░░ " + langName + ": " + "");}
            try {System.out.println("                                           ░░ Deutsch: " + editLine[1]);} catch (Exception E) {System.out.println("                   ░░ Deutsch: " + "");}
            try {System.out.println("                                           ░░ Anmerkung: " + editLine[2]);} catch (Exception E) {System.out.println("                   ░░ Anmerkung: " + "");}
        }
        if (listNr == 2) {

            editLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list2csv)).get(Integer.parseInt(wordNr) - 1).split(";");

            try {System.out.println("                                           ░░ " + langName + ": " + editLine[0]);} catch (Exception E) {System.out.println("                   ░░ " + langName + ": " + "");}
            try {System.out.println("                                           ░░ Deutsch: " + editLine[1]);} catch (Exception E) {System.out.println("                   ░░ Deutsch: " + "");}
            try {System.out.println("                                           ░░ Anmerkung: " + editLine[2]);} catch (Exception E) {System.out.println("                   ░░ Anmerkung: " + "");}
        }
        if (listNr == 3) {

            editLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list3csv)).get(Integer.parseInt(wordNr) - 1).split(";");

            try {System.out.println("                                           ░░ " + langName + ": " + editLine[0]);} catch (Exception E) {System.out.println("                   ░░ " + langName + ": " + "");}
            try {System.out.println("                                           ░░ Deutsch: " + editLine[1]);} catch (Exception E) {System.out.println("                   ░░ Deutsch: " + "");}
            try {System.out.println("                                           ░░ Anmerkung: " + editLine[2]);} catch (Exception E) {System.out.println("                   ░░ Anmerkung: " + "");}
        }


        System.out.println("                                           ░░  ");
        System.out.println("                                           ░░ ↓ wird zu ↓");
        System.out.println("                                           ░░  ");
        System.out.print("                                           ░░ " + langName + ": > ");
        String lang = Main.brUser.readLine();
        System.out.print("                                           ░░ Deutsch: > ");
        String de = Main.brUser.readLine();
        System.out.print("                                           ░░ Anmerkung: > ");
        String nt = Main.brUser.readLine();


        if (listNr == 1) {

            List<String> fileContent = new ArrayList<>(Files.readAllLines(FileSystems.getDefault().getPath(Main.globPath + langName + Main.list1csv)));
            fileContent.set(Integer.parseInt(wordNr) - 1, lang + ";" + de + ";" + nt + ";" + editLine[3] + ";" + editLine[4] + ";" + editLine[5] + ";" + editLine[6] + ";");
            Files.write((FileSystems.getDefault().getPath(Main.globPath + langName + Main.list1csv)), fileContent, StandardCharsets.UTF_8);
        }

        if (listNr == 2) {

            List<String> fileContent = new ArrayList<>(Files.readAllLines(FileSystems.getDefault().getPath(Main.globPath + langName + Main.list2csv)));
            fileContent.set(Integer.parseInt(wordNr) - 1, lang + ";" + de + ";" + nt + ";" + editLine[3] + ";" + editLine[4] + ";" + editLine[5] + ";" + editLine[6] + ";");
            Files.write((FileSystems.getDefault().getPath(Main.globPath + langName + Main.list2csv)), fileContent, StandardCharsets.UTF_8);
        }

        if (listNr == 3) {

            List<String> fileContent = new ArrayList<>(Files.readAllLines(FileSystems.getDefault().getPath(Main.globPath + langName + Main.list3csv)));
            fileContent.set(Integer.parseInt(wordNr) - 1, lang + ";" + de + ";" + nt + ";" + editLine[3] + ";" + editLine[4] + ";" + editLine[5] + ";" + editLine[6] + ";");
            Files.write((FileSystems.getDefault().getPath(Main.globPath + langName + Main.list3csv)), fileContent, StandardCharsets.UTF_8);
        }

        System.out.println("                                           ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("    ");
        System.out.println("                                           ░░ Erfolgreich bearbeitet.");

        if (listNr == 1) { List1.list1(langName); }
        if (listNr == 2) { List2.list2(langName); }
        if (listNr == 3) { List3.list3(langName); }
    }
}
