import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServFirstPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        boolean isLoginSet = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("login")) {
                    isLoginSet = true;
                    login = cookie.getValue();
                    break;
                }
            }
        }
        if (isLoginSet) {
            Cookie loginCookie = new Cookie("login", login);
            resp.addCookie(loginCookie);
        }

        req.getRequestDispatcher("/second").forward(req, resp);
    }

}
