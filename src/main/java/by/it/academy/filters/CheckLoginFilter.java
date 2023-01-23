package by.it.academy.filters;

import org.apache.log4j.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@WebFilter
public class CheckLoginFilter extends HttpFilter {
    private Logger log;

    List<String> logins = new ArrayList<>();

    @Override
    public void init() {
       String message = String.valueOf(Logger.getLogger(RequestLoggingFilter.class));
    }

    //    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        Map<String, ArrayList<String>> headers = getHeaders(req);
//        log.info(req.getRequestURL() + ":" + headers);
//        chain.doFilter(req, res);
//    }

    private boolean checkLogin(HttpServletRequest req) {
        String str = req.getParameter("login");
        boolean flag = true;
        if (logins.contains(str)) {
            flag = false;
        } else {
            logins.add(str);
        }
        return flag;
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
//    private Map<String, ArrayList<String>> getHeaders(HttpServletRequest req) {
//        return Collections.list(req.getHeaderNames()).stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        h -> Collections.list(req.getHeaders(h))
//                ));
//    }
}