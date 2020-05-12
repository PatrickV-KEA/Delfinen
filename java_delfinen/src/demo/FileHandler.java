package demo;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    // ------------------------------------------------------
    // FIELDS
    // ------------------------------------------------------
    private OrdersList ordersList;
    private PizzaList pizzaList;
    // ------------------------------------------------------
    // CONSTRUCTOR
    // ------------------------------------------------------
    public FileHandler(OrdersList ordersList, PizzaList pizzaList) {
        this.ordersList = ordersList;
        this.pizzaList = pizzaList;
    }
    // ------------------------------------------------------
    // BEHAVIOR::METHODS
    // ------------------------------------------------------
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
            while ((line=br.readLine())!=null) {

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

    public ArrayList<String> getStatistics(){
        ArrayList<String> strArr = new ArrayList<>();
        try {
            File file = new File("finishedOrders.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            while (br.readLine()!=null) {
                strArr.add(br.readLine());
            }
            return strArr;
        } catch (IOException e) {
                e.printStackTrace();
                return strArr;
            }
    }

}