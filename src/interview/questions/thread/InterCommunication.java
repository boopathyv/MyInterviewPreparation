package interview.questions.thread;

public class InterCommunication {
	   public static void main(String[] args) {
	      Chats m = new Chats();
	      new T1Cons(m);
	      new T2Cons(m);
	   }
	}

	class Chats {
		   boolean flag = false;

		   public synchronized void Question(int msg) {
		      if (flag) {
		         try {
//		        	 System.out.println("t1 wait");
		            wait();
		         } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		      }
		      System.out.println(msg);
		      flag = true;
		      notify();
		   }

		   public synchronized void Answer(int msg) {
		      if (!flag) {
		         try {
//		        	 System.out.println("t2 wait");
		            wait();
		         } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		      }

		      System.out.println(msg);
		      flag = false;
		      notify();
		   }
		}

		class T1Cons implements Runnable {
		   Chats m;
		   String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

		   public T1Cons(Chats m1) {
		      this.m = m1;
		      new Thread(this, "Question").start();
		   }

		   public void run() {
		      for (int i = 1; i < 50; i=i+2) {
		         m.Question(i);
		      }
		      System.out.println("Questions loop Completed...");
		   }
		}

		class T2Cons implements Runnable {
		   Chats m;
		   String[] s2 = { "Hi", "I am good, what about you?", "Great!" };

		   public T2Cons(Chats m2) {
		      this.m = m2;
		      new Thread(this, "Answer").start();
		   }

		   public void run() {
		      for (int i = 2; i < 50; i=i+2) {
		         m.Answer(i);
		      }
		      System.out.println("Answers loop Completed...");
		   }
		}
		