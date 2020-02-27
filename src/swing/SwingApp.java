package swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

public class SwingApp {

	private static JFrame jFrame = getFrame();
	private static JPanel jPanel = new JPanel();

	public static void main(String[] args) {

		scroll();

	}

	private static void popup() {

		jFrame.add(jPanel);
		JPopupMenu jPopupMenu = new JPopupMenu();
		jPopupMenu.add(new JMenuItem("test"));
		jPanel.setComponentPopupMenu(jPopupMenu);

	}

	private static void gridColumn() {

		jFrame.setLayout(new BorderLayout());

		JPanel rightPanel = new JPanel(new GridLayout(2, 1));
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("button2");
		rightPanel.add(button1, BorderLayout.NORTH);
		rightPanel.add(button2, BorderLayout.NORTH);
		jFrame.add(rightPanel, BorderLayout.EAST);

		JPanel centerPanel = new JPanel();
		jFrame.add(centerPanel);

		JPanel leftPanel = new JPanel(new GridLayout(0, 1));
		for (int index = 0; index < 12; index++) {
			leftPanel.add(new JButton(String.valueOf(index)));
		}

		JPanel left = new JPanel(new BorderLayout());
		left.add(leftPanel, BorderLayout.NORTH);
		jFrame.add(left, BorderLayout.WEST);

//	    jFrame.pack();
		jFrame.setLocationRelativeTo(null);

	}

	private static void scroll() {

		JPanel jp = new JPanel();
		jFrame.add(jp);
		jp.setPreferredSize(new Dimension(800, 400));
		for (int i = 0; i < 100; i++) {
			jp.add(new JButton("JButton"));
		}

		JScrollPane js = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		js.setPreferredSize(new Dimension(400, 300));
		jFrame.add(js);		

	}

	private static JFrame getFrame() {

		final JFrame jFrame = new JFrame();
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Toolkit toolkit = Toolkit.getDefaultToolkit();
		final Dimension dimension = toolkit.getScreenSize();
		jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 150, 500, 300);
		jFrame.setTitle("Test");
		return jFrame;

	}

}
