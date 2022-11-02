import java.sql.*;
import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.*;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class chart {
	public static void main(String[] args) throws Exception {

	       String query = "SELECT * from Dataser";
	       JDBCCategoryDataset dataset = new JDBCCategoryDataset(
		"jdbc:mysql://localhost:3306/test", 
                "com.mysql.jdbc.Driver","root", "root");
	       dataset.executeQuery(query);
	       JFreeChart chart =  
                ChartFactory.createBarChart3D("Test", "Id", "Score",
	        dataset, PlotOrientation.VERTICAL, true, true, false);
	       try {
	       ChartUtilities.saveChartAsJPEG(new File("C:/chart.jpg"),
                chart,400, 300);
	       } catch (IOException e) {
	       System.out.println("Problem in creating chart.");
  }
	}
}
