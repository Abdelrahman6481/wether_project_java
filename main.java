import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static Saudi saudi = new Saudi("Saudi Arabia", "Asia", 500000, "Hello Saudi");

    public static City ReadFile(String FileName) throws FileNotFoundException {
        City mycity = null;
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader("D:\\1.programing projects\\saudi java\\Saudi\\Saudi\\" + FileName));
        try {
            ArrayList<String> items = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                items.add(line);
            }

            if (items.isEmpty()) {
                System.out.println("File Is Empty");
                return null;
            }

            for (String item : items) {
                String[] itemData = item.split(";");
                mycity = new City(itemData[0],
                        Integer.valueOf(itemData[1]),
                        Double.valueOf(itemData[2]),
                        itemData[3],
                        Double.valueOf(itemData[4]));
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
        }
        return mycity;
    }

    public static City[] AddCities() {
        City[] myCities = new City[4];
        myCities[0] = new City("Ryad", 5000000, 45, "desc Ryad", 100);
        myCities[1] = new City("Makka", 6000000, 50, "desc makka", 200);
        myCities[2] = new City("Madyna", 3000000, 40, "desc madyna", 300);
        myCities[3] = new City("Gadda", 3000000, 40, "desc gadda", 400);
        return myCities;
    }

    public static void Test() {
        //
//        City[] myCities = AddCities();
//
        Saudi saudi = new Saudi("Saudi Arabia"
                , "Asia"
                , 7000000
                , "i love saudi");
        //saudi.AddCityByFile("test1.txt");
        saudi.PrintCitiesData();

    }

    public static void AddCityInput() { // String name, int population, double temperature, String description, double PricePerDay
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter City Name");
        String name = sc.next();
        System.out.println("Please Enter City population");
        int population = sc.nextInt();
        System.out.println("Please Enter City temperature");
        double temperature = sc.nextDouble();
        System.out.println("Please Enter City description");
        sc.next();
        String description = sc.nextLine();
        System.out.println("Please Enter City PricePerDay");
        double PricePerDay = sc.nextDouble();

        City temp = new City(name, population, temperature, description, PricePerDay);
        saudi.AddCity(temp);
        System.out.println("City is added successfully");
    }

    public static void AdminMenu() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Admin Menu");
        boolean flag = false;
        while (true) {
            System.out.println("Please Enter 1)add city\n2)delete last city\n3) compare cities\n4)number of cities\n5) System Report\n6) add two cities from a files\n7)exit admin panel");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    AddCityInput();
                    break;
                case 2:
                    saudi.DeleteACity();
                    System.out.println("City is deleted successfully");
                    break;
                case 3:
                    saudi.PrintCitiesData();
                    System.out.println("Please enter two indices of two cities (starting from zero) to compare them");
                    int idx1 = sc.nextInt();
                    System.out.println("Please enter the other index");
                    int idx2 = sc.nextInt();
                    if (saudi.CheckIfCitiesAreEqual(idx1, idx2)) System.out.println("Two cities are equal");
                    else System.out.println("Two cities are not equal");
                    break;
                case 4:
                    System.out.println("number of cities is/are:" + saudi.getNumberofCityObj());
                    break;
                case 5:
                    saudi.PrintCitiesData();
                    break;
                case 6:
                    saudi.AddCityByFile("test1.txt");
                    saudi.AddCityByFile("test2.txt");
                    System.out.println("two cities are added successfully form the files");
                    break;
                case 7:
                    System.out.println("Exit admin menu.");
                    return;
                default:
                    System.out.println("Please enter a number from the above menu");
            }
        }
    }

    public static void UserMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To User Menu");
        boolean flag = false;
        while (true) {
            System.out.println("Please Enter 1)View all cities in Saudi Arabia \n2)Book In A City\n3)exit user panel");
            int c = sc.nextInt();
            switch (c) {
                case 1:
                    saudi.PrintCitiesData();
                    break;
                case 2:
                    saudi.ViewCitiesToBook();
                    saudi.BookACity();
                    //System.out.println("City is deleted successfully");
                    break;
                case 3:
                    System.out.println("Exit user menu");
                    return;
                default:
                    System.out.println("Please enter a number from the above menu");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        saudi.AddCityByFile("test1.txt");
        saudi.AddCityByFile("test2.txt");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter 1) for admin\n2) for user\n3) exit the program");
            int c = sc.nextInt();
            Admin arafat = new Admin("Abdelrahman Monatser", 20, "abdo", "123");
            User kamal = new User("Ahmed", 22, 999, "medo", "123");
            switch (c) {
                case 1: // if admin
                    while (true) {
                        System.out.println("Please enter admin UserName");
                        String adminName = sc.next();
                        System.out.println("Please enter admin Password");
                        String pass = sc.next();
                        if (arafat.LogIn(adminName, pass)) {
                            AdminMenu();
                            break;
                        } else System.out.println("Wrong Data,please try again");
                    }
                    break;
                case 2:// if user
                    while (true) {
                        System.out.println("Please enter Customer UserName");
                        String username = sc.next();
                        System.out.println("Please enter Customer Password");
                        String pass = sc.next();
                        if (kamal.LogIn(username, pass)) {
                            UserMenu();
                            break;
                        } else System.out.println("Wrong Data,please try again");
                    }
                    break;
                case 3:// if user
                    System.out.println("Thank you for using our program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose either 1 or 2");
            }
        }
    }
}
