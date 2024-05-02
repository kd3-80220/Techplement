package com.app.shivshankar.quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Quiz {
	
	public static int menu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.add question");
		System.out.println("2.take quiz");
		System.out.println("3.check score");
		System.out.println("0.Exit");
		int choice=sc.nextInt();
		return choice;
	}

	public static void main(String[] args) {
		ArrayList<Question> gkquestions=new ArrayList<Question>();
		HashMap<String,Integer> students=new HashMap<String,Integer>();
		int score=0;
		String name=null;
		Scanner sc=new Scanner(System.in);
		int noQuestions=0;
		int choice;
		while((choice = menu()) != 0)
		{
			switch(choice)
			{
			case 1: System.out.println("How many questions you want to add?");
					noQuestions=sc.nextInt();
					for(int i=0;i<noQuestions;i++)
					{
					Question q=new Question();
					q.addQuestion();
					gkquestions.add(q);
					}
					System.out.println("gkquestions.size(): "+gkquestions.size());
					
				break;
			case 2: System.out.println("Do you want to give quiz? (yes/no)");
					String chooseoption=sc.next();
					if(chooseoption.startsWith("y")) {
					System.out.println("Enter your name");
					name=sc.next();
					System.out.println("gkquestions.size(): "+gkquestions.size());
					for(int i=0;i<gkquestions.size();i++)
					{
					gkquestions.get(i).displayQuestion();
					System.out.println("Enter correct option");
					int ans=sc.nextInt();
					if(gkquestions.get(i).isCorrect(ans))
						score++;
					}
					students.put(name, score);
					}
				break;
			case 3:	for(Entry<String, Integer> entry:students.entrySet())
					System.out.println("Name: "+entry.getKey()+" Score: "+entry.getValue());
				break;
			default: System.out.println("You have entered wrong choice");
				break;
			}
		}
	}
}