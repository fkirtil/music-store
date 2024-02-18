import java.util.Arrays;
import java.util.Objects;

public class MusicStoreService {

    private Product[] allProducts;

    private Product[] allSongs;



    private User[] users = new User[]{
            new User(1L, "Ahmet Gültekin"),
            new User(2L, "Asım Kılıç")
    };

    private Song song1 = new Song(1L, "Vazgeçtim", "2009", 3.40, "Müslüm Gürses");
    private Song song2 = new Song(2L, "Tastamam", "2009", 2.40, "Can Bonomo");

    private Game game = new Game(3L, "Knight Online", "2005", 9.90, 5.00);

    public void initializeProducts() {
        allProducts = new Product[]{song1, song2, game};
    }

    public Product searchProductById(Long id) {
        //allProducts
        Product searchedProduct = null;
        for (var product : allProducts) {
            if (product.getId() == id) {
                searchedProduct = product;
                break;
            }
        }
        return searchedProduct;
    }

    public Product searchProductByName(String productName) {
        Product searchedProduct = null;
        for (Product product : allProducts) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println(product.getName() + " bulundu.");
                return product;
            }
        }
        return searchedProduct;
    }

    public Product searchGameByName(String gameName) {
        Product searchedProduct = null;
        for (Product product : allProducts) {
            if (product instanceof Game game) {
                if (game.getName().equalsIgnoreCase(gameName)) {
                    System.out.println(game.getName() + " bulundu.");
                    return game;
                }
            }
        }
        return searchedProduct;
    }

    public Song searchSongOnProductByName(String songName) {
        Song searchedSong = null;
        for (var product : allProducts) {
            if (product.getName().equalsIgnoreCase(songName)) {
                if (product instanceof Song song) {
                    searchedSong = song;
                    System.out.println(song.getName() + " bulundu.");
                    //searchedSong = (Song) product;
                    break;
                }
            }
        }
        return searchedSong;
    }

    public Song searchAllSongs() {
        Song searchedSong = null;
        for (var product : allProducts) {
            if (product instanceof Song song) {
                System.out.println(song.getName());
            }
        }
        return searchedSong;
    }
    public Game searchAllGames() {
        Game searchedGame = null;
        for (var product : allProducts) {
            if (product instanceof Game game) {
                System.out.println(game.getName());
            }
        }
        return searchedGame;
    }

    public void listUsers() {
        var userInfo = Arrays.toString(users);
        System.out.println(userInfo);
    }

    public void listProducts() {
        var productInfo = Arrays.toString(allProducts);
        System.out.println(productInfo);
    }

    public void listSongs() {
        var songInfo = Arrays.toString(allSongs);
    }

    public User findUserById(Long userId) {
        User user = null;
        for (User u : users) {
            if (Objects.equals(u.getId(), userId)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public void listBasketByUserId(Long userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı");
            return;
        }
        user.getBasket().listBasket();
    }

    public void purchaseProduct(Long productId, Long userId) {
        Product product = searchProductById(productId);
        if (product == null) {
            System.out.println("Ürün bulunamadı.");
            return;
        }
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı.");
            return;
        }
        user.getBasket().addProduct(product);
        System.out.println(product.getName() + " alındı");
    }
}
