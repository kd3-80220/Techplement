package com.app.shivshankar.quiz;

import java.util.ArrayList;
import java.util.Scanner;

//here Question class is created so that it can take questions and their options and and store correct option
public class Question {
	private String question;	//used to store question
	private ArrayList<String> options;	//used to store options
	private int correctOptionIndex;	//used to store correct option
	private String quizName;
	
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	//parameterized constructor
	public Question(String que, ArrayList<String> optionList,int corrIndex,String qn) {
		this.question=que;
		this.options=optionList;
		this.correctOptionIndex=corrIndex;
		this.quizName=qn;
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public ArrayList<String> getOptions() {
		return options;
	}
	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}
	public int getCorrectOptionIndex() {
		return correctOptionIndex;
	}
	public void setCorrectOptionIndex(int correctOptionIndex) {
		this.correctOptionIndex = correctOptionIndex;
	}
	@Override
	public String toString() {
		return "Question [question=" + question + ", options=" + options + ", correctOptionIndex=" + correctOptionIndex
				+ "]";
	}
    
    
}
