/**
 * @author Patrick
 */

package demo;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private UI ui = new UI();
    private File file = new File("Svømmeklub.txt");
    private SmartInputter smartInputter = new SmartInputter();

    // -------------------------------------------------------------------------------------------------
    // CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public FileHandler() {}

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    /*public ArrayList<Member> getMemberList_new() {
        ArrayList<Member> memberArrayList = new ArrayList<>();
        Hashtable<String, String> fileMap = new Hashtable<String, String>(50);

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            //READ A LINE FOR EVERY LOOP
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {

                    Member member = new Member("", LocalDate.of(0000,00,00),0000,false,false);

                    String[] lineArr = line.split("¤");
                    for (int i = 0; i < lineArr.length; i++) {

                        String[] partArr = line.split(" ");
                        for (int j = 0; j < partArr.length; j++) {

                            try {
                                String[] varArr = line.split("=");
                                fileMap.put( varArr[0], varArr[1] );
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } // END OF FOR-LOOP
                    } // END OF FOR-LOOP (READING LINE)

                    for (int i = 0; i < fileMap.size(); i++) {

                        Hashtable attrMap = member.getAttrMap();
                        attrMap.get("id") = 1;

                    } // END OF FOR-LOOP ()
                }
            } // END OF WHILE-LOOP

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Member>();
    }*/
    public ArrayList<Member> getMembersList() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            //READ A LINE FOR EVERY LOOP
            String line;
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    String[] lineArr = line.split("¤");
                    String[] lineMember = lineArr[0].split(" ");

                    //INSTANTIATE MEMBER
                    Member member = new Member();
                    for (int i = 0; i < lineMember.length; i++) {
                        smartInputter.input(member, lineMember[i]);
                    }

                    //ADD TOURNAMENTS
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
    public ArrayList<Member> getMembersList() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();

            String line;
            //READ A LINE FOR EVERY LOOP
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    // membernr, name, birthday, cpr, payed, discipline, bestTime, active, tournament
                    String[] lineArr = line.split("¤");
                    String[] lineMember = lineArr[0].split(" ");
                    String lineDate = lineMember[2].split("=")[1];

                    int id = Character.getNumericValue(lineMember[0].split("=")[1].charAt(0));
                    String name = lineMember[1].split("=")[1];
                    LocalDate date = LocalDate.parse(lineDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    int cpr = Integer.parseInt(lineMember[3].split("=")[1]);
                    boolean payed = Boolean.parseBoolean(lineMember[4].split("=")[1]);
                    boolean active = Boolean.parseBoolean(lineMember[5].split("=")[1]);

                    //INSTANTIATE MEMBER
                    Member member;
                    if (lineArr.length > 1) {
                        String[] lineContents = lineArr[1].split(" ");
                        if (lineContents[0].equals("")) {
                            String discipline = lineContents[1].split("=")[1];
                            float time = Float.parseFloat(lineContents[2].split("=")[1]);
                            member = new Member(id, name, date, cpr, payed, active, discipline, time);
                        } else {
                            String discipline = lineContents[0].split("=")[1];
                            float time = Float.parseFloat(lineContents[1].split("=")[1]);
                            member = new Member(id, name, date, cpr, payed, active, discipline, time);
                        }
                    } else {
                        member = new Member(id, name, date, cpr, payed, active);
                    }

                    //ADD TOURNAMENTS
                    Tournament tournament;
                    if (lineArr.length > 2) {
                        for (int i = 2; i < lineArr.length; i++) {
                            String[] lineContents = lineArr[i].split(" ");
                            if (lineContents[0].equals("")) {
                                String tName = lineContents[1].split("=")[1];
                                int tResult = Integer.parseInt(lineContents[2].split("=")[1]);
                                float tTime = Float.parseFloat(lineContents[3].split("=")[1]);
                                LocalDate tDate = LocalDate.parse(lineContents[4].split("=")[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                tournament = new Tournament(tName, tResult, tTime, tDate);
                                member.addTournament(tournament);
                            } else {
                                String tName = lineContents[0].split("=")[1];
                                int tResult = Integer.parseInt(lineContents[1].split("=")[1]);
                                float tTime = Float.parseFloat(lineContents[2].split("=")[1]);
                                LocalDate tDate = LocalDate.parse(lineContents[3].split("=")[1], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                tournament = new Tournament(tName, tResult, tTime, tDate);
                                member.addTournament(tournament);
                            }
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
    */
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