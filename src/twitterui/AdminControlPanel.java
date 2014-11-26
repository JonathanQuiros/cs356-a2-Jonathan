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
	User user = new User(null);
	UserGroup userGroup = new UserGroup();
	JTree tree = new JTree();
		
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
//		tree.setModel(new DefaultTreeModel(
//			new DefaultMutableTreeNode("Root") {
//				/**
//				 * 
//				 */
//				private static final long serialVersionUID = 1L;
//
//				{
//					DefaultMutableTreeNode node_1;
//					node_1 = new DefaultMutableTreeNode("Dog-Lovers");
//						node_1.add(new DefaultMutableTreeNode("James"));
//						node_1.add(new DefaultMutableTreeNode("Tigran"));
//						node_1.add(new DefaultMutableTreeNode("Roy"));
//					add(node_1);
//					node_1 = new DefaultMutableTreeNode("Yankee Fans");
//						node_1.add(new DefaultMutableTreeNode("Tigran"));
//						node_1.add(new DefaultMutableTreeNode("Andrea"));
//					add(node_1);
//					add(new DefaultMutableTreeNode("Diego"));
//					add(new DefaultMutableTreeNode("Edwin"));
//				}
//			}
//		));
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
				user.addFollower(textFieldUserId.getText());
				System.out.println(user.getFollowers());
				
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
				
				//Testing
				userGroup.addFollower(textFieldGroupId.getText());
				System.out.println(userGroup.getFollowers());
			}
		});
		addGroupBtn.setBounds(342, 47, 102, 30);
		frame.getContentPane().add(addGroupBtn);
		
		//User View Btn
		JButton userViewBtn = new JButton("User View");
		//Click handler for userViewBtn
		userViewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserView.main();
			}
		});
		
		userViewBtn.setBounds(270, 120, 110, 30);
		frame.getContentPane().add(userViewBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(216, 162, 228, 110);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//User Total Btn
		JButton btnUserTotal = new JButton("User Total");
		btnUserTotal.setBounds(0, 27, 110, 30);
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
		btnGroupTotal.setBounds(118, 27, 110, 30);
		panel.add(btnGroupTotal);
		
		JButton btnMessageTotal = new JButton("Msg's Total");
		btnMessageTotal.setBounds(0, 75, 110, 30);
		panel.add(btnMessageTotal);
		
		JButton btnPositivePerc = new JButton("Positive %");
		btnPositivePerc.setBounds(118, 75, 110, 30);
		panel.add(btnPositivePerc);
		
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
