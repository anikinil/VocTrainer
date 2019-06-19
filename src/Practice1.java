import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Practice1 {

    public static void practice1(String langName, int lang) throws IOException {

        System.out.println("    ");

        if (Handler.isListEmpty(langName, 1)) {

            System.out.println("    ");
            System.out.println("                                           ░░ Liste 1 ist leer.");
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

            int pick = (int) (Math.random() * Handler.getLength(langName, 1));

            String temp0 = " ";
            String temp1 = " ";
            String temp2 = " ";
            String temp3 = " ";
            String temp4 = " ";
            String temp5 = " ";
            String temp6 = " ";

            try {
                temp0 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[0];
            } catch (Exception E) {
                temp0 = "";
            }

            try {
                temp1 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[1];
            } catch (Exception E) {
                temp1 = "";
            }

            try {
                temp2 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[2];
            } catch (Exception E) {
                temp2 = "";
            }

            temp3 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[3];

            temp4 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[4];

            temp5 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[5];

            temp6 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(pick).split(";")[6];

            String[] temp = new String[7];
            temp[0] = temp0;
            temp[1] = temp1;
            temp[2] = temp2;
            temp[3] = temp3;
            temp[4] = temp4;
            temp[5] = temp5;
            temp[6] = temp6;

            int lang1 = 0;
            int lang2 = 0;
            if (lang == 1) {
                lang1 = 0;
                lang2 = 1;
            }
            if (lang == 2) {
                lang1 = 1;
                lang2 = 0;
            }

            System.out.println("                                           ░░ (\"!\" eingeben zum Beenden)");
            System.out.println("    ");

            try {
                System.out.print("                                           ░░ " + temp[lang1] + "  >  ");
            } catch (Exception E) {
                System.out.print("                                           ░░ " + "" + "  >  ");
            }

            String answ = Main.brUser.readLine();

            int cases = 0;
            try {
                if (answ.equalsIgnoreCase(temp[lang2])) {
                    cases = 1;
                }
            } catch (Exception E) {
                if (answ.equalsIgnoreCase("")) {
                    cases = 1;
                }
            }

            if (answ.equals("!")) {
                cases = 2;
            }

            switch (cases) {

                case 1:

                    System.out.println("                                           ░░ ✔ Richtig!");

                    List<String[]> tempList = new ArrayList<>();
                    String[] tempString;

                    for (int j = 0; j < Handler.getLength(langName, 1); j++) {
                        tempString = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(j).split(";");
                        tempList.add(tempString);
                    }

                    tempList.remove(pick);


                    PrintWriter writer = new PrintWriter(Main.globPath + langName + Main.list1csv);
                    writer.print("");
                    writer.close();

                    for (int j = 0; j < tempList.size(); j++) {

                        FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list1csv, true);

                        try {
                            fileWriter.append(tempList.get(j)[0]);
                        } catch (Exception E) {
                            fileWriter.append("");
                        }
                        fileWriter.append(";");

                        try {
                            fileWriter.append(tempList.get(j)[1]);
                        } catch (Exception E) {
                            fileWriter.append("");
                        }
                        fileWriter.append(";");

                        try {
                            fileWriter.append(tempList.get(j)[2]);
                        } catch (Exception E) {
                            fileWriter.append("");
                        }
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

                    FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list2csv, true);

                    try {
                        fileWriter.append(temp[0]);
                    } catch (Exception E) {
                        fileWriter.append("");
                    }
                    fileWriter.append(";");

                    try {
                        fileWriter.append(temp[1]);
                    } catch (Exception E) {
                        fileWriter.append("");
                    }
                    fileWriter.append(";");

                    try {
                        fileWriter.append(temp[2]);
                    } catch (Exception E) {
                        fileWriter.append("");
                    }
                    fileWriter.append(";");

                    fileWriter.append("" + (Integer.parseInt(temp[3]) + 1));
                    fileWriter.append(";");

                    fileWriter.append("" + (Integer.parseInt(temp[4]) + 1));
                    fileWriter.append(";");

                    fileWriter.append(temp[5]);
                    fileWriter.append(";");


                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
                    Calendar calendar = Calendar.getInstance();

                    fileWriter.append(dateFormat.format(calendar.getTime()));
                    fileWriter.append(";");


                    fileWriter.append("\r\n");
                    fileWriter.flush();
                    fileWriter.close();

                    if (Handler.getLength(langName, 1) == 0) {

                        System.out.println("    ");
                        System.out.println("                                           ░░ Liste 1 fertig geübt ✔");


                        DateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
                        calendar.add(Calendar.DATE, 1);

                        System.out.println("                                           ░░ Nächster Übungstermin: " + dateFormat2.format(calendar.getTime()) + " (morgen)");
                        System.out.println("    ");
                        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("                                           ░░ 1: Eine andere Liste üben         ░░");
                        System.out.println("                                           ░░ 2: Zurück zum Hauptmenü           ░░");
                        System.out.println("                                           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
                        System.out.println("    ");
                        System.out.print("                                           ░░ > ");
                        String choice1 = Main.brUser.readLine();

                        while (! Handler.inputIsCorrect(choice1, 2)) {
                            System.out.println(Handler.correctInput(choice1, 2));
                            System.out.println("    ");
                            System.out.print("                                           ░░ > ");
                            choice1 = Main.brUser.readLine();
                        }

                        if (choice1.equals("1")) {
                            Practice.practiceMenu(langName);
                        }

                        if (choice1.equals("2")) {
                            Menu.menu(langName);
                        }
                    }

                    break;

                case 2:

                    System.out.println("    ");
                    System.out.println("                                           ░░ Beendet.");

                    Menu.menu(langName);
                    break;

                default:

                    try {
                        System.out.println("                                           ░░ × Falsch!     →  " + temp[lang2]);
                    } catch (Exception E) {
                        System.out.println("                                           ░░ × Falsch!     →  " + "");
                    }

                    List<String[]> tempList2 = new ArrayList<>();
                    String[] tempString2;

                    for (int j = 0; j < Handler.getLength(langName, 1); j++) {
                        tempString2 = Files.readAllLines(Paths.get(Main.globPath + langName + Main.list1csv)).get(j).split(";");
                        tempList2.add(tempString2);
                    }

                    PrintWriter writer2 = new PrintWriter(Main.globPath + langName + Main.list1csv);
                    writer2.print("");
                    writer2.close();

                    for (int j = 0; j < tempList2.size(); j++) {

                        FileWriter fileWriter2 = new FileWriter(Main.globPath + langName + Main.list1csv, true);

                        try {
                            fileWriter2.append(tempList2.get(j)[0]);
                        } catch (Exception E) {
                            fileWriter2.append("");
                        }
                        fileWriter2.append(";");

                        try {
                            fileWriter2.append(tempList2.get(j)[1]);
                        } catch (Exception E) {
                            fileWriter2.append("");
                        }
                        fileWriter2.append(";");

                        try {
                            fileWriter2.append(tempList2.get(j)[2]);
                        } catch (Exception E) {
                            fileWriter2.append("");
                        }
                        fileWriter2.append(";");

                        fileWriter2.append(tempList2.get(j)[3]);
                        fileWriter2.append(";");

                        if (j == pick) {
                            fileWriter2.append(String.valueOf(Integer.parseInt(tempList2.get(j)[4]) + 1));
                            fileWriter2.append(";");
                        } else {
                            fileWriter2.append(tempList2.get(j)[4]);
                            fileWriter2.append(";");
                        }

                        fileWriter2.append(tempList2.get(j)[5]);
                        fileWriter2.append(";");

                        if (j == pick) {
                            DateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
                            Calendar calendar2 = Calendar.getInstance();
                            fileWriter2.append(dateFormat2.format(calendar2.getTime()));
                            fileWriter2.append(";");
                        } else {
                            fileWriter2.append(tempList2.get(j)[6]);
                            fileWriter2.append(";");
                        }

                        fileWriter2.append("\r\n");
                        fileWriter2.flush();
                        fileWriter2.close();
                    }

                    break;
            }

            continue1(langName, lang);
        }
    }

    public static void continue1(String langName, int lang) throws IOException {

        Practice1.practice1(langName, lang);

    }
}
