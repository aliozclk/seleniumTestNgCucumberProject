package getDataFromExcelFile;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
    public static void main(String[] args) throws IOException {

        DataDriven dataDriven = new DataDriven();
        ArrayList<String> data = dataDriven.getData("SignUp & Delete Account");

        for (int i = 0; i <data.size(); i++) {
            System.out.println(data.get(i));
        }

    }
}
