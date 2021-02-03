
public class Bank {
//SAAD ALAGEEL 441100902
//MONDAY 1-3
	private String[] names;
	private double[] balances;
	private int nClient;
	
	public Bank(){}
	
	public Bank(int size){
		nClient=0;
		names = new String[size];
		balances = new double[size];
	}
	
	public int findIndexByName(String name){
		
		for( int i = 0; i < names.length; i++)
		{
		    String element = names[i];

		    if(element.equals(name)){
		    	return i;
		    }
		}
		
		return -1;
	}
	
	public boolean addClient(String name,double balance){
		for (int i = 0; i < names.length; i++) {
			if(names[i]==null){
				names[i] = name;
				balances[i] =balance;
				return true;
			}
			if (names[i].equals(name)) {
				return false;
			}
		}
		return false;
	}
	
	public boolean deleteClient(String name){
		String[] copynames = new String[names.length];
		double[] copybalance = new double[names.length];
		boolean namefound=false;
		for (int i = 0, j = 0; i < names.length; i++) {
		    if (names[i]!=null && !names[i].equals(name)){
		        copynames[j] = names[i];
		        copybalance[j] = balances[i];
		    	j++;
		    }else if(names[i]!=null && names[i].equals(name)){
		    	namefound = true;
		    }
		}
		
		names = copynames;
		balances =copybalance;
		return namefound;
	}
	
	public boolean deposit(String name, double amount){
		for (int i = 0, j = 0; i < names.length; i++) {
			if(names[i]!=null && names[i].equals(name)){
				double newBalance = balances[i] + amount;
				System.out.println(names[i]+" was "+balances[i]+", now "+newBalance);
				balances[i] = newBalance;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean withdraw(String name, double amount){
		for (int i = 0, j = 0; i < names.length; i++) {

			if(names[i]!=null && names[i].equals(name)){
				if(balances[i] - amount >0){
					double newbalance = balances[i] - amount;
					System.out.println(names[i]+" was "+balances[i]+", now "+newbalance);
					balances[i] = newbalance;
					return true;
				}
			}
		}
		
		return false;
	}

	public boolean transfer(String fName,String tName,double amount){
		int fname=-1;
		int tname=-1;
		
		for (int i = 0, j = 0; i < names.length; i++) {

			if(names[i]!=null && names[i].equals(fName)){
				fname = i;
			}
			if(names[i]!=null && names[i].equals(tName)){
				tname = i;
			}
		}
		
		if(fname == -1 || tname == -1){
			return false;
		}
		
		double fNameBalance = balances[fname];
		double tNameBalance = balances[tname];
		
		if(fNameBalance-amount<0){
			System.out.println(fName+" was "+fNameBalance+", now "+balances[fname]);
			System.out.println(tName+" was "+tNameBalance+", now "+balances[tname]);
			return false;
		}
		
		balances[fname]=fNameBalance-amount;
		balances[tname]=tNameBalance+amount;


		return true;
	}
	
	public String findMax(){ 
        int i; 
        int maxI=0;  
        double max = balances[0]; 
       
        if(names.length ==0){
        	return null;
        }
        
        for (i = 1; i < balances.length; i++){
            if (balances[i] > max){ 
                max = balances[i];
                maxI = i;
            }
        }
        
        return names[maxI]+" "+balances[maxI]+" SR";
    } 
	
	public void display(String name){
		for (int i = 0, j = 0; i < names.length; i++) {
			if(names[i].equals(name)){
				System.out.println(names[i]+" "+balances[i]+" SR");
				return;
			}
		}
		System.out.println("Not found");
	}
	public boolean transferToBank(String f,Bank toBank,String t,double a){
		int fNameIndex=-1;
		int tNameIndex=-1;
		
		double[] toBankBalance = toBank.balances;
		String[] toBankNames = toBank.names;

		for(int i=0;i<toBankNames.length;i++){
			if(toBankNames[i].equals(t)){
				tNameIndex = i;
			}
		}
		
		for (int i = 0, j = 0; i < names.length; i++) {

			if(names[i]!=null && names[i].equals(f)){
				fNameIndex = i;
			}
		}
		
		if(fNameIndex == -1 || tNameIndex == -1){
			return false;
		}
		
		double fnamebalance = balances[fNameIndex];
		double tnamebalance = toBankBalance[tNameIndex];
		
		if(fnamebalance-a<0){
			return false;
		}
		
		balances[fNameIndex] = fnamebalance - a;
		toBankBalance[tNameIndex] = tnamebalance + a;
		
		System.out.println(f+" was "+fnamebalance+", now "+balances[fNameIndex]);
		System.out.println(t+" was "+tnamebalance+", now "+toBankBalance[tNameIndex]);

		return true;

	}
	
	

	
}
