package part_6;

public class Pad extends Computer {
    private boolean hasStylus;

    public Pad(String model, double price, int ram, String screenResolution, String processor, boolean hasStylus) {
        createModel(model);
        setPrice(price);
        addRAM(ram);
        changeScreenResolution(screenResolution);
        changeProcessor(processor);
        this.hasStylus = hasStylus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Stylus: " + (hasStylus ? "Yes" : "No"));
    }

    public void draw(String drawing) {
        System.out.println("Drawing: " + drawing);
    }
}
