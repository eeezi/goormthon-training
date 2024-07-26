import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        // 상품 목록 생성
        Set<Product> productSet = new HashSet<>();

        // TODO: 상품 클래스를 생성하여 상품목록에 넣는다.

        //csv read
        BufferedReader br = null;
        String line;
        String path = "C:/goormthon-training/CartImpl/src/data.csv";

        List<Product> myProducts = new ArrayList<>();

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            //한 줄 씩 읽기
            while ((line = br.readLine()) != null) {
                //csv 포맷에 맞추기
                String[] temp = line.split(",");

                Product product = new Product(temp[0], temp[1], Integer.parseInt(temp[2]));
                productSet.add(product);

                myProducts.add(product);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 상품 목록 확인
        System.out.println("고유한 상품 목록:");
        for (Product product : productSet) {
            System.out.println(product.getName() + " : " + product.getPrice());
        }

        // 장바구니 생성
        Cart myCart = new Cart();

        // 상품을 장바구니에 추가
        myCart.addProduct(myProducts.get(0), 1);
        myCart.addProduct(myProducts.get(1), 2);


        // 상품을 장바구니에서 제거
        myCart.removeProduct(myProducts.get(0), 1);
        myCart.removeProduct(myProducts.get(1), 1);


        // 장바구니에 현재 담긴 상품들을 출력 (상품이름, 각 상품의 갯수)
        System.out.println(myCart.showItemsStream());

        //추가 테스트
        System.out.println("remove again");
        myCart.removeProduct(myProducts.get(0), 1);
        myCart.showItems();





    }
}
