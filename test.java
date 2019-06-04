import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.*;

public class test {
	
	JFrame window;
	Container con;
	JPanel titlePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleLabel, cloutLabel, cloutLabelNumber, repectLabel, repectLabelNumber, cashLabel, cashLabelNumber;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 15);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int clout , respect, cash;
	String readiness , position, position2;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ActionListener choiceHandler = new ChoiceHandler();
	
	JTextField txtInput = new JTextField("");
	
	int difficulty;
	int count;
	int wrong;
	int correct;
	int yuh;
	int battleType = 0;



	public static void main(String[] args) {

		new test();
	}
	
	public test(){
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 100, 600, 150);
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel("AYT");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.white);
		startButton.setForeground(Color.black);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titlePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		con.add(titlePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen(){
		
		titlePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		
		mainTextArea = new JTextArea("AYT");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.black);
		choice1.setFont(buttonFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.black);
		choice2.setFont(buttonFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.black);
		choice3.setFont(buttonFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.black);
		choice4.setFont(buttonFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		cloutLabel = new JLabel("clout:");
		cloutLabel.setFont(normalFont);
		cloutLabel.setForeground(Color.white);
		playerPanel.add(cloutLabel);
		cloutLabelNumber = new JLabel();
		cloutLabelNumber.setFont(normalFont);
		cloutLabelNumber.setForeground(Color.white);
		playerPanel.add(cloutLabelNumber);
		repectLabel = new JLabel("repect:");
		repectLabel.setFont(normalFont);
		repectLabel.setForeground(Color.white);
		playerPanel.add(repectLabel);
		repectLabelNumber = new JLabel();
		repectLabelNumber.setFont(normalFont);
		repectLabelNumber.setForeground(Color.white);
		playerPanel.add(repectLabelNumber);
		cashLabel = new JLabel("cash:");
		cashLabel.setFont(normalFont);
		cashLabel.setForeground(Color.white);
		playerPanel.add(cashLabel);
		cashLabelNumber = new JLabel();
		cashLabelNumber.setFont(normalFont);
		cashLabelNumber.setForeground(Color.white);
		playerPanel.add(cashLabelNumber);

		playerSetup();

	}
	public void playerSetup(){
		clout  =  0;
		respect = 0;
		cash = 0;
		readiness  = "notready";
		cloutLabelNumber.setText("" + clout);
		repectLabelNumber.setText("" + respect);
		cashLabelNumber.setText("" + cash);	
		yuh();
	}
	public void yuh() {
		position = "yuh";
		mainTextArea.setText("Wacko Swami: Yo that right there is Symere. He’s the guy you want to talk to if you want to join Ayt Squad. He’s the manager and the lead rapper.\n" + 
				"You: Yo bet can you introduce us, I sent them a demo a couple days ago.\n" + 
				"Wacko Swami: Yooo Symere this my boy who can rap, he sent you that demo a couple days ago. \n" + "");
		try {
			ausdio a=new ausdio("Beginning(Sumeet).wav");
			a.play();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		choice1.setText("Continue");
		choice2.setText("Continue");
		choice3.setText("Continue");
		choice4.setText("Continue");
	}
	public void introduction(){
		position = "introduction";
		mainTextArea.setText("What’s good G? You the one who sent us that trash demo?");		
		choice1.setText("Na G, all my tracks are heat.");
		choice2.setText("Watchu mean dawg you tryna start sum?");
		choice3.setText("");
		choice4.setText("");
	}
	public void ifA(){
		position = "ifA";
		mainTextArea.setText("I was just playing dawg, I ain’t even check you out yet, play something smt for me.");
		choice1.setText("Ayt dawg lemme play a lil sum for you, I call it “Chutney”. This goes B.");
		choice2.setText("Yea I knew you wasn’t no stupid. Lemme play a lil sum I call “Chutney");
		choice3.setText("");
		choice4.setText("");
	}
	public void ifB(){
		position = "ifB";
		mainTextArea.setText("You buggin b, I ain’t even listen to it yet but On Moms it's prolly trash");
		choice1.setText("Watchu tryna say dawg? ayt squad? Who names themselves ayt squad my guy? You calling my stuff trash?");
		choice2.setText("Lemme prove you wrong real quick Symere. Lemme play this banger me and my boy Wacko Swami put together.");
		choice3.setText("");
		choice4.setText("");
	}
	public void ifAChoiceOne(){
		difficulty = 10;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "ifAChoiceOne";
		position2 = "ruckers";
		mainTextArea.setText("Symere: Yo this fire fam. You should come into the studio with us one day. ayt squad could use another member.\n" + 
				"You: Yea, I’ll hit the stu witchu tmrw. I’m tryna get some battle rap in right now though. You down?  \n" + 
				"Symere: No doubt, I’ll beat you.\n" + "");

		choice1.setText("Battle");
		choice2.setText("Battle");
		choice3.setText("Battle");
		choice4.setText("Quit");		
	}
	public void ifAChoiceTwo(){
		difficulty = 10;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "ifAChoiceTwo";
		position2 = "ruckers";
		mainTextArea.setText("Symere: Ima ignore that slight cause yo demo fire. You should hit the studio with us one day. \n" + 
				"You: Yo how about this, we battle right here and If I win you let me join ayt squad.\n" + 
				"Symere: Hahah you think you can beat ME? Bet\n" + "");
		
		try {
			ausdio a=new ausdio("");
			a.play();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		choice1.setText("Battle");
		choice2.setText("Battle");
		choice3.setText("Battle");
		choice4.setText("Quit");		
	}
	public void ifBChoiceOne(){
		difficulty = 10;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "ifBChoiceOne";
		position2 = "ruckers";
		mainTextArea.setText("Symere: Dawg get outta here. You tryna catch this fade huh I’ll bet a band right now that you can’t take me in a cypher. \n" + 
				"You: Bet let’s do it right here right now.\n" + 
				"Symere: Bet if you win I’ll even let you join Ayt Squad.\n" + "");
	
		try {
			ausdio a=new ausdio("");
			a.play();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		choice1.setText("Battle");
		choice2.setText("Battle");
		choice3.setText("Battle");
		choice4.setText("Quit");		
	}
	public void ifBChoiceTwo(){
		difficulty = 10;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "ifBChoiceTwo";
		position2 = "ruckers";
		mainTextArea.setText("Symere: Yo this is aight but idk how much of it is you and how much of it is ya boy.\n" + 
				"You: How about this, lemme just hit you with this freestyle real quick. One band  says I can out rap you. \n" + 
				"Symere: Hahah you think you can beat ME? Bet if you win I’ll even let you join Ayt Squad.\n" + "");
		
		try {
			ausdio a=new ausdio("");
			a.play();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		choice1.setText("Battle");
		choice2.setText("Battle");
		choice3.setText("Battle");
		choice4.setText("Quit");		
	}
	
	public void battle(){
			position = "battle";
			battleType = 1;
			String b=RhymeGame.getRandomWord();
			RhymeGame a=new RhymeGame(b);
			String console = b+ "\n Attempt: " + (count+1) + "\n # Correct: " + correct +"\n # Wrong: " + wrong;
			mainTextArea.setText(console);

			a.getArray();
			ArrayList rhymes=a.rhymes;
			
			Random rand=new Random();
			int rhymeNum=rand.nextInt(rhymes.size());
			String rhymingWord=(String)rhymes.get(rhymeNum);
			yuh=rand.nextInt(4)+1;

			if(yuh==1) {
				choice1.setText(rhymingWord);
		

			}
			else {
				choice1.setText(RhymeGame.getRandomWord());
			}
			if(yuh==2) {
				choice2.setText(rhymingWord);
		
			}
			else {
				choice2.setText(RhymeGame.getRandomWord());
			}
			if(yuh==3) {
				choice3.setText(rhymingWord);
			
			}
			else {
				choice3.setText(RhymeGame.getRandomWord());
			}
			if(yuh==4) {
				choice4.setText(rhymingWord);
				
			}
			else {
				choice4.setText(RhymeGame.getRandomWord());
			}
	}
	
	public void typeBattle(){
		mainTextArea.setText("Battle Stage");
		position = "typeBattle";
		battleType = 2;
		count = 0;
		wrong = 0;
		correct = 0;
		String input;
		while(count<(difficulty)) {
			String b=RhymeGame.getRandomWord();
			RhymeGame a=new RhymeGame(b);

			JOptionPane.showMessageDialog(null, b);
			a.getArray();
			ArrayList rhymes=a.rhymes;
			Random rand=new Random();
			int rhymeNum=rand.nextInt(rhymes.size());
			input = JOptionPane.showInputDialog("input");
			if(rhymes.contains(input.toLowerCase().replaceAll(" ","" ).replaceAll("'","").replaceAll("-", ""))) {
				correct++;
				count++;	
				JOptionPane.showMessageDialog(null, "Thats a rhyme! \n Attempts: " + count + "\n # Correct: " + correct +"\n # Wrong: " + wrong);	
			}
			else {
				wrong++;
				count++;
				JOptionPane.showMessageDialog(null, "Nope!" + "\nPossible rhyme to " + b + ": "+ (String)rhymes.get(rhymeNum) + "\n Attempts: " + count + "\n # Correct: " + correct +"\n # Wrong: " + wrong);
			
			}
	}
		if(correct>=wrong) {
			win();
		}
		else {
			lose();
		}	
}

	
	public void ruckers(){	
		difficulty = 10;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "ruckers";
		position2 = "ruckers";
		try {
			ausdio a=new ausdio("");
			a.play();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		mainTextArea.setText("The Next Day /nSymere: Dawg… you been for real killin’ it out there in the underground. \n" + 
				"Player: Word? I’m tryna keep it low key.\n" + 
				"Symere: Listen up fam. You got talent. You legit. \n" + 
				"Player: Shoot thanks bro, but what’s the deal with this?\n" + 
				"Symere: There’s this freestyle rap battle tournament coming up in a minute…\n" + 
				"Player (Interrupting): Naw fam… that’s not me you know I’m not about that.\n" + 
				"Symere: I think you’re up for it dawg. You our best rapper by a long shot. And I know you ain’t been doing too hot back at home. Your moms just lost her job so you need the money. The prize pot is 10 grand. That’s some life changing stuff and you know it.\n" + 
				"Player: ... aight. I’m down… I guess.\n" + 
				"Symere: That’s my dawg. Better start grinding. Show up to Rucker’s Park in a month. i’ll let you know the time soon. Until then practice and get better. Wacko knows a few people who can help you out.  \n" + 
				"Player: I appreciate it man.\n" + 
				"");	
		choice1.setText("Talk to Wacko");
		choice2.setText("Practice Battle");
		choice3.setText("Quit");
		choice4.setText("");
	}
	
	public void training(){
		difficulty = 15;
		count = 0;
		wrong = 0;
		correct = 0;
		position = "training";
		try {
			ausdio a=new ausdio("");
			a.play();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		mainTextArea.setText("You: Yo wacko, I heard you know some freestyle legends who can help me out. I’m tryna win this tournament at Ruckers coming up.\n" + 
				"Wacko: Yea man my pops and his homies done won that tourney back in the day. If you can beat them you can beat anyone.\n" + 
				"You: Yo can you introduce us? What’s your dads name?\n" + 
				"Wacko: His name?  Mc Juice.\n");	
		choice1.setText("Battle MC Juice");
		choice2.setText("Quit");
		choice3.setText("");
		choice4.setText("");
	}

	
	public void replayIntroduction(){
		position = "replayIntroduction";
		
		introduction();	
	}
public void quit(){
		position = "quit";
		
		mainTextArea.setText("See Ya");	
		System.exit(0);
	}
	public void win(){
		position = "win";
		count = 0;
		wrong = 0;
		correct = 0;
		mainTextArea.setText("YOU WON");	
		
		clout+=15; 
		cloutLabelNumber.setText(""+clout); 
		respect+=15; 
		repectLabelNumber.setText(""+respect); 
		cash+=15; 
		cashLabelNumber.setText(""+cash); 
			
		
		choice1.setText("Continue");
		choice2.setText("Replay Battle");
		choice3.setText("Quit");
		choice4.setText("");
		
	}
	public void lose(){
		position = "lose";
		count = 0;
		wrong = 0;
		correct = 0;
		clout-=15; 
		cloutLabelNumber.setText(""+clout); 
		respect-=15; 
		repectLabelNumber.setText(""+respect); 
		cash-=15; 
		cashLabelNumber.setText(""+cash); 
		
		mainTextArea.setText("YOU LOST . . .");
		
		choice1.setText("Replay Battle");
		choice2.setText("Replay Introduction");
		choice3.setText("Quit");
		choice4.setText("");
	}	
	public void continued(){
		position = position2;
	}	

	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "yuh":
				switch(yourChoice){
				case "c1": replayIntroduction(); 
				try {
					ausdio a=new ausdio("Symere (Intro).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c2": replayIntroduction(); 
				try {
					ausdio a=new ausdio("Symere (Intro).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c3": replayIntroduction(); 
				try {
					ausdio a=new ausdio("Symere (Intro).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c4": replayIntroduction(); 
				try {
					ausdio a=new ausdio("Symere (Intro).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
					}
				break;
			case "introduction":
				switch(yourChoice){
				case "c1": ifA(); 
				clout+=15; 
				cloutLabelNumber.setText(""+clout); 
				respect+=15; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (A).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				try {
					ausdio a=new ausdio("Symere(If A).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c2": ifB();
				clout-=5; 
				cloutLabelNumber.setText(""+clout); 
				respect-=5; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (B).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				}
				break;
			case "ifA":
				switch(yourChoice){
				case "c1": ifAChoiceOne(); 
				clout+=10; 
				cloutLabelNumber.setText(""+clout); 
				respect+=10; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (If A Option 1).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c2": ifAChoiceTwo();
				clout-=5; 
				cloutLabelNumber.setText(""+clout); 
				respect-=5; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (If A Option 2).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				}
				break;
			case "ifB":
				switch(yourChoice){
				case "c1": ifBChoiceOne(); 
				clout+=5; 
				cloutLabelNumber.setText(""+clout); 
				respect+=5; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (If B Option 1).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c2": ifBChoiceTwo();
				clout-=5; 
				cloutLabelNumber.setText(""+clout); 
				respect-=5; 
				repectLabelNumber.setText(""+respect); 
				cash+=0; 
				cashLabelNumber.setText(""+cash); 
				try {
					ausdio a=new ausdio("Sumeet (If B Option 2).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				}
				break;
			case "ifAChoiceOne":
				switch(yourChoice){
				case "c1": battle(); break;
				case "c2": battle(); break;
				case "c3": battle(); break;
				case "c4": quit(); break;
				}
				break;
			case "ifAChoiceTwo":
				switch(yourChoice){
				case "c1": battle(); break;
				case "c2": battle(); break;
				case "c3": battle(); break;
				case "c4": quit(); break;
				}
				break;
			case "ifBChoiceOne":
				switch(yourChoice){
				case "c1": battle(); break;
				case "c2": battle(); break;
				case "c3": battle(); break;
				case "c4": quit(); break;
				}
				break;
			case "ifBChoiceTwo":
				switch(yourChoice){
				case "c1": battle(); break;
				case "c2": battle(); break;
				case "c3": battle(); break;
				case "c4": quit(); break;
				}
				break;
			case "lose":
				switch(yourChoice){
				case "c1": 
					if(battleType==1) {
						battle();
					}
					if(battleType==2) {
						typeBattle();
					}
					break;
				case "c2": replayIntroduction(); break;
				case "c3": quit(); break;
				}
				break;
			case "win":
				switch(yourChoice){
				case "c1": continued(); break;
				case "c2": 
					if(battleType==1) {
						battle();
					}
					if(battleType==2) {
						typeBattle();
					}
					break;
				case "c3": quit(); break;
				}
				break;
			case "ruckers":
				switch(yourChoice){
				case "c1": training(); 
				try {
					ausdio a=new ausdio("Training Conversation(Sumeet).wav");
					a.play();
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case "c2": 
					if(battleType==1) {
						battle();
					}
					if(battleType==2) {
						typeBattle();
					}
					break;
				case "c3": quit(); break;
				}
				break;
			case "training":
				switch(yourChoice){
				case "c1": typeBattle(); break;
				case "c2": quit(); break;
				}
				break;
			case "battle":
				switch(yourChoice){
				case "c1": 
					if(count<(difficulty-1)) {					
						if(yuh==1) {
							correct++;
							count++;
							battle();
						}
						else{
							wrong++;
							count++;
							battle();
						}
						}
						else{
						if(correct>wrong){
							win();
						}
						else{
							lose();
						}
						}
						break;	 
				case "c2": 
					if(count<(difficulty-1)) {
						if(yuh==2) {
							correct++;
							count++;
							battle();
						}
						else{
							wrong++;
							count++;
							battle();
						}
						break;
						}
						else{
						if(correct>wrong){
							win();
						}
						else{
							lose();
						}
						break;
						}
				case "c3": 
					if(count<(difficulty-1)) {
						if(yuh==3) {
							correct++;
							count++;
							battle();
						}
						else{
							wrong++;
							count++;
							battle();
						}
						break;
						}
						else{
						if(correct>wrong){
							win();
						}
						else{
							lose();
						}
						break;
						}			
				case "c4": 
					if(count<(difficulty-1)) {
					if(yuh==4) {
						correct++;
						count++;
						battle();
					}
					else{
						wrong++;
						count++;
						battle();
					}
					break;
					}
					else{
					if(correct>wrong){
						win();
					}
					else{
						lose();
					}
					break;
					}
				}
				break;
			}
		}	
	}
	
}


