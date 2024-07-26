import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 상품 목록
        Set<Product> productSet = new HashSet<>();

        // 상품 글래스를 생성하여 상품 목록에 넣기
        Product product1 = new Product("1", "칫솔", 1000);
        Product product2 = new Product("2", "치약", 2000);
        productSet.add(product1);
        productSet.add(product2);

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(product1, 1);
        myCart.addProduct(product2, 2);
        myCart.showItems();

        // 상품을 장바구니에서 제거
        myCart.removeProduct(product1, 1);
        myCart.removeProduct(product2, 1);


        // 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        System.out.println(myCart.showItemsStream());

        //추가 테스트
        System.out.println("remove again");
        myCart.removeProduct(product1, 1);
        myCart.showItems();
    }
}