
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 * Contains UserInfo managing server operations. Created by Mehmet Burak
 * Kurutmaz on 04.11.2015.
 */
public class UserInfoServlet extends HttpServlet {

    /**
     * Responds client by sending its user information.
     *
     * @author Mehmet Burak Kurutmaz.
     * @param request Request object that is sent by client
     * @param response Response object that will be sent to client
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            JSONObject json = new JSONObject();
            json.put("email", session.getAttribute("email"));
            json.put("name", session.getAttribute("name"));
            json.put("surname", session.getAttribute("surname"));
            out.write(json.toString());
        }
    }

}
