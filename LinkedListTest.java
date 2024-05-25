import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class LinkedListTest
{
        public static void main(String [] args)throws Exception{
        try{
            FileReader fr = new FileReader ("customer.txt");
            BufferedReader br = new BufferedReader (fr);
            DecimalFormat df = new DecimalFormat ("0.00");
            
            // Create an instance of MenuDisplay
            MenuDisplay menuDisplay = new MenuDisplay();
            
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            
            LinkedList CustomerList = new LinkedList();
            
            String indata = null;
            while((indata=br.readLine()) != null)
            {
                StringTokenizer st = new StringTokenizer(indata, ";");
                
                String custName = st.nextToken();
                String custId = st.nextToken();
                String custAddress = st.nextToken();
                String custPhone = st.nextToken();
                int clothesType = Integer.parseInt(st.nextToken());
                int clothesVariation = Integer.parseInt(st.nextToken());
                char clothesSize = st.nextToken().charAt(0);
                int paymentType = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                String memberID = st.nextToken();
                String purchaseDate = st.nextToken();
                
                Customer cust = new Customer(custName, custId, custAddress, custPhone, clothesType, clothesVariation, clothesSize, paymentType, quantity, memberID,purchaseDate);
                CustomerList.insertAtBack(cust);
            }
            br.close();
            //***************************************************************************
            //Display Menu
            menuDisplay.displayMenu();
            //initialize key for if else
            int key = sc.nextInt();
            int key1 = 1;
            
            
            while(key!=0){
                //[1] Display Customer Order
                if(key == 1){
                    System.out.print('\u000C');
                    Customer temp = (Customer)CustomerList.getFirst(); 
                    int count = 1;
                    while(temp!=null){
                        System.out.println("CUSTOMER #"+count);
                        System.out.println("===============================================================================");
                        System.out.println(temp.toString()+"\n\n");
                        count++;
                        temp = (Customer)CustomerList.getNext();
                    }
                    System.out.println("[11] Menu");
                    key = sc.nextInt();
                }
                
                //[2] Remove Customer Order
                if(key == 2){
                    System.out.print('\u000C');
                    Customer temp = (Customer)CustomerList.getFirst();
                    int count = 1;
                    System.out.println("=========================================================REMOVE CUSTOMER ORDER=======================================================");
                    while(temp!=null){
                        System.out.println("["+count+"] "+temp.getCustName());
                        count++;
                        temp = (Customer)CustomerList.getNext();
                    }
                    System.out.println("\n\nEnter the number from customer list: ");
                    int deleteIndex = sc.nextInt();
                    int deleteIndex2 = deleteIndex - 1;
                    //Delete Process
                    CustomerList.deleteAnyNode(deleteIndex2);
                    //print process after delete
                    temp = (Customer)CustomerList.getFirst();
                    int count2 = 1;
                    while(temp!=null){
                        System.out.println("["+count2+"] "+temp.getCustName());
                        count2++;
                        temp = (Customer)CustomerList.getNext();                    
                    }
                    System.out.println("\n\nYour deletion process is successful!");
                    System.out.println("[11] Menu");
                    key = sc.nextInt();
                    
                }
                
                //[3] Seach Customer by Name
                if(key==3){
                    System.out.print('\u000C');
                    System.out.println("=========================================================SEARCH FOR CUSTOMER BY NAME=======================================================");
                    System.out.println("Please insert the name: ");
                    String nameSearch = sc.next();
                    
                    //Casting
                    Customer searchObj = (Customer)CustomerList.getFirst();
                    Customer foundObj = null;
                    boolean found = false;
                    while(searchObj != null){
                        if(searchObj.getCustName().toLowerCase().contains(nameSearch.toLowerCase())){
                            found = true;
                            foundObj = searchObj;
                            break;
                        }
                        searchObj = (Customer)CustomerList.getNext();
                    }
                    
                    //Found/Not Found text output
                    if(found = true){
                        System.out.println(foundObj.toString());
                        System.out.println("\n\n Your name search process is succcesful!");
                    }
                    else{
                        System.out.println("\n\n Name is not registered in system!");
                    }
                    System.out.println("[11] Menu");
                    key = sc.nextInt();
                }
                //[4] Most Popular Items
                if(key==4){
                    System.out.print('\u000C');
                    Customer popularObj = (Customer)CustomerList.getFirst();
                    int[] popularCount = {0,0,0,0,0,0};
                    String[] popularItem = {"Todak X Next MLBB Special Collaboration 2023","Jersey Todak S12 Fan Edition White","Limited Baseball Jersey Todak Langgar",
                                            "Todak Classic Button Short Sleeve Black Edition","Loose Stripe Collar Shirt Todak Series I","Loose Revere Collar Shirt Todak Series II"};
                    //counting items
                    while(popularObj != null){
                        if(popularObj.getClothesType() == 1){
                            if(popularObj.getClothesVariation() == 1)
                                popularCount[0] += popularObj.getQuantity();
                            else if(popularObj.getClothesVariation() == 2)
                                popularCount[1] += popularObj.getQuantity();
                            else if(popularObj.getClothesVariation() == 3)
                                popularCount[2] += popularObj.getQuantity();
                        }
                        else if(popularObj.getClothesType() == 2){
                            if(popularObj.getClothesVariation() == 1)
                                popularCount[3] += popularObj.getQuantity();
                            else if(popularObj.getClothesVariation() == 2)
                                popularCount[4] += popularObj.getQuantity();
                            else if(popularObj.getClothesVariation() == 3)
                                popularCount[5] += popularObj.getQuantity();
                        }
                        popularObj = (Customer)CustomerList.getNext();
                    }
                    //sort from the popular items to less buy
                    int n =popularCount.length;
                    int tempCount = 0;
                    String tempText = null;
                    
                    for(int i = 0; i<n; i++){
                        for(int j = 1; i<(n-i); i++){
                            if(popularCount[j-1]>popularCount[j]){
                                //swap item count
                                tempCount = popularCount[j-1];
                                popularCount[j-1] = popularCount[j];
                                popularCount[j] = tempCount;
                                
                                //swap item text
                                tempText = popularItem[j-1];
                                popularItem[j-1] = popularItem[j];
                                popularItem[j] = tempText;
                            }
                        }
                    }    
                    System.out.println("=========================================================MOST POPULAR ITEM=======================================================");
                    System.out.println(String.format("%55s%30s","Item Name","Quantity Sold"));
                    System.out.println(String.format("%55s%30s","-----","-----------"));
                    System.out.println(String.format("%55s%30s",popularItem[5],popularCount[5]));
                    System.out.println(String.format("%55s%30s",popularItem[4],popularCount[4]));
                    System.out.println(String.format("%55s%30s",popularItem[3],popularCount[3]));
                    System.out.println(String.format("%55s%30s",popularItem[2],popularCount[2]));
                    System.out.println(String.format("%55s%30s",popularItem[1],popularCount[1]));
                    System.out.println(String.format("%55s%30s",popularItem[0],popularCount[0]));
                    
                    System.out.println("\n\n[11] Menu");
                    key = sc.nextInt();
                }
                
                //[5] Monthly Sale Report
                if(key==5){
                    System.out.print('\u000C');
                    Customer saleObj = (Customer)CustomerList.getFirst();
                    double[] MonthlySale = {0,0,0,0,0,0,0,0,0,0,0,0};
                    double totalSale = 0;
                    
                    //Monthly Sale Processing
                    while(saleObj != null){
                        if(saleObj.getPurchaseDate().charAt(3) == '0'){
                            if(saleObj.getPurchaseDate().charAt(4) == '1')
                                MonthlySale[0] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '2')
                                MonthlySale[1] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '3')
                                MonthlySale[2] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '4')
                                MonthlySale[3] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '5')
                                MonthlySale[4] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '6')
                                MonthlySale[5] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '7')
                                MonthlySale[6] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '8')
                                MonthlySale[7] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '9')
                                MonthlySale[8] += saleObj.price();
                            }
                        else if (saleObj.getPurchaseDate().charAt(3) == '1'){
                            if(saleObj.getPurchaseDate().charAt(4) == '0')
                                MonthlySale[9] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '1')
                                MonthlySale[10] += saleObj.price();
                            else if(saleObj.getPurchaseDate().charAt(4) == '2')
                                MonthlySale[11] += saleObj.price();
                        }
                        saleObj = (Customer)CustomerList.getNext();
                    }
                    //Calculate total sale
                    for(int i = 0; i<MonthlySale.length; i++){
                        totalSale+=MonthlySale[i];
                    }
                    System.out.println("=========================================================MONTHLY SALE REPORT=======================================================");
                    System.out.println(String.format("%55s%30s","MONTH","TOTAL SALE"));
                    System.out.println(String.format("%55s%30s","-----","-----------"));
                    System.out.println(String.format("%55s%30s","January","RM "+df.format(MonthlySale[0])));
                    System.out.println(String.format("%55s%30s","February","RM "+df.format(MonthlySale[1])));
                    System.out.println(String.format("%55s%30s","March","RM "+df.format(MonthlySale[2])));
                    System.out.println(String.format("%55s%30s","April","RM "+df.format(MonthlySale[3])));
                    System.out.println(String.format("%55s%30s","May","RM "+df.format(MonthlySale[4])));
                    System.out.println(String.format("%55s%30s","June","RM "+df.format(MonthlySale[5])));
                    System.out.println(String.format("%55s%30s","July","RM "+df.format(MonthlySale[6])));
                    System.out.println(String.format("%55s%30s","August","RM "+df.format(MonthlySale[7])));
                    System.out.println(String.format("%55s%30s","September","RM "+df.format(MonthlySale[8])));
                    System.out.println(String.format("%55s%30s","October","RM "+df.format(MonthlySale[9])));
                    System.out.println(String.format("%55s%30s","November","RM "+df.format(MonthlySale[10])));
                    System.out.println(String.format("%55s%30s","December","RM "+df.format(MonthlySale[11])));
                    System.out.println(String.format("%30s","--------------------------------------------------------------------------------------------------------------"));
                    System.out.println(String.format("%30s","ANNUAL TOTAL SALE: RM"+df.format(totalSale)));
                    
                    System.out.println("\n\n[11] Menu");
                    key = sc.nextInt();
                }
                
                if(key==6){
                    System.out.print('\u000C');
                    System.out.println("=========================================================UPDATE CUSTOMER ORDER=======================================================");
                    System.out.println("Are you sure to update customer order? [11] No [12] Yes");
                    key = sc.nextInt();
                    if(key==12){
                        System.out.print('\u000C');
                        System.out.println("=========================================================UPDATE CUSTOMER ORDER=======================================================");
                        System.out.println("\nNew Customer Name: ");
                        String newCustName = sc.next();
                        System.out.println("\nNew Customer IC: ");
                        String newID = sc.next();
                        System.out.println("\nNew Customer Address: ");
                        String newAddress = sc.next();
                        System.out.println("\nNew Customer Phone Number: ");
                        String newPhone = sc.next();
                        System.out.println("\n===============Clothes Type================");
                        System.out.println("[1] E-Sports Jersey");
                        System.out.println("[2] Short Sleeve Shirt");
                        int newClothesType = sc.nextInt();
                        System.out.println("\n===============Clothes Variation================");
                        if(newClothesType == 1){
                            System.out.println("[1] Todak X Next MLBB Special Collaboration 2023");
                            System.out.println("[2] Jersey Todak S12 Fan Edition White");
                            System.out.println("[3] Limited Baseball Jersey Todak Langgar");
                        }
                        else if(newClothesType == 2){
                            System.out.println("[1] Todak Classic Button Short Sleeve Black Edition");
                            System.out.println("[2] Loose Stripe Collar Shirt Todak Series I");
                            System.out.println("[3] Loose Revere Collar Shirt Todak Series II");
                        }
                        int newClothesVariation = sc.nextInt();
                        System.out.println("\nClothes Size [S] [M] [L]: ");
                        char newClothesSize = sc.next().charAt(0);
                        System.out.println("\n===============Payment Method================");
                        System.out.println("[1] Cash on Delivery");
                        System.out.println("[2] Online Banking");
                        System.out.println("[3] E-Wallet");
                        int newPaymentMethod = sc.nextInt();
                        System.out.println("\nClothes Quantity: ");
                        int newQuantity = sc.nextInt();
                        System.out.println("\nMember ID (6 Digits) Type '0' if not a member");
                        String newMemID = sc.next();
                        System.out.println("\nDate Purchase xx-xx-xxxx");
                        String newDatePurchase = sc.next();
                        //update new data
                        Customer cust = new Customer(newCustName,newID,newAddress,newPhone,newClothesType,newClothesVariation,newClothesSize,newPaymentMethod,newQuantity,newMemID,newDatePurchase);
                        CustomerList.insertAtBack(cust);
                        
                        System.out.println("\n\n\nData successfully updated! Please check the newest data in menu.");
                        System.out.println("[11] Menu");
                        key = sc.nextInt();
                    }
                }                
                if(key == 11){
                    System.out.print('\u000C');
                    menuDisplay.displayMenu();
                    key = sc.nextInt();
                } 
                }
            }
        
        catch(FileNotFoundException fnfe)
        {
            System.out.println(fnfe.getMessage());
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
