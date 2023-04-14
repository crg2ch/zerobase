import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Mission1_1 {
    public static void main(String[] args) {
        try {
            File file = new File("property.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<html>");
            writer.write("\n<head>");
            writer.write("\n<h2>자바 환경정보</h2>");
            writer.write("\n\t <meta charset=\"UTF-8\"/>");
            writer.write("\n\t <style>");
            writer.write("\n\t\t table { border-collapse: collapse; width: 100%; }");
            writer.write("\n\t\t th, td { border: solid 1px #000; }");
            writer.write("\n\t </style>");
            writer.write("\n</head>");
            writer.write("\n<body>");
            writer.write("\n<table>");
            writer.write("\n\t<tr>");
            writer.write("\n\t\t<th>키</th>");
            writer.write("\n\t\t<th>값</th>");
            writer.write("\n\t</tr>");
            for (Object k : System.getProperties().keySet()) {
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("\n\t<tr>");
                writer.write(String.format("\n\t\t<td>%s</td>", key));
                writer.write(String.format("\n\t\t<td>%s</td>", value));
                writer.write("\n\t</tr>");
            }
            writer.write("\n</table>");
            writer.write("\n</body>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
