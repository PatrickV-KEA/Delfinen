/**
 * @author Patrick
 */

package demo;

import java.io.*;
import java.util.ArrayList;

public class FileReader {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui = new UI();
    private File file = new File("Svømmeklub.txt");
    private SmartInputter smartInputter = new SmartInputter();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public FileReader() {}

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public ArrayList<Member> getMembersList() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //READ A LINE FOR EVERY LOOP
            String line;
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    String[] lineArr = line.split("¤");
                    String[] lineMember = lineArr[0].split(" ");

                    //ADD MEMBER
                    Member member = new Member();
                    for (int i = 0; i < lineMember.length; i++) {
                        smartInputter.input(member, lineMember[i]);
                    }

                    //ADD TOURNAMENTS IF PRESENT
                    if (lineArr.length > 1) {
                        for (int i = 1; i < lineArr.length; i++) {
                            String[] lineContents = lineArr[i].split(" ");
                            Tournament tournament = new Tournament();

                            for (int j = 0; j < lineContents.length; j++) {
                                smartInputter.input(tournament, lineContents[j]);
                            }

                            member.addTournament(tournament);
                        } // END OF LOOP
                    }
                    memberArrayList.add(member);
                }
            }// END OF LOOP
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberArrayList;
    }
    /*
    public void writeOrder(Order order) {
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
    }

    public ArrayList<String> getStatistics() {
        ArrayList<String> strArr = new ArrayList<>();
        try {
            File file = new File("finishedOrders.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (br.readLine() != null) {
                strArr.add(br.readLine());
            }
            return strArr;
        } catch (IOException e) {
            e.printStackTrace();
            return strArr;
        }
    }

     */
}