package twitterui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import com.apple.jobjc.ID;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import twitter.User;
import twitter.UserGroup;

public class AdminControlPanel {

	private JFrame frame;
	private JTextField textFieldUserId;
	private JTextField textFieldGroupId;
	private static AdminControlPanel instance = null;
	private User user = new User();
	private UserGroup userGroup = new UserGroup();
	private JTree tree = new JTree();
		
	public static synchronized AdminControlPanel getInstance() {
		if (instance == null) {
			instance = new AdminControlPanel();
		}
		return instance;
	}

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
		
		//Tree
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Root") {
				{
				}
			}
		));
		tree.setEditable(true);
		tree.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tree.setBounds(6, 6, 198, 266);
		frame.getContentPane().add(tree);
		
		//User ID text field
		textFieldUserId = new JTextField();
		textFieldUserId.setText("User ID");
		textFieldUserId.setBounds(216, 6, 102, 30);
		frame.getContentPane().add(textFieldUserId);
		textFieldUserId.setColumns(10);
		
		//Add User Btn
		JButton addUserBtn = new JButton("Add User");
		addUserBtn.setBounds(342, 6, 102, 30);
		frame.getContentPane().add(addUserBtn);
		addUserBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				user.addFollower(textFieldUserId.getText().replace(" ", ""));
				user.setId(textFieldUserId.getText());
				System.out.println(user.getFollowers());
				user.setCreationTime();
				user.getCreationTime();
				DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
				model.insertNodeInto(new DefaultMutableTreeNode(textFieldUserId.getText()), root, root.getChildCount());
			}
		});
		
		//User Group ID text field
		textFieldGroupId = new JTextField();
		textFieldGroupId.setText("Group ID");
		textFieldGroupId.setBounds(216, 46, 102, 30);
		frame.getContentPane().add(textFieldGroupId);
		textFieldGroupId.setColumns(10);
		
		//Add Group btn
		JButton addGroupBtn = new JButton("Add Group");
		addGroupBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (user.userExists(textFieldGroupId.getText())) {
					DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
					DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
					root.add(new DefaultMutableTreeNode(textFieldGroupId.getText()));
					model.reload(root);
				}
				
				userGroup.addFollower(textFieldGroupId.getText().replace(" ", ""));
				userGroup.setId(textFieldGroupId.getText());
				System.out.println(userGroup.getFollowers());
				userGroup.setCreationTime();
				userGroup.getCreationTime();
			}
		});
		addGroupBtn.setBounds(342, 47, 102, 30);
		frame.getContentPane().add(addGroupBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(216, 146, 228, 126);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//User Total Btn
		JButton btnUserTotal = new JButton("User Total");
		btnUserTotal.setBounds(0, 42, 110, 30);
		panel.add(btnUserTotal);
		btnUserTotal.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Total number of users: "
						+ user.getSize() , "Show User Total",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton btnGroupTotal = new JButton("Group Total");
		btnGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Total number of user groups: "
						+ userGroup.getSize() , "Show User Group Total",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnGroupTotal.setBounds(118, 42, 110, 30);
		panel.add(btnGroupTotal);
		
		JButton btnMessageTotal = new JButton("Msg's Total");
		btnMessageTotal.setBounds(0, 90, 110, 30);
		panel.add(btnMessageTotal);
		
		JButton btnPositivePerc = new JButton("Positive %");
		btnPositivePerc.setBounds(118, 90, 110, 30);
		panel.add(btnPositivePerc);
		
		//User View Btn
		JButton userViewBtn = new JButton("User View");
		userViewBtn.setBounds(55, 6, 110, 30);
		panel.add(userViewBtn);
		//Click handler for userViewBtn
		userViewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserView.main();
			}
		});
		
		JButton btnUserVerification = new JButton("User Verification");
		btnUserVerification.setBounds(270, 81, 110, 30);
		frame.getContentPane().add(btnUserVerification);
		btnUserVerification.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "All users and groups valid"
						, "Verify Users and Groups", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton btnLastUpdate = new JButton("Last Update");
		btnLastUpdate.setBounds(270, 117, 110, 30);
		frame.getContentPane().add(btnLastUpdate);		
		btnLastUpdate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Last updated user: " + user.getId() 
						, "Last Updated User", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) 
						tree.getLastSelectedPathComponent();
				
				if (node == null) return;
				
				Object nodeInfo = node.getUserObject();
				
				System.out.println(nodeInfo);
			}
		});
	}

}
