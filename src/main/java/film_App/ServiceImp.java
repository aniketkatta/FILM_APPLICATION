package film_App;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceImp implements Service{

    private static Connection conn;
    static {
        String url="jdbc:mysql://localhost:3306/filmdb";
        String username="root";
        String password="Kattasql@358";
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    @Override
    public int addFilm(FilmData film) {
        int n=0;
        String insertQuery="insert into film_info (film_name,film_year,film_lang,film_rating) values(?,?,?,?)";
        try {
            PreparedStatement pstmt= conn.prepareStatement(insertQuery);
            pstmt.setString(1,film.getFilmName());
            pstmt.setInt(2,film.getFilmYear());
            pstmt.setString(3,film.getFilmlang());
            pstmt.setDouble(4,film.getFilmRating());

            n=pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    @Override
    public int updateFilm(int year, String filmName) {
        int n=0;

        String updateQuery="UPDATE film_info SET film_year=" + year + " WHERE film_name='" + filmName + "'";

        try {
            Statement stmt= conn.createStatement();
            n=stmt.executeUpdate(updateQuery);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    @Override
    public List<FilmData> displayFilm() {
        String displayQuery="select * from film_info where film_rating>5";
        List<FilmData> filmDataList=new ArrayList<>();

        try {
            Statement stmt=conn.createStatement();
            ResultSet rs= stmt.executeQuery(displayQuery);


            while (rs.next())
            {
                FilmData film=new FilmData();
                film.setFilmId(rs.getInt(1));
                film.setFilmName(rs.getString(2));
                film.setFilmYear(rs.getInt(3));
                film.setFilmlang(rs.getString(4));
                film.setFilmRating(rs.getDouble(5));

                filmDataList.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return filmDataList;
    }

    @Override
    public List<FilmData> displayOscarFilm() {
        String displayOscarFilm="select * from film_info order by film_rating desc limit 5";
        List<FilmData> oscarFilmList=new ArrayList<>();

        try {
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(displayOscarFilm);

            while (rs.next())
            {
                FilmData film=new FilmData();
                film.setFilmId(rs.getInt(1));
                film.setFilmName(rs.getString(2));
                film.setFilmYear(rs.getInt(3));
                film.setFilmlang(rs.getString(4));
                film.setFilmRating(rs.getDouble(5));

                oscarFilmList.add(film);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return oscarFilmList;
    }
}
