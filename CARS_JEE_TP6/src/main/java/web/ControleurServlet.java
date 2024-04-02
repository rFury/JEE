package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICarDao;
import dao.CarDaoImpl;
import metier.Car;
import web.CarModele;
import dao.IFGDao;
import dao.FGDaoImpl;
import metier.Family_Group;
import web.FGModele;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ICarDao carDao;
    private IFGDao familyGroupDao;

    @Override
    public void init() throws ServletException {
        carDao = new CarDaoImpl();
        familyGroupDao = new FGDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/index.do":
                // Display Cars.jsp
                request.getRequestDispatcher("Cars.jsp").forward(request, response);
                break;
            case "/chercher.do":
                String motCle = request.getParameter("motCle");
                CarModele carModel = new CarModele();
                carModel.setMotCle(motCle);
                List<Car> cars = carDao.carsByModel(motCle);
                carModel.setCars(cars);
                request.setAttribute("model", carModel);
                request.getRequestDispatcher("Cars.jsp").forward(request, response);
                break;
            case "/supprimer.do":
                long carId = Long.parseLong(request.getParameter("id"));
                carDao.deleteCar(carId);
                response.sendRedirect("chercher.do?motCle=");
                break;
            case "/editer.do":
            	Long id = Long.parseLong(request.getParameter("id"));
            	Family_Group group = familyGroupDao.getFamily_Group(id);
            	request.setAttribute("familyGroup", group);

            	List<Family_Group> groups = familyGroupDao.getAllFamily_Groups();
            	FGModele model = new FGModele();
            	model.setFamilyGroups(groups);
            	request.setAttribute("groupModel", model);
                long editCarId = Long.parseLong(request.getParameter("id"));
                Car editCar = carDao.getCar(editCarId);
                request.setAttribute("car", editCar);
                request.getRequestDispatcher("editerCar.jsp").forward(request, response);
                break;
            case "/saisie.do":
                // Display form for adding a new car
            	List<Family_Group> groupsS = familyGroupDao.getAllFamily_Groups();
            	FGModele modelS = new FGModele();
            	modelS.setFamilyGroups(groupsS);
            	request.setAttribute("groupModel", modelS);
                request.getRequestDispatcher("saisieCar.jsp").forward(request, response);
                break;
            case "/save.do":
            	Long FGID =Long.parseLong(request.getParameter("groupModel"));
                String carModelName = request.getParameter("model");
                Family_Group FG = familyGroupDao.getFamily_Group(FGID);
                String carBrand = request.getParameter("brand");
                double carPrice = Double.parseDouble(request.getParameter("price"));
                Car newCar = carDao.save(new Car(carModelName, carBrand, carPrice,FG));
                request.setAttribute("car", newCar);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                break;
            case "/update.do":
            	Long FGIDU =Long.parseLong(request.getParameter("FG"));
                Family_Group FGU = familyGroupDao.getFamily_Group(FGIDU);
                long updateCarId = Long.parseLong(request.getParameter("id"));
                String updatedCarModel = request.getParameter("model");
                String updatedCarBrand = request.getParameter("brand");
                double updatedCarPrice = Double.parseDouble(request.getParameter("price"));
                Car updatedCar = new Car(updateCarId, updatedCarModel, updatedCarBrand, updatedCarPrice,FGU);
                carDao.updateCar(updatedCar);
                request.setAttribute("car", updatedCar);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
