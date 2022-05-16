package test.your.knowladge;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

public class serverQandA extends QandA {

    Database db = Database.getInstance();
    ArrayList<Integer> list;
    LocalConnect loc;
    int randomNum;
    int counter;
    IOdevice device;

    public serverQandA(LocalConnect loc) {
        this.loc = loc;
        random();
    }

    @Override
    public void questions() {
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        randomNum = list.remove(index);
        device = new IOserver(randomNum, loc);
        device.print();

    }

    @Override
    public void answer() {
        try {
            String answer = device.read();
            ResultSet rs = db.resultQuery(randomNum);
            if (rs.next()) {
                if (rs.getNString("answer").equals(answer)) {
                    counter++;
                }
            }
        } catch (Exception ex) {
            System.err.println("somting went wrong with game");
        }
    }

    @Override
    public void result() {
        String s = String.valueOf(counter);
        loc.getOut().println(s);
    }

    public void random() {
        list = new ArrayList<Integer>(getNumOfQuestion());
        for (int i = 1; i <= getNumOfQuestion(); i++) {
            list.add(i);
        }
    }
}
