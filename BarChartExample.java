import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;
  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
  
public class BarChartExample extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public BarChartExample(String appTitle) {  
    super(appTitle);  
  
    // Create Dataset  
    CategoryDataset dataset = createDataset();  
      
    //Create chart  
    JFreeChart chart=ChartFactory.createBarChart(  
        "Bar Chart Example", //Chart Title  
        "Year", // Category axis  
        "Population in Million", // Value axis  
        dataset,  
        PlotOrientation.VERTICAL,  
        true,true,false  
       );  
  
    ChartPanel panel=new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private CategoryDataset createDataset() {  
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
  
    // Smart Economy  
    dataset.addValue(4565, "Norway", "Smart_Economy");
    dataset.addValue(4905, "Norway", "Smart_Economy");
    dataset.addValue(8095, "Netherlands", "Smart_Economy");
    dataset.addValue(5580, "Denmark", "Smart_Economy");
    dataset.addValue(4330, "Sweden", "Smart_Economy");
    dataset.addValue(6810, "Canada", "Smart_Economy");
    dataset.addValue(5415, "Austria", "Smart_Economy");  
    dataset.addValue(5200, "Denmark", "Smart_Economy");
    dataset.addValue(5535, "Singapore", "Smart_Economy");
    dataset.addValue(8935, "USA", "Smart_Economy");
  
    // Smart mobility 
    dataset.addValue(6480, "Norway", "Smart_Mobility ");
    dataset.addValue(7097, "Norway", "Smart_Mobility ");
    dataset.addValue(7540, "Netherlands", "Smart_Mobility ");
    dataset.addValue(7490, "Denmark", "Smart_Mobility ");
    dataset.addValue(6122, "Sweden", "Smart_Mobility ");
    dataset.addValue(7490, "Canada", "Smart_Mobility ");
    dataset.addValue(5683, "Austria", "Smart_Mobility ");  
    dataset.addValue(6160, "Denmark", "Smart_Mobility ");
    dataset.addValue(5790, "Singapore", "Smart_Mobility ");
    dataset.addValue(7870, "USA", "Smart_Mobility ");
    
    //Smart Index
    dataset.addValue(7138, "Norway", "SmartCity_Index");
    dataset.addValue(7296, "Norway", "SmartCity_Index");
    dataset.addValue(7311, "Netherlands", "SmartCity_Index");
    dataset.addValue(7171, "Denmark", "SmartCity_Index");
    dataset.addValue(6812, "Sweden", "SmartCity_Index");
    dataset.addValue(7353, "Canada", "SmartCity_Index");
    dataset.addValue(6771, "Austria", "SmartCity_Index");  
    dataset.addValue(6886, "Denmark", "SmartCity_Index");
    dataset.addValue(6813, "Singapore", "SmartCity_Index");
    dataset.addValue(6852, "USA", "SmartCity_Index");
  
    return dataset;  
  }  
  
  public static void main(String[] args) throws Exception {  
    SwingUtilities.invokeAndWait(()->{  
      BarChartExample example=new BarChartExample("Bar Chart Window");  
      example.setSize(800, 400);  
      example.setLocationRelativeTo(null);  
      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      example.setVisible(true);  
    });  
  }  
}  