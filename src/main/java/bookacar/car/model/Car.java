package bookacar.car.model;

import bookacar.common.model.Model;

public class Car extends Model {
    private String model;
    private String manufacturer;
    private int year;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Car [id=%s, model=%s, manufacturer=%s, year=%s]",
                getId(), model, manufacturer, year);
    }

}
