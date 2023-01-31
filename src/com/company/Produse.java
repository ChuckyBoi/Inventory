package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.DesktopIconUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultTextUI;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.sql.*;

public class Produse extends Window {


    Connection connection;
    Statement statement;

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    int number=30;
    int ok=40;

    ImageButton back = new ImageButton("Main Menu", "C:/Users/Szilard/Desktop/MAN/Cancel.png");
    Background panel = new Background(new ImageIcon("C:/Users/Szilard/Desktop/MAN/SDA2.jpg").getImage());

    Produse() {


        setTitle("Produse");

        setActivity(false);

        buttonsSetUp();

        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        contentPane.add(back);






    }




    public void buttonsSetUp() {

        back.setSize(back.getSizeX(), back.getSizeY());
        back.setLocation(1000, 300);
        back.setForeground(Color.black);


    }


     public void deletePreviousT(){



     }
    public void viewData() {


        String[] columnNames = {"id", "nume", "firma", "pret", "tva", "pret_final", "nr_articole", "Up", "Down"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 1) {
                    return false;
                } else {
                    return true;
                }
            }
        };

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "password2002");
            String sql = "select * from inventar";
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from inventar");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nume");
                String firma = rs.getString("firma");
                int pret = rs.getInt("pret");
                float tva = rs.getFloat("tva");
                float pret_final = rs.getFloat("pret_final");
                int nr_articole = rs.getInt("nr_articole");

                System.out.println("nr articole in view data is " + nr_articole);


                String[] data = {String.valueOf(id), name, firma, String.valueOf(pret), String.valueOf(tva), String.valueOf(pret_final), String.valueOf(nr_articole)};
                tableModel.addRow(data);
            }
            tableSetup(tableModel);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tableSetup(DefaultTableModel tm){



        table = new JTable(tm);
        scrollPane = new JScrollPane(table);


        contentPane.add(scrollPane);


        /*table.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                TableModel model = (TableModel)e.getSource();
                Object data = model.getValueAt(row, column);
                System.out.println("im gonna kms " + data);

            }
        });*/

        scrollPane.setBounds(37, 37, 800, 1200);


        ButtonEditor up = new ButtonEditor(new JTextField());
        ButtonEditor down = new ButtonEditor(new JTextField());




        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());;
        table.getColumnModel().getColumn(7).setCellEditor(up);
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());;
        table.getColumnModel().getColumn(8).setCellEditor(down);





        up.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int rowIndex = table.getSelectedRow();
                System.out.println("row index is " + rowIndex);
                int colIndex = table.getSelectedColumn();
                System.out.println("column index is "+ colIndex);
                substract(rowIndex,tm);


             //   updateRow(rowIndex);
            }
        });
        down.btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //getmouse pos


                int rowIndex = table.getSelectedRow();
                int colIndex = table.getSelectedColumn();

                add(rowIndex,tm);
            }
        });


        contentPane.add(panel);

    }
    public void substract(int row,DefaultTableModel tm){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "password2002");
            String query = "update inventar set nr_articole=? where id=? ";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps = connection.prepareStatement(query);
            ps.setInt(1, number--);
            ps.setInt(2, 1);
            ps.executeUpdate();

            tm.setValueAt(number, 0, 6);

            System.out.println("Record is updated successfully......");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(int row,DefaultTableModel tm){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "password2002");
            String query = "update inventar set nr_articole=? where id=? ";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps = connection.prepareStatement(query);

            ps.setInt(1, number++);
            ps.setInt(2, 1);
            ps.executeUpdate();

            tm.setValueAt(number, 0, 6);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showImage(int row){

        System.out.println(tableModel.getValueAt(row,1));
        getSomething(tableModel.getValueAt(row,1));
        try {
            toDraw a = new toDraw();
            a.drawing();
        }catch (Exception e){


        }


     }
    public static void getSomething(Object s) {

        try {
            // Does a google image search for "test"
            Document doc1 = Jsoup.connect("https://www.google.com/search?q=" + s).get();
            Element media = doc1.select("img[data-src]").first();
            String sourceUrl = media.attr("abs:data-src");
            System.out.println(sourceUrl);

            URL url = new URL(sourceUrl);
            InputStream in = url.openStream();

            OutputStream out = new BufferedOutputStream(new FileOutputStream("idk.png"));
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public String toString() {
        return "Produse";
    }
    public void setActivity(boolean state) {
        setVisible(state);
    }
    public void doAction(Context context) {
        System.out.println("Player is in Produse");
        context.setState(this);
    }




}



