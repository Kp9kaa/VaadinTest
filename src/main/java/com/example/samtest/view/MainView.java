package com.example.samtest.view;

import com.example.samtest.client.BackendRestClient;
import com.example.samtest.models.User;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.annotations.Theme;
import com.vaadin.data.HasValue;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupView;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import lombok.RequiredArgsConstructor;

@SpringUI
@StyleSheet("vaadin://addons/styles.css")
@Theme("valo")
@RequiredArgsConstructor
public class MainView extends UI {

    private VerticalLayout layout;

    private final BackendRestClient backendRestClient;


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        addForm();
    }

    private void addForm() {
        layout = new VerticalLayout();
        setContent(layout);

        HorizontalLayout firstForm = new HorizontalLayout();
        Label popupLabel = new Label("Example");
        TextField textField = new TextField("Text field");
        textField.addValueChangeListener((HasValue.ValueChangeListener<String>) valueChangeEvent -> popupLabel.setValue(valueChangeEvent.getValue()));
        PopupView popup = new PopupView(null, popupLabel);
        Button firstButton = new Button("Button 1", clickEvent -> {
            popup.setPopupVisible(true);
        });
        firstForm.addComponents(firstButton, textField, popup);

        layout.addComponents(firstForm);

        Button secondButton = new Button("Button 2");
        secondButton.setPrimaryStyleName("color-button");
        layout.addComponent(secondButton);

        HorizontalLayout secondForm = new HorizontalLayout();
        Label label = new Label("Label");
        ComboBox<User> comboBox = new ComboBox<>("ComboBox");
        comboBox.setItems(backendRestClient.receiveUsers());
        comboBox.addValueChangeListener(changeEvent -> {
            label.setValue(changeEvent.getValue().toString());
        });
        secondForm.addComponents(comboBox, label);

        layout.addComponent(secondForm);
    }
}
