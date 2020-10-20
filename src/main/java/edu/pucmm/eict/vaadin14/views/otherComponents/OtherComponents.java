package edu.pucmm.eict.vaadin14.views.otherComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import edu.pucmm.eict.vaadin14.data.entity.Department;
import edu.pucmm.eict.vaadin14.data.entity.Employee;
import edu.pucmm.eict.vaadin14.views.main.MainView;

import java.util.Arrays;
import java.util.List;

@Route(value = "other/components", layout = MainView.class)
@PageTitle("Components")
@CssImport("styles/views/form/form-view.css")
public class OtherComponents extends Div {

    public OtherComponents() {
        setId("other-component");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        VerticalLayout layout = new VerticalLayout();

        createRadioButtonGroup(horizontalLayout);
        createListBox(layout);
        createMultiSelectListBox(layout);
        createCustomizingListBox(horizontalLayout);


        add(new H2("Other Components"), layout, horizontalLayout);
    }

    public void createRadioButtonGroup(HorizontalLayout verticalLayout) {
        RadioButtonGroup<Department> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Department: ");
        List<Department> departmentList = getDepartments();
        radioGroup.setItems(departmentList);
        radioGroup.setRenderer(new TextRenderer<>(Department::getName));
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);

        radioGroup.addValueChangeListener(event -> {
            if (event.getValue() != null) {

                radioGroup.setLabel("Department: " + event.getValue().getName());
            }
        });


        verticalLayout.add(radioGroup);
    }

    private List<Department> getDepartments() {
        List<Department> list = Arrays.asList(
                new Department("Production"),
                new Department("programming"),
                new Department("analysis"),
                new Department("TI"),
                new Department("Development"),
                new Department("system"));
        return list;
    }

    public void createListBox(VerticalLayout overlayLayout) {

        ListBox listBox = new ListBox();
        listBox.setItems("Option one", "Option two", "Option three");
        listBox.setValue("Option one");
        overlayLayout.add(new Paragraph("Listbox basic"), listBox);
    }

    public void createMultiSelectListBox(VerticalLayout verticalLayout) {
        MultiSelectListBox<String> listBox = new MultiSelectListBox<>();
        listBox.setItems("Option one", "Option two", "Option three",
                "Option four");
        verticalLayout.add(new Paragraph("MultiSelectListBox"), listBox);
    }

    public void createCustomizingListBox(HorizontalLayout horizontalLayout) {

        ListBox<Employee> listBox = new ListBox<>();
        List<Employee> list = Arrays.asList(
                new Employee("Gabriella",
                        "https://randomuser.me/api/portraits/women/43.jpg"),
                new Employee("Rudi",
                        "https://randomuser.me/api/portraits/men/77.jpg"),
                new Employee("Hamsa",
                        "https://randomuser.me/api/portraits/men/35.jpg"),
                new Employee("Jacob",
                        "https://randomuser.me/api/portraits/men/76.jpg"));
        listBox.setItems(list);
        listBox.setValue(list.get(0));

        listBox.setRenderer(new ComponentRenderer<>(employee -> {
            Div text = new Div();
            text.setText(employee.getName());

            Image image = new Image();
            image.setWidth("21px");
            image.setHeight("21px");
            image.setSrc(employee.getImage());

            FlexLayout wrapper = new FlexLayout();
            text.getStyle().set("margin-left", "0.5em");
            wrapper.add(image, text);
            return wrapper;
        }));
        horizontalLayout.add(listBox);
    }


}
