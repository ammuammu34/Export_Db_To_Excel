package com.ashokit;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentReportService {
	@Autowired
	private StudentRepository service;

	public void GenerateExcelReport(HttpServletResponse response) throws Exception {
		List<Student> courses = service.findAll();
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("course-Info");
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("studentId");
		row.createCell(0).setCellValue("studentName");
		row.createCell(0).setCellValue("CourseName");
		int dataRowIndex = 1;
		for (Student course : courses) {
			HSSFRow data = sheet.createRow(dataRowIndex);
			data.createCell(0).setCellValue(course.getStudentId());
			data.createCell(1).setCellValue(course.getStudentName());
			data.createCell(2).setCellValue(course.getCourseName());
			dataRowIndex++;
		}
		ServletOutputStream output = response.getOutputStream();
		workbook.write(output);
		workbook.close();
		output.close();

	}

}
