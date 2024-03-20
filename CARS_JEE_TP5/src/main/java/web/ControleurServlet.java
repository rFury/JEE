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
import web.CarModele; // Assuming this is your model class

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ICarDao metier;

    @Override
    public void init() throws ServletException {
        metier = new CarDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/index.do":
                request.getRequestDispatcher("Cars.jsp").forward(request, response);
                break;
            case "/chercher.do":
                String motCle = request.getParameter("motCle");
                CarModele model = new CarModele();
                model.setMotCle(motCle);
                List<Car> cars = metier.carsByModel(motCle);
                model.setCars(cars);
                request.setAttribute("model", model);
                request.getRequestDispatcher("Cars.jsp").forward(request, response);
                break;
            case "/supprimer.do":
                long id = Long.parseLong(request.getParameter("id"));
                metier.deleteCar(id);
                response.sendRedirect("chercher.do?motCle=");
                break;
            case "/editer.do":
                long editId = Long.parseLong(request.getParameter("id"));
                Car editCar = metier.getCar(editId);
                request.setAttribute("car", editCar);
                request.getRequestDispatcher("editerCar.jsp").forward(request, response);
                break;
            case "/saisie.do":
                request.getRequestDispatcher("saisieCar.jsp").forward(request, response);
                break;
            case "/save.do":
                String carModel = request.getParameter("model");
                String carBrand = request.getParameter("brand");
                double price = Double.parseDouble(request.getParameter("price"));
                Car car = metier.save(new Car(carModel, carBrand, price));
                request.setAttribute("car", car);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                break;
            case "/update.do":
                long updateId = Long.parseLong(request.getParameter("id"));
                String updatedModel = request.getParameter("model");
                String updatedBrand = request.getParameter("brand");
                double updatedPrice = Double.parseDouble(request.getParameter("price"));
                Car updatedCar = new Car(updateId, updatedModel, updatedBrand, updatedPrice);
                metier.updateCar(updatedCar);
                request.setAttribute("car", updatedCar);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
