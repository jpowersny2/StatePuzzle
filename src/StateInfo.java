//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


public class StateInfo {
    private final int[] borderStates = new int[8];
    private int numberOfBorders = 0;
    private final int stateNumber;
    private final int area;
    private int borderIndex;

    public StateInfo(int stateNumber, int area) {
        this.stateNumber = stateNumber;
        this.area = area;
    }

    public void addBorder(int border) {
        this.borderStates[this.numberOfBorders++] = border;
    }

    public boolean isBorder(int state) {
        for(int x = 0; x < this.numberOfBorders; ++x) {
            if (this.borderStates[x] == state) {
                return true;
            }
        }

        return false;
    }

    public int getBorder() {
        this.borderIndex = 0;
        return this.borderStates[this.borderIndex++];
    }

    public int getNextBorder() {
        return this.borderIndex >= this.numberOfBorders ? -1 : this.borderStates[this.borderIndex++];
    }

    public int getArea() {
        return this.area;
    }

    public int getStateNumber() {
        return this.stateNumber;
    }
}