import static java.lang.Math.*;
import static java.lang.Math.E;
import java.util.Date;

public class lab_1 {
    public static double getRandomNumber(double min, double max) {
        return (double)((random() * (max - min)) + min);
    }

    public static void getArray1(short[] a) {
        for (short i : a) {
            System.out.printf("%d ", i);
        }
        System.out.println('\n');
    }

    public static void getArray2(double[] a) {
        for (double i : a) {
            System.out.printf("%.2f ", i);
        }
        System.out.println('\n');
    }

    public static double base(double xi) {
        return atan(pow((xi + 5) / 2 * E + 1, 2));
    }

    public static double index(double xi) {
        return pow(((pow((xi / (xi - 0.5)), 2) - 1) / cos(xi)), 3);
    }

    public static double lg(double xi) {
        return log(pow(E, asin(1 / (pow(E, abs(xi))))));
    }

    public static double tan(double xi) {
        return 3 / (atan((xi + 5) / 2 * E + 1) + 3);
    }

    public static void getArray3(double[][] arr) {
        for (double[] doubles : arr) {
            for (double aDouble : doubles) {
                if (Double.isInfinite(aDouble) || Double.isNaN(aDouble)) {
                    System.out.printf("%-5.2e ", (double) 0);
                } else {
                    System.out.printf("%-5.2e ", aDouble);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        // Вариант 311401
        System.out.println(
                "P3114 Гиниятуллин Арслан Рафаилович\n" +
                        "Вариант №311401");
        // Task1
        System.out.println("Создать одномерный массив a типа short. Заполнить его чётными числами от 4 до 18 включительно в порядке возрастания.");
        short[] a = new short[8];
        short ind = 0;
        for (short i = 4; i <= 18; i += 2) {
            a[ind] = i;
            ++ind;
        }
        getArray1(a);
        //Task2
        System.out.println("Создать одномерный массив x типа double. Заполнить его 17-ю случайными числами в диапазоне от -5.0 до 15.0.");
        double[] x = new double[17];
        double min = -5.0, max = 15.0;
        for (int i = 0; i < x.length; ++i) {
            x[i] = getRandomNumber(min, max);
        }
        getArray2(x);
        //Task3
        System.out.println("Создать двумерный массив a размером 8x17. Вычислить его элементы по следующей формуле (где x = x[j]): ");
        double[][] arr = new double[8][17];
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {
                double xi = x[j];
                if (a[i] == 10) {
                    double base = base(xi);
                    double index = index(xi);
                    arr[i][j] = pow(base, index);
                } else if (a[i] == 4 || a[i] == 8 || a[i] == 14 || a[i] == 18)
                    arr[i][j] = lg(xi);
                else arr[i][j] = tan(xi);
            }
        }
        getArray3(arr);
        System.out.println(date);
    }
}