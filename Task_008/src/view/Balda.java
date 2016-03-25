package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Balda
 */

public class Balda extends JFrame {
    public static JFrame jf;
    static int size = 5;
    static String let = "";
    static String word;
    static int y;
    static int x;
    public static HashSet<String> gameWords = new HashSet<String>();
    static String bukva;
    public static int count;
    static int amount;
    public static final HashSet<JButton> clearing = new HashSet<JButton>();
    public static final HashSet<JButton> last = new HashSet<JButton>();
    static MouseListener ml;

    public static JPanel newGame(String s, final PrintWriter pw) throws FileNotFoundException {
        count = 0;
        amount = 0;
        bukva = "";
        jf = new JFrame();
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setBounds(500, 100, 400, 450);
        jf.setLayout(new GridLayout(1, 1));
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        final JPanel w = new JPanel();
        w.setLayout(new GridLayout(5, 5));
        w.setSize(100, 400);
        main.add(w, BorderLayout.CENTER);

        final JButton ok = new JButton("Готово");
        ok.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                for (JButton b : clearing) {
                    b.setEnabled(true);
                }
                for (final JButton j : last) {
                    bukva = j.getText();
                }
                try {
                    boolean boool = trueWord(word);
                    if (!checkWord(word)) {
                        JOptionPane.showMessageDialog(jf, "Такое слово уже было добавлено!");
                        for (final JButton j : last) {
                            word = "";
                            j.setText("");
                            j.setEnabled(true);
                            last.clear();
                            j.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent mouseEvent) {
                                    j.setEnabled(true);
                                    createAlphabet(j);
                                    last.add(j);
                                    j.removeMouseListener(this);
                                    x = j.getX();
                                    y = j.getY();
                                    bukva = j.getText();
                                    j.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent mouseEvent) {
                                            j.setEnabled(false);
                                            clearing.add(j);
                                        }

                                        @Override
                                        public void mousePressed(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseReleased(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseEntered(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseExited(MouseEvent mouseEvent) {

                                        }
                                    });
                                }

                                @Override
                                public void mousePressed(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseExited(MouseEvent mouseEvent) {

                                }
                            });
                            clearing.clear();
                            last.clear();
                        }
                    }
                    if (boool) {
                        JOptionPane.showMessageDialog(jf, "Такого слова не существует!");
                        for (final JButton j : last) {
                            word = "";
                            j.setText("");
                            j.setEnabled(true);
                            last.clear();
                            j.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent mouseEvent) {
                                    j.setEnabled(true);
                                    createAlphabet(j);
                                    last.add(j);
                                    j.removeMouseListener(this);
                                    x = j.getX();
                                    y = j.getY();
                                    bukva = j.getText();
                                    j.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent mouseEvent) {
                                            j.setEnabled(false);
                                            clearing.add(j);
                                        }

                                        @Override
                                        public void mousePressed(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseReleased(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseEntered(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseExited(MouseEvent mouseEvent) {

                                        }
                                    });
                                }

                                @Override
                                public void mousePressed(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent mouseEvent) {

                                }

                                @Override
                                public void mouseExited(MouseEvent mouseEvent) {

                                }
                            });
                            word = "";
                            clearing.clear();
                            last.clear();
                        }
                    }

                    int a = word.length();
                    if (a != 0) {
                        amount++;
                        pw.println(word);
                        pw.println(x);
                        pw.println(y);
                        pw.println(bukva);
                        count = count + a;
                    }

                    if (amount > 9) {
                        if (JOptionPane.showConfirmDialog(Balda.jf, "Игра окончена. Ваш счёт: " + count + "\n" +
                                "Нажмите на любую кнопку, чтобы завершить игру") == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        } else {
                            System.exit(0);
                        }
                    }

                    gameWords.add(word);
                    word = "";
                    clearing.clear();
                    last.clear();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.add(ok);
        main.add(panel, BorderLayout.SOUTH);
        jf.add(main);

        jf.setTitle("Балда");
        jf.setResizable(false);
        gameWords.add(s);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 2) {
                    if (j == 0) {
                        final JButton jb = new JButton(String.valueOf(s.charAt(0)));
                        jb.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent mouseEvent) {
                                jb.setEnabled(false);
                                word = word + jb.getText();
                                clearing.add(jb);
                            }

                            @Override
                            public void mousePressed(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseExited(MouseEvent mouseEvent) {

                            }
                        });
                        jb.setVisible(true);
                        w.add(jb);
                    }
                    if (j == 1) {
                        final JButton jb = new JButton(String.valueOf(s.charAt(1)));
                        jb.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent mouseEvent) {
                                jb.setEnabled(false);
                                word = word + jb.getText();
                                clearing.add(jb);
                            }

                            @Override
                            public void mousePressed(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseExited(MouseEvent mouseEvent) {

                            }
                        });
                        jb.setVisible(true);
                        w.add(jb);
                    }
                    if (j == 2) {
                        final JButton jb = new JButton(String.valueOf(s.charAt(2)));
                        jb.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent mouseEvent) {
                                jb.setEnabled(false);
                                word = word + jb.getText();
                                clearing.add(jb);
                            }

                            @Override
                            public void mousePressed(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseExited(MouseEvent mouseEvent) {

                            }
                        });
                        jb.setVisible(true);
                        w.add(jb);
                    }
                    if (j == 3) {
                        final JButton jb = new JButton(String.valueOf(s.charAt(3)));
                        jb.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent mouseEvent) {
                                jb.setEnabled(false);
                                word = word + jb.getText();
                                clearing.add(jb);
                            }

                            @Override
                            public void mousePressed(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseExited(MouseEvent mouseEvent) {

                            }
                        });
                        jb.setVisible(true);
                        w.add(jb);
                    }
                    if (j == 4) {
                        final JButton jb = new JButton(String.valueOf(s.charAt(4)));
                        jb.addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent mouseEvent) {
                                jb.setEnabled(false);
                                word = word + jb.getText();
                                clearing.add(jb);
                            }

                            @Override
                            public void mousePressed(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseReleased(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseEntered(MouseEvent mouseEvent) {

                            }

                            @Override
                            public void mouseExited(MouseEvent mouseEvent) {

                            }
                        });
                        jb.setVisible(true);
                        w.add(jb);
                    }
                } else {
                    final JButton butt = new JButton("");
                    ml = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            if (butt.getText().equals("")) {
                                createAlphabet(butt);
                                last.add(butt);
                                x = butt.getX();
                                y = butt.getY();
                                bukva = butt.getText();
                                butt.removeMouseListener(this);
                                butt.addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent mouseEvent) {
                                        butt.setEnabled(false);
                                        word = word + butt.getText();
                                        clearing.add(butt);
                                    }

                                    @Override
                                    public void mousePressed(MouseEvent mouseEvent) {

                                    }

                                    @Override
                                    public void mouseReleased(MouseEvent mouseEvent) {

                                    }

                                    @Override
                                    public void mouseEntered(MouseEvent mouseEvent) {

                                    }

                                    @Override
                                    public void mouseExited(MouseEvent mouseEvent) {

                                    }

                                });
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent mouseEvent) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent mouseEvent) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent mouseEvent) {

                        }

                        @Override
                        public void mouseExited(MouseEvent mouseEvent) {

                        }

                    };
                    butt.addMouseListener(ml);
                    butt.setVisible(true);
                    w.add(butt);
                }
            }
        }

        count = 0;
        jf.setVisible(true);
        return w;
    }


    public static void addChar(JPanel p, int a, int b, String ch) {
        final JButton button = (JButton) p.getComponentAt(a, b);
        button.setText(ch);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                button.removeAll();
                button.setEnabled(false);
                word = word + button.getText();
                clearing.add(button);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
    }


    public static void createAlphabet(final JButton b) {
        char c = 1040;
        final JFrame alf = new JFrame();
        alf.setBounds(500, 550, 400, 150);
        alf.setLayout(new GridLayout(4, 8));
        for (int i = 0; i < 32; i++) {
            final JButton but = new JButton(String.valueOf(c));
            c++;
            but.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent mouseEvent) {
                    let = but.getText();
                    alf.setVisible(false);
                    b.setText(let);
                }

                @Override
                public void mousePressed(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseReleased(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseEntered(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseExited(MouseEvent mouseEvent) {

                }
            });
            but.setVisible(true);
            alf.add(but);
        }
        jf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent windowEvent) {
                super.windowDeactivated(windowEvent);
            }
        });
        alf.setUndecorated(true);
        alf.setVisible(true);
        alf.setResizable(false);
    }


    public static String startWord() throws FileNotFoundException {
        String word = "";
        Random ran = new Random();
        String file = "./StartWords.txt";
        Scanner scan = new Scanner(new File(file));
        int line = ran.nextInt(2235) + 1;
        int a = 0;
        boolean b = true;
        while (scan.hasNext() && b) {
            if (a != line) {
                a++;
                scan.nextLine();
            } else {
                b = false;
                word = scan.nextLine();
            }
        }
        return word;
    }

    public static boolean checkWord(String s) {
        boolean flag = true;
        for (String hs : gameWords) {
            if (hs.equals(s)) {
                flag = false;
            }
        }
        return flag;
    }

    public static boolean trueWord(String s) throws FileNotFoundException {
        boolean a = true;
        String file = "./dictionary.txt";
        Scanner scan = new Scanner(new File(file));
        while (scan.hasNext() && a) {
            if (scan.nextLine().equals(s)) {
                a = false;
            }
        }
        return a;
    }
}