import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
public class Hello extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hello frame = new Hello();
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
	public Hello() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 666);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("UserName:");
		userLabel.setForeground(Color.MAGENTA);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		userLabel.setBounds(100, 60, 200, 26);
		contentPane.add(userLabel);
		
		JLabel pwdLabel = new JLabel("Password");
		pwdLabel.setBackground(Color.DARK_GRAY);
		pwdLabel.setForeground(Color.MAGENTA);
		pwdLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		pwdLabel.setBounds(100, 120, 200, 30);
		contentPane.add(pwdLabel);
		
		textField = new JTextField();
		textField.setBounds(300, 60, 200, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(300, 120, 200, 30);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setForeground(Color.MAGENTA);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		 loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String password=passwordField.getText();
				
				// It is optional for JDBC4.x version
			      try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      // variables
			      final String url = "jdbc:mysql:///capsdb";
			      final String user = "root";
			      final String password1 = "Ehsan1999@1378";
			      // establish the connection
			      Connection con;
				try {
					con = DriverManager.getConnection(url, user, password1);
				      // display status message
				      if (con == null) {
				         System.out.println("JDBC connection is not established");
				         return;
				      } else
				         System.out.println("Congratulations," +
				              " JDBC connection is established successfully.\n");
					
				//	PreparedStatement st= con.prepareStatement("Select * from login ");
					PreparedStatement st= con.prepareStatement("Select login_name, login_pass from login where login_name=? and login_pass=?");
				     
					st.setString(1, username);
					st.setString(2, password);
					ResultSet rs = st.executeQuery();
					//System.out.println(rs);
					
		
			      if(rs.next()) {
						System.out.println("Hello  " +username +" !");
						
						
					}
					else
						System.out.println("Wrong password");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			      // close JDBC connection
			     // con.close();
			}
		});
		 loginButton.setBounds(358, 541, 85, 21);
		contentPane.add( loginButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(58, 544, 85, 21);
	    contentPane.add(btnNewButton_1);
	    
	    JLabel NewLabel = new JLabel("Welcome Back!");
	    NewLabel.setFont(new Font("Tahoma", Font.BOLD, 54));
	    NewLabel.setBounds(0, 0, 530, 629);
	    ImageIcon icon=new ImageIcon(this.getClass().getResource("/shoping.jpg"));
	    NewLabel.setIcon(icon);
	    contentPane.add(NewLabel);
		
	}
}