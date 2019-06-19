import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Delete {

    static void delete(String langName, int listNr) throws IOException {

        System.out.println("  ");
        System.out.print("                                           ░░ Wortnummer eingeben: > ");
        String wordNr = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(wordNr, Handler.getLength(langName, listNr))) {

            System.out.println(Handler.correctInput(wordNr, Handler.getLength(langName, listNr)));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            wordNr = Main.brUser.readLine();
        }

        String[] deleteLine = new String[2];

        switch (listNr) {

            case 1:
                deleteLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(Integer.parseInt(wordNr) - 1).split(";");
            break;

            case 2:
                deleteLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list2csv)).get(Integer.parseInt(wordNr) - 1).split(";");
            break;

            case 3:
                deleteLine = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list3csv)).get(Integer.parseInt(wordNr) - 1).split(";");
            break;
        }

        System.out.println("    ");
        System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                        ░░");

        try { System.out.print("                        ░░ Löschen:    " + deleteLine[0]); }
        catch (Exception E) { System.out.print("                        ░░ Löschen:    " + ""); }

        try { System.out.print("   --   " + deleteLine[1]); }
        catch (Exception E) { System.out.print("   --   " + ""); }

        try { System.out.print("        " + " // " + deleteLine[2]); }
        catch (Exception E) { System.out.print(""); }

        System.out.println("      ?");

        System.out.println("                        ░░");
        System.out.println("                        ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░                                   ░░                    ");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("                                           ░░ 1: Löschen                        ░░");
        System.out.println("                                           ░░ 2: Abbrechen                      ░░");
        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("    ");
        System.out.print("                                           ░░ > ");
        String choice = Main.brUser.readLine();

        while (!Handler.inputIsCorrect(choice, 2)) {
            System.out.println(Handler.correctInput(String.valueOf(choice), 2));
            System.out.println("    ");
            System.out.print("                                           ░░ > ");
            choice = Main.brUser.readLine();
        }

        switch (choice) {

            case "1":

                List<String[]> tempList = new ArrayList<>();
                String[] tempString;

                if (listNr == 1) {

                    for (int j = 0; j < Handler.getLength(langName, 1); j++) {
                        tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(j).split(";");
                        tempList.add(tempString);
                    }

                    tempList.remove(Integer.parseInt(wordNr) - 1);

                    PrintWriter writer = new PrintWriter(Main.globPath + langName + Main.list1csv);
                    writer.print("");
                    writer.close();

                    for (int j = 0; j < tempList.size(); j++) {

                        FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list1csv, true);

                        try {fileWriter.append(tempList.get(j)[0]);}
                        catch (Exception E) {fileWriter.append("");}
                        fileWriter.append(";");
                        try {fileWriter.append(tempList.get(j)[1]);}
                        catch (Exception E) {fileWriter.append("");}
                        fileWriter.append(";");

                        try {fileWriter.append(tempList.get(j)[2]);}
                        catch (Exception E) {fileWriter.append("");}
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[3]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[4]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[5]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[6]);
                        fileWriter.append(";");

                        fileWriter.append("\r\n");
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }


                if (listNr == 2) {

                    for (int j = 0; j < Handler.getLength(langName, 2); j++) {
                        tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list2csv)).get(j).split(";");
                        tempList.add(tempString);
                    }

                    tempList.remove(Integer.parseInt(wordNr) - 1);

                    PrintWriter writer = new PrintWriter(Main.globPath + langName + Main.list2csv);
                    writer.print("");
                    writer.close();

                    for (int j = 0; j < tempList.size(); j++) {

                        FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list2csv, true);

                        try {fileWriter.append(tempList.get(j)[0]);}
                        catch (Exception E) {fileWriter.append("");}

                        fileWriter.append(";");

                        try {fileWriter.append(tempList.get(j)[1]);}
                        catch (Exception E) {fileWriter.append("");}

                        fileWriter.append(";");

                        try {fileWriter.append(tempList.get(j)[2]);}
                        catch (Exception E) {fileWriter.append("");}
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[3]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[4]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[5]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[6]);
                        fileWriter.append(";");

                        fileWriter.append("\r\n");
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }

                if (listNr == 3) {

                    for (int j = 0; j < Handler.getLength(langName, 2); j++) {
                        tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list3csv)).get(j).split(";");
                        tempList.add(tempString);
                    }

                    tempList.remove(Integer.parseInt(wordNr) - 1);

                    PrintWriter writer = new PrintWriter(Main.globPath + langName + Main.list3csv);
                    writer.print("");
                    writer.close();

                    for (int j = 0; j < tempList.size(); j++) {

                        FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list3csv, true);

                        try {fileWriter.append(tempList.get(j)[0]);}
                        catch (Exception E) {fileWriter.append("");}

                        fileWriter.append(";");

                        try {fileWriter.append(tempList.get(j)[1]);}
                        catch (Exception E) {fileWriter.append("");}

                        fileWriter.append(";");

                        try {fileWriter.append(tempList.get(j)[2]);}
                        catch (Exception E) {fileWriter.append("");}
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[3]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[4]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[5]);
                        fileWriter.append(";");

                        fileWriter.append(tempList.get(j)[6]);
                        fileWriter.append(";");

                        fileWriter.append("\r\n");
                        fileWriter.flush();
                        fileWriter.close();
                    }
                }

                System.out.println("    ");

                try {System.out.print("                                           ░░ " + deleteLine[0]);}
                catch (Exception E) {System.out.print("                                           ░░ " + "");}

                try {System.out.print("   --   " + deleteLine[1]);}
                catch (Exception E) {System.out.print("   --   " + "");}

                try {System.out.print("        // " + deleteLine[2]);}
                catch (Exception E) {System.out.print("");}

                System.out.println("      Erfolgreich gelöscht.");

                System.out.println("    ");

                if (listNr == 1) { List1.list1(langName); }
                if (listNr == 2) { List2.list2(langName); }
                if (listNr == 3) { List3.list3(langName); }

                break;


            case "2":

                System.out.println("  ");
                System.out.println("                                           ░░ Abgebrochen.");

                if (listNr == 1) {
                    List1.list1(langName);
                }
                if (listNr == 2) {
                    List2.list2(langName);
                }
                if (listNr == 3) {
                    List3.list3(langName);
                }
                break;
        }
    }
}
