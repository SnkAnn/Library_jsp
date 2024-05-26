package by.fpmibsu.LIBRARY.Servlet;
import by.fpmibsu.LIBRARY.Pool.ConnectionPool;
import by.fpmibsu.LIBRARY.exception.PersistentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.*;
import java.io.IOException;

public class Connection_Filter implements Filter {

    private static Logger logger= LogManager.getLogger(LoginServlet.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
          final String DB_DRIVER_CLASS = "org.postgresql.Driver";
          final String DB_URL = "jdbc:postgresql://localhost:5432/LIBRARY";
          final String DB_USER = "postgres";
          final String DB_PASSWORD = "mina1a2a3a";
          final int DB_POOL_START_SIZE = 10;
          final int DB_POOL_MAX_SIZE = 1000;
          final int DB_POOL_CHECK_CONNECTION_TIMEOUT = 0;

            try {
                ConnectionPool.getInstance().init(DB_DRIVER_CLASS, DB_URL, DB_USER, DB_PASSWORD, DB_POOL_START_SIZE, DB_POOL_MAX_SIZE, DB_POOL_CHECK_CONNECTION_TIMEOUT);
            } catch(PersistentException e) {
                logger.error("It is impossible to initialize application", e);
            }
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() { 
    }
}
