import java.io.File;
public class HiLoScore {
    private int high;
    private int low;

    public HiLoScore() {
        high = Integer.MIN_VALUE;
        low = Integer.MAX_VALUE;

        String pathName = System.getProperty("user.home") + "/solutions/";
        File directory = new File(pathName);
        File[] listOfFiles = directory.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            try {
                String fileName = listOfFiles[i].getName();
                String[] splits = fileName.split("\\.");
                int number = Integer.parseInt(splits[0]);
                setIsWithin(number);
            } catch (NumberFormatException e) {}
        }
    }

    HiLoScore(int lo, int hi) {
        low = lo;
        high = hi;
    }

    public boolean isWithin(int value) {
        return (value >= low && value <= high);
    }

    public boolean setIsWithin(int value) {
        boolean within = true;
        if (value > high) {
            high = value;
            within = false;
        }
        if (value < low) {
            low = value;
            within = false;
        }
        return within;
    }

}
