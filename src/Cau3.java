import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class Cau3 extends JFrame {
    private JPanel panel1;
    private JButton exitBtn;
    private JButton fixBtn;
    private JTextField midTextField;
    private JLabel midLabel;
    private JTable table1;
    // Tạo bảng
    private DefaultTableModel model = new DefaultTableModel(
            new String[]{"Mã nhân sự", "Họ tên", "Tuổi", "Giới tính", "Chức danh"},
            0
    );

    public Cau3(ArrayList<Person> personList) {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        // Đổ dữ liệu từ danh sách đối tượng vảo bảng
        for (Person person : personList) {
            if (person instanceof KPIEvaluator) {
                String employeeID = "";

                // Kiểm tra loại đối tượng để lấy ID
                if (person instanceof TeachingAssistant) {
                    employeeID = ((TeachingAssistant) person).employeeID;
                } else if (person instanceof Lecturer) {
                    employeeID = ((Lecturer) person).employeeID;
                } else if (person instanceof Professor) {
                    employeeID = ((Professor) person ).employeeID;
                }

                Object[] rowData = {employeeID, person.name, person.age, person.gender, person.getRole()};
                model.addRow(rowData);
            }
        }
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = midTextField.getText().trim();
                // Kiểm tra độ dài khác 4
                if (searchText.length() != 4) {
                    JOptionPane.showMessageDialog(null, "Mã nhân sự không hợp lệ");
                    midTextField.requestFocusInWindow();
                }
            }
        });
        midTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Khi mid rỗng thì nút sửa sẽ không tương tác được
                if (midLabel.getText().trim().isEmpty()) {
                    fixBtn.setEnabled(false);
                }
                else {
                    fixBtn.setEnabled(true);
                }
                if(Character.isDigit(e.getKeyChar()) == false) {
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] args) {
        new Cau3().setVisible(true);
        /*ui.setContentPane(ui.panel1);
        ui.setTitle("Chương trình của Việt Anh");
        ui.setSize(500, 500);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Khi form được load lên thì msvTextField sẽ được focus lại.
        ui.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                ui.midTextField .requestFocusInWindow();
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });*/
    }
}
