package com.avandy.dataset.ui;

import com.avandy.dataset.generator.Generator;
import com.avandy.dataset.util.Saver;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public class Gui extends JFrame {
    public static DefaultTableModel model;
    public static final String[] MAIN_TABLE_HEADERS = {"№", "Int", "Long", "Name", "Age", "Avg_grade", "Car", "Color", "Country"};
    public static JComboBox<String> saveFormatComboBox;
    private static final ImageIcon LOGO_ICON = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Gui.class.getResource("/icons/logo.png")));
    public static final ImageIcon CLEAR_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Gui.class.getResource("/icons/clear.png")));
    public static final ImageIcon EXPORT_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Gui.class.getResource("/icons/export.png")));
    private static final Font GUI_FONT = new Font("Tahoma", Font.PLAIN, 14);
    private static final String[] SAVE_FORMAT = new String[]{"csv", "txt"};
    private static JTextField rowsCount;
    private long start;
    private final JLabel statusLabel;

    public Gui() {
        setResizable(false);
        getContentPane().setBackground(new Color(233, 223, 178));
        setContentPane(new Background());
        setTitle("avandy-random-data-generator");
        setIconImage(LOGO_ICON.getImage());
        setFont(GUI_FONT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(370, 190, 1195, 600);
        getContentPane().setLayout(null);

        //Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 1160, 500);
        getContentPane().add(scrollPane);
        model = new DefaultTableModel(new Object[][]{
        }, MAIN_TABLE_HEADERS) {
            final boolean[] columnEditable = new boolean[]{
                    false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditable[column];
            }

            // Сортировка
            final Class[] types_unique = {Integer.class, Integer.class, Long.class, String.class, Integer.class,
                    Double.class, String.class, String.class, String.class};

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
        table.setFont(GUI_FONT);
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setMaxWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setMaxWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setMaxWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        table.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(table);

        // Создание строк
        JButton generateButton = new JButton("generate");
        generateButton.setBounds(80, 10, 90, 22);
        //generateButton.setIcon(icon);
        //generateButton.setBackground(new Color(190, 225, 255));
        generateButton.setFocusable(false);
        generateButton.setContentAreaFilled(false);
        generateButton.setBorderPainted(true);
        getContentPane().add(generateButton);
        generateButton.addActionListener(e -> {
            start = System.currentTimeMillis();
            new Generator().generate(rowsCount.getText());
            setStatus("rows created in " + (System.currentTimeMillis() - start) + " ms.");
        });

        /* RIGHT TOP */
        int rightTopX = 1032;
        int rightTopY = 10;

        // кнопка
        JButton getSelectedColumnDataButton = new JButton();
        getSelectedColumnDataButton.setIcon(CLEAR_BUTTON_ICON);
        getSelectedColumnDataButton.setFocusable(false);
        getSelectedColumnDataButton.setContentAreaFilled(false);
        getSelectedColumnDataButton.setBorderPainted(true);
        getSelectedColumnDataButton.setBounds(991, rightTopY, 36, 22);
        getContentPane().add(getSelectedColumnDataButton);
        getSelectedColumnDataButton.addActionListener(e -> {
            int[] selectedColumns = table.getSelectedColumns();

        });

        // Формат выгрузки
        saveFormatComboBox = new JComboBox<>();
        saveFormatComboBox.setBounds(rightTopX, rightTopY, 55, 22);
        saveFormatComboBox.setBackground(new Color(238, 238, 238));
        saveFormatComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        saveFormatComboBox.setEditable(false);
        saveFormatComboBox.setModel(new DefaultComboBoxModel<>(SAVE_FORMAT));
        this.getContentPane().add(saveFormatComboBox);

        // Выгрузка в файл
        JButton exportButton = new JButton();
        exportButton.setIcon(EXPORT_BUTTON_ICON);
        exportButton.setFocusable(false);
        exportButton.setContentAreaFilled(false);
        exportButton.setBorderPainted(true);
        exportButton.setBounds(rightTopX + 60, rightTopY, 36, 22);
        getContentPane().add(exportButton);
        exportButton.addActionListener(e -> {
            try {
                if (model.getRowCount() > 0) {
                    JFileChooser saver = new JFileChooser();
                    File file = new File(System.getProperty("user.home") +
                            System.getProperty("file.separator") + "Desktop");
                    saver.setCurrentDirectory(file);
                    int res = saver.showDialog(null, "Save");
                    if (res == JFileChooser.APPROVE_OPTION) {
                        start = System.currentTimeMillis();
                        new Saver().exportData(saver);
                        setStatus("Export completed in " + (System.currentTimeMillis() - start) + " ms.");
                    }
                } else {
                    setStatus("No data to export");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Очистка модели
        JButton clearButton = new JButton();
        clearButton.setIcon(CLEAR_BUTTON_ICON);
        clearButton.setFocusable(false);
        clearButton.setContentAreaFilled(false);
        clearButton.setBorderPainted(true);
        clearButton.setBounds(rightTopX + 101, rightTopY, 36, 22);
        getContentPane().add(clearButton);
        clearButton.addActionListener(e -> {
            if (model.getRowCount() > 0) {
                model.setRowCount(0);
            }
        });

        // Количество строк для генерации
        rowsCount = new JTextField();
        rowsCount.setBounds(10, 10, 64, 22);
        getContentPane().add(rowsCount);
        rowsCount.setText("1000");
        //rowsCount.setColumns(8);

        // Подпись
        JLabel labelSign = new JLabel("mrprogre");
        labelSign.setForeground(new Color(0, 0, 0));
        //labelSign.setEnabled(false);
        labelSign.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelSign.setBounds(1113, 543, 57, 14);
        getContentPane().add(labelSign);
        labelSign.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                labelSign.setForeground(new Color(40, 36, 180));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelSign.setForeground(new Color(0, 0, 0));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    String url = "https://github.com/mrprogre";
                    URI uri = null;
                    try {
                        uri = new URI(url);
                    } catch (URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                    Desktop desktop = Desktop.getDesktop();
                    assert uri != null;
                    try {
                        desktop.browse(uri);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Статус
        statusLabel = new JLabel();
        statusLabel.setBounds(180, 14, 300, 14);
        getContentPane().add(statusLabel);
        setVisible(true);
    }

    // Установка статуса для информативности
    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    // Фон UI
    static class Background extends JPanel {
        public void paintComponent(Graphics g) {
            try {
                Image im = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/background/gray.png")));
                g.drawImage(im, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}