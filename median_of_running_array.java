import java.util.*;


public class Main {
    public double[] getMedians(int[] a)
    {
      PriorityQueue<Integer> min = new PriorityQueue<Integer>();
      PriorityQueue<Integer> max = new PriorityQueue<Integer>(new Comparator<Integer>(){
        	public int compare(Integer n1,Integer n2){
              return (((Integer)n2).compareTo((Integer)n1));
            }
      });
      double result[] = new double[a.length];
      for(int i=0;i<a.length;i++){
        	int size1 = min.size();
        	int size2 = max.size();
        	if(size1>0&&size2>0){
              if(a[i]<min.peek()&&a[i]<max.peek()){
                int num = max.poll();
                min.add(num);
                max.add(a[i]);
              }
              else
                min.add(a[i]);
            }
        	else
              min.add(a[i]);
        size1 = min.size();
        size2 = max.size();
        if(size1-size2>1){
          int num = min.poll();
          max.add(num);
        }
        size1 = min.size();
        size2 = max.size();
        if(size1-size2==1){
          result[i] = (min.peek());
        }
        else if(size1-size2==0){
          result[i] = ((double)(min.peek())+(double)(max.peek()))/(double)2;
        }
      }
      for(int i=0;i<a.length;i++)
        System.out.println(result[i]);
      return result;
    }
      public static void main(String []args)
    {
        Main obj = new Main();
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        int [] a = new int[num];
        
        for(int i=0; i<num;i++)
        {
            a[i] = sc.nextInt();
        }
        obj.getMedians(a);
        sc.close();
        
        
    }
}
