package training.experimental.immutability;

public class StringVsStringBuilderStringBuffer {

    public static void main(String[] args) {

        String s = "XYZ";

        StringBuilder sb = new StringBuilder("xyz");

        sb.append(1);
        sb.append("c");
        sb.append(10.0f);
        sb.append(" ");
        sb.append(20.0d);
        sb.append(" ");
        sb.append(1000);
        sb.append(true);
        sb.append("AAA");
        sb.toString();

        System.out.println(sb.toString());

        StringBuffer sbf = new StringBuffer("strigBuffer");
        sbf.append("SSS");
        sbf.append(sb);
        System.out.println(sbf.toString());

    }


}
