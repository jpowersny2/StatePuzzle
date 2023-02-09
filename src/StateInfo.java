//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.logging.Level;
import java.util.logging.Logger;

public class StateInfo {
    private final int[] borderStates = new int[8];
    private int numberOfBorders = 0;
    private final int stateNumber;
    private final int area;
    private int borderIndex;

    private StateInfo(int stateNumber, int area) {
        this.stateNumber = stateNumber;
        this.area = area;
    }

    private void addBorder(int border) {
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

    static public StateInfo[] stateInfoFactory() {
        StateInfo[] stateInfo = new StateInfo[48];

        try {
            int n = StateNames.getNumber("AL");
            stateInfo[n] = new StateInfo(n, 52);
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("GA"));
            stateInfo[n].addBorder(StateNames.getNumber("FL"));
            stateInfo[n].addBorder(StateNames.getNumber("MS"));
            n = StateNames.getNumber("AZ");
            stateInfo[n] = new StateInfo(n, 114);
            stateInfo[n].addBorder(StateNames.getNumber("UT"));
            stateInfo[n].addBorder(StateNames.getNumber("NM"));
            stateInfo[n].addBorder(StateNames.getNumber("CA"));
            stateInfo[n].addBorder(StateNames.getNumber("NV"));
            n = StateNames.getNumber("AR");
            stateInfo[n] = new StateInfo(n, 53);
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("MS"));
            stateInfo[n].addBorder(StateNames.getNumber("LA"));
            stateInfo[n].addBorder(StateNames.getNumber("TX"));
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            n = StateNames.getNumber("CA");
            stateInfo[n] = new StateInfo(n, 159);
            stateInfo[n].addBorder(StateNames.getNumber("OR"));
            stateInfo[n].addBorder(StateNames.getNumber("NV"));
            stateInfo[n].addBorder(StateNames.getNumber("AZ"));
            n = StateNames.getNumber("CO");
            stateInfo[n] = new StateInfo(n, 104);
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            stateInfo[n].addBorder(StateNames.getNumber("KS"));
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            stateInfo[n].addBorder(StateNames.getNumber("NM"));
            stateInfo[n].addBorder(StateNames.getNumber("UT"));
            n = StateNames.getNumber("CT");
            stateInfo[n] = new StateInfo(n, 5);
            stateInfo[n].addBorder(StateNames.getNumber("MA"));
            stateInfo[n].addBorder(StateNames.getNumber("RI"));
            stateInfo[n].addBorder(StateNames.getNumber("NY"));
            n = StateNames.getNumber("DE");
            stateInfo[n] = new StateInfo(n, 2);
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            stateInfo[n].addBorder(StateNames.getNumber("NJ"));
            stateInfo[n].addBorder(StateNames.getNumber("MD"));
            n = StateNames.getNumber("FL");
            stateInfo[n] = new StateInfo(n, 59);
            stateInfo[n].addBorder(StateNames.getNumber("GA"));
            stateInfo[n].addBorder(StateNames.getNumber("AL"));
            n = StateNames.getNumber("GA");
            stateInfo[n] = new StateInfo(n, 59);
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("NC"));
            stateInfo[n].addBorder(StateNames.getNumber("SC"));
            stateInfo[n].addBorder(StateNames.getNumber("FL"));
            stateInfo[n].addBorder(StateNames.getNumber("AL"));
            n = StateNames.getNumber("ID");
            stateInfo[n] = new StateInfo(n, 84);
            stateInfo[n].addBorder(StateNames.getNumber("MT"));
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            stateInfo[n].addBorder(StateNames.getNumber("UT"));
            stateInfo[n].addBorder(StateNames.getNumber("NV"));
            stateInfo[n].addBorder(StateNames.getNumber("OR"));
            stateInfo[n].addBorder(StateNames.getNumber("WA"));
            n = StateNames.getNumber("IL");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(StateNames.getNumber("WI"));
            stateInfo[n].addBorder(StateNames.getNumber("IN"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            n = StateNames.getNumber("IN");
            stateInfo[n] = new StateInfo(n, 36);
            stateInfo[n].addBorder(StateNames.getNumber("MI"));
            stateInfo[n].addBorder(StateNames.getNumber("OH"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("IL"));
            n = StateNames.getNumber("IA");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(StateNames.getNumber("MN"));
            stateInfo[n].addBorder(StateNames.getNumber("WI"));
            stateInfo[n].addBorder(StateNames.getNumber("IL"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            n = StateNames.getNumber("KS");
            stateInfo[n] = new StateInfo(n, 82);
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            n = StateNames.getNumber("KY");
            stateInfo[n] = new StateInfo(n, 40);
            stateInfo[n].addBorder(StateNames.getNumber("IL"));
            stateInfo[n].addBorder(StateNames.getNumber("IN"));
            stateInfo[n].addBorder(StateNames.getNumber("OH"));
            stateInfo[n].addBorder(StateNames.getNumber("WV"));
            stateInfo[n].addBorder(StateNames.getNumber("VA"));
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            n = StateNames.getNumber("LA");
            stateInfo[n] = new StateInfo(n, 49);
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            stateInfo[n].addBorder(StateNames.getNumber("MS"));
            stateInfo[n].addBorder(StateNames.getNumber("TX"));
            n = StateNames.getNumber("ME");
            stateInfo[n] = new StateInfo(n, 33);
            stateInfo[n].addBorder(StateNames.getNumber("NH"));
            n = StateNames.getNumber("MD");
            stateInfo[n] = new StateInfo(n, 11);
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            stateInfo[n].addBorder(StateNames.getNumber("DE"));
            stateInfo[n].addBorder(StateNames.getNumber("VA"));
            stateInfo[n].addBorder(StateNames.getNumber("WV"));
            n = StateNames.getNumber("MA");
            stateInfo[n] = new StateInfo(n, 8);
            stateInfo[n].addBorder(StateNames.getNumber("VT"));
            stateInfo[n].addBorder(StateNames.getNumber("NH"));
            stateInfo[n].addBorder(StateNames.getNumber("RI"));
            stateInfo[n].addBorder(StateNames.getNumber("CT"));
            stateInfo[n].addBorder(StateNames.getNumber("NY"));
            n = StateNames.getNumber("MI");
            stateInfo[n] = new StateInfo(n, 58);
            stateInfo[n].addBorder(StateNames.getNumber("OH"));
            stateInfo[n].addBorder(StateNames.getNumber("IN"));
            stateInfo[n].addBorder(StateNames.getNumber("WI"));
            n = StateNames.getNumber("MN");
            stateInfo[n] = new StateInfo(n, 84);
            stateInfo[n].addBorder(StateNames.getNumber("WI"));
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            stateInfo[n].addBorder(StateNames.getNumber("ND"));
            n = StateNames.getNumber("MS");
            stateInfo[n] = new StateInfo(n, 48);
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("AL"));
            stateInfo[n].addBorder(StateNames.getNumber("LA"));
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            n = StateNames.getNumber("MO");
            stateInfo[n] = new StateInfo(n, 70);
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            stateInfo[n].addBorder(StateNames.getNumber("IL"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            stateInfo[n].addBorder(StateNames.getNumber("KS"));
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            n = StateNames.getNumber("MT");
            stateInfo[n] = new StateInfo(n, 147);
            stateInfo[n].addBorder(StateNames.getNumber("ND"));
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
            n = StateNames.getNumber("NE");
            stateInfo[n] = new StateInfo(n, 77);
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("KS"));
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            n = StateNames.getNumber("NV");
            stateInfo[n] = new StateInfo(n, 110);
            stateInfo[n].addBorder(StateNames.getNumber("OR"));
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
            stateInfo[n].addBorder(StateNames.getNumber("UT"));
            stateInfo[n].addBorder(StateNames.getNumber("AZ"));
            stateInfo[n].addBorder(StateNames.getNumber("CA"));
            n = StateNames.getNumber("NH");
            stateInfo[n] = new StateInfo(n, 9);
            stateInfo[n].addBorder(StateNames.getNumber("ME"));
            stateInfo[n].addBorder(StateNames.getNumber("MA"));
            stateInfo[n].addBorder(StateNames.getNumber("VT"));
            n = StateNames.getNumber("NJ");
            stateInfo[n] = new StateInfo(n, 8);
            stateInfo[n].addBorder(StateNames.getNumber("NY"));
            stateInfo[n].addBorder(StateNames.getNumber("DE"));
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            n = StateNames.getNumber("NM");
            stateInfo[n] = new StateInfo(n, 122);
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            stateInfo[n].addBorder(StateNames.getNumber("TX"));
            stateInfo[n].addBorder(StateNames.getNumber("AZ"));
            n = StateNames.getNumber("NY");
            stateInfo[n] = new StateInfo(n, 50);
            stateInfo[n].addBorder(StateNames.getNumber("VT"));
            stateInfo[n].addBorder(StateNames.getNumber("MA"));
            stateInfo[n].addBorder(StateNames.getNumber("CT"));
            stateInfo[n].addBorder(StateNames.getNumber("NJ"));
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            n = StateNames.getNumber("NC");
            stateInfo[n] = new StateInfo(n, 53);
            stateInfo[n].addBorder(StateNames.getNumber("VA"));
            stateInfo[n].addBorder(StateNames.getNumber("SC"));
            stateInfo[n].addBorder(StateNames.getNumber("GA"));
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            n = StateNames.getNumber("ND");
            stateInfo[n] = new StateInfo(n, 71);
            stateInfo[n].addBorder(StateNames.getNumber("MN"));
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            stateInfo[n].addBorder(StateNames.getNumber("MT"));
            n = StateNames.getNumber("OH");
            stateInfo[n] = new StateInfo(n, 41);
            stateInfo[n].addBorder(StateNames.getNumber("MI"));
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            stateInfo[n].addBorder(StateNames.getNumber("WV"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("IN"));
            n = StateNames.getNumber("OK");
            stateInfo[n] = new StateInfo(n, 70);
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            stateInfo[n].addBorder(StateNames.getNumber("KS"));
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            stateInfo[n].addBorder(StateNames.getNumber("TX"));
            stateInfo[n].addBorder(StateNames.getNumber("NM"));
            n = StateNames.getNumber("OR");
            stateInfo[n] = new StateInfo(n, 97);
            stateInfo[n].addBorder(StateNames.getNumber("WA"));
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
            stateInfo[n].addBorder(StateNames.getNumber("NV"));
            stateInfo[n].addBorder(StateNames.getNumber("CA"));
            n = StateNames.getNumber("PA");
            stateInfo[n] = new StateInfo(n, 45);
            stateInfo[n].addBorder(StateNames.getNumber("NY"));
            stateInfo[n].addBorder(StateNames.getNumber("NJ"));
            stateInfo[n].addBorder(StateNames.getNumber("DE"));
            stateInfo[n].addBorder(StateNames.getNumber("MD"));
            stateInfo[n].addBorder(StateNames.getNumber("WV"));
            stateInfo[n].addBorder(StateNames.getNumber("OH"));
            n = StateNames.getNumber("RI");
            stateInfo[n] = new StateInfo(n, 1);
            stateInfo[n].addBorder(StateNames.getNumber("MA"));
            stateInfo[n].addBorder(StateNames.getNumber("CT"));
            n = StateNames.getNumber("SC");
            stateInfo[n] = new StateInfo(n, 31);
            stateInfo[n].addBorder(StateNames.getNumber("NC"));
            stateInfo[n].addBorder(StateNames.getNumber("GA"));
            n = StateNames.getNumber("SD");
            stateInfo[n] = new StateInfo(n, 77);
            stateInfo[n].addBorder(StateNames.getNumber("ND"));
            stateInfo[n].addBorder(StateNames.getNumber("MN"));
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            stateInfo[n].addBorder(StateNames.getNumber("MT"));
            n = StateNames.getNumber("TN");
            stateInfo[n] = new StateInfo(n, 42);
            stateInfo[n].addBorder(StateNames.getNumber("MO"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("VA"));
            stateInfo[n].addBorder(StateNames.getNumber("NC"));
            stateInfo[n].addBorder(StateNames.getNumber("GA"));
            stateInfo[n].addBorder(StateNames.getNumber("AL"));
            stateInfo[n].addBorder(StateNames.getNumber("MS"));
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            n = StateNames.getNumber("TX");
            stateInfo[n] = new StateInfo(n, 267);
            stateInfo[n].addBorder(StateNames.getNumber("OK"));
            stateInfo[n].addBorder(StateNames.getNumber("AR"));
            stateInfo[n].addBorder(StateNames.getNumber("LA"));
            stateInfo[n].addBorder(StateNames.getNumber("NM"));
            n = StateNames.getNumber("UT");
            stateInfo[n] = new StateInfo(n, 85);
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
            stateInfo[n].addBorder(StateNames.getNumber("WY"));
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            stateInfo[n].addBorder(StateNames.getNumber("AZ"));
            stateInfo[n].addBorder(StateNames.getNumber("NV"));
            n = StateNames.getNumber("VT");
            stateInfo[n] = new StateInfo(n, 10);
            stateInfo[n].addBorder(StateNames.getNumber("NH"));
            stateInfo[n].addBorder(StateNames.getNumber("MA"));
            stateInfo[n].addBorder(StateNames.getNumber("NY"));
            n = StateNames.getNumber("VA");
            stateInfo[n] = new StateInfo(n, 41);
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            stateInfo[n].addBorder(StateNames.getNumber("WV"));
            stateInfo[n].addBorder(StateNames.getNumber("MD"));
            stateInfo[n].addBorder(StateNames.getNumber("NC"));
            stateInfo[n].addBorder(StateNames.getNumber("TN"));
            n = StateNames.getNumber("WA");
            stateInfo[n] = new StateInfo(n, 68);
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
            stateInfo[n].addBorder(StateNames.getNumber("OR"));
            n = StateNames.getNumber("WV");
            stateInfo[n] = new StateInfo(n, 24);
            stateInfo[n].addBorder(StateNames.getNumber("OH"));
            stateInfo[n].addBorder(StateNames.getNumber("PA"));
            stateInfo[n].addBorder(StateNames.getNumber("MD"));
            stateInfo[n].addBorder(StateNames.getNumber("VA"));
            stateInfo[n].addBorder(StateNames.getNumber("KY"));
            n = StateNames.getNumber("WI");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(StateNames.getNumber("MN"));
            stateInfo[n].addBorder(StateNames.getNumber("MI"));
            stateInfo[n].addBorder(StateNames.getNumber("IL"));
            stateInfo[n].addBorder(StateNames.getNumber("IA"));
            n = StateNames.getNumber("WY");
            stateInfo[n] = new StateInfo(n, 98);
            stateInfo[n].addBorder(StateNames.getNumber("MT"));
            stateInfo[n].addBorder(StateNames.getNumber("SD"));
            stateInfo[n].addBorder(StateNames.getNumber("NE"));
            stateInfo[n].addBorder(StateNames.getNumber("CO"));
            stateInfo[n].addBorder(StateNames.getNumber("UT"));
            stateInfo[n].addBorder(StateNames.getNumber("ID"));
        } catch (StateNameError e) {
            Logger.getLogger(StatePuzzle.class.getName()).log(Level.SEVERE, null, e);
        }

        return stateInfo;
    }

}