package com.View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import com.Model.Client;
import com.Model.MyThread;

public class Gui {

    public Gui()
    {
        Display display = new Display();
        Shell shell = new Shell(display);

        shell.setText("LAB 4");
        shell.setLayout(new GridLayout());
        shell.setSize(300,400);

        // Shell can be used as container
        Label label = new Label(shell, SWT.BORDER);
        label.setText("Enter expression:");
        label.setToolTipText("4+16, for example");

        Text text = new Text(shell, SWT.NONE);
        text.setText("                        ");

        Button button =  new Button(shell, SWT.PUSH);
        button.setText("Calculate");
        // set widgets size to their preferred size
        text.pack();
        label.pack();

        Text text2 = new Text(shell,SWT.CENTER);
        text2.setText("Result of expression\n");
        text2.setSize(30, 50);
        text2.setEditable(false);
        Label[] labels = new Label[8];

        for(int i = 0; i < 8; i++) {
            labels[i] = new Label(shell, SWT.BORDER);
            labels[i].setText("                                       ");
            labels[i].pack();
        }
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                MyThread[] thread = new MyThread[8];

                for(int i = 0; i < 8; i++)
                {
                    Client cl = new Client(text.getText());
                    thread[i] = new MyThread();
                    thread[i].setInfo(cl,i);
                    thread[i].start();
                    labels[i].setText("                                       ");
                }

                for(int i = 0; i < 8; i++)
                {
                    try {
                        thread[i].join();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    //String check = thread[i].getResultString();
                    //if (check.matches("[\\d]+")) {
                      //  labels[i].setText(thread[i].getResultString());
                    //} else
                    //labels[i].setText("Incorrect input");
                    labels[i].setText(thread[i].getResultString());
                }
            }
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
