import java.util.ArrayList;
import java.util.Scanner;
public class HITSHOP {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String tenHang = sc.nextLine();
//        double donGia = Double.parseDouble(sc.nextLine());
//        int soLuong = Integer.parseInt(sc.nextLine());
//        double thanhTien = donGia * (double)soLuong;
//        System.out.println("Ten hang: " + tenHang);
//        System.out.println("Don Gia: " + donGia);
//        System.out.println("So luong: " + soLuong);
//        System.out.println("Thanh Tien: " + thanhTien);
//        System.out.println();
//        double VAT_RATE = 0.1;
//        double SHIPPING_FEE = 20000.0F;
//        thanhTien = thanhTien + 0.1 * thanhTien + (double)20000.0F;
//        System.out.println("Thanh Tien: " + thanhTien);
        int choice;
        do {
            printMenu();
            System.out.print("Chọn: ");
            choice=Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addItem(sc);
                    break;
                case 2:
                    removeItem(sc);
                    break;
                case 3:
                    printItem();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.print("Kết thúc");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }
        static void printMenu(){
            System.out.println("1.Thêm mặt hàng");
            System.out.println("2.Xóa mặt hàng");
            System.out.println("3.Xem mặt hàng");
            System.out.println("4.Xem tổng tiền");
            System.out.println("0.Thoát");
        }
        static void addItem(Scanner sc){
            System.out.println("Nhập tên hàng "); String name= sc.nextLine();
            System.out.println("Nhập giá bán: "); Double price=Double.parseDouble(sc.nextLine());
            System.out.println("Nhập số nượng: "); Integer quantity=Integer.parseInt(sc.nextLine());
            names.add(name);
            prices.add(price);
            quantities.add(quantity);
            printItem();
        }
        static void removeItem(Scanner sc){
            System.out.println("Nhập số thứ tự hàng muốn xóa ");
            int index=Integer.parseInt(sc.nextLine());
            if (index <=0 || index >names.size()){
                System.out.println("lựa chọn không hợp lệ ");
                return;
            }
            names.remove(index-1);
            prices.remove(index-1);
            quantities.remove(index-1);
            printItem();
        }
        static void printItem(){
            if (names.isEmpty()){
                System.out.println("Danh sách rỗng");
                return;
            }
            System.out.println("GIỎ HÀNG");
            for(int i=0;i< names.size();i++){
                double moneyTotal= prices.get(i) * quantities.get(i);
                System.out.printf("%d . %s | ĐG: %.1f | SL: %d | Thành tiền: %.1f%n", i + 1, names.get(i), prices.get(i), quantities.get(i), moneyTotal);
            }
        }
        static double calculateTotal(){
            double total=0;
            if (names.isEmpty()){
                total=0;
            }
            for (int i=0 ;i< names.size();i++){
                total+= prices.get(i) * quantities.get(i);
            }
            double VAT_RATE = 0.1 *total;
            double SHIPPING_FEE = 20000;
            double sum = total + VAT_RATE + SHIPPING_FEE;
            System.out.printf("Tiền hàng: %.1f\n", total);
            System.out.printf("VAT (10%%): %.1f\n", VAT_RATE);
            System.out.printf("Phí vận chuyển: %.1f\n",SHIPPING_FEE);
            System.out.printf("Tong thanh toan: %.1f\n",sum);
            return sum;
        }
    }