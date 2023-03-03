/**
 * Notebook
 */
public class Notebook {
    private static int nextId = 0;
    int id;
    String manufacturer = "";
    String model = "";    
    double diagonal;
    int ram;
    String processor ="";
    int hardDiskVloume;    
    String color = "";
    String os = "";

    public Notebook() {
    this.id=Notebook.nextId++;}



    public Notebook(int id, String manufacturer, String model, double diagonal, int ram, String processor,
            int hardDiskVloume, String color, String os) {
        this.id = ++Notebook.nextId;;
        this.manufacturer = manufacturer;
        this.model = model;
        this.diagonal = diagonal;
        this.ram = ram;
        this.processor = processor;
        this.hardDiskVloume = hardDiskVloume;
        this.color = color;
        this.os = os;
    }

    

    @Override
    public String toString() {
        return  id + " " + manufacturer + " " + model + ", diagonal=" + diagonal
                + ", ram=" + ram + ", processor=" + processor + ", hardDiskVloume=" + hardDiskVloume + ", color="
                + color + ", os=" + os ;
    }  
    
}