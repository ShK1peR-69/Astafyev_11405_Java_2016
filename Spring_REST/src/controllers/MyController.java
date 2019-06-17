package controllers;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Controller
public class MyController {

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(ModelMap model) throws JSONException {
        StudentDAO studentDAO = new StudentDAO();
        model.put("students", studentDAO.getAll());
        return "allStudents";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String getUserByID(@PathVariable("id") int id, ModelMap model) {
        StudentDAO studentDAO = new StudentDAO();
        model.put("studentByID", studentDAO.getStudentByID(id));
        return "studentByID";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteAllUserByID(@PathVariable("id") int id, ModelMap model) {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.deleteUserByID(id);
    }
}