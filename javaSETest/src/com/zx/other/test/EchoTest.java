package com.zx.other.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class EchoTest{
  private static long count = 1L;
  private static String fn = "";
  private static Display display;
  private static Shell shell;
  private static Menu mainMenu;
  private static MenuItem mainMenuItemFile;
  private static Menu fileMenu;
  private static MenuItem newFile;
  private static MenuItem openFile;
  private static MenuItem saveFile;
  private static MenuItem sendFile;
  private static MenuItem uploadFile;
  private static MenuItem exit;
  
  private static MenuItem mainMenuItemEdit;
  private static Menu editMenu;
  private static MenuItem copyContent;
  private static MenuItem cutContent;
  private static MenuItem pasteContent;
  private static Composite mainBoard;
  private static TabFolder tabFunc;
  private static final String block1Sign = ";;====================Basic Information====================";
  private static final String block2Sign = ";;====================Varibles & Formulas====================";
  private static final String block3Sign = ";;====================GUI====================";
  private static final String block4Sign = ";;====================PCI calculations====================";
  private static final String block5Sign = ";;====================Configuration Definition====================";
  private static final String block6Sign = ";;====================PCI definitions====================";
  private static final String block7Sign = ";;====================Configuration Annotations====================";
  private static final String block8Sign = ";;====================Configuration Meta Attributes====================";
  private static final String block9Sign = ";;====================Indicators====================";
  private static final String tabFunc1Name = "Basic Information";
  private static final String tabFunc2Name = "Varibles";
  private static final String tabFunc3Name = "GUI";
  private static final String tabFunc4Name = "PCI Calculation";
  private static final String tabFunc5Name = "Configuration Definition";
  private static final String tabFunc6Name = "PCI Definition";
  private static final String tabFunc7Name = "Annotations";
  private static final String tabFunc8Name = "Meta Attributes";
  private static final String tabFunc9Name = "Indicators";
  private static Text basicInformationText;
  private static Text variblesText;
  private static Text GUIText;
  private static Text PCINoText;
  private static Text conDefinitionText;
  private static Text PCIDefinitionText;
  private static Text conAnnotationText;
  private static Text conMetaAttributeText;
  private static Text indicatorText;
  
  public EchoTest()
  {
    display = new Display();
    shell = new Shell(display);
    shell.setText("Echo");
    shell.setLayout(new FormLayout());
    
    FormData formData = new FormData();
    
    formData.top = new FormAttachment(0, 0);
    
    formData.left = new FormAttachment(0, 0);
    
    formData.bottom = new FormAttachment(100, 0);
    
    formData.right = new FormAttachment(100, 0);
    
    mainMenu = new Menu(shell, SWT.BAR);
    shell.setMenuBar(mainMenu);

    mainMenuItemFile = new MenuItem(mainMenu, SWT.CASCADE);
    mainMenuItemFile.setText("File");
    
    fileMenu = new Menu(shell, SWT.DROP_DOWN);
    
    newFile = new MenuItem(fileMenu, 8);
    newFile.setText("New");
    
    openFile = new MenuItem(fileMenu, 8);
    openFile.setText("Open");
    
    saveFile = new MenuItem(fileMenu, 8);
    saveFile.setText("Save");
    
    sendFile = new MenuItem(fileMenu, 8);
    sendFile.setText("Send In E-mail");
    
    uploadFile = new MenuItem(fileMenu, 8);
    uploadFile.setText("Upload");
    
    exit = new MenuItem(fileMenu, 8);
    exit.setText("Exit");
    
    fileMenu.setDefaultItem(newFile);
    mainMenuItemFile.setMenu(fileMenu);
    
    mainMenuItemEdit=new MenuItem(mainMenu, SWT.CASCADE);
    mainMenuItemEdit.setText("Edit");
    editMenu=new Menu(shell,SWT.DROP_DOWN);

    cutContent=new MenuItem(editMenu, 8);
    cutContent.setText("cut");
    copyContent=new MenuItem(editMenu, 8);
    copyContent.setText("copy");
    pasteContent=new MenuItem(editMenu, 8);
    pasteContent.setText("paste");
    
    mainMenuItemEdit.setMenu(editMenu);
    
    mainBoard = new Composite(shell, 0);
    mainBoard.setBounds(0, 0, shell.getClientArea().width, shell.getClientArea().height);
    
    tabFunc = new TabFolder(mainBoard, 0);
    tabFunc.setBounds(0, 0, mainBoard.getClientArea().width, mainBoard.getClientArea().height);
    
    TabItem tabFunc1 = new TabItem(tabFunc, 0);
    tabFunc1.setText("Basic Information");
    
    Composite comp1 = new Composite(tabFunc, 0);
    tabFunc1.setControl(comp1);
    basicInformationText = new Text(comp1, 2626);
    basicInformationText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc2 = new TabItem(tabFunc, 0);
    tabFunc2.setText("Varibles");
    
    Composite comp2 = new Composite(tabFunc, 0);
    tabFunc2.setControl(comp2);
    variblesText = new Text(comp2, 2626);
    variblesText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc3 = new TabItem(tabFunc, 0);
    tabFunc3.setText("GUI");
    
    Composite comp3 = new Composite(tabFunc, 0);
    tabFunc3.setControl(comp3);
    GUIText = new Text(comp3, 2626);
    GUIText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc4 = new TabItem(tabFunc, 0);
    tabFunc4.setText("PCI Calculation");
    
    Composite comp4 = new Composite(tabFunc, 0);
    tabFunc4.setControl(comp4);
    PCINoText = new Text(comp4, 2626);
    PCINoText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc5 = new TabItem(tabFunc, 0);
    tabFunc5.setText("Configuration Definition");
    
    Composite comp5 = new Composite(tabFunc, 0);
    tabFunc5.setControl(comp5);
    conDefinitionText = new Text(comp5, 2626);
    conDefinitionText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc6 = new TabItem(tabFunc, 0);
    tabFunc6.setText("PCI Definition");
    
    Composite comp6 = new Composite(tabFunc, 0);
    tabFunc6.setControl(comp6);
    PCIDefinitionText = new Text(comp6, 2626);
    PCIDefinitionText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc7 = new TabItem(tabFunc, 0);
    tabFunc7.setText("Annotations");
    
    Composite comp7 = new Composite(tabFunc, 0);
    tabFunc7.setControl(comp7);
    conAnnotationText = new Text(comp7, 2626);
    conAnnotationText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc8 = new TabItem(tabFunc, 0);
    tabFunc8.setText("Meta Attributes");
    
    Composite comp8 = new Composite(tabFunc, 0);
    tabFunc8.setControl(comp8);
    conMetaAttributeText = new Text(comp8, 2626);
    conMetaAttributeText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    TabItem tabFunc9 = new TabItem(tabFunc, 0);
    tabFunc9.setText("Indicators");
    
    Composite comp9 = new Composite(tabFunc, 0);
    tabFunc9.setControl(comp9);
    indicatorText = new Text(comp9, 2626);
    indicatorText.setBounds(0, 0, tabFunc.getClientArea().width, tabFunc.getClientArea().height);
    
    newFile.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent event)
      {
        EchoTest.fn = "";
        try
        {
          File file = new File("./attachments/Template.func");
          FileInputStream fis = new FileInputStream(file);
          BufferedReader in = new BufferedReader(new InputStreamReader(fis));
          EchoTest.basicInformationText.setText("");
          EchoTest.variblesText.setText("");
          EchoTest.GUIText.setText("");
          EchoTest.PCINoText.setText("");
          EchoTest.conDefinitionText.setText("");
          EchoTest.PCIDefinitionText.setText("");
          EchoTest.conAnnotationText.setText("");
          EchoTest.conMetaAttributeText.setText("");
          EchoTest.indicatorText.setText("");
          
          String s = null;
          int blockNum = 0;
          while ((s = in.readLine()) != null)
          {
            if (s.equals(";;====================Basic Information====================")) {
              blockNum = 1;
            }
            if (s.equals(";;====================Varibles & Formulas====================")) {
              blockNum = 2;
            }
            if (s.equals(";;====================GUI====================")) {
              blockNum = 3;
            }
            if (s.equals(";;====================PCI calculations====================")) {
              blockNum = 4;
            }
            if (s.equals(";;====================Configuration Definition====================")) {
              blockNum = 5;
            }
            if (s.equals(";;====================PCI definitions====================")) {
              blockNum = 6;
            }
            if (s.equals(";;====================Configuration Annotations====================")) {
              blockNum = 7;
            }
            if (s.equals(";;====================Configuration Meta Attributes====================")) {
              blockNum = 8;
            }
            if (s.equals(";;====================Indicators====================")) {
              blockNum = 9;
            }
            if (blockNum == 1) {
              EchoTest.basicInformationText.append(s + "\r\n");
            }
            if (blockNum == 2) {
              EchoTest.variblesText.append(s + "\r\n");
            }
            if (blockNum == 3) {
              EchoTest.GUIText.append(s + "\r\n");
            }
            if (blockNum == 4) {
              EchoTest.PCINoText.append(s + "\r\n");
            }
            if (blockNum == 5) {
              EchoTest.conDefinitionText.append(s + "\r\n");
            }
            if (blockNum == 6) {
              EchoTest.PCIDefinitionText.append(s + "\r\n");
            }
            if (blockNum == 7) {
              EchoTest.conAnnotationText.append(s + "\r\n");
            }
            if (blockNum == 8) {
              EchoTest.conMetaAttributeText.append(s + "\r\n");
            }
            if (blockNum == 9) {
              EchoTest.indicatorText.append(s + "\r\n");
            }
          }
          EchoTest.shell.setText(EchoTest.count++ + ".func");
          in.close();
        }
        catch (FileNotFoundException e)
        {
          e.printStackTrace();
          EchoTest.this.alertMsg(EchoTest.shell, "Found No Template File!", "Warning!");
        }
        catch (Exception e)
        {
          e.printStackTrace();
          EchoTest.this.alertMsg(EchoTest.shell, "Failed To Create A New File", "Error!");
        }
      }
    });
    openFile.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent event)
      {
        FileDialog dialog = new FileDialog(EchoTest.shell, 4096);
        String fileName = dialog.open();
        try
        {
          if (fileName != null)
          {
            FileInputStream fis = new FileInputStream(fileName);
            EchoTest.basicInformationText.setText("");
            EchoTest.variblesText.setText("");
            EchoTest.GUIText.setText("");
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String s = null;
            int blockNum = 0;
            while ((s = in.readLine()) != null)
            {
              if (s.equals(";;====================Basic Information====================")) {
                blockNum = 1;
              }
              if (s.equals(";;====================Varibles & Formulas====================")) {
                blockNum = 2;
              }
              if (s.equals(";;====================GUI====================")) {
                blockNum = 3;
              }
              if (s.equals(";;====================PCI calculations====================")) {
                blockNum = 4;
              }
              if (s.equals(";;====================Configuration Definition====================")) {
                blockNum = 5;
              }
              if (s.equals(";;====================PCI definitions====================")) {
                blockNum = 6;
              }
              if (s.equals(";;====================Configuration Annotations====================")) {
                blockNum = 7;
              }
              if (s.equals(";;====================Configuration Meta Attributes====================")) {
                blockNum = 8;
              }
              if (s.equals(";;====================Indicators====================")) {
                blockNum = 9;
              }
              if (blockNum == 1) {
                EchoTest.basicInformationText.append(s + "\r\n");
              }
              if (blockNum == 2) {
                EchoTest.variblesText.append(s + "\r\n");
              }
              if (blockNum == 3) {
                EchoTest.GUIText.append(s + "\r\n");
              }
              if (blockNum == 4) {
                EchoTest.PCINoText.append(s + "\r\n");
              }
              if (blockNum == 5) {
                EchoTest.conDefinitionText.append(s + "\r\n");
              }
              if (blockNum == 6) {
                EchoTest.PCIDefinitionText.append(s + "\r\n");
              }
              if (blockNum == 7) {
                EchoTest.conAnnotationText.append(s + "\r\n");
              }
              if (blockNum == 8) {
                EchoTest.conMetaAttributeText.append(s + "\r\n");
              }
              if (blockNum == 9) {
                EchoTest.indicatorText.append(s + "\r\n");
              }
            }
            EchoTest.fn = fileName;
            EchoTest.shell.setText(EchoTest.fn);
            EchoTest.this.alertMsg(EchoTest.shell, "Open file successfully!", "Information");
            in.close();
          }
        }
        catch (NullPointerException e)
        {
          System.out.println("Warning: No file Selected!");
          EchoTest.this.alertMsg(EchoTest.shell, "No file selected!", "Warning!");
        }
        catch (Exception exception)
        {
          EchoTest.this.alertMsg(EchoTest.shell, "Fail to open file!", "Error");
        }
      }
    });
    saveFile.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent event)
      {
        try
        {
          String fileName = null;
          if (EchoTest.fn.equals(""))
          {
            FileDialog dialog = new FileDialog(EchoTest.shell, 8192);
            fileName = dialog.open();
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(EchoTest.basicInformationText.getText());
            out.write(EchoTest.variblesText.getText());
            out.write(EchoTest.GUIText.getText());
            out.write(EchoTest.PCINoText.getText());
            out.write(EchoTest.conDefinitionText.getText());
            out.write(EchoTest.PCIDefinitionText.getText());
            out.write(EchoTest.conAnnotationText.getText());
            out.write(EchoTest.conMetaAttributeText.getText());
            out.write(EchoTest.indicatorText.getText());
            out.close();
            EchoTest.this.alertMsg(EchoTest.shell, "Created File Successfully!", "Information!");
            if (fileName != null)
            {
              EchoTest.fn = fileName;
              EchoTest.shell.setText(EchoTest.fn);
            }
          }
          else
          {
            FileOutputStream fos = new FileOutputStream(fileName);
            OutputStreamWriter out = new OutputStreamWriter(fos);
            out.write(EchoTest.basicInformationText.getText());
            out.close();
          }
        }
        catch (Exception exception)
        {
          exception.printStackTrace();
          MessageBox errorBox = new MessageBox(EchoTest.shell, 1);
          errorBox.setText("Error");
          errorBox.setMessage("Fail to save file!");
          errorBox.open();
        }
      }
    });
    exit.addSelectionListener(new SelectionAdapter()
    {
      public void widgetSelected(SelectionEvent e)
      {
        System.out.println(e.toString());
        EchoTest.display.dispose();
      }
    });
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    System.out.println("Closed");
    display.dispose();
  }
  
  private void alertMsg(Shell shell, String msg, String msgText)
  {
    MessageBox msgBox = new MessageBox(shell);
    msgBox.setMessage(msg);
    msgBox.setText(msgText);
    msgBox.open();
  }
  
  public static void main(String[] args)
  {
    new EchoTest();
  }
}
