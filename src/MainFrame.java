import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame{
    public MainFrame(){
        initComp();
    }
    private Container cp;
    private JPanel jpnCenter = new JPanel(new GridLayout(3 , 3 , 3 , 3));
    private JPanel jpnRight = new JPanel(new GridLayout(7 , 1 , 3 , 3));
    private JPanel jpnUnder = new JPanel(new GridLayout(1 , 2 , 3 , 3));

    private JTextArea jta = new JTextArea();
    private JScrollPane jsp = new JScrollPane(jta);
    private JTextField jtfSend = new JTextField();
    private JTextField jtfPort = new JTextField();

    private JLabel jlbSever = new JLabel("Sever IP:");
    private JLabel jlbIP = new JLabel();
    private JLabel jlbPort = new JLabel("Port:");

    private JButton jbtStart = new JButton("Start");
    private JButton jbtStop = new JButton("Stop");
    private JButton jbtExit = new JButton("Exit");
    private JButton jbtSend = new JButton("Send");
    private JButton jbt[] = new JButton[9];

    private int sw = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int sh = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fw = 900 , fh = 600;

    private void initComp() {
        this.setBounds(sw / 2 - fw / 2 , sh / 2 - fh / 2 - 100 , fw , fh);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cp = this.getContentPane();

        jsp.setPreferredSize(new Dimension(200,100));
        jta.setLineWrap(true);

        for(int x = 0 ; x < 9 ; x++){
            jbt[x] = new JButton();
            jpnCenter.add(jbt[x]);
        }
        jpnRight.add(jlbSever);
        jpnRight.add(jlbIP);
        jpnRight.add(jlbPort);
        jpnRight.add(jtfPort);
        jpnRight.add(jbtStart);
        jpnRight.add(jbtStop);
        jpnRight.add(jbtExit);
        jpnUnder.add(jtfSend);
        jpnUnder.add(jbtSend);
        cp.add(jsp,BorderLayout.WEST);
        cp.add(jpnCenter,BorderLayout.CENTER);
        cp.add(jpnRight,BorderLayout.EAST);
        cp.add(jpnUnder,BorderLayout.SOUTH);

        jbtExit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
