//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class StateNames {
    private static final String[] STATE_NAMES = new String[]{"TX", "CA", "MT", "CO", "VT", "AL", "DE", "ME", "IL", "AR", "IA", "CT", "IN", "GA", "KY", "LA", "MD", "MA", "MS", "NH", "NJ", "NM", "NY", "NC", "OH", "PA", "RI", "SC", "TN", "VA", "WV", "WI", "FL", "MO", "OK", "ND", "WA", "SD", "NE", "KS", "ID", "UT", "MN", "MI", "WY", "OR", "NV", "AZ"};

    public StateNames() {
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
}