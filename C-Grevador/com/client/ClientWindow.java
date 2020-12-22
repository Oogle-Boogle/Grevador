package com.client;

import com.client.sign.Signlink;

import java.net.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ClientWindow extends Client implements ActionListener, WindowListener {

	private static final long serialVersionUID = -6978617783576386732L;

	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	public void initUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			frame = new JFrame(Configuration.CLIENT_TITLE);
			BufferedImage img = ImageIO.read(new URL("https://cdn3.iconfinder.com/data/icons/navigation-elements-1/512/letter-g-key-keyboard-2-512.png"));
			Image image = getScaledImage(img, 512, 512);

			frame.setIconImage(image);
			frame.setLayout(new BorderLayout());
			setFocusTraversalKeysEnabled(false);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JPanel gamePanel = new JPanel();
			gamePanel.setLayout(new BorderLayout());
			gamePanel.add(this);
			gamePanel.setPreferredSize(new Dimension(765, 503));
			frame.getContentPane().add(gamePanel, BorderLayout.CENTER);
			frame.pack();
			insets = frame.getInsets();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//string args[]
	public ClientWindow() {
		super();
		try {
			com.client.sign.Signlink.startpriv(InetAddress.getByName(server));
			initUI();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public URL getCodeBase() {
		try {
			return new URL("http://" + server + "/overlays");
		} catch (Exception e) {
			return super.getCodeBase();
		}
	}

	public static void takeScreenshot() {
		try {
			Window window = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusedWindow();
			Point point = window.getLocationOnScreen();
			int x = (int)point.getX();
			int y = (int)point.getY();
			int w = window.getWidth();
			int h = window.getHeight();
			Robot robot = new Robot(window.getGraphicsConfiguration().getDevice());
			Rectangle captureSize = new Rectangle(x, y, w, h);
			BufferedImage bufferedimage = robot.createScreenCapture(captureSize);
			String imageName = JOptionPane.showInputDialog(frame, "Image Name:", "Game screenshot - Grevador", JOptionPane.OK_CANCEL_OPTION);
			int completedImage = JOptionPane.showConfirmDialog(frame, "Your image has been saved in the cache/Screenshots dir.");
			if(!imageName.equals("null"))
				ImageIO.write(bufferedimage, "png", new File(Signlink.getCacheDirectory() + "/Screenshots/" + imageName + ".png"));
		} catch (Exception e) {
			System.out.println("Caught screenshot expection e.");
		}
	}

	@Override
	public URL getDocumentBase() {
		return getCodeBase();
	}

	public void loadError(String s) {
		System.out.println("loadError: " + s);
	}

	@Override
	public String getParameter(String key) {
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
	}
	
	private static JFrame frame;
	
	public static JFrame getFrame() {
		return frame;
	}
	
	private static Insets insets;
	
	public static Insets getInset() {
		return insets;
	}

}