package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //indicamos tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        //para uso mas profecional excel usar poi.apache.org
        
        //para que no guarde cache 3 lineas
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1);
        
        //desplegar info al cliente
        PrintWriter out = response.getWriter();
        //t deja celda vacia
        //cada linea codigo es un renglon
        //cada valor en las lineas se hace columna
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=Suma(b2:b3)");
        out.close();
    }
}
