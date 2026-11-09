import model.CartItem;
import model.Customer;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HITSHOP {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p01 = new Product("P01", "Áo thun", 150000, 20);
        Product p02 = new Product("P02", "Bình nước", 50000, 10);
        int choice;
        do {
            printMenu();
            System.out.print("Chọn: ");
            choice=Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sach san pham:");
                    System.out.println("P01 - Ao thun - 150000");
                    System.out.println("P02 - Binh nuoc - 50000");
                    System.out.print("Nhap ma san pham: ");
                    String id = sc.nextLine();

                    System.out.print("Nhap so luong: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();
                    if (id.equals("P01")) {
                        addItem(p01, quantity);
                        System.out.println("ADD thanh cong");
                    } else if (id.equals("P02")) {
                        addItem(p01, quantity);
                        System.out.println("ADD thanh co11ng");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 2:

                    System.out.print("Nhap so thu tu mat hang can xoa: ");
                    int number=Integer.parseInt(sc.nextLine());
                    removeItem(number - 1);
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
        static void addItem(Product product, int quantity){
            CartItem item = new CartItem (product, quantity);
            cart.add(item);
        }
        static void removeItem(int index){
            if (index <0 && index >cart.size()){
                return;
            }
            cart.remove(index);
        }
        static void printItem(){
            System.out.println("THONG TIN");
            System.out.println("Khach hang hien tai: " + currentCustomer);
            if (cart.isEmpty()){
                System.out.println("Gio hang rong");
                return;
            }
            for(int i=0;i< cart.size();i++){
                System.out.println((i + 1) + ". " +cart.get(i).getProduct().getId() + " | " +cart.get(i).getProduct().getName() + " | "
                        +cart.get(i).getProduct().getPrice() +" | SL: " +cart.get(i).getQuantity() + " | Thành tiền: "+cart.get(i).getTotal());
            }
            }
        static double calculateTotal(){
            double total = 0;
            for(int i = 0; i < cart.size(); i++){
                total += cart.get(i).getTotal();
            }
            return total;
        }
    }
