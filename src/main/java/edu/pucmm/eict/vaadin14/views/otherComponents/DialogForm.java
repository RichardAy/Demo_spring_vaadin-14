package edu.pucmm.eict.vaadin14.views.otherComponents;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;

public class DialogForm extends Dialog {

    public DialogForm() {
        setId("dialogForm-view");


        VerticalLayout verticalLayout = new VerticalLayout();


        Button bottonSave = new Button("Save");
        bottonSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button bottonCancel = new Button("Cancel");
        bottonCancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        HorizontalLayout star = new HorizontalLayout();
        star.add(bottonSave);
        star.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        HorizontalLayout end = new HorizontalLayout();
        end.add(bottonCancel);
        end.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        verticalLayout.add(new H1("Create"), formComponent());

        add(verticalLayout, star, end);
    }

    private FormLayout formComponent() {
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("10em", 1),
                new FormLayout.ResponsiveStep("25em", 2)
        );
        TextField textFieldName = new TextField("First name");
        TextField textFieldLastName = new TextField("Last name");
        IntegerField textFieldAge = new IntegerField("Age");
        TextField textFieldAddress = new TextField("Address");
        TextField textFieldPhoneNumber = new TextField("Phone number");

        formLayout.add(textFieldName, textFieldLastName, textFieldAge, textFieldPhoneNumber,textFieldAddress);

        formLayout.setColspan(textFieldAddress, 2);

        return formLayout;

    }

}
