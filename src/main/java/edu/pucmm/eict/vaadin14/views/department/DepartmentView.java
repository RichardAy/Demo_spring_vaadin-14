package edu.pucmm.eict.vaadin14.views.department;

import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import edu.pucmm.eict.vaadin14.views.main.MainView;

import java.time.LocalDate;
import java.util.Collections;


@Route(value = "Department", layout = MainView.class)
@PageTitle("Department")
@CssImport("styles/views/form/form-view.css")
public class DepartmentView extends Div {

    BigDecimalField bigDecimalField = new BigDecimalField();
    TextField textField = new TextField();
    Paragraph tax = new Paragraph();
    TimePicker timePicker = new TimePicker("Time");

    public DepartmentView() {
        setId("department-view");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        VerticalLayout wrapper = createWrapper();
        createTitle(wrapper);
        createTextArea(wrapper);
        createBondy(wrapper);
        createBigFieldAdnPlus(wrapper);
        createCheckboxGroup(horizontalLayout);
        createDatePicker(horizontalLayout);
        createComboBox(wrapper);
        createEmailField(wrapper);

        createPasswordField(wrapper);



        add(horizontalLayout, wrapper);
    }

    public void createBigFieldAdnPlus(VerticalLayout verticalLayout) {


        textField.setPlaceholder("Word");
        textField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));

        bigDecimalField.setLabel("Value");
        bigDecimalField.setPrefixComponent(new Icon(VaadinIcon.DOLLAR));
        bigDecimalField.setClearButtonVisible(true);

        tax.setText("Dollar");


        verticalLayout.add(bigDecimalField, tax, timePicker, textField);

    }

    public void createCheckboxGroup(HorizontalLayout horizontalLayout) {
        CheckboxGroup<String> horizontal = new CheckboxGroup<>();
        horizontal.setLabel("Horizontal");
        horizontal.setItems("Option one", "Option two", "Option three");
        horizontal.setValue(Collections.singleton("Option one"));
        horizontalLayout.add(horizontal);

    }

    public void createComboBox(VerticalLayout verticalLayout) {
        ComboBox<String> labelComboBox = new ComboBox<>();
        labelComboBox.setItems("Option one", "Option two");
        labelComboBox.setLabel("Label");

        ComboBox<String> placeHolderComboBox = new ComboBox<>();
        placeHolderComboBox.setItems("Option one", "Option two");
        placeHolderComboBox.setPlaceholder("Placeholder");

        ComboBox<String> valueComboBox = new ComboBox<>();
        valueComboBox.setItems("Value", "Option one", "Option two");
        valueComboBox.setValue("Value");

        ComboBox<String> requiredComboBox = new ComboBox<>();
        requiredComboBox.setItems("Option one", "Option two", "Option three");
        requiredComboBox.setLabel("Required");
        requiredComboBox.setPlaceholder("Select an option");

        requiredComboBox.setRequired(true);
        requiredComboBox.setClearButtonVisible(true);

        verticalLayout.add(labelComboBox, placeHolderComboBox, valueComboBox, requiredComboBox);

    }

    public void createEmailField(VerticalLayout verticalLayout) {
        EmailField emailField = new EmailField("Email");
        emailField.setClearButtonVisible(true);
        emailField.setErrorMessage("Please enter a valid email address");
        emailField.setRequiredIndicatorVisible(true);


        TextField centerTextField = new TextField();
        centerTextField.setValue("center");
        centerTextField.setLabel("Center");
        centerTextField.setRequired(true);
        centerTextField.setErrorMessage("This is required");
        centerTextField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);

        verticalLayout.add(emailField, centerTextField);
    }

    public void createPasswordField(VerticalLayout verticalLayout) {
        PasswordField passwordField = new PasswordField();
        passwordField.setLabel("Password");
        passwordField.setPlaceholder("Enter password");
        passwordField.setValue("secret1");
        passwordField.setRequired(true);
        passwordField.setErrorMessage("this");

        verticalLayout.add(passwordField);

    }


    public void createDatePicker(HorizontalLayout horizontalLayout) {

        DatePicker labelDatePicker = new DatePicker();
        labelDatePicker.setLabel("Label");

        DatePicker placeholderDatePicker = new DatePicker();
        placeholderDatePicker.setPlaceholder("Placeholder");
        placeholderDatePicker.setLabel("Label-2");

        DatePicker valueDatePicker = new DatePicker();
        LocalDate now = LocalDate.now();
        valueDatePicker.setValue(now);
        valueDatePicker.setLabel("Label-3");

        horizontalLayout.add(labelDatePicker, placeholderDatePicker, valueDatePicker);
    }

    public void createTextArea(VerticalLayout verticalLayout){

        TextArea textArea = new TextArea("Description");
        textArea.getStyle().set("minHeight", "150px");
        textArea.setPlaceholder("Write here ...");

        verticalLayout.add(textArea);
    }
    private void createTitle(VerticalLayout wrapper) {
        H1 h1 = new H1("Department");
        wrapper.add(h1);

    }

    private void createBondy(VerticalLayout verticalLayout) {
        H1 h1 = new H1("Hello Work");
        verticalLayout.add(h1);

    }

    private VerticalLayout createWrapper() {
        VerticalLayout wrapper = new VerticalLayout();
        wrapper.setId("wrapper");
        wrapper.setSpacing(false);
        return wrapper;
    }

}
