package de.mattes.uol.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.atlassian.templaterenderer.TemplateRenderer;
//import com.opencsv.CSVReader;

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

/*    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        InputStream fileContent = part.getInputStream();

        Reader in = new InputStreamReader(fileContent);

        CSVReader csvReader;
        Iterator<String[]> iterator;

        try {
            csvReader = new CSVReader(new InputStreamReader(fileContent));
            iterator = csvReader.iterator();

            String[] row = iterator.next();

            for (int i = 0; i < row.length; i++) {
                System.out.println(row[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        in.close();
    }*/
}