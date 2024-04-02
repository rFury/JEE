package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.FGDaoImpl;
import dao.IFGDao;
import metier.Family_Group;

@WebServlet(name="FGServlet", urlPatterns= {"/familyGroups","/saisieFamilyGroup","/saveFamilyGroup","/supprimerFamilyGroup","/editerFamilyGroup","/updateFamilyGroup"})
public class FGServlet extends HttpServlet {
    IFGDao metier;

    @Override
    public void init() throws ServletException {
        metier = new FGDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("PATH " + path);
        if (path.equals("/familyGroups")) {
            FGModele model = new FGModele();
            List<Family_Group> groups = metier.getAllFamily_Groups();
            model.setFamilyGroups(groups);
            request.setAttribute("model", model);
            request.getRequestDispatcher("familyGroups.jsp").forward(request, response);
        } else if (path.equals("/saisieFamilyGroup")) {
            request.getRequestDispatcher("saisieFamilyGroup.jsp").forward(request, response);
        } else if (path.equals("/saveFamilyGroup") && request.getMethod().equals("POST")) {
            Date dateOfCreation = new Date();
            String groupName = request.getParameter("groupName");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dateOfCreation = dateFormat.parse(request.getParameter("dateOfCreation"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Family_Group group = metier.save(new Family_Group(groupName, dateOfCreation));
            request.setAttribute("familyGroup", group);
            response.sendRedirect("familyGroups");
        } else if (path.equals("/supprimerFamilyGroup")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteFamily_Group(id);
            response.sendRedirect("familyGroups");
        } else if (path.equals("/editerFamilyGroup")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Family_Group group = metier.getFamily_Group(id);
            request.setAttribute("familyGroup", group);
            request.getRequestDispatcher("editerFamilyGroup.jsp").forward(request, response);
        } else if (path.equals("/updateFamilyGroup")) {
            Date dateOfCreation = new Date();
            Long id = Long.parseLong(request.getParameter("id"));
            String groupName = request.getParameter("groupName");
            Family_Group group = new Family_Group();
            group.setGroup_ID(id);
            group.setGroup_Name(groupName);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                dateOfCreation = dateFormat.parse(request.getParameter("dateOfCreation"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            group.setDateOfCreation(dateOfCreation);
            metier.updateFamily_Group(group);
            response.sendRedirect("familyGroups");
        } else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
