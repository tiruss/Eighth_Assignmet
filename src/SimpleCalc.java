import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.Container;
import java.awt.Dimension;

public class SimpleCalc implements ActionListener{
 
    private JFrame Frame;
    private JPanel buttonPanel;
    private JTextField numberCalc;
    float calcOperation = 0;
    float currentCalc = 0;
    

    public static void main(String[] args) {
     
         new SimpleCalc();
              
    }
    
    public SimpleCalc()
    {
        Frame = new JFrame();
        
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setTitle("Simple Calculator");
        Frame.setSize(500,700);
      
        Frame.setLocationRelativeTo(null);
        
        numberCalc = new JTextField(40);
        numberCalc.setHorizontalAlignment(JTextField.RIGHT);
        numberCalc.setEditable(false);
        
        Frame.add(numberCalc, BorderLayout.NORTH);
        
        buttonPanel = new JPanel();
               
        buttonPanel.setLayout(new GridLayout(5,3));   
        Frame.add(buttonPanel, BorderLayout.CENTER);
        
        for (int i=0;i<10;i++)
        {
        	JButton btn = new JButton("" + i);
			btn.addActionListener(this);
			btn.setPreferredSize(new Dimension(100, 100));
			buttonPanel.add(btn);
            
        }
        

        JButton addButton = new JButton("+");
        addButton.setActionCommand("+");
        
        OperatorAction addAction = new OperatorAction(1);
        addButton.addActionListener(addAction);
        
        JButton subButton = new JButton("-");
        subButton.setActionCommand("-");
        
        OperatorAction subAction = new OperatorAction(2);
        subButton.addActionListener(subAction);
        
        JButton mulButton = new JButton("*");
        addButton.setActionCommand("*");
        
        OperatorAction mulAction = new OperatorAction(3);
        mulButton.addActionListener(mulAction);
        
        JButton divButton = new JButton("/");
        addButton.setActionCommand("/");
        
        OperatorAction divAction = new OperatorAction(4);
        divButton.addActionListener(divAction);
        
        JButton equalsButton = new JButton("=");
        equalsButton.setActionCommand("=");
        equalsButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if (!numberCalc.getText().isEmpty())
                {
                    float number = Float.parseFloat(numberCalc.getText());
                    if (calcOperation == 1)
                    {
                        float calculate = currentCalc  + number;
                        numberCalc.setText(Float.toString(calculate));
                    }
                    else if (calcOperation == 2)
                    {
                        float calculate = currentCalc  - number;
                        numberCalc.setText(Float.toString(calculate));
                    }
                    else if (calcOperation == 3)
                    {
                    	float calculate = currentCalc * number;
                    	numberCalc.setText(Float.toString(calculate));
                    }
                    else if (calcOperation == 4)
                    {
                    	float calculate = currentCalc / number;
                    	numberCalc.setText(Float.toString(calculate));
                    }
                }
            }
        });
        
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(equalsButton);
        
        Frame.pack();
		Frame.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String action = event.getActionCommand();
        
        numberCalc.setText(numberCalc.getText());
        numberCalc.setText(action);
    }
    
    public class OperatorAction implements ActionListener
    {
        public int operator;
        
        public OperatorAction(int operation)
        {
            operator = operation;
        }
        
        public void actionPerformed(ActionEvent event)
        {
        	currentCalc = Float.parseFloat(numberCalc.getText());
            calcOperation = operator;
            }
        }
    }
