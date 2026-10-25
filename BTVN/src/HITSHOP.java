import java.util.Scanner;
public class HITSHOP {
    public HITSHOP() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenHang = sc.nextLine();
        double donGia = Double.parseDouble(sc.nextLine());
        int soLuong = Integer.parseInt(sc.nextLine());
        double thanhTien = donGia * (double)soLuong;
        System.out.println("Ten hang: " + tenHang);
        System.out.println("Don Gia: " + donGia);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh Tien: " + thanhTien);
        System.out.println();
        double VAT_RATE = 0.1;
        double SHIPPING_FEE = (double)20000.0F;
        thanhTien = thanhTien + 0.1 * thanhTien + (double)20000.0F;
        System.out.println("Thanh Tien: " + thanhTien);
    }
}