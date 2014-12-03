package twitterui;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.AbstractListModel;

import twitter.User;
import javax.swing.JLabel;

public class UserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUserId;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollBar scrollBar_1;
	private JList following = new JList();
	private JTextField txtTweetMessage;
	private JList newsFeed;
	private DefaultListModel listModel = new DefaultListModel();
	private DefaultListModel listModel2 = new DefaultListModel();
	private User user = new User();
	private JLabel lbLastUpdateTime;
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
					frame.setVisible(true);
					//frame.setTitle(user.getId() + "'s Profile");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserView() {
		following = new JList(listModel);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserId = new JTextField();
		txtUserId.setText("User ID");
		txtUserId.setBounds(6, 6, 130, 30);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(179, 7, 115, 30);
		contentPane.add(btnFollowUser);
		btnFollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel.addElement(txtUserId.getText());
				following = new JList(listModel);
			}
		});
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 49, 288, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(267, 6, 15, 125);
		panel.add(scrollBar_1);
		
		following.setModel(new AbstractListModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		following.setBounds(6, 6, 263, 125);
		panel.add(following);
		
		panel_1 = new JPanel();
		panel_1.setBounds(6, 198, 294, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		final JLabel lbLastUpdateTime = new JLabel("Last Update Time");
		lbLastUpdateTime.setBounds(88, 406, 206, 16);
		contentPane.add(lbLastUpdateTime);
		
		txtTweetMessage = new JTextField();
		txtTweetMessage.setText("Tweet Message");
		txtTweetMessage.setBounds(0, 6, 136, 30);
		panel_1.add(txtTweetMessage);
		txtTweetMessage.setColumns(10);
		
		JButton btnTweet = new JButton("Post Tweet");
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listModel2.addElement(txtTweetMessage.getText());
				newsFeed = new JList(listModel);
				user.setLastUpdateTime();
				String lastUpdateTime = String.valueOf(user.getLastUpdateTime());
				System.out.println("Created at: " + lastUpdateTime);
				lbLastUpdateTime.setText("Created at:" + lastUpdateTime);
			}
		});
		btnTweet.setBounds(178, 7, 110, 30);
		panel_1.add(btnTweet);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(6, 252, 288, 150);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(267, 6, 15, 158);
		panel_2.add(scrollBar_2);
		
		newsFeed = new JList();
		newsFeed.setBounds(6, 6, 262, 158);
		panel_2.add(newsFeed);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(279, 50, 15, 136);
		contentPane.add(scrollBar);
	}
	
	public void resetLastUpdateTime(ActionEvent e, String s) {
		lbLastUpdateTime.setText(s);
	}
}
