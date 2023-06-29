package ec.edu.espe.model;

/**
 *
 * @author Anabel Davila,Andres Espin, DCCO-ESPE
 */
public class Farm {
    int id;
    String specie;
    String color;
    String weight;
    
    public Farm(int id,String specie, String color, String weight) {
        this.id = id;
        this.specie=specie;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Farm{" + "id=" + id +", specie="+ specie + ", color=" + color + ", weight=" + weight + '}';
    }

    public int getId() {
        return id;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getSpecie() {
        return specie;
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
