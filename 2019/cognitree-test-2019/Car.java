package cognitree;

import java.util.Objects;

public class Car {

    private String name;
    private String country;
    private Double horsePower;

    public Car(String record) {
        String[] values = record.split(",");
        this.name = values[0];
        this.country = values[1];
        this.horsePower = Double.valueOf(values[2]);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(country, car.country) &&
                Objects.equals(horsePower, car.horsePower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, horsePower);
    }

    @Override
    public String toString() {
        return this.name + "," + this.horsePower + "," + this.country;
    }
}
