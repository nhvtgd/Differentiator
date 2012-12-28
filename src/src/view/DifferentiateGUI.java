package src.view;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class DifferentiateGUI extends JFrame {
	private JTextField mathExp;
	private JLabel resultExp;
	private JTextField resultVar;
	private JButton diffButton;

	public DifferentiateGUI() {
		initGui();
	}

	private void initGui() {
		JPanel mainPane = new JPanel();
		mathExp = new JTextField();
		resultExp = new JLabel("Nothing to differentiate");
		JLabel varToDiff = new JLabel("Variabel to differentiate");
		resultVar = new JTextField(10);
		JLabel mathLabel = new JLabel("Math Expression ");
		JLabel resultLabel = new JLabel("Result Expression ");
		diffButton = new JButton("Differentiate");

		GroupLayout layout = new GroupLayout(mainPane);
		layout.setHorizontalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup().addComponent(mathLabel)
								.addComponent(varToDiff)
								.addComponent(resultLabel))
				.addComponent(diffButton)
				.addGroup(
						layout.createParallelGroup().addComponent(mathExp)
								.addComponent(resultVar)
								.addComponent(resultExp)));
		layout.setVerticalGroup(layout
				.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup().addComponent(mathLabel)
								.addComponent(mathExp))
				.addGroup(
						layout.createParallelGroup().addComponent(varToDiff)
								.addComponent(resultVar))
				.addGroup(
						layout.createParallelGroup().addComponent(resultLabel)
								.addComponent(resultExp))
				.addComponent(diffButton));
		mainPane.setLayout(layout);
		setContentPane(mainPane);
		setTitle("Differentiator Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();

	}

	/** Listener for Math Expression */
	public void addTextListener(ActionListener ac) {
		mathExp.addActionListener(ac);
	}

	public void addDiffListener(ActionListener ac) {
		diffButton.addActionListener(ac);
	}

	/** Get the math expression */
	public String getExpression() {
		return mathExp.getText();
	}

	/** Set the result math expression */
	public void setLabel(String text) {
		resultExp.setText(text);
	}

	/** Get the variable to differentiate */
	public String getVar() {
		return resultVar.getText();
	}

	public static void displayGui() {
		JFrame frame = new DifferentiateGUI();
		frame.setTitle("Differentiator Demo");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				displayGui();

			}
		});
	}
}
