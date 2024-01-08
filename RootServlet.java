@WebServlet("/root")
public class RootServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sqlCommand = request.getParameter("sqlCommand");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project4", "root", "pass");
             Statement statement = connection.createStatement()) {

            if (sqlCommand.trim().toUpperCase().startsWith("SELECT")) {
                ResultSet resultSet = statement.executeQuery(sqlCommand);
                // Process the ResultSet and set results as request attribute
                request.setAttribute("resultSet", resultSet);
            } else {
                int rowsAffected = statement.executeUpdate(sqlCommand);
                // Set rows affected as request attribute
                request.setAttribute("rowsAffected", rowsAffected);
            }

            // Forward to a JSP for rendering results
            RequestDispatcher dispatcher = request.getRequestDispatcher("/root.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("error", e.getMessage());
            // Forward to a JSP for rendering error
            RequestDispatcher dispatcher = request.getRequestDispatcher("/root.jsp");
            dispatcher.forward(request, response);
        }
    }
}
