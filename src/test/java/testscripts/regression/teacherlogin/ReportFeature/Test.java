package testscripts.regression.teacherlogin.ReportFeature;

public class Test {
    public void print() {
        String[] ar = {
                "Pratik", "Manoj"
        };
        StringBuilder sb1 = new StringBuilder(200);
        sb1.append("<html><body>" + "<table style='border:2px solid black'>");
        for (String cat : ar) {
            sb1.append("<tr><br/><td>");
            /*sb1.append(cat.getINNumber())
                    .append("</td><br/><td>")
                    .append(cat.getDescription())
                    .append("</td><br/><td>")
                    .append(cat.getStatus())
                    .append("</td><br/><td>")
                    .append(cat.getStatus())
                    .append("</td><br/><td>")
                    .append(cat.getOwner())
                    .append("</td><br/><td>")
                    .append(cat.getOwnerGroup())
                    .append("</td><br/><td>")
                    .append(cat.getSeverity());*/
            sb1.append("</td><br/><td>");
            String in = sb1.toString();
            System.out.println(in);

        }
        sb1.append("</table></br></body></html>");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.print();
    }

}