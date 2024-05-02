package com.app.shivshankar.quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Question {
	private String question;
	private ArrayList<String> options;
	private int correctOptionIndex;
	
	public Question(String que, ArrayList<String> optionList,int corrIndex) {
		this.question=que;
		this.options=optionList;
		this.correctOptionIndex=corrIndex;
	}
	public Question() {
		options=new ArrayList<String>();
	}
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
	
	public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}
