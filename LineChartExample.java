import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  


public class LineChartExample extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public LineChartExample(String title) {  
    super(title);  
    // Create dataset  
    DefaultCategoryDataset dataset = createDataset();  
    // Create chart  
    JFreeChart chart = ChartFactory.createLineChart(  
        "Smart Mobility vs Smart Economy", // Chart title  
        "Country", // X-Axis Label  
        "Indexes", // Y-Axis Label  
        dataset  
        );  
  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private DefaultCategoryDataset createDataset() {  
  
    String series1 = "Smart_Economy ";  
    String series2 = "Smart_Mobility ";  
  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
    dataset.addValue(4565,series1, "Norway");
    dataset.addValue(4905,series1,"Norway");
    dataset.addValue(8095,series1,"Netherlands");
    dataset.addValue(5580,series1,"Denmark");
    dataset.addValue(4330,series1, "Sweden");
    dataset.addValue(6810,series1, "Canada");
    dataset.addValue(5415,series1, "Austria");  
    dataset.addValue(5200,series1, "Denmark");
    dataset.addValue(5535,series1, "Singapore");
    dataset.addValue(8935,series1, "USA");
  
    // Smart mobility 
    dataset.addValue(6480,series2, "Norway");
    dataset.addValue(7097,series2, "Norway");
    dataset.addValue(7540,series2, "Netherlands");
    dataset.addValue(7490,series2, "Denmark");
    dataset.addValue(6122,series2, "Sweden");
    dataset.addValue(7490,series2, "Canada");
    dataset.addValue(5683,series2, "Austria");  
    dataset.addValue(6160,series2, "Denmark");
    dataset.addValue(5790,series2, "Singapore");
    dataset.addValue(7870,series2, "USA"); 
  
    return dataset;  
  }  
  
  public static void main(String[] args) {  
    SwingUtilities.invokeLater(() -> {  
      LineChartExample example = new LineChartExample("Line Chart Example");  
      example.setAlwaysOnTop(true);  
      example.pack();  
      example.setSize(600, 400);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  