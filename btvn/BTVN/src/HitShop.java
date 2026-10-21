import java.util.Scanner;
public class HitShop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String tenHang=sc.nextLine();
        double donGia=Double.parseDouble(sc.nextLine());
        int soLuong=Integer.parseInt(sc.nextLine());
        double thanhTien=donGia*soLuong;
        System.out.println("Ten hang: "+tenHang);
        System.out.println("Don Gia: "+donGia);
        System.out.println("So luong: "+soLuong);
        System.out.println("Thanh Tien: "+thanhTien);
    }
}
