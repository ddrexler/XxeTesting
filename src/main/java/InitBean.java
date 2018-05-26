import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.LinkedList;
import java.util.List;

@Singleton
@Startup
@LocalBean
public class InitBean {


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> pProducts) {
        products = pProducts;
    }

    public static void addToProducts(Product p){
        products.add(p);
    }

    static List<Product> products = new LinkedList<>();

    @PostConstruct
    public void init(){
        createSampleDate();
    }

    private void createSampleDate() {

        Category clothes = new Category("Clothes");

        Category men = new Category("Men");

        men.setParent(clothes);

        Category trousersMen = new Category("Trousers");
        trousersMen.setParent(men);

        Category electro = new Category("Electro");


        Category telly = new Category("Television");
        telly.setParent(electro);

        Category hoover = new Category("Hoover");
        hoover.setParent(electro);

        Category smartphone = new Category("Smartphone");
        smartphone.setParent(electro);

        Product phillips1 = new Product("Philips 55PUK4900", 679.99f, "This new Phillips is superb...", "images/products/Phillips_55PUK4900.jpg", telly);
        Product phillips2 = new Product("Phillips 55PUS6031", 998.99f, "The brand new Phillips...", "images/products/Phillips_55PUS6031.jpg", telly);
        Product samsung3 = new Product("Samsung UE65JU6070", 1200.99f, "This new Samsung is not as good...", "images/products/Samsung_UE65JU6070.jpg", telly);
        Product panasonic1 = new Product("Panasonic TX-49DXW654", 679.99f, "This new Phillips is superb...", "images/products/Panasonic_TX49DXW654.jpg", telly);
        Product panasonic3 = new Product("Panasonic TX55CXW684", 328.99f, "This new Phillips is not as good...", "images/products/Panasonic_TX55CXW684.jpg", telly);
        Product hoover4 = new Product("Dyson Big Ball Parquet", 640.90f, "Brand new and strong...", "images/products/Dyson_Bigball1.jpg", hoover);
        Product smartphone1 = new Product("Apple Iphone 7", 860.90f, "Brand new and strong...", "images/products/Iphone7.jpg", smartphone);
        Product smartphone2 = new Product("Apple Iphone SE", 450.90f, "Brand new and strong...", "images/products/Iphone_SE.jpg", smartphone);
        Product jeans1 = new Product("Lewis", 110.90f, "Brand new and strong...", "images/products/jeans1.jpg", trousersMen);
        Product jeans6 = new Product("Mustang", 55.90f, "Brand new and strong...", "images/products/jeans6.jpg", trousersMen);

        products.add(phillips1);
        products.add(phillips2);
        products.add(samsung3);
        products.add(panasonic1);
        products.add(panasonic3);
        products.add(hoover4);
        products.add(smartphone1);
        products.add(smartphone2);
        products.add(jeans1);
        products.add(jeans6);

    }
}
