class Phone {
    private String number;
    private PhoneCategory category;

    public Phone(String number, PhoneCategory category) {
        this.number = number;
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public PhoneCategory getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Phone: " + number;
    }
}