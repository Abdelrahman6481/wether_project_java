import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Saudi extends Country {
    private City[] Cities;
    private int sz;
    private final int SIZE = 5;

    public Saudi(String name, String continent, int population, String description) {
        super(name, continent, population, description);
        Cities = new City[SIZE];
        sz = 0;
    }

    public Saudi() {

    }

    public void fillArray(City[] arr, int Size) {
        if (Size > SIZE) {
            System.out.println("Entered Array Is Too Large");
            return;
        }
        for (int i = 0; i < Size; i++, sz++) {
            Cities[i] = arr[i];
        }
    }

    public void AddCity(City obj) {
        if (sz == SIZE) System.out.println("Cities Array Is Full");
        else Cities[sz++] = obj;
    }

    public int getSz() {
        return sz;
    }

    public void PrintCitiesData() {
        for (int i = 0; i < sz; i++) {
            System.out.println(Cities[i].toString());
        }
    }

    public int getNumberofCityObj() {
        return City.getNumberofObjects();
    }

    public boolean CheckIfCitiesAreEqual(int idx1, int idx2) {
        return Cities[idx1].equals(Cities[idx2]);
    }

    public void DeleteACity() {
        if (sz == 0) {
            System.out.println("Array Is Already Empty");
            return;
        }
        sz--;
    }

    public void AddCityByFile(String FileName) throws FileNotFoundException {
        if (sz == SIZE) System.out.println("Cities Array Is Full");
        else Cities[sz++] = main.ReadFile(FileName);
    }

    public void ViewCitiesToBook() {
        System.out.println("Please enter number of the city you want to book in it");
        for (int i = 0; i < sz; i++) {
            System.out.println(i + "--->" + Cities[i].toString());
        }
    }

    public void BookACity() {
        Scanner sc = new Scanner(System.in);
        int c;
        while (true) {
            System.out.println("Please enter number of the city you want to book in it");
            c = sc.nextInt();
            if (c >= 0 && c < sz) break;
        }
        System.out.println("Please enter number of days you want to stay in it");
        int days = sc.nextInt();
        System.out.println("To stay in " + Cities[c].getName() + " For " + days + " Day(s), you will pay " + Cities[c].getPricePerDay() * days + " SAR");
        System.out.println("Are you sure you want to verify the payment [n/y]");
        char choice = sc.next().charAt(0);
        if (choice == 'y') System.out.println("Your Booking is verified Successfully");
        else System.out.println("Your Booking is not completed");
    }
}
