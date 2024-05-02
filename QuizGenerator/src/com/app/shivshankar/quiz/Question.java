package com.app.shivshankar.quiz;

import java.util.ArrayList;
import java.util.Scanner;

//here Question class is created so that it can take questions and their options and and store correct option
public class Question {
	private String question;	//used to store question
	private ArrayList<String> options;	//used to store options
	private int correctOptionIndex;	//used to store correct option
	
	//parameterized constructor
	public Question(String que, ArrayList<String> optionList,int corrIndex) {
		this.question=que;
		this.options=optionList;
		this.correctOptionIndex=corrIndex;
	}
	//parameterless constructor
	public Question() {
		options=new ArrayList<String>();
	}
	//addQuestion: this method is used to add questions and options with correct options
	public void addQuestion()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter question:");
		question=sc.nextLine();
		for(int i=1;i<=4;i++)
		{
			System.out.print("Enter option "+i);
			options.add(sc.nextLine());
		}
		System.out.println("Enter correct option:");
		correctOptionIndex=sc.nextInt();
	}
	
	//this isCorrect method used to check your selected option and correct option are correct or not
	public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }

	//this displayQuestion method used to display questions one by one
    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " +options.get(i));
        }
    }
}
