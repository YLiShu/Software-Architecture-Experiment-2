package teachSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;

/* 
 * author: 钱志伟_202131060824
 */
public class system {
    public static void main(String[] args) {
        new MyFrameSystem("经典软件体系结构教学软件");
    }
}

class MyFrameSystem extends JFrame {
    JLabel lab, lab1;// 定义相应组件
    JButton jbt, btn1, btn2, btn3, btn4;
    JPanel jp1, jp2, jp3, jp4;

    // JTextField jtf1,jtf2,jtf3;
    MyFrameSystem(String title) {
        super(title);
        lab = new JLabel("点击按钮选择不同风格的体系结构");// 实例化对象
        // lab1=new JLabel("+");
        // jtf1=new JTextField(10);
        // jtf2=new JTextField(10);
        // jtf3=new JTextField(10);

        btn1 = new JButton("主程序-子程序");
        btn2 = new JButton("面向对象");
        btn3 = new JButton("事件系统");
        btn4 = new JButton("管道-过滤");

        // jbt=new JButton("刷新");
        // jbt.addActionListener(new MonitorAddCount(jtf1,jtf2,jtf3));//创建监听器
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dialog1();

            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dialog2();

            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dialog3();

            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dialog4();

            }
        });
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp1.setLayout(new GridLayout(2, 1));// 设置面板1的布局为网格布局
        this.add(jp1);// 为JFrame窗口添加面板
        jp1.add(jp2);
        jp1.add(jp3);
        jp2.add(lab);
        jp3.add(btn1);
        jp3.add(btn2);
        jp3.add(btn3);
        jp3.add(btn4);
        // jp3.add(jtf1);
        // jp3.add(lab1);
        // jp3.add(jtf2);
        // jp3.add(jbt);
        // jp3.add(jtf3);
        this.setBounds(200, 300, 600, 400);// 设计JFrame的桌面位置和大小
        this.setVisible(true);// 设置窗口可见
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);// 设置运行后程序结束运行。
        pack();// 按照组件大小改变窗口
    }
}

class dialog1 extends JDialog {
    dialog1() {
        setVisible(true);
        setBounds(800, 300, 600, 400);
        // 图片
        ImageIcon icon = new ImageIcon("主子程序.png");

        JLabel imagelab = new JLabel(icon);
        JLabel lab = new JLabel("主程序-子程序");
        JPanel pal = new JPanel();
        JPanel pal2 = new JPanel();
        pal.setLayout(new GridBagLayout());
        String des = new String();
        String code = new String();
        // 结果文件
        String result = new String();
        result = ReadFile.readStringFromtxt();
        // System.out.println(result);
        des = "主程序-子程序,调用-返回机制,层次化结构\n"
                + "将大系统分解成为若干模块，主程序调用这些模块实现完整的系统功能\n"
                + "优点：有效地将一个比较复杂的程序系统设计任务分解成许多简单的，易于控制和处理的子任务，便于开发和维护，已被证明是成功的设计方法，可以被用于较大程序\n"
                + "缺点：程序超过10万行的时候表现并不好，程序太大，开发太慢，测试也越来越困难。可重用性较差，难以开发大型软件和图形界面的应用软件\n";

        code = "关键代码：\n" + "    public void shift() {\n" +
                "        //获取每个单词，存入tokens\n" +
                "        Iterator<String> it = lineTxt.iterator();\n" +
                "        while (it.hasNext()) {\n" +
                "            StringTokenizer token = new StringTokenizer(it.next());\n" +
                "            ArrayList<String> tokens = new ArrayList<String>();\n" +
                "            int i = 0;\n" +
                "            //循环添加单词\n" +
                "            int count = token.countTokens();\n" +
                "            while (i < count) {\n" +
                "                tokens.add(token.nextToken());\n" +
                "                i++;\n" +
                "            }\n" +
                "\n" +
                "            //display(tokens);\n" +
                "            //切割各个单词，不断改变起始值和利用loop实现位移。\n" +
                "            for (i = 0; i < count; i++) {\n" +
                "                StringBuffer lineBuffer = new StringBuffer();\n" +
                "                int index = i;\n" +
                "                for (int f = 0; f < count; f++) {\n" +
                "                    //从头继续位移\n" +
                "                    if (index >= count)\n" +
                "                        index = 0;\n" +
                "                    //存入StringBuffer\n" +
                "                    lineBuffer.append(tokens.get(index));\n" +
                "                    lineBuffer.append(\" \");\n" +
                "                    index++;\n" +
                "                }\n" +
                "                String tmp = lineBuffer.toString();\n" +
                "                kwicList.add(tmp);\n" +
                "            }\n" +
                "        }\n" +
                "\n" +
                "    }";

        JTextArea TDesc = new JTextArea(des);
        JTextArea TCode = new JTextArea(code);
        JTextArea TResult = new JTextArea(result);

        TDesc.setLineWrap(true);
        TDesc.setWrapStyleWord(true);
        JScrollPane scroll_desc = new JScrollPane(TDesc);
        scroll_desc.setFont(new Font(null, Font.PLAIN, 50));

        TCode.setLineWrap(true);
        TCode.setWrapStyleWord(true);
        JScrollPane scroll_code = new JScrollPane(TCode);
        scroll_code.setFont(new Font(null, Font.PLAIN, 50));

        TResult.setLineWrap(true);
        TResult.setWrapStyleWord(true);
        JScrollPane scroll_result = new JScrollPane(TResult);
        scroll_result.setFont(new Font(null, Font.PLAIN, 50));

        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridy = 0;// 行
        gridBagConstraints1.gridx = 0;// 列
        gridBagConstraints1.weightx = 0.2;
        gridBagConstraints1.weighty = 0.5;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridy = 1;// 行
        gridBagConstraints2.gridx = 0;// 列
        gridBagConstraints2.weightx = 0.5;
        gridBagConstraints2.weighty = 0.5;
        gridBagConstraints2.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridy = 2;// 行
        gridBagConstraints3.gridx = 0;// 列
        gridBagConstraints3.weightx = 0.2;
        gridBagConstraints3.weighty = 0.5;
        gridBagConstraints3.fill = GridBagConstraints.BOTH;

        pal.add(scroll_desc, gridBagConstraints1);
        pal.add(scroll_code, gridBagConstraints2);
        pal.add(scroll_result, gridBagConstraints3);
        // pal2.add(TCode);
        this.add(lab);
        this.add(imagelab, BorderLayout.NORTH);

        this.add(pal);
        // this.add(pal2);

    }
}

class dialog2 extends JDialog {
    dialog2() {
        setVisible(true);
        setBounds(800, 300, 600, 400);
        // 图片
        ImageIcon icon = new ImageIcon("面向对象.png");

        JLabel imagelab = new JLabel(icon);
        JLabel lab = new JLabel("面向对象");
        JPanel pal = new JPanel();
        JPanel pal2 = new JPanel();
        pal.setLayout(new GridBagLayout());
        String des = new String();
        String code = new String();
        // 结果文件
        String result = new String();
        result = ReadFile2.readStringFromtxt();
        // System.out.println(result);
        des = "面向对象,类和对象,对象之间通过功能与函数调用实现交互\n"
                + "优点： 一个对象对外隐藏了自己的信息，对象将数据与操作封装在了一起。\n"
                + "缺点：首先需要管理大量的对象，难以确定合适的结构，另外若要调用另外一个对象，就必须要知道它的名称，而且随着继承引起的复杂度，会产生连锁反应。\n";

        code = "关键代码：\n" +
                "    public static void main(String[] args) {\n" +
                "        Input input = new Input();\n" +
                "        input.input(\"C:\\\\Users\\\\yelishu\\\\Desktop\\\\test2\\\\src\\\\input.txt\");\n" +
                "        Shift shift = new Shift(input.getLineTxt());\n" +
                "        shift.shift();\n" +
                "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\n" +
                "        alphabetizer.sort();\n" +
                "        Output output = new Output(alphabetizer.getKwicList());\n" +
                "        output.output(\"C:\\\\Users\\\\yelishu\\\\Desktop\\\\test2\\\\src\\\\output2.txt\");\n" +
                "\n" +
                "    }";

        JTextArea TDesc = new JTextArea(des);
        JTextArea TCode = new JTextArea(code);
        JTextArea TResult = new JTextArea(result);

        TDesc.setLineWrap(true);
        TDesc.setWrapStyleWord(true);
        JScrollPane scroll_desc = new JScrollPane(TDesc);
        scroll_desc.setFont(new Font(null, Font.PLAIN, 50));

        TCode.setLineWrap(true);
        TCode.setWrapStyleWord(true);
        JScrollPane scroll_code = new JScrollPane(TCode);
        scroll_code.setFont(new Font(null, Font.PLAIN, 50));

        TResult.setLineWrap(true);
        TResult.setWrapStyleWord(true);
        JScrollPane scroll_result = new JScrollPane(TResult);
        scroll_result.setFont(new Font(null, Font.PLAIN, 50));

        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridy = 0;// 行
        gridBagConstraints1.gridx = 0;// 列
        gridBagConstraints1.weightx = 0.2;
        gridBagConstraints1.weighty = 0.5;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridy = 1;// 行
        gridBagConstraints2.gridx = 0;// 列
        gridBagConstraints2.weightx = 0.5;
        gridBagConstraints2.weighty = 0.5;
        gridBagConstraints2.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridy = 2;// 行
        gridBagConstraints3.gridx = 0;// 列
        gridBagConstraints3.weightx = 0.2;
        gridBagConstraints3.weighty = 0.5;
        gridBagConstraints3.fill = GridBagConstraints.BOTH;

        pal.add(scroll_desc, gridBagConstraints1);
        pal.add(scroll_code, gridBagConstraints2);
        pal.add(scroll_result, gridBagConstraints3);
        // pal2.add(TCode);
        this.add(lab);
        this.add(imagelab, BorderLayout.NORTH);

        this.add(pal);
        // this.add(pal2);

    }
}

class dialog3 extends JDialog {
    dialog3() {
        setVisible(true);
        setBounds(800, 300, 600, 400);
        // 图片
        ImageIcon icon = new ImageIcon("事件系统.png");

        JLabel imagelab = new JLabel(icon);
        JLabel lab = new JLabel("事件系统");
        JPanel pal = new JPanel();
        JPanel pal2 = new JPanel();
        pal.setLayout(new GridBagLayout());
        String des = new String();
        String code = new String();
        // 结果文件
        String result = new String();
        result = ReadFile3.readStringFromtxt();
        // System.out.println(result);
        des = "事件系统体系结构,对象或者过程,事件-过程绑定\n"
                + "特点：事件的触发这并不知道那些构件会被这些事件影响到，相互保持独立，这样就不能假定构件的处理顺序，甚至不知道哪些过程会被调用，并且哥哥构建彼此之间没有连接关系，各自独立存在，通过对事件的发布和注册实现关联\n"
                + "事件调度策略：没有独立派遣模块的事件管理器，带有独立派遣模块的事件管理器\n";

        code = "关键代码：\n" +
                "public class Subject {\n" +
                "\n" +
                "    //观察者数组\n" +
                "    private List<Observer> vector = new LinkedList<>();\n" +
                "\n" +
                "\n" +
                "    //增加一个观察者\n" +
                "    public void addObserver(Observer observer) {\n" +
                "        vector.add(observer);\n" +
                "    }\n" +
                "\n" +
                "    //删除一个观察者\n" +
                "    public void deleteObserver(Observer observer) {\n" +
                "        vector.remove(observer);\n" +
                "    }\n" +
                "\n" +
                "    //通知所有观察者\n" +
                "    public void notifyAllObserver() {\n" +
                "        for(Observer observer : vector) {\n" +
                "            observer.toDo();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    // 通知特定观察者\n" +
                "    public void notifyOneObserver(int i) {\n" +
                "        vector.get(i).toDo();\n" +
                "    }\n" +
                "\n" +
                "}";

        JTextArea TDesc = new JTextArea(des);
        JTextArea TCode = new JTextArea(code);
        JTextArea TResult = new JTextArea(result);

        TDesc.setLineWrap(true);
        TDesc.setWrapStyleWord(true);
        JScrollPane scroll_desc = new JScrollPane(TDesc);
        scroll_desc.setFont(new Font(null, Font.PLAIN, 50));

        TCode.setLineWrap(true);
        TCode.setWrapStyleWord(true);
        JScrollPane scroll_code = new JScrollPane(TCode);
        scroll_code.setFont(new Font(null, Font.PLAIN, 50));

        TResult.setLineWrap(true);
        TResult.setWrapStyleWord(true);
        JScrollPane scroll_result = new JScrollPane(TResult);
        scroll_result.setFont(new Font(null, Font.PLAIN, 50));

        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridy = 0;// 行
        gridBagConstraints1.gridx = 0;// 列
        gridBagConstraints1.weightx = 0.2;
        gridBagConstraints1.weighty = 0.5;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridy = 1;// 行
        gridBagConstraints2.gridx = 0;// 列
        gridBagConstraints2.weightx = 0.5;
        gridBagConstraints2.weighty = 0.5;
        gridBagConstraints2.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridy = 2;// 行
        gridBagConstraints3.gridx = 0;// 列
        gridBagConstraints3.weightx = 0.2;
        gridBagConstraints3.weighty = 0.5;
        gridBagConstraints3.fill = GridBagConstraints.BOTH;

        pal.add(scroll_desc, gridBagConstraints1);
        pal.add(scroll_code, gridBagConstraints2);
        pal.add(scroll_result, gridBagConstraints3);
        // pal2.add(TCode);
        this.add(lab);
        this.add(imagelab, BorderLayout.NORTH);

        this.add(pal);
        // this.add(pal2);

    }
}

class dialog4 extends JDialog {
    dialog4() {
        setVisible(true);
        setBounds(800, 300, 600, 400);
        // 图片
        ImageIcon icon = new ImageIcon("管道过滤.png");

        JLabel imagelab = new JLabel(icon);
        JLabel lab = new JLabel("管道-过滤器");
        JPanel pal = new JPanel();
        JPanel pal2 = new JPanel();
        pal.setLayout(new GridBagLayout());
        String des = new String();
        String code = new String();
        // 结果文件
        String result = new String();
        result = ReadFile4.readStringFromtxt();
        // System.out.println(result);
        des = "管道-过滤器,构件为过滤器,连接件为数据流\n"
                + "原理：递增的读取和消费数据流，过滤器在处理数据的时候不是收集然后再处理，而是在输入被完全消费之前，输出就产生了\n"
                + "优点：高并发性，实时性强\n";

        code = "关键代码：\n" +
                "public class Pipe {\n" +
                "    private Scanner pipeReader;\n" +
                "    private PrintWriter pipeWriter;\n" +
                "    Pipe(){\n" +
                "        PipedWriter pipedWriter = new PipedWriter();\n" +
                "        PipedReader pipedReader = new PipedReader();\n" +
                "        try {\n" +
                "            pipedWriter.connect(pipedReader);\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        }\n" +
                "        pipeReader = new Scanner(pipedReader);\n" +
                "        pipeWriter = new PrintWriter(pipedWriter);\n" +
                "    }\n" +
                "    public String readerLine(){\n" +
                "        return pipeReader.nextLine();\n" +
                "    }\n" +
                "    public boolean hashNextLine(){\n" +
                "        return pipeReader.hasNext();\n" +
                "    }\n" +
                "    public void writerLine(String strLine){\n" +
                "        pipeWriter.println(strLine);\n" +
                "    }\n" +
                "    public void closeReader(){\n" +
                "        pipeReader.close();\n" +
                "    }\n" +
                "    public void closeWriter(){\n" +
                "        pipeWriter.close();\n" +
                "    }\n" +
                "}\n"
                +
                "public abstract class Filter {\n" +
                "    protected Pipe input;\n" +
                "    protected Pipe output;\n" +
                "\n" +
                "    public Filter(Pipe input, Pipe output) {\n" +
                "        this.input = input;\n" +
                "        this.output = output;\n" +
                "    }\n" +
                "    protected abstract void transform() throws IOException;\n" +
                "}";

        JTextArea TDesc = new JTextArea(des);
        JTextArea TCode = new JTextArea(code);
        JTextArea TResult = new JTextArea(result);

        TDesc.setLineWrap(true);
        TDesc.setWrapStyleWord(true);
        JScrollPane scroll_desc = new JScrollPane(TDesc);
        scroll_desc.setFont(new Font(null, Font.PLAIN, 50));

        TCode.setLineWrap(true);
        TCode.setWrapStyleWord(true);
        JScrollPane scroll_code = new JScrollPane(TCode);
        scroll_code.setFont(new Font(null, Font.PLAIN, 50));

        TResult.setLineWrap(true);
        TResult.setWrapStyleWord(true);
        JScrollPane scroll_result = new JScrollPane(TResult);
        scroll_result.setFont(new Font(null, Font.PLAIN, 50));

        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridy = 0;// 行
        gridBagConstraints1.gridx = 0;// 列
        gridBagConstraints1.weightx = 0.2;
        gridBagConstraints1.weighty = 0.5;
        gridBagConstraints1.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridy = 1;// 行
        gridBagConstraints2.gridx = 0;// 列
        gridBagConstraints2.weightx = 0.5;
        gridBagConstraints2.weighty = 0.5;
        gridBagConstraints2.fill = GridBagConstraints.BOTH;

        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridy = 2;// 行
        gridBagConstraints3.gridx = 0;// 列
        gridBagConstraints3.weightx = 0.2;
        gridBagConstraints3.weighty = 0.5;
        gridBagConstraints3.fill = GridBagConstraints.BOTH;

        pal.add(scroll_desc, gridBagConstraints1);
        pal.add(scroll_code, gridBagConstraints2);
        pal.add(scroll_result, gridBagConstraints3);
        // pal2.add(TCode);
        this.add(lab);
        this.add(imagelab, BorderLayout.NORTH);

        this.add(pal);
        // this.add(pal2);

    }
}

// 读取文件
class ReadFile {
    public static String readStringFromtxt() {
        File file = new File("C:\\Users\\yelishu\\Desktop\\test2\\src\\output1.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

class ReadFile2 {
    public static String readStringFromtxt() {
        File file = new File("C:\\Users\\yelishu\\Desktop\\test2\\src\\output2.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

class ReadFile3 {
    public static String readStringFromtxt() {
        File file = new File("C:\\Users\\yelishu\\Desktop\\test2\\src\\output3.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

class ReadFile4 {
    public static String readStringFromtxt() {
        File file = new File("C:\\Users\\yelishu\\Desktop\\test2\\src\\output4.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
