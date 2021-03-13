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

    public static int numNaus = 3;
    Nau[] nau;
    Nau nauPropia;
    Random rand;
    Shot balas[] = new Shot[5];

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
            System.out.println("Repintant");
            repaint();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < nau.length; ++i) {
            nau[i].pinta(g);
        }
        nauPropia.pinta(g);
        for (int i = 0; i < nauPropia.shots.size(); ++i) {
            nauPropia.shots.get(i).pinta(g);
        }
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
        if (y >= 325 - ty || y <= ty) {
            dsy = -dsy;
        }
    }

    public synchronized void pinta(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.image, x, y, null);
    }

    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
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
