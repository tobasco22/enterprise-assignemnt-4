package cnt.pkg4714.servlet.examples;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check authentication
        if (authenticate(username, password)) {
            // Authentication successful, redirect to appropriate page
            if ("root".equals(username)) {
                response.sendRedirect("welcome1");
                return;
            } else if ("client".equals(username)) {
                response.sendRedirect("client.jsp");
                return;
            } else if ("dataentryuser".equals(username)) {
                response.sendRedirect("dataentry.jsp");
                return;
            } else if ("accountant".equals(username)) {
                response.sendRedirect("accountant.jsp");
                return;
            } else {
                // Unknown user
                response.getWriter().println("Unknown user");
                return;
            }
        } else {
            // Authentication failed, redirect back to login page
            response.sendRedirect("error.jsp");
            return;
        }
    }

    private boolean authenticate(String username, String password) {
        
        return "root".equals(username) && "pass1".equals(password)
                || "client".equals(username) && "client".equals(password)
                || "dataentryuser".equals(username) && "dataentryuser".equals(password)
                || "accountant".equals(username) && "accountant".equals(password);
    }
}
