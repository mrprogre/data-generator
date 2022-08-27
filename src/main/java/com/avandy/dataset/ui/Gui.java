package com.avandy.dataset.ui;

import com.avandy.dataset.generator.Generator;
import com.avandy.dataset.ui.buttons.SetButton;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Gui extends JFrame {
    public static JTextField rowsCount;
    public static DefaultTableModel model;
    private static final Object[] MAIN_TABLE_HEADERS = {"№", "Int", "Long", "FIO", "Age", "Avg grade", "Car", "Color"};

    public Gui() {
        setResizable(false);
        getContentPane().setBackground(new Color(255, 251, 201));
        setTitle("Avandy Dataset Generator");
        //setIconImage(LOGO_ICON.getImage());
        //setFont(GUI_FONT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(370, 190, 1240, 634);
        getContentPane().setLayout(null);

        //Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 1200, 500);
        getContentPane().add(scrollPane);
        model = new DefaultTableModel(new Object[][]{
        }, MAIN_TABLE_HEADERS) {
            final boolean[] columnEditable = new boolean[]{
                    false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditable[column];
            }

            // Сортировка
            final Class[] types_unique = {Integer.class, Integer.class, Long.class, String.class, Integer.class,
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
        DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer();
        rendererCenter.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(4).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(5).setCellRenderer(rendererCenter);

        DefaultTableCellRenderer rendererLeft = new DefaultTableCellRenderer();
        rendererLeft.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(1).setCellRenderer(rendererLeft);
        table.getColumnModel().getColumn(2).setCellRenderer(rendererLeft);
        table.getColumnModel().getColumn(3).setCellRenderer(rendererLeft);


        table.setRowHeight(28);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setMaxWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setMaxWidth(42);

        table.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(table);

        // Создание строк
        JButton generateButton = new JButton("generate");
        //SetButton setButton = new SetButton(null, new Color(190, 225, 255), 750, 10, 120, 22);
        //setButton.buttonSetting(generateButton, "Generate new dataset");
        generateButton.setBounds(80, 10, 90, 22);
        //generateButton.setIcon(icon);
        //generateButton.setBackground(new Color(190, 225, 255));
        generateButton.setFocusable(false);
        generateButton.setContentAreaFilled(false);
        generateButton.setBorderPainted(true);

        generateButton.addActionListener(e -> {
            new Generator().generate();
        });
        getContentPane().add(generateButton);

        // Выгрузка в файл
        JButton exportButton = new JButton("export");
        exportButton.setFocusable(false);
        exportButton.setContentAreaFilled(false);
        exportButton.setBorderPainted(true);
        exportButton.setBounds(180, 10, 77, 22);
        getContentPane().add(exportButton);

        // Количество строк для генерации
        rowsCount = new JTextField();
        rowsCount.setBounds(10, 10, 64, 22);
        getContentPane().add(rowsCount);
        rowsCount.setText("1000");
        rowsCount.setColumns(10);

        setVisible(true);
    }
}