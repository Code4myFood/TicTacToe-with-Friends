package client;

import javax.swing.SwingUtilities;

/**
 * Connecting the game to the server
 * @author Code4Food
 *
 */
public class Client {
	
	private static View view;
	
	public static void main(String[] args) {
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					view = new View();
					view.getExit().addActionListener(e->{
						System.exit(0);
					});
					view.getSubmit().addActionListener(e->{
						view.getSubmit().setEnabled(false);
						view.getTextField().setEditable(false);
						view.getUpperLabel().setText("Welcome " + view.getTextField().getText());
						Controller controller = new Controller(view);
						controller.start();
					});
					
					
				}
			});
	}
}
