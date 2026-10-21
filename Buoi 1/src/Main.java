import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double chieuDai=Double.parseDouble(sc.nextLine());
        double chieuRong=Double.parseDouble(sc.nextLine());
        System.out.println("Chieu dai la: "+chieuDai);
        System.out.println("Chieu rong la: "+chieuRong);
        double chuVi=(chieuDai+chieuRong)*2;
        double dienTich=(chieuDai*chieuRong);
        System.out.println("Chu vi la: "+chuVi);
        System.out.println("Dien tich la: "+dienTich);
    }
}