package edu.pucmm.eict.vaadin14.views.otherComponents;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import edu.pucmm.eict.vaadin14.data.entity.Employee;
import edu.pucmm.eict.vaadin14.data.entity.People;
import edu.pucmm.eict.vaadin14.views.main.MainView;

import java.util.ArrayList;
import java.util.List;


@Route(value = "yelson", layout = MainView.class)
@PageTitle("yelson")
@CssImport("styles/views/form/form-view.css")
public class Yelson extends Div {

    public Yelson() {
        setId("yelson-view");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(createFileAndButton());
        horizontalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add( viewGrid());

        add(horizontalLayout,verticalLayout);
    }

    public HorizontalLayout createFileAndButton() {


        Button button = new Button(new Icon(VaadinIcon.PLUS));

        button.addClickListener(buttonClickEvent -> {

            DialogForm dialogForm = new DialogForm();
            dialogForm.open();

        });
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);


        TextField textField = new TextField();
        textField.setPlaceholder("Search");
        textField.setSuffixComponent(new Icon(VaadinIcon.SEARCH));


        return new HorizontalLayout(textField, button);
    }

    private Grid viewGrid() {


        Grid<People> grid = new Grid<>(People.class);
        grid.setItems(listPeople());

        grid.removeColumnByKey("id");


        grid.setColumns("firstName", "lastName", "age", "address",
                "phoneNumber");
        return grid;
    }

    public List<People> listPeople(){

        List<People> personList = new ArrayList<>();

        personList.add(new People(100L, "Lucas", "Kane", 68L,
                "12080 Washington", "127-942-237"));
        personList.add(new People(101L, "Peter", "Buchanan", 38L,
                "93849New York", "201-793-488"));
        personList.add(new People(102L, "Samuel", "Lee", 53L,
                "86829 New York", "043-713-538"));
        personList.add(new People(103L, "Anton", "Ross", 37L,
                "63521 New York", "150-813-6462"));
        personList.add(new People(104L, "Aaron", "Atkinson", 18L,
                "25415 Washington", "321-679-8544"));
        personList.add(new People(105L, "Jack", "Woodward", 28L,
                "95632 New York", "187-338-588"));
        return personList;
    }

    public List<Employee> listEmployee() {

        List<Employee> personList = new ArrayList<>();

        personList.add(  new Employee("Gabriella",
                        "Inge", "https://randomuser.me/api/portraits/women/43.jpg"));
        personList.add( new Employee("Rudi", "Doctor",
                        "https://randomuser.me/api/portraits/men/77.jpg"));
        personList.add(         new Employee("Hamsa", "Arquite",
                        "https://randomuser.me/api/portraits/men/35.jpg"));
        personList.add(        new Employee("Jacob", "vest",
                        "https://randomuser.me/api/portraits/men/76.jpg"));
        return personList;

    }


}
