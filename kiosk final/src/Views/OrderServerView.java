package Views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.text.SimpleDateFormat;



@SuppressWarnings("serial")
public class OrderServerView extends JFrame {

	private JPanel contentPane;
	TextArea textArea = new TextArea();

	public OrderServerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ORDER SERVER");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 529, 31);
		contentPane.add(lblNewLabel);
		
		
		textArea.setEditable(false);
		textArea.setBounds(10, 48, 529, 301);
		contentPane.add(textArea);
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd").format(new java.util.Date());
		JLabel lblNewLabel_1 = new JLabel("Date: "+timeStamp);
		lblNewLabel_1.setBounds(10, 11, 179, 31);
		contentPane.add(lblNewLabel_1);
	}
	
	public void addText(String text) {
		String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
		textArea.setEditable(true);
		textArea.setText("\n"+timeStamp+" --> "+text+"\n"+textArea.getText());
		textArea.setEditable(false);
		
	}
}
