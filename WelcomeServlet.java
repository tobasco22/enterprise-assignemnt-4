package cnt.pkg4714.servlet.examples;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class WelcomeServlet extends HttpServlet{
    @Override

protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        
        out.println("<html>");
        out.println( "<meta charset=\"utf=8\">");
        out.println( "<head>");
        out.println("<style type ='text/css'>");
        out.println( "<!-- body{background-color:blue; color:white; font-familiy: Verdana, Arial, sans-serif; text-alighn:center}");
        out.println( " h1{font-size: 100pt; text-align:center;} h2{font-size:60pt;} ");
        out.println( " #one{color:magenta;} #two{color:yellow;} #three{color:red;} #four{color:lime;} #five{color:cyan;}");
        out.println( "-->");
        out.println( "</style>");
        out.println( "<title>Welcome to Servlets!</title>");
        out.println( "</head>");
        
        out.println( "<body>" );
        out.println( "<h1><span id=\"one\">H</span><span id=\"two\">e</span><span id=\"three\">1</span>"
        + "<span id=\"four\">1</span><span id=\"five\">o</span>!!</h1>");
        out.println( "<h2>Welcome To The Exciting World Of Servlet Technology!</h2>");
        out.println( "</body>");
        
        out.println("</html>");
        out.close();
}
}
