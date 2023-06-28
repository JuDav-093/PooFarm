package ec.edu.espe.model;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class Farm {
    int id;
    String color;
    String weight;
    
    public Farm(int id, String color, String weight) {
        this.id = id;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Farm{" + "id=" + id + ", color=" + color + ", weight=" + weight + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
}
