package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.workshop.utils.GzipUtility;

@WebServlet("/large-page")
public class LargeServletPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out;

		if (GzipUtility.isGzipSupported(request) && !GzipUtility.isGzipDisabled(request)) {
			out = GzipUtility.getGzipWriter(response);
			response.setHeader("Content-Encoding", "gzip");
		} else {
			out = response.getWriter();
		}
		
		
		String dummyLine = "Attracting new customers and generating leads are critical steps"
				+ " in the success of your marketing funnel. Without these initial accomplishments,"
				+ " you won’t have any leads to nurture or convert to sales. It all starts with"
				+ " top of funnel marketing tactics, which help you establish trust and thought "
				+ "leadership with potential customers.";

		String line = dummyLine + dummyLine;

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> showing all request headers </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1> All Request Headers </h1>");

		for (int i = 0; i < 10000; i++) {
			out.println(line + "<br/>");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
