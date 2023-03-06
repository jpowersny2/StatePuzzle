//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.util.logging.Level;
import java.util.logging.Logger;

public class StateInfo {

    private static final String[] STATE_NAMES = new String[]{"TX", "CA", "MT", "NM", "AZ", "NV", "CO", "WY", "OR", "UT", "MN", "ID", "KS", "SD", "NE", "ND", "OK", "MO", "WA", "FL", "GA", "MI", "IA", "IL", "WI", "AR", "NC", "AL", "NY", "LA", "MS", "PA", "TN", "VA", "OH", "KY", "IN", "ME", "SC", "WV", "MD", "VT", "NH", "NJ", "MA", "CT", "DE", "RI" };

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

    public static String getName(int num) throws StateNameError {
        if (num >= 0 && num <= 47) {
            return STATE_NAMES[num];
        } else {
            throw new StateNameError(String.format("State number out of range: %d", num));
        }
    }
    public static int getNumber(String name) throws StateNameError {
        for(int x = 0; x < 48; ++x) {
            if (name.compareTo(STATE_NAMES[x]) == 0) {
                return x;
            }
        }

        throw new StateNameError(String.format("Unknow state: %s", name));
    }


    static public StateInfo[] stateInfoFactory() {
        StateInfo[] stateInfo = new StateInfo[48];

        try {
            int n = getNumber("TX");
            stateInfo[n] = new StateInfo(n, 267);
            stateInfo[n].addBorder(getNumber("OK"));
            stateInfo[n].addBorder(getNumber("AR"));
            stateInfo[n].addBorder(getNumber("LA"));
            stateInfo[n].addBorder(getNumber("NM"));
            n = getNumber("CA");
            stateInfo[n] = new StateInfo(n, 159);
            stateInfo[n].addBorder(getNumber("OR"));
            stateInfo[n].addBorder(getNumber("NV"));
            stateInfo[n].addBorder(getNumber("AZ"));
            n = getNumber("MT");
            stateInfo[n] = new StateInfo(n, 147);
            stateInfo[n].addBorder(getNumber("ND"));
            stateInfo[n].addBorder(getNumber("SD"));
            stateInfo[n].addBorder(getNumber("WY"));
            stateInfo[n].addBorder(getNumber("ID"));
            n = getNumber("NM");
            stateInfo[n] = new StateInfo(n, 122);
            stateInfo[n].addBorder(getNumber("CO"));
            stateInfo[n].addBorder(getNumber("OK"));
            stateInfo[n].addBorder(getNumber("TX"));
            stateInfo[n].addBorder(getNumber("AZ"));
            n = getNumber("AZ");
            stateInfo[n] = new StateInfo(n, 114);
            stateInfo[n].addBorder(getNumber("UT"));
            stateInfo[n].addBorder(getNumber("NM"));
            stateInfo[n].addBorder(getNumber("CA"));
            stateInfo[n].addBorder(getNumber("NV"));
            n = getNumber("NV");
            stateInfo[n] = new StateInfo(n, 110);
            stateInfo[n].addBorder(getNumber("OR"));
            stateInfo[n].addBorder(getNumber("ID"));
            stateInfo[n].addBorder(getNumber("UT"));
            stateInfo[n].addBorder(getNumber("AZ"));
            stateInfo[n].addBorder(getNumber("CA"));
            n = getNumber("CO");
            stateInfo[n] = new StateInfo(n, 104);
            stateInfo[n].addBorder(getNumber("WY"));
            stateInfo[n].addBorder(getNumber("NE"));
            stateInfo[n].addBorder(getNumber("KS"));
            stateInfo[n].addBorder(getNumber("OK"));
            stateInfo[n].addBorder(getNumber("NM"));
            stateInfo[n].addBorder(getNumber("UT"));
            n = getNumber("WY");
            stateInfo[n] = new StateInfo(n, 98);
            stateInfo[n].addBorder(getNumber("MT"));
            stateInfo[n].addBorder(getNumber("SD"));
            stateInfo[n].addBorder(getNumber("NE"));
            stateInfo[n].addBorder(getNumber("CO"));
            stateInfo[n].addBorder(getNumber("UT"));
            stateInfo[n].addBorder(getNumber("ID"));
            n = getNumber("OR");
            stateInfo[n] = new StateInfo(n, 97);
            stateInfo[n].addBorder(getNumber("WA"));
            stateInfo[n].addBorder(getNumber("ID"));
            stateInfo[n].addBorder(getNumber("NV"));
            stateInfo[n].addBorder(getNumber("CA"));
            n = getNumber("UT");
            stateInfo[n] = new StateInfo(n, 85);
            stateInfo[n].addBorder(getNumber("ID"));
            stateInfo[n].addBorder(getNumber("WY"));
            stateInfo[n].addBorder(getNumber("CO"));
            stateInfo[n].addBorder(getNumber("AZ"));
            stateInfo[n].addBorder(getNumber("NV"));
            n = getNumber("MN");
            stateInfo[n] = new StateInfo(n, 84);
            stateInfo[n].addBorder(getNumber("WI"));
            stateInfo[n].addBorder(getNumber("IA"));
            stateInfo[n].addBorder(getNumber("SD"));
            stateInfo[n].addBorder(getNumber("ND"));
            n = getNumber("ID");
            stateInfo[n] = new StateInfo(n, 84);
            stateInfo[n].addBorder(getNumber("MT"));
            stateInfo[n].addBorder(getNumber("WY"));
            stateInfo[n].addBorder(getNumber("UT"));
            stateInfo[n].addBorder(getNumber("NV"));
            stateInfo[n].addBorder(getNumber("OR"));
            stateInfo[n].addBorder(getNumber("WA"));
            n = getNumber("KS");
            stateInfo[n] = new StateInfo(n, 82);
            stateInfo[n].addBorder(getNumber("NE"));
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("OK"));
            stateInfo[n].addBorder(getNumber("CO"));
            n = getNumber("SD");
            stateInfo[n] = new StateInfo(n, 77);
            stateInfo[n].addBorder(getNumber("ND"));
            stateInfo[n].addBorder(getNumber("MN"));
            stateInfo[n].addBorder(getNumber("IA"));
            stateInfo[n].addBorder(getNumber("NE"));
            stateInfo[n].addBorder(getNumber("WY"));
            stateInfo[n].addBorder(getNumber("MT"));
            n = getNumber("NE");
            stateInfo[n] = new StateInfo(n, 77);
            stateInfo[n].addBorder(getNumber("SD"));
            stateInfo[n].addBorder(getNumber("IA"));
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("KS"));
            stateInfo[n].addBorder(getNumber("CO"));
            stateInfo[n].addBorder(getNumber("WY"));
            n = getNumber("ND");
            stateInfo[n] = new StateInfo(n, 71);
            stateInfo[n].addBorder(getNumber("MN"));
            stateInfo[n].addBorder(getNumber("SD"));
            stateInfo[n].addBorder(getNumber("MT"));
            n = getNumber("OK");
            stateInfo[n] = new StateInfo(n, 70);
            stateInfo[n].addBorder(getNumber("CO"));
            stateInfo[n].addBorder(getNumber("KS"));
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("AR"));
            stateInfo[n].addBorder(getNumber("TX"));
            stateInfo[n].addBorder(getNumber("NM"));
            n = getNumber("MO");
            stateInfo[n] = new StateInfo(n, 70);
            stateInfo[n].addBorder(getNumber("IA"));
            stateInfo[n].addBorder(getNumber("IL"));
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("AR"));
            stateInfo[n].addBorder(getNumber("OK"));
            stateInfo[n].addBorder(getNumber("KS"));
            stateInfo[n].addBorder(getNumber("NE"));
            n = getNumber("WA");
            stateInfo[n] = new StateInfo(n, 68);
            stateInfo[n].addBorder(getNumber("ID"));
            stateInfo[n].addBorder(getNumber("OR"));
            n = getNumber("FL");
            stateInfo[n] = new StateInfo(n, 59);
            stateInfo[n].addBorder(getNumber("GA"));
            stateInfo[n].addBorder(getNumber("AL"));
            n = getNumber("GA");
            stateInfo[n] = new StateInfo(n, 59);
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("NC"));
            stateInfo[n].addBorder(getNumber("SC"));
            stateInfo[n].addBorder(getNumber("FL"));
            stateInfo[n].addBorder(getNumber("AL"));
            n = getNumber("MI");
            stateInfo[n] = new StateInfo(n, 58);
            stateInfo[n].addBorder(getNumber("OH"));
            stateInfo[n].addBorder(getNumber("IN"));
            stateInfo[n].addBorder(getNumber("WI"));
            n = getNumber("IA");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(getNumber("MN"));
            stateInfo[n].addBorder(getNumber("WI"));
            stateInfo[n].addBorder(getNumber("IL"));
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("NE"));
            stateInfo[n].addBorder(getNumber("SD"));
            n = getNumber("IL");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(getNumber("WI"));
            stateInfo[n].addBorder(getNumber("IN"));
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("IA"));
            n = getNumber("WI");
            stateInfo[n] = new StateInfo(n, 56);
            stateInfo[n].addBorder(getNumber("MN"));
            stateInfo[n].addBorder(getNumber("MI"));
            stateInfo[n].addBorder(getNumber("IL"));
            stateInfo[n].addBorder(getNumber("IA"));
            n = getNumber("AR");
            stateInfo[n] = new StateInfo(n, 53);
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("MS"));
            stateInfo[n].addBorder(getNumber("LA"));
            stateInfo[n].addBorder(getNumber("TX"));
            stateInfo[n].addBorder(getNumber("OK"));
            n = getNumber("NC");
            stateInfo[n] = new StateInfo(n, 53);
            stateInfo[n].addBorder(getNumber("VA"));
            stateInfo[n].addBorder(getNumber("SC"));
            stateInfo[n].addBorder(getNumber("GA"));
            stateInfo[n].addBorder(getNumber("TN"));
            n = getNumber("AL");
            stateInfo[n] = new StateInfo(n, 52);
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("GA"));
            stateInfo[n].addBorder(getNumber("FL"));
            stateInfo[n].addBorder(getNumber("MS"));
            n = getNumber("NY");
            stateInfo[n] = new StateInfo(n, 50);
            stateInfo[n].addBorder(getNumber("VT"));
            stateInfo[n].addBorder(getNumber("MA"));
            stateInfo[n].addBorder(getNumber("CT"));
            stateInfo[n].addBorder(getNumber("NJ"));
            stateInfo[n].addBorder(getNumber("PA"));
            n = getNumber("LA");
            stateInfo[n] = new StateInfo(n, 49);
            stateInfo[n].addBorder(getNumber("AR"));
            stateInfo[n].addBorder(getNumber("MS"));
            stateInfo[n].addBorder(getNumber("TX"));
            n = getNumber("MS");
            stateInfo[n] = new StateInfo(n, 48);
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("AL"));
            stateInfo[n].addBorder(getNumber("LA"));
            stateInfo[n].addBorder(getNumber("AR"));
            n = getNumber("PA");
            stateInfo[n] = new StateInfo(n, 45);
            stateInfo[n].addBorder(getNumber("NY"));
            stateInfo[n].addBorder(getNumber("NJ"));
            stateInfo[n].addBorder(getNumber("DE"));
            stateInfo[n].addBorder(getNumber("MD"));
            stateInfo[n].addBorder(getNumber("WV"));
            stateInfo[n].addBorder(getNumber("OH"));
            n = getNumber("TN");
            stateInfo[n] = new StateInfo(n, 42);
            stateInfo[n].addBorder(getNumber("MO"));
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("VA"));
            stateInfo[n].addBorder(getNumber("NC"));
            stateInfo[n].addBorder(getNumber("GA"));
            stateInfo[n].addBorder(getNumber("AL"));
            stateInfo[n].addBorder(getNumber("MS"));
            stateInfo[n].addBorder(getNumber("AR"));
            n = getNumber("VA");
            stateInfo[n] = new StateInfo(n, 41);
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("WV"));
            stateInfo[n].addBorder(getNumber("MD"));
            stateInfo[n].addBorder(getNumber("NC"));
            stateInfo[n].addBorder(getNumber("TN"));
            n = getNumber("OH");
            stateInfo[n] = new StateInfo(n, 41);
            stateInfo[n].addBorder(getNumber("MI"));
            stateInfo[n].addBorder(getNumber("PA"));
            stateInfo[n].addBorder(getNumber("WV"));
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("IN"));
            n = getNumber("KY");
            stateInfo[n] = new StateInfo(n, 40);
            stateInfo[n].addBorder(getNumber("IL"));
            stateInfo[n].addBorder(getNumber("IN"));
            stateInfo[n].addBorder(getNumber("OH"));
            stateInfo[n].addBorder(getNumber("WV"));
            stateInfo[n].addBorder(getNumber("VA"));
            stateInfo[n].addBorder(getNumber("TN"));
            stateInfo[n].addBorder(getNumber("MO"));
            n = getNumber("IN");
            stateInfo[n] = new StateInfo(n, 36);
            stateInfo[n].addBorder(getNumber("MI"));
            stateInfo[n].addBorder(getNumber("OH"));
            stateInfo[n].addBorder(getNumber("KY"));
            stateInfo[n].addBorder(getNumber("IL"));
            n = getNumber("ME");
            stateInfo[n] = new StateInfo(n, 33);
            stateInfo[n].addBorder(getNumber("NH"));
            n = getNumber("SC");
            stateInfo[n] = new StateInfo(n, 31);
            stateInfo[n].addBorder(getNumber("NC"));
            stateInfo[n].addBorder(getNumber("GA"));
            n = getNumber("WV");
            stateInfo[n] = new StateInfo(n, 24);
            stateInfo[n].addBorder(getNumber("OH"));
            stateInfo[n].addBorder(getNumber("PA"));
            stateInfo[n].addBorder(getNumber("MD"));
            stateInfo[n].addBorder(getNumber("VA"));
            stateInfo[n].addBorder(getNumber("KY"));
            n = getNumber("MD");
            stateInfo[n] = new StateInfo(n, 11);
            stateInfo[n].addBorder(getNumber("PA"));
            stateInfo[n].addBorder(getNumber("DE"));
            stateInfo[n].addBorder(getNumber("VA"));
            stateInfo[n].addBorder(getNumber("WV"));
            n = getNumber("VT");
            stateInfo[n] = new StateInfo(n, 10);
            stateInfo[n].addBorder(getNumber("NH"));
            stateInfo[n].addBorder(getNumber("MA"));
            stateInfo[n].addBorder(getNumber("NY"));
            n = getNumber("NH");
            stateInfo[n] = new StateInfo(n, 9);
            stateInfo[n].addBorder(getNumber("ME"));
            stateInfo[n].addBorder(getNumber("MA"));
            stateInfo[n].addBorder(getNumber("VT"));
            n = getNumber("NJ");
            stateInfo[n] = new StateInfo(n, 8);
            stateInfo[n].addBorder(getNumber("NY"));
            stateInfo[n].addBorder(getNumber("DE"));
            stateInfo[n].addBorder(getNumber("PA"));
            n = getNumber("MA");
            stateInfo[n] = new StateInfo(n, 8);
            stateInfo[n].addBorder(getNumber("VT"));
            stateInfo[n].addBorder(getNumber("NH"));
            stateInfo[n].addBorder(getNumber("RI"));
            stateInfo[n].addBorder(getNumber("CT"));
            stateInfo[n].addBorder(getNumber("NY"));
            n = getNumber("CT");
            stateInfo[n] = new StateInfo(n, 5);
            stateInfo[n].addBorder(getNumber("MA"));
            stateInfo[n].addBorder(getNumber("RI"));
            stateInfo[n].addBorder(getNumber("NY"));
            n = getNumber("DE");
            stateInfo[n] = new StateInfo(n, 2);
            stateInfo[n].addBorder(getNumber("PA"));
            stateInfo[n].addBorder(getNumber("NJ"));
            stateInfo[n].addBorder(getNumber("MD"));
            n = getNumber("RI");
            stateInfo[n] = new StateInfo(n, 1);
            stateInfo[n].addBorder(getNumber("MA"));
            stateInfo[n].addBorder(getNumber("CT"));
        } catch (StateNameError e) {
            Logger.getLogger(StatePuzzle.class.getName()).log(Level.SEVERE, null, e);
        }

        return stateInfo;
    }

}