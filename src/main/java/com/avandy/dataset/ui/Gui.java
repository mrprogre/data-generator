package com.avandy.dataset.ui;

import com.avandy.dataset.export.Export;
import com.avandy.dataset.generator.Generator;
import com.avandy.dataset.util.Util;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

import static java.awt.GraphicsDevice.WindowTranslucency.TRANSLUCENT;

public class Gui extends JFrame {
    public static DefaultTableModel model;
    public static final String[] MAIN_TABLE_HEADERS = {"№", "Int", "Long", "Name", "Age", "Avg grade",
            "Car", "Color", "Country", "Orders", "Sales", "Last order", "Post"};
    public static JComboBox<String> saveFormatComboBox;
    public static JComboBox<String> rowsCountComboBox;
    private static final Font GUI_FONT = new Font("Tahoma", Font.PLAIN, 14);
    private static final String[] SAVE_FORMAT = new String[]{"csv", "txt"};
    private static final String[] ROWS_COUNT = new String[]{"1k", "10k", "100k", "500k"};
    private static JLabel statusLabel;
    private static final int BUTTON_WIDTH = 36;
    // Icons
    private static final ImageIcon LOGO_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/logo.png")));
    private static final ImageIcon CLEAR_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/clear.png")));
    private static final ImageIcon WHEN_MOUSE_ON_CLEAR_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/clear2.png")));
    private static final ImageIcon EXPORT_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/export.png")));
    private static final ImageIcon WHEN_MOUSE_ON_EXPORT_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/export2.png")));
    private static final ImageIcon START_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/start.png")));
    private static final ImageIcon WHEN_MOUSE_ON_START_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/start2.png")));
    private static final ImageIcon STOP_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/stop.png")));
    private static final ImageIcon WHEN_MOUSE_ON_STOP_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/stop2.png")));
    private static final ImageIcon EXIT_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/exit.png")));
    private static final ImageIcon WHEN_MOUSE_ON_EXIT_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/exit2.png")));
    private static final ImageIcon TRAY_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/tray.png")));
    private static final ImageIcon WHEN_MOUSE_ON_TRAY_BUTTON_ICON = new ImageIcon(Toolkit.getDefaultToolkit()
            .createImage(Gui.class.getResource("/icons/tray2.png")));
    private static final URL APP_IN_TRAY_BUTTON_ICON = Gui.class.getResource("/icons/tray3.png");


    public Gui() {
        setResizable(false);
        getContentPane().setBackground(new Color(139, 194, 224));
        setTitle("avandy-random-data-generator");
        setIconImage(LOGO_ICON.getImage());
        setFont(GUI_FONT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(260, 120, 1385, 671);
        getContentPane().setLayout(null);

        // Прозрачность и оформление окна
        this.setUndecorated(true);
        // Проверка поддерживает ли операционная система прозрачность окон
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isUniformTranslucencySupported = gd.isWindowTranslucencySupported(TRANSLUCENT);
        if (isUniformTranslucencySupported) this.setOpacity(0.90f);

        /* TOP LEFT */
        int topLeftX = 105;
        int topLeftY = 10;

        // Лейбл
        JLabel rowsGenerate = new JLabel("Generate rows: ");
        rowsGenerate.setBounds(topLeftX - 95, topLeftY + 4, 90, 14);
        getContentPane().add(rowsGenerate);
        labelAnimation(rowsGenerate);

        // Количество строк для генерации
        rowsCountComboBox = new JComboBox<>();
        rowsCountComboBox.setBounds(topLeftX, topLeftY, 56, 22);
        rowsCountComboBox.setBackground(new Color(238, 238, 238));
        rowsCountComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rowsCountComboBox.setEditable(false);
        rowsCountComboBox.setModel(new DefaultComboBoxModel<>(ROWS_COUNT));
        this.getContentPane().add(rowsCountComboBox);

        // Создание строк
        JButton generateButton = new JButton();
        generateButton.setToolTipText("generate data");
        generateButton.setIcon(START_BUTTON_ICON);
        generateButton.setBounds(topLeftX + 60, topLeftY, BUTTON_WIDTH, 22);
        generateButton.setFocusable(false);
        generateButton.setContentAreaFilled(false);
        generateButton.setBorderPainted(false);
        getContentPane().add(generateButton);

        generateButton.addActionListener(e -> {
            String row = Objects.requireNonNull(rowsCountComboBox.getSelectedItem()).toString();
            int rowsCount = Util.getRowsCount(row);
            new Thread(() -> new Generator().generate(rowsCount)).start();
        });
        iconAnimation(generateButton, START_BUTTON_ICON, WHEN_MOUSE_ON_START_BUTTON_ICON);

        // Статус
        statusLabel = new JLabel();
        statusLabel.setBounds(topLeftX + 100, topLeftY + 4, 300, 14);
        getContentPane().add(statusLabel);
        labelAnimation(statusLabel);

        /* TOP RIGHT */
        int topRightX = 1118;
        int topRightY = 10;

        // Лейбл
        JLabel exportLabel = new JLabel("Export data:");
        exportLabel.setBounds(topRightX - 77, topRightY + 4, 69, 14);
        getContentPane().add(exportLabel);
        labelAnimation(exportLabel);

        // Формат выгрузки
        saveFormatComboBox = new JComboBox<>();
        saveFormatComboBox.setBounds(topRightX, topRightY, 55, 22);
        saveFormatComboBox.setBackground(new Color(238, 238, 238));
        saveFormatComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        saveFormatComboBox.setEditable(false);
        saveFormatComboBox.setModel(new DefaultComboBoxModel<>(SAVE_FORMAT));
        this.getContentPane().add(saveFormatComboBox);

        // Выгрузка в файл
        JButton exportButton = new JButton();
        exportButton.setToolTipText("export data");
        exportButton.setIcon(EXPORT_BUTTON_ICON);
        exportButton.setFocusable(false);
        exportButton.setContentAreaFilled(false);
        exportButton.setBorderPainted(false);
        exportButton.setBounds(topRightX + 60, topRightY, BUTTON_WIDTH, 22);
        getContentPane().add(exportButton);
        exportButton.addActionListener(e -> {
            if (model.getRowCount() > 0) {
                JFileChooser saver = new JFileChooser();
                File file = new File(System.getProperty("user.home") +
                        System.getProperty("file.separator") + "Desktop");
                saver.setCurrentDirectory(file);
                int res = saver.showDialog(null, "Save");
                if (res == JFileChooser.APPROVE_OPTION) {
                    //new Export().exportData(saver);
                    new Thread(() -> {
                        try {
                            new Export().exportData(saver);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                }
            } else {
                setStatus("No data to export");
            }
        });
        iconAnimation(exportButton, EXPORT_BUTTON_ICON, WHEN_MOUSE_ON_EXPORT_BUTTON_ICON);

        // Остановка экспорта строк
        JButton stopGeneration = new JButton();
        stopGeneration.setToolTipText("export stop");
        stopGeneration.setIcon(STOP_BUTTON_ICON);
        stopGeneration.setFocusable(false);
        stopGeneration.setContentAreaFilled(false);
        stopGeneration.setBorderPainted(false);
        stopGeneration.setBounds(topRightX + 100, topRightY, BUTTON_WIDTH, 22);
        getContentPane().add(stopGeneration);
        stopGeneration.addActionListener(e -> {
            Export.isExportStop.set(true);
            setStatus("Stopped");
        });
        iconAnimation(stopGeneration, STOP_BUTTON_ICON, WHEN_MOUSE_ON_STOP_BUTTON_ICON);

        // Очистка модели
        JButton clearButton = new JButton();
        clearButton.setToolTipText("clear table");
        clearButton.setIcon(CLEAR_BUTTON_ICON);
        clearButton.setFocusable(false);
        clearButton.setContentAreaFilled(false);
        clearButton.setBorderPainted(false);
        clearButton.setBounds(topRightX + 143, topRightY, BUTTON_WIDTH, 22);
        getContentPane().add(clearButton);
        clearButton.addActionListener(e -> {
            if (model.getRowCount() > 0) {
                model.setRowCount(0);
            }
        });
        iconAnimation(clearButton, CLEAR_BUTTON_ICON, WHEN_MOUSE_ON_CLEAR_BUTTON_ICON);

        /* Сворачивание в трей */
        JButton toTrayBtn = new JButton(TRAY_BUTTON_ICON);
        toTrayBtn.setToolTipText("to tray");
        toTrayBtn.setFocusable(false);
        toTrayBtn.setContentAreaFilled(false);
        toTrayBtn.setBorderPainted(false);
        toTrayBtn.setBounds(topRightX + 190, topRightY + 2, 24, 22);
        if (SystemTray.isSupported()) {
            getContentPane().add(toTrayBtn);
        }
        toTrayBtn.addActionListener(e -> setVisible(false));
        iconAnimation(toTrayBtn, TRAY_BUTTON_ICON, WHEN_MOUSE_ON_TRAY_BUTTON_ICON);

        if (SystemTray.isSupported()) {
            try {
                BufferedImage iconTray = ImageIO.read(Objects.requireNonNull(APP_IN_TRAY_BUTTON_ICON));
                final TrayIcon trayIcon = new TrayIcon(iconTray, "Data Generator");
                SystemTray systemTray = SystemTray.getSystemTray();
                systemTray.add(trayIcon);

                final PopupMenu trayMenu = new PopupMenu();
                MenuItem iShow = new MenuItem("Show");
                iShow.addActionListener(e -> {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                });
                trayMenu.add(iShow);

                MenuItem iClose = new MenuItem("Close");
                iClose.addActionListener(e -> System.exit(0));
                trayMenu.add(iClose);

                trayIcon.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isLeftMouseButton(e)) {
                            setVisible(true);
                            setExtendedState(JFrame.NORMAL);
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            trayIcon.setPopupMenu(trayMenu);
                        }
                    }
                });
            } catch (IOException | AWTException e) {
                e.printStackTrace();
            }
        }

        // Exit button
        JButton exitBtn = new JButton(EXIT_BUTTON_ICON);
        exitBtn.setToolTipText("exit");
        exitBtn.setBounds(topRightX + 230, topRightY + 2, 24, 22);
        exitBtn.setContentAreaFilled(false);
        exitBtn.setBorderPainted(false);
        exitBtn.setFocusable(false);
        getContentPane().add(exitBtn);
        exitBtn.addActionListener((e) -> System.exit(0));
        iconAnimation(exitBtn, EXIT_BUTTON_ICON, WHEN_MOUSE_ON_EXIT_BUTTON_ICON);

        /* BOTTOM */
        // Подпись
        JLabel labelSign = new JLabel("mrprogre");
        labelSign.setForeground(new Color(0, 0, 0));
        //labelSign.setEnabled(false);
        labelSign.setFont(new Font("Tahoma", Font.BOLD, 11));
        labelSign.setBounds(1320, 651, 57, 14);
        getContentPane().add(labelSign);
        labelAnimation(labelSign);

        labelSign.addMouseListener(new MouseAdapter() {
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

        //Table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 1365, 608);
        getContentPane().add(scrollPane);
        model = new DefaultTableModel(new Object[][]{
        }, MAIN_TABLE_HEADERS) {
            final boolean[] columnEditable = new boolean[]{
                    false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditable[column];
            }

            // Сортировка
            final Class[] types_unique = {Integer.class, Integer.class, Long.class, String.class, Byte.class,
                    Double.class, String.class, String.class, String.class, Byte.class, Double.class,
                    LocalDate.class, String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return this.types_unique[columnIndex];
            }
        };
        JTable table = new JTable(model);
        //headers
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Tahoma", Font.BOLD, 13));
        // "№", "Int", "Long", "Name", "Age", "Avg grade", "Car", "Color", "Country", "Orders", "Sales", "Last order", "Post"
        //  0    1      2       3       4      5            6      7        8          9         10       11            12

        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(1).setMaxWidth(90);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setMaxWidth(160);
        table.getColumnModel().getColumn(2).setPreferredWidth(160);
        table.getColumnModel().getColumn(3).setMaxWidth(160);
        table.getColumnModel().getColumn(3).setPreferredWidth(160);
        table.getColumnModel().getColumn(4).setMaxWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setMaxWidth(90);
        table.getColumnModel().getColumn(5).setPreferredWidth(90);
        table.getColumnModel().getColumn(6).setMaxWidth(90);
        table.getColumnModel().getColumn(6).setPreferredWidth(90);
        table.getColumnModel().getColumn(7).setMaxWidth(90);
        table.getColumnModel().getColumn(7).setPreferredWidth(90);
        table.getColumnModel().getColumn(8).setMaxWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(150);
        table.getColumnModel().getColumn(9).setMaxWidth(60);
        table.getColumnModel().getColumn(9).setPreferredWidth(60);
        table.getColumnModel().getColumn(10).setMaxWidth(80);
        table.getColumnModel().getColumn(10).setPreferredWidth(80);
        table.getColumnModel().getColumn(11).setMaxWidth(90);
        table.getColumnModel().getColumn(11).setPreferredWidth(90);

        DefaultTableCellRenderer rendererCenter = new DefaultTableCellRenderer();
        rendererCenter.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(4).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(5).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(9).setCellRenderer(rendererCenter);
        table.getColumnModel().getColumn(11).setCellRenderer(rendererCenter);

        DefaultTableCellRenderer rendererLeft = new DefaultTableCellRenderer();
        rendererLeft.setHorizontalAlignment(JLabel.LEFT);
        table.getColumnModel().getColumn(1).setCellRenderer(rendererLeft);
        table.getColumnModel().getColumn(2).setCellRenderer(rendererLeft);
        table.getColumnModel().getColumn(3).setCellRenderer(rendererLeft);
        table.getColumnModel().getColumn(10).setCellRenderer(rendererLeft);

        table.setRowHeight(28);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setFont(GUI_FONT);
        table.setAutoCreateRowSorter(true);
        scrollPane.setViewportView(table);

        setVisible(true);
    }

    private void iconAnimation(JButton exitBtn, ImageIcon off, ImageIcon on) {
        exitBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitBtn.setIcon(on);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitBtn.setIcon(off);
            }
        });
    }

    private void labelAnimation(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(new Color(255, 236, 13));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(new Color(0, 0, 0));
            }
        });
    }

    // Установка статуса для информативности
    public static void setStatus(String status) {
        statusLabel.setText(status);
    }

}