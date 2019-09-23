/*
Every Vote Counts
by:Isabella Rolfe 09/22/19
 */
public class everyvotecounts {
    public static int CountCriticalVotes(int[] blocks, int blockIndex){
        //start everything at 0
        return count(blocks, blockIndex, 0, 0, 0);
    }

    public static int count(int [] blocks, int blockIndex, int currentindex, int numofa,int numofb){
        if(currentindex==blocks.length){
            if(numofb>numofa && numofa+blocks[blockIndex]>numofb){
                return 1;
            }
            else if(numofb<numofa&& numofb+blocks[blockIndex]>numofa){
                return 1;
            }
            else{
                return 0;
            }
        }
        //don't want to count block trying to check
        if(currentindex==blockIndex){
            return count(blocks,blockIndex,currentindex+1,numofa,numofb);
        }
        //have to account for both scenarios, votes going either way to a or b
        return count(blocks,blockIndex,currentindex+1,numofa+blocks[currentindex], numofb)+
                count(blocks,blockIndex,currentindex+1,numofa,numofb+blocks[currentindex]);
    }
    public static void main(String[] args) {
        int[] array={4,2,7,4};
        System.out.println(CountCriticalVotes(array,2));
    }

}
