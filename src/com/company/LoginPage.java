package com.company;

import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.AttributedString;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginPage extends Window implements ActionListener{


    ImageButton loginButton = new ImageButton("Login","C:/Users/Szilard/Desktop/MAN/Login.png");

    ImageButton resetButton = new ImageButton("Reset","C:/Users/Szilard/Desktop/MAN/Cancel.png");

   // ImageButton User = new ImageButton("User","C:/Users/Szilard/Desktop/MAN/pngegg4.png");
   // ImageButton Password = new ImageButton("Password","C:/Users/Szilard/Desktop/MAN/pngegg4.png");

    InputFields userIDField = new InputFields("C:/Users/Szilard/Desktop/MAN/Username.png");
    PasswordField userPasswordField = new PasswordField("C:/Users/Szilard/Desktop/MAN/Password.png");

    JLabel messageLabel = new JLabel();
    String str="Forgotten password";
    JLabel link = new JLabel("<html><u>"+str+"</u>");
    JLabel email = new JLabel("Username:");
    JLabel password = new JLabel("Password:");


    HashMap<String,String> logininfo = new HashMap<String,String>();

    boolean Successfull= false;

    LoginPage(HashMap<String,String> loginInfoOriginal){



        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);


        logininfo = loginInfoOriginal;
        //setStart
        setVisible(true);

        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("C:/Users/Szilard/Desktop/MAN/Orbitron.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            //contentPane.setFont(customFont);
            link.setFont(customFont);
            email.setFont(customFont);
            password.setFont(customFont);
            userIDField.setFont(customFont);
            userPasswordField.setFont(customFont);
            FontMetrics metrics = getGraphics().getFontMetrics(customFont);
            link.setSize(metrics.stringWidth(str),metrics.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

//use the font




        Background panel = new Background(new ImageIcon("C:/Users/Szilard/Desktop/MAN/SDA.png").getImage());
       // BackgroundForButtons panelForButtons = new BackgroundForButtons(new ImageIcon("C:/Users/Szilard/Desktop/MAN/ForButtons.png").getImage());



        //Dimension Buttonsize = new Dimension(super.getWidth(),80);

        link.setForeground(Color.white.brighter());
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        email.setForeground(Color.white.brighter());

        password.setForeground(Color.white.brighter());

       // panelForButtons.setPosX((getWidth()/20)*11);
     //   panelForButtons.setLenght((getWidth()/20)*9);


        loginButton.setSize(loginButton.getSizeX(),loginButton.getSizeY());
        resetButton.setSize(resetButton.getSizeX(),resetButton.getSizeY());

     //   User.setSize((int)Buttonsize.getWidth()/2,(int)Buttonsize.getHeight());
        userPasswordField.setSize(userPasswordField.getSizeX(),userPasswordField.getSizeY());
        userIDField.setSize(userIDField.getSizeX(),userIDField.getSizeY());


        userIDField.setBounds(getWidth()/2+userIDField.getWidth()/8, getHeight()/2-getHeight()/15,
                userIDField.getWidth() ,userIDField.getHeight());


        userPasswordField.setBounds(getWidth()/2+userPasswordField.getWidth()/8, getHeight()/2+getHeight()/15,
                userPasswordField.getWidth() ,userPasswordField.getHeight());

        loginButton.setBounds(userPasswordField.getBounds().x + userPasswordField.getSizeX() - loginButton.getSizeX(),getHeight()/2+3*getHeight()/15,
                loginButton.getWidth(), loginButton.getHeight());

        userPasswordField.setBackground(Color.gray.brighter());

        resetButton.setLocation(userPasswordField.getBounds().x,getHeight()/2+3*getHeight()/15);

     //   User.setLocation(getWidth()/2-(int)Buttonsize.getWidth()/2-User.getWidth()/2,super.getHeight()/2-3*(int)Buttonsize.getHeight()-10);
      //  Password.setLocation(getWidth()/2-(int)Buttonsize.getWidth()/2-Password.getWidth()/2,super.getHeight()/2-2*(int)Buttonsize.getHeight());



        System.out.println(link.getWidth());
        link.setBounds(userPasswordField.getLocation().x+userPasswordField.getWidth()-link.getWidth(),userPasswordField.getLocation().y + 3/2* userPasswordField.getHeight()+20,
                link.getWidth(),link.getHeight());
        email.setBounds(userIDField.getLocation().x,userIDField.getLocation().y-30,500,30);
        password.setBounds(userPasswordField.getLocation().x,userPasswordField.getLocation().y-30,500,30);








        //loginButton.addActionListener(this);

        contentPane.add(link);
        contentPane.add(email);
        contentPane.add(password);
        contentPane.add(loginButton);
        contentPane.add(resetButton);
       // contentPane.add(User);
      //  contentPane.add(Password);





        //  contentPane.add(userIDLabel);
      //  contentPane.add(userPasswordLabel);
      //  contentPane.add(messageLabel);
      //  contentPane.add(userIDField);

        contentPane.add(userPasswordField);
        contentPane.add(userIDField);
        contentPane.add(loginButton);
        contentPane.add(resetButton);




     //   contentPane.add(panelForButtons);
        contentPane.add(panel);


        contentPane.revalidate();
        contentPane.repaint();

        contentPane.setVisible(true);

    }


    public void linkAction() {
        link.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
                    try
                    {
                        Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley"));
                    }
                    catch (IOException | URISyntaxException e1)
                    {
                        e1.printStackTrace();
                    }
                System.out.println("ok");

            }

            @Override
            public void mouseExited(MouseEvent e) {
               // link.setText(str);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
              //  link.setText(str);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {
            userIDField.setText("");

            userPasswordField.setText("");
        }
        if(e.getSource()==loginButton) {
            CheckPassword();
        }
    }
    public void CheckPassword(){
        String userID = userIDField.getText();
        String Password = String.valueOf(userPasswordField.getPassword());

        if(logininfo.containsKey(userID)) {
            if(logininfo.get(userID).equals(Password)) {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Login successful");
                Successfull=true;
            }
            else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Wrong password");
            }
        }
        else {
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Username not found");
        }
    }
    public boolean check(){
        return Successfull;
    }
    public void setActivity(boolean state) {
        setVisible(state);
    }
    public void doAction(Context context) {
        System.out.println("Player is in Login");
        context.setState(this);
    }
    public String toString() {

        return "Login";
    }
}