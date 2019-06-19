import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Handler {

    public static int getLength(String langName, int listNr) throws IOException {

        BufferedReader brFile = null;
        {
            try {
                brFile = new BufferedReader(new FileReader(Main.globPath + langName + "/vocList" + listNr + ".csv"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        int i = 0;
        while ((Main.line = brFile.readLine()) != null) {
            i++;
        }

        return i;
    }

    public static boolean isListEmpty(String langName, int listNr) throws IOException {

        boolean ret = false;

        if (listNr == 0) {

            BufferedReader brFile = null;
            {
                try {
                    brFile = new BufferedReader(new FileReader(Main.langListPath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            int i = 0;
            while ((Main.line = brFile.readLine()) != null) {
                i++;
            }

            if (i == 0) {
                ret = true;
            } else {
                ret = false;
            }
        }

        if (listNr == 1) {

            BufferedReader brFile1 = null;
            {
                try {
                    brFile1 = new BufferedReader(new FileReader(Main.globPath + langName + Main.list1csv));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            int i = 0;
            while ((Main.line = brFile1.readLine()) != null) {
                i++;
            }

            if (i == 0) {
                ret = true;
            } else {
                ret = false;
            }
        }

        if (listNr == 2) {

            BufferedReader brFile2 = null;
            {
                try {
                    brFile2 = new BufferedReader(new FileReader(Main.globPath + langName + Main.list2csv));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            int i = 0;
            while ((Main.line = brFile2.readLine()) != null) {
                i++;
            }

            if (i == 0) {
                ret = true;
            } else {
                ret = false;
            }
        }

        if (listNr == 3) {

            BufferedReader brFile3 = null;
            {
                try {
                    brFile3 = new BufferedReader(new FileReader(Main.globPath + langName + Main.list3csv));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            int i = 0;
            while ((Main.line = brFile3.readLine()) != null) {
                i++;
            }

            if (i == 0) {
                ret = true;
            } else {
                ret = false;
            }
        }

        return ret;
    }

    public static boolean inputIsCorrect(String input, int range) {

        boolean ret = true;

        try {
            Double.parseDouble(input);

            if (Integer.parseInt(input) > range || Integer.parseInt(input) < 1) {

                ret = false;
            }
        } catch (Exception E) {
            ret = false;
        }

        return ret;
    }

    public static String correctInput(String input, int range) {

        String ret = null;

        try {
            Double.parseDouble(input);

            if (Integer.parseInt(input) > range || Integer.parseInt(input) < 1) {

                ret = "                                           ░░ Bitte nur zwischen 1 und " + range + " wählen.";
            }
        } catch (Exception E) {
            ret = "                                           ░░ Bitte eine ganze Zahl zwischen 1 und " + range + " wählen.";
        }

        return ret;
    }

    public static boolean inputIsCorrectLangs(String input, int rangeD, int rangeU) {

        boolean ret = true;

        try {
            Double.parseDouble(input);

            if (Integer.parseInt(input) < rangeD || Integer.parseInt(input) > rangeU) {

                ret = false;
            }
        } catch (Exception E) {
            ret = false;
        }

        return ret;
    }

    public static String correctInputLangs(String input, int rangeD, int rangeU) {

        String ret = null;

        try {
            Double.parseDouble(input);

            if (Integer.parseInt(input) < rangeD || Integer.parseInt(input) > rangeU) {

                ret = "                                           ░░ Bitte nur zwischen " + rangeD + " und " + rangeU + " wählen.";
            }
        } catch (Exception E) {
            ret = "                                           ░░ Bitte eine ganze Zahl zwischen " + rangeD + " und " + rangeU + " wählen.";
        }

        return ret;
    }

}
