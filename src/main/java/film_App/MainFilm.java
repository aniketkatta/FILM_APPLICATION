package film_App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainFilm {
    private static Scanner sc=new Scanner(System.in);
    private static Service service=new ServiceImp();
    public static void main(String[] args) {

        System.out.println("\n\n**************** SELECT OPTION *****************");
        System.out.println("1. Add Film Data");
        System.out.println("2. Update Film Data");
        System.out.println("3. Display All Data");
        System.out.println("4. Display Oscar Movie");

        int ch=sc.nextInt();

        switch (ch)
        {
            case 1:
                addFilm();
                break;
            case 2:
                updateFilm();
                break;
            case 3:
                displayAll();
                break;
            case 4:
                displayOscar();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option");


        }
        main(args);

    }

    private static void displayOscar() {
        List<FilmData> filmList=service.displayOscarFilm();
        for (FilmData fd:filmList)
        {
            System.out.println(fd.getFilmId()+"\t\t"+fd.getFilmName()+"\t\t\t\t"+fd.getFilmYear()+"\t\t\t"+fd.getFilmlang()+"\t\t\t"+fd.getFilmRating());
        }
    }

    private static void displayAll() {
        List<FilmData> filmList=service.displayFilm();

        for (FilmData fd:filmList)
        {
            System.out.println(fd.getFilmId()+"\t\t"+fd.getFilmName()+"\t\t\t\t"+fd.getFilmYear()+"\t\t\t"+fd.getFilmlang()+"\t\t\t"+fd.getFilmRating());
        }

    }

    private static void updateFilm() {
        System.out.println("Enter Film Year");
        int filmYear=sc.nextInt();

        System.out.println("Enter Film Name");
        String filmName=sc.next();

        int n=service.updateFilm(filmYear,filmName);
        System.out.println(n+" Row Update");
    }

    private static void addFilm() {
        System.out.println("Enter Film Name");
        sc.nextLine();
        String filmName=sc.nextLine();

        System.out.println("Enter Film Year");
        int filmYear=sc.nextInt();

        System.out.println("Enter Film Lang");
        String filmLang=sc.next();

        System.out.println("Enter Film Rating");
        double filmRating=sc.nextDouble();

        FilmData newFilm=new FilmData(filmName,filmYear,filmLang,filmRating);

        int n=service.addFilm(newFilm);
        System.out.println(n+ "Record Added");
    }
}
