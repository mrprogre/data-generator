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
    public static final String[] MAIN_TABLE_HEADERS = {"№", "Int", "Long", "Name", "Age", "Avg_grade", "Car", "Color"};
    private static final ImageIcon LOGO_ICON = new ImageIcon(Toolkit.getDefaultToolkit().createImage(Gui.class.getResource("/icons/logo.png")));
    private static final Font GUI_FONT = new Font("Tahoma", Font.PLAIN, 14);
    private static final String[] SAVE_FORMAT = new String[]{"csv", "txt"};
    private static JTextField rowsCount;
    private final JComboBox<String> saveFormatComboBox;
    private JLabel generateTime;
    private long startGenerate;
    private long endGenerate;

    public Gui() {
        setResizable(false);
        getContentPane().setBackground(new Color(178, 233, 231));
        this.setContentPane(new Background());
        setTitle("avandy-data-generator");
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
            startGenerate = System.currentTimeMillis();
            new Generator().generate(rowsCount.getText());
            endGenerate = System.currentTimeMillis();
            generateTime.setText((endGenerate - startGenerate) + " ms.");
        });

        // Время генерации
        generateTime = new JLabel("0 ms.");
        generateTime.setBounds(180, 14, 60, 14);
        getContentPane().add(generateTime);

        // Формат выгрузки
        saveFormatComboBox = new JComboBox<>();
        saveFormatComboBox.setBounds(1028, 10, 55, 22);
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
        exportButton.setBounds(1093, 10, 77, 22);
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

        //My sign
        JLabel labelSign = new JLabel("mrprogre");
        labelSign.setForeground(new Color(0, 0, 0));
        //labelSign.setEnabled(false);
        labelSign.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelSign.setBounds(1113, 543, 57, 14);
        getContentPane().add(labelSign);

        labelSign.addMouseListener(new MouseAdapter() {
            // наведение мышки на письмо
            @Override
            public void mouseEntered(MouseEvent e) {
                labelSign.setForeground(new Color(40, 36, 180));
            }

            // убрали мышку с письма
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

        setVisible(true);
    }

    static class Background extends JPanel {
        public void paintComponent(Graphics g) {
            try {
                Image im = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("/background/gray.png"))); //gray.png
                g.drawImage(im, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}