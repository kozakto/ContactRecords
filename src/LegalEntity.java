public class LegalEntity extends Contact {
    private String name;

    public LegalEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "company: " + name + ", Address: " + address;
    }
}