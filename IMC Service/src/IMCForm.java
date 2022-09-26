import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IMCForm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCalcular;
	private JLabel lblResultado;
	private JTextArea txtOutResultado;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JTextField txtInAltura;
	private JTextField txtInPeso;
	private JLabel lblDiagnostico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMCForm frame = new IMCForm();
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
	public IMCForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblResultado = new JLabel("Resultado");
			lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblResultado.setBounds(92, 192, 69, 26);
			contentPane.add(lblResultado);
		}
		{
			txtOutResultado = new JTextArea();
			txtOutResultado.setFont(new Font("Monospaced", Font.PLAIN, 15));
			txtOutResultado.setBounds(171, 192, 155, 26);
			contentPane.add(txtOutResultado);
		}
		{
			lblAltura = new JLabel("Altura");
			lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblAltura.setBounds(113, 37, 48, 14);
			contentPane.add(lblAltura);
		}
		{
			lblPeso = new JLabel("Peso");
			lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblPeso.setBounds(113, 77, 48, 14);
			contentPane.add(lblPeso);
		}
		{
			txtInAltura = new JTextField();
			txtInAltura.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtInAltura.setBounds(230, 37, 96, 20);
			contentPane.add(txtInAltura);
			txtInAltura.setColumns(10);
		}
		{
			txtInPeso = new JTextField();
			txtInPeso.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txtInPeso.setBounds(230, 77, 96, 20);
			contentPane.add(txtInPeso);
			txtInPeso.setColumns(10);
		}
		{
			btnCalcular = new JButton("Calcular");
			btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCalcular.addActionListener(this);
			btnCalcular.setBounds(141, 145, 133, 36);
			contentPane.add(btnCalcular);
		}
		{
			lblDiagnostico = new JLabel("");
			lblDiagnostico.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDiagnostico.setBounds(102, 229, 224, 21);
			contentPane.add(lblDiagnostico);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==btnCalcular) {
			do_btnCalcular_actionPerformed(arg0);
		}
	}
	protected void do_btnCalcular_actionPerformed(ActionEvent arg0) {
		Double altura = Double.parseDouble(txtInAltura.getText());
		Double peso = Double.parseDouble(txtInPeso.getText());
		Double resultado = peso / (altura * altura);
		String res = String.format("%.2f", resultado);
		txtOutResultado.append(res);
		if (resultado >= 30) {
			lblDiagnostico.setText("Obesidad");
		}
		else if (resultado <= 18.5){
			lblDiagnostico.setText("Debajo de lo normal");
		}
		else {
			if ((resultado > 18.5) && (resultado<=25)){
				lblDiagnostico.setText("Peso normal");
			}
			else {
				lblDiagnostico.setText("Sobrepeso");
			}
		}
		
	}
}
