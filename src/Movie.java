public class Movie implements Comparable<Movie> {
    private String gendre;
    private String tittle;
    private String realeaseDate; // fecha de lanzamiento
    private Double duration;
    private String classification;
    private String countryAcronym;
    private String description;
    private Integer copies;
    private Integer rentsAmount=0;

    public Movie() {
    }

    public Movie(String gendre, String tittle, String realeaseDate, Double duration, String classification, String countryAcronym, String description, Integer copies) {
        this.gendre = gendre;
        this.tittle = tittle;
        this.realeaseDate = realeaseDate;
        this.duration = duration;
        this.classification = classification;
        this.countryAcronym = countryAcronym;
        this.description = description;
        this.copies = copies;
    }

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getRealeaseDate() {
        return realeaseDate;
    }

    public void setRealeaseDate(String realeaseDate) {
        this.realeaseDate = realeaseDate;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCountryAcronym() {
        return countryAcronym;
    }

    public void setCountryAcronym(String countryAcronym) {
        this.countryAcronym = countryAcronym;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public Integer getRentsAmount() {
        return rentsAmount;
    }

    public void setRentsAmount(Integer rentsAmount) {
        this.rentsAmount = rentsAmount;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "gendre='" + gendre + '\'' +
                ", tittle='" + tittle + '\'' +
                ", realeaseDate='" + realeaseDate + '\'' +
                ", duration=" + duration +
                ", classification='" + classification + '\'' +
                ", countryAcronym='" + countryAcronym + '\'' +
                ", description='" + description + '\'' +
                ", copies=" + copies + '\'' +
                ", cant alquileres= "+ rentsAmount+
                '}';
    }

    @Override
    public int compareTo(Movie o) {
        return this.getRentsAmount().compareTo(o.getRentsAmount());
    }
}
