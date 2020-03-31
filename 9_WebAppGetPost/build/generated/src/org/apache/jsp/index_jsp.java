package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Sistema de cotización de seguros de auto</h1>\n");
      out.write("        <h2>Datos personales</h2>\n");
      out.write("\n");
      out.write("        <form name=\"FormaUno\" action=\"final.jsp\" method=\"POST\">\n");
      out.write("            <input type=\"text\" name=\"parametro_post\" value=\"\" />\n");
      out.write("            <input type=\"submit\" value=\"Enviar\" />\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form name=\"FormaDos\" action=\"final.jsp\" method=\"GET\">\n");
      out.write("            <input type=\"text\" name=\"parametro_get\" value=\"\" />\n");
      out.write("            <input type=\"submit\" value=\"Enviar\" />\n");
      out.write("        </form>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Campo</th>\n");
      out.write("                    <th>Valor</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Nombre</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"name\" value=\"\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Apellidos</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"lastname\" value=\"\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Género</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"radio\" name=\"genero\" value=\"Masculino\" />\n");
      out.write("                        <input type=\"radio\" name=\"genero\" value=\"Femenino\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Edad</td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"number\" name=\"age\" value=\"\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Estado</td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"Region\">\n");
      out.write("                            <option>CDMX</option>\n");
      out.write("                            <option>Jalisco</option>\n");
      out.write("                            <option>Nuevo León</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Limpiar\" name=\"btl\" />\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"submit\" value=\"Enviar\" name=\"bts\" />\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
