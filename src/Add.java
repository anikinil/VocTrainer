import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Add {

    static void add(String langName) throws IOException {

        String[] list1Temp = new String[3];

        System.out.println("    ");
        System.out.print("                                           ░░ " + langName + ": > ");
        list1Temp[0] = Main.brUser.readLine();

        System.out.print("                                           ░░ Deutsch: > ");
        list1Temp[1] = Main.brUser.readLine();

        System.out.print("                                           ░░ Anmerkung?: > ");
        list1Temp[2] = Main.brUser.readLine();


        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        FileWriter fileWriter = new FileWriter(Main.globPath + langName + Main.list1csv, true);

        fileWriter.append(list1Temp[0]);                                fileWriter.append(";");
        fileWriter.append(list1Temp[1]);                                fileWriter.append(";");
        fileWriter.append(list1Temp[2]);                                fileWriter.append(";");
        fileWriter.append("0");                                         fileWriter.append(";");
        fileWriter.append("0");                                         fileWriter.append(";");
        fileWriter.append(dateFormat.format(calendar.getTime()));       fileWriter.append(";");
        fileWriter.append("-");                                         fileWriter.append(";");

        fileWriter.append("\r\n");

        fileWriter.flush();
        fileWriter.close();

        BufferedReader brFile = null;
        { try { brFile = new BufferedReader(new FileReader(Main.globPath + langName + Main.list1csv)); }
          catch (FileNotFoundException e) { e.printStackTrace(); } }

        while ((Main.line = brFile.readLine()) != null) {

            Main.last = Main.line.split(";");
        }

        System.out.println("    ");
        System.out.println("                                           ░░ Neues Wort in die Liste 1 hinzugefügt:");

        try { System.out.print("                                           ░░ " + Main.last[0]); }
        catch (Exception E) { System.out.print("                                           ░░ " + ""); }

        try { System.out.print("  --  " + Main.last[1]); }
        catch (Exception E) { System.out.print("  --  " + ""); }

        try { System.out.println("      // " + Main.last[2]); }
        catch (Exception E) { System.out.println(" "); }

        Menu.menu(langName);
    }
}
