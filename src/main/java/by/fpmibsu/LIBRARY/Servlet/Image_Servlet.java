package by.fpmibsu.LIBRARY.Servlet;
import by.fpmibsu.LIBRARY.Service.ImageService;
import by.fpmibsu.LIBRARY.Service.LiteratureService;
import by.fpmibsu.LIBRARY.util.JspHelper;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@WebServlet("/images")
public class Image_Servlet extends HttpServlet {
    private final ImageService imageService=ImageService.getInstance();
    private final LiteratureService literatureService = LiteratureService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try(var printWriter = resp.getWriter()){
            printWriter.write("<h1>Список литературы:</h1>");
            printWriter.write("<ul>");
            literatureService.findAll().forEach(literatureDto -> {
                printWriter.write("""
                        <li>
                        <a>literatureId=%s text=%s</a>
                        </li>
                        """.formatted(literatureDto.getLiteratureId(), literatureDto.getText()));
            });
            printWriter.write("</ul>");
        }
    }

//    private final ImageService imageService=ImageService.getInstance();
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        var requestURI = req.getRequestURI();
//        var imagePath=requestURI.replace("/images","");
//        imageService.get(imagePath)
//                .ifPresentOrElse(image->{
//                    resp.setContentType("application/octet-stream");
//                    writeImage(image,resp);
//                },()->resp.setStatus(404));
//    }
//@SneakyThrows
//    private void writeImage(InputStream image, HttpServletResponse resp) {
//        try(image;var outputStream=resp.getOutputStream()){
//            int currentByte;
//            while ((currentByte=image.read())!=-1){
//                outputStream.write(currentByte);
//            }
//        }
//    }
}
