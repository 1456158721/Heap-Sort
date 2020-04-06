import java.util.ArrayList;

class Heap <E extends Comparable<E>> {
    private ArrayList<E> num = new ArrayList<>();

    ArrayList<E> getNum (){
        return num;
    }
    void add (E newObject){
        num.add( newObject );
        int currentIndex = num.size()-1;
        while (currentIndex > 0) {
            int parentIndex = ( currentIndex - 1 ) / 2;
            if (num.get( currentIndex ).compareTo( num.get( parentIndex ) ) > 0){
                E temp = num.get( currentIndex );
                num.set( currentIndex,num.get( parentIndex ) );
                num.set( parentIndex,temp );
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }
    E remove(){
        if (num.size() == 0){
            return null;
        }
        E removedObject = num.get( 0 );
        num.set( 0,num.get( num.size() - 1 ) );
        num.remove( num.size() - 1 );
        int currentIndex = 0;
        while (currentIndex < num.size()) {
            int leftChildIndex = 2 *currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if (leftChildIndex >= num.size()) {
                break;
            }
            int maxIndex = leftChildIndex;
            if (rightChildIndex < num.size()) {
                if (num.get( maxIndex ).compareTo( num.get( rightChildIndex ) ) < 0) {
                    maxIndex = rightChildIndex;
                }
            }
            if (num.get( currentIndex ).compareTo( num.get( maxIndex ) ) < 0) {
                E temp = num.get( maxIndex );
                num.set( maxIndex,num.get( currentIndex ) );
                num.set( currentIndex,temp );
                currentIndex = maxIndex;
            } else {
                break;
            }
        }
        return removedObject;
    }

}
