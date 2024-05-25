import java.text.DecimalFormat;

public class Customer
{
    private String custName;
    private String custId;
    private String custAddress;
    private String custPhone;
    private int clothesType;
    private int clothesVariation;
    private char clothesSize;
    private int paymentType;
    private int quantity;
    private String memberID;
    private String datePurchase;
    
    DecimalFormat df = new DecimalFormat("0.00");

    public Customer(){
     custName = null;
     custId = null;
     custAddress = null;
     custPhone = null;
     clothesType = 0;
     clothesVariation = 0;
     clothesSize = ' ';
     paymentType =  0;
     quantity = 0;
     memberID = null;
     datePurchase = null;
    }
    
    public Customer (String custName, String custId, String custAddress,String custPhone, int clothesType, int clothesVariation, char clothesSize, int paymentType, int quantity, String memberID,String datePurchase){
      this.custName = custName;
      this.custId = custId;
      this.custAddress = custAddress;
      this.custPhone = custPhone;
      this.clothesType = clothesType;
      this.clothesVariation = clothesVariation;
      this.clothesSize = clothesSize;
      this.paymentType = paymentType;
      this.quantity = quantity;
      this.memberID = memberID;
      this.datePurchase = datePurchase;
    }
    
    public void setCustName (String custName) {this.custName = custName;}
    public void setCustId (String custId) {this.custId = custId;}
    public void setCustAddress (String custAddress) {this.custAddress = custAddress;}
    public void setCustPhone (String custPhone) {this.custPhone = custPhone;}
    public void setClothesType (int clothesType) {this.clothesType  = clothesType;}
    public void setClothesVariation (int clothesVariation) {this.clothesVariation = clothesVariation;}
    public void setClothesSize (char clothesSize) {this.clothesSize = clothesSize;}
    public void setPaymentType (int paymentType) {this.paymentType = paymentType;}
    public void setQuantity (int quantity) {this.quantity = quantity;}
    public void setmemberID (String memberID) {this.memberID = memberID;}
    public void setDatePurchase (String datePurchase) {this.datePurchase = datePurchase;}
    
    public String getCustName() {return custName;}
    public String getCustId() {return custId;}
    public String getCustAddress() {return custAddress;}
    public String getCustPhone(){return custPhone;}
    public int getClothesType() {return clothesType;}
    public int getClothesVariation() {return clothesVariation;}
    public char getClothesSize() {return clothesSize;}
    public int getPaymentType() {return paymentType;}
    public int getQuantity() {return quantity;}
    public String getmemberID() {return memberID;}
    public String getPurchaseDate(){return datePurchase;}
    //clothes type text
    public String getClothesTypeText(){
        String text = null;
        if (clothesType == 1)
            text = "E-Sports Jersey";
        else if (clothesType == 2)
            text = "Short Sleeve Shirt";
        
        return text;
    }
    //clothes variation text
    public String getClothesVariationText(){
        String text = null;
        if(clothesType==1){
            if (clothesVariation == 1)
            text = "Todak X Next MLBB Special Collaboration 2023";
            else if(clothesVariation == 2)
            text = "Jersey Todak S12 Fan Edition White";
            else if(clothesVariation == 3)
            text = "Limited Baseball Jersey Todak Langgar"; 
        }
        if(clothesType==2){
            if (clothesVariation == 1)
            text = "Todak Classic Button Short Sleeve Black Edition";
            else if(clothesVariation == 2)
            text = "Loose Stripe Collar Shirt Todak Series I";
            else if(clothesVariation == 3)
            text = "Loose Revere Collar Shirt Todak Series II";
        }
        
        return text;
    }
    //payment method text
        public String getPaymentTypeText(){
        String text = null;
        
        if(paymentType == 1)
        text= "Cash on Delivery";
        else if(paymentType == 2)
        text = "Online Banking";
        else if(paymentType ==2)
        text = "E-Wallet";
        
        return text;
    }
    
    //member discount text
        public String getmemberIDText(){
        String text = null;
        if(memberID.length()==6){
            if(memberID.charAt(5)=='A')
            text = "10% Discount";
            else if(memberID.charAt(5)=='B')
            text = "20% Discount";
            else if(memberID.charAt(5)=='C')
            text = "30% Discount";
        }
        else if(memberID.length()==1)
            text = "No Discount";
        
        return text;
    }
    
    //date dictionary
    public String monthText(){
        String month = null;
        if(datePurchase.charAt(3) == '0'){
            if(datePurchase.charAt(4) == '1')
                month = "January";
            else if(datePurchase.charAt(4) == '2')
                month = "February";
            else if(datePurchase.charAt(4) == '3')
                month = "March";
            else if(datePurchase.charAt(4) == '4')
                month = "April";
            else if(datePurchase.charAt(4) == '5')
                month = "May";
            else if(datePurchase.charAt(4) == '6')
                month = "June";
            else if(datePurchase.charAt(4) == '7')
                month = "July";
            else if(datePurchase.charAt(4) == '8')
                month = "August";
            else if(datePurchase.charAt(4) == '9')
                month = "September";
            }
        else if (datePurchase.charAt(3) == '1'){
            if(datePurchase.charAt(4) == '0')
                month = "October";
            else if(datePurchase.charAt(4) == '1')
                month = "November";
            else if(datePurchase.charAt(4) == '2')
                month = "December";
        }
        return month;
    }
    
    //base price method
    public double basePrice(){
        double price = 0.00;
        if(clothesType==1)
            if(clothesVariation==1){
                if(clothesSize=='S')
                price = 99.00;
                else if(clothesSize=='M')
                price = 110.00;
                else if(clothesSize=='L')
                price = 120.00;
            }
            else if(clothesVariation==2){
                if(clothesSize=='S')
                price = 94.00;
                else if(clothesSize=='M')
                price = 100.00;
                else if(clothesSize=='L')
                price = 110.00;
            }
            else if(clothesVariation==3){
                if(clothesSize=='S')
                price = 164.00;
                else if(clothesSize=='M')
                price = 180.00;
                else if(clothesSize=='L')
                price = 190.00;
            }
        if(clothesType==2)
            if(clothesVariation==1){
                if(clothesSize=='S')
                price = 155.00;
                else if(clothesSize=='M')
                price = 165.00;
                else if(clothesSize=='L')
                price = 175.00;
            }
            else if(clothesVariation==2){
                if(clothesSize=='S')
                price = 148.00;
                else if(clothesSize=='M')
                price = 160.00;
                else if(clothesSize=='L')
                price = 180.00;
            }
            else if(clothesVariation==3){
                if(clothesSize=='S')
                price = 180.00;
                else if(clothesSize=='M')
                price = 190.00;
                else if(clothesSize=='L')
                price = 200.00;
            }
        return price;        
    }   
    

    //total price method
    public double price(){
        double price = 0.0;
        if(clothesType==1)
            if(clothesVariation==1){
                if(clothesSize=='S')
                price = 99.00*quantity;
                else if(clothesSize=='M')
                price = 110.00*quantity;
                else if(clothesSize=='L')
                price = 120.00*quantity;
            }
            else if(clothesVariation==2){
                if(clothesSize=='S')
                price = 94.00*quantity;
                else if(clothesSize=='M')
                price = 100.00*quantity;
                else if(clothesSize=='L')
                price = 110.00*quantity;
            }
            else if(clothesVariation==3){
                if(clothesSize=='S')
                price = 164.00*quantity;
                else if(clothesSize=='M')
                price = 180.00*quantity;
                else if(clothesSize=='L')
                price = 190.00*quantity;
            }
        if(clothesType==2)
            if(clothesVariation==1){
                if(clothesSize=='S')
                price = 155.00*quantity;
                else if(clothesSize=='M')
                price = 165.00*quantity;
                else if(clothesSize=='L')
                price = 175.00*quantity;
            }
            else if(clothesVariation==2){
                if(clothesSize=='S')
                price = 148.00*quantity;
                else if(clothesSize=='M')
                price = 160.00*quantity;
                else if(clothesSize=='L')
                price = 180.00*quantity;
            }
            else if(clothesVariation==3){
                if(clothesSize=='S')
                price = 180.00*quantity;
                else if(clothesSize=='M')
                price = 190.00*quantity;
                else if(clothesSize=='L')
                price = 200.00*quantity;
            }
        return price;
    }
    
    //after discount method
    public double aftermemberID(){
        double price = price();
        double total = 0.00;
        
        if(memberID.length()==6){
            if(memberID.charAt(5)=='A')
            total = price-(price*0.10);
            
            else if(memberID.charAt(5)=='B')
            total = price-(price*0.20);
            
            else if(memberID.charAt(5)=='C')
            total = price-(price*0.30);
        }
        else if(memberID.length()==1)
            total = price;
        
        return total;
    }
    
    //printing method 
    public String toString(){
        return("\nCustomer name\t\t\t: "+getCustName()+
              "\nCustomer IC\t\t\t: "+getCustId()+
              "\nCustomer Address\t\t: "+getCustAddress()+
              "\nCustomer Phone Number\t\t: "+getCustPhone()+
              "\nClothes Type\t\t\t: "+   getClothesTypeText()+
              "\nClothes Variation\t\t: "+getClothesVariationText()+
              "\nClothes Size\t\t\t: "+getClothesSize()+
              "\nPayment Type\t\t\t: "+getPaymentType()+
              "\nQuantity\t\t\t: "+getQuantity()+
              "\nmemberID Code\t\t\t: "+getmemberID()+
              "\nmemberID Value\t\t\t: "+getmemberIDText()+
              "\nDate Purchase\t\t\t: "+getPurchaseDate()+
              "\n============================================"+
              "\nBase Price\t\t\t: RM "+df.format(basePrice())+
              "\nTotal Price (Before memberID)\t: RM "+df.format(price())+
              "\nTOTAL PRICE\t\t\t: RM "+df.format(aftermemberID()));
    }

}
