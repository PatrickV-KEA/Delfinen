/**
 * For adding new members or changes to current members
 *
 * @author Patrick
 */
package demo;

import java.io.*;
import java.util.ArrayList;

public class MemberFileWriter {

    // -------------------------------------------------------------------------------------------------
    // FIELDS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private File file;
    private File bck;

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    MemberFileWriter() {
        bck = new File("backup.txt");
        file = new File("Svømmeklub.txt");
    }
    MemberFileWriter(String UnitTest) {
        /**
         * Constructor for UnitTesting, pass any String
         */
        bck = new File("Test/demo/backup.txt");
        file = new File("Test/demo/Svømmeklub.txt");
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    /*public void writeMember(Member member) {
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
    }*/
    public void updateMembers(ArrayList<Member> membersList) {
        try {
            // Copy to backup file
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(file);
                os = new FileOutputStream(bck);
                byte[] buffer = new byte[4096];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
            } finally {
                is.close();
                os.close();
            }
            // Write new file
            FileWriter fw = new FileWriter(file);
            StringBuilder sb = new StringBuilder();
            for (Member member : membersList) {
                sb.append(member.toFile()).append("\n");
            }
            fw.write(sb.toString());
            fw.flush();
            fw.close();

            // Delete backup file
            bck.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}