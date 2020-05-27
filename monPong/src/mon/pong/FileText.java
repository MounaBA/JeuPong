package mon.pong;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static mon.pong.Action.niveau;
import static mon.pong.Action.vies;

public class FileText {

    File file = new File("testFileWriter.txt");
    FileWriter fw;
    FileReader fr;

    public FileText() {

    }

    public void sauvegarder() {

        try {
            //Création de l'objet
            fw = new FileWriter(file);
            String str = Integer.toString(niveau);
            str += "\n";
            str += Integer.toString(vies);
            //On écrit la chaîne
            fw.write(str);
            //On ferme le flux
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String continuer() {

        String str = "";
        try {
            //Création de l'objet de lecture
            fr = new FileReader(file);
            int i = 0;
            //Lecture des données
            while ((i = fr.read()) != -1) {
                str += (char) i;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (str.split("\n")[0] + str.split("\n")[1]);
    }
}
