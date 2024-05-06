package com.app.shivshankar.quiz;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//here class is created for main method
public class Quiz {
	
	//method menu is written here so that you call multiple times in application
	public static int menu()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add Question");
		System.out.println("2.Take Quiz");
		System.out.println("3.Check Score");
		System.out.println("4.See performance of all students");
		System.out.println("0.Exit");
		int choice=sc.nextInt();
		return choice;
	}

	public static void main(String[] args) throws SQLException {
		ArrayList<Question> gkquestions=new ArrayList<Question>();	//ArrayList used to store questions of quiz
		int score=0;
		int latestScore=0;
		QuizDao qd=new QuizDao();
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
					q.addQuestion();	//question added in ArrayList
					qd.addQuestion(q);	//Question added in database
					gkquestions.add(q);
					}
				break;
			case 2: System.out.println("Do you want to give quiz? (yes/no)");
					String chooseoption=sc.next();
					if(chooseoption.startsWith("y")) {	//if user enter string start with y then this method will work
					System.out.println("Enter your name");
					name=sc.next();
					
					ArrayList<Question> testQuestions=new ArrayList<Question>();
					testQuestions=qd.getTestQuestions();
					Collections.shuffle(testQuestions);
					System.out.println(testQuestions.size());
					for(int i=0;i<testQuestions.size();i++)
					{
						testQuestions.get(i).displayQuestion();
					System.out.println("Enter correct option");
					int ans=sc.nextInt();
					if(testQuestions.get(i).isCorrect(ans))
						score++;
					}
					qd.addScore(name, score);
					latestScore=score;
					score=0;
					}else {
						continue;
					}
				break;
			case 3:	System.out.println("Name: "+name+" Score: "+latestScore);
				break;
			case 4:	qd.seeAllStudentPerformance();
			break;
			default: System.out.println("You have entered wrong choice");
				break;
			}
		}
	}
}
