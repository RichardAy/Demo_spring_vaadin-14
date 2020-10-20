package edu.pucmm.eict.vaadin14.views.Other;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import edu.pucmm.eict.vaadin14.data.entity.People;
import edu.pucmm.eict.vaadin14.views.main.MainView;
import edu.pucmm.eict.vaadin14.views.otherComponents.DialogForm;

import java.beans.FeatureDescriptor;

@Route(value = "Other", layout = MainView.class)
@PageTitle("Other")
@CssImport("styles/views/form/form-view.css")
public class Other extends Div {

    public Other() {
        setId("Other-view");

        HorizontalLayout caja = new HorizontalLayout();
        caja.add(new H2("Seller:"));
        caja.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(createFileAndButton());
        horizontalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add( viewGrid());

        add(caja,horizontalLayout,verticalLayout);

    }
    public HorizontalLayout createFileAndButton() {


        Button button = new Button(new Icon(VaadinIcon.PLUS));


        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(buttonClickEvent -> {

            OtherForm dialogForm = new OtherForm();
            dialogForm.open();

        });

        TextField textField = new TextField();
        textField.setPlaceholder("Search");
        textField.setSuffixComponent(new Icon(VaadinIcon.SEARCH));


        return new HorizontalLayout(textField, button);
    }
    private Grid viewGrid() {


        Grid<People> grid = new Grid<>(People.class);
        //grid.setItems(listPeople());

        grid.removeColumnByKey("id");


        grid.setColumns("firstName", "lastName", "age", "address",
                "phoneNumber");
        return grid;
    }

}
