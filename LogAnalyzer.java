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
 * 9) 
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
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}
