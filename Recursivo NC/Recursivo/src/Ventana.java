import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTabbedPane tabbedPane1;
    private JSpinner spID;
    private JComboBox cboFaccion;
    private JComboBox cboNombre;
    private JTextField txtPoder;
    private JButton btnRegistrar;
    private JButton btnCalcular;
    private JTextArea txtListar;
    private JLabel lblSumatoria;
    private JLabel lblSumatoriaPorFaccion;
    private JComboBox cboFaccion2;
    private JButton btnSumatoriaPorFaccion;
    private Coleccion c1 = new Coleccion();

    public Ventana() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(spID.getValue().toString());
                String faccion = cboFaccion.getSelectedItem().toString();
                String nombre = cboNombre.getSelectedItem().toString();
                float poder = Float.parseFloat(txtPoder.getText());
                Transformer obj = new Transformer(id, faccion, nombre, poder);
                c1.agregar(obj);
                txtListar.setText(c1.listar());
            }
        });
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblSumatoria.setText("La suma de poderes es: "+c1.sumar(0));
            }
        });
        btnSumatoriaPorFaccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String faccionSeleccionada = cboFaccion2.getSelectedItem().toString();
                float sumaPorFaccion = c1.sumatoriaPorFaccion(faccionSeleccionada);
                lblSumatoriaPorFaccion.setText("La sumatoria para la faccion: " + faccionSeleccionada + "es: " + sumaPorFaccion);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
