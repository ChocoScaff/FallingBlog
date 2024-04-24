package fr.eseo.e3.poo.projet.blox.modele.main;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.PropertyChangeListener;
import java.text.*;
import javax.swing.tree.*;

public class Java_Swing_Library {

    // if width is 0 then the frame is maximized horizontally
    // if height is 0 then the frame is maximized vertically
    public static JFrame setupJFrameAndGet(String title, int width, int height) {
        int state = 0;
        JFrame tmpJF = new JFrame(title);
        if (width == 0) {
            state = state | JFrame.MAXIMIZED_HORIZ;
        }
        if (height == 0) {
            state = state | JFrame.MAXIMIZED_VERT;
        }
        if ((width != 0) || (height != 0)) {
            tmpJF.setSize(width, height);
        }
        tmpJF.setExtendedState(tmpJF.getExtendedState() | state);
        tmpJF.setLocationRelativeTo(null);
        tmpJF.setLayout(null);
        tmpJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return tmpJF;
    } // end of setupJFrameAndGet

    // width and height are the preferred width and height of JPanel
    public static ArrayList<Object> setupScrollableJFrameAndGetFrameAndPanel(String title, int width, int height) {
        JFrame tmpJF = new JFrame(title);
        tmpJF.setExtendedState(tmpJF.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        tmpJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //tmpJF.setLayout(null);

        JPanel tmpJP = new JPanel();
        //tmpJP.setBounds(xpos, ypos, width + 1000, height + 1000);
        tmpJP.setPreferredSize(new Dimension(width, height));
        tmpJP.setLayout(null);

        JScrollPane tmpJSPFrame = new JScrollPane(tmpJP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tmpJSPFrame.getHorizontalScrollBar().setUnitIncrement(10);
        tmpJSPFrame.getVerticalScrollBar().setUnitIncrement(10);
        tmpJF.add(tmpJSPFrame);

        ArrayList<Object> tmpA = new ArrayList<>();
        tmpA.add((Object) (tmpJF));
        tmpA.add((Object) (tmpJP));

        return tmpA;
    } // end of setupScrollableJFrameAndGetFrameAndPanel

    // actLisObj: object which implements action listener
    public static JButton setupJButtonAndGet(String text, Object actLisObj, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JButton tmpJB = new JButton(text);
        if (setBoundsFlag == true) {
            tmpJB.setBounds(xpos, ypos, width, height);
        }
        tmpJB.addActionListener((ActionListener) actLisObj);
        return tmpJB;
    } // end of setupJButtonAndGet

    // halign: horizontal alignment of text, valign: vertical alignment of text
    public static JLabel setupJLabelAndGet(String text, boolean opaque, Color bg, int halign, int valign, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JLabel tmpJL = new JLabel(text);
        if (setBoundsFlag == true) {
            tmpJL.setBounds(xpos, ypos, width, height);
        }
        tmpJL.setOpaque(opaque);
        if (bg != null) {
            tmpJL.setBackground(bg);
        }
        tmpJL.setHorizontalAlignment(halign);
        tmpJL.setVerticalAlignment(valign);
        return tmpJL;
    } // end of setupJlabelAndGet

    public static JTextField setupJTextFieldAndGet(int xpos, int ypos, int width, int height) {
        JTextField tmpJTF = new JTextField();
        tmpJTF.setBounds(xpos, ypos, width, height);
        return tmpJTF;
    } // end of setupJTextFieldAndGet

    public static JFormattedTextField setupJFormattedTextFieldAndGet(Format fmt, Object initialVal, Object propertyChangeLis, String propertyToListenFor, int xpos, int ypos, int width, int height) {
        JFormattedTextField tmpJFTF = new JFormattedTextField(fmt);
        tmpJFTF.setValue(initialVal);
        tmpJFTF.addPropertyChangeListener(propertyToListenFor, (PropertyChangeListener) propertyChangeLis);
        tmpJFTF.setBounds(xpos, ypos, width, height);
        return tmpJFTF;
    } // end of setupJFormattedTextFieldAndGet

    // itemLisObj: object which implements item listener
    public static JCheckBox setupJCheckBoxAndGet(String text, boolean state, Object itemLisObj, int xpos, int ypos, int width, int height) {
        JCheckBox tmpJCB = new JCheckBox(text, state);
        tmpJCB.setBounds(xpos, ypos, width, height);
        tmpJCB.addItemListener((ItemListener) itemLisObj);
        return tmpJCB;
    } // end of setupJCheckBoxAndGet

    // actLisObj: object which implements action listener
    public static JRadioButton setupJRadioButtonAndGet(String text, boolean state, Object actLisObj, int xpos, int ypos, int width, int height) {
        JRadioButton tmpJRB = new JRadioButton(text, state);
        tmpJRB.setBounds(xpos, ypos, width, height);
        tmpJRB.addActionListener((ActionListener) actLisObj);
        return tmpJRB;
    } // end of setupJRadioButtonAndGet

    public static ButtonGroup setupButtonGroupAndGet() {
        ButtonGroup tmpBG = new ButtonGroup();
        return tmpBG;
    } // end of setupButtonGroupAndGet

    public static JPasswordField setupJPasswordFieldAndGet(int xpos, int ypos, int width, int height) {
        JPasswordField tmpJPF = new JPasswordField();
        tmpJPF.setBounds(xpos, ypos, width, height);
        return tmpJPF;
    } // end of setupJPasswordFieldAndGet

    public static JTextArea setupJTextAreaAndGet(String text, int rows, int columns, boolean setEditableFlag, boolean setLineWrapFlag, boolean setWrapStyleWordFlag, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JTextArea tmpJTA = new JTextArea(text, rows, columns);
        tmpJTA.setEditable(setEditableFlag);
        tmpJTA.setLineWrap(setLineWrapFlag);
        tmpJTA.setWrapStyleWord(setWrapStyleWordFlag);
        if (setBoundsFlag == true) {
            tmpJTA.setBounds(xpos, ypos, width, height);
        }
        return tmpJTA;
    } // end of setupJTextAreaAndGet

    public static JScrollPane setupScrollableJTextAreaAndGet(JTextArea jta, int xpos, int ypos, int width, int height) {
        JScrollPane tmpJSP = new JScrollPane(jta);
        tmpJSP.setBounds(xpos, ypos, width, height);
        return tmpJSP;
    } // end of setupScrollableJTextAreaAndGet

    public static JList<String> setupJListAndGet(ListModel<String> lm, int selectionMode, int visibleRowCount, int initialSelectedIndex, Object listSelLisObj, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JList<String> tmpJList = new JList<String>(lm);
        tmpJList.setSelectionMode(selectionMode);
        tmpJList.setVisibleRowCount(visibleRowCount);
        if (initialSelectedIndex >= 0) {
            tmpJList.setSelectedIndex(initialSelectedIndex);
        }
        tmpJList.addListSelectionListener((ListSelectionListener) listSelLisObj);
        if (setBoundsFlag == true) {
            tmpJList.setBounds(xpos, ypos, width, height);
        }
        return tmpJList;
    } // end of setupJListAndGet

    public static JScrollPane setupScrollableJListAndGet(JList jlist, int xpos, int ypos, int width, int height) {
        JScrollPane tmpJSP = new JScrollPane(jlist);
        tmpJSP.setBounds(xpos, ypos, width, height);
        return tmpJSP;
    } // end of setupScrollableJListAndGet

    public static JComboBox<String> setupJComboBoxAndGet(ComboBoxModel<String> cbm, int initialSelectedIndex, Object actLisObj, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JComboBox<String> tmpJComboBox = new JComboBox<String>(cbm);
        if (initialSelectedIndex >= 0) {
            tmpJComboBox.setSelectedIndex(initialSelectedIndex);
        }
        tmpJComboBox.addActionListener((ActionListener) actLisObj);
        if (setBoundsFlag == true) {
            tmpJComboBox.setBounds(xpos, ypos, width, height);
        }
        return tmpJComboBox;
    } // end of setupJComboBoxAndGet

    public static JProgressBar setupJProgressBarAndGet(int orientation, int min, int max, int initialVal, boolean borderPaintedFlag, boolean stringPaintedFlag, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JProgressBar tmpJPB = new JProgressBar(orientation, min, max);
        tmpJPB.setValue(initialVal);
        tmpJPB.setBorderPainted(borderPaintedFlag);
        tmpJPB.setStringPainted(stringPaintedFlag);
        if (setBoundsFlag == true) {
            tmpJPB.setBounds(xpos, ypos, width, height);
        }
        return tmpJPB;
    } // end of setupJProgressBarAndGet

    public static JSlider setupJSliderAndGet(int orientation, int min, int max, int initialVal, int minorTickSpacing, int majorTickSpacing, boolean paintTicksFlag, boolean paintLabelsFlag, Object changeLisObj, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JSlider tmpJS = new JSlider(orientation, min, max, initialVal);
        tmpJS.setMinorTickSpacing(minorTickSpacing);
        tmpJS.setMajorTickSpacing(majorTickSpacing);
        tmpJS.setPaintTicks(paintTicksFlag);
        tmpJS.setPaintLabels(paintLabelsFlag);
        tmpJS.addChangeListener((ChangeListener) changeLisObj);
        if (setBoundsFlag == true) {
            tmpJS.setBounds(xpos, ypos, width, height);
        }
        return tmpJS;
    } // end of setupJSliderAndGet

    public static JTree setupJTreeAndGet(DefaultMutableTreeNode rootNode, int selectionMode, Object treeSelLisObj, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JTree tmpJTree = new JTree(rootNode);
        tmpJTree.getSelectionModel().setSelectionMode(selectionMode);
        tmpJTree.addTreeSelectionListener((TreeSelectionListener) treeSelLisObj);
        if (setBoundsFlag == true) {
            tmpJTree.setBounds(xpos, ypos, width, height);
        }
        return tmpJTree;
    } // end of setupJTreeAndGet

    public static JScrollPane setupScrollableJTreeAndGet(JTree jtree, int xpos, int ypos, int width, int height) {
        JScrollPane tmpJSP = new JScrollPane(jtree);
        tmpJSP.setBounds(xpos, ypos, width, height);
        return tmpJSP;
    } // end of setupScrollableJTreeAndGet

    public static JSpinner setupJSpinnerAndGet(SpinnerModel sm, boolean editableFlag, Object spinnerChangeLisObj, int xpos, int ypos, int width, int height) {
        JSpinner tmpJSPN = new JSpinner(sm);
        tmpJSPN.addChangeListener((ChangeListener) spinnerChangeLisObj);
        if (editableFlag == false) {
            JComponent editor = tmpJSPN.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                ((JSpinner.DefaultEditor) editor).getTextField().setEditable(editableFlag);
            } else {
                System.out.println("Error: Could not set editableFlag for JSpinner.");
            }
        }
        tmpJSPN.setBounds(xpos, ypos, width, height);
        return tmpJSPN;
    } // end of setupJSpinnerAndGet

    public static JColorChooser setupJColorChooserAndGet(Color initialColor, boolean borderTitleFlag, String borderTitle, Object colorChooserChangeLisObj, int xpos, int ypos, int width, int height) {
        JColorChooser tmpJCC = new JColorChooser(initialColor);
        tmpJCC.getSelectionModel().addChangeListener((ChangeListener) colorChooserChangeLisObj);
        if (borderTitleFlag == true) {
            tmpJCC.setBorder(BorderFactory.createTitledBorder(borderTitle));
        }
        tmpJCC.setBounds(xpos, ypos, width, height);
        return tmpJCC;
    } // end of setupJColorChooserAndGet

    public static JDialog setupJDialogAndGet(Frame owner, String title, boolean modal, int width, int height) {
        JDialog tmpJD = new JDialog(owner, title, modal);
        tmpJD.setSize(width, height);
        tmpJD.setLocationRelativeTo(null);
        tmpJD.setLayout(null);
        tmpJD.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return tmpJD;
    } // end of setupJDialogAndGet

    public static ArrayList<Object> setupScrollableJDialogAndGetDialogAndPanel(Frame owner, String title, boolean modal, int dialogWidth, int dialogHeight, int panelWidth, int panelHeight) {
        JDialog tmpJD = new JDialog(owner, title, modal);
        tmpJD.setSize(dialogWidth, dialogHeight);
        tmpJD.setLocationRelativeTo(null);
        tmpJD.setLayout(null);
        tmpJD.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel tmpJP = new JPanel();
        tmpJP.setPreferredSize(new Dimension(panelWidth, panelHeight));
        tmpJP.setLayout(null);

        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        sp.getHAdjustable().setUnitIncrement(10);
        sp.getVAdjustable().setUnitIncrement(10);
        sp.add(tmpJP);
        tmpJD.getRootPane().setContentPane(sp);

        ArrayList<Object> tmpA = new ArrayList<>();
        tmpA.add((Object) (tmpJD));
        tmpA.add((Object) (tmpJP));

        return tmpA;
    } // end of setupScrollableJDialogAndGetDialogAndPanel

    public static JToggleButton setupJToggleButtonAndGet(String text, Object itemLisObj, boolean opaque, Color bgcolor, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JToggleButton tmpJTB = new JToggleButton(text);
        if (setBoundsFlag == true) {
            tmpJTB.setBounds(xpos, ypos, width, height);
        }
        tmpJTB.addItemListener((ItemListener) itemLisObj);
        tmpJTB.setOpaque(opaque);
        tmpJTB.setBackground(bgcolor);
        return tmpJTB;
    } // end of setupJToggleButtonAndGet

    public static JSeparator setupJSeparatorAndGet(int orientation, Color bgcolor, boolean setBoundsFlag, int xpos, int ypos, int width, int height) {
        JSeparator tmpJS = new JSeparator(orientation);
        tmpJS.setBackground(bgcolor);
        if (setBoundsFlag == true) {
            tmpJS.setBounds(xpos, ypos, width, height);
        }
        return tmpJS;
    } // end of setupJSeparatorAndGet

    public static JMenuBar setupJMenuBarAndGet(Color fgcolor, Color bgcolor) {
        JMenuBar tmpJMB = new JMenuBar();
        tmpJMB.setOpaque(true);
        tmpJMB.setForeground(fgcolor);
        tmpJMB.setBackground(bgcolor);
        return tmpJMB;
    } // end of setupJMenuBarAndGet

    public static JMenu setupJMenuAndGet(String text, Color fgcolor, Color bgcolor) {
        JMenu tmpJM = new JMenu(text);
        tmpJM.setOpaque(true);
        tmpJM.setForeground(fgcolor);
        tmpJM.setBackground(bgcolor);
        return tmpJM;
    } // end of setupJMenuAndGet

    public static JMenuItem setupJMenuItemAndGet(String text, Object actLisObj, KeyStroke k, Color fgcolor, Color bgcolor) {
        JMenuItem tmpJMI = new JMenuItem(text);
        tmpJMI.setOpaque(true);
        tmpJMI.setForeground(fgcolor);
        tmpJMI.setBackground(bgcolor);
        tmpJMI.setAccelerator(k);
        if (actLisObj != null) {
            tmpJMI.addActionListener((ActionListener) actLisObj);
        }
        return tmpJMI;
    } // end of setupJMenuItemAndGet

} // end of Java_Swing_Library
