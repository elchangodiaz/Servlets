package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //visita por primera vez al sitio por usuario
        boolean nuevoUsuario = true;
        
        //obttenemos arreglo cookie
        Cookie[] cookies = request.getCookies();
        
        //buscamos una cookie creada con anterioridad
        //llamada visitante rewcurrente
        if(cookies != null){
            for(Cookie c:cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visirar nuestro sitio por primera vez";
        }else {
            mensaje = "Gracias por visirar nuevamente nuestro sitio";
        }
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Mensaje: " + mensaje);
        out.close();
    }
}
