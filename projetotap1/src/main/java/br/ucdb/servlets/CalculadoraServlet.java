package br.ucdb.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucdb.util.Calculadora;

@WebServlet(urlPatterns = "/calcServlet")
public class CalculadoraServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String op = req.getParameter("op");

		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		int operacao = Integer.parseInt(op);

		Calculadora calc = new Calculadora();
		int res = calc.calcular(num1, num2, operacao);

		req.setAttribute("res", res);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("resultado_calc.jsp");
		dispatcher.forward(req, resp);


	}
}
