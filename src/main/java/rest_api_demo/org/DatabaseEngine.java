package rest_api_demo.org;

import java.io.*;

/**
 * Imituoja Duomenu bazes veikima (rasyma/skaityma)
 * praktiskai turi tik viena lentele athletes (ArrayList<Athlete>)
 */
public class DatabaseEngine implements Serializable {

    synchronized public boolean WriteObjectToDatabase(Object obj) {
        File file = new File(Settings.DATABASE.value);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("No souch file " + Settings.DATABASE.value);
            return false;
        } catch (IOException e) {
            System.out.println("Cannot write obj to DATABASE " + Settings.DATABASE.value);
            return false;
        }
    }

    public Object ReadObjectFromDatabase() {
        File file = new File(Settings.DATABASE.value);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object obj = (Object) ois.readObject();
            ois.close();
            fis.close();
            return obj;
        } catch (FileNotFoundException e) {
            System.out.println("No souch file " + Settings.DATABASE.value);
            return null;
        } catch (IOException e) {
            System.out.println("Cannot read " + Settings.DATABASE.value);
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("No obj in DATABASE " + Settings.DATABASE.value);
            return null;
        }
    }
}
