package de.mattes.uol.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import com.atlassian.templaterenderer.TemplateRenderer;


@WebServlet("/automation")
@MultipartConfig
public class AutomationServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AutomationServlet.class);

    private final TemplateRenderer templateRenderer;

    public AutomationServlet(TemplateRenderer templateRenderer) {
        this.templateRenderer = templateRenderer;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        templateRenderer.render("index.vm", resp.getWriter());
    }
}