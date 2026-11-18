import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HITSHOP {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();
    private static final List<Product> products= new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product p01 = new Product("P01", "Áo thun", 150000, 20);
        Product p02 = new Product("P02", "Bình nước", 50000, 10);
        products.add(p01);
        products.add(p02);
        int choice;
        do {
            printMenu();
            System.out.print("Chọn: ");
            choice=Integer.parseInt(sc.nextLine());
            switch(choice) {
                case 1:
                    System.out.println("Chọn loại sản phẩm");
                    System.out.println("1.Product");
                    System.out.println("2.Book");
                    System.out.println("3.Cake");
                    System.out.print("Chọn loại: ");
                    int option= sc.nextInt();;
                sc.nextLine();
                System.out.print("Nhập id: ");
                String id = sc.nextLine();

                System.out.print("Nhập tên sản phẩm: ");
                String name = sc.nextLine();

                System.out.print("Nhập giá: ");
                double price = sc.nextDouble();

                System.out.print("Nhập tồn kho: ");
                int stock = sc.nextInt();
                sc.nextLine();
                Product product = null;
                if( option==1) {
                    product = new Product(id, name, price, stock){
                    };
                } else if(option==2) {
                    System.out.print("Nhập tên tác giả: ");
                    String author = sc.nextLine();
                    product = new Book(
                            id, name, price, stock, author
                    );
                } else if(option== 3) {
                    System.out.print("Nhập thương hiệu bánh: ");
                    String brand = sc.nextLine();
                    product = new Cake(
                            id, name, price, stock, brand
                    );
                }
                products.add(product);
                System.out.print("Nhập số lượng mua: ");
                int quantity = sc.nextInt();
                if(quantity <= 0 || quantity > stock) {
                    System.out.println("Số lượng không hợp lệ.");
                    products.remove(product);
                    break;
                }
                addItem(product, quantity);
                System.out.println("Thêm mặt hàng thành công.");
                break;
                case 2:
                    if(cart.isEmpty()) {
                        System.out.println("Giỏ hàng đang trống.");
                        break;
                    }
                    printItem();
                    System.out.print("Nhập số thứ tự cần xóa: ");
                    int displayNumber = sc.nextInt();
                    if(displayNumber < 0 || displayNumber >= cart.size()) {
                        System.out.println("Không tìm thấy mặt hàng.");
                    } else{
                        removeItem(displayNumber-1);
                        System.out.println("Xóa mặt hàng thành công.");
                    }
                    break;
                case 3:
                    printItem();
                    break;
                case 4:
                    System.out.println("SUM: " + calculateTotal());
                    break;
                case 0:
                    System.out.println("Kết thúc");
                    break;
                case 5:
                    System.out.print("Nhập id sản phẩm: ");
                    String searchId = sc.next();
                    Product foundProduct = null;

                    for (Product p : products) {
                        if(p.getId().equalsIgnoreCase(searchId)) {
                            foundProduct = p;
                            break;
                        }
                    }
                    if (foundProduct == null) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    } else{
                        if(foundProduct.isExpensive()){
                            System.out.println("Sản phẩm đắt.");
                        } else{
                            System.out.println("Sản phẩm is cheap.");
                        }
                    }
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
            System.out.println("5.Kiểm tra sản phẩm đắt hay cheap");
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