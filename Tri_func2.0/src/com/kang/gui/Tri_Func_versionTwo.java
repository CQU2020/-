package com.kang.gui;
import com.kang.function.*;

/**
 * 使用swing框架设计一个计算三角函数的界面
 * 本次基于1.0版本中设计的计算三角函数的demo，使用了swing框架做了一个GUI界面
 *  使用界面的形式将三角函数的结果显示出来，整个代码的灵魂依然是1.0版中的算法。
 * 使用流程：
 *      1：点击界面中的数字按钮，输入想要的数字
 *      2：然后依次点击"sin","cos","tan"按钮，就可以得到三角函数结果值
 *      3：点击"="有惊喜哦。
 *
 * @author 康
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Tri_Func_versionTwo extends JFrame implements ActionListener {
    // 新建一个自定义三角函数类，方便后面计算时调用
    trigonometricFunc tri = new trigonometricFunc();
    // operate_number代表第几个操作数，等于0代表第一个，等于1代表第二个。
    int operate_number = 0;
    // 代表是否有小数点，1是0非
    int operate_decimal = 0;
    // number_1代表操作数
    double number_1;
    // t用来迭代浮点数
    double t = 10.0;
    // 创建面板1
    JPanel panel = new JPanel();
    // 创建面板2，并设置网格为4行4列
    JPanel pane2 = new JPanel(new GridLayout(4, 4,8,8));
    // 创建文本框
    JTextField tf = new JTextField();
    //定义按钮
    JButton bu0 = new JButton("0");
    JButton bu1 = new JButton("1");
    JButton bu2 = new JButton("2");
    JButton bu3 = new JButton("3");
    JButton bu4 = new JButton("4");
    JButton bu5 = new JButton("5");
    JButton bu6 = new JButton("6");
    JButton bu7 = new JButton("7");
    JButton bu8 = new JButton("8");
    JButton bu9 = new JButton("9");
    JButton bu_dian = new JButton(".");
    JButton bu_clean = new JButton("删除");
    JButton bu_sin = new JButton("sin");
    JButton bu_cos = new JButton("cos");
    JButton bu_tan = new JButton("tan");
    //JButton bu_cot = new JButton("cot");
    JButton bu_dengyu = new JButton("=");

    // 构造函数
    public  Tri_Func_versionTwo(){
        // 设置一个字符串来判断你究竟选择的是哪一个组件
        tf.setEditable(false);
        bu0.setActionCommand("0");
        bu1.setActionCommand("1");
        bu2.setActionCommand("2");
        bu3.setActionCommand("3");
        bu4.setActionCommand("4");
        bu5.setActionCommand("5");
        bu6.setActionCommand("6");
        bu7.setActionCommand("7");
        bu8.setActionCommand("8");
        bu9.setActionCommand("9");
        bu_dian.setActionCommand(".");
        bu_clean.setActionCommand("删除");
        bu_sin.setActionCommand("sin");
        bu_cos.setActionCommand("cos");
        bu_tan.setActionCommand("tan");
        //bu_cot.setActionCommand("cot");
        bu_dengyu.setActionCommand("=");

        // 增加监听事件
        bu0.addActionListener(this);
        bu1.addActionListener(this);
        bu2.addActionListener(this);
        bu3.addActionListener(this);
        bu4.addActionListener(this);
        bu5.addActionListener(this);
        bu6.addActionListener(this);
        bu7.addActionListener(this);
        bu8.addActionListener(this);
        bu9.addActionListener(this);
        bu_dian.addActionListener(this);
        bu_clean.addActionListener(this);
        bu_sin.addActionListener(this);
        bu_cos.addActionListener(this);
        bu_tan.addActionListener(this);
        //bu_cot.addActionListener(this);
        bu_dengyu.addActionListener(this);

        tf.setPreferredSize(new Dimension(465, 40));
        tf.setFont(new Font("宋体", Font.PLAIN, 28));
        Font f1 = new Font("仿宋",  Font.BOLD, 25);
        Font f2 = new Font("仿宋", Font.BOLD, 21);
        // 给每个按钮设置字体样式,美化作用，也可以不用添加下面的处理
        bu0.setFont(f1);
        bu1.setFont(f1);
        bu2.setFont(f1);
        bu3.setFont(f1);
        bu4.setFont(f1);
        bu5.setFont(f1);
        bu6.setFont(f1);
        bu7.setFont(f1);
        bu8.setFont(f1);
        bu9.setFont(f1);
        bu_dian.setFont(f1);
        bu_clean.setFont(f2);
        bu_sin.setFont(f1);
        bu_cos.setFont(f1);
        bu_tan.setFont(f1);
        //bu_cot.setFont(f1);
        bu_dengyu.setFont(f1);
        // 文本框添加在面板1最上面
        panel.add(tf);
        this.add(panel,BorderLayout.NORTH);
        // 网格布局，按顺序添加按钮
        pane2.add(bu7);
        pane2.add(bu8);
        pane2.add(bu9);
        pane2.add(bu_sin);
        pane2.add(bu4);
        pane2.add(bu5);
        pane2.add(bu6);
        pane2.add(bu_cos);
        pane2.add(bu1);
        pane2.add(bu2);
        pane2.add(bu3);
        pane2.add(bu_tan);
        pane2.add(bu0);
        pane2.add(bu_dian);
        pane2.add(bu_clean);
        pane2.add(bu_dengyu);

        // 设置计算器界面名称，布局等
        this.setTitle("三角函数计算器——TEAM");
        this.add(pane2, BorderLayout.CENTER); // 居中
        this.setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //操作处理
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("1")){
            opt(1);
        }else if (e.getActionCommand().equals("2")) {
            opt(2);
        } else if (e.getActionCommand().equals("3")) {
            opt(3);
        } else if (e.getActionCommand().equals("4")) {
            opt(4);
        } else if (e.getActionCommand().equals("5")) {
            opt(5);
        } else if (e.getActionCommand().equals("6")) {
            opt(6);
        } else if (e.getActionCommand().equals("7")) {
            opt(7);
        } else if (e.getActionCommand().equals("8")) {
            opt(8);
        } else if (e.getActionCommand().equals("9")) {
            opt(9);
        } else if (e.getActionCommand().equals("0")) {
            opt(0);
        }else if(e.getActionCommand().equals(".")){
            operate_decimal = 1;
        }else if(e.getActionCommand().equals("=")){
            send_msg();
            this.operate_number = 0;
            this.number_1 = 0;
            this.t = 10.0;
            this.operate_decimal = 0;
        }else if(e.getActionCommand().equals("删除")){
            // 删除操作，统一归零
            tf.setText("");
            this.operate_decimal = 0;
            this.operate_number = 0;
            this.t = 10.0;
            this.number_1 = 0;
        }else if(e.getActionCommand().equals("sin")){
            this.number_1 = tri.sin(this.number_1);
            tf.setText(String.valueOf(number_1));
        }else if(e.getActionCommand().equals("cos")){
            this.number_1 = tri.cos(this.number_1);
            tf.setText(String.valueOf(number_1));
        }else if(e.getActionCommand().equals("tan")){
            this.number_1 = tri.tan(this.number_1);
            tf.setText(String.valueOf(number_1));
        }
    }

    // 具体操作
    public void opt(int number){
        if(this.operate_number == 0){
            //
            if(this.operate_decimal == 0){
                this.number_1 = this.number_1 * 10 + number;
                tf.setText(String.valueOf((int) this.number_1));
            }else{
                double d_number;
                d_number = (double) number / t;
                t = t * 10.0;
                this.number_1 += d_number;
                BigDecimal BD = new BigDecimal(this.number_1); // 四舍五入取值
                double dd = BD.setScale(8, BigDecimal.ROUND_HALF_DOWN).doubleValue();
                tf.setText(String.valueOf(dd));
                }
        }
    }
    // 定义"="号操作
    public void send_msg(){
        tf.setText(String.valueOf("PHP是世界上最好的语言"));
    }

    public static void main(String[] args) {
        Tri_Func_versionTwo tri_func_versionTwo = new Tri_Func_versionTwo();
    }
}
