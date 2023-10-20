public class Building {
    String BlName;
    String City;
    String FoundationYear;

    public Building(String blName, String city, String foundationYear) {
        BlName = blName;
        City = city;
        FoundationYear = foundationYear;
    }

    public Building() {

    }

    public String getBlName() {
        return BlName;
    }

    public void setBlName(String blName) {
        BlName = blName;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getFoundationYear() {
        return FoundationYear;
    }

    public void setFoundationYear(String foundationYear) {
        FoundationYear = foundationYear;
    }
}
