package ac.za.tut;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;
import java.util.List;

public class ChrecheKiddie extends JFrame {

    private List<Child> kidsList = new ArrayList<Child>();
    // panels
    private JPanel namePnl;
    private JPanel genderPnl;
    private JPanel nameAndGenderPnl;
    private JPanel btnPnl;
    private JPanel txtAreaPnl;
    private JPanel mainPnl;

    // labels
    private JLabel nameLbl;
    private JLabel genderLbl;

//radio buttons
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;

//buttons
    private JButton registerBtn;
    private JButton displayBtn;

//button group
    private ButtonGroup gp;
//text area
    private JTextArea detailsTxtArea;

//text field
    private JTextField nameTxtFld;

//scrollpane
    private JScrollPane sp;

    public ChrecheKiddie() {
        setTitle("CHRECHE 4 YOUR KIDDIE");
        setSize(500, 550);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//create panels
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameAndGenderPnl = new JPanel(new GridLayout(2, 1));
        btnPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txtAreaPnl = new JPanel(new FlowLayout());
        mainPnl = new JPanel(new BorderLayout());

//create labels
        nameLbl = new JLabel("Name: ");
        genderLbl = new JLabel("Gender: ");

//create text field
        nameTxtFld = new JTextField(20);

//create RadioButtons
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        gp = new ButtonGroup();
        gp.add(maleRadio);
        gp.add(femaleRadio);

//create buttons
        registerBtn = new JButton("Register kiddie");
        displayBtn = new JButton("Display kiddies");

//create text area
        detailsTxtArea = new JTextArea(10, 15);
        detailsTxtArea.setEditable(false);
        sp = new JScrollPane(detailsTxtArea);

//add components to their panels
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);

        genderPnl.add(genderLbl);
        genderPnl.add(maleRadio);
        genderPnl.add(femaleRadio);

        nameAndGenderPnl.add(namePnl);
        nameAndGenderPnl.add(genderPnl);

        btnPnl.add(registerBtn);
        btnPnl.add(displayBtn);

        txtAreaPnl.add(sp);

        mainPnl.add(nameAndGenderPnl, BorderLayout.NORTH);
        mainPnl.add(btnPnl, BorderLayout.CENTER);
        mainPnl.add(txtAreaPnl, BorderLayout.SOUTH);

        add(mainPnl);

        pack();
        setVisible(true);

        registerBtn.addActionListener((r) -> registerButton());
       displayBtn.addActionListener((d)-> displayDetails());
    }

    private void registerButton() {
String name = nameTxtFld.getText();
String gender="";
 

        if (maleRadio.isSelected()) {
        gender = "Male";   
        }else if (femaleRadio.isSelected()) {
        gender = "Female";   
        }
        
        if ((!name.isEmpty()) && (!gender.isEmpty())) {
        kidsList.add(new Child(name, gender));
        nameTxtFld.setText("");
        gp.clearSelection();
        JOptionPane.showMessageDialog(this, "Kiddie registered!");
        }else{
        JOptionPane.showMessageDialog(this, "Error! Fill all the field(Name and Gender)","Invalid!",JOptionPane.ERROR_MESSAGE);
        
        }


    }

    private void displayDetails() {
    detailsTxtArea.setText("");
        for (Child child : kidsList) {
        detailsTxtArea.append(child.toString()+"\n");
        }
    
    
    
    
    }

    

       

}
