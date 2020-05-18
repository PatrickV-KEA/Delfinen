/**
 * For adding new members or changes to current members
 *
 * @author Patrick
 */
package demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class MemberFileWriter {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private File file;

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    MemberFileWriter() {

        file = new File("Svømmeklub.txt");
    }
    MemberFileWriter(String UnitTest) {
        /**
         * Constructor for UnitTesting, pass any String
         */
        file = new File("Test/demo/Svømmeklub.txt");
    }

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
    public void updateMembers(ArrayList<Member> membersList) {
        try {
            FileWriter fw = new FileWriter(file, false);
            StringBuilder sb = new StringBuilder();
            for (Member member : membersList) {
                sb.append(member.toFile()).append("\n");
            }
            fw.write(sb.toString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}