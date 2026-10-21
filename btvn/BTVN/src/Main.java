import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String tenHang=sc.nextLine();
        double donGia=Double.parseDouble(sc.nextLine());
        int soLuong=Integer.parseInt(sc.nextLine());
        double thanhTien=donGia*soLuong;
    }

}