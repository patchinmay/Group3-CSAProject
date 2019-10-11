package userInterface;
/**
 *
 * @author Yukang Li
 * 
 */
import java.awt.EventQueue;
import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


import Components.CC;
import Components.IR;
import Components.IX;
import Components.MAR;
import Components.MBR;
import Components.MFR;
import Components.PC;
import Components.Register;
import Components.Cache;
import Components.Devid;
import function.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UI {
	
	public static int keyboardFlag;
	public static int memory[] = new int[2048];
	//0 MAR / 1 PC / 2 MB / 3 MFR / 4 IR / 5 CC / 6 R0
	//7 R1 / 8 R2 / 9 R3 / 10 IX1 / 11 IX2 / 12 IX3
	public static int NewValue[] = new int[20];
	public static int OldValue[] = new int[20];
	public static Devid Devids[] = new Devid[32];
	public static int MAR_index=0;
	public static int PC_index=1;
	public static int MBR_index=2;
	public static int MFR_index=3;
	public static int IR_index=4;
	public static int CC_index=5;
	public static int R0_index=6;
	public static int R1_index=7;
	public static int R2_index=8;
	public static int R3_index=9;
	public static int IX1_index=10;
	public static int IX2_index=11;
	public static int IX3_index=12;
	private Tools tools = new Tools();

	public JFrame frame;
	public static JTextField MAR_textField;
	public static JTextField PC_textField;
	public static JTextField MBR_textField;
	public static JTextField MFR_textField;
	public static JTextField IR_textField;
	public static JTextField CC_textField;
	public static JTextField R0_textField;
	public static JTextField R1_textField;
	public static JTextField R2_textField;
	public static JTextField R3_textField;
	public static JTextField IX1_textField;
	public static JTextField IX2_textField;
	public static JTextField IX3_textField;
	public static JTextField Addr_textField;
	public static JTextField Value_textField;
	
	private JButton PCStore;
	private JButton MARStore;
	private JButton MBRStore;
	private JButton MFRStore;
	private JButton IRStore;
	private JButton CCStore;
	private JButton R0Store;
	private JButton R1Store;
	private JButton R2Store;
	private JButton R3Store;
	private JButton IX1Store;
	private JButton IX2Store;
	private JButton IX3Store;
	private JButton AddrQuery;
	private JButton AddrStore;
	private JButton RunInstr;
	private JButton IPL;
	private JButton Save;
	private static JButton KeyboardInput;
	
	public static PC pc = new PC();
	public static MAR mar = new MAR();
	public static MBR mbr = new MBR();
	public static MFR mfr = new MFR();
	public static IR ir = new IR(); 
	public static CC cc = new CC();
	public static Register[] r = new Register[4];
	public static IX[] ix = new IX[4];
	public static JTextArea Instr_textArea;
	public static JTextArea LogtextArea;
	public static Cache cache = new Cache();
	private JButton Singlestep;
	public static JTextField keyboardTextField;
	public static JTextField printerTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initialData();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}
	
	/**
	 * Initial the data
	 */
	public static void initialData() {
		for (int i = 0; i < Devids.length; i++) {
			Devids[i] = new Devid();
		}
		for(int i=0;i<4;i++){
		       ix[i]=new IX();
		 }
		for(int j=0;j<4;j++) {
			r[j] = new Register();
		}
		pc.setValue(2000, PC_index);
		ix[1].setValue(100, IX1_index);
	    ix[2].setValue(200, IX2_index);
	    ix[3].setValue(300, IX3_index);
	    memory[1024] = 24;
	    memory[1025] = 25;
	    memory[1026] = 26;
	 
	    memory[1028] = 28;
	    memory[1029] = 29;
	 
	    memory[1030] = 30;
	    memory[1031] = 31;
	 
	    memory[1032] = 32;
	    memory[1033] = 33;
	 
	    memory[1034] = 34;
	    memory[1035] = 35;
	 
	    memory[1036] = 36;
	    memory[1037] = 37;
	    /*new test memory*/
	    memory[1124] = 124;
	    memory[1224] = 224;
	    memory[1325] = 325;

	    memory[24] = 1024;
	    memory[25] = 1025;
	    memory[26] = 1026;
	    memory[30] = 1030;
	    memory[34] = 1034;
	    memory[36] = 1036;
	    memory[37] = 1037;

	    memory[124] = 100;
	    memory[224] = 200;
	    memory[324] = 300;
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MAR_textField = new JTextField();
		MAR_textField.setBounds(91, 80, 130, 26);
		frame.getContentPane().add(MAR_textField);
		MAR_textField.setColumns(10);
		MAR_textField.setText(Integer.toString(mar.getValue()));
		
		PC_textField = new JTextField();
		PC_textField.setColumns(10);
		PC_textField.setBounds(91, 118, 130, 26);
		frame.getContentPane().add(PC_textField);
		PC_textField.setText(Integer.toString(pc.getValue()));
		
		MBR_textField = new JTextField();
		MBR_textField.setColumns(10);
		MBR_textField.setBounds(91, 156, 130, 26);
		frame.getContentPane().add(MBR_textField);
		MBR_textField.setText(Integer.toString(mbr.getValue()));
		
		MFR_textField = new JTextField();
		MFR_textField.setColumns(10);
		MFR_textField.setBounds(91, 194, 130, 26);
		frame.getContentPane().add(MFR_textField);
		MFR_textField.setText(Integer.toString(mfr.getValue()));
		
		IR_textField = new JTextField();
		IR_textField.setColumns(10);
		IR_textField.setBounds(91, 232, 130, 26);
		frame.getContentPane().add(IR_textField);
		IR_textField.setText(Integer.toString(ir.getValue()));
		
		CC_textField = new JTextField();
		CC_textField.setText(" ");
		CC_textField.setColumns(10);
		CC_textField.setBounds(91, 270, 130, 26);
		frame.getContentPane().add(CC_textField);
		CC_textField.setText(Integer.toString(cc.getValue()));
		
		R0_textField = new JTextField();
		R0_textField.setColumns(10);
		R0_textField.setBounds(364, 80, 130, 26);
		frame.getContentPane().add(R0_textField);
		R0_textField.setText(Integer.toString(r[0].getValue()));
		
		R1_textField = new JTextField();
		R1_textField.setColumns(10);
		R1_textField.setBounds(364, 118, 130, 26);
		frame.getContentPane().add(R1_textField);
		R1_textField.setText(Integer.toString(r[1].getValue()));
		
		R2_textField = new JTextField();
		R2_textField.setColumns(10);
		R2_textField.setBounds(364, 156, 130, 26);
		frame.getContentPane().add(R2_textField);
		R2_textField.setText(Integer.toString(r[2].getValue()));
		
		R3_textField = new JTextField();
		R3_textField.setColumns(10);
		R3_textField.setBounds(364, 194, 130, 26);
		frame.getContentPane().add(R3_textField);
		R3_textField.setText(Integer.toString(r[3].getValue()));
		
		IX1_textField = new JTextField();
		IX1_textField.setColumns(10);
		IX1_textField.setBounds(364, 232, 130, 26);
		frame.getContentPane().add(IX1_textField);
		IX1_textField.setText(Integer.toString(ix[1].getValue()));
		
		IX2_textField = new JTextField();
		IX2_textField.setColumns(10);
		IX2_textField.setBounds(364, 270, 130, 26);
		frame.getContentPane().add(IX2_textField);
		IX2_textField.setText(Integer.toString(ix[2].getValue()));
		
		IX3_textField = new JTextField();
		IX3_textField.setColumns(10);
		IX3_textField.setBounds(364, 308, 130, 26);
		frame.getContentPane().add(IX3_textField);
		IX3_textField.setText(Integer.toString(ix[3].getValue()));
		
		JLabel lblMar = new JLabel("MAR");
		lblMar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMar.setBounds(27, 85, 61, 16);
		frame.getContentPane().add(lblMar);
		
		JLabel lblNewLabel = new JLabel("PC");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 123, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMbr = new JLabel("MBR");
		lblMbr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMbr.setBounds(27, 161, 61, 16);
		frame.getContentPane().add(lblMbr);
		
		JLabel lblMfr = new JLabel("MFR");
		lblMfr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfr.setBounds(27, 199, 61, 16);
		frame.getContentPane().add(lblMfr);
		
		JLabel lblIr = new JLabel("IR");
		lblIr.setHorizontalAlignment(SwingConstants.CENTER);
		lblIr.setBounds(27, 237, 61, 16);
		frame.getContentPane().add(lblIr);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setHorizontalAlignment(SwingConstants.CENTER);
		lblCc.setBounds(27, 275, 61, 16);
		frame.getContentPane().add(lblCc);
		
		JLabel lblR = new JLabel("R0");
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setBounds(313, 85, 61, 16);
		frame.getContentPane().add(lblR);
		
		JLabel lblR_1 = new JLabel("R1");
		lblR_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblR_1.setBounds(313, 123, 61, 16);
		frame.getContentPane().add(lblR_1);
		
		JLabel lblR_2 = new JLabel("R2");
		lblR_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblR_2.setBounds(313, 161, 61, 16);
		frame.getContentPane().add(lblR_2);
		
		JLabel lblR_3 = new JLabel("R3");
		lblR_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblR_3.setBounds(313, 199, 61, 16);
		frame.getContentPane().add(lblR_3);
		
		JLabel lblIxr = new JLabel("IX1");
		lblIxr.setHorizontalAlignment(SwingConstants.CENTER);
		lblIxr.setBounds(313, 237, 61, 16);
		frame.getContentPane().add(lblIxr);
		
		JLabel lblIxr_1 = new JLabel("IX2");
		lblIxr_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIxr_1.setBounds(313, 275, 61, 16);
		frame.getContentPane().add(lblIxr_1);
		
		JLabel lblIxr_2 = new JLabel("IX3");
		lblIxr_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIxr_2.setBounds(313, 313, 61, 16);
		frame.getContentPane().add(lblIxr_2);
		
		
		
		RunInstr = new JButton("Run");
		RunInstr.setBounds(125, 435, 70, 29);
		frame.getContentPane().add(RunInstr);
		
		Addr_textField = new JTextField();
		Addr_textField.setColumns(10);
		Addr_textField.setBounds(91, 37, 130, 26);
		frame.getContentPane().add(Addr_textField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(125, 20, 61, 16);
		frame.getContentPane().add(lblAddress);
		
		Value_textField = new JTextField();
		Value_textField.setColumns(10);
		Value_textField.setBounds(233, 37, 130, 26);
		frame.getContentPane().add(Value_textField);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setBounds(260, 20, 61, 16);
		frame.getContentPane().add(lblValue);
		
		AddrStore = new JButton("Store");
		AddrStore.setBounds(364, 37, 70, 29);
		frame.getContentPane().add(AddrStore);
		
		AddrQuery = new JButton("Query");
		AddrQuery.setBounds(441, 37, 70, 29);
		frame.getContentPane().add(AddrQuery);
		
		MARStore = new JButton("Store");
		MARStore.setBounds(214, 80, 70, 29);
		frame.getContentPane().add(MARStore);
		
		PCStore = new JButton("Store");
		PCStore.setBounds(214, 118, 70, 29);
		frame.getContentPane().add(PCStore);
		
		MBRStore = new JButton("Store");
		MBRStore.setBounds(214, 156, 70, 29);
		frame.getContentPane().add(MBRStore);
		
		MFRStore = new JButton("Store");
		MFRStore.setBounds(214, 194, 70, 29);
		frame.getContentPane().add(MFRStore);
		
		IRStore = new JButton("Store");
		IRStore.setBounds(214, 232, 70, 29);
		frame.getContentPane().add(IRStore);
		
		CCStore = new JButton("Store");
		CCStore.setBounds(214, 270, 70, 29);
		frame.getContentPane().add(CCStore);
		
		R0Store = new JButton("Store");
		R0Store.setBounds(490, 80, 70, 29);
		frame.getContentPane().add(R0Store);
		
		R1Store = new JButton("Store");
		R1Store.setBounds(490, 118, 70, 29);
		frame.getContentPane().add(R1Store);
		
		R2Store = new JButton("Store");
		R2Store.setBounds(490, 156, 70, 29);
		frame.getContentPane().add(R2Store);
		
		R3Store = new JButton("Store");
		R3Store.setBounds(490, 194, 70, 29);
		frame.getContentPane().add(R3Store);
		
		IX1Store = new JButton("Store");
		IX1Store.setBounds(490, 232, 70, 29);
		frame.getContentPane().add(IX1Store);
		
		IX2Store = new JButton("Store");
		IX2Store.setBounds(490, 270, 70, 29);
		frame.getContentPane().add(IX2Store);
		
		IX3Store = new JButton("Store");
		IX3Store.setBounds(490, 308, 70, 29);
		frame.getContentPane().add(IX3Store);
		
		JLabel lblInstruction = new JLabel("CardReader");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(408, 354, 86, 16);
		frame.getContentPane().add(lblInstruction);
		
		
		LogtextArea = new JTextArea();
		LogtextArea.setText("");
		LogtextArea.setBounds(623, 85, 260, 251);
		frame.getContentPane().add(LogtextArea);
		
		JScrollPane logJScrollPane = new JScrollPane(LogtextArea);
		logJScrollPane.setBounds(623, 85, 260, 251);
		frame.getContentPane().add(logJScrollPane);
		
		
		JLabel lblLog = new JLabel("Log");
		lblLog.setHorizontalAlignment(SwingConstants.CENTER);
		lblLog.setBounds(720, 60, 61, 16);
		frame.getContentPane().add(lblLog);
		
		Instr_textArea = new JTextArea();
		Instr_textArea.setText("LDR r0,00,0,11000\n"+"LDR r0,01,0,11000");
//		Instr_textArea.setText("LDR r0,00,11000,0\n" + 
//				"LDR r0,01,11000,0\n" + 
//				"LDR r1,00,11000,1\n" + 
//				"LDR r2,10,11000,1\n" + 
//				"STR r1,00,11000,0\n" + 
//				"STR r2,01,11000,0\n" + 
//				"STR r3,00,11000,1\n" + 
//				"STR r3,11,11001,1\n" + 
//				"LDA r1,00,11010,0\n" + 
//				"LDA r2,01,11001,0\n" + 
//				"LDA r3,00,11001,1\n" + 
//				"LDA r3,11,11001,1\n" + 
//				"LDX x1,11010,0\n" + 
//				"LDX x2,11010,1\n" + 
//				"STX x1,11011,0\n" + 
//				"STX x2,11100,1\n" + 
//				"HLT r0,00,00000,0");
		Instr_textArea.setBounds(330, 372, 264, 170);
		frame.getContentPane().add(Instr_textArea);
		//set the textArea could not be edited before click IPL button
		Instr_textArea.setEditable(false);
		
		JScrollPane instrScrollPane = new JScrollPane(Instr_textArea);
		instrScrollPane.setBounds(330, 372, 264, 170);
		frame.getContentPane().add(instrScrollPane);
		
		IPL = new JButton("IPL");
		IPL.setBounds(125, 394, 70, 29);
		frame.getContentPane().add(IPL);
		
		Singlestep = new JButton("SingleStep");
		Singlestep.setBounds(201, 435, 99, 29);
		frame.getContentPane().add(Singlestep);
		
		Save = new JButton("Save");
		Save.setBounds(207, 394, 70, 29);
		frame.getContentPane().add(Save);
		
		JButton P1 = new JButton("P1");
		P1.setBounds(53, 394, 70, 29);
		frame.getContentPane().add(P1);
		
		keyboardTextField = new JTextField();
		keyboardTextField.setBounds(623, 369, 130, 26);
		frame.getContentPane().add(keyboardTextField);
		keyboardTextField.setColumns(10);
		
		KeyboardInput = new JButton("input");
		KeyboardInput.setBounds(753, 369, 61, 29);
		frame.getContentPane().add(KeyboardInput);
		
		JLabel lblKeyboard = new JLabel("keyboard");
		lblKeyboard.setBounds(653, 354, 61, 16);
		frame.getContentPane().add(lblKeyboard);
		
		printerTextField = new JTextField();
		printerTextField.setColumns(10);
		printerTextField.setBounds(623, 417, 130, 125);
		frame.getContentPane().add(printerTextField);
		
		JLabel lblPrinter = new JLabel("Printer");
		lblPrinter.setBounds(664, 399, 61, 16);
		frame.getContentPane().add(lblPrinter);
		
		
		PCStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the value from the TextField
				String PCContent = PC_textField.getText();
				//determine if the textField is blank;
				if(PCContent != null) {
					int value = Integer.parseInt(PCContent);
					//if it's not blank, store data to the PC
					pc.setValue(value,PC_index);
					//PC_textField.setText(Integer.toString(pc.getValue()));
				}
			}
		});
		
		MARStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String marString = MAR_textField.getText();
				if(marString != null) {
					int value = Integer.parseInt(marString);
					mar.setValue(value, MBR_index);
					MAR_textField.setText(Integer.toString(mar.getValue()));
				}
			}
		});
		
		MBRStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mbrString = MBR_textField.getText();
				if(mbrString != null) {
					int value = Integer.parseInt(mbrString);
					mbr.setValue(value, MBR_index);
					MBR_textField.setText(Integer.toString(mbr.getValue()));
				}
			}
		});
		
		MFRStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String mfrString = MFR_textField.getText();
				if(mfrString != null) {
					int value = Integer.parseInt(mfrString);
					mfr.setValue(value,MFR_index);
					MFR_textField.setText(Integer.toString(mfr.getValue()));
				}
			}
		});
		
		IRStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String irString = IR_textField.getText();
				if(irString != null) {
					int value = Integer.parseInt(irString);
					ir.setValue(value, IR_index);
					IR_textField.setText(Integer.toString(ir.getValue()));
				}
			}
		});
		
		CCStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ccString = CC_textField.getText();
				if(ccString != null) {
					int value = Integer.parseInt(ccString);
					cc.setValue(value,CC_index);
					CC_textField.setText(Integer.toString(cc.getValue()));
				}
			}
		});
		
		R0Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r0String = R0_textField.getText();
				if(r0String != null) {
					int value = Integer.parseInt(r0String);
					r[0].setValue(value, R0_index);
					R0_textField.setText(Integer.toString(r[0].getValue()));
				}
			}
		});
		
		R1Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r1String = R1_textField.getText();
				if(r1String != null) {
					int value = Integer.parseInt(r1String);
					r[1].setValue(value, R1_index);
					R1_textField.setText(Integer.toString(r[1].getValue()));
				}
			}
		});
		
		R2Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r2String = R2_textField.getText();
				if(r2String != null) {
					int value = Integer.parseInt(r2String);
					r[2].setValue(value, R2_index);
					R2_textField.setText(Integer.toString(r[2].getValue()));
				}
			}
		});
		
		R3Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r3String = R3_textField.getText();
				if(r3String != null) {
					int value = Integer.parseInt(r3String);
					r[3].setValue(value, R3_index);
					R3_textField.setText(Integer.toString(r[3].getValue()));
				}
			}
		});
		
		IX1Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ix1String = IX1_textField.getText();
				if(ix1String != null) {
					int value = Integer.parseInt(ix1String);
					ix[1].setValue(value, IX1_index);
					IX1_textField.setText(Integer.toString(ix[1].getValue()));
				}
			}
		});
		
		IX2Store.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String ix2String = IX2_textField.getText();
						if(ix2String != null) {
							int value = Integer.parseInt(ix2String);
							ix[2].setValue(value, IX2_index);
							IX2_textField.setText(Integer.toString(ix[2].getValue()));
						}
					}
				});
		
		IX3Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ix3String = IX3_textField.getText();
				if(ix3String != null) {
					int value = Integer.parseInt(ix3String);
					ix[3].setValue(value, IX3_index);
					IX3_textField.setText(Integer.toString(ix[3].getValue()));
				}
			}
		});
		
		AddrQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addrString = Addr_textField.getText();
				if(addrString != null) {
					int addr = Integer.parseInt(addrString);
					//int value = memory[addr];
					int value = cache.returnValue(addr);
					String valueString = Integer.toString(value);
					Value_textField.setText(valueString);
				}
			}
		});
		
		/**
		 * @author Yukang Li
		 * this store button mainly use to test the function
		 */
		AddrStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String addrString = Addr_textField.getText();
				String valueString  = Value_textField.getText();
				if(addrString != null && valueString != null) {
					int add = Integer.parseInt(addrString);
					int value = Integer.parseInt(valueString);
					//memory[add] = value;
					cache.setValue(add, value);
				}
			}
		});
		
		/**
		 * save the instruction in the instrTextArea
		 * then can implement the run and singleStep function
		 */
		Save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		    	//get the address to store the first instruction 
		    	String PCAddress = PC_textField.getText();
		    	//get the instr.s in the textarea
		    	String instrs = Instr_textArea.getText();
		    	
		    	//split the instr.s and store them into the memory
		    	StoreInstr(instrs, PCAddress);
			}
		});
		
		/**
		 * execute only one instruction shown in the pc -- sep 19
		 * 
		 * actually, the function of singleStep should can be clicked many times
		 * execute the instr.s one by one
		 */
		Singlestep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				1. Get all instr. shown in the textArea and the address in [PC]
//				2. Store all instr. 
//				3. execute the first instr.
//				4. the value of PC should be plus one - [PC]+1
				String addString = PC_textField.getText();
				int add = Integer.parseInt(addString);
				singleExecute(add);
			}
		});
		
		/**
		 * when user click the IPL button, user would be allowed to type
		 * in the instruction area. 
		 */
		IPL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Instr_textArea.setEditable(true);
			}
		});
		
		/**
		 * Run instr.s
		 */
		RunInstr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		
		KeyboardInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//get keyboard value, put it to keyboard(devid[0])
				Devids[0].setValue(Integer.parseInt(keyboardTextField.getText()));
				Instr.IN(0, 0);
				Instr.OUT(0, 1);
				//change the keyboard flag
				//clear the keyboard Textfield
				keyboardTextField.setText("");
			}
		});
	}
	
	/**
	 * 2. get the address in the [PC] 
	 * 3. Put it to the [MAR] 
	 * 4. Get the instruction from memory 
	 * 5. Put the decimal instruction to [MBR] 
	 * 6. Put the instruction to [IR] 
	 * 	1. [IR] decode the instruction from Decimal to String 
	 * 	2. Get OpCode, R, IX, I, Address
	 * @author Yukang Li 
	 */
    public boolean singleExecute(int address) {

    	//get address from pc (Hexadecimal Format String)
    	//transfer hexadecimal to decimal in the next step
    	
    	//get the instr. from memory
    	//transfer hexadecimal to decimal
    	//iAddress means address in int format
    	//int iAddress = tools.strHexa2decimal(address);
    	//put it to mar
    	MAR_textField.setText(Integer.toString(address));
    	mar.setValue(address, MAR_index);
    	//value is the instr.
    	//int value = memory[address];
    	int value = cache.returnValue(address);
    	
    	//put the instr. to the mbr & ir
    	MBR_textField.setText(Integer.toString(value));
    	mbr.setValue(value, MBR_index);
    	IR_textField.setText(Integer.toString(value));
    	ir.setValue(value, IR_index);
    	//decode & execute the instr. 
    	int  i = analysisInstr(value);
    	if(i == 1) {
    		return false;
    	}
    	pc.setValue(pc.getValue()+1,PC_index);
    	PC_textField.setText(Integer.toString(pc.getValue()));
    	return true;
    }
    
    /**
     * Batch execution instr.s
     * @author Yukang Li
     */
    public void run() {
    	//get the address to store the first instruction 
    	String address = PC_textField.getText();
    	//convert the address to decimal, so that could be calculated
    	int iAddress = Integer.parseInt(address);
    	//execute the instr.s
    	Boolean status = true;
    	while (status) {
			status = singleExecute(iAddress);
			iAddress++;
		}
    }
    
    /**
     * analysis the instr. and use different instr. func.
     * @param instr
     * @author Yukang Li
     */
    public int analysisInstr(int instr) {
    	//once face the HLT instr. change the status to 1;
    	int status = 0;
    	//array contain opCode, register, indexRegister, indirect, address
    	int[] array = tools.decodeInstr(instr);
    	int opCode = array[0];
    	int r;
    	int ix;
    	int i;
    	int address;
    	int Rx;
    	int Ry;
    	int AL;
    	int LR;
    	int Count;
    	int DevID;
    	int cc;
    	int immed;
    	int trapCode;
    	switch (opCode) {
		case 1:
			//01 -- LDR
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.LDR(r, ix, i, address);
			break;
		case 2:
			//02 -- STR
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.STR(r, ix, i, address);
			break;
		case 3:
			//03 -- LDA
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.LDA(r, ix, i, address);
			break;
		case 41:
			//41 -- LDX
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.LDX(ix, i, address);
			break;
		case 42:
			//42 -- STX
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.STX(ix, i, address);
			break;
		case 10:
			//10 -- JZ
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JZ(r, ix, i, address);
			break;
		case 11:
			//11 -- JNE
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JNE(r, ix, i, address);
			break;
		case 12:
			//12 -- JCC
			cc = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JCC(cc, ix, i, address);
			break;
		case 13:
			//13 -- JMA
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JMA(ix, i, address);
			break;
		case 14:
			//14 --  JSR
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JSR(ix, i, address);
			break;
		case 15:
			//15 -- RFS
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.RFS();
			break;
		case 16:
			//16 -- SOB
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.SOB(r, ix, i, address);
			break;
		case 17:
			//17 -- JGE
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.JGE(r, ix, i, address);
			break;
		case 04:
			//04 -- AMR
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.AMR(r, ix, i, address);
			break;
		case 05:
			//05 -- SMR
			r = array[1];
			ix = array[2];
			i = array[3];
			address = array[4];
			Instr.SMR(r, ix, i, address);
			break;
		case 06:
			//06 -- AIR
			r = array[1];
			immed = array[4];
			Instr.AIR(r, immed);
			break;
		case 07:
			//07 -- SIR
			r = array[1];
			immed = array[4];
			Instr.SIR(r, immed);
			break;
		case 20:
			//20 -- MLT
			Rx = array[1];
			Ry = array[2];
			Instr.MLT(Rx, Ry);
			break;
		case 21:
			//21 -- DVD
			Rx = array[1];
			Ry = array[2];
			Instr.DVD(Rx, Ry);
			break;
		case 22:
			//22 -- TRR
			Rx = array[1];
			Ry = array[2];
			Instr.TRR(Rx, Ry);
			break;
		case 23:
			//23 -- AND
			Rx = array[1];
			Ry = array[2];
			Instr.AND(Rx, Ry);
			break;
		case 24:
			//24 -- ORR
			Rx = array[1];
			Ry = array[2];
			Instr.ORR(Rx, Ry);
			break;
		case 25:
			//25 --NOT
			Rx = array[1];
			Instr.NOT(Rx);
			break;
		case 31:
			//31 -- SRC
			r = array[1];
			AL = array[2];
			LR = array[3];
			Count = array[4];
			Instr.SRC(r, Count, LR, AL);
			break;
		case 32:
			//32 -- RRC
			r = array[1];
			AL = array[2];
			LR = array[3];
			Count = array[4];
			Instr.RRC(r, Count, LR, AL);
			break;
		case 61:
			//61 -- IN
			r = array[1];
			DevID = array[2];
			Instr.IN(r, DevID);
			break;
		case 62:
			//62 -- OUT
			r = array[1];
			DevID = array[2];
			Instr.OUT(r, DevID);
			break;
		case 63:
			//63 -- CHK
			r = array[1];
			DevID = array[2];
			break;
		case 36:
			//36 -- TRAP
			trapCode = array[1];
			break;
		case 00:
			//00 -- HLT
			status = 1;
			break;
		default:
			break;
		}
    	return status;
    }
    

	/**
	 * this function mainly get the instr.s and the address,
	 * then store those instr.s to the memory
	 * @author Chinmay
	 * @param a
	 * @param pc1
	 */
	public void StoreInstr(String a, String pc1) {
		int pc = Integer.parseInt(pc1);
		String[] lines = a.split("\n");
		for (String line : lines) {
			//System.out.println("contents in the line " + line);
			ReadInputBox(line, pc);
			
			pc= pc+1;
		}

	}
	
	/**
	 * @author Chinmay
	 * @param r
	 * @param pc
	 */
	public void ReadInputBox(String r, int pc) {
			//String r = "";
			// This string variable is used for scanning the values of each line from text
			// area.
		String str = "";
		String ins, ins1, reg, ireg, mem, indirectAdd,reg2;
		ins = r.substring(0, 3);
		ins1 = r.substring(0, 2);
		if (ins.equals("LDR") || ins.equals("STR") || ins.equals("LDX") || ins.equals("STX") || ins.equals("LDA")) {
			//ins = r.substring(0, 3);
			reg = r.substring(4, 6);
			ireg = r.substring(7, 9);
			indirectAdd = r.substring(10,11);
			mem = r.substring(12,17);

			if (ins.equals("LDR")) {
				ins = "000001";
			} else if (ins.equals("STR")) {
				ins = "000010";
			} else if (ins.equals("LDA")) {
				ins = "000011";
			} else if (ins.equals("LDX")) {
				ins = "101001";
			} else if (ins.equals("STX")) {
				ins = "101010";

			} else if (ins.equals("HLT")) {
				ins = "000000";

			} else {
				ins = "000000";
			}

			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}

//			if (ireg.equals("x1")) {
//				ireg = "01";
//			} else if (ireg.equals("x2")) {
//				ireg = "10";
//			} else if (ireg.equals("x3")) {
//				ireg = "11";
//			}
			
			str = ins + reg + ireg +  indirectAdd +mem ;
			
		} else if(ins1.equals("JZ")) {
			
			//Transfer instructions
			reg = r.substring(3, 5);
			ireg = r.substring(6, 8);
			mem = r.substring(10, 15);
			indirectAdd = r.substring(9);
			
			if(ins1.equals("JZ")) {
				ins1 = "001010";
			}
			
			
			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}

			if (ireg.equals("x1")) {
				ireg = "01";
			} else if (ireg.equals("x2")) {
				ireg = "10";
			} else if (ireg.equals("x3")) {
				ireg = "11";
			}
			
			str = ins1 + reg + ireg +  indirectAdd +mem ;

		}
		
		else if ( ins.equals("JNE") || ins.equals("JCC") || ins.equals("JMA")
				|| ins.equals("JSR	") || ins.equals("RFS") || ins.equals("SOB") || ins.equals("JGE")) {

			reg = r.substring(4, 6);
			ireg = r.substring(7, 9);
			mem = r.substring(11, 16);
			indirectAdd = r.substring(10);



			if (ins.equals("JNE")) {
				ins = "001011";
			} else if (ins.equals("JCC")) {
				ins = "001100";
			} else if (ins.equals("JMA")) {
				ins = "001101";
			} else if (ins.equals("JSR")) {
				ins = "001110";
			} else if (ins.equals("RFS")) {
				ins = "001111";
			} else if (ins.equals("SOB")) {
				ins = "010000";

			} else if(ins.equals("JGE")){
				ins = "010001";

			} else if (ins.equals("HLT")){
				ins = "00000";
			}else {
				ins = "00000";

			}
			

			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}

			if (ireg.equals("x1")) {
				ireg = "01";
			} else if (ireg.equals("x2")) {
				ireg = "10";
			} else if (ireg.equals("x3")) {
				ireg = "11";
			}
			
			str = ins + reg + ireg +  indirectAdd +mem ;
			
		}
		
		else if (ins.equals("AMR") || ins.equals("SMR") ) {

			//Arithmetic and logical instructions
			reg = r.substring(4, 6);
			ireg = r.substring(7, 9);
			mem = r.substring(11, 16);
			indirectAdd = r.substring(10);



			if (ins.equals("AMR")) {
				ins = "000100";
			} else if (ins.equals("SMR")) {
				ins = "000101";
			}

			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}

			if (ireg.equals("x1")) {
				ireg = "01";
			} else if (ireg.equals("x2")) {
				ireg = "10";
			} else if (ireg.equals("x3")) {
				ireg = "11";
			}
			
			
			str = ins + reg + ireg +  indirectAdd +mem ;

			
			
		}
		else if (ins.equals("AIR") || ins.equals("SIR")) {

			//Arithmetic and logical instructions
			reg = r.substring(4, 6);
			//ireg = r.substring(7, 9);
			
			String immed = r.substring(7,12);
			String blacked = "000";
			
			if (reg.equals("r0")) {
				reg = "00";
			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}
			
			str = ins + reg + blacked;
			
		}
		
		else if (ins.equals("MLT") || ins.equals("DVD") || ins.equals("TRR") || ins.equals("AND") || ins.equals("ORR")) {
			
			
			//Arithmetic part 2
			//Instructions of the type MLT Rx,Ry
			
			reg = r.substring(4, 6);
			reg2 = r.substring(7,9);
			String blacked = "000000";
			if(ins.equals("MLT")) {
				ins = "010100";
			}else if(ins.equals("DVD")) {
				ins = "010101";
			}else if(ins.equals("TRR")) {
				ins = "010110";
			}else if(ins.equals("AND")) {
				ins = "010111";
			}else if(ins.equals("ORR")) {
				ins = "011000";
			}
			
			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}
			
			if (reg2.equals("r0")) {
				reg2 = "00";

			} else if (reg2.equals("r1")) {
				reg2 = "01";
			} else if (reg2.equals("r2")) {
				reg2 = "10";
			} else if (reg2.equals("r3")) {
				reg2 = "11";
			}
			
			str = ins + reg + reg2+ blacked;
		}
		
		else if ( ins.equals("NOT")) {
			
			
			//Arithmetic part 2
			//Instructions of the type MLT Rx,Ry
			
			reg = r.substring(4, 6);
			String blacked = "00000000";
			ins = "011001";
			
			
			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}

			
			str = ins + reg + blacked;
		}
		
		else if (ins.equals("SRC") || ins.equals("RRC")) {
			// logical rotate
			String count,R,LR,AL;
			R = r.substring(5);
			count = r.substring(7);
			LR = r.substring(9);
			AL = r.substring(11);
			String blacked= "00";
			if(ins.equals("SRC")) {
				ins = "011111";
			}else if(ins.equals("RRC")) {
				ins = "100000";
			}
			
			if(R.equals("0")) {
				R = "00";
			}else if(R.equals("1")) {
				R = "01";
			}else if(R.equals("2")) {
				R = "10";
			}else if(R.equals("3")) {
				R = "11";
			} 
			
			if(LR.equals("0")) {
				LR = "00";
			}else if(LR.equals("1")) {
				LR = "01";
			}
			
			if(AL.equals("0")) {
				AL = "00";
			}else if(AL.equals("1")) {
				AL = "01";
			}
			int a = Integer.parseInt(count);
			count = Integer.toBinaryString(a);
			
//			if(count.equals("1")){
//				count = "00";
//			}else if(count.equals("1")) {
//				count = "01";
//			}else if(count.equals("2")) {
//				count = "10";
//			}else if(count.equals("3")) {
//				count = "11";
//			} 
			
			str = ins + count + R + LR +AL+ blacked;
		}
		
		
		else if(ins.equals("OUT") || ins.equals("CHK")){
			// I/O operation.
			reg = r.substring(4, 6);
			String DevId = r.substring(7,9);
			if(ins.equals("OUT")) {
				ins = "111110";
			}else if(ins.equals("CHK")) {
				ins = "111111";
			}
			
			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}
			int a = Integer.parseInt(DevId);
			DevId = Integer.toBinaryString(a);
			String blacked = "000";
			str = ins + reg + DevId + blacked;
			
		}
		else if(ins1.equals("IN")) {
			ins1 = "111101";
			reg = r.substring(3, 5);
			String DevId = r.substring(6,11);

			if (reg.equals("r0")) {
				reg = "00";

			} else if (reg.equals("r1")) {
				reg = "01";
			} else if (reg.equals("r2")) {
				reg = "10";
			} else if (reg.equals("r3")) {
				reg = "11";
			}
			//int a = Integer.parseInt(DevId);
			//DevId = Integer.toBinaryString(a);
			String blacked = "000";
			str = ins1 + reg + blacked + DevId ;
			//commiting the code
		}

			int result = Integer.parseInt(str, 2);
			//memory[pc] = result;
			cache.setValue(pc, result);
			
	}
	
}
