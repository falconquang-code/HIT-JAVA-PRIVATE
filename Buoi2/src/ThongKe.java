import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThongK {
    static final List<String> names = new ArrayList<>();
    static final List<Double> p  rices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();
    public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("lựa chọn: ");
        int choice=Integer.parseInt(sc.nextLine());
        switch (choice) {
        case 1 -> System.out.println("them mot mat hang"); additem("So tay",25000.0,3);
        case 2 -> System.out.println("xoa mot mat hang"); removeitem();
        case 3 -> System.out.println("in mat hang") printitem();
        case 4 -> System.out.println("Tổng tiền: ");
        case 5 -> System.out.println("Kết thúc.");
        default -> System.out.println("Lựa chọn không hợp lệ.");
    }
}
static void Printmenu(){
    System.out.println("1.Thêm mặt hàng");
    System.out.println("2.Xóa mặt hàng");
    System.out.println("3.in mặt hàng");
    System.out.println("4.Tính tổng tiền");
    System.out.println("5.Kết thúc");
}
    static void additem(String name, double price, Integer quantitie){
    names.add(name);
    prices.add(price);
    quantities.add(quantitie);
    if (names.isEmpty()){
        System.out.println("khong tim thay mat hang");
        return;
    }
        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }
    static void removeitem(String name, double price, Integer quantitie){
        names.remove(name);
        prices.remove(price);
        quantities.remove(quantitie);
    }
}

