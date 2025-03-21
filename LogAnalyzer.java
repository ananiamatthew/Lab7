/**
 * Read web server data and analyse hourly access patterns.
 * 
 * Questions:
 * 
 * 1) Busiest time is 6pm
 * 
 * 2) private Person[] people;
 * 
 * 3) private boolean[] vacant;
 * 
 * 4) Used in analyzeHourlyData() and printHourlyCounts()
 * 
 * 5) int[] counts;
 *    occupied = new boolean[5000];
 * 
 * 6) readings = new double[60];
 *    urls = new String[90];
 *    machine = new TicketMachine[5];
 * 
 * 7) 21 String objects
 * 
 * 8) Parentheses should be brackets instead
 *    double[] prices = new double[50];
 * 
 * 9) It causes an out-of-bounds error
 * 
 * 11) public void printGreater(double marks, double mean) {
           for(index = 0; index < marks.length; index++) {
               if(marks[index] > mean) {
               System.out.println(marks[index]);
               }
           }
       }
 * 
 * 13) public int numberOfAccesses() {
           int total = 0;
           for (int i = 0; i < hourCounts.length; i++) {
               total = total + hourCounts[i];
           }
           return total;
       } 
 * 
 * 15 DOES NOT WORK???
 * 
 * 
 * 
 * 
 * 
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }
    
    /**
     * Create an object to analyze hourly web accesses from a file.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    public int numberOfAccesses() {
        int total = 0;
        for (int i = 0; i < hourCounts.length; i++) {
            total = total + hourCounts[i];
        }
        return total;
       }
    
    public int busiestHour() {
        int hourval = hourCounts[0];
        int hour = 0;
        for (int i = 0; i < hourCounts.length; i++) {
            if (hourval > hourCounts[i]) {
                hourval = hourCounts[i];
                hour = i;
            }
        }
        return hour;
    }
}
