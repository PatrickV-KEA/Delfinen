/**
 * @author Patrick
 */
package demo;

import java.io.*;
import java.util.ArrayList;

public class MemberFileReader {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private File file;
    private SmartInputter smartInputter = new SmartInputter();

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    MemberFileReader() {

        file = new File("Svømmeklub.txt");
    }
    MemberFileReader(String UnitTest) {
        /**
         * Constructor for UnitTesting, pass any String
         */
        file = new File("Test/demo/Svømmeklub.txt");
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    public ArrayList<Member> getMembersList() {

        ArrayList<Member> memberArrayList = new ArrayList<>();

        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {

                if (!line.isEmpty()) {
                    String[] lineArr = line.split("¤");
                    String[] lineMember = lineArr[0].split(" ");

                    //ADD MEMBER
                    Member member = new Member();
                    for (int i = 0; i < lineMember.length; i++) {
                        smartInputter.input(member, lineMember[i]);
                    } // END OF FOR-LOOP

                    //ADD TOURNAMENTS IF PRESENT
                    if (lineArr.length > 1) {
                        for (int i = 1; i < lineArr.length; i++) {
                            String[] lineContents = lineArr[i].split(" ");
                            Tournament tournament = new Tournament();
                            for (int j = 0; j < lineContents.length; j++) {
                                smartInputter.input(tournament, lineContents[j]);
                            } // END OF FOR-LOOP
                            member.addTournament(tournament);
                        } // END OF FOR-LOOP
                    }
                    memberArrayList.add(member);
                }
            }// END OF WHILE-LOOP
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberArrayList;
    }
}