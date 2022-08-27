package com.avandy.dataset.ui;

import com.avandy.dataset.generator.Generator;
import com.avandy.dataset.ui.buttons.SetButton;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Gui extends JFrame {
    public static DefaultTableModel model;
    private static final Object[] MAIN_TABLE_HEADERS = {"Int", "Long", "FIO", "Age", "Avg grade", "Car", "Color"};

    public Gui() {
        setResizable(false);
        getContentPane().setBackground(new Color(230, 255, 219));
        setTitle("Avandy Dataset Generator");
        //setIconImage(LOGO_ICON.getImage());
        //setFont(GUI_FONT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(510, 235, 900, 634);
        getContentPane().setLayout(null);

        //Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 860, 500);
        getContentPane().add(scrollPane);
        model = new DefaultTableModel(new Object[][]{
        }, MAIN_TABLE_HEADERS) {
            final boolean[] columnEditable = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditable[column];
            }

            // Сортировка
            final Class[] types_unique = {Integer.class, Long.class, String.class, Integer.class,
                    Double.class, String.class, String.class};

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types_unique[columnIndex];
            }
        };
        JTable table = new JTable(model);

        //headers
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 13));
        //Cell alignment
        DefaultTableCellRenderer Renderer = new DefaultTableCellRenderer();
        Renderer.setHorizontalAlignment(JLabel.CENTER);

        table.setAutoCreateRowSorter(true);
        table.setAutoCreateRowSorter(true);

//        table.getColumnModel().getColumn(0).setCellRenderer(Renderer);
        table.setRowHeight(28);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
//        table.getColumnModel().getColumn(0).setMaxWidth(40);
//        table.getColumnModel().getColumn(1).setPreferredWidth(100);
//        table.getColumnModel().getColumn(1).setMaxWidth(180);
//        table.getColumnModel().getColumn(2).setPreferredWidth(490);
//        table.getColumnModel().getColumn(3).setPreferredWidth(100);
//        table.getColumnModel().getColumn(3).setMaxWidth(100);
        scrollPane.setViewportView(table);

        // Выбор цвета шрифта в таблице
        JButton generateButton = new JButton("Generate");
        SetButton setButton = new SetButton(null, new Color(190, 225, 255), 750, 10, 120, 22);
        setButton.buttonSetting(generateButton, "Generate new dataset");

        generateButton.addActionListener(e -> {
            new Generator().generate();
        });
        getContentPane().add(generateButton);

        setVisible(true);
    }
}