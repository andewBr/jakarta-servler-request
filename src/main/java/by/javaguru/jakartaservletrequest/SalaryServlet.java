package by.javaguru.jakartaservletrequest;

import by.javaguru.jakartaservletrequest.model.Employee;
import by.javaguru.jakartaservletrequest.model.Root;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("")
public class SalaryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("userInfo.json")) {
            ObjectMapper mapper = new ObjectMapper();
            Root root = mapper.readValue(resourceAsStream, Root.class);

            int totalIncome = 0;
            int totalTax = 0;
            int totalProfit;

            ArrayList<Employee> employees = root.getEmployees();
            for (Employee employeeNode : employees) {
                int salary = employeeNode.getSalary();
                int tax = employeeNode.getTax();
                totalIncome += salary;
                totalTax += tax;
            }
            totalProfit = totalIncome - totalTax;

            String htmlResponse = "<!DOCTYPE html><html lang=\"en\"><head><title>Salary</title></head>" +
                    "<body>" + "<table>" +
                    "<tr>" +
                    "<th>Total income</th>" +
                    "<th>Total tax</th>" +
                    "<th>Total profit</th>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" + totalIncome + "</td>" +
                    "<td>" + totalTax + "</td>" +
                    "<td>" + totalProfit + "</td></tr>" +
                    "</table></body></html>";

            response.setContentType("text/html");
            response.getWriter().write(htmlResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
