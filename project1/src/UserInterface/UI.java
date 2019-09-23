package UserInterface;
/**
 *
 * @author Yukang Li
 * 
 */
import java.awt.EventQueue;

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
import function.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UI {
	
	private static int memory[] = new int[2048];
	private Tools tools = new Tools();

	private JFrame frame;
	private JTextField MAR_textField;
	private JTextField PC_textField;
	private JTextField MBR_textField;
	private JTextField MFR_textField;
	private JTextField IR_textField;
	private JTextField CC_textField;
	private JTextField R0_textField;
	private JTextField R1_textField;
	private JTextField R2_textField;
	private JTextField R3_textField;
	private JTextField IX1_textField;
	private JTextField IX2_textField;
	private JTextField IX3_textField;
	private JTextField Addr_textField;
	private JTextField Value_textField;
	
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
	
	private static PC pc = new PC();

	private static MAR mar = new MAR();
	private static MBR mbr = new MBR();
	private static MFR mfr = new MFR();
	private static IR ir = new IR(); 
	private static CC cc = new CC();
	private static Register r0 = new Register();
	private static Register r1 = new Register();
	private static Register r2 = new Register();
	private static Register r3 = new Register();
	//private static IX ix[] = new IX[3];
	private static IX[] ix = new IX[4];
	private JTextArea Instr_textArea;
	private JTextArea LogtextArea;
	private JButton Singlestep;

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
		for(int i=0;i<4;i++){
		       ix[i]=new IX();
		 }
//		  ix[1].setValue(1024);
//		  ix[2].setValue(25);
//		  ix[3].setValue(331);
//		  memory[1024] = 24;
//		  memory[1025] = 25;
//		  memory[1026] = 26;
//	
//		  memory[1028] = 28;
//		  memory[1029] = 29;
//	
//		  memory[1030] = 30;
//		  memory[1031] = 31;
//	
//		  memory[1032] = 32;
//		  memory[1033] = 33;
//	
//		  memory[1034] = 34;
//		  memory[1035] = 35;
//	
//		  memory[1036] = 36;
//		  memory[1037] = 37;
//	
//		  memory[25] = 1025;
//		  memory[26] = 1026;
//		  memory[30] = 1030;
//		  memory[34] = 1034;
//		  memory[36] = 1036;
//		  memory[37] = 1037;
//	
//		  memory[331] = 1331;
//		  memory[335] = 1335;
		pc.setValue(2000);
		ix[1].setValue(100);
	    ix[2].setValue(200);
	    ix[3].setValue(300);
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
		R0_textField.setText(Integer.toString(r0.getValue()));
		
		R1_textField = new JTextField();
		R1_textField.setColumns(10);
		R1_textField.setBounds(364, 118, 130, 26);
		frame.getContentPane().add(R1_textField);
		R1_textField.setText(Integer.toString(r1.getValue()));
		
		R2_textField = new JTextField();
		R2_textField.setColumns(10);
		R2_textField.setBounds(364, 156, 130, 26);
		frame.getContentPane().add(R2_textField);
		R2_textField.setText(Integer.toString(r2.getValue()));
		
		R3_textField = new JTextField();
		R3_textField.setColumns(10);
		R3_textField.setBounds(364, 194, 130, 26);
		frame.getContentPane().add(R3_textField);
		R3_textField.setText(Integer.toString(r3.getValue()));
		
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
		
		JLabel lblInstruction = new JLabel("Instruction");
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(408, 344, 86, 16);
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
		lblLog.setBounds(722, 60, 61, 16);
		frame.getContentPane().add(lblLog);
		
		Instr_textArea = new JTextArea();
		Instr_textArea.setText("LDR r0,00,11000,0\n" + 
				"LDR r0,01,11000,0\n" + 
				"LDR r1,00,11000,1\n" + 
				"LDR r2,10,11000,1\n" + 
				"STR r1,00,11000,0\n" + 
				"STR r2,01,11000,0\n" + 
				"STR r3,00,11000,1\n" + 
				"STR r3,11,11001,1\n" + 
				"LDA r1,00,11010,0\n" + 
				"LDA r2,01,11001,0\n" + 
				"LDA r3,00,11001,1\n" + 
				"LDA r3,11,11001,1\n" + 
				"LDX x1,11010,0\n" + 
				"LDX x2,11010,1\n" + 
				"STX x1,11011,0\n" + 
				"STX x2,11100,1\n" + 
				"HLT r0,00,00000,0");
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
		
		
		
		
		PCStore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//get the value from the TextField
				String PCContent = PC_textField.getText();
				//determine if the textField is blank;
				if(PCContent != null) {
					int value = Integer.parseInt(PCContent);
					//if it's not blank, store data to the PC
					pc.setValue(value);
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
					mar.setValue(value);
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
					mbr.setValue(value);
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
					mfr.setValue(value);
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
					ir.setValue(value);
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
					cc.setValue(value);
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
					r0.setValue(value);
					R0_textField.setText(Integer.toString(r0.getValue()));
				}
			}
		});
		
		R1Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r1String = R1_textField.getText();
				if(r1String != null) {
					int value = Integer.parseInt(r1String);
					r1.setValue(value);
					R1_textField.setText(Integer.toString(r1.getValue()));
				}
			}
		});
		
		R2Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r2String = R2_textField.getText();
				if(r2String != null) {
					int value = Integer.parseInt(r2String);
					r2.setValue(value);
					R2_textField.setText(Integer.toString(r2.getValue()));
				}
			}
		});
		
		R3Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String r3String = R3_textField.getText();
				if(r3String != null) {
					int value = Integer.parseInt(r3String);
					r3.setValue(value);
					R3_textField.setText(Integer.toString(r3.getValue()));
				}
			}
		});
		
		IX1Store.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ix1String = IX1_textField.getText();
				if(ix1String != null) {
					int value = Integer.parseInt(ix1String);
					ix[1].setValue(value);
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
							ix[2].setValue(value);
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
					ix[3].setValue(value);
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
					int value = memory[addr];
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
					memory[add] = value;
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
    	mar.setValue(address);
    	//value is the instr.
    	int value = memory[address];
    	//put the instr. to the mbr & ir
    	MBR_textField.setText(Integer.toString(value));
    	mbr.setValue(value);
    	IR_textField.setText(Integer.toString(value));
    	ir.setValue(value);
    	//decode & execute the instr. 
    	int  i = analysisInstr(value);
    	if(i == 1) {
    		return false;
    	}
    	pc.setValue(pc.getValue()+1);
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
    	int r = array[1];
    	int ix = array[2];
    	int i = array[3];
    	int address = array[4];
    	switch (opCode) {
		case 1:
			//01 -- LDR
			LDR(r, ix, i, address);
			break;
		case 2:
			//02 -- STR
			STR(r, ix, i, address);
			break;
		case 3:
			//03 -- LDA
			LDA(r, ix, i, address);
			break;
		case 41:
			//41 -- LDX
			LDX(ix, i, address);
			break;
		case 42:
			//42 -- STX
			STX(ix, i, address);
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
     * LDR instr. -- Load Register From Memory
     * @author Yukang Li
     * @param r
     * @param ix
     * @param i
     * @param address
     */
	public void LDR(int r, int ix, int i, int address) {
		//Get OpCode, R, IX, I, Address
		//analysis the Effective function first
		//determine using the indrect addressing
		if(i == 0) {
			//determine using the index register 
			if(ix <=3 && ix>=1) {
				address = UI.ix[ix].getValue() + address;
			}
		}else {
			//indirect addressing
		}
		//1. Get the address of data [IR]
		IR_textField.setText(Integer.toString(address));
		ir.setValue(address);
		//2. Transmit address to [MAR]
		MAR_textField.setText(Integer.toString(address));
		mar.setValue(address);
		//3. Get data from memory and put it to [MBR]
		int value = memory[address];
		MBR_textField.setText(Integer.toString(value));
		mbr.setValue(value);
		int MAR1 = mar.getValue();
		int MBR1 = mbr.getValue();
		System.out.println(MAR1);
		LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		LogtextArea.append("MBR:"+ MBR1 + "->" + value+"\n");
		//4. Put data to the specified [Register]
		switch (r) {
		case 0:
			int aa = r0.getValue();
			R0_textField.setText(Integer.toString(value));
			r0.setValue(value);
			LogtextArea.append("R0:"+aa+"->"+value+"\n");
			break;
		case 1:
			int a1 = r1.getValue();
			R1_textField.setText(Integer.toString(value));
			r1.setValue(value);
			LogtextArea.append("R1:"+a1+"->"+value+"\n");
			break;
		case 2:
			int a2 = r2.getValue();
			R2_textField.setText(Integer.toString(value));
			r2.setValue(value);
			LogtextArea.append("R2:"+a2+"->"+value+"\n");
			break;
		case 3:
			int a3 = r3.getValue();
			R3_textField.setText(Integer.toString(value));
			r3.setValue(value);
			LogtextArea.append("R3:"+a3+"->"+value+"\n");
			break;

		default:
			break;
		}
	}
	
	/**
	 * STR instr. -- Store Register To Memory
	 * @author Yukang Li
	 * @param r
	 * @param ix
	 * @param i
	 * @param address
	 */
	public void STR(int r, int ix, int i, int address) {
        //Get the address(where to store data) [IR]
		IR_textField.setText(Integer.toString(address));
		ir.setValue(address);
        //Transmit address to [MAR]
		MAR_textField.setText(Integer.toString(address));
		mar.setValue(address);
        //Get data from [Register] and put it to [MBR]
		int value = 0;
		int MAR1 = mar.getValue();
		LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		int MBR1 = mbr.getValue();
		LogtextArea.append("MBR:"+ MBR1 + "->" + address+"\n");
		switch (r) {
		case 0:
			int OriginDataR0 = r0.getValue();
			value = r0.getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			LogtextArea.append("R0:"+ OriginDataR0 + "->" + value+"\n");
			break;
		case 1:
			int OriginDataR1 = r1.getValue();
			value = r1.getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			LogtextArea.append("R1:"+ OriginDataR1 + "->" + value+"\n");
			break;
		case 2:
			int OriginDataR2 = r2.getValue();
			value = r2.getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			LogtextArea.append("R2:"+ OriginDataR2 + "->" + value+"\n");
			break;
		case 3:
			int OriginDataR3 = r3.getValue();
			value = r3.getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			LogtextArea.append("R3:"+ OriginDataR3 + "->" + value+"\n");
			break;

		default:
			break;
		}
		//Put data to the memory
		memory[address] = value;
	}
	
	/**
	 * LDA instr. -- Load Register with Address
	 * @author Yukang Li
	 * @param r
	 * @param ix
	 * @param i
	 * @param address
	 */
	public void LDA (int r, int ix, int i, int address) {
        //Get the address [IR]
		IR_textField.setText(Integer.toString(address));
		ir.setValue(address);
        //Transmit address to [MBR]
		MBR_textField.setText(Integer.toString(address));
		mbr.setValue(address);
        //Put the data to the specified [Register]
		int MBR1 = mbr.getValue();
		LogtextArea.append("MBR:"+ MBR1 + "->" + address+"\n");
		switch (r) {
		case 0:
			r0.setValue(address);
			R0_textField.setText(Integer.toString(address));
			break;
		case 1:
			r1.setValue(address);
			R1_textField.setText(Integer.toString(address));
			break;
		case 2:
			r2.setValue(address);
			R2_textField.setText(Integer.toString(address));
			break;
		case 3:
			r3.setValue(address);
			R3_textField.setText(Integer.toString(address));
			break;

		default:
			break;
		}
	}
	
	/**
	 * LDX instr. -- Load Index Register from Memory
	 * @author Yukang Li
	 * @param ix
	 * @param i
	 * @param address
	 */
	public void LDX(int ix, int i, int address) {
        //Get the address of data [IR]
		IR_textField.setText(Integer.toString(address));
		ir.setValue(address);
        //Transmit address to [MAR]
		MAR_textField.setText(Integer.toString(address));
		mar.setValue(address);
        //Get data and put it to [MBR]
		int value = memory[address];
		MBR_textField.setText(Integer.toString(value));
		mbr.setValue(value);
		int MAR1 = mar.getValue();
		int MBR1 = mbr.getValue();

		LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		LogtextArea.append("MBR:"+ MBR1 + "->" + value+"\n");
        //Put data to the specified [Index Register]
		switch (ix) {
		case 1:
			UI.ix[1].setValue(value);
			IX1_textField.setText(Integer.toString(value));
			break;
		case 2:
			UI.ix[2].setValue(value);
			IX2_textField.setText(Integer.toString(value));
			break;
		case 3:
			UI.ix[2].setValue(value);
			IX2_textField.setText(Integer.toString(value));
			break;

		default:
			break;
		}
	}

	/**
	 * STX instr. -- Store Index Register to Memory
	 * @author Yukang Li
	 * @param ix
	 * @param i
	 * @param address
	 */
	public void STX(int ix, int i, int address) {

        //Get the address(where to store data) [IR]
		IR_textField.setText(Integer.toString(address));
		ir.setValue(address);
        //Transmit address to [MAR]
		MAR_textField.setText(Integer.toString(address));
		mar.setValue(address);
		
		int MAR1 = mar.getValue();
		LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
        //Get data from [Index Register] and put it to [MBR]
		int value = 0;
		switch (ix) {
		case 1:
			value = UI.ix[1].getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			break;
		case 2:
			value = UI.ix[2].getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			break;
		case 3:
			value = UI.ix[3].getValue();
			MBR_textField.setText(Integer.toString(value));
			mbr.setValue(value);
			break;

		default:
			break;
		}
        //Put data to the memory
		memory[address] = value;
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
			String ins = "";
			String reg = "";
			String ireg = "";
			String mem = "";
			String indirectAdd = "";
			int length = r.length();
			if(length <15) {
				ins = r.substring(0, 3);
				ireg = r.substring(4, 6);
				mem = r.substring(7, 12);
				indirectAdd = r.substring(13); 
			}else {
				ins = r.substring(0, 3);
				reg = r.substring(4, 6);
				ireg = r.substring(7, 9);
				mem = r.substring(10, 15);
				indirectAdd = r.substring(16);
			}
			
			if (ins.equals("LDR")) {
				ins = "000001";
			} else if (ins.equals("STR")) {
				ins = "000010";
			} else if (ins.equals("LDA")) {
				ins = "000011";
			} else if (ins.equals("LDX")) {
				ins = "101001";
			} else if (ins.equals("STX")){
				ins = "101010";
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
			
			if(ireg.equals("x1")) {
				ireg = "01";
			}else if(ireg.equals("x2")) {
				ireg = "10";
			}else if(ireg.equals("x3")) {
				ireg = "11";
			}
			
			if(length<15) {
				str = ins + ireg + mem + indirectAdd;
			}else {
				str = ins + reg + ireg + mem + indirectAdd;
			}
			
			int result = Integer.parseInt(str, 2);
			memory[pc] = result;
	}
}
