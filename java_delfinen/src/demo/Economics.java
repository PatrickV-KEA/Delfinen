package demo;

import java.util.ArrayList;

public class Economics {

    private FileHandler fileHandler = new FileHandler();
    private UI ui = new UI();


    public void printMemberArrears() {

        Member member;
        ArrayList<Member> arrearsList = new ArrayList<>();
        ArrayList<Member> memberList = fileHandler.getMembersList();

        for (int i = 0; i < memberList.size(); i++) {
            if (memberList.get(i).isPayed() == false) {
                member = memberList.get(i);
                arrearsList.add(member);
            }
        }
        ui.printArraylist(arrearsList);
    }
}



