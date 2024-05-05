import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Roberto nos cuenta que le gustaría contar con ciertas funcionalidades que le harían el
        //trabajo del dia a dia más fácil, tomamos nota de las mismas:
        //● Quiere una forma de poder consultar los alquileres vigentes.
        //● Quiere una forma de poder consultar las devoluciones que deberían hacerse en el
        //dia de la fecha.
        //● Quiere poder consultar los últimos 10 alquileres de cada cliente.
        //● Quiere una forma de consultar los títulos que fueron más alquilados.
        //● También quiere poder buscar títulos por género y ordenarlos según popularidad.
        //● Quiere poder ver información detallada de un determinado título.


        List<Movie> movies = new ArrayList<Movie>();
        List<Clients> clients = new ArrayList<Clients>();

        movies.add(new Movie("accion", "rapidos y furiosos", "01/01/2000", 180d, "PG", "EU", "automoviles", 3));
        movies.add(new Movie("comedia", "y donde estan las rubias", "01/01/2004", 170d, "PG", "EU", "", 2));
        movies.add(new Movie("horror", "insidius", "01/01/1998", 160d, "NC-17", "EU", "fantasmas", 2));

        clients.add(new Clients("juan", "rivadavia 2989", "2235858652"));
        clients.add(new Clients("pepe", "belgrano 2989", "2236325412"));

        VideoStore video = new VideoStore(movies, clients);
        int opc = 0;

        System.out.println("VIDEO STORE DE ALBERTO");
        System.out.println("MENU DE OPCIONES");
        System.out.println("opcion 1 - Alquilar pelicula");
        System.out.println("opcion 2 - devolver pelicula");
        System.out.println("opcion 3 - cargar nuevo cliente");
        System.out.println("opcion 4 - listado de clientes");
        System.out.println("opcion 5 - listado de peliculas");
        System.out.println("opcion 6 - listado de alquileres");
        System.out.println("opcion 7: alquileres que deben devolver hoy");
        System.out.println("opcion 8: titulo mas alquilado");
        System.out.println("opcion 9: orden por popularidad");

        while (opc < 10 && opc >= 0) {
            System.out.println("ingrese la opcion deseada: ");
            Scanner op = new Scanner(System.in);
            opc = op.nextInt();


            switch (opc) {
                case 1:
                    System.out.println("ingrese el nombre de la pelicula que desea alquilar: ");
                    Scanner st = new Scanner(System.in);
                    String tittle = st.nextLine();
                    System.out.println("ingrese el nombre del cliente");
                    String name = st.nextLine();
                    video.rentAMovie(tittle, name);
                    video.toString();
                    break;
                case 2:
                    System.out.println("ingrese el ID del alquiler: ");
                    Scanner sr = new Scanner(System.in);
                    Integer ID = sr.nextInt();
                    video.returnMovie(ID);
                    break;
                case 3:
                    System.out.println("ingrese nombre del cliente: ");
                    Scanner sa = new Scanner(System.in);
                    name = sa.nextLine();
                    System.out.println("ingrese domicilio: ");
                    String adress = sa.nextLine();
                    System.out.println("ingrese telefono: ");
                    String PhoneNumber = sa.nextLine();
                    video.addClient(name, adress, PhoneNumber);
                    break;
                case 4:
                    video.printClients(video);
                    break;
                case 5:
                    video.printMovies(video);
                    break;
                case 6:
                    video.printRents(video);
                    break;
                case 7:
                    video.todaysReturns();
                    break;
                case 8:
                    Collections.sort(movies);
                    System.out.println(movies.getLast().toString());
                    break;
                case 9:
                    Movie mostPopular= video.bestMovie(movies);
                    System.out.println("Pelicula mas popular: ");
                    System.out.println(mostPopular.toString());
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }


    }
}