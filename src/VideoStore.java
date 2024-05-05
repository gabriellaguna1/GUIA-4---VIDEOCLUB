import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideoStore{
    private List<Movie>movie;
    private List<Clients>client;
    private List<Rents>rent;

    public VideoStore(List<Movie> movie, List<Clients> client) {
        this.movie = movie;
        this.client = client;
        this.rent=new ArrayList<>(10);
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public List<Clients> getClient() {
        return client;
    }

    public List<Rents> getRent() {
        return rent;
    }

    public Movie seekMovie(String tittle){
        for(Movie m: movie){
            if(m.getTittle().equals(tittle)){
                return m;
            }
        }
        return null;
    }
    public Clients seekClient(String name){
        for(Clients c: client){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
    public Rents seekRent(Integer ID){
        for(Rents r: rent){
            if(r.ID==ID){
                return r;
            }
        }
        return null;
    }
    public void deleteRent(Integer ID){
        for(int i=0; i<rent.size(); i++){
            if(rent.get(i).ID==ID){
                rent.remove(i);
            }
        }
    }
    public String addClient(String name, String adress, String phoneNumber){
        Clients c=new Clients(name, adress, phoneNumber);
        client.add(c);
        System.out.println("cliente agregado a base de datos, mostrando datos cargados...");
        return c.toString();
    }

    public Rents rentAMovie(String tittle, String client){
        Rents r=null;
        Movie m=seekMovie(tittle);
        Clients c= seekClient(client);
        if(m==null){
            System.out.println("pelicula no encontrada en base de datos");
        }
        if(c==null){
            System.out.println("cliente no encontrado en base de datos");
        }
        if(m!=null && c!=null){
            if(m.getCopies()>0){
                r= new Rents(m,c, LocalDate.now());
                rent.add(r);
                m.setCopies(m.getCopies()-1);
                m.setRentsAmount(m.getRentsAmount()+1);
                System.out.println("pelicula alquilada exitosamente");
            }
            else{
                System.out.println("no hay stock de la pelicula elegida");
            }

        }

        return r;
    }

    public void returnMovie(int ID){
        Rents r=seekRent(ID);
        if(r!=null){
            String tittle=r.getMovie().getTittle();
            Movie m=seekMovie(tittle);
            m.setCopies(m.getCopies()+1);
            System.out.println("pelicula devuelta satisfactoriamente");
            deleteRent(ID);
        }
        else{
            System.out.println("alquiler no encontrado con ese ID");
        }
    }
    public void printMovies(VideoStore vd) {
        System.out.println("\n=== peliculas ===");
        for (Movie m : vd.getMovie()) {
            System.out.println(m);
        }
    }

    public void printClients(VideoStore vd) {
        System.out.println("\n=== clientes ===");
        for (Clients c : vd.getClient()) {
            System.out.println(c);
        }
    }

    public void printRents(VideoStore vd) {
        if(vd.getRent()==null){
            System.out.println("no hay peliculas en alquiler");
            return;
        }
        System.out.println("\n=== alquileres activos ===");
        for (Rents r : vd.getRent()) {
            System.out.println(r);
        }
    }
    public void todaysReturns(){
        List<Rents> todaysRet= new ArrayList<>();
        for(Rents r: rent){
            if(r.getReturnDate().equals(LocalDate.now())){
                todaysRet.add(r);
            }
        }
        for(Rents r: todaysRet){
            r.toString();
        }
    }

    public Movie bestMovie(List<Movie> x) {
        Integer amount;
        Integer max = 0;
        Movie bestMovie = new Movie();

        for (Movie m : x) {
           amount = 0;
            for (Rents r : rent) {
                if( m.getTittle().equalsIgnoreCase(r.getMovie().getTittle())){
                    amount++;
                }
            }
            if ( amount > max){
                max = amount;
                bestMovie = m;
            }
        }
        return bestMovie;
    }

}
