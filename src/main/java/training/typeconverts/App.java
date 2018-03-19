package training.typeconverts;

public class App {
    public static void main(String[] args) {

        // Byte -> Short -> Integer -> Long -> Float -> Double

        byte b = 0;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        Byte bb = 0;
        Short ss = bb.shortValue();
        Integer ii = ss.intValue();
        Long ll = ii.longValue();
        Float ff = ll.floatValue();
        Double dd = ff.doubleValue();

        // Double -> Float -> Long -> Integer -> Short -> Byte

        double ddd = 100.00;
        float fff = (float) ddd;
        long lll = (long) fff;
        int iii = (int) lll;
        short sss = (short) iii;
        byte bbb = (byte) sss;

        Double dddd = 100.00;
        Float ffff = dddd.floatValue();
        Long llll = ffff.longValue();
        Integer iiii = llll.intValue();
        Short ssss = iiii.shortValue();
        Byte bbbb = ssss.byteValue();
    }
}
