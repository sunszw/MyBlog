package com.study.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThyUtils {
    private static TemplateEngine templateEngine;

    static {
        templateEngine = new TemplateEngine();
        ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver();
        classLoaderTemplateResolver.setCharacterEncoding("utf-8");
        classLoaderTemplateResolver.setPrefix("../");
        classLoaderTemplateResolver.setSuffix(".html");
        templateEngine.setTemplateResolver(classLoaderTemplateResolver);
    }

    public static void print(String path, HttpServletResponse response, Context context) throws IOException {
        String html = templateEngine.process(path, context);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.println(html);
        printWriter.close();
    }
}
