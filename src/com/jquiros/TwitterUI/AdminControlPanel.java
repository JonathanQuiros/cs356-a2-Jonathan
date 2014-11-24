package com.jquiros.TwitterUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class AdminControlPanel {

	private JFrame frame;
	private JTextField textFieldUserId;
	private JTextField textFieldGroupId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminControlPanel window = new AdminControlPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminControlPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTree tree = new JTree();
		tree.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		tree.setBounds(6, 6, 198, 266);
		frame.getContentPane().add(tree);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(28, 209, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton addUserBtn = new JButton("Add User");
		addUserBtn.setBounds(342, 6, 102, 30);
		frame.getContentPane().add(addUserBtn);
		
		textFieldUserId = new JTextField();
		textFieldUserId.setEditable(false);
		textFieldUserId.setText("User ID");
		textFieldUserId.setBounds(216, 6, 102, 30);
		frame.getContentPane().add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		textFieldGroupId = new JTextField();
		textFieldGroupId.setText("Group ID");
		textFieldGroupId.setEditable(false);
		textFieldGroupId.setBounds(216, 46, 102, 30);
		frame.getContentPane().add(textFieldGroupId);
		textFieldGroupId.setColumns(10);
		
		JButton addGroupBtn = new JButton("Add Group");
		addGroupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addGroupBtn.setBounds(342, 47, 102, 30);
		frame.getContentPane().add(addGroupBtn);
		
		JButton userViewBtn = new JButton("User View");
		
		//Click handler for 
		userViewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		userViewBtn.setBounds(270, 120, 110, 30);
		frame.getContentPane().add(userViewBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(216, 162, 228, 110);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnUserTotal = new JButton("User Total");
		btnUserTotal.setBounds(0, 27, 110, 30);
		panel.add(btnUserTotal);
		
		JButton btnGroupTotal = new JButton("Group Total");
		btnGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGroupTotal.setBounds(118, 27, 110, 30);
		panel.add(btnGroupTotal);
		
		JButton btnMessageTotal = new JButton("Msg's Total");
		btnMessageTotal.setBounds(0, 75, 110, 30);
		panel.add(btnMessageTotal);
		
		JButton btnPositivePerc = new JButton("Positive %");
		btnPositivePerc.setBounds(118, 75, 110, 30);
		panel.add(btnPositivePerc);
	}
}
