package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //agregamos la variable contador
        int contador = 0;
        
        //Revisar si existe la cookie contador visitas
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie c:cookies){
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        //incrementar el contador en 1
        contador++;
        //ageregamos la respuesta al navegador
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
        //La cookie se almacenara en el cliente por 1hr(3600seg)
        c.setMaxAge(3600);
        response.addCookie(c);
        
        //Mandamos el mensaje al navegador]
        response.setContentType("text/html;charset-UTF-8");
        PrintWriter out = response.getWriter();
        out.print("Contadoe de visitas de cada cliente: " + contador);
        out.close();
        
    }
    
}
