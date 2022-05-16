package test.your.knowladge;

import java.io.IOException;
import java.sql.ResultSet;

public class IOserver implements IOdevice {

    int index;
    Database db = Database.getInstance();
    LocalConnect loc;

    public IOserver(int index, LocalConnect loc) {
        this.index = index;
        this.loc = loc;
    }

    @Override
    public void print() {
        try {
            ResultSet rs = db.questionQuery(index);
            if (rs.next()) {
                loc.getOut().println(rs.getNString("qestion"));
                loc.getOut().println("A) " + rs.getNString("a"));
                loc.getOut().println("B) " + rs.getNString("b"));
                loc.getOut().println("C) " + rs.getNString("c"));
                loc.getOut().println("D) " + rs.getNString("d"));
                loc.getOut().println("Your answer: ");
            }
        } catch (Exception ex) {
            System.err.println("somthing went wrong");
        }

    }

    @Override
    public String read() {
        String answer = "";
        try {
            answer = loc.getRead().readLine();
            loc.getOut().println("-------------------------------------------");
        } catch (IOException ex) {
            System.err.println("somthing went wrong");
        }
        return answer;
    }
}
