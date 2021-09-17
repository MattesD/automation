package de.mattes.uol.servlet;

import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Iterator;


import com.atlassian.templaterenderer.TemplateRenderer;


@WebServlet("/automation")
@MultipartConfig
public class AutomationServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(AutomationServlet.class);

    private final TemplateRenderer templateRenderer;
    private CSVReader csvReader;

    public AutomationServlet(TemplateRenderer templateRenderer, CSVReader csvReader) {
        this.templateRenderer = templateRenderer;
        this.csvReader = csvReader;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        templateRenderer.render("index.vm", resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        InputStream fileContent = part.getInputStream();

        Reader in = new InputStreamReader(fileContent);

        Iterator<String[]> iterator;

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        try {
            csvReader = new CSVReader(new InputStreamReader(fileContent));
            iterator = csvReader.iterator();

            String[] row = iterator.next();

            for (int i = 0; i < row.length; i++) {
                writer.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        in.close();
    }
}