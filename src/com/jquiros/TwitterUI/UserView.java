package com.jquiros.TwitterUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

public class UserView extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserId;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollBar scrollBar_1;
	private JList list;
	private JTextField txtTweetMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserView frame = new UserView();
					frame.setVisible(true);
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFollowUser = new JButton("Follow User");
		btnFollowUser.setBounds(170, 9, 130, 29);
		contentPane.add(btnFollowUser);
		
		txtUserId = new JTextField();
		txtUserId.setEditable(false);
		txtUserId.setText("User ID");
		txtUserId.setBounds(6, 7, 130, 30);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(6, 49, 288, 137);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(267, 6, 15, 125);
		panel.add(scrollBar_1);
		
		list = new JList();
		list.setBounds(6, 6, 263, 125);
		panel.add(list);
		
		panel_1 = new JPanel();
		panel_1.setBounds(6, 198, 288, 42);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtTweetMessage = new JTextField();
		txtTweetMessage.setText("Tweet Message");
		txtTweetMessage.setBounds(6, 6, 134, 28);
		panel_1.add(txtTweetMessage);
		txtTweetMessage.setColumns(10);
		
		JButton btnTweet = new JButton("Post Tweet");
		btnTweet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTweet.setBounds(165, 7, 117, 29);
		panel_1.add(btnTweet);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(6, 252, 288, 170);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane textPane = 	new JTextPane();
		textPane.setBounds(6, 6, 263, 158);
		panel_2.add(textPane);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		scrollBar_2.setBounds(267, 6, 15, 158);
		panel_2.add(scrollBar_2);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(279, 50, 15, 136);
		contentPane.add(scrollBar);
	}
}
