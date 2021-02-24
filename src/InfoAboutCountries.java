import java.util.Scanner;

class Country{
    String name;
    double square;
}
public class InfoAboutCountries {
    public static void printCountries(Country[]countries) {
        for (int i = 0; i < countries.length; i++) {
            System.out.println("Name: " + countries[i].name + " Square: " + countries[i].square);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter count");
        int count = sc.nextInt();
        sc.nextLine();
        Country [] countries = new Country[count];
        for (int i = 0; i < count; i++) {
            countries[i] = new Country();
            System.out.println("Name =>");
            countries[i].name = sc.nextLine();
            System.out.println("Square =>");
            countries[i].square = sc.nextDouble();
            sc.nextLine();
        }
        printCountries(countries);

        int IndexMax = 0;
        double max = countries[IndexMax].square;

        for (int i = 1; i < countries.length; i++) {
            if (countries[i].square > max) {
                IndexMax = i;
                max = countries[IndexMax].square;
            }
        }
        System.out.println("Country with max square is " + countries[IndexMax].name
                + " where square is equal " + countries[IndexMax].square);

        for (int i = 0; i < count-1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (countries[j].square > countries[j + 1].square) {
                    Country rab = countries[j];
                    countries[j] = countries[j + 1];
                    countries[j + 1] = rab;
                }
            }
        }
        System.out.println("\nList by square: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + countries[i].name + " Square: " + countries[i].square);
        }

        for (int i = 0; i < count-1; i++)
            for (int j = 0; j < count-i-1; j++)
                if(countries [j].name.compareTo(countries[i+1].name) > 0) {
                    Country rab = countries[j];
                    countries[j] = countries[j+1];
                    countries[j+1]=rab;
                }
        System.out.println("\nList by name: ");
        for (int i = 0; i < count; i++) {
            System.out.println("Name: " + countries[i].name + " Square: " + countries[i].square);
        }

        double s = 0;
        for (int i = 0; i < count; i++)
            s += countries[i].square;
        double sr = s/count;
        System.out.println("Average square = " + sr);
        System.out.println("\nCountries with square more than average");
        for (int i = 0; i < count; i++) {
            if (countries[i].square > sr)
                System.out.println("Name: " + countries[i].name + " Square: " + countries[i].square);
        }

        sc.nextLine();
        System.out.println("Enter name of country => ");
        String name = sc.nextLine();
        int nom = -1;

        for (int i = 0; i < count; i++)
            if (name.equalsIgnoreCase(countries[i].name))
                nom = i;
        if (nom!= -1) {
            System.out.println("This is: " + countries[nom].name + " Square: " + countries[nom].square);
        }
        else
            System.out.println("This country is not on the list");
    }
}
