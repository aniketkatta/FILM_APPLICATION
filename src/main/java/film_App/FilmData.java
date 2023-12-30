package film_App;

public class FilmData {
    private int filmId;
    private String filmName;
    private int filmYear;
    private String filmlang;
    private double filmRating;

    public FilmData() {
    }

    public FilmData(String filmName, int filmYear, String filmlang, double filmRating) {
//        this.filmId = filmId;
        this.filmName = filmName;
        this.filmYear = filmYear;
        this.filmlang = filmlang;
        this.filmRating = filmRating;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public int getFilmYear() {
        return filmYear;
    }

    public void setFilmYear(int filmYear) {
        this.filmYear = filmYear;
    }

    public String getFilmlang() {
        return filmlang;
    }

    public void setFilmlang(String filmlang) {
        this.filmlang = filmlang;
    }

    public double getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(double filmRating) {
        this.filmRating = filmRating;
    }
}
