package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.view.DifferentiateGUI;
import differentiator.Differentiator;

public class DifferentiateController {
	private final DifferentiateGUI view;
	private final Differentiator model;

	public DifferentiateController(DifferentiateGUI view, Differentiator model) {
		this.view = view;
		this.model = model;

		view.addDiffListener(new myDifferentiateListener());
	}

	public class myDifferentiateListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String mathExp = view.getExpression();
			String var = view.getVar();
			if (mathExp.length() > 0 && var.length() > 0) {
				String result = model.evaluate(mathExp, var);
				view.setLabel(result);
			}

		}
	}

	public static void main(String[] args) {
		DifferentiateGUI view = new DifferentiateGUI();
		Differentiator model = new Differentiator();
		DifferentiateController controller = new DifferentiateController(view,
				model);
		view.setVisible(true);
	}
}
