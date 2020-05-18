/**
 * @author Patrick
 */
package demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

<<<<<<< HEAD:java_delfinen/src/demo/MemberFileWriter.java
public class MemberFileWriter {
=======
public class  FileWriter {
>>>>>>> b12828edfc4564dd9c801592e37d3aa409e626a7:java_delfinen/src/demo/FileWriter.java

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private File file = new File("temp.txt");

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public void writeMember(Member member) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(member.toFile());
            bw.flush();

            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateMembersList(ArrayList<Member> membersList) {

    }
    /*public void writeOrder(Order order) {
        try {
            File file = new File("activeOrders.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(order.toString());
            bw.flush();

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeOrder(Order order) {
        try {

            File file = new File("activeOrders.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            StringBuffer sb = new StringBuffer();

            String line;
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    int thisInt = Character.getNumericValue((char) line.charAt(0));

                    if (thisInt != order.getOrderNumber()) {
                        sb.append(line + "\n");
                    }
                }
            }

            br.close();
            fr.close();

            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeStatistic(Order order) {
        try {
            File file = new File("finishedOrders.txt");
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.write(order.toString());
            bw.flush();

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}