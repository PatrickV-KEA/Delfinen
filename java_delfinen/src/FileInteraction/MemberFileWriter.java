/**
 * For updating the storage file.
 * When used, there is also generated a backup file that is deleted on completion.
 * if an error occurs during file writing the backup will remain.
 *
 * @author Patrick
 */
package FileInteraction;

import Program.Member;
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
    public MemberFileWriter() {
        bck = new File("backup.txt");
        file = new File("storage.txt");
    }
    public MemberFileWriter(String UnitTest) {
        /** Constructor for UnitTesting, pass any String */
        bck = new File("Test/backup.txt");
        file = new File("Test/storage.txt");
    }

    // -------------------------------------------------------------------------------------------------
    // BEHAVIOR METHODS ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // -------------------------------------------------------------------------------------------------
    private void backup() {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateMembers(ArrayList<Member> membersList) {
        try {
            backup();

            FileWriter fw = new FileWriter(file);
            StringBuilder sb = new StringBuilder();

            for (Member member : membersList) {
                sb.append(member.toFile()).append("\n");
            } // END OF FOR-LOOP

            fw.write(sb.toString());
            fw.flush();
            fw.close();

            bck.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}