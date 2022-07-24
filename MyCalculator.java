package Roni;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MyCalculator implements ActionListener {
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPoint, bCancel;
    JButton bPlass, bMinus, bTime, bDevide, bModule, bEqual, bDelete;
    JTextField t ,textSymble;
    JPanel text_panel, number_panel, operation_panel;
    static double a, b, result;
    static int operation;
    MyCalculator(){
        JFrame f = new JFrame("My Calculator");
        //text_panel
        text_panel = new JPanel();
        text_panel.setBackground(Color.LIGHT_GRAY);
        text_panel.setBounds(0, 0, 250, 400);
        //add component
        t = new JTextField(20);
        textSymble = new JTextField(2);
        t.setBackground(Color.green);
        textSymble.setBackground((Color.CYAN));
        text_panel.add(t);
        text_panel.add(textSymble);
        text_panel.setLayout(new FlowLayout());

        //number_panel
        number_panel = new JPanel();
        number_panel.setBackground(Color.red);
        number_panel.setBounds(0, 30, 200, 300);
        // all button

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        bPoint = new JButton(".");
        b0 = new JButton("0");
        bDelete = new JButton("D");


        number_panel.add(b1);
        number_panel.add(b2);
        number_panel.add(b3);
        number_panel.add(b4);
        number_panel.add(b5);
        number_panel.add(b6);
        number_panel.add(b7);
        number_panel.add(b8);
        number_panel.add(b9);
        number_panel.add(bPoint);
        number_panel.add(b0);
        number_panel.add(bDelete);

        number_panel.setLayout(new GridLayout(4,3,2,2));




        //operation_panel
        operation_panel = new JPanel();
        operation_panel.setBounds(200, 30, 50, 300);
        operation_panel.setBackground(Color.blue);

        //add all comopnent in operation_panel
        operation_panel.setLayout(new GridLayout(6,1,2,2));
        bPlass = new JButton("+");
        bMinus = new JButton("-");
        bTime = new JButton("*");
        bDevide = new JButton("/");
        bModule = new JButton("%");
        bEqual = new JButton("=");

        operation_panel.add(bPlass);
        operation_panel.add(bMinus);
        operation_panel.add(bTime);
        operation_panel.add(bDevide);
        operation_panel.add(bModule);
        operation_panel.add(bEqual);

        //add all component in frame
        bCancel = new JButton("Clear");
        bCancel.setBounds(0, 330, 250, 50);
        f.add(bCancel);
        f.add(operation_panel);
        f.add(number_panel);
        f.add(text_panel);
        f.setSize(265, 415);
        f.setLayout(null);
        f.setBackground(Color.orange);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding all the button in actionlistener
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bPoint.addActionListener(this);
        bCancel.addActionListener(this);
        bPlass.addActionListener(this);
        bMinus.addActionListener(this);
        bTime.addActionListener(this);
        bDevide.addActionListener(this);
        bModule.addActionListener(this);
        bEqual.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){

        //numaric buttons
        if(e.getSource() == b0) t.setText(t.getText().concat("0"));
        else if(e.getSource() == b1) t.setText(t.getText().concat("1"));
        else if(e.getSource() == b2) t.setText(t.getText().concat("2"));
        else if(e.getSource() == b3) t.setText(t.getText().concat("3"));
        else if(e.getSource() == b4) t.setText(t.getText().concat("4"));
        else if(e.getSource() == b5) t.setText(t.getText().concat("5"));
        else if(e.getSource() == b6) t.setText(t.getText().concat("6"));
        else if(e.getSource() == b7) t.setText(t.getText().concat("7"));
        else if(e.getSource() == b8) t.setText(t.getText().concat("8"));
        else if(e.getSource() == b9) t.setText(t.getText().concat("9"));
        else if(e.getSource() == bPoint) t.setText(t.getText().concat("."));

            // operation button

        else if(e.getSource() == bPlass) {
            a = Double.parseDouble(t.getText());
            operation = 1;
            t.setText("");
            textSymble.setText("+");
        }
        else if(e.getSource() == bMinus) {
            a = Double.parseDouble(t.getText());
            operation = 2;
            t.setText("");
            textSymble.setText("-");
        }
        else if(e.getSource() == bTime) {
            a = Double.parseDouble(t.getText());
            operation = 3;
            t.setText("");
            textSymble.setText("*");
        }
        else if(e.getSource() == bDevide) {
            a = Double.parseDouble(t.getText());
            operation = 4;
            t.setText("");
            textSymble.setText("/");
        }
        else if(e.getSource() == bModule) {
            a = Double.parseDouble(t.getText());
            operation = 5;
            t.setText("");
            textSymble.setText("%");
        }
        else if(e.getSource() == bEqual) {
            b = Double.parseDouble(t.getText());
            switch (operation){
                case 1 : result = a+b; break;
                case 2 : result = a-b; break;
                case 3 : result = a*b; break;
                case 4 : result = a/b; break;
                case 5 : result = a%b; break;
                default : result = 0;
            }
            t.setText(" "+result);
        }
        else if(e.getSource() == bCancel) {
            t.setText("");
        }

        else if(e.getSource() == bDelete){
            String s = t.getText();
            t.setText("");
            for (int i = 0; i < s.length()-1; i++) {
                t.setText(t.getText() + s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new MyCalculator();
    }
}