/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_uf2_act7;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alumne
 */
public class NauEspaial extends javax.swing.JFrame {

    public NauEspaial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE));
        pack();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspaial.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        NauEspaial f = new NauEspaial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(480, 580);
        f.setVisible(true);
    }
}

class PanelNau extends JPanel implements Runnable, KeyListener {

    public static int numNaus = 3, numBalas = 5;
    Nau[] nau;
    Nau nauPropia;
    Random rand;
    Shot balas[] = new Shot[5];
    boolean trigger = false;

    public PanelNau() {
        nau = new Nau[numNaus];
        for (int i = 0; i < nau.length; i++) {
            rand = new Random();
            int velocitat = (rand.nextInt(3) + 5) * 10;
            int posX = rand.nextInt(100) + 30;
            int posY = rand.nextInt(100) + 30;
            int dX = rand.nextInt(3) + 1;
            int dY = rand.nextInt(3) + 1;
            nau[i] = new Nau(i, posX, posY, dX, dY, velocitat);
        }
        nauPropia = new Nau(numNaus + 9999, 240, 430, 0, 0, rand.nextInt(rand.nextInt(3) + 5) * 10);
        Thread n = new Thread(this);
        n.start();

        addKeyListener(this);
        setFocusable(true);
    }

    public void run() {
        System.out.println("Inici fil repintar");
        while (true) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            } // espero 0,1 segons
            //System.out.println("Repintant");
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double dis = 0, cnt = 10000;

        for (int i = 0; i < nau.length; i++) {
            if (nau[i] != null) {
                nau[i].pinta(g);
                System.out.println("es la " + i);
                if (nauPropia != null) {
                    cnt = Math.floor(Math.sqrt(
                            (nauPropia.getX() - nau[i].getX())
                            * (nauPropia.getX() - nau[i].getX())
                            + (nauPropia.getY() - nau[i].getY())
                            * (nauPropia.getY() - nau[i].getY())));
                }

            }
            if (nauPropia != null) {
                nauPropia.pinta(g);
                System.out.println(i);

                for (int j = 0; j < nauPropia.shots.size(); j++) {
                    if ((nauPropia.shots.get(j) != null) && (nau[i] != null)) {
                        if (nauPropia.shots.get(j).getY() <= 0) {
                            nauPropia.shots.set(j, null);
                        } else {
                            nauPropia.shots.get(j).pinta(g);
                            dis = Math.floor(Math.sqrt(
                                    (nauPropia.shots.get(j).getX() - nau[i].getX())
                                    * (nauPropia.shots.get(j).getX() - nau[i].getX())
                                    + (nauPropia.shots.get(j).getY() - nau[i].getY())
                                    * (nauPropia.shots.get(j).getY() - nau[i].getY())));
                            if (nauPropia != null) {
                                System.out.println(cnt);
                                if (cnt < 50) {
                                    if (!trigger) {
                                        nauPropia = null;
                                        JOptionPane.showMessageDialog(null, "Has perdut");
                                        trigger = true;
                                        System.exit(0);
                                    }
                                }
                            }
                            if (dis < 50) {
                                nau[i] = null;
                                nauPropia.shots.set(j, null);
                                numNaus--;
                                if (numNaus == 0) {
                                    JOptionPane.showMessageDialog(null, "GG");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }

            if (nauPropia != null && cnt < 50) {
                System.out.println(cnt);
                if (cnt < 50) {
                    if (!trigger) {
                        nauPropia = null;
                        JOptionPane.showMessageDialog(null, "Has perdut");
                        trigger = true;
                        System.exit(0);
                    }
                }
            }
        }
//        for (int i = 0; i < nau.length; i++) {
//            if (nauPropia != null) {
//                cnt = Math.floor(Math.sqrt(
//                        (nauPropia.getX() - nau[i].getX())
//                        * (nauPropia.getX() - nau[i].getX())
//                        + (nauPropia.getY() - nau[i].getY())
//                        * (nauPropia.getY() - nau[i].getY())));
//                System.out.println(cnt);
//                if (cnt < 10) {
//                    if (!trigger) {
//                        nauPropia = null;
//                        JOptionPane.showMessageDialog(null, "Has perdut");
//                        trigger = true;
//                        System.exit(0);
//                    }
//                }
//            }
//        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int tecla = e.getKeyCode();

        if (tecla == 68) {
            nauPropia.moureR();
        } else if (tecla == 65) {
            nauPropia.moureL();
        } else if (tecla == 32) {
            nauPropia.disparar();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        nauPropia.moureNull();
    }

    public int getNumNaus() {
        return numNaus;
    }

}

class Nau extends Thread {

    private int numero;
    private int x, y;
    private int dsx, dsy, v;
    private int tx = 10;
    private int ty = 10;
    ArrayList<Shot> shots = new ArrayList<Shot>();

    private String img = "/images/nau.jpg";
    private Image image;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    public int getDsy() {
        return dsy;
    }

    public void setDsy(int dsy) {
        this.dsy = dsy;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getTy() {
        return ty;
    }

    public void setTy(int ty) {
        this.ty = ty;
    }

    public ArrayList<Shot> getShots() {
        return shots;
    }

    public void setShots(ArrayList<Shot> shots) {
        this.shots = shots;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Nau(int numero, int x, int y, int dsx, int dsy, int v) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.dsx = dsx;
        this.dsy = dsy;
        this.v = v;

        if (numero == (PanelNau.numNaus + 9999)) {
            image = new ImageIcon(Nau.class.getResource("nau.png")).getImage();
        } else {
            image = new ImageIcon(Nau.class.getResource("enemy.png")).getImage();
        }

        Thread t = new Thread(this);
        t.start();
    }

    public int velocitat() {
        return v;
    }

    public synchronized void moure() {
        x = x + dsx;
        y = y + dsy;
        // si arriva als marges ...
        if (x >= 420 - tx || x <= tx) {
            dsx = -dsx;
        }
        if (y >= 440 - ty || y <= ty) {
            dsy = -dsy;
        }
    }

    public synchronized void pinta(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, null);
    }

    public void run() {
        while (true) {
            //System.out.println("Movent nau numero " + this.numero);
            try {
                Thread.sleep(this.v);
            } catch (Exception e) {
            }
            moure();
        }
    }

    void moureL() {
        if (!(x <= 0 - tx)) {
            this.dsx = -5;
        }

    }

    void moureR() {
        if (!(x >= 420 - tx)) {
            this.dsx = 5;
        }
    }

    void moureNull() {
        this.dsx = 0;
    }

    public void disparar() {
        shots.add(new Shot(this.x + 20, this.y - 16, 5));
    }
}

class Shot extends Thread {

    private int x, y, v;
    private int dsy = 1, dsx = 0;
    private Image image;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getV() {
        return v;
    }

    public int getDsy() {
        return dsy;
    }

    public int getDsx() {
        return dsx;
    }

    public Image getImage() {
        return image;
    }

    public Shot(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;

        Thread t = new Thread(this);
        image = new ImageIcon(Nau.class.getResource("balanau.png")).getImage();
        this.start();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(this.v);
            } catch (Exception e) {
            }
            moure();
        }
    }

    public synchronized void moure() {
        y = y - dsy;

    }

    public synchronized void pinta(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, null);
    }

}
