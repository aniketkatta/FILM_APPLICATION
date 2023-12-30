package film_App;

import java.util.List;

public interface Service {
    int addFilm(FilmData film);
    int updateFilm(int year,String filmName);

    List<FilmData> displayFilm();

    List<FilmData> displayOscarFilm();
}
