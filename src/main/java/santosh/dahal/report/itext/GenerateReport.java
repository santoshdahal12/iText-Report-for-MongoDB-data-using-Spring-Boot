package santosh.dahal.report.itext;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import java.util.List;

@Component
public class GenerateReport {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public void createPdf() {
		

		Document document = new Document();
		
		try {
			FileOutputStream fileOutputStream= new FileOutputStream("D:\\salaryreport.pdf");
			PdfWriter writer=PdfWriter.getInstance(document, fileOutputStream);
			document.open();
			PdfPTable table = new PdfPTable(4); // 3 columns.
				List<Employee> empList = employeeRepository.findAll();
				for (Employee employee : empList) {
				PdfPCell cell1 = new PdfPCell(new Paragraph(employee.getName()));
				table.addCell(cell1);

			}

			for (Employee employee : empList) {
				PdfPCell cell2 = new PdfPCell(new Paragraph("" + employee.getSalary()));
				table.addCell(cell2);

			}

			document.add(table);
			PieDataset pdSet=createDataSet(empList);
			
			JFreeChart chart= createChart(pdSet,"Salary Pie-Chart");
			try{
				ChartUtilities.writeChartAsPNG(fileOutputStream, chart, 70,20);// check here for writing pie chart in the same document
				fileOutputStream.close();
			}
			 catch (Exception e) {
				// TODO: handle exception
			}
			document.close();
			
		} catch (Exception e) {

		}
	}
	private JFreeChart createChart(PieDataset pdSet, String chartTitle) {
		// TODO Auto-generated method stub
		JFreeChart chart= ChartFactory.
				createPieChart3D(chartTitle, pdSet, true, true, false);
		PiePlot3D plot=(PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		
		return chart;
	}
	private PieDataset createDataSet(List<Employee> empList) {
		DefaultPieDataset dpd= new DefaultPieDataset();
		for(Employee employee:empList){
		dpd.setValue(employee.getName(), employee.getSalary());
		}// TODO Auto-generated method stub
		return dpd;
	}

	
}

