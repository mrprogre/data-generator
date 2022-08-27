package com.avandy.dataset.ui;

import com.avandy.dataset.generator.Generator;
import com.avandy.dataset.util.Saver;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gui extends JFrame {
    public static DefaultTableModel model;
    public static final String[] MAIN_TABLE_HEADERS = {"№", "Int", "Long", "Name", "Age", "Avg_grade", "Car", "Color"};
    private static final String[] SAVE_FORMAT = new String[]{"csv", "txt"};
    private static JTextField rowsCount;
    private final JComboBox<String> saveFormatComboBox;

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
        table.getColumnModel().getColumn(4).setPreferredWidth(42);
        table.getColumnModel().getColumn(5).setMaxWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);

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
        getContentPane().add(generateButton);
        generateButton.addActionListener(e -> new Generator().generate(rowsCount.getText()));

        // Формат выгрузки
        saveFormatComboBox = new JComboBox<>();
        saveFormatComboBox.setBounds(1065, 10, 55, 22);
        saveFormatComboBox.setBackground(new Color(238, 238, 238));
        saveFormatComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        saveFormatComboBox.setEditable(false);
        saveFormatComboBox.setModel(new DefaultComboBoxModel<>(SAVE_FORMAT));
        this.getContentPane().add(saveFormatComboBox);

        // Выгрузка в файл
        JButton exportButton = new JButton("export");
        exportButton.setFocusable(false);
        exportButton.setContentAreaFilled(false);
        exportButton.setBorderPainted(true);
        exportButton.setBounds(1133, 10, 77, 22);
        getContentPane().add(exportButton);
        exportButton.addActionListener(e -> {
            try {
                if (Generator.rows.size() > 0) {
                    JFileChooser saver = new JFileChooser();
                    File file = new File(System.getProperty("user.home") +
                            System.getProperty("file.separator") + "Desktop");
                    saver.setCurrentDirectory(file);
                    int res = saver.showDialog(null, "Save");
                    if (res == JFileChooser.APPROVE_OPTION) {
                        new Saver().saveCsv(Generator.rows, saver.getSelectedFile() + "." + saveFormatComboBox.getSelectedItem());
                    }
                } else System.out.println("Нет данных для выгрузки");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Количество строк для генерации
        rowsCount = new JTextField();
        rowsCount.setBounds(10, 10, 64, 22);
        getContentPane().add(rowsCount);
        rowsCount.setText("1000");
        rowsCount.setColumns(10);

        setVisible(true);
    }
}