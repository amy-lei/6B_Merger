/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;
    ArrayList<String> mergedData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
        //copy data
        mergedData = new ArrayList<String>();
        for(int i = 0; i < usersData.size(); i++){
            mergedData.add(usersData.get(i));
        }
        
          
    }


    /**
      Merge the sorted sub-lists and include the ignored items
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
        
        int endOfList0 = start1;
        int endOfList1 = nItems;
        
        for( int index = start0
            ; index < nItems
            ; index++
            ){  
                //#0
                if( start0 == endOfList0){
                    mergedData.set( index, usersData.get(start1));
                    // System.out.println("#0 start0: " 
                                        // + start0
                                        // + " start1: "
                                        // + start1
                                        // + " setting: " 
                                        // + mergedData);
                    start1++;
                        
                }
                //#1
                else if( start1 == endOfList1){
                    mergedData.set( index, usersData.get(start0));
                    // System.out.println("#1 start0: " 
                                        // + start0
                                        // + " start1: "
                                        // + start1
                                        // + " setting: " 
                                        // + mergedData);
                    start0++;
                }
                //#2
                else{ if( usersData.get(start0).compareTo(usersData.get(start1))<0){
                        mergedData.set( index, usersData.get(start0));
                    // System.out.println("#2 start0: " 
                                        // + start0
                                        // + " start1: "
                                        // + start1
                                        // + " setting: " 
                                        // + mergedData);
                        start0++;
                        }
                  //#3
                  else { mergedData.set(index, usersData.get(start1));
                    // System.out.println("#3 start0: " 
                                        // + start0
                                        // + " start1: "
                                        // + start1
                                        // + " setting: " 
                                        // + mergedData);
                             start1++;
                      }
                }
            }
        usersData = mergedData;
        
          
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}