import javax.servlet.*;
import java.io.IOException;

public class FilterForPages implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter("login");
        System.out.println("FILTER");
        if(login != null) {
            chain.doFilter(request, response);
        }

        throw new RuntimeException("put login");
    }

    @Override
    public void destroy() {

    }
}
