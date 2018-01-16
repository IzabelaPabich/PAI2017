package pl.ftims.pai.entities;

public enum OrderStatus {

    CREATED("Created"),
    IN_PROGRESS("In Progress"),
    FINALIZED("Finalized");

    OrderStatus(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
