package Exception;

import java.io.*;

public class EmployeeFileSystem {

    public static void main(String[] args) {

        FileWriter fw = null;

        try {

            fw = new FileWriter("employee.txt");

            fw.write("101,John,50000\n");
            fw.write("102,David,60000\n");
            fw.write("103,Smith,70000\n");

            System.out.println("Data Saved");

        }
        catch(IOException e) {
            System.out.println(
                    "Error Writing File");
        }
        finally {

            try {

                if(fw != null)
                    fw.close();

            }
            catch(IOException e) {

                System.out.println(
                        "Error Closing File");
            }
        }

        BufferedReader br = null;

        try {

            br = new BufferedReader(
                    new FileReader(
                            "employee.txt"));

            String line;

            while((line = br.readLine())
                    != null) {

                String data[] =
                        line.split(",");

                System.out.println(
                        "ID : " + data[0]);
                System.out.println(
                        "Name : " + data[1]);
                System.out.println(
                        "Salary : " + data[2]);
                System.out.println();
            }

        }
        catch(Exception e) {

            System.out.println(
                    "File Read Error");
        }
        finally {

            try {

                if(br != null)
                    br.close();

            }
            catch(IOException e) {

                System.out.println(
                        "Error Closing Reader");
            }
        }
    }
}