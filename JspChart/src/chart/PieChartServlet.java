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
import org.jfree.data.general.DefaultPieDataset;

//@WebServlet("/PieChartServlet")
public class PieChartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		
		//데이터를 생성함
		DefaultPieDataset dataset = new DefaultPieDataset();
		//데이터 셋 객체를 생성
		//setValue()메소드를 활용해서 데이터를 설정
		
		dataset.setValue("aaa",63.2);
		dataset.setValue("bbb",37.9);
		dataset.setValue("ccc",12.6);
		
		//차트 생성
		JFreeChart chart = ChartFactory.createPieChart("title", dataset, true, true, false);
		//제목, 데이터셋, 범례, 툴팁사용여부 , url 설정여부
		
		//차트를 보여줌
		ServletOutputStream out = response.getOutputStream();
		ChartUtilities.writeChartAsJPEG(out, chart, 400, 400); //가로 , 세로 사이즈 400
		
		
	}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
	}
			
}
