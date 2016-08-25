import java.util.Date;
import java.util.Arrays;

public class HygroSample implements HygroSampleInt{
	
	int length;									// Length of Vector
	Node first;									// First Node Element
	Node last;									// Last Node Element
	
	HygroSample(){								//Initialize empty Sample
		first=null;
		last=null;
		length=0;
	}

	
	public void add(Date day, double[] time, double[] temp, double[] humi, String[] dayState){
		Node node=new Node(day,time,temp,humi,dayState);	//create a new node with the vectors of time, temperature and relative humidity
		if(emptyQ()){								//Test if initial vector is empty and concatenate the vector v
			first=node;								//Attach node to first
			last=node;								//Attach node to last
			length++;								//Update length 
			return;
		} else {                          		//if the sample is not empty
		Node nodeaux=first;
		while(nodeaux.next!=null){
			nodeaux=nodeaux.next;         		//run all the sample
		}
		nodeaux.next=node;                		//attach the vector to the end of the sample
		last=node;
		length++;                         		//update the length of the sample
		return;
		}

		
	}

	public boolean emptyQ(){					//Test if vector is empty
		return length==0;
		}


	public int length(){						//Return length of vector
		return length;
	}

	public Node element(int i){					//Receives position and returns Sample Vector
		Node nodeaux=first;
		int n=1;
		while(n!=i && nodeaux!=null){
			nodeaux=nodeaux.next;
			n++;
		}
				return nodeaux;
	}


	public void join(HygroSample a){			//Join two samples
		Node nodeaux=last;
//		while(nodeaux.next!=null){              	//Run the first sample
//			nodeaux=nodeaux.next;
//		}
		int n=0;
		Node nodeaux2=a.first;
		while(n!=a.length-1){						// Add node by node the second sample to the first
			nodeaux.next=nodeaux2;
			nodeaux=nodeaux.next;
			nodeaux2=nodeaux2.next;
			n++;
			length++;									//update the length of the sample
		}
		return;
	}

	
	public void print(){							// Print every node	temperature				
		Node nodeaux=first;
		while(nodeaux!=null){
			System.out.println(Arrays.toString(nodeaux.temp));
			nodeaux=nodeaux.next;
		}
	}
	
public void printL(){								// Print last node temperature
	System.out.println(Arrays.toString(last.time));
	System.out.println(Arrays.toString(last.temp));
	System.out.println(this.length());

	}


	@Override
	public void feeda(Node n, double time, double temp, double humi, String state) {
		// TODO Auto-generated method stub
		double dt = 30./60; // minutes (change later for 05 minutes) - dot is required to be a double
		int i= (int) (time/dt);
		n.time[i]=time;
		n.temp[i]=temp;
		n.hum[i]=humi;
		n.state[i]=state;
		
	}

	public void feed(Node n, double time, double temp, double humi, String state) {
		// TODO Auto-generated method stub
		double dt = 5./60; // minutes (change later for 05 minutes) - dot is required to be a double
		int i= (int) (time/dt);
		n.time[i]=time;
		n.temp[i]=temp;
		n.hum[i]=humi;
		n.state[i]=state;
		
	}


		
	
}
