package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null ||
                session.getAttribute("username") == null) {

            resp.sendRedirect(req.getContextPath() + "/login.html");
            return;
        }

        String username =
                (String) session.getAttribute("username");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Home</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Welcome " + username + "</h1>");
        out.println("<h2>Home Page</h2>");

        out.println("<a href='" +
                req.getContextPath() +
                "/logout'>Logout</a>");

        out.println("</body>");
        out.println("</html>");
    }
}