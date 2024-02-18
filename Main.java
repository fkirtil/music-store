import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        MusicStoreService service = new MusicStoreService();
        service.initializeProducts();
        printMenu();
        do {
            System.out.print("Seçiminiz: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("----------------------------------");
                    service.listUsers();
                    System.out.println("----------------------------------");
                }
                case 2 -> {
                    System.out.println("----------------------------------");
                    service.listProducts();
                    System.out.println("----------------------------------");

                }
                case 3 -> {
                    System.out.println("----------------------------------");
                    service.searchAllSongs();
                    System.out.println("----------------------------------");
                }
                case 4 -> {
                    System.out.println("----------------------------------");
                    service.searchAllGames();
                    System.out.println("----------------------------------");
                }
                case 5 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Hangi ürünü satın almak istersiniz?");
                    service.listProducts();
                    service.listUsers();
                    Long productId = sc.nextLong();
                    Long userId = sc.nextLong();
                    service.purchaseProduct(productId, userId);
                    System.out.println("----------------------------------");
                }
                case 6 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Ürün ara");
                    String productName = sc.nextLine();
                    service.searchProductByName(productName);
                    System.out.println("----------------------------------");
                }
                case 7 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Şarkı ara");
                    String songName = sc.nextLine();
                    service.searchSongOnProductByName(songName);
                    System.out.println("----------------------------------");
                }
                case 8 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Ürün ara");
                    String gameName = sc.nextLine();
                    service.searchGameByName(gameName);
                    System.out.println("----------------------------------");
                }
                case 9 -> {
                    System.out.println("----------------------------------");
                    System.out.println("Hangi kullanıcının sepetini listelemek istiyorsun?");
                    Long userId = sc.nextLong();
                    service.listBasketByUserId(userId);
                    System.out.println("----------------------------------");
                }
                case -1 -> {
                    System.out.println("İyi günler");
                }
                default -> printMenu();
            }
        } while(choice != -1);

    }

    private static void printMenu() {
        System.out.println("#### Menu ####");
        System.out.println("1 : Kullanıcıları listele");
        System.out.println("2 : Ürünleri listele");
        System.out.println("3 : Şarkıları listele");
        System.out.println("4 : Oyunları listele");
        System.out.println("5 : Ürün satın al");
        System.out.println("6 : Ürün ara");
        System.out.println("7 : Şarkı ara");
        System.out.println("8 : Oyun ara");
        System.out.println("9 : Kullanıcı sepeti listele");
        System.out.println("-1 : Çıkış \n\n");
    }
}
