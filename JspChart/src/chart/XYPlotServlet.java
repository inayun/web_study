package chart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


//@WebServlet("/XYPlotServlet")

public class XYPlotServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1522:orcl";
	private static final String DB_ID = "scott";
	private static final String DB_PASS = "tiger";
	
	public void init() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("디비연결성공");
		} catch(Exception e){
			e.printStackTrace();
		}
	}//end init
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			Connection con = DriverManager.getConnection(DB_URL,DB_ID,DB_PASS);
			Statement st = con.createStatement();
			
			String sql = "select value from stock";
			ResultSet rs = st.executeQuery(sql);
			XYSeries vs = new XYSeries("Stock Flow");
			int x = 1; //값을 증가시키기 위한 변수
			
			while(rs.next()) {
				vs.add(x, rs.getInt(1));
				x += 1;
				
			}
			//데이터 셋팅 완료
			XYSeriesCollection ds = new XYSeriesCollection(vs);
			JFreeChart chart = ChartFactory.createXYLineChart(
					"stock chart","day","price",ds,PlotOrientation.VERTICAL,true,true,true);
			
			//차트를 보여줌
			ServletOutputStream out = response.getOutputStream();
			ChartUtilities.writeChartAsPNG(out, chart, 400, 400);
			
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
