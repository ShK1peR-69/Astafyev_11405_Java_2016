package com.springapp.mvc.fx;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.services.UsersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class MainController {

    @Qualifier("users")
    @Autowired(required = false)
    protected UsersService usersService;
    @FXML
    private TableView<Users> table;
    @FXML
    private TextField textName;
    @FXML
    private TextField textUsername;
    @FXML
    private TextField textEmail;

    private ObservableList<Users> data;

    @FXML
    public void initialize() {
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    public void init() {
        List<Users> users = usersService.getAllUsers();
        System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ   "+users.size());
        data = FXCollections.observableArrayList(users);

        TableColumn<Users, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("id"));

        TableColumn<Users, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));

        TableColumn<Users, String> usernameColumn = new TableColumn<>("Логин");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("username"));

        TableColumn<Users, String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));

        table.getColumns().setAll(idColumn, nameColumn, usernameColumn, emailColumn);
        table.setItems(data);
    }


    @FXML
    public void addNewUser() {
        Users user = new Users(textName.getText(), textUsername.getText(), textEmail.getText());
        usersService.addNewUser(user);
        data.add(user);
        textName.setText("");
        textUsername.setText("");
        textEmail.setText("");
    }

    public MainController() {
    }
}
