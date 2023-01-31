package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.URL;
import java.sql.*;

public class Produse extends Window {


    Connection connection;
    DefaultTableModel tableModel;
    JTable table;
    Statement statement;
    int number=30;

    ImageButton back = new ImageButton("Main Menu", "C:/Users/Szilard/Desktop/MAN/Cancel.png");

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

    public void viewData() {
        String[] columnNames = {"id", "nume", "firma", "pret", "tva", "pret_final", "nr_articole", "Up", "Down"};

        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false

                if (column == 1) {
                    return false;
                } else {
                    return true;
                }
            }

            public void setValueAt(Object value, int row, int col) {

                fireTableCellUpdated(row, col);
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

                String[] data = {String.valueOf(id), name, firma, String.valueOf(pret), String.valueOf(tva), String.valueOf(pret_final), String.valueOf(nr_articole)};
                tableModel.addRow(data);
            }
            tableSetup();

            System.out.println("value is " + tableModel.getValueAt(0,6));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    private void updateRow(int row)
    {
              DefaultTableModel model = (DefaultTableModel) table.getModel();
              //  model.removeRow(row);
              try{

                      int id = Integer.valueOf(model.getValueAt(row,0).toString());
                      String firma = model.getValueAt(row,1).toString();
                      String name = model.getValueAt(row,2).toString();
                      int pret = Integer.valueOf(model.getValueAt(row,3).toString());
                      float tva = Float.valueOf(model.getValueAt(row,4).toString());
                      float pret_final = Float.valueOf(model.getValueAt(row,5).toString());
                      int nr_articole = Integer.valueOf(model.getValueAt(row,6).toString());

                   String updateQuery="UPDATE 'inventar' SET 'id'='"+id+"', 'firma'='"+firma+"' , 'name'='"+name+"', 'pret'='"+pret+"', 'tva'='"+tva+"', 'pret_final'='"+pret_final+"','nr_articole'='"+nr_articole+"' ";
                      statement.addBatch(updateQuery);

                  int [] updatedRow= statement.executeBatch();

              } catch (SQLException e) {
                  e.printStackTrace();
              }
    }*/
    public void tableSetup(){
       table = new JTable(tableModel);
        table.getModel().addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                TableModel model = (TableModel)e.getSource();
                Object data = model.getValueAt(row, column);
                System.out.println("im gonna kms " + data);
                //it shows where it has changed
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(36, 37, 800, 1200);

      //  TableCellRenderer buttonRenderer = new ButtonRenderer();


        ButtonEditor up = new ButtonEditor(new JTextField());
        ButtonEditor down = new ButtonEditor(new JTextField());


        table.getColumnModel().getColumn(7).setCellRenderer(new ButtonRenderer());;
        table.getColumnModel().getColumn(7).setCellEditor(up);
        table.getColumnModel().getColumn(8).setCellRenderer(new ButtonRenderer());;
        table.getColumnModel().getColumn(8).setCellEditor(down);

        up.btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                    //getmouse pos
                int rowIndex = table.getSelectedRow();
                int colIndex = table.getSelectedColumn();
                substract(rowIndex);
             //   updateRow(rowIndex);

            }
        });
        down.btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //getmouse pos
                int rowIndex = table.getSelectedRow();
                int colIndex = table.getSelectedColumn();
                add();

            }
        });

        getContentPane().add(scrollPane);
    }
    public void substract(int row){

        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "password2002");
            String query = "update inventar set nr_articole=? where id=? ";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps = connection.prepareStatement(query);



            ps.setInt(1, number--);
            ps.setInt(2, 1);
            ps.executeUpdate();

            System.out.println("Record is updated successfully......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tableModel.getValueAt(0,6));
        System.out.println(tableModel.getValueAt(0,5));
        System.out.println(tableModel.getValueAt(0,4));
        System.out.println(tableModel.getValueAt(0,3));
        System.out.println(tableModel.getValueAt(0,2));
        System.out.println(tableModel.getValueAt(0,1));
        System.out.println(tableModel.getValueAt(0,0));


        // tableModel.setValueAt(1,0,6);
       viewData();
       // tableSetup();


    }

    public void add(){

        try {

            //  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "password2002");
            String query = "update inventar set nr_articole=? where id=? ";
            PreparedStatement ps  = connection.prepareStatement(query);
            ps = connection.prepareStatement(query);
            ps.setInt(1, number++);
            ps.setInt(2, 1);
            ps.executeUpdate();

            System.out.println("Record is updated successfully......");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tableModel.getValueAt(0,6));
        System.out.println(tableModel.getValueAt(0,5));
        System.out.println(tableModel.getValueAt(0,4));
        System.out.println(tableModel.getValueAt(0,3));
        System.out.println(tableModel.getValueAt(0,2));
        System.out.println(tableModel.getValueAt(0,1));
        System.out.println(tableModel.getValueAt(0,0));


        // tableModel.setValueAt(1,0,6);
        viewData();
        tableSetup();

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



