public class Country {
    private String id;
    private String name;
    private double area;
    private String terrain;

    public Country() {
    }

    public Country(String id, String name, double area, String terrain) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.terrain = terrain;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void display(){
        System.out.printf("%5s %10s %10.5f %10s\n",id,name,area,terrain);
    }
}
