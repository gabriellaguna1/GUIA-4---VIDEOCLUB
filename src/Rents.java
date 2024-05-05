import java.time.LocalDate;
import java.util.List;

public class Rents {
    private static int i=1;
    Integer ID;
    private Movie movie;
    private Clients client;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Rents(Movie movie, Clients client, LocalDate loanDate) {
        this.ID = i++;
        this.movie = movie;
        this.client = client;
        this.loanDate = loanDate;
        this.returnDate = loanDate.plusDays(2);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Rents{" +
                "ID=" + ID +
                ", movie=" + movie +
                ", client=" + client +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                '}';
    }
}



