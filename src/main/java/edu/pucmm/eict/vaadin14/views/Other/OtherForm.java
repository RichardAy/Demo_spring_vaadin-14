package edu.pucmm.eict.vaadin14.views.Other;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.function.ValueProvider;
import edu.pucmm.eict.vaadin14.data.entity.Seller;
import edu.pucmm.eict.vaadin14.views.grid.EjemploGrid;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class OtherForm extends Dialog {


    TextField Name = new TextField("First name");
    TextField LastName = new TextField("Last name");
    TextField Detail = new TextField("Detail");
    TextField phoneNumber = new TextField("Phone number");
    IntegerField Age = new IntegerField("Age");
    Button buttonSave;
    Binder<Seller> binder;

    Seller seller = new Seller();

    public OtherForm() {
        setId("dialogForm-view");


        VerticalLayout verticalLayout = new VerticalLayout();


        buttonSave = new Button("Save");
        buttonSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSave = new Button("Save", new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {

                try {
                    binder.writeBean(seller);
                    Notification.show("The Seller:" + ", " + seller.getName() +
                            ", " + seller.getLastName() + ", " + seller.getDetail() +
                            ", " + seller.getPhoneNumber() + ", " + seller.getAge());
                } catch (ValidationException e) {
                    Span content = new Span("Deve de llenar los campos en rojo.");
                    Notification.show(content.getText()).setPosition(Notification.Position.MIDDLE);

                    Report();


                }
            }
        });


        Button buttonCancel = new Button("Cancel");
        buttonCancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        HorizontalLayout star = new HorizontalLayout();
        star.add(buttonSave);
        star.setJustifyContentMode(FlexComponent.JustifyContentMode.START);

        HorizontalLayout end = new HorizontalLayout();
        end.add(buttonCancel);
        end.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        buttonCancel.addClickListener(buttonClickEvent -> {
            close();

        });
        verticalLayout.add(new H1("Create"), formComponent());

        UpBinder();

        add(verticalLayout, star, end);


    }

    public void Report() {
       /* JasperPrint jasperPrint = JasperFillManager.fillReport(
                "./src/main/resources/lank_A4.jasper", null
                );
        JRPdfExporter exp = new JRPdfExporter();
        exp.setExporterInput(new SimpleExporterInput(jasperPrint));
        exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteAlumnos.pdf"));
        SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
        exp.setConfiguration(conf);
        exp.exportReport();*/


        //String report = JasperCompileManager.compileReportToFile("\\edu\\pucmm\\eict\\vaadin14\\report\\Blank_A4.jasper");



/*
        String reportPath="src/main/resources";
             //JasperReport reporte = (JasperReport) JRLoader.loadObject(new File("src/main/resources/Blank_A4.jasper"));

           //JasperReport jasperReport = JasperCompileManager.compileReport(reportPath+"/Blank_A4.jasper");

            Map parametro = new HashMap();
            parametro.put("Parameter1", "Richard Rafae;");
            parametro.put("Parameter2", "Duran Aybar");
            parametro.put("Parameter3", "809-203-1003.");
            parametro.put("Parameter4", "25");

        JasperPrint jprint = null;
        try {
            JasperReport  reporte1 = (JasperReport) JRLoader.loadObject(getClass().getResource(reportPath+"/Blank_A4.jasper"));
            jprint = JasperFillManager.fillReport(reporte1, parametro);
        } catch (JRException e) {
            e.printStackTrace();
        }
        JasperViewer jv = new JasperViewer(jprint, false);
            jv.setVisible(true);
*/
        try {
            String reportPath = "src/main/resources";
            JasperReport reporte1 = (JasperReport) JRLoader.loadObject(getClass().getResource(reportPath + "/Blank_A4.jasper"));
            Map parametro = new HashMap();
            parametro.put("Parameter1", "Richard Rafae;");
            parametro.put("Parameter2", "Duran Aybar");
            parametro.put("Parameter3", "809-203-1003.");
            parametro.put("Parameter4", "25");
            JasperPrint jprint = JasperFillManager.fillReport(reporte1, parametro);
//=
            JRPdfExporter exp = new JRPdfExporter();
            exp.setExporterInput(new SimpleExporterInput(jprint));
            exp.setExporterOutput(new SimpleOutputStreamExporterOutput("ReporteAlumnos.pdf"));
            SimplePdfExporterConfiguration conf = new SimplePdfExporterConfiguration();
            exp.setConfiguration(conf);
            exp.exportReport();
//=

           /* JasperViewer jv = new JasperViewer(jprint, false);
            jv.setVisible(true);*/
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

    public void UpBinder() {
        binder = new BeanValidationBinder<>(Seller.class);

        binder.forMemberField(Detail).asRequired("Falta el Detail.").bind(Seller::getDetail, Seller::setDetail);
        binder.forMemberField(Age).bind(Seller::getAge, Seller::setAge);

        binder.forField(Name).asRequired("Falta el name")
                .bind(Seller::getName, Seller::setName);

        binder.forField(LastName).asRequired("Falta el last name.")
                .bind(Seller::getLastName, Seller::setLastName);

        binder.forField(phoneNumber).asRequired("Falta el Detail.")
                .bind(Seller::getPhoneNumber, Seller::setPhoneNumber);


    }

    private FormLayout formComponent() {
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("10em", 1),
                new FormLayout.ResponsiveStep("25em", 2)
        );

        formLayout.add(Name, LastName, Detail, this.phoneNumber, Age);

        formLayout.setColspan(Detail, 2);


        return formLayout;

    }

}
