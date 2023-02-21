package rapi;
//practicelang
public class Inventory {
    //initialize the default value.
	private String id = "ABC-1234";
	private String name = "New Item";
	private int qoh = 0;
	private int rop = 25;
	private double sellPrice = 0;
	
	public Inventory() {
		
	}
	
	public Inventory(String id, String name, double sellPrice) {
	this.id = id;
	this.name = name;
	this.sellPrice = sellPrice;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) throws IllegalArgumentException {
            
            if (id.matches("[a-zA-Z]{3}[-]{1}[0-9]{4}")){
		this.id = id;
            }
            else{
               throw new IllegalArgumentException("The value is invalid");
            }
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws IllegalArgumentException{
            
            if(name.equals("")){
                throw new IllegalArgumentException("You must enter an item name");
            }
		this.name = name;
	}
	
	public int getQoh() {
		return qoh;
	}
	
	public void setQoh(int qoh) throws IllegalArgumentException{
            if(qoh < 0){
                throw new IllegalArgumentException("You input negative number");
            }
            else{
		this.qoh = qoh;
            }
	}

	public int getRop() {
		return rop;
	}
	
	public void setRop(int rop) throws IllegalArgumentException {
            
            if(rop <= 0){
                throw new IllegalArgumentException("QOH must be 0 or more.");
            }
            else{
		this.rop = rop;
            }
	}
	
	public double getSellPrice() {
		return sellPrice;
	}
	
	public void setSellPrice(double price) throws IllegalArgumentException{
            
            if(price < 0){
                throw new IllegalArgumentException("Selling price must be greater than 0");
            }
            else{    
		this.sellPrice = price;
            }
	}
	@Override
	public String toString(){
		String result = String.format("%s (%s), QOH: %d Price: $%.2f \n", id,name,qoh,sellPrice);
		return result;
        }
}
